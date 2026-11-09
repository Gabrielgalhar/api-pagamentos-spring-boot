package br.com.gabriel.apipagamentos.service;

import br.com.gabriel.apipagamentos.dto.CriarPagamentoRequisicao;
import br.com.gabriel.apipagamentos.model.Pagamento;
import br.com.gabriel.apipagamentos.model.StatusPagamento;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ServicoPagamento {

    private final Map<UUID, Pagamento> pagamentos = new ConcurrentHashMap<>();

    public Pagamento criar(CriarPagamentoRequisicao requisicao) {
        Pagamento pagamento = new Pagamento(
                requisicao.nomeCliente(),
                requisicao.valor()
        );

        pagamentos.put(pagamento.getId(), pagamento);
        return pagamento;
    }

    public List<Pagamento> listarTodos() {
        return new ArrayList<>(pagamentos.values());
    }

    public Pagamento buscarPorId(UUID id) {
        Pagamento pagamento = pagamentos.get(id);

        if (pagamento == null) {
            throw new NoSuchElementException("pagamento nao encontrado");
        }

        return pagamento;
    }

    public Pagamento pagar(UUID id) {
        Pagamento pagamento = buscarPorId(id);

        if (pagamento.getStatus() != StatusPagamento.PENDENTE) {
            throw new IllegalStateException(
                    "somente pagamentos pendentes podem ser pagos"
            );
        }

        pagamento.setStatus(StatusPagamento.PAGO);
        return pagamento;
    }

    public Pagamento cancelar(UUID id) {
        Pagamento pagamento = buscarPorId(id);

        if (pagamento.getStatus() != StatusPagamento.PENDENTE) {
            throw new IllegalStateException(
                    "somente pagamentos pendentes podem ser cancelados"
            );
        }

        pagamento.setStatus(StatusPagamento.CANCELADO);
        return pagamento;
    }
}
