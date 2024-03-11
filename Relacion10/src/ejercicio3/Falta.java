package ejercicio3;

public class Falta {
	private int justificadas;
	private int injustificadas;
	private int retrasos;

	public Falta(int justificadas, int injustificadas, int retrasos) throws FaltaException {

		setJustificadas(justificadas);
		setInjustificadas(injustificadas);
		setRetrasos(retrasos);
	}

	public int getJustificadas() {
		return justificadas;
	}

	public void setJustificadas(int justificadas) throws FaltaException {
		if (justificadas < 0) {
			throw new FaltaException("Error. Faltas incorrectas");
		}
		this.justificadas = justificadas;
	}

	public int getInjustificadas() {
		return injustificadas;
	}

	public void setInjustificadas(int injustificadas) throws FaltaException {
		if (injustificadas < 0) {
			throw new FaltaException("Error. Faltas incorrectas");
		}
		this.injustificadas = injustificadas;
	}

	public int getRetrasos() {
		return retrasos;
	}

	public void setRetrasos(int retrasos) throws FaltaException {
		if (retrasos < 0) {
			throw new FaltaException("Error. Retrasos incorrectas");
		}
		this.retrasos = retrasos;
	}

	@Override
	public String toString() {
		return "J" + justificadas + "I" + injustificadas + "R" + retrasos;
	}

}
