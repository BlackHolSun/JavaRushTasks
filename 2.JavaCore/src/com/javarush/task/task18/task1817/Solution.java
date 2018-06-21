package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        int countSpaces = 0;
        int countSymbols = 0;
        String parameter = args[0];
        if (!parameter.isEmpty()) {
            FileInputStream inputStream = new FileInputStream(parameter);
            while (inputStream.available() > 0){
                int b = inputStream.read();
                if (b == 32) countSpaces++;
                countSymbols++;
            }
            double ratio = countSpaces / (double)countSymbols * 100;
            System.out.println(String.format("%.2f", ratio));
            inputStream.close();
        }

    }
}
