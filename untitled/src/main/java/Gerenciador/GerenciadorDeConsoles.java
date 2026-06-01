package Gerenciador;

import java.io.Console;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeConsoles {
    private Map<String, Console> acervo;
    private SalvarDados salvarDados;

    public GerenciadorDeConsoles() {
        this.acervo = new HashMap<>();
        this.salvarDados = new SalvarDados();
    }

    @Override
    public void cadastrarConsole(String modelo, Console console) {
        acervo.put(modelo, console);
    }

    @Override
    public Console pesquisarConsole(String modelo) {
        return acervo.get(modelo);
    }

    @Override
    public boolean removerConsole(String modelo) {
        if (acervo.containsKey(modelo)) {;
            acervo.remove(modelo);
            return true;
        }
        return false;
    }

    @Override
    public void salvarDados() throws IOException {
        salvarDados.salvar(acervo);
    }

    @Override
    public void recuperarDados() throws IOException, ClassNotFoundException {
        this.acervo = salvarDados.recuperar();
    }

    public void listarConsoles() {
        if (acervo.isEmpty()) {
            System.out.println("Nenhum console cadastrado.");
        } else {
            System.out.println("Consoles cadastrados:");
            for (Console console : acervo.values()) {
                System.out.println(console);
            }
        }
    }
}
