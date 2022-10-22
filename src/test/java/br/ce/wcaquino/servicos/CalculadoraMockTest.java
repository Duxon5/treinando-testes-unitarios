package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class CalculadoraMockTest {

	@Mock
	private Calculadora calcMock;
	
	@Spy
	private Calculadora calcSpy;
	
	@Spy
	private EmailService email;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void devoMostrarDiferencaEntreMockSpy() {
		
//		Mockito.when(calcMock.somar(1, 2)).thenReturn(5); // Se não quiser o retorno do método
//		Mockito.when(calcMock.somar(1, 2)).thenCallRealMethod(); // Se quiser o retorno do método
		
//		Mockito.when(calcSpy.somar(1, 2)).thenReturn(5); // Se quiser o retorno do método
//		Mockito.doNothing().when(calcSpy).imprime(); // Se não quiser o retorno do método
		Mockito.doReturn(5).when(calcSpy).somar(1, 2); // Se quiser o retorno do método e não quer o conteúdo da execução
		
		// O Mock quando não sabe oq fazer retorna 0
		System.out.println("calcMock: "+calcMock.somar(1, 2));
		// O Spy quando não sabe oq fazer retorna o retorno do método
		System.out.println("calcSpy: "+calcSpy.somar(1, 2));
		
		System.out.println("Mock");
		calcMock.imprime();
		System.out.println("Spy");
		calcSpy.imprime();
	}
	
	@Test
	public void teste1() {
		Calculadora calc = Mockito.mock(Calculadora.class);
		// Força que se somar 1 + 2 retorna 5
		Mockito.when(calc.somar(1, 2)).thenReturn(5);
		// Força que se somar int + int retorna 5
		Mockito.when(calc.somar(Mockito.anyInt(), Mockito.anyInt())).thenReturn(5);
		
		// Dá erro, pois se 1 parametro for matcher, então todos devem ser
//		Mockito.when(calc.somar(1, Mockito.anyInt())).thenReturn(5);
		// Força que se for passado 1 + int, então retorna 5
		Mockito.when(calc.somar(Mockito.eq(1), Mockito.anyInt())).thenReturn(5);
				
	}
	
	@Test
	public void teste2() {
		Calculadora calc = Mockito.mock(Calculadora.class);

		ArgumentCaptor<Integer> argCapt = ArgumentCaptor.forClass(Integer.class);
		Mockito.when(calc.somar(argCapt.capture(), argCapt.capture())).thenReturn(5);
		
		
		Assert.assertEquals(5, calc.somar(1, 100000));
//		System.out.println(argCapt.getAllValues());
		
				
	}
	
}
