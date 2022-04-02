package videoclub;

public class Pelicula extends Producto{

	//---------Atributos--------//
	
	private boolean alquiler=false;
	private int tipo=0;

	
	//---------Metodos----------//
	
	@Override
	public String toString() {
		String tipoPeli="";
		switch (this.tipo) {
		case 1:
			tipoPeli="Novedad";
			break;
		case 2:
			tipoPeli="Semi-Novedad";
			break;
		case 3:
			tipoPeli="Antigua";
			break;
		}
		return "Pelicula | CodPeli:"+this.getCodproducto()+" | Titulo: "+this.getTitulo()+" | Tipo: "+tipoPeli;
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
