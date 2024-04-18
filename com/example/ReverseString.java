package com.example;
// Imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * This Program tells the user what a.
 * word would be spelt backwards.
 * Using Input File and Output File.
 * @author Jaydin Madore
 * @version 1.0
 * @since 2024-04-17
 */

/*
 * ReverseString class
 *
*/

public final class ReverseString {
    /** Private constructor to prevent instantiation. */
    private ReverseString() {
        throw new UnsupportedOperationException("Cannot instantiate");
    }
    // This method reverses a string recursively.
    // It than returns The reversed string.
    public static String reverse(String str){
        if (str.length() == 0){
            return str;
        } else{
            return reverse(str.substring(1)) + str.charAt(0);
        }
    }

    public static void main(final String[] args) {
        // List of file paths to output to.
        String outputFilePath = "output.txt";
        // List of file paths to read from.
        String readFilePath = "input.txt";

        try {
            // It reads the files
            BufferedReader reader = new BufferedReader
            (new FileReader(readFilePath));
            BufferedWriter writer = new BufferedWriter
            (new FileWriter(outputFilePath));
            String line;
            while ((line = reader.readLine()) != null){
                String reversedLine = reverse(line);
                writer.write(reversedLine);
                writer.newLine();
            }
            // Tells the user the program is done running.
            System.out.println("Done");
            System.out.println("Check output File for the results");
            // This tells the user that there was 
            // a Error when trying to read the files
            // It could be the input or output file 
            // that could be the problem.
            reader.close();
            writer.close();
        } catch (IOException e) {
            System.err.println("Error reading/writing files: " + e.getMessage());
        }
    }
}
