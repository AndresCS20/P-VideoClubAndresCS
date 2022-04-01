package videoclub;

public class Cd  extends Producto {

	//---------Atributos--------//
	
	private String autor="";
	private double precio=0.0;

	
	
	//---------Metodos----------//
	
	@Override
	public String toString() {
		return "CD | CodCD:"+this.getCodproducto()+" | Titulo: "+this.getTitulo()+" | Grupo/Cantante: "+autor+" | Precio: "+precio;
	}
	
	//------Constructores-------//

	public Cd(int codproducto, String titulo, String autor, double precio) {
		super(codproducto, titulo);
		this.autor = autor;
		this.precio = precio;
	}
	
	//----Setters && Getters----//
	
	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	
}
