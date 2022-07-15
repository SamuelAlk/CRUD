package com.lojaSA.lojaSA.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoResponse {
    private String id;
    private String nome;
    private String descricao;
    private Long quantidade;
    private BigDecimal valor;
    private LocalDate validade;

}
