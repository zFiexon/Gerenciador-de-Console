package Gerenciador;

import java.io.IOException;
import java.util.Collection;


public interface SistemaConsole {

     boolean cadastrarConsole(String marca, String modelo, int geracao, int id);
     Collection<Console> pesquisarConsole(String modelo, int geracao);
     void removerConsole(String modelo, int geracao) throws ConsoleInexistenteException;
     void salvarDados() throws IOException;
     void recuperarDados() throws IOException;
}