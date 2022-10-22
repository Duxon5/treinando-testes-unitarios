package br.ce.wcaquino.servicos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.wcaquino.exceptions.NaoPodeDividirPorZeroException;

//@RunWith(ParallelRunner.class)
public class CalculadoraTest {
	
	// é thread safe
	public static StringBuffer ordem = new StringBuffer();

	private Calculadora calc;
	
	@Before
	public void setup() {
		calc = new Calculadora();
		System.out.println("iniciando 1...");
		ordem.append("1");
	}
	
	@After
	public void tearDown() {
		System.out.println("finalizando 1...");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println(ordem.toString());
	}
	
	@Test
	public void deveSomarDoisValores() {
		
		// cenario
		int a = 5;
		int b = 3;
		calc = new Calculadora();
		
		// ação
		int resultado = calc.somar(a, b);
		
		// verificação
		Assert.assertEquals(8, resultado);
		
	}
	
	@Test
	public void deveSubtrairDoisValores() {
		
		int a = 8;
		int b = 5;
		calc = new Calculadora();
		
		int resultado = calc.subtrair(a, b);
		
		Assert.assertEquals(3, resultado);
		
	}
	
	@Test
	public void deveDividirDoisValores() throws NaoPodeDividirPorZeroException {
		
		int a = 6;
		int b = 3;
		calc = new Calculadora();
		
		int resultado = calc.dividir(a, b);
		
		Assert.assertEquals(2, resultado);
		
	}
	
	@Test(expected = NaoPodeDividirPorZeroException.class)
	public void deveLancarExcecaoAoDividirPorZero() throws NaoPodeDividirPorZeroException {
		
		int a = 10;
		int b = 0;
		calc = new Calculadora();
		
		calc.dividir(a, b);
		
		
	}
	
	@Test
	public void deveDivir() {
		String a = "6";
		String b = "3";
	
		int resultado = calc.dividir(a, b);
		
		Assert.assertEquals(2,  resultado);
		
	}
	
	
}
