package practica3;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.WRITE;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio5_BWconAppend {
	public static void main(String[] args) {
		Scanner lc = new Scanner(System.in);
		System.out.println("Bienvenido\n" + "Introduzca las frases que desee(pulse enter para introducir cada una)\n"
				+ "Cuando desee finalizar simplemente vuelva a pulsar enter:");
		boolean salir = false;
		Charset charset = Charset.forName("UTF-8");
		Path dialogo = Paths.get("dialogo.txt");
		OpenOption[] options = new OpenOption[2];
		options[0] = APPEND;
		options[1] = WRITE;
		try {
			BufferedWriter bw = Files.newBufferedWriter(dialogo, charset);
			while (!salir) {
				String frase = lc.nextLine();
				if (frase.isEmpty())
					salir = true;
				else {
					if (Files.exists(dialogo) && Files.size(dialogo) != 0) {
						bw.write(frase);
					} else {
						bw.append(frase);
						bw.newLine();
					}
				}
			}
			bw.close();
			System.out.println(Files.readAllLines(dialogo).toString());
		} catch (IOException io) {
			System.err.println(io);
		}
	}
}
