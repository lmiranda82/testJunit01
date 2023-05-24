package mx.com.sodexo.servicios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CalculadoraComisionesTest {

	@Test
	public void testCalcularComision_ventaDebajoMinimo() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		double importeMenorQueMinimo = calculadora.getImporteMinimo() - 1 ;
		char tipoVenta = 'N';
		
		//entonces
		double comision = calculadora.calcularComision(importeMenorQueMinimo, tipoVenta);
		
		//validar
		assertEquals(comision, 0);
	}
	
	@Test
	public void testCalcularVtaNormalImpMayorQMin() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		double importeMayor = calculadora.getImporteMinimo() * 2 ;
		char tipoVenta = 'N';
		
		//entonces
		double comision = calculadora.calcularComision(importeMayor, tipoVenta);
		
		//validar
		assertEquals(comision, 100);
					
	}
	
	@Test
	public void testCalcularVentaExtraMayorQMin() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		double importeMayor = calculadora.getImporteMinimo() * 2 ;
		char tipoVenta = 'X';
				
		//entonces
		double comision = calculadora.calcularComision(importeMayor, tipoVenta);
				
		//validar
		assertEquals(comision, 200);		
	}
	
	@Test
	public void testTipoVentaInexistente() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		double importeMayor = calculadora.getImporteMinimo() * 2 ;
		char tipoVenta = 'T';
				
		//entonces
		double comision = calculadora.calcularComision(importeMayor, tipoVenta);
				
		//validar
		assertEquals(comision, -1);
		
	}
	
	@Test
	public void testTipoVentaMinisculaN() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		double importeMayor = calculadora.getImporteMinimo() * 2 ;
		char tipoVenta = 'n';
				
		//entonces
		double comision = calculadora.calcularComision(importeMayor, tipoVenta);
				
		//validar
		//assertEquals(comision, -3);
		assertEquals(comision, 100);
		
	}
	
	@Test
	public void testTipoVentaMinisculaX() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		double importeMayor = calculadora.getImporteMinimo() * 2 ;
		char tipoVenta = 'x';
				
		//entonces
		double comision = calculadora.calcularComision(importeMayor, tipoVenta);
				
		//validar
		//assertEquals(comision, -3);
		assertEquals(comision, 200);
		
	}
	
	@Test
	public void testImporteNenorACero() {
		//Dados
		CalculadoraComisiones calculadora = new CalculadoraComisiones();
		double importeMayor = calculadora.getImporteMinimo() * 0 ;
		char tipoVenta = 'N';
				
		//entonces
		double comision = calculadora.calcularComision(importeMayor, tipoVenta);
				
		//validar
		assertEquals(comision, -2);
		
	}
	
}
