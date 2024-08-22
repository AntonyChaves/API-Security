package com.TestePratico.XP.Model;

import com.TestePratico.XP.Enum.ResultadoModel;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table (name = "testeXP_Produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id_produto;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    private double valor;

    @Column
    private String tipo;

    @Column
    private int estoque;

    @Column
    private ResultadoModel resultado;

    public void setId_produto(UUID id_produto) {
        this.id_produto = id_produto;
    }

    public UUID getId_produto() {
        return id_produto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public ResultadoModel getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoModel resultado) {
        this.resultado = resultado;
    }
}
