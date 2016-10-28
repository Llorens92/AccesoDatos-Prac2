package practica3;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3_OutputStream {
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
			else
				frases.add(frase);
		}
		Path dialogo = Paths.get("dialogo.txt");
		byte[] bytes = frases.toString().getBytes();
		try {
			OutputStream ostream = Files.newOutputStream(dialogo);
			ostream.write(bytes);
			System.out.println(Files.readAllLines(dialogo).toString());
			ostream.close();
		} catch (IOException io) {
			System.err.println(io);
		}
	}
}
