package com.ashahova.gai_spring_boot.demo.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File {

    public static void appendUsingFileWriter(String filePath, StringBuilder text) {
        FileWriter fr = null;
        try {
            fr = new FileWriter(filePath,true);
            fr.write(String.valueOf(text)+ " ");

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static boolean findStringFile(String number)
    {

        boolean found = false;
        try{
            BufferedReader br = new BufferedReader(new FileReader("GaiNumbers.txt"));
            try{
                String line;
                while ((line = br.readLine()) != null)
                {
                    if (line.contains(number))
                        found = true;
                }
            } finally {
                br.close();
            }
        } catch(IOException ioe)
        {
            System.out.println("Error while opening the file !");
        }
        return found;
    }
}
