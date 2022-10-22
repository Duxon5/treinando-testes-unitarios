package br.ce.wcaquino.servicos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import br.ce.wcaquino.builders.FilmeBuilder;
import br.ce.wcaquino.builders.LocacaoBuilder;
import br.ce.wcaquino.builders.UsuarioBuilder;
import br.ce.wcaquino.daos.LocacaoDAO;
import br.ce.wcaquino.entidades.Filme;
import br.ce.wcaquino.entidades.Locacao;
import br.ce.wcaquino.entidades.Usuario;
import br.ce.wcaquino.exceptions.FilmeSemEstoqueException;
import br.ce.wcaquino.exceptions.LocadoraException;
import br.ce.wcaquino.matchers.MatchersProprios;
import br.ce.wcaquino.runners.ParallelRunner;
import br.ce.wcaquino.utils.DataUtils;

//@RunWith(ParallelRunner.class)
public class LocacaoServiceTest {

	@InjectMocks @Spy
	LocacaoService service;
	@Mock
	private LocacaoDAO dao;
	@Mock
	private SPCService spc;
	@Mock
	private EmailService email;
	
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	// Executa antes de cada método
	@Before
	public void setup_aula11() {
		MockitoAnnotations.initMocks(this);
		System.out.println("iniciando 2...");
		CalculadoraTest.ordem.append("2");
	}
	
	@After
	public void tearDown() {
		System.out.println("finalizando 2...");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println(CalculadoraTest.ordem.toString());
	}
	
	// Executa depois de cada método
	/*@After
	public void tearDown_aula11() {
		System.out.println("After");
	}*/
	
	// Executa antes de cada classe
	/*@BeforeClass
	public static void setupClass_aula11() {
		System.out.println("Before Class");
	}*/
	
	// Executa depois de cada classe
	/*@AfterClass
	public static void tearDownClass_aula11() {
		System.out.println("After Class: " + contador);
	}*/
	
	/*static int contador = 0;*/
	
	/*@Test
	public void testLocacaoAula5() {
		// cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);
		
		// ação
		
		Locacao locacao = service.alugarFilme(usuario, filme);

		Assert.assertTrue(locacao.getValor() == 5.0);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	}*/
	
	/*@Test
	public void testLocacaoAula6() {
		// cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);
		
		// ação
		
		Locacao locacao = service.alugarFilme(usuario, filme);

		Assert.assertEquals(5.0, locacao.getValor(), 0.01);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	}*/
	
	/*@Test
	public void testLocacaoAula7() {
		// cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);
		
		// ação
		
		Locacao locacao = service.alugarFilme(usuario, filme);

		Assert.assertThat(locacao.getValor(), is(equalTo(5.0)));
		Assert.assertThat(locacao.getValor(), is(not(equalTo(6.0))));
		Assert.assertThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
		Assert.assertThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(true));
	}*/
	
	// Comentado, pois gera erros (proposital)
	/*@Test 
	public void testLocacaoAula8() {
		// cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 2, 5.0);
		
		// ação
		
		Locacao locacao = service.alugarFilme(usuario, filme);

		error.checkThat(locacao.getValor(), is(equalTo(6.0)));
		error.checkThat(locacao.getValor(), is(not(equalTo(5.0))));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(false));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)), is(false));
	}*/
	
	/*@Test
	public void testLocacaoAula9() throws Exception {
		// cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 0, 5.0);
		
		// ação
		
		Locacao locacao;
		locacao = service.alugarFilme(usuario, filme);

		Assert.assertTrue(locacao.getValor() == 5.0);
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
		Assert.assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
	}*/
	
	/*@Test(expected=Exception.class)
	public void testLocacaoAula9_filmeSemEstoque() throws Exception {
		// cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 0, 5.0);
		
		// ação
		Locacao locacao;
		locacao = service.alugarFilme(usuario, filme);
	}*/
	
	/*@Test
	public void testLocacaoAula9_filmeSemEstoque2() {
		// cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 0, 5.0);
		
		// ação
		Locacao locacao;
		try {
			locacao = service.alugarFilme(usuario, filme);
			Assert.fail("Deveria ter lançado uma exceção");
		} catch (Exception e) {
			assertThat(e.getMessage(), is("Filme sem estoque"));
		}
	}*/
	
	/*@Test
	public void testLocacaoAula9_filmeSemEstoque3() throws Exception {
		// cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 0, 5.0);
		
		exception.expect(Exception.class);
		exception.expectMessage("Filme sem estoque");
		
		// ação
		service.alugarFilme(usuario, filme);
	}*/
	
	// Forma Elegante
	/*@Test(expected=FilmeSemEstoqueException.class)
	public void testLocacaoAula10_filmeSemEstoque() throws Exception {
		// cenário
		LocacaoService service = new LocacaoService();
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 0, 5.0);
		
		// ação
		Locacao locacao;
		locacao = service.alugarFilme(usuario, filme);
	}*/
	
	// Forma Robusta
	/*@Test
	public void testLocacaoAula10_usuarioVazio() throws FilmeSemEstoqueException {
		// cenário
		Usuario usuario = new Usuario("Usuario 1");
		Filme filme = new Filme("Filme 1", 1, 5.0);
		
		// ação
		try {
			service.alugarFilme(null, filme);
			Assert.fail();
		} catch (LocadoraException e) {
			Assert.assertThat(e.getMessage(), is("Usuario vazio"));
		}
	}*/
	
	// Forma Nova
	/*@Test
	public void testLocacaoAula10_filmeVazio() throws FilmeSemEstoqueException, LocadoraException {
		// cenário
		Usuario usuario = new Usuario("Usuario 1");
		
		exception.expect(LocadoraException.class);
		exception.expectMessage("Filme vazio");
		
		// ação
		service.alugarFilme(usuario, null);
	}*/
	
	// Comentado, pois gera erros (proposital)
	@Test 
	public void deveAlugarFilme() throws Exception {
		
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filmes = Arrays.asList(FilmeBuilder.umFilme().comValor(5.0).agora());
		
		Mockito.doReturn(DataUtils.obterData(28, 4, 2017)).when(service).obterData();
		
		// ação
		Locacao locacao = service.alugarFilme(usuario, filmes);

		error.checkThat(locacao.getValor(), is(equalTo(5.0)));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataLocacao(), DataUtils.obterData(28, 4, 2017)), is(true));
		error.checkThat(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterData(29, 4, 2017)), is(true));
	}
	
	@Test(expected = FilmeSemEstoqueException.class)
	public void naoDeveAlugarFilmeSemEstoque() throws FilmeSemEstoqueException, LocadoraException {
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Filme filme1 = FilmeBuilder.umFilmeSemEstoque().agora();
		Filme filme2 = FilmeBuilder.umFilmeSemEstoque().agora();
		Filme filme3 = FilmeBuilder.umFilmeSemEstoque().agora();
		
		List<Filme> filmes = new ArrayList<Filme>(Arrays.asList(filme1, filme2, filme3));
		
		// ação
		service.alugarFilme(usuario, filmes);
	}
	
	@Test
	public void naoDeveAlugarFilmeSemUsuario() throws FilmeSemEstoqueException {
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Filme filme1 = FilmeBuilder.umFilme().agora();
		Filme filme2 = FilmeBuilder.umFilme().agora();
		Filme filme3 = FilmeBuilder.umFilme().agora();
		
		List<Filme> filmes = new ArrayList<Filme>(Arrays.asList(filme1, filme2, filme3));
		
		// ação
		try {
			service.alugarFilme(null, filmes);
		} catch (LocadoraException e) {
			assertThat(e.getMessage(), is("Usuario vazio"));
		}
	}
	
	@Test
	public void naoDeveAlugarFilmeSemFilme() throws FilmeSemEstoqueException, LocadoraException {
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		
		exception.expect(LocadoraException.class);
		exception.expectMessage("Filme vazio");
		
		// ação
		service.alugarFilme(usuario, null);
	}
	
	@Test
	public void devePagar75PctNoFilme3() throws FilmeSemEstoqueException, LocadoraException {
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		
		Filme filme1 = FilmeBuilder.umFilme().agora();
		Filme filme2 = FilmeBuilder.umFilme().agora();
		Filme filme3 = FilmeBuilder.umFilme().agora();
		
		List<Filme> filmes = new ArrayList<Filme>(Arrays.asList(filme1, filme2, filme3));
		
		Locacao resultado = service.alugarFilme(usuario, filmes);
		
		assertThat(resultado.getValor(), is(11.0));
	}
	
	@Test
	public void devePagar50PctNoFilme4() throws FilmeSemEstoqueException, LocadoraException {
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		
		Filme filme1 = FilmeBuilder.umFilme().agora();
		Filme filme2 = FilmeBuilder.umFilme().agora();
		Filme filme3 = FilmeBuilder.umFilme().agora();
		Filme filme4 = FilmeBuilder.umFilme().agora();
		
		List<Filme> filmes = new ArrayList<Filme>(Arrays.asList(filme1, filme2, filme3, filme4));
		
		Locacao resultado = service.alugarFilme(usuario, filmes);
		
		assertThat(resultado.getValor(), is(13.0));
	}
	
	@Test
	public void devePagar75PctNoFilme5() throws FilmeSemEstoqueException, LocadoraException {
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		
		Filme filme1 = FilmeBuilder.umFilme().agora();
		Filme filme2 = FilmeBuilder.umFilme().agora();
		Filme filme3 = FilmeBuilder.umFilme().agora();
		Filme filme4 = FilmeBuilder.umFilme().agora();
		Filme filme5 = FilmeBuilder.umFilme().agora();
		
		List<Filme> filmes = new ArrayList<Filme>(Arrays.asList(filme1, filme2, filme3, filme4, filme5));
		
		Locacao resultado = service.alugarFilme(usuario, filmes);
		
		assertThat(resultado.getValor(), is(14.0));
	}
	
	@Test
	public void devePagar100PctNoFilme6() throws FilmeSemEstoqueException, LocadoraException {
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		
		Filme filme1 = FilmeBuilder.umFilme().agora();
		Filme filme2 = FilmeBuilder.umFilme().agora();
		Filme filme3 = FilmeBuilder.umFilme().agora();
		Filme filme4 = FilmeBuilder.umFilme().agora();
		Filme filme5 = FilmeBuilder.umFilme().agora();
		Filme filme6 = FilmeBuilder.umFilme().agora();
		
		List<Filme> filmes = new ArrayList<Filme>(Arrays.asList(filme1, filme2, filme3, filme4, filme5, filme6));
		
		Locacao resultado = service.alugarFilme(usuario, filmes);
		
		assertThat(resultado.getValor(), is(14.0));
	}
	
	@Test
	public void deveDevolverNaSegundaAoAlugarNoSabado() throws Exception {
		
		// cenário
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		
		Filme filme1 = FilmeBuilder.umFilme().agora();
		List<Filme> filmes = new ArrayList<Filme>(Arrays.asList(filme1));
		
		// Data informada é sabado
		Mockito.doReturn(DataUtils.obterData(29, 4, 2017)).when(service).obterData();
		
		Locacao retorno = service.alugarFilme(usuario,  filmes);
		
		assertThat(retorno.getDataRetorno(), MatchersProprios.caiNumaSegunda());
	}
	
	@Test
	public void naoDeveAlugarFilmeParaNegativadoSPC() throws Exception {
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		
		List<Filme> filmes = Arrays.asList(FilmeBuilder.umFilme().agora());
		
		// Específico
//		Mockito.when(spc.possuiNegativacao(usuario)).thenReturn(true);
		// Genérico
		Mockito.when(spc.possuiNegativacao(Mockito.any(Usuario.class))).thenReturn(true);
		
		try {
			service.alugarFilme(usuario, filmes);
			//verificacao
			Assert.fail();
		} catch (LocadoraException e) {
			Assert.assertThat(e.getMessage(), is("Usuario Negativado"));
		}
		
		// verificacao
		Mockito.verify(spc).possuiNegativacao(usuario);
	}
	
	@Test
	public void deveEnviarEmailParaLocacoesAtrasadas() {
		
		// cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		Usuario usuario2 = UsuarioBuilder.umUsuario().comNome("Usuario em dia").agora();
		Usuario usuario3 = UsuarioBuilder.umUsuario().comNome("Outro atrasado").agora();
		List<Locacao> locacoes = Arrays.asList(
				LocacaoBuilder.umLocacao().atrasada().comUsuario(usuario).agora(),
				LocacaoBuilder.umLocacao().comUsuario(usuario2).agora(),
				LocacaoBuilder.umLocacao().atrasada().comUsuario(usuario3).agora(),
				LocacaoBuilder.umLocacao().atrasada().comUsuario(usuario3).agora()
				);
		
		Mockito.when(dao.obterLocacoesPendentes()).thenReturn(locacoes);

		// acao
		service.notificarAtrasos();
		
		// verificacao
		// Checa se foi executado ao menos 2 verificações no método passando Usuario
		Mockito.verify(email, Mockito.times(3)).notificarAtraso(Mockito.any(Usuario.class));
		// Checa se enviou email para os atrasados
		Mockito.verify(email).notificarAtraso(usuario);
		// Checa se recebeu o email 2x
//		Mockito.verify(email, Mockito.times(2)).notificarAtraso(usuario3);
		Mockito.verify(email, Mockito.atLeastOnce()).notificarAtraso(usuario3);
		
		// Checa se NÃO enviou email para quem não está atrasado
		Mockito.verify(email, Mockito.never()).notificarAtraso(usuario2);
		
		// Checa se não foi enviado mais emails
		Mockito.verifyNoMoreInteractions(email);
		
		// Não faz sentido neste escopo
		//Mockito.verifyZeroInteractions(spc);
	}
	
	@Test
	public void deveTratarErronoSPC() throws Exception {
		// cenario
		Usuario usuario = UsuarioBuilder.umUsuario().agora();
		List<Filme> filmes = Arrays.asList(FilmeBuilder.umFilme().agora());

		Mockito.when(spc.possuiNegativacao(usuario)).thenThrow(new Exception("Falha catastrófica"));
		
		// verificacao
		exception.expect(LocadoraException.class);
		exception.expectMessage("Problemas com SPC, tente novamente");
		
		// acao
		service.alugarFilme(usuario, filmes);
	}
	
	@Test
	public void deveProrrogarUmaLocacao() {
		// cenario
		Locacao locacao = LocacaoBuilder.umLocacao().agora();
		
		// acao
		service.prorrogarLocacao(locacao, 3);
		
		// verificacao
		// Resgata o objeto que foi passado dentro do método prorrogarLocacao
		ArgumentCaptor<Locacao> argCapt = ArgumentCaptor.forClass(Locacao.class);
		Mockito.verify(dao).salvar(argCapt.capture());
		Locacao locacaoRetornada = argCapt.getValue();
		
		error.checkThat(locacaoRetornada.getValor(), is(12.0));
		error.checkThat(locacaoRetornada.getDataLocacao(), MatchersProprios.ehHoje());
		error.checkThat(locacaoRetornada.getDataRetorno(), MatchersProprios.ehHojeComDiferencaDias(3));
	}
	
	@Test
	public void deveCalcularValorLocaca() throws Exception {
		// cenario
		List<Filme> filmes = Arrays.asList(FilmeBuilder.umFilme().agora(), FilmeBuilder.umFilme().agora());
				
		// acao
		Class<LocacaoService> classe = LocacaoService.class;
		Method metodo = classe.getDeclaredMethod("calcularValorLocacao", List.class);
		metodo.setAccessible(true);
		Double valor = (Double) metodo.invoke(service, filmes);
		
		// verificacao
		Assert.assertThat(valor, is(8.0));
		
	}
	
	/*public static void main(String[] args) {
		new BuilderMaster().gerarCodigoClasse(Locacao.class);
	}*/
	
}
