/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Alan Rene Garcia Rico
 */
public class Ejercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
            creaArchivo();     
        
             if("add".equals(args[0])) {
                 String dato = "";
                 
                 for(int i = 1; i < args.length; i++)
                     dato+=args[i]+" ";
                 agregaArchivo(dato);
             }
            
             if("list".equals(args[0])) {     
                 leeArchivo( );
             }
             
             if("fuzzy-search".equals(args[0])){
                 String dato = "";
                 
                 for(int i = 1; i < args.length; i++)
                     dato+=args[i]+" ";
                 
                 dato = dato.substring(dato.indexOf(":")+2, dato.length()-3);
                 buscaPersona(dato);
             }  
    }
    
    public static void leeArchivo( ) throws IOException
    {
        ArrayList<String> al = new ArrayList<String>();
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
             archivo = new File ("c:\\Archivo\\fuzzy-search.txt");
             fr = new FileReader (archivo);
             br = new BufferedReader(fr);
        
         boolean flag = false;
         String linea;
         while((linea=br.readLine())!=null){
            al.add(linea); 
            flag = true;
         }
         
         if(!flag)
             System.out.println("[]");
         else
             Collections.sort(al);
         System.out.println(al);
         }
        catch(FileNotFoundException e){
             System.out.println("Problema con el archivo "+e.getMessage());
        } 
        
        catch (IOException ex) {
            Logger.getLogger(Ejercicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            br.close();
            fr.close();
        }
    }
   
    public static void agregaArchivo(String reg) throws IOException
    {
        FileWriter archivo = null;
        PrintWriter pw = null;
        try
        {
            archivo = new FileWriter("c:\\Archivo\\fuzzy-search.txt", true);
            pw = new PrintWriter(archivo,true);
            pw.println(reg);
            System.out.println("Usuario agregado");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
           try {
               pw.close();
           if (null != archivo)
              archivo.close();
           } 
           catch (IOException e2) {
              e2.printStackTrace();
           }
        }
    }
    
    public static void buscaPersona(String dato) throws IOException
    {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
             archivo = new File ("c:\\Archivo\\fuzzy-search.txt");
             fr = new FileReader (archivo);
             br = new BufferedReader(fr);
        
         boolean flag = false;
         String linea;
         while((linea=br.readLine())!=null){
             if(linea.indexOf(dato)>0){
                 System.out.println(linea);
                 flag = true;
              }
         }
         
         if(!flag)
             System.out.println("Sin coincidencias");
         
         }
        catch(FileNotFoundException e){
             System.out.println("Problema con el archivo "+e.getMessage());
        } 
        
        catch (IOException ex) {
            Logger.getLogger(Ejercicio.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            br.close();
            fr.close();
        }
    }
    
    public static void creaArchivo()
    {
        File folder = new File("c:\\Archivo");
        String ruta = "c:\\Archivo\\fuzzy-search.txt";
        File file = new File(ruta);
        try {
        if (!folder.exists())
            folder.mkdir();
        if (!file.exists()) {
                file.createNewFile();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
