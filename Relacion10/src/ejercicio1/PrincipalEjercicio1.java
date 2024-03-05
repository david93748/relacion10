package ejercicio1;

import java.util.Random;
import java.util.Scanner;

public class PrincipalEjercicio1 {
	public static final int NUMERO_ALUMNOS = 8;
	public static final int NOTA_LIMITE_APROBADO = 5;
	public static final int NOTA_MAXIMA = 10;
	public static final String[] ASIGNATURAS = { "PROGRAMACION", "BASE DE DATOS", "LENGUAJES DE MARCA" };
	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		int matrizNotas[][] = new int[NUMERO_ALUMNOS][ASIGNATURAS.length];
		String asignatura;

		cargarNotasMatriz(matrizNotas);

		imprimirNotas(matrizNotas);

		numeroDeSuspensosPorAlumno(matrizNotas);

		System.out.println("Introduce asignatura:");
		asignatura = teclado.nextLine();

		System.out.println(notaMediaDeAsignatura(matrizNotas, asignatura));
		
		notaMediaPorAsignatura(matrizNotas);
		
		estadisticaAlumnosPorSuspensos(matrizNotas);

	}

	/**
	 * Carga los datos de la matriz con notas aleatorias entre 0 y 10
	 * 
	 * @param matrizNotas
	 */
	private static void cargarNotasMatriz(int matrizNotas[][]) {
		int indiceAlumno, indiceAsignatura;

		Random serie = new Random();
		for (indiceAlumno = 0; indiceAlumno < matrizNotas.length; indiceAlumno++) {

			for (indiceAsignatura = 0; indiceAsignatura < matrizNotas[0].length; indiceAsignatura++) {

				matrizNotas[indiceAlumno][indiceAsignatura] = serie.nextInt(NOTA_MAXIMA + 1); // DE
																								// 0
																								// A
																								// NOTA_MAXIMA
			}
		}
	}

	/**
	 * Imprime las notas por pantalla
	 * 
	 * @param matrizNotas
	 */
	private static void imprimirNotas(int matrizNotas[][]) {
		int indiceAlumno, indiceAsignatura;

		for (int i = 0; i < ASIGNATURAS.length; i++) {
			System.out.print("\t" + ASIGNATURAS[i]);
		}

		System.out.println();
		for (indiceAlumno = 0; indiceAlumno < matrizNotas.length; indiceAlumno++) {
			System.out.print("Alumno " + (indiceAlumno + 1) + "    ");
			for (indiceAsignatura = 0; indiceAsignatura < matrizNotas[0].length; indiceAsignatura++) {
				System.out.print(matrizNotas[indiceAlumno][indiceAsignatura]);
				System.out.print("\t\t");
			}
			System.out.println();
		}

	}

	/**
	 * Realiza un listado donde aparezca para cada alumno cuantos suspensos tiene
	 */
	private static void numeroDeSuspensosPorAlumno(int matrizNotas[][]) {
		int[] suspensosAlumno = new int[matrizNotas.length];

		for (int i = 0; i < matrizNotas.length; i++) {
			for (int j = 0; j < matrizNotas[0].length; j++) {
				if (matrizNotas[i][j] < NOTA_LIMITE_APROBADO) {
					suspensosAlumno[i]++;
				}
			}
		}

		System.out.println("\tNUMERO SUSPENSOS POR ALUMNO");

		for (int i = 0; i < suspensosAlumno.length; i++) {
			System.out.println("Alumno " + (i + 1) + ": " + suspensosAlumno[i]);
		}

	}

	private static double notaMediaDeAsignatura(int matrizNotas[][], String asignatura) {
		double notaMedia = -1;
		int indiceAsignatura = 0;
		boolean asignaturaEncontrada = false;

		asignatura = asignatura.toUpperCase();

		for (int i = 0; i < ASIGNATURAS.length && asignaturaEncontrada == false; i++) {
			if (ASIGNATURAS[i].equals(asignatura)) {
				indiceAsignatura = i;
				asignaturaEncontrada = true;
			}
		}

		if (asignaturaEncontrada == true) {
			notaMedia = 0;
			for (int i = 0; i < matrizNotas.length; i++) {
				notaMedia = notaMedia + matrizNotas[i][indiceAsignatura];
			}
			notaMedia = notaMedia / matrizNotas.length;
		}

		return notaMedia;
	}

	private static void notaMediaPorAsignatura(int matrizNotas[][]) {
		double notasMedia[]=new double[matrizNotas[0].length];
		
		for (int j = 0; j < matrizNotas[0].length; j++) {
			for (int i = 0; i < matrizNotas.length; i++) {
				notasMedia[j]=notasMedia[j]+matrizNotas[i][j];
				
			}
			notasMedia[j]=notasMedia[j]/matrizNotas.length;
		}
		
		System.out.println("\tNOTA MEDIA POR ASIGNATURA");
		for (int i = 0; i < ASIGNATURAS.length; i++) {
			System.out.print(ASIGNATURAS[i]+"\t");
		}
		System.out.println();
		for (int i = 0; i < notasMedia.length; i++) {
			System.out.print(notasMedia[i]+"\t\t");
		}
		System.out.println();

	}

	/*
	 * Alumnos con 0 suspensos: X Alumnos con 1 suspensos: X etc.
	 */
	private static void estadisticaAlumnosPorSuspensos(int[][] matrizNotas) {
		int[] cantidadSuspensos=new int[matrizNotas[0].length+1];
		int suspensosAlumno;
		
		for (int i = 0; i < matrizNotas.length; i++) {
			suspensosAlumno=0;
			for (int j = 0; j < matrizNotas[0].length; j++) {
				if(matrizNotas[i][j]<NOTA_LIMITE_APROBADO) {
					
					suspensosAlumno++;
				}
			}
			cantidadSuspensos[suspensosAlumno]++;
		}
		for (int i = 0; i < cantidadSuspensos.length; i++) {
			System.out.println("Alumnos con "+i+" suspensos: "+cantidadSuspensos[i]);
		}
	}

}
