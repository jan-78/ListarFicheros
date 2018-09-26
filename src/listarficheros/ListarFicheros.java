/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listarficheros;

import java.io.File;
import java.io.IOException;

/**
 *
 * @author JBeltran
 */
public class ListarFicheros {

    public static void main(String[] args) {
        actividad1();
        actividad2();
        actividad3();
    }

    public static void actividad1() {

        String ruta = "c:\\";
        File directorio = new File(ruta);
        File[] archivos = directorio.listFiles();

        //Colores para la consola
        String azul = "\u001B[34m";
        String rojo = "\u001B[31m";
        String normal = "\u001B[0m";

        System.out.printf("Ficheros en el directorio %s: %d %n", ruta, archivos.length);

        for (File archivo : archivos) {
            System.out.printf("Nombre: " + azul + "%s" + normal
                    + ", es fichero?: " + rojo + "%b" + normal
                    + ", es directorio?: " + rojo + "%b" + normal + "%n",
                    archivo.getName(), archivo.isFile(), archivo.isDirectory());
        }
    }

    public static void actividad2() {

        File directorio = new File("NUEVODIR");
        directorio.mkdir();

        try {
            File fichero1 = new File(directorio, "fichero1.txt");
            boolean f1 = fichero1.createNewFile();
            System.out.println("Creado fichero " + fichero1.getName() + " " + f1);

            File fichero2 = new File(directorio, "fichero2.txt");
            boolean f2 = fichero2.createNewFile();
            System.out.println("Creado fichero " + fichero2.getName() + " " + f2);

            boolean renamef2 = fichero2.renameTo(new File(directorio, "nuevoFichero.txt"));
            System.out.println("Renombrado fichero " + fichero2.getName() + " " + renamef2);

        } catch (IOException ex) {
            System.err.println("Error al crear los ficheros.\n"
                    + ex.getLocalizedMessage());
        }

    }

    public static void actividad3() {
        File directorio = new File("NUEVODIR");
        System.out.println("El directorio debe estar vacio para poder eliminarlo");
        if (directorio.exists()) {
            System.out.println("Borrando contenido del directorio");
            File[] ficheros = directorio.listFiles();

            for (File fichero : ficheros) {
                fichero.delete();
            }
            boolean delete = directorio.delete();
            System.out.println("Directorio " + directorio.getPath()
                    + " borrado " + delete);
        } else {
            System.out.println("No existe el directorio");
        }

    }

}
