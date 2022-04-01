package videoclub;

public class Pelicula extends Producto{

	//---------Atributos--------//
	
	private boolean alquiler=false;
	private int tipo=0;

	
	//---------Metodos----------//
	
	@Override
	public String toString() {
		return "Pelicula [codpelicula= "+this.getCodproducto()+"titulo=" + this.getTipo()+ ", tipo=" + tipo + "]";
	}	
	
	//------Constructores-------//
	
	public Pelicula(int codproducto, String titulo, int tipo) {
		super(codproducto, titulo);
		this.tipo = tipo;
	}	
	
	
	public Pelicula() {
		super();
	}

	//----Setters && Getters----//
	
	public boolean isAlquiler() {
		return alquiler;
	}

	public void setAlquiler(boolean alquiler) {
		this.alquiler = alquiler;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
}
