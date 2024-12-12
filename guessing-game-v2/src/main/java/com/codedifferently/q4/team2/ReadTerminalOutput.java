package com.codedifferently.q4.team2;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadTerminalOutput {

    public static void main(String[] args) throws IOException, InterruptedException {
        // Create a ProcessBuilder to run the command
        ProcessBuilder pb = new ProcessBuilder("ls", "-l");

        // Start the process
        Process process = pb.start();

        // Get the input stream of the process (standard output)
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

        // Read the output line by line and store in a StringBuilder
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }

        // Wait for the process to finish
        int exitCode = process.waitFor();

        // Print the output
        System.out.println("Output:\n" + output);
        System.out.println("Exit code: " + exitCode);
    }
}
