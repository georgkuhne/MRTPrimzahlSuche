package iks.mrt.primzahlsuche.persistence;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class NewDatabaseDialog extends MessageDialog {
	private String sDbName;
	private TableItem[] presentDatabasList;
	private Label lNewDbInfo;
	private Text tNewDbName;

	private NewDatabaseDialog(Shell parentShell, String dialogTitle,
			Image dialogTitleImage, String dialogMessage, int dialogImageType,
			String[] dialogButtonLabels, int defaultIndex) {
		super(parentShell, dialogTitle, dialogTitleImage, dialogMessage,
				dialogImageType, dialogButtonLabels, defaultIndex);

	}

	public NewDatabaseDialog(Shell parentShell, TableItem[] presentDatabasList) {
		this(parentShell, "Create Database", null, "Create Database", 0,
				new String[] { IDialogConstants.OK_LABEL,
						IDialogConstants.CANCEL_LABEL }, 0);
		this.presentDatabasList = presentDatabasList;
	}

	public String getNewDbName() {
		return sDbName;
	}

	@Override
	protected void buttonPressed(int buttonId) {
		sDbName = tNewDbName.getText();
		super.buttonPressed(buttonId);
	}

	@Override
	public void create() {
		super.create();
		checkDatabaseName();
	}

	@Override
	protected Control createCustomArea(Composite parent) {
		parent.setLayout(new GridLayout(2, false));

		GridData gd = new GridData();

		Label lNewDbName = new Label(parent, SWT.NONE);
		lNewDbName.setText("Database Name");
		lNewDbName.setLayoutData(gd);

		gd = new GridData(GridData.FILL_HORIZONTAL);

		tNewDbName = new Text(parent, SWT.BORDER);
		tNewDbName.setLayoutData(gd);
		tNewDbName.addModifyListener(new ModifyListener() {

			public void modifyText(ModifyEvent e) {
				checkDatabaseName();
			}
		});

		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.horizontalSpan = 2;

		lNewDbInfo = new Label(parent, SWT.NONE);
		lNewDbInfo.setForeground(ColorConstants.red);
		lNewDbInfo.setLayoutData(gd);

		return super.createCustomArea(parent);
	}

	private void checkDatabaseName() {
		String sNewDbName = tNewDbName.getText();
		char[] schemaName = sNewDbName.toCharArray();
		for (char tmpChar : schemaName) {
			if (!((('0' <= tmpChar) && (tmpChar <= '9'))
					|| (('A' <= tmpChar) && (tmpChar <= 'Z'))
					|| (('a' <= tmpChar) && (tmpChar <= 'z')) || (tmpChar == ' '))) {
				lNewDbInfo.setText("Allowed characters: 0-9 a-z A-Z");
				lNewDbInfo.pack();
				getButton(OK).setEnabled(false);
				return;
			}
		}

		if (sNewDbName.length() == 0) {
			lNewDbInfo
					.setText("The Database name must not be empty! Choose a database name.");
			lNewDbInfo.pack();
			getButton(OK).setEnabled(false);
			return;
		} else if (sNewDbName.startsWith(" ")) { //$NON-NLS-1$
			lNewDbInfo
					.setText("The Database name must not be empty! Choose a database name.");
			lNewDbInfo.pack();
			getButton(OK).setEnabled(false);
			return;
		}

		for (TableItem sDbName : presentDatabasList) {
			if (sNewDbName.equals(sDbName.getText())) {
				lNewDbInfo
						.setText("Database already exists! Choose another database name.");
				lNewDbInfo.pack();
				getButton(OK).setEnabled(false);
				return;
			}
		}
		lNewDbInfo.setText(""); //$NON-NLS-1$
		lNewDbInfo.pack();
		getButton(OK).setEnabled(true);
	}
}
