package br.com.mateus.sistemaclientes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClienteServiceTest {

    @Test
    void deveCadastrarEEncontrarCliente() {
        ClienteService service = new ClienteService();

        Cliente cliente = service.cadastrar(
                "Mateus Soares",
                "mateus@email.com",
                "31999999999"
        );

        assertEquals(1, cliente.getId());
        assertTrue(service.buscarPorId(1).isPresent());
        assertEquals("Mateus Soares", service.buscarPorId(1).get().getNome());
    }

    @Test
    void deveRemoverCliente() {
        ClienteService service = new ClienteService();
        service.cadastrar("João Silva", "joao@email.com", "31988888888");

        assertTrue(service.remover(1));
        assertTrue(service.buscarPorId(1).isEmpty());
    }

    @Test
    void deveAtualizarCliente() {
        ClienteService service = new ClienteService();
        service.cadastrar("Maria", "maria@email.com", "31977777777");

        assertTrue(service.atualizar(
                1,
                "Maria Souza",
                "maria.souza@email.com",
                "31966666666"
        ));

        Cliente cliente = service.buscarPorId(1).orElseThrow();
        assertEquals("Maria Souza", cliente.getNome());
        assertEquals("maria.souza@email.com", cliente.getEmail());
    }

    @Test
    void naoDeveAceitarNomeVazio() {
        ClienteService service = new ClienteService();

        assertThrows(
                IllegalArgumentException.class,
                () -> service.cadastrar("", "email@email.com", "31999999999")
        );
    }
}
