package br.com.system.pigCinco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.system.pigCinco.domain.Produto;
import br.com.system.pigCinco.service.ProdutoService;
import javassist.tools.rmi.ObjectNotFoundException;

@Controller
@RequestMapping("produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/listarProdutos")
	public ModelAndView listaTodosProdutos() {
		ModelAndView mv = new ModelAndView("produto/paginaListaProdutos");
		mv.addObject("produtos", produtoService.buscarTodosProdutos());
		return mv;
	}
	
	@GetMapping("/cadastar")
	public ModelAndView cadastrarProdutos() {
		ModelAndView mv = new ModelAndView ("produto/cadastroProduto");
		mv.addObject("produto", new Produto());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarProduto(Produto produto) {
		produtoService.salvar(produto);
		return listaTodosProdutos();
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterarProduto(@PathVariable ("id")Integer idProduto) throws ObjectNotFoundException{
		ModelAndView mv = new ModelAndView("produto/alteraProduto");
		mv.addObject("produto", produtoService.buscaPorID(idProduto));
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Produto produtoAlterado) throws ObjectNotFoundException{
		produtoService.salvarAlteracao(produtoAlterado);
		return listaTodosProdutos();
	}
	
	@GetMapping("/excluir/{id}")
	public ModelAndView excluirProduto(@PathVariable ("id")Integer id) {
		produtoService.excluir(id);
		return listaTodosProdutos();
	}

}
