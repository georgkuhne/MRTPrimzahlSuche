package iks.mrt.primzahlsuche.persistence;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class DialogDatabaseConfiguration extends Dialog {

	private Text text_userDBPath;
	private Button button_ChooseDirectory;
	private Table tDatabase;
	public int VALIDATE_BUTTONID = 999;

	public DialogDatabaseConfiguration(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = new Composite(parent, SWT.None);
		container.setLayout(new GridLayout(3, false));

		GridData gd = new GridData(GridData.FILL_HORIZONTAL);
		container.setLayoutData(gd);

		// descrition:
		gd = new GridData(SWT.FILL, SWT.FILL, true, false);
		gd.widthHint = 150;
		gd.horizontalSpan = 3;
		Label label_description = new Label(container, SWT.NONE | SWT.WRAP);
		label_description.setLayoutData(gd);
		label_description
				.setText("Choose one of the existing databases or create a new one by clicking on \"New Database\".");

		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalAlignment = SWT.RIGHT;
		gd.verticalAlignment = SWT.CENTER;
		gd.verticalIndent = 20;

		Label pathLabel = new Label(container, SWT.NONE);
		pathLabel.setLayoutData(gd);
		pathLabel.setText("path");

		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.verticalIndent = 20;

		text_userDBPath = new Text(container, SWT.BORDER);
		text_userDBPath.setLayoutData(gd);
		text_userDBPath.setEditable(false);

		String dbPath = DatabaseConfigurator.getInstance()
				.getDatabaseFolderPath();
		if (dbPath.equals("") || dbPath == null) { //$NON-NLS-1$
			dbPath = System.getProperty("user.home");
		} else {
			int index = dbPath.lastIndexOf(File.separator);
			if (index == -1) // if path from preferences is a network
								// address...
				dbPath = ""; //$NON-NLS-1$
			else
				dbPath = dbPath.substring(0, index);
		}
		text_userDBPath.setText(dbPath);

		gd = new GridData();
		gd.verticalIndent = 20;

		button_ChooseDirectory = new Button(container, SWT.PUSH);
		button_ChooseDirectory.setText("Browse");
		button_ChooseDirectory.setLayoutData(gd);
		button_ChooseDirectory.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String path = null;
				DirectoryDialog fd = new DirectoryDialog(Display.getCurrent()
						.getActiveShell(), SWT.OPEN);
				path = fd.open();
				if (path != null) {
					// path = HelperH2Embedded.getSubFolderPath(path);

					text_userDBPath.setText(path);

					refreshDatabaseList();
					update();

				}
			}

		});

		gd = new GridData();
		gd.horizontalAlignment = SWT.RIGHT;
		gd.verticalAlignment = SWT.TOP;

		final Label lDatabase = new Label(container, SWT.NONE);
		lDatabase.setLayoutData(gd);
		lDatabase.setText("Database:");

		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.widthHint = 301;
		gd.heightHint = 68;

		tDatabase = new Table(container, SWT.FULL_SELECTION | SWT.BORDER);
		tDatabase.setLayoutData(gd);
		tDatabase.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				widgetDefaultSelected(e);
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				update();
			}
		});

		TableColumn databaseColumn = new TableColumn(tDatabase, SWT.LEFT);
		databaseColumn.setText("Database Name");
		databaseColumn.setWidth(150);

		TableColumn statusColumn = new TableColumn(tDatabase, SWT.LEFT);
		statusColumn.setText("Status");
		statusColumn.setWidth(150);

		tDatabase.setHeaderVisible(true);

		gd = new GridData();
		gd.verticalAlignment = SWT.TOP;

		Composite buttonComp = new Composite(container, SWT.NONE);
		buttonComp.setLayout(new FillLayout(SWT.VERTICAL));
		buttonComp.setLayoutData(gd);

		Button createNewDb = new Button(buttonComp, SWT.PUSH);
		createNewDb.setText("New Database");
		createNewDb.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				String path = text_userDBPath.getText().trim();

				File worrkDir = new File(path);
				if (!worrkDir.exists()) {
					try {
						worrkDir.mkdirs();
					} catch (Exception e2) {
						MessageDialog.openError(Display.getCurrent()
								.getActiveShell(), "No Write Permissons",
								"No write permissons to create " + path);

						update();
						return;
					}
				}
				String tmpStamp = String.valueOf(System.currentTimeMillis() / 1000);
				File tmpFile = new File(worrkDir, tmpStamp + ".tmp"); //$NON-NLS-1$
				try {
					if (!tmpFile.createNewFile()) {
						MessageDialog.openError(Display.getCurrent()
								.getActiveShell(), "No Write Permissons",
								"No write permissons to that folder:" + path);

						update();
						return;
					}
					tmpFile.delete();
				} catch (IOException e1) {
					MessageDialog.openError(Display.getCurrent()
							.getActiveShell(), "No Write Permissons",
							"No Write Permissons to" + path);
					update();
					return;
				}
				TableItem[] databaseList = tDatabase.getItems();

				NewDatabaseDialog newDbDia = new NewDatabaseDialog(Display
						.getCurrent().getActiveShell(), databaseList);
				if (newDbDia.open() == NewDatabaseDialog.OK) {
					new File(
							path
									+ File.separator
									+ newDbDia.getNewDbName()
									+ Constants.PREFERENCESTORE_DATABASENAME_SUFFIX)
							.mkdirs();
					refreshDatabaseList();
					TableItem[] items = tDatabase.getItems();
					for (TableItem item : items) {
						if (item.getText().equals(newDbDia.getNewDbName()))
							tDatabase.setSelection(item);
					}

				}
			}

		});

		Button refreshButton = new Button(buttonComp, SWT.PUSH);
		refreshButton.setText("refresh");
		refreshButton.addSelectionListener(new SelectionListener() {

			public void widgetSelected(SelectionEvent e) {
				widgetDefaultSelected(e);
			}

			public void widgetDefaultSelected(SelectionEvent e) {
				refreshDatabaseList();
				update();
			}
		});

		refreshDatabaseList();

		return container;
	}

	protected void update() {
		getButton(IDialogConstants.OK_ID).setEnabled(false);

	}

	protected void validateInput() {
		if ((tDatabase != null)
				&& !(tDatabase.getSelection().length == 0)
				&& tDatabase.getEnabled()
				&& tDatabase.getSelection()[0].getForeground(1).equals(
						ColorConstants.darkGreen))
			getButton(IDialogConstants.OK_ID).setEnabled(true);

	}

	protected String getSubFolderPath(String trim) {
		// TODO Auto-generated method stub
		return null;
	}

	private void refreshDatabaseList() {

		String subfolder = text_userDBPath.getText().trim();
		String[] databaseList = new File(subfolder).list(new FilenameFilter() {

			public boolean accept(File dir, String name) {
				File testDir = new File(dir + File.separator + name);
				if (testDir.isDirectory())
					if (name.endsWith(Constants.PREFERENCESTORE_DATABASENAME_SUFFIX))
						return true;
				return false;
			}
		});

		if (databaseList != null && databaseList.length != 0) {
			tDatabase.removeAll();
			TableItem item;
			for (int i = 0; i < databaseList.length; i++) {
				int index = databaseList[i]
						.indexOf(Constants.PREFERENCESTORE_DATABASENAME_SUFFIX);
				databaseList[i] = databaseList[i].substring(0, index);

				item = new TableItem(tDatabase, SWT.NONE);
				item.setText(0, databaseList[i]);
				item.setText(1, ""); //$NON-NLS-1$
				checkDatabes(item);
			}

			tDatabase.select(0);
			tDatabase.setEnabled(true);
		} else {
			tDatabase.removeAll();
			TableItem item = new TableItem(tDatabase, SWT.NONE);
			item.setText(0, "No database found!");
			item.setText(1, ""); //$NON-NLS-1$
			tDatabase.setEnabled(false);
		}
	}

	private void checkDatabes(TableItem item) {
		String projectAddress = null;
		String subfolder = text_userDBPath.getText().trim();
		projectAddress = subfolder + File.separator + item.getText(0)
				+ Constants.PREFERENCESTORE_DATABASENAME_SUFFIX;

		File dbFile = new File(projectAddress);
		if (!dbFile.canWrite()) {
			item.setText(1, "not writable");
			item.setForeground(0, ColorConstants.gray);
			item.setForeground(1, ColorConstants.red);
			return;

		}

		switch (DatabaseConfigurator.getInstance().canConnectToDB(
				projectAddress)) {
		case DATABASE_CONNECTION_OK:
			item.setText(1, "OK");
			item.setForeground(0, ColorConstants.black);
			item.setForeground(1, ColorConstants.darkGreen);
			break;
		case DATABASE_ALREADY_OPEN:
			item.setText(1, "Allready Opened");
			item.setForeground(0, ColorConstants.gray);
			item.setForeground(1, ColorConstants.red);
			break;
		case DATABASE_NOT_FOUND:
			item.setText(1, "New");
			item.setForeground(0, ColorConstants.black);
			item.setForeground(1, ColorConstants.darkGreen);
			break;
		default:
			item.setText(1, "error");
			item.setForeground(0, ColorConstants.gray);
			item.setForeground(1, ColorConstants.red);
			break;
		}
	}

	// overriding this methods allows you to set the
	// title of the custom dialog
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("configure Database");
	}

	// @Override
	// protected Point getInitialSize() {
	// return new Point(640, 640);
	// }

	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, VALIDATE_BUTTONID, "VALIDATE", false);
		super.createButtonsForButtonBar(parent);
		getButton(IDialogConstants.OK_ID).setEnabled(false);
		getButton(VALIDATE_BUTTONID).addSelectionListener(
				new SelectionListener() {

					public void widgetSelected(SelectionEvent e) {
						validateInput();
					}

					public void widgetDefaultSelected(SelectionEvent e) {
						// TODO Auto-generated method stub

					}
				});

	}

	@Override
	protected void okPressed() {
		String path = text_userDBPath.getText().trim();
		path = path + File.separator + tDatabase.getSelection()[0].getText()
				+ Constants.PREFERENCESTORE_DATABASENAME_SUFFIX;
		DatabaseConfigurator.getInstance().persistDatabaseFolderPath(path);
		super.okPressed();
	}
}
