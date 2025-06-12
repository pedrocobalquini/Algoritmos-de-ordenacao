import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    private static final int MAX_SIZE = 1000000;

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        // Trocar o nome do arquivo de teste
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\pedro\\Downloads\\Algoritmos-de-ordenacao-main\\dados_ordenacao\\reversa_10.txt"))) {
            String line;
            while ((line = br.readLine()) != null && numbers.size() < MAX_SIZE) {
                try {
                    numbers.add(Integer.parseInt(line.trim()));
                } catch (NumberFormatException e) {
                    System.err.println("Ignorando linha inválida: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao abrir o arquivo: " + e.getMessage());
            return;
        }

        if (numbers.isEmpty()) {
            System.out.println("Arquivo vazio ou erro na leitura!");
            return;
        }

        ArrayList<Integer> quickList = new ArrayList<>(numbers);
        ArrayList<Integer> bubbleList = new ArrayList<>(numbers);
        ArrayList<Integer> selectionList = new ArrayList<>(numbers);

        long startTime, endTime;

        // Quick Sort
                startTime = System.nanoTime();
                QuickSort.sort(quickList, 0, quickList.size() - 1);
                endTime = System.nanoTime();
                System.out.printf("%.6f%n", (endTime - startTime) / 1_000_000_000.0);

        // Bubble Sort
                startTime = System.nanoTime();
                BubbleSort.sort(bubbleList);
                endTime = System.nanoTime();
                System.out.printf("%.6f%n", (endTime - startTime) / 1_000_000_000.0);

        // Selection Sort
                startTime = System.nanoTime();
                SelectionSort.sort(selectionList);
                endTime = System.nanoTime();
                System.out.printf("%.6f%n", (endTime - startTime) / 1_000_000_000.0);


    }
}
