/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boletin21;

import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 *
 * @author nelson
 */
public class Alumno
{
    //declaración variables
    private String nombre;
    private String codigo;
    private Integer nota;
    
    public final Integer APROBADO=5;//limite de nota aprobado
    private final String ARCHIVO="alumnos.ndt";//nombre del archivo
    private File infoAlumnos= new File(ARCHIVO);//creación del archivo
    
    public ArrayList <Alumno> listaAlumnos = new ArrayList<>();
    
    //constructores
    public Alumno(){}   
    public Alumno(String nombre, String codigo, Integer nota)
    {
        this.nombre=nombre;
        this.codigo=codigo;
        this.nota=nota;
    }
    
    //metodos set

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo)
    {
        this.codigo = codigo;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(Integer nota)
    {
        this.nota = nota;
    }
    
    //metodos get

    /**
     * @return the alumno
     */
    public String getNombre()
    {
        return nombre;
    }

    /**
     * @return the codigo
     */
    public String getCodigo()
    {
        return codigo;
    }

    /**
     * @return the nota
     */
    public Integer getNota()
    {
        return nota;
    }
    
    //sobreescribimos el método toString
    @Override
    public String toString()
    {
        return (this.getNombre()+","+this.getCodigo()+","+this.getNota());
    }
    
    /**
     * crea un alumno 
     */
    public void crearAlumno()
    {
        String nombreAlumno,codigoAlumno;
        Integer notaAlumno;
        do
        {
            nombreAlumno=JOptionPane.showInputDialog(null, "Introduzca el nombre del alumno", "Información", JOptionPane.INFORMATION_MESSAGE);
            codigoAlumno=JOptionPane.showInputDialog(null, "Introduzca el código del alumno", "Información", JOptionPane.INFORMATION_MESSAGE);
            notaAlumno=Integer.parseInt(JOptionPane.showInputDialog(null, "Introduzca la nota del alumno", "Información", JOptionPane.INFORMATION_MESSAGE));
            
            Alumno alumn=new Alumno(nombreAlumno,codigoAlumno,notaAlumno);//creo un alumno que se machaca en cada vuelta
            if(guardarEnLista(alumn))//pero antes guardo sus valores en la lista
            {
                JOptionPane.showMessageDialog(null,"Guardado Correctamente.","Guardado",JOptionPane.INFORMATION_MESSAGE);
            }else
            {
                JOptionPane.showMessageDialog(null,"Se produjo un error al guardar.","Guardado",JOptionPane.ERROR_MESSAGE);
            }
        }while(JOptionPane.showConfirmDialog(null, "Desea salir?","Atención",JOptionPane.YES_NO_OPTION)>0);
       
        System.out.println("tamaño lista: "+listaAlumnos.size());
        
        this.guardarEnArchivo();
    }
    
    /**
     * devuelve true si se añade correctamente un elemento
     * o false si se produjo algún tipo de error
     * 
     * @param alumn
     * @return 
     */
    public boolean guardarEnLista(Alumno alumn)
    {
        if (this.listaAlumnos.add(alumn))
        {
            return true; 
        }else
        {
            return false; 
        }
    }
    
    /**
     * guarda en un fichero de texto los datos que tenemos guardados
     * en el array list
     * 
     * si todo va bien, devuelve true, en caso de error, devuelve false
     * @return 
     */
    public boolean guardarEnArchivo()
    {
        PrintWriter fich=null;
        FileWriter f=null;
        
        //comprobamos si existe el archivo
        File fichero = new File(this.ARCHIVO);
        
        if (fichero.exists())
        {
            JOptionPane.showMessageDialog(null,"El archivo ya existe, se procede a usar el modo agregar datos en el archivo","Warning",JOptionPane.INFORMATION_MESSAGE);
            
            try
            {
                f= new FileWriter(fichero,true);
                fich = new PrintWriter(f);
                
                Iterator it= this.listaAlumnos.iterator();
                
                while(it.hasNext())
                {
                    Alumno informacion= (Alumno)it.next();
                    fich.println(informacion);//al haber modificado el toString, ya me devuelve los datos guardados del objeto
                }
                fich.close();
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                fich.close();
                return false;
            }
            
        }else
        {
         JOptionPane.showMessageDialog(null,"El archivo no existe, se procede a usar el modo crear archivo","Warning",JOptionPane.INFORMATION_MESSAGE);   
         
         try
            {
                f= new FileWriter(fichero);
                fich = new PrintWriter(f);
                
                Iterator it= this.listaAlumnos.iterator();
                
                while(it.hasNext())
                {
                    Alumno informacion= (Alumno)it.next();
                    fich.println(informacion);
                }
                fich.close();
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                fich.close();
                return false;
            }
        }
        return true;
    }
    
    //sobrecarga del método
     public boolean guardarEnArchivo(ArrayList <Alumno> datos)
    {
        PrintWriter fich=null;
        FileWriter f=null;
        
        //comprobamos si existe el archivo
        File fichero = new File("aprobados.ndt");
        
        if (fichero.exists())
        {
            JOptionPane.showMessageDialog(null,"El archivo ya existe, se procede a usar el modo agregar datos en el archivo","Warning",JOptionPane.INFORMATION_MESSAGE);
            
            try
            {
                f= new FileWriter(fichero,true);
                fich = new PrintWriter(f);
                
                Iterator it= datos.iterator();
                
                while(it.hasNext())
                {
                    Alumno informacion= (Alumno)it.next();
                    fich.println(informacion);//al haber modificado el toString, ya me devuelve los datos guardados del objeto
                }
                fich.close();
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                fich.close();
                return false;
            }
            
        }else
        {
         JOptionPane.showMessageDialog(null,"El archivo no existe, se procede a usar el modo crear archivo","Warning",JOptionPane.INFORMATION_MESSAGE);   
         
         try
            {
                f= new FileWriter(fichero);
                fich = new PrintWriter(f);
                
                Iterator it= datos.iterator();
                
                while(it.hasNext())
                {
                    Alumno informacion= (Alumno)it.next();
                    fich.println(informacion);
                }
                fich.close();
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                fich.close();
                return false;
            }
        }
        return true;
    }
    
    
    public void aprobados()
    {
            //creamos el archivo y el scaner para leer los datos
            File fichero= new File(this.ARCHIVO);     
            Scanner data=null;
            Integer contadorAlumnos=0;
        try
        {
            //leemos los datos del archivo 
             data= new Scanner(fichero);
            
            while(data.hasNext())
            {
                String info=data.nextLine();
                String datosSeparados[]=info.split(",");
                
                if (Integer.parseInt(datosSeparados[2])>this.APROBADO)
                {
                    contadorAlumnos+=1;
                    Alumno alu=new Alumno(datosSeparados[0],datosSeparados[1],Integer.parseInt(datosSeparados[2]));
                    this.listaAlumnos.add(alu);
                }
                System.out.println("datos: "+info);
            }
            
            JOptionPane.showMessageDialog(null, "Se contontraron "+contadorAlumnos+" alumnos aprobados.","Contador alumnos aprobados", JOptionPane.INFORMATION_MESSAGE);
            this.guardarEnArchivo(listaAlumnos);
            data.close();
        }catch (Exception ex)
        {
            JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            data.close();
        }
    }
    
    public void buscarAlumno()
    {
        String codigoBuscar=JOptionPane.showInputDialog(null,"Introduzca el código a buscar:","búsqueda",JOptionPane.INFORMATION_MESSAGE);
        
         File fichero= new File(this.ARCHIVO);     
         Scanner data=null;
         boolean existe=false;
        try
        {
            data= new Scanner(fichero);
            
            while(data.hasNext())
            {
                String info=data.nextLine();
                String datosSeparados[]=info.split(",");
                
                if (datosSeparados[1].equalsIgnoreCase(codigoBuscar))
                {
                    existe=true;
                    JOptionPane.showMessageDialog(null,"Los datos del alumno son los siguientes:\n Nombre: "+datosSeparados[0]+"\n Código: "+datosSeparados[1]+"\n Nota:"+Integer.parseInt(datosSeparados[2]),"Información Alumno",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
            if (!existe)
            {
                JOptionPane.showMessageDialog(null, "El alumno buscado no existe","Datos alumno", JOptionPane.ERROR_MESSAGE);
            }
            
            
        } catch (FileNotFoundException ex)
        {
            JOptionPane.showMessageDialog(null,"Error: "+ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            data.close();
        }
    }
}
