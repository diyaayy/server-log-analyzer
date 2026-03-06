import java.io.*;

public class LogAnalyzer {

    public static void main(String[] args) {

        int error = 0;
        int warning = 0;
        int info = 0;
        int total = 0;

        StringBuilder errorLogs = new StringBuilder();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("server.log"));
            String line;

            while ((line = reader.readLine()) != null) {

                total++;

                if (line.contains("ERROR")) {
                    error++;
                    errorLogs.append(line).append("\n");
                }
                else if (line.contains("WARNING")) {
                    warning++;
                }
                else if (line.contains("INFO")) {
                    info++;
                }
            }

            reader.close();

            double errorPercent = (error * 100.0) / total;

            String mostFrequent;

            if (error > warning && error > info)
                mostFrequent = "ERROR";
            else if (warning > error && warning > info)
                mostFrequent = "WARNING";
            else
                mostFrequent = "INFO";

            System.out.println("===== Log Analysis Report =====");
            System.out.println("Total Logs: " + total);
            System.out.println("ERROR: " + error);
            System.out.println("WARNING: " + warning);
            System.out.println("INFO: " + info);
            System.out.println("Error Percentage: " + errorPercent + "%");
            System.out.println("Most Frequent Log Type: " + mostFrequent);

            System.out.println("\n--- ERROR LOGS ---");
            System.out.println(errorLogs);

            // Save report to file
            BufferedWriter writer = new BufferedWriter(new FileWriter("report.txt"));

            writer.write("Log Analysis Report\n");
            writer.write("Total Logs: " + total + "\n");
            writer.write("ERROR: " + error + "\n");
            writer.write("WARNING: " + warning + "\n");
            writer.write("INFO: " + info + "\n");
            writer.write("Error Percentage: " + errorPercent + "%\n");
            writer.write("Most Frequent Log Type: " + mostFrequent + "\n");

            writer.close();

            System.out.println("Report saved to report.txt");

        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }
}