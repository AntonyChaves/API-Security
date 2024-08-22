package com.TestePratico.XP.Service;

import com.TestePratico.XP.Enum.ResultadoModel;
import com.TestePratico.XP.Model.ProdutoModel;
import com.TestePratico.XP.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public ResponseEntity saveProduct(ProdutoModel novoProduto) {

        try {
            if (produtoRepository.existsByDescricao(novoProduto.getDescricao())){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto já existe!");
            }
            novoProduto.setResultado(ResultadoModel.SUCCESS);
            produtoRepository.save(novoProduto);
            return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocorreu um erro na criação" +
                    " do produto, por favor tente novamente.");
        }
    }

    public List<ProdutoModel> products() {
        return produtoRepository.findAll();
    }


    public ResponseEntity updateProduct(ProdutoModel produtoAtualizado) {

        try {
                if (!produtoRepository.existsById(produtoAtualizado.getId_produto())) {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto não existe!");
                }
                produtoAtualizado.setResultado(ResultadoModel.SUCCESS);
                produtoRepository.save(produtoAtualizado);
                return ResponseEntity.status(HttpStatus.ACCEPTED).body(produtoAtualizado);

        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ocorreu um erro na atualização"+
                    " do produto, por favor tente novamente.");
        }

    }

    public ResponseEntity deleteProduct(ProdutoModel produtoDeletado) {
        try {
            if (!produtoRepository.existsById(produtoDeletado.getId_produto())) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto não existe!");
            }
            produtoRepository.delete(produtoDeletado);
            return ResponseEntity.status(HttpStatus.ACCEPTED).header("Produto Deletado").body(produtoDeletado);
        }

        catch (Exception e){
            return ResponseEntity.status(HttpStatus.GONE).body("Não foi possível excluir o produto.");
        }
    }
}
