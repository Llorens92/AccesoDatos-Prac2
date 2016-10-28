package practica3;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2_Dialogo {
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
		try {
			Charset charset = Charset.forName("UTF-8");
			Path dialogo = Paths.get("dialogo.txt");
			Files.write(dialogo, frases, charset);
			charset = Charset.forName("UTF-8");
			System.out.println("Usted ha escrito las siguientes frases:");
			System.out.println(Files.readAllLines(dialogo).toString());
		} catch (IOException io) {
			System.err.println(io);
		}
	}
}
