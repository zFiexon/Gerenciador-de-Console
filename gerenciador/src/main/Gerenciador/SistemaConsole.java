package Gerenciador;

import java.io.IOException;
import java.util.Collection;


public interface SistemaConsole {

     void cadastrarConsole(String marca, String modelo, int geracao, int id);
     Collection<Console> pesquisarConsole(String modelo, int id);
     void removerConsole(String modelo, int id) throws ConsoleInexistenteException;
     void salvarDados() throws IOException;
     void recuperarDados() throws IOException;
}