package videoclub;

public class Pelicula extends Producto{

	//---------Atributos--------//
	
	private int alquiler=0;
	private int tipo=0;
	private Cliente clientealquiler=new Cliente();
	
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
	
	public int getAlquiler() {
		return alquiler;
	}

	public void setAlquiler(int alquiler) {
		this.alquiler = alquiler;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public Cliente getClientealquiler() {
		return clientealquiler;
	}

	public void setClientealquiler(Cliente clientealquiler) {
		this.clientealquiler = clientealquiler;
	}
	
}
