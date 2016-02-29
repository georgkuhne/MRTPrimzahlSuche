package iks.mrt.primzahlsuche.persistence;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;

import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class PersistenceUtilityFile {
	private static PersistenceUtilityFile INSTANCE = new PersistenceUtilityFile();
	private FileWriter writer;
	private FileReader reader;
	BigInteger lastfoundprimeNr;
	File file;

	public static PersistenceUtilityFile getINSTANCE() {
		return INSTANCE;
	}

	public void init() {
		DirectoryDialog dlg = new DirectoryDialog(new Shell(
				Display.getDefault()));

		dlg.setMessage("Select a directory");

		String dir = dlg.open();
		if (dir != null) {
			file = new File(dir + File.separator + "Primezahlen.txt");
			if (!file.exists()) {
				try {
					file.createNewFile();
					writer = new FileWriter(file, true);
					writer.write("2" + "\r\n");
					lastfoundprimeNr = new BigInteger("2");
					writer.flush();

				} catch (IOException e) {
					System.exit(0);
					e.printStackTrace();
				}
				// Set the text box to the new selection
			} else {
				lastfoundprimeNr = new BigInteger(tail(file));
				try {
					writer = new FileWriter(file, true);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}
	}

	public BigInteger getLastPrime() {
		return lastfoundprimeNr;
	}

	public void writePrime(BigInteger prime) {
		try {
			writer.write(prime.toString() + "\r\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String tail(File file) {
		RandomAccessFile fileHandler = null;
		try {
			fileHandler = new RandomAccessFile(file, "r");
			long fileLength = fileHandler.length() - 1;
			StringBuilder sb = new StringBuilder();

			for (long filePointer = fileLength; filePointer != -1; filePointer--) {
				fileHandler.seek(filePointer);
				int readByte = fileHandler.readByte();

				if (readByte == 0xA) {
					if (filePointer == fileLength) {
						continue;
					}
					break;

				} else if (readByte == 0xD) {
					if (filePointer == fileLength - 1) {
						continue;
					}
					break;
				}

				sb.append((char) readByte);
			}

			String lastLine = sb.reverse().toString();
			return lastLine;
		} catch (java.io.FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (java.io.IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			if (fileHandler != null)
				try {
					fileHandler.close();
				} catch (IOException e) {
					/* ignore */
				}
		}
	}
}
