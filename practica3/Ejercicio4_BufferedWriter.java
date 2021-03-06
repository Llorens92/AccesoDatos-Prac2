package practica3;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio4_BufferedWriter {
	public static void main(String[] args) {
		Scanner lc = new Scanner(System.in);
		System.out.println("Bienvenido\n" + "Introduzca las frases que desee(pulse enter para introducir cada una)\n"
				+ "Cuando desee finalizar simplemente vuelva a pulsar enter:");
		boolean salir = false;
		ArrayList<String> frases = new ArrayList<String>();
		while (!salir) {
			String frase = lc.nextLine();
			if (frase.isEmpty())
				salir = true;
			else {
				frases.add(frase);
			}
		}
		Charset charset = Charset.forName("UTF-8");
		Path dialogo = Paths.get("dialogo.txt");
		try {
			BufferedWriter bw = Files.newBufferedWriter(dialogo, charset);
			for (int i = 0; i < frases.size(); i++) {
				bw.write(frases.get(i), 0, frases.get(i).length());
				bw.newLine();
			}
			bw.close();
			System.out.println(Files.readAllLines(dialogo).toString());
		} catch (IOException io) {
			System.err.println(io);
		}
	}
}
