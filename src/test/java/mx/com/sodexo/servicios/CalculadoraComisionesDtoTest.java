package mx.com.sodexo.servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import mx.com.sodexo.dto.Venta;

public class CalculadoraComisionesDtoTest {
	
	@Test
	public void testCalcularComision_ventaDebajoMinimo() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		Venta venta = new Venta(calculadora.getImporteMinimo() - 1, 'N');
		
		//entonces
		double comision = calculadora.calcularComision(venta);
		
		//validar
		assertEquals(comision, 0);
	}
	
	@Test
	public void testCalcularVtaNormalImpMayorQMin() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();	
		Venta venta = new Venta(calculadora.getImporteMinimo() * 2 , 'N');
		
		//entonces
		double comision = calculadora.calcularComision(venta);
		
		//validar
		assertEquals(comision, 100);
					
	}
	
	@Test
	public void testCalcularVentaExtraMayorQMin() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		Venta venta = new Venta(calculadora.getImporteMinimo() * 2 , 'X');
				
		//entonces
		double comision = calculadora.calcularComision(venta);
				
		//validar
		assertEquals(comision, 200);		
	}
	
	@Test
	public void testTipoVentaInexistente() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		Venta venta = new Venta(calculadora.getImporteMinimo() * 2 , 'T');
				
		//entonces
		double comision = calculadora.calcularComision(venta);
				
		//validar
		assertEquals(comision, -1);
		
	}
	
	@Test
	public void testTipoVentaMinisculaN() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		Venta venta = new Venta(calculadora.getImporteMinimo() * 2 , 'n');
				
		//entonces
		double comision = calculadora.calcularComision(venta);
				
		//validar
		//assertEquals(comision, -3);
		assertEquals(comision, 100);
		
	}
	
	@Test
	public void testTipoVentaMinisculaX() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		Venta venta = new Venta(calculadora.getImporteMinimo() * 2 , 'x');
				
		//entonces
		double comision = calculadora.calcularComision(venta);
				
		//validar
		//assertEquals(comision, -3);
		assertEquals(comision, 200);
		
	}
	
	@Test
	public void testImporteNenorACero() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		Venta venta = new Venta(calculadora.getImporteMinimo() * 0 , 'N');
				
		//entonces
		double comision = calculadora.calcularComision(venta);
				
		//validar
		assertEquals(comision, -2);
		
	}

}
