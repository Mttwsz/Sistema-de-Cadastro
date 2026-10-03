package br.com.mateus.sistemaclientes;

import java.util.Objects;

/**
 * Representa um cliente cadastrado no sistema.
 */
public class Cliente {

    private final int id;
    private String nome;
    private String email;
    private String telefone;

    public Cliente(int id, String nome, String email, String telefone) {
        this.id = id;
        this.nome = validarTexto(nome, "nome");
        this.email = validarTexto(email, "e-mail");
        this.telefone = validarTexto(telefone, "telefone");
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void atualizarDados(String nome, String email, String telefone) {
        this.nome = validarTexto(nome, "nome");
        this.email = validarTexto(email, "e-mail");
        this.telefone = validarTexto(telefone, "telefone");
    }

    private static String validarTexto(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("O " + campo + " não pode ser vazio.");
        }
        return valor.trim();
    }

    @Override
    public String toString() {
        return "ID: " + id
                + " | Nome: " + nome
                + " | E-mail: " + email
                + " | Telefone: " + telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cliente cliente)) {
            return false;
        }
        return id == cliente.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
