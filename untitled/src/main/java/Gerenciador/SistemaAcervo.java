package Gerenciador;

import java.io.Console;
import java.io.IOException;

public interface SistemaAcervo {

    void cadastrarConsole(String modelo, Console console);
    Console pesquisarConsole(String modelo);
    boolean removerConsole(String modelo);
    void salvarDados() throws IOException;
    void recuperarDados() throws IOException, ClassNotFoundException;
}