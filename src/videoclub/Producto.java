package videoclub;

public class Producto {

	//---------Atributos--------//
	
	private int codproducto=0;
	private String titulo="";

	
	//---------Metodos----------//
	
	//------Constructores-------//

	public Producto(int codproducto, String titulo) {
		super();
		this.codproducto = codproducto;
		this.titulo = titulo;
	}	
	
	public Producto() {
		super();
	}

	//----Setters && Getters----//
	
	public int getCodproducto() {
		return codproducto;
	}

	public void setCodproducto(int codproducto) {
		this.codproducto = codproducto;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}	
	
}
