package br.com.gabriel.apipagamentos.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Pagamento {

    private UUID id;

    @NotBlank(message = "o nome do cliente e obrigatorio")
    private String nomeCliente;

    @NotNull(message = "o valor e obrigatorio")
    @DecimalMin(value = "0.01", message = "o valor deve ser maior que zero")
    private BigDecimal valor;

    private StatusPagamento status;
    private LocalDateTime dataCriacao;

    public Pagamento() {
    }

    public Pagamento(String nomeCliente, BigDecimal valor) {
        this.id = UUID.randomUUID();
        this.nomeCliente = nomeCliente;
        this.valor = valor;
        this.status = StatusPagamento.PENDENTE;
        this.dataCriacao = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public StatusPagamento getStatus() {
        return status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public void setStatus(StatusPagamento status) {
        this.status = status;
    }
}
