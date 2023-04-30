package ej3;

public class Test {

	public static void main(String[] args) {
        // Crear arreglo con 2 objetos Estudiante
        Estudiante[] estudiantes = new Estudiante[2];
        estudiantes[0] = new Estudiante();
        estudiantes[0].setNombre("Juan");
        estudiantes[0].setApellido("Pérez");
        estudiantes[0].setComision(1);
        estudiantes[0].setEmail("juan.perez@gmail.com");
        estudiantes[0].setDireccion("Av. Siempreviva 123");

        estudiantes[1] = new Estudiante();
        estudiantes[1].setNombre("María");
        estudiantes[1].setApellido("González");
        estudiantes[1].setComision(2);
        estudiantes[1].setEmail("maria.gonzalez@gmail.com");
        estudiantes[1].setDireccion("Calle Falsa 123");

        // Crear arreglo con 3 objetos Profesor
        Profesor[] profesores = new Profesor[3];
        profesores[0] = new Profesor();
        profesores[0].setNombre("Pedro");
        profesores[0].setApellido("García");
        profesores[0].setEmail("pedro.garcia@universidad.edu.ar");
        profesores[0].setCatedra("Matemáticas");
        profesores[0].setFacultad("Ciencias Exactas");

        profesores[1] = new Profesor();
        profesores[1].setNombre("Ana");
        profesores[1].setApellido("López");
        profesores[1].setEmail("ana.lopez@universidad.edu.ar");
        profesores[1].setCatedra("Física");
        profesores[1].setFacultad("Ciencias Exactas");

        profesores[2] = new Profesor();
        profesores[2].setNombre("Jorge");
        profesores[2].setApellido("Gómez");
        profesores[2].setEmail("jorge.gomez@universidad.edu.ar");
        profesores[2].setCatedra("Química");
        profesores[2].setFacultad("Ciencias Exactas");

        // Recorrer arreglo de estudiantes e imprimir sus datos
        System.out.println("Estudiantes:");
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.tusDatos());
        }

        // Recorrer arreglo de profesores e imprimir sus datos
        System.out.println("\nProfesores:");
        for (Profesor profesor : profesores) {
            System.out.println(profesor.tusDatos());
        }
    }

}
