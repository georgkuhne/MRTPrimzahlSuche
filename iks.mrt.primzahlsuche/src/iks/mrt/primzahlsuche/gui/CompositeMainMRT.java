package iks.mrt.primzahlsuche.gui;

import iks.mrt.primzahlsuche.algorithm.MillerRabinPrimzahlTest;
import iks.mrt.primzahlsuche.persistence.PersistenceUtility;
import iks.mrt.primzahlsuche.persistence.PersistenceUtilityFile;

import java.math.BigInteger;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import sun.awt.HorizBagLayout;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboViewer;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class CompositeMainMRT extends Composite {
	private Text lastPrimeNr;
	private Text actualNr;
	BigInteger aktuelleZahl;
	BigInteger letztePrimzahl;
	private Button btnStart;
	boolean isRunning = false;
	RunThread runtrhread;

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 */
	public CompositeMainMRT(Composite parent, int style) {
		super(parent, style);
		setLayout(new FormLayout());
		Listener scrollBarListener1 = new Listener() {

			public void handleEvent(Event event) {
				Text t = (Text) event.widget;
				Rectangle r1 = t.getClientArea();
				Rectangle r2 = t.computeTrim(r1.x, r1.y, r1.width, r1.height);
				Point p = t.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
				t.getHorizontalBar().setVisible(r2.width <= p.x);
				// t.getVerticalBar().setVisible(r2.height <= p.y);
				if (event.type == SWT.Modify) {
					t.getParent().layout(true);
					t.showSelection();
				}
			}

		};
		Listener scrollBarListener2 = new Listener() {

			public void handleEvent(Event event) {
				Text t = (Text) event.widget;
				Rectangle r1 = t.getClientArea();
				Rectangle r2 = t.computeTrim(r1.x, r1.y, r1.width, r1.height);
				Point p = t.computeSize(SWT.DEFAULT, SWT.DEFAULT, true);
				t.getHorizontalBar().setVisible(r2.width <= p.x);
				// t.getVerticalBar().setVisible(r2.height <= p.y);
				if (event.type == SWT.Modify) {
					t.getParent().layout(true);
					t.showSelection();
				}
			}

		};

		btnStart = new Button(this, SWT.NONE);
		btnStart.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!isRunning)
					start();
				else
					stopp();
			}
		});
		FormData fd_btnNewButton = new FormData();
		fd_btnNewButton.bottom = new FormAttachment(100, -10);
		fd_btnNewButton.right = new FormAttachment(100, -22);
		fd_btnNewButton.left = new FormAttachment(0, 23);
		btnStart.setLayoutData(fd_btnNewButton);
		btnStart.setText("Start");

		Label lblLastFoundPrime = new Label(this, SWT.NONE);
		FormData fd_lblLastFoundPrime = new FormData();
		fd_lblLastFoundPrime.top = new FormAttachment(0, 10);
		fd_lblLastFoundPrime.left = new FormAttachment(0, 10);
		lblLastFoundPrime.setLayoutData(fd_lblLastFoundPrime);
		lblLastFoundPrime.setText("Letzte gefundene Primzahl");

		lastPrimeNr = new Text(this, SWT.BORDER | SWT.H_SCROLL);
		FormData fd_text = new FormData();
		fd_text.left = new FormAttachment(0, 10);
		fd_text.top = new FormAttachment(lblLastFoundPrime, 6);
		fd_text.right = new FormAttachment(100, -10);
		lastPrimeNr.setLayoutData(fd_text);
		lastPrimeNr.addListener(SWT.Resize, scrollBarListener1);
		lastPrimeNr.addListener(SWT.Modify, scrollBarListener1);

		Label lblZuUntersuchendeZahl = new Label(this, SWT.NONE);
		FormData fd_lblZuUntersuchendeZahl = new FormData();
		fd_lblZuUntersuchendeZahl.top = new FormAttachment(lastPrimeNr, 5);
		fd_lblZuUntersuchendeZahl.left = new FormAttachment(0, 10);
		lblZuUntersuchendeZahl.setLayoutData(fd_lblZuUntersuchendeZahl);
		lblZuUntersuchendeZahl.setText("zu untersuchende Zahl");

		actualNr = new Text(this, SWT.BORDER | SWT.H_SCROLL);
		FormData fd_text_1 = new FormData();
		fd_text_1.top = new FormAttachment(lblZuUntersuchendeZahl, 7);
		fd_text_1.left = new FormAttachment(0, 10);
		fd_text_1.right = new FormAttachment(100, -10);
		actualNr.setLayoutData(fd_text_1);

		
		
	
		actualNr.addListener(SWT.Resize, scrollBarListener2);
		actualNr.addListener(SWT.Modify, scrollBarListener2);
		init();

	}

	protected void stopp() {
		btnStart.setText("Start");
		runtrhread.setStopp(true);
		isRunning = false;

	}

	private void init() {
PersistenceUtilityFile.getINSTANCE().init();
	aktuelleZahl=	PersistenceUtilityFile.getINSTANCE().getLastPrime();
	lastPrimeNr.setText(aktuelleZahl.toString());
	actualNr.setText(aktuelleZahl.toString());
	}

	protected void start() {

		btnStart.setText("Stopp");
		runtrhread = new RunThread();
		runtrhread.start();
		isRunning = true;
	}

	public void loadZahlen() {

		letztePrimzahl = PersistenceUtility.getINSTANCE().getLastPrime();
		aktuelleZahl = PersistenceUtility.getINSTANCE().getActualNumber();
		lastPrimeNr.setText(letztePrimzahl.toString());
		actualNr.setText(aktuelleZahl.toString());
		int maxStellen = lastPrimeNr.getText().trim().length();
		String[] list=new String[maxStellen];
		for (int i = 1; i <= maxStellen; i++) {
			list[i-1]=""+i;
		}
	}

	public class RunThread extends Thread {

		boolean stopp = false;

		public void run() {

			while (!stopp) {
				aktuelleZahl =  aktuelleZahl.add(BigInteger.ONE);
				Display.getDefault().syncExec(new Runnable() {
		
										public void run() {
										actualNr.setText(aktuelleZahl.toString());
										}});
										
				MillerRabinPrimzahlTest test = new MillerRabinPrimzahlTest();
				if (test.miller_rabin(aktuelleZahl, 100)) {
					PersistenceUtilityFile.getINSTANCE().writePrime(aktuelleZahl);
					Display.getDefault().syncExec(new Runnable() {
						
						public void run() {
							lastPrimeNr.setText(aktuelleZahl.toString());
						}});
				}

			
			}
			}

		public void setStopp(boolean b) {
			stopp = b;
		}
	}
}
