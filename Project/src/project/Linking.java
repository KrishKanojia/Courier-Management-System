/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Linking {
    String filename1 = "Adminfile.txt";
    String filename2 = "Courierfile.txt";
    String filename3 = "Registrationfile.txt";
    int linecount = 0;
    int linecount1 = 0;
    Scanner x;
    
    public void fileopen() {
        try{
            x = new Scanner(new File(filename1));
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
    }
    
    public void fileopen1()
    {
        try{
            x = new Scanner(new File(filename3));
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
        
    }
    
    
    public void close(){
        x.close();
    }
    
    public boolean read(String n, String p)
    {
        boolean status = false;
        String tempn = n;
        String tempp = p;
        while(x.hasNext()){
            String a = x.next();
            String b = x.next();
            if(tempn.equals(a) && tempp.equals(b)){
                status = true;
            }
                 
        }
        return status;
    }
    
    public void writetofile1(String d) throws IOException
    {
        FileWriter file = new FileWriter(filename2,true);
        BufferedWriter w = new BufferedWriter(file);
        w.write(d);
        w.write("\n");
        w.close();
    }
    
    public void writetofile2(String d) throws IOException
    {
        FileWriter file = new FileWriter(filename3,true);
        BufferedWriter w = new BufferedWriter(file);
        w.write(d);
        w.write("\n");
        w.close();
    }
    
    public String[][] readfullrecord() throws IOException
    {
        FileReader file = new FileReader(filename3);
        BufferedReader buffer = new BufferedReader(file);
        String line = null;
        String records[] = new String[14];
        String data[][] = new String[10][];
        
        while((line = buffer.readLine())!=null)
        {
            records = line.split(",");
            data[linecount] = records;
            linecount++;
        }
        return data;
    }
     public String[][] readfullrecord1() throws IOException
    {
        FileReader file1 = new FileReader(filename2);
        BufferedReader buffer1 = new BufferedReader(file1);
        String line = null;
        String records1[] = new String[8];
        String data1[][] = new String[10][];
        
        while((line = buffer1.readLine())!=null)
        {
            records1 = line.split(",");
            data1[linecount1] = records1;
            linecount1++;
        }
        return data1;
    }
   
    public static void main(String[] args) throws IOException {
        Linking cnn = new Linking();
        
        String x[][] = cnn.readfullrecord1();
        for(int i = 0; i < cnn.linecount1;i++)
        {
            for(int j = 0; j < 14;j++)
            {
                System.out.print(x[i][j] + "\t");
            }
              System.out.println();
        }
        
    }


}
