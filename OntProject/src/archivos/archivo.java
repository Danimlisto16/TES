/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author dyyysof
 */
public class archivo {
    public archivo(){
    }
    
    
    public  String leerArchivo(String path){
        String data = "";
      try {
      //File myObj = new File("src/querys/c6.txt");
      File myObj = new File(path);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        data += myReader.nextLine()+"\n";
        
      }
      System.out.println(data);
      myReader.close();
      return data;
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
        return null;
    }
}
