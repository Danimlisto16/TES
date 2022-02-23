/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author dyyysof
 */

import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;
import org.apache.jena.query.ResultSetFormatter;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;


public class ontmain {    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM); model.read("/home/dyyysof/Documents/ont.owl","RDF/XML");
        
        System.out.println("PRUEBA ONTOLOGÍAS");
        String queryString = 
                            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
                            "PREFIX ont: <http://www.semanticweb.org/dyyysof/ontologies/2022/1/untitled-ontology-25#>" +
                             "SELECT  ?area_especialidad ?centro" + 
                             "		WHERE {" +
                             "				?cen ont:tiene_are ?esp."+
                             "				?esp ont:nombre ?area_especialidad."+
                             "				?cen ont:nombre ?centro."+
                             "}";
        
        Query query = QueryFactory.create(queryString);
        QueryExecution qe = QueryExecutionFactory.create(query,model);
        try{
            ResultSet results = qe.execSelect();
            
            ResultSetFormatter.out(System.out, results, query);
            
        }finally{
            qe.close();
        }
        
        

    }
    
}
