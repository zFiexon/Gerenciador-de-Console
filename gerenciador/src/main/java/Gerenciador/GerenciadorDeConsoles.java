package Gerenciador;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.HashMap;

public class GerenciadorDeConsoles implements SistemaConsole {

    private HashMap<String,Console> consoles;
    private GravadorDeDados gravador;

    public GerenciadorDeConsoles() {
        this.consoles = new HashMap<>();
        this.gravador = new GravadorDeDados();
    }

    @Override
    public boolean cadastrarConsole(String marca, String modelo, int geracao, int id) {
        if (this.consoles.containsKey(id)) {
            return false;
        }
        Console console = new Console(marca, modelo, geracao, id);
        this.consoles.put(String.valueOf(id), console);
        return true;
    }

    @Override
    public Collection<Console> pesquisarConsole(String modelo, int geracao) {
        List<Console> resultados = new ArrayList<>();
        for (Console c : this.consoles.values()) {
            if (c.getModelo().equalsIgnoreCase(modelo) && c.getGeracao() == geracao) {
                resultados.add(c);
            }
        }
        return resultados;
    }

    @Override
    public void removerConsole(String modelo, int geracao) throws ConsoleInexistenteException {
        if (this.consoles.containsKey(modelo)){
            this.consoles.remove(modelo);
        } else {
            throw new ConsoleInexistenteException("Console não encontrado: " + modelo + ", geração: " + geracao);
        }
    }

    @Override
    public void salvarDados() throws IOException {
        this.gravador.salvarConsoles(this.consoles);
    }

    @Override
    public void recuperarDados() throws IOException {
        this.consoles = this.gravador.recuperarConsoles();
    }
}
