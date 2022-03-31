package videoclub;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Principal {
		public static Scanner scString=new Scanner(System.in);
	public static void main(String[] args) {

		int dia=1;
		int opcion=0;
		String texto="";

		
		
		while (true) {
		do {
		System.out.println("MENU: DIA "+dia);
		System.out.println("1.-Introducir nuevo producto.");
		System.out.println("2.-Eliminar producto");
		System.out.println("3.-Ver listado de peliculas");
		System.out.println("4.-Ver listado de CDs");
		System.out.println("5.-Alquilar pelicula");
		System.out.println("6.-Vender disco");
		System.out.println("7.-Ver peliculas en alquiler");
		System.out.println("8.-Ver ganancias");
		System.out.println("9.-Pasar al dia siguiente");
		System.out.println("10.-Terminar el programa");
		System.out.println("----------------------------------");
		

		System.out.println("\n[>>] Introduce un numero 1-10 para elegir una opcion del Menu");
		opcion = introducirNumeroEntero(opcion);
		
		}while(opcion<0 || opcion>10);
		
		switch (opcion-1) {
		case 0:
			System.out.println("[1] Introducir nuevo producto");
			break;
		case 1:
			System.out.println("[2] Eliminar producto");
			break;
		case 2:
			System.out.println("[3] Ver listado de peliculas");
			break;
		case 3:
			System.out.println("[4] Ver listado de CDs");
			break;	
		case 4:
			System.out.println("[5] Alquilar pelicula");
			break;
		case 5:
			System.out.println("[6] Ver peliculas en alquiler");
			break;
		case 6:
			System.out.println("[7] Ver ganancias");
			break;
		case 7:
			System.out.println("[8] Ver ganancias");
			break;
		case 8:
			System.out.println("[9] Pasando al siguiente dia...\n");
			break;				
		}
		
		
		//Opcion para terminar el programa
		if (opcion==10) {
			System.out.println("\n[10]Terminar el Programa, ha pasado "+dia+" dias activo.");
			break;
			}
		dia++;
		}
	}

	
	
	//Try-Catch para Double y para Int
	
	private static int introducirNumeroEntero(int opcion) {
		String texto;
		boolean correcto=false;
		do {
		try {
			texto = scString.nextLine();
			opcion = Integer.valueOf(texto);
			correcto=true;
		} catch (NumberFormatException e) {
			System.err.println("ERROR: No has introducido un numero");
		}
		}
		while (!correcto);
		return opcion;
	}
	
	private static double introducirNumeroDecimal(double decimal) {
		String texto;
		boolean correcto=false;
		do {
		try {
			texto = scString.nextLine();
			decimal = Double.valueOf(texto);
			correcto=true;
		} catch (NumberFormatException e) {
			System.err.println("ERROR: No has introducido un numero");
		}
		}
		while (!correcto);
		return decimal;
	}

}
