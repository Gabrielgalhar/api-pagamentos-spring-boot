package br.com.gabriel.apipagamentos.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CriarPagamentoRequisicao(

        @NotBlank(message = "o nome do cliente e obrigatorio")
        String nomeCliente,

        @NotNull(message = "o valor e obrigatorio")
        @DecimalMin(value = "0.01", message = "o valor deve ser maior que zero")
        BigDecimal valor
) {
}
