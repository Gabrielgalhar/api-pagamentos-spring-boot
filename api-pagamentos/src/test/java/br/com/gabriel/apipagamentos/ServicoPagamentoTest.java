package br.com.gabriel.apipagamentos;

import br.com.gabriel.apipagamentos.dto.CriarPagamentoRequisicao;
import br.com.gabriel.apipagamentos.model.Pagamento;
import br.com.gabriel.apipagamentos.model.StatusPagamento;
import br.com.gabriel.apipagamentos.service.ServicoPagamento;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class ServicoPagamentoTest {

    @Test
    void deveCriarPagamentoComoPendente() {
        ServicoPagamento servico = new ServicoPagamento();

        Pagamento pagamento = servico.criar(
                new CriarPagamentoRequisicao(
                        "Gabriel Galhardone",
                        new BigDecimal("100.00")
                )
        );

        assertNotNull(pagamento.getId());
        assertEquals(StatusPagamento.PENDENTE, pagamento.getStatus());
        assertEquals(new BigDecimal("100.00"), pagamento.getValor());
    }

    @Test
    void deveAlterarPagamentoParaPago() {
        ServicoPagamento servico = new ServicoPagamento();

        Pagamento pagamento = servico.criar(
                new CriarPagamentoRequisicao(
                        "Gabriel Galhardone",
                        new BigDecimal("50.00")
                )
        );

        Pagamento pagamentoPago = servico.pagar(pagamento.getId());

        assertEquals(StatusPagamento.PAGO, pagamentoPago.getStatus());
    }

    @Test
    void deveCancelarPagamento() {
        ServicoPagamento servico = new ServicoPagamento();

        Pagamento pagamento = servico.criar(
                new CriarPagamentoRequisicao(
                        "Gabriel Galhardone",
                        new BigDecimal("75.00")
                )
        );

        Pagamento pagamentoCancelado = servico.cancelar(pagamento.getId());

        assertEquals(StatusPagamento.CANCELADO, pagamentoCancelado.getStatus());
    }
}
