package videoclub;
import java.util.ArrayList;
import java.util.Scanner;
public class Cliente {

	//---------Atributos--------//	
	private int idCliente=0;
	private String nombre="";
	private String apellido="";
	private ArrayList<Pelicula>peliculasAlquiladas=new ArrayList();

	//---------Metodos----------//
	
	@Override
	public String toString() {
		return "Cliente [id="+idCliente+" nombre=" + nombre + ", apellido=" + apellido + "]";
	}	
	
	public  void intrducirCliente(int codCliente) {
		Scanner scString=new Scanner(System.in);
		
		System.out.println("Introduce el nombre del cliente");
		this.nombre=scString.nextLine();
		System.out.println("Introduce el o los apellidos del cliente");
		this.apellido=scString.nextLine();
		this.idCliente=codCliente;
	}
	
	//------Constructores-------//

	public Cliente(String nombre, String apellido) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
	}
	
	public Cliente() {
		super();
	}	
	//----Setters && Getters----//
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public ArrayList<Pelicula> getPeliculasAlquiladas() {
		return peliculasAlquiladas;
	}
	public void setPeliculasAlquiladas(ArrayList<Pelicula> peliculasAlquiladas) {
		this.peliculasAlquiladas = peliculasAlquiladas;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
}
