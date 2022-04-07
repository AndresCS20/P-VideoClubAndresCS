package videoclub;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Principal {
	public static Scanner scString=new Scanner(System.in);
	public static int codPeli=10000;
	public static int codCd=20000;
	public static int codCliente=100;
	public static double beneficioventaCD=0.0;
	public static double beneficioalquilerPelicula=0.0;
	public static double beneficioPorRecargos=0.0;
	public static double beneficioGlobal=0.0;
	public static void main(String[] args) {

		int dia=1;
		int opcion=0;
		String texto="";
		
		ArrayList<Pelicula> peliculasSinAlquilar=new ArrayList();
		ArrayList<Pelicula> peliculasAlquiladas=new ArrayList();
		ArrayList<Cd> cdActivo=new ArrayList();
		ArrayList<Cliente> clientes=new ArrayList();
		
		
		while (true) { // While True del programa en general
			while (true) { // While true del menu
				do {
					System.out.println("MENU: DIA " + dia);
					System.out.println("01.-Introducir nuevo producto.");
					System.out.println("02.-Dar de alta cliente");
					System.out.println("03.-Eliminar producto");
					System.out.println("04.-Ver listado de peliculas");
					System.out.println("05.-Ver listado de CDs");
					System.out.println("06.-Alquilar pelicula");
					System.out.println("07.-Devolver pelicula");
					System.out.println("08.-Vender disco");
					System.out.println("09.-Ver peliculas en alquiler");
					System.out.println("10.-Ver retraso");
					System.out.println("11.-Buscar cliente");
					System.out.println("12.-Ver ganancias");
					System.out.println("13.-Pasar al dia siguiente");
					System.out.println("14.-Terminar el programa");
					System.out.println("----------------------------------");

					System.out.println("\n[>>] Introduce un numero 1-14 para elegir una opcion del Menu");
					opcion = introducirNumeroEntero(opcion);

				} while (opcion < 0 || opcion > 14);

				//Opciones del Menu Principal (Desde la opcion 1 hasta la 12)
				switch (opcion - 1) {
				case 0:
					opcion = introducirProducto(opcion, peliculasSinAlquilar, cdActivo);
					break;
				case 1:
					System.out.println("[02] Dar de alta cliente");
					
					Cliente cliente=new Cliente();
					cliente.intrducirCliente(codCliente);
					clientes.add(cliente);
					codCliente++;
					break;
				case 2:
					opcion = eliminarProducto(opcion, peliculasSinAlquilar, peliculasAlquiladas, cdActivo);
					break;
				case 3:
					verlistadoPeliculas(peliculasSinAlquilar, peliculasAlquiladas);
					break;
				case 4:
					verlistadoCDs(cdActivo);
					break;
				case 5:
					//Hay que hacer que introduzca  el codigo cliente y alquile una a una 
					alquilarPeliculas(opcion, peliculasSinAlquilar, peliculasAlquiladas);
					break;
				case 6:
					System.out.println("[07] Devolver peliculas");
					break;	
				case 7:
					venderDisco(opcion, cdActivo);
					break;
				case 8:
					verPeliculasenAlquiler(peliculasAlquiladas);
					break;
				case 9:
					System.out.println("[10] Ver retraso");
					break;
				case 10:
					System.out.println("[11] Buscar cliente");
					break;	
				case 11:
					verGanancias();
					break;
				}

				//Opcion 13 para pasar de dia 
				if (opcion == 13) {
					texto = "";
					while (true) {
						System.out.println("[13] Desea pasar al siguiente dia (s/n)?");
						texto = scString.nextLine();
						if (texto.equalsIgnoreCase("s") || texto.equalsIgnoreCase("n")) {
							break;
						}
					}
					if (texto.equalsIgnoreCase("s")) {
						calculoDeBeneficios(peliculasSinAlquilar, peliculasAlquiladas);
						break;
					}
				}
				// Opcion extra  para terminar el programa
				if (opcion == 14) {
					System.out.println("\n[14]Terminar el Programa, ha pasado " + dia + " dias activo.");
					System.exit(0);
				}
			}

			dia++;
		}
	}

	// [1] Introducir Productos (Peliculas o CD`s)
	private static int introducirProducto(int opcion, ArrayList<Pelicula> peliculasSinAlquilar,ArrayList<Cd> cdActivo) {
		System.out.println("[1] Introducir nuevo producto");
		do {
			System.out.println("Elige el tipo de producto");
			System.out.println("[1] Pelicula o [2] CDs");
			opcion = introducirNumeroEntero(opcion);
		} while (opcion < 1 || opcion > 2);
		introducirPeliculas(opcion, peliculasSinAlquilar);

		introducirCDs(opcion, cdActivo);
		return opcion;
	}


	// [01A] Introducir Peliculas
	private static void introducirPeliculas(int opcion, ArrayList<Pelicula> peliculasSinAlquilar) {
		if (opcion == 1) {
			String titulo = "";
			int tipo = 0;
			int cantidad = 0;
			System.out.println("Has elegido introducir peliculas");
			while (true) {
				System.out.println("Introduce el Titulo de la Pelicula");
				titulo = scString.nextLine();
				if (titulo != "") {
					break;
				}
			}
			System.out.println("Tipo de Pelicula");
			System.out.println("[1] Novedad");
			System.out.println("[2] Semi-Novedad");
			System.out.println("[3] Antigua");
			while (true) {
				System.out.println("Introduce el tipo de Pelicula");
				tipo = introducirNumeroEntero(opcion);
				if (tipo > 0 && tipo < 4) {
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
		}
	}


	// [01B] Introducir CD´s
	private static void introducirCDs(int opcion, ArrayList<Cd> cdActivo) {
		if (opcion == 2) {
			System.out.println("Has elegido introducir CDs");
			String titulo = "";
			String autor = "";
			int cantidad = 0;
			double precio = 0.0;
			while (true) {
				System.out.println("Introduce el Titulo del CD");
				titulo = scString.nextLine();
				if (titulo != "") {
					break;
				}
			}
			while (true) {
				System.out.println("Introduce el nombre del Grupo o Cantante");
				autor = scString.nextLine();
				if (autor != "") {
					break;
				}
			}
			while (true) {
				System.out.println("Introduce precio de CDs");
				precio = introducirNumeroDecimal(opcion);
				if (precio > 0.0) {
					break;
				}
			}
			while (true) {
				System.out.println("Introduce cantidad de CDs");
				cantidad = introducirNumeroEntero(opcion);
				if (cantidad > 0) {
					break;
				}
			}

			System.out.println("Cantidad " + cantidad);
			for (int i = 0; i < cantidad; i++) {

				Cd cd = new Cd(codCd, titulo, autor, precio);
				cdActivo.add(cd);
				codCd++;
			}
		}
	}

	// [03] Eliminar productos (Pelicula o Cd)
	private static int eliminarProducto(int opcion, ArrayList<Pelicula> peliculasSinAlquilar,ArrayList<Pelicula> peliculasAlquiladas, ArrayList<Cd> cdActivo) {
		System.out.println("[03] Eliminar producto");
		do {
			System.out.println("Elige el tipo de producto");
			System.out.println("[1] Pelicula o [2] CDs");
			opcion = introducirNumeroEntero(opcion);
		} while (opcion < 1 || opcion > 2);

		eliminarPeliculas(opcion, peliculasSinAlquilar, peliculasAlquiladas);
		eliminarCD(opcion, cdActivo);
		return opcion;
	}

	// [03A] Eliminar Peliculas
	private static void eliminarPeliculas(int opcion, ArrayList<Pelicula> peliculasSinAlquilar,ArrayList<Pelicula> peliculasAlquiladas) {
		if (opcion == 1) {
			int codPeliEliminar = 0;
			if (peliculasAlquiladas.size() > 0 || peliculasSinAlquilar.size() > 0) {
				System.out.println("Has elegido eliminar una pelicula ¿Cual quieres eliminar?");
				if (peliculasAlquiladas.size() > 0) {
					for (int i = 0; i < peliculasAlquiladas.size(); i++) {
						System.out.println(peliculasAlquiladas.get(i));
					}
				}
				if (peliculasSinAlquilar.size() > 0) {
					for (int i = 0; i < peliculasSinAlquilar.size(); i++) {
						System.out.println(peliculasSinAlquilar.get(i));
					}
				}
				while (true) {
					System.out.println("Introduce el codigo de la pelicula ");
					codPeliEliminar = introducirNumeroEntero(opcion);// (peliculasSinAlquilar.size()+10000
					if (codPeliEliminar >= 10000 && (codPeliEliminar < codPeli || codPeliEliminar < codPeli)) {
						break;
					} else
						System.out.println("ERROR: Ese codigo no corresponde con ninguna pelicula disponible");
				}

				for (int i = 0; i < peliculasSinAlquilar.size(); i++) {
					if (peliculasSinAlquilar.get(i).getCodproducto() == codPeliEliminar) {
						System.out.println("La pelicula " + peliculasSinAlquilar.get(i).getTitulo() + "(ID: "
								+ peliculasSinAlquilar.get(i).getCodproducto() + ") ha sido eliminada");
						peliculasSinAlquilar.remove(i);
						break;
					}
				}

				for (int i = 0; i < peliculasAlquiladas.size(); i++) {
					if (peliculasAlquiladas.get(i).getCodproducto() == codPeliEliminar) {
						System.out.println("La pelicula " + peliculasAlquiladas.get(i).getTitulo() + "(ID: "
								+ peliculasAlquiladas.get(i).getCodproducto() + ") ha sido eliminada");
						peliculasAlquiladas.remove(i);
						break;
					}
				}
			} else
				System.out.println("ERROR: No hay peliculas disponibles para eliminar");

		}
	}

	// [03B] Eliminar CD
	private static void eliminarCD(int opcion, ArrayList<Cd> cdActivo) {
		if (opcion == 2) {
			int cdEliminar = 0;
			if (cdActivo.size() > 0) {
				System.out.println("Has elegido eliminar una CD ¿Cual quieres eliminar?");

				if (cdActivo.size() > 0) {
					for (int i = 0; i < cdActivo.size(); i++) {
						System.out.println(cdActivo.get(i));
					}
				}
				while (true) {
					System.out.println("Introduce el codigo del CD ");
					cdEliminar = introducirNumeroEntero(opcion);// (peliculasSinAlquilar.size()+10000
					if (cdEliminar >= 20000 && cdEliminar < codCd) {
						break;
					} else
						System.out.println("ERROR: Ese codigo no corresponde con ningun CD disponible");
				}

				for (int i = 0; i < cdActivo.size(); i++) {
					if (cdActivo.get(i).getCodproducto() == cdEliminar) {
						System.out.println("El CD " + cdActivo.get(i).getTitulo() + "(ID: "
								+ cdActivo.get(i).getCodproducto() + ") ha sido eliminado");
						cdActivo.remove(i);
						break;
					}
				}

			} else
				System.err.println("ERROR: No hay CD disponibles para eliminar");

		}
	}	
	

	// [04] Ver listado de peliculas
	private static void verlistadoPeliculas(ArrayList<Pelicula> peliculasSinAlquilar,ArrayList<Pelicula> peliculasAlquiladas) {
		System.out.println("[04] Ver listado de peliculas");
		if (peliculasAlquiladas.size() > 0 || peliculasSinAlquilar.size() > 0) {
			if (peliculasAlquiladas.size() > 0) {
				for (int i = 0; i < peliculasAlquiladas.size(); i++) {
					System.out.println(peliculasAlquiladas.get(i));
				}
			}
			if (peliculasSinAlquilar.size() > 0) {
				for (int i = 0; i < peliculasSinAlquilar.size(); i++) {
					System.out.println(peliculasSinAlquilar.get(i));
				}
			}
		} else
			System.err.println("ERROR: No hay ninguna pelicula para poder mostrar");
	}

	// [05] Ver listado de CD's
	private static void verlistadoCDs(ArrayList<Cd> cdActivo) {
		System.out.println("[05] Ver listado de CDs");
		if (cdActivo.size() > 0) {
			if (cdActivo.size() > 0) {
				for (int i = 0; i < cdActivo.size(); i++) {
					System.out.println(cdActivo.get(i));
				}
			}
		} else System.err.println("ERROR: No hay ningun CD para poder mostrar");
	}

	// [06] Alquiler de Peliculas
	private static void alquilarPeliculas(int opcion, ArrayList<Pelicula> peliculasSinAlquilar,
			ArrayList<Pelicula> peliculasAlquiladas) {
		System.out.println("[06] Alquilar pelicula");
		int codigoPeliSeleccionada=0;
		if (peliculasSinAlquilar.size() > 0) {
			for (int i = 0; i < peliculasSinAlquilar.size(); i++) {
				System.out.println(peliculasSinAlquilar.get(i));
			}			
			while (true) {
				System.out.println("Introduce el codigo de la pelicula ");
				codigoPeliSeleccionada = introducirNumeroEntero(opcion);//(peliculasSinAlquilar.size()+10000  HAY QUE MODIFICAR LO QUE HAY EN EL  IF A PARTIR DE <= no sirve con la ultima pelicula
				if (codigoPeliSeleccionada >= 10000 && codigoPeliSeleccionada<codPeli) {
					break;
				}
				else System.out.println("ERROR: Ese codigo no corresponde con ninguna pelicula disponible");
			}
			
			for (int i=0; i<peliculasSinAlquilar.size(); i++) {
				
				if (peliculasSinAlquilar.get(i).getCodproducto()==codigoPeliSeleccionada) {
					switch (peliculasSinAlquilar.get(i).getTipo()) { 
					case 1:
						peliculasSinAlquilar.get(i).setAlquiler(1);
						break;

					case 2:
						peliculasSinAlquilar.get(i).setAlquiler(2);
						break;
						
					case 3:
						peliculasSinAlquilar.get(i).setAlquiler(4);
						break;
					}						
					peliculasAlquiladas.add(peliculasSinAlquilar.get(i));
					System.out.println("La pelicula "+peliculasSinAlquilar.get(i).getTitulo() + "(ID: "+peliculasSinAlquilar.get(i).getCodproducto()+") ha sido alquilada por "+peliculasSinAlquilar.get(i).getAlquiler()+" dias.");
					peliculasSinAlquilar.remove(i);

					break;
				}
				
			}
			
		} else System.err.println("ERROR: No hay ninguna pelicula para poder alquilar");
	}
	

	//[08] Venta de Discos
	private static void venderDisco(int opcion, ArrayList<Cd> cdActivo) {
		int cdVender=0;
		if (cdActivo.size()>0) {
		System.out.println("[08] Vender disco");
		
		for (int i=0; i<cdActivo.size(); i++) {
			System.out.println(cdActivo.get(i));
			}
		while (true) {
			System.out.println("Introduce el codigo del CD ");
			cdVender = introducirNumeroEntero(opcion);//(peliculasSinAlquilar.size()+10000cdActivo.get(cdActivo.size()-1).getCodproducto()
			if (cdVender >= 20000 && cdVender<codCd ) {
				break;
			}
			else System.out.println("ERROR: Ese codigo no corresponde con ningun CD disponible");
		}
		
		for (int i=0; i<cdActivo.size(); i++) {
			
			if (cdVender==cdActivo.get(i).getCodproducto()) {
				
				beneficioventaCD+=cdActivo.get(i).getPrecio();
				beneficioGlobal+=cdActivo.get(i).getPrecio();
				System.out.println("El disco "+cdActivo.get(i).getTitulo()+" (ID: "+cdActivo.get(i).getCodproducto()+") de "+cdActivo.get(i).getAutor()+" se ha vendido por "+cdActivo.get(i).getPrecio()+" euros.");
				cdActivo.remove(i);
			}
			
		}
		
		}else System.out.println("ERROR: No hay CD disponibles para vender");
	}


	// [09] Ver listado de alquiler de peliculas
	private static void verPeliculasenAlquiler(ArrayList<Pelicula> peliculasAlquiladas) {
		System.out.println("[09] Ver Peliculas en alquiler");		
		if (peliculasAlquiladas.size() > 0) {
			for (int i = 0; i < peliculasAlquiladas.size(); i++) {
				System.out.println(peliculasAlquiladas.get(i)+" | Tiempo restante: "+peliculasAlquiladas.get(i).getAlquiler());
			}
		} else System.err.println("ERROR: No hay ninguna pelicula en alquiler para poder mostrar");
	}

	
	// [12] Ver las ganancias por alquiler de peliculas, por venta de discord y global
	private static void verGanancias() {
		beneficioalquilerPelicula=Math.round(beneficioalquilerPelicula*100.0)/100.0;
		beneficioventaCD=Math.round(beneficioventaCD*100.0)/100.0;
		beneficioGlobal=Math.round(beneficioGlobal*100.0)/100.0;
		System.out.println("[12] Ver ganancias");
		System.out.println("[$] Ganancias por alquiler de Peliculas: "+beneficioalquilerPelicula);
		System.out.println("[$] Ganancias por venta de Discos: "+beneficioventaCD);
		System.out.println("[$$]Ganancias globales (Alquiler de Peliculas + Ventas de Discos): "+beneficioGlobal);
	}


	// [13] Calculo de Beneficios de Alquiler de Pelicula
	private static void calculoDeBeneficios(ArrayList<Pelicula> peliculasSinAlquilar,
			ArrayList<Pelicula> peliculasAlquiladas) {
		for (int i = 0; i < peliculasAlquiladas.size(); i++) { 
			peliculasAlquiladas.get(i).setAlquiler(peliculasAlquiladas.get(i).getAlquiler() - 1);
			switch (peliculasAlquiladas.get(i).getTipo()) {
			case 1:
				beneficioalquilerPelicula += 3;
				beneficioGlobal += 3;
				break;

			case 2:
				beneficioalquilerPelicula += 2;
				beneficioGlobal += 2;
				break;

			case 3:
				beneficioalquilerPelicula += 1;
				beneficioGlobal += 1;
				break;
			}
		if (peliculasAlquiladas.get(i).getAlquiler() == 0) {
			System.out.println("La Pelicula "+peliculasAlquiladas.get(i).getTitulo() +"(ID: "+peliculasAlquiladas.get(i).getCodproducto()+") ha dejado de estar en alquiler");
			peliculasSinAlquilar.add(peliculasAlquiladas.get(i));
			peliculasAlquiladas.remove(i);
			i--;
			}							
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