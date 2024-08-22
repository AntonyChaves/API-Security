package com.TestePratico.XP.DTO;

import com.TestePratico.XP.Enum.ResultadoModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProdutoDTO(

        @NotBlank
        String nome,

        @NotBlank
        String descricao,

        @NotNull
        double valor,

        @NotBlank
        String tipo,

        @NotNull
        int estoque

) {
}
