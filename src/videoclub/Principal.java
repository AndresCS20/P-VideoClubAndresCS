package videoclub;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Principal {
	public static Scanner scString=new Scanner(System.in);
	public static int codPeli=1000;
	public static int codCd=1000;
	public static void main(String[] args) {

		int dia=1;
		int opcion=0;
		String texto="";
		
		ArrayList<Pelicula> peliculasSinAlquilar=new ArrayList();
		ArrayList<Pelicula> peliculasAlquiladas=new ArrayList();

		ArrayList<Producto> cdActivo=new ArrayList();
		
		
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
			
			System.out.println("Elige el tipo de producto");
			System.out.println("[1] Pelicula o [2] CDs");
			opcion=introducirNumeroEntero(opcion);
			if (opcion==1) {
				String titulo="";
				int tipo=0;
				int cantidad=0;
				System.out.println("Has elegido introducir peliculas");
				while (true) {		
				System.out.println("Introduce el Titulo de la Pelicula");
				titulo=scString.nextLine();
					if (titulo!="") {
					break;
					}
				}
				System.out.println("Tipo de Pelicula");
				System.out.println("[1] Novedad");
				System.out.println("[2] Semi-Novedad");
				System.out.println("[3] Antigua");
				while (true) {		
					System.out.println("Introduce el tipo de Pelicula");
				tipo=introducirNumeroEntero(opcion);
					if (tipo>0 && tipo<4) {
					break;
					}
				}

				while (true) {
					System.out.println("Introduce cantidad de pelicula");
					cantidad = introducirNumeroEntero(opcion);
					if (cantidad > 0) {
						break;
					}
				}
				
				System.out.println("Cantidad " + cantidad);
				for (int i = 0; i < cantidad; i++) {

					Pelicula pelicula = new Pelicula(codPeli, titulo, tipo);
					peliculasSinAlquilar.add(pelicula);
					codPeli++;
				}
					
						
				
				for (int i=0; i<peliculasSinAlquilar.size(); i++) {
					System.out.println(peliculasSinAlquilar.get(i));
				}
				System.out.println("Titulo: "+titulo+" Tipo: "+tipo+" Tamaño ArraySinAlquilar: "+peliculasSinAlquilar.size());

			}
			
			if (opcion==2) {
				System.out.println("Has elegido introducir CDs");
				
				
			}
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
