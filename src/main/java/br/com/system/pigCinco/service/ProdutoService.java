package br.com.system.pigCinco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.system.pigCinco.domain.Produto;
import br.com.system.pigCinco.repository.ProdutoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repoProduto;
	
	public List<Produto> buscarTodosProdutos(){
		return repoProduto.findAll();
	}
	
	public Produto salvar (Produto produto) {
		return repoProduto.save(produto);
	}
	
	
	public Produto buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Produto> produto = repoProduto.findById(id);
		return produto.orElseThrow(() -> new ObjectNotFoundException("Produto não encontrado. id: " +id));
		
	}
	
	public Produto salvarAlteracao(Produto produtoAlterado) throws ObjectNotFoundException{
		Produto produto = buscaPorID(produtoAlterado.getProduto_id());
		produto.setProduto_id(produtoAlterado.getProduto_id());
		produto.setProduto_descricao(produtoAlterado.getProduto_descricao());
		produto.setProduto_status(produtoAlterado.getProduto_status());
		return salvar(produto);
	}
	
	public void excluir (Integer id) {
		repoProduto.deleteById(id);
	}

}
