import iks.mrt.primzahlsuche.gui.CompositeMainMRT;
import iks.mrt.primzahlsuche.persistence.PersistenceUtilityFile;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;


public class Main {
public static void main(String[] args) {
	Display display = new Display ();
	Shell shell = new Shell (display,SWT.DEFAULT);
	PersistenceUtilityFile.getINSTANCE().init();
	shell.setLayout(new FillLayout());
	new CompositeMainMRT(shell, SWT.None);
	shell.open();
	
	while (!shell.isDisposed ()) {
		if (!display.readAndDispatch ()) display.sleep ();
		
	
	}
	display.dispose ();
}
}
