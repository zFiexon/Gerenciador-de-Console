package Gerenciador;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collection;

public class TestaSistema {

    private GerenciadorDeConsoles gerenciador;

    @Test
    public void testaCadastroPesquisaRemocao() {
        gerenciador = new GerenciadorDeConsoles();
        Collection<Console> consolesAchados = gerenciador.pesquisarConsole("PlayStation 5", 000);
        assertTrue(consolesAchados.size() == 0);
        gerenciador.cadastrarConsole("Sony", "PlayStation 5", 9, 000);
        gerenciador.cadastrarConsole("Microsoft", "Xbox Series X", 9, 100);
        consolesAchados = gerenciador.pesquisarConsole("PlayStation 5", 000);
        assertEquals(1, consolesAchados.size());
        Console ps5 = new Console("Sony", "PlayStation 5", 9, 000);
        assertTrue(consolesAchados.contains(ps5));
        try {
            gerenciador.removerConsole("PlayStation 5", 000);
        } catch (ConsoleInexistenteException e) {
            fail("Console não encontrado para remoção");
        }
    }
}