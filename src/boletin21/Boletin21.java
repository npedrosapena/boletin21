/*
Crea un ficheiro chamado datosAlumnos.txt co nome (String), codigo (String) e 
nota (Integer), xenerar un ficheiro cos datos dos alumnos aprobados.

Consultar a nota dun alumno tomando como campo clave o código.

Engadir alumnos (ata que o seu código sexa '*')

 */

package boletin21;

/**
 *
 * @author nelson
 */
public class Boletin21
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        Alumno alu = new Alumno();
        
       // alu.crearAlumno();
        //alu.aprobados();
        alu.buscarAlumno();
    }
    
}
