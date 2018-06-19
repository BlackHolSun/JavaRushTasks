package com.javarush.task.task18.task1816;

/* 
English letters
First paramenter in main is a filename.
Count English letters (uppercase and lowercase) given file contains.
Print out the amount of letters.
Streams must be closed.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        if(!args[0].isEmpty()) {
            String filename = args[0];
            int lettersCount = 0;
            FileInputStream fileInputStream = new FileInputStream(filename);
            while (fileInputStream.available() > 0) {
                int i = fileInputStream.read();
                if (i > 64 && i < 123) {
                    lettersCount++;
                }
            }
            System.out.println(lettersCount);
            fileInputStream.close();
        }

    }

}
