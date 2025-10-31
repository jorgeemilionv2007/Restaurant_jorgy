package co.edu.umanizales.restaurant_jorgy.service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CsvService {
    private static final String CSV_DIRECTORY = "data/csv/";

    public CsvService() {
        createDirectoryIfNotExists();
    }

    private void createDirectoryIfNotExists() {
        try {
            Files.createDirectories(Paths.get(CSV_DIRECTORY));
        } catch (IOException e) {
            System.err.println("Error creating CSV directory: " + e.getMessage());
        }
    }

    public void writeToCSV(String filename, List<String> headers, List<List<String>> data) {
        try {
            String filepath = CSV_DIRECTORY + filename;
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(filepath), StandardCharsets.UTF_8));

            // Write headers
            writer.write(String.join(",", headers));
            writer.newLine();

            // Write data
            for (List<String> row : data) {
                writer.write(String.join(",", row));
                writer.newLine();
            }

            writer.close();
            System.out.println("Data written to " + filepath);
        } catch (IOException e) {
            System.err.println("Error writing to CSV: " + e.getMessage());
        }
    }

    public List<List<String>> readFromCSV(String filename) {
        List<List<String>> data = new ArrayList<>();
        try {
            String filepath = CSV_DIRECTORY + filename;
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(new FileInputStream(filepath), StandardCharsets.UTF_8));

            String line;
            while ((line = reader.readLine()) != null) {
                List<String> row = new ArrayList<>();
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
                for (String value : values) {
                    row.add(value.trim().replaceAll("^\"|\"$", ""));
                }
                data.add(row);
            }

            reader.close();
            System.out.println("Data read from " + filepath);
        } catch (IOException e) {
            System.err.println("Error reading from CSV: " + e.getMessage());
        }
        return data;
    }

    public void appendToCSV(String filename, List<String> row) {
        try {
            String filepath = CSV_DIRECTORY + filename;
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(filepath, true), StandardCharsets.UTF_8));

            writer.write(String.join(",", row));
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.err.println("Error appending to CSV: " + e.getMessage());
        }
    }

    public Boolean fileExists(String filename) {
        return Files.exists(Paths.get(CSV_DIRECTORY + filename));
    }
}
