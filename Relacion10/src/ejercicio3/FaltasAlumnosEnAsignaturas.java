package ejercicio3;

import java.util.Random;

public class FaltasAlumnosEnAsignaturas {

	private static final int NUMERO_ALUMNOS = 10;
	private static final int NUMERO_ASIGNATURAS = 4;

	private String[] asignaturas = { "PROG", "LM", "BD", "ED" };
	private Falta[][] matrizFaltas;

	public FaltasAlumnosEnAsignaturas() {
		matrizFaltas = new Falta[NUMERO_ALUMNOS][NUMERO_ASIGNATURAS];

		cargarConDatosAleatorios();
	}

	public String alumnoConMasFaltasInjustificadasPorAsignatura() {
		StringBuilder sb = new StringBuilder();
		int maximofaltas = -1;
		int alumnoMasFaltas = -1;

		for (int contadorAsignaturas = 0; contadorAsignaturas < matrizFaltas[0].length; contadorAsignaturas++) {
			maximofaltas=-1;
			for (int contadorAlumnos = 0; contadorAlumnos < matrizFaltas.length; contadorAlumnos++) {
				if(matrizFaltas[contadorAlumnos][contadorAsignaturas].getInjustificadas()>maximofaltas) {
					maximofaltas=matrizFaltas[contadorAlumnos][contadorAsignaturas].getInjustificadas();
					alumnoMasFaltas=contadorAlumnos+1;
				}
			}
			sb.append(asignaturas[contadorAsignaturas]+"-> Alumno con mas faltas injustificadas "+alumnoMasFaltas+" con "+maximofaltas+"\n");
		}
		return sb.toString();
	}
	
	public String alumnosConMasRetrasosALaMedia() {
		StringBuilder sb = new StringBuilder();
		double mediaTotalRetrasos=0;
		int totalRetrasosAlumno=0;
		
		for (int contadorAsignaturas = 0; contadorAsignaturas < matrizFaltas[0].length; contadorAsignaturas++) {
			for (int contadorAlumnos = 0; contadorAlumnos < matrizFaltas.length; contadorAlumnos++) {
				mediaTotalRetrasos=mediaTotalRetrasos+matrizFaltas[contadorAlumnos][contadorAsignaturas].getRetrasos();
			}
		}
		
		mediaTotalRetrasos=mediaTotalRetrasos/matrizFaltas.length;
		
		sb.append("La media de retrasos es "+mediaTotalRetrasos+"\n");

		
		for (int contadorAlumnos = 0; contadorAlumnos < matrizFaltas.length; contadorAlumnos++) {
			totalRetrasosAlumno=0;
			for (int contadorAsignaturas = 0; contadorAsignaturas < matrizFaltas[0].length; contadorAsignaturas++) {
				totalRetrasosAlumno=totalRetrasosAlumno+matrizFaltas[contadorAlumnos][contadorAsignaturas].getRetrasos();
			}
			if(totalRetrasosAlumno>mediaTotalRetrasos) {
				sb.append("El alumno "+(contadorAlumnos+1)+" tiene "+totalRetrasosAlumno+" retrasos\n");
			}
		}
		
		
		
		return sb.toString();
	}
	
	public String asignaturaConMenosRetrasos() {
		int totalRetrasosAsignatura=0;
		int minimoRetrasos= Integer.MAX_VALUE;
		String asignaturaMenosRetrasos = null;
		
		for (int contadorAsignaturas = 0; contadorAsignaturas < matrizFaltas[0].length; contadorAsignaturas++) {
			totalRetrasosAsignatura=0;
			for (int contadorAlumnos = 0; contadorAlumnos < matrizFaltas.length; contadorAlumnos++) {
				totalRetrasosAsignatura=totalRetrasosAsignatura+matrizFaltas[contadorAlumnos][contadorAsignaturas].getRetrasos();
			}
			if(totalRetrasosAsignatura<minimoRetrasos) {
				minimoRetrasos=totalRetrasosAsignatura;
				asignaturaMenosRetrasos=asignaturas[contadorAsignaturas];
			}
		}
		
		return "La asignatura con menos retrasos es "+asignaturaMenosRetrasos+" con "+minimoRetrasos+" retrasos";
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (int numeroAlumno = 0; numeroAlumno < matrizFaltas.length; numeroAlumno++) {

			for (int numeroAsig = 0; numeroAsig < matrizFaltas[0].length; numeroAsig++) {
				sb.append(matrizFaltas[numeroAlumno][numeroAsig] + "\t");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

	private void cargarConDatosAleatorios() {

		Random serie = new Random();
		Falta falta;

		for (int numeroAlumno = 0; numeroAlumno < matrizFaltas.length; numeroAlumno++) {

			for (int numeroAsig = 0; numeroAsig < matrizFaltas[0].length; numeroAsig++) {

				try {
					falta = new Falta(serie.nextInt(10), serie.nextInt(10), serie.nextInt(10));
					matrizFaltas[numeroAlumno][numeroAsig] = falta;

				} catch (FaltaException e) {
					// Este error no va a producirse
					System.out.println(e.getMessage());
				}

			}
		}

	}

}
