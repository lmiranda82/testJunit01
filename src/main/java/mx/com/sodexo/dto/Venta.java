package mx.com.sodexo.dto;

public class Venta {

	private double importeVenta;
	private char tipoVenta;
	
	
	
	public Venta(double importeVenta, char tipoVenta) {
		super();
		this.importeVenta = importeVenta;
		this.tipoVenta = tipoVenta;
	}
	
	public double getImporteVenta() {
		return importeVenta;
	}
	public void setImporteVenta(double importeVenta) {
		this.importeVenta = importeVenta;
	}
	public char getTipoVenta() {
		return tipoVenta;
	}
	public void setTipoVenta(char tipoVenta) {
		this.tipoVenta = tipoVenta;
	}
	
	
}
