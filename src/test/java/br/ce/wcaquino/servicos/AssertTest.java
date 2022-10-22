package br.ce.wcaquino.servicos;

import org.junit.Assert;
import org.junit.Test;

import br.ce.wcaquino.entidades.Usuario;


public class AssertTest {

	@Test
	public void testandoAssertAula6() {
		Assert.assertTrue(true);
		Assert.assertFalse(false);
		
		Assert.assertEquals(1, 1);
//		Assert.assertEquals("Msg de erro", 1, 2);
		Assert.assertEquals(0.51234, 0.512, 0.01);
		Assert.assertEquals(Math.PI, 3.14, 0.01);
		
		int i = 5;
		Integer i2 = 5;
		Assert.assertEquals(Integer.valueOf(i), i2);
		Assert.assertEquals(i, i2.intValue());
		
		Assert.assertEquals("bola", "bola");
		Assert.assertTrue("bola".equalsIgnoreCase("Bola"));
		Assert.assertTrue("bola".startsWith("bo"));
		
		Assert.assertNotEquals("bola", "casa");
		
		Usuario u1 = new Usuario("Usuario 1");
		Usuario u2 = new Usuario("Usuario 1");
		Usuario u3 = u2;
		Usuario u4 = null;
		
		Assert.assertEquals(u1, u1);
		Assert.assertEquals(u1, u2);
		
		Assert.assertSame(u1, u1); // Olha também se é a mesma instância
		Assert.assertSame(u2, u3); // Olha também se é a mesma instância
		
		Assert.assertNotSame(u1, u2);
		
		Assert.assertTrue(u4 == null);
		Assert.assertNull(u4);
		Assert.assertNotNull(u2);
	}
	
}
