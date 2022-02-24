/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package transaccionesOWL;

import archivos.archivo;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;

/**
 *
 * @author dyyysof
 */
public class transaccionesOWL{
    
    public transaccionesOWL(){
    
    }
    
    public static OntModel conexionOWL(){
        OntModel model = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM); model.read("/home/dyyysof/Documents/ont.owl","RDF/XML");
        return model;
    } 
    
    
    public ResultSet cargarConsulta(String path){
        archivo ar = new archivo();
        System.out.println("PRUEBA ONTOLOGÍAS");
        String queryString = ar.leerArchivo(path);        
        Query query = QueryFactory.create(queryString);
        QueryExecution qe = QueryExecutionFactory.create(query,conexionOWL());
        ResultSet results = qe.execSelect();
        return results;        
    }
    
    public void ConstructionTable(org.apache.jena.query.ResultSet re, String[] d, DefaultTableModel aModel, JTable DataTable) {
        RDFNode[] data = new RDFNode[d.length];
        while (re.hasNext()) {
            QuerySolution sol = re.nextSolution();
            System.out.println("data: " + d.length);
            for (int i = 0; i < d.length; i++) {
                data[i] = sol.get(d[i]);
            }
            aModel.addRow(data);
            DataTable.setModel(aModel);
        }
    }
    
}
