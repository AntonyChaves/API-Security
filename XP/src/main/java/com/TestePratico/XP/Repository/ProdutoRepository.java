package com.TestePratico.XP.Repository;

import com.TestePratico.XP.Model.ProdutoModel;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, UUID> {

    boolean existsByDescricao(String descricao);

}
