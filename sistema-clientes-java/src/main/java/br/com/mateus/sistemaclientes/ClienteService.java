package br.com.mateus.sistemaclientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Centraliza as operações de cadastro, consulta, atualização e remoção de clientes.
 */
public class ClienteService {

    private final List<Cliente> clientes = new ArrayList<>();
    private int proximoId = 1;

    public Cliente cadastrar(String nome, String email, String telefone) {
        Cliente cliente = new Cliente(proximoId++, nome, email, telefone);
        clientes.add(cliente);
        return cliente;
    }

    public List<Cliente> listar() {
        return List.copyOf(clientes);
    }

    public Optional<Cliente> buscarPorId(int id) {
        return clientes.stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst();
    }

    public boolean remover(int id) {
        return clientes.removeIf(cliente -> cliente.getId() == id);
    }

    public boolean atualizar(int id, String nome, String email, String telefone) {
        Optional<Cliente> clienteEncontrado = buscarPorId(id);

        if (clienteEncontrado.isEmpty()) {
            return false;
        }

        clienteEncontrado.get().atualizarDados(nome, email, telefone);
        return true;
    }

    public boolean isEmpty() {
        return clientes.isEmpty();
    }
}
