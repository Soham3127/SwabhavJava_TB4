package com.aurionpro.bufferclass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileScanner {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("demo.txt");
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line);
        }

        scanner.close();
    }
}
