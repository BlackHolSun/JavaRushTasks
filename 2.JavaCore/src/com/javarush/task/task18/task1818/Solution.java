package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();
        String fileName3 = reader.readLine();

        FileInputStream inputStream2 = new FileInputStream(fileName2);
        FileInputStream inputStream3 = new FileInputStream(fileName3);
        FileOutputStream outputStream1 = new FileOutputStream(fileName1);

        while (inputStream2.available() > 0)
        {
            outputStream1.write(inputStream2.read());
        }

        FileOutputStream outputStream = new FileOutputStream(fileName1, true);

        while(inputStream3.available() > 0){
            outputStream.write(inputStream3.read());
        }
        inputStream2.close();
        inputStream3.close();
        outputStream.close();
        outputStream1.close();
    }
}
