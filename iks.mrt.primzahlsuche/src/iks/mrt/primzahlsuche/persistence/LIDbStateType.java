package iks.mrt.primzahlsuche.persistence;


public enum LIDbStateType {
	SOME_DATABASE_ERROR(-1), DATABASE_CONNECTION_OK(0), DATABASE_NOT_FOUND(1), DATABASE_ALREADY_OPEN(
			2);

	private int code;

	private LIDbStateType(int c) {
		code = c;
	}

	public int getStateType() {
		return code;
	}
}
