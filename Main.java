import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileCSV = "C:\\Java Projelerim IDE\\JavaReport\\src\\TurkishCities.csv";
        CSVto2DArray csvConverter = new CSVto2DArray(fileCSV);
        String[] cities = csvConverter.csvCities(fileCSV);

        while (true) {

            System.out.println("\nCity List:");
            for (int i = 0; i < cities.length; i++) {
                System.out.println((i + 1) + ". " + cities[i]);
            }


            System.out.println("\nPlease select the start city (number):");
            int startIndex = scanner.nextInt() - 1;
            System.out.println("Please select the target city (number):");
            int targetIndex = scanner.nextInt() - 1;

            String start = cities[startIndex];
            String target = cities[targetIndex];


            System.out.println("Please select the search algorithm (BFS or DFS):");
            String algorithm = scanner.next().toUpperCase();


            Graph graph = new Graph(cities, csvConverter.csvMatrix(fileCSV));
            graph.setupGraph();


            if ("BFS".equals(algorithm)) {
                long startTime = System.nanoTime();
                graph.BFS(start, target);
                long endTime = System.nanoTime();
                System.out.println("BFS Execution Time: " + (endTime - startTime) + " nanoseconds.");
            } else if ("DFS".equals(algorithm)) {
                long startTime = System.nanoTime();
                graph.preDFS(start, target);
                long endTime = System.nanoTime();
                System.out.println("DFS Execution Time: " + (endTime - startTime) + " nanoseconds.");
            } else {
                System.out.println("Invalid algorithm choice! Please select either BFS or DFS.");
            }

            System.out.println("\nDo you want to try again? (yes/no):");
            String choice = scanner.next().toLowerCase();
            if (!choice.equals("yes")) {
                System.out.println("Exiting the program. Goodbye!");
                break;
            }
        }

        scanner.close();
    }
}
