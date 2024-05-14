import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GestorDeLlibres {

    public static String[] llegirLlibres() {
        StringBuilder contingut = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("Llibres.txt"))) {
            String linia;
            while ((linia = br.readLine()) != null) {
                contingut.append(linia).append("\n");
            }
