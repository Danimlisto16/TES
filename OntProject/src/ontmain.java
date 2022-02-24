
import archivos.archivo;
import javax.swing.text.Utilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author dyyysof
 */
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import static transaccionesOWL.transaccionesOWL.conexionOWL;



public class ontmain {    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
      archivo ar = new archivo();
      
      
      
       System.out.println("PRUEBA ONTOLOGÍAS");
        String queryString = ar.leerArchivo("src/querys/c6.txt");       
        Query query = QueryFactory.create(queryString);
        QueryExecution qe = QueryExecutionFactory.create(query,conexionOWL());
        
        
        try{
            ResultSet results = qe.execSelect();
            ResultSetFormatter.out(System.out,results,query);
        }finally{
            qe.close();
        }

    }
    
}
