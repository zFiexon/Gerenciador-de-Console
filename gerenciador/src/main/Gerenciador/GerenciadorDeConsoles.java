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
    public void cadastrarConsole(String marca, String modelo, int geracao, int id) {
        String chave = String.valueOf(id);
        if (this.consoles.containsKey(chave)) {
            return;
        }
        Console console = new Console(marca, modelo, geracao, id);
        this.consoles.put(chave, console);
    }

    @Override
    public Collection<Console> pesquisarConsole(String modelo, int id) {
        List<Console> resultados = new ArrayList<>();
        for (Console c : this.consoles.values()) {
            if (c.getModelo().equalsIgnoreCase(modelo) && c.getId() == id) {
                resultados.add(c);
            }
        }
        return resultados;
    }

    @Override
    public void removerConsole(String modelo, int id) throws ConsoleInexistenteException {
        String chave = String.valueOf(id);
        Console console = this.consoles.get(chave);
        if (console != null && console.getModelo().equalsIgnoreCase(modelo)) {
            this.consoles.remove(chave);
        } else {
            throw new ConsoleInexistenteException("Console não encontrado: " + modelo + ", id: " + id);
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
