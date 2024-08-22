package com.TestePratico.XP.Controller;

import com.TestePratico.XP.DTO.ProdutoDTO;
import com.TestePratico.XP.Model.ProdutoModel;
import com.TestePratico.XP.Repository.ProdutoRepository;
import com.TestePratico.XP.Service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.UUID;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @PostMapping("/cadastrarProduto")
    public ResponseEntity cadastrarProduto (@RequestBody @Valid ProdutoDTO produtoDTO){

        ProdutoModel novoProduto = new ProdutoModel();
        BeanUtils.copyProperties(produtoDTO, novoProduto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.saveProduct(novoProduto));
    }

    @GetMapping("/produtos")
    public List<ProdutoModel> todosProdutos (){
        return produtoService.products();
    }

    @PutMapping("/atualizarProduto/{id_Produto}")
    public ResponseEntity atualizarProduto (@PathVariable UUID id_Produto,
                                            @RequestBody @Valid ProdutoDTO produtoDTO){
        var produtoAtualizado = new ProdutoModel();
        BeanUtils.copyProperties(produtoDTO, produtoAtualizado);
        produtoAtualizado.setId_produto(id_Produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.updateProduct(produtoAtualizado));
    }

    @DeleteMapping("/deletarProduto/{id_Produto}")
    public ResponseEntity deletarProduto(@PathVariable UUID id_Produto){
        var produtoDeletado = new ProdutoModel();
        produtoDeletado.setId_produto(id_Produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoService.deleteProduct(produtoDeletado));
    }

}
