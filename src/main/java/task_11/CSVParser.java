package task_11;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Parser of scv files. Analyses an information about user's activity,
 * presented in scv files and makes a statistical report. Works with several
 * threads using ExecutorService.
 *
 * @author Kseniya Shavonina
 * @version 1.0
 */
public class CSVParser {
    /** Count of threads. */
    private final int THREADS_COUNT = 10;
    /** Path to files to analyse. */
    private String inputFilesPath;
    /** Array of files to analyse. */
    private File[] inputFilesArray;
    /** Result of processing files. */
    private Map<String, Long> processingResult;

    /** Initializes an instance of CSVParser class. */
    CSVParser() {
        this("./src/main/java/task_11/resources");
    }

    /** Initializes an instance of CSVParser class. */
    private CSVParser(String inputFilesPath) {
        this.inputFilesPath = inputFilesPath;
        this.inputFilesArray = new File(inputFilesPath).listFiles((dir, name) -> name.toLowerCase().endsWith(".csv"));
        this.processingResult = new ConcurrentHashMap<>();
    }

    /**
     * Starts analysis of files.
     */
    void start() {
        parseFiles();
        createReport();
    }

    /**
     * Parses csv files in several threads.
     */
    private void parseFiles() {
        int threadCount = inputFilesArray.length < 10 ? inputFilesArray.length : this.THREADS_COUNT;
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);

        for (File file : inputFilesArray) {
            executorService.execute(new ParsingThread(file));
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Creates statistical report with information about total time
     * each user have spent on each URL.
     */
    private void createReport() {
        String outputPath = "./src/main/java/task_11/report";

        if (new File(outputPath).mkdir()) {
            File timeReportFile = new File(outputPath, "report.scv");

            try (FileWriter writer = new FileWriter(timeReportFile, false)) {
                writer.write("user,url,time");
                Map<String, Long> sortedMap = new TreeMap<>(processingResult);

                for (Map.Entry<String, Long> pair : sortedMap.entrySet()) {
                    writer.write('\n' + pair.getKey() + ',' + pair.getValue());
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    /**
     * Class for reading scv files.
     */
    private class ParsingThread implements Runnable {
        /** File for analysis. */
        private File fileToParse;

        private ParsingThread(File fileToParse) {
            this.fileToParse = fileToParse;
        }

        /**
         * Reads all info from file, analyzes it and puts into processingResult file.
         */
        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(fileToParse))) {
                reader.readLine();
                String fileLine;

                fileLine = reader.readLine();
                while (fileLine != null) {
                    String[] values = fileLine.split(",");
                    long timeValue = values[2].matches("\\d*") ? Long.parseLong(values[2]) : 0;
                    processingResult.merge(values[3] + ',' + values[1], timeValue, (exTime, newTime)
                            -> exTime + newTime);
                    fileLine = reader.readLine();
                }
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
