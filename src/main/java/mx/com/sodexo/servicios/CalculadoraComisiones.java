package mx.com.sodexo.servicios;

import mx.com.sodexo.dto.Venta;

public class CalculadoraComisiones {

	//Solamente debe dar comision a ventas superiores al importe minimo
	private final double importeMinimo = 1000;
	
	//Aplica a venta nomarles: tipo 'N'
	private final double porcComisionNormal = 5;
	
	//Aplica a venta extraordinaria: tipo 'X'
	private final double porcComisionExtraodrinario = 10;
	
	
	
	public double getImporteMinimo() {
		return importeMinimo;
	}



	public double getPorcComisionNormal() {
		return porcComisionNormal;
	}



	public double getPorcComisionExtraodrinario() {
		return porcComisionExtraodrinario;
	}



	public double calcularComision(double importeVenta, char tipoVenta) {
	
		tipoVenta = Character.toUpperCase(tipoVenta);
		
		if(importeVenta <= 0) {
			return -2;
		}
		if(importeVenta <= this.importeMinimo)
			return 0;
		if(tipoVenta == 'N') {
			return importeVenta * this.porcComisionNormal / 100;
		}
		if(tipoVenta == 'X') {
			return importeVenta * this.porcComisionExtraodrinario / 100;
		}
		if(tipoVenta == 'n' || tipoVenta == 'x') {
			return -3;
		}
		return -1;
	}
	
	
	public double calcularComision(Venta venta) {
		return this.calcularComision(venta.getImporteVenta(), venta.getTipoVenta());
	}

	/*
	 * Escenarios a validar
	 * 1.- un importe de venta menor o igual al importe minimo
	 * 2.- un importe de venta mayor que el importe minimo
	 * 3.- un importe de venta(tipo ''<X) extraordinario > importe minimo
	 * 4.- Tipo de Venta inexistente
	 * 5.- Tipo de Venta Con 'n' (Minuscula)
	 * 6.- Tipo de Venta Con 'x' (Minuscula)
	 * 7.-importe 0 menor
	 * */
}
