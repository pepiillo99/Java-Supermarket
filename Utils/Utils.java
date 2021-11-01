package me.pepe.ExamenCarrera.Ejercicio10.Utils;

import java.util.Arrays;
import java.util.List;

public class Utils {
	public static String printArray(Object[] args) {
		String a= "[";
		for (Object o : args) {
			if (a.equals("[")) {
				a = a+ o.toString();
			} else {
				a = a + ", " + o.toString();
			}
		}
		a = a + "]";
		return a;
	}
	public static boolean isDateValid(int dia, int mes, int ano) {
		boolean valido = true;
		if (mes < 1 || mes > 12) {
			valido = false;
		}
		if (dia < 1 || dia > 31) {
			valido = false;
		}
		if (dia > 28) {
			if (mes == 2) {
				if ((ano / 4) % 1 == 0) {
					// es visiesto
					if (dia > 28) {
						valido = false;
					}
				} else {
					// no es visieso
					valido = false;
				}
			}
		}
		List<Integer> meses_31 = Arrays.asList(1, 3, 5, 7, 8, 10, 12);
		if (dia == 31) {
			if (!meses_31.contains(mes)) {
				valido = false;
			}
		}
		return valido;
	}
	public static boolean isDNIValid(String dni) {
		boolean valid = true;
		String dniLetters = "TRWAGMYFPDXBNJZSQVHLCKE";
		if (dni.length() == 9) {
			char dniLetter = dni.charAt(8);
			int dniNumber;
			try {
				dniNumber = Integer.valueOf(dni.replace(dniLetter + "", ""));
				if (dniLetters.contains(String.valueOf(dniLetter))) {
					if (dniLetter != dniLetters.charAt(dniNumber%23)) {
						valid = false;
					}
				} else {
					valid = false;
				}
			} catch (NumberFormatException ex) {
				// el numero del dni no es un numero valido
				valid = false;
			}
		} else {
			valid = false;
		}
		return valid;
	}
}
