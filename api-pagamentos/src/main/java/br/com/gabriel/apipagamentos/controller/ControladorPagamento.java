package br.com.gabriel.apipagamentos.controller;

import br.com.gabriel.apipagamentos.dto.CriarPagamentoRequisicao;
import br.com.gabriel.apipagamentos.model.Pagamento;
import br.com.gabriel.apipagamentos.service.ServicoPagamento;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pagamentos")
public class ControladorPagamento {

    private final ServicoPagamento servicoPagamento;

    public ControladorPagamento(ServicoPagamento servicoPagamento) {
        this.servicoPagamento = servicoPagamento;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pagamento criar(@Valid @RequestBody CriarPagamentoRequisicao requisicao) {
        return servicoPagamento.criar(requisicao);
    }

    @GetMapping
    public List<Pagamento> listarTodos() {
        return servicoPagamento.listarTodos();
    }

    @GetMapping("/{id}")
    public Pagamento buscarPorId(@PathVariable UUID id) {
        return servicoPagamento.buscarPorId(id);
    }

    @PatchMapping("/{id}/pagar")
    public Pagamento pagar(@PathVariable UUID id) {
        return servicoPagamento.pagar(id);
    }

    @PatchMapping("/{id}/cancelar")
    public Pagamento cancelar(@PathVariable UUID id) {
        return servicoPagamento.cancelar(id);
    }
}
