package ejercicio3;

public class Principal {

	public static void main(String[] args) {
		FaltasAlumnosEnAsignaturas faltas=new FaltasAlumnosEnAsignaturas();
		
		System.out.println(faltas);
		System.out.println(faltas.alumnoConMasFaltasInjustificadasPorAsignatura());
		System.out.println(faltas.alumnosConMasRetrasosALaMedia());
		System.out.println(faltas.asignaturaConMenosRetrasos());

	}

}
