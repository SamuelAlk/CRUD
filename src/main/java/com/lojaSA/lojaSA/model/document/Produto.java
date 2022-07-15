package com.lojaSA.lojaSA.model.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class Produto {
    @Id
    private String id;
    private Boolean ativo;
    private String nome;
    private String descricao;
    private Long quantidade;
    private BigDecimal valor;
    private LocalDate validade;

}
