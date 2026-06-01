package Gerenciador;

import java.io.Console;
import java.io.IOException;

public class TestaSistema {
    public static void main(String[] args) {
        GerenciadorDeConsoles gerenciador = new GerenciadorDeConsoles();

        try {
            gerenciador.recuperarDados();
            System.out.println("Dados recuperados com sucesso!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Nenhum dado encontrado. Iniciando com acervo vazio.");
        }

        gerenciador.cadastrarConsole("PS5", new Console("Sony", "PlayStation 5", 9));
        gerenciador.cadastrarConsole("Xbox Series X", new Console("Microsoft", "Xbox Series X", 9));
        gerenciador.cadastrarConsole("Switch", new Console("Nintendo", "Switch", 8));

        gerenciador.listarConsoles();

        Console consolePesquisado = gerenciador.pesquisarConsole("PS5");
        if (consolePesquisado != null) {
            System.out.println("Console encontrado: " + consolePesquisado);
        } else {
            System.out.println("Console não encontrado.");
        }

        boolean removido = gerenciador.removerConsole("Switch");
        if (removido) {
            System.out.println("Console 'Switch' removido com sucesso.");
        } else {
            System.out.println("Console 'Switch' não encontrado para remoção.");
        }

        gerenciador.listarConsoles();

        try {
            gerenciador.salvarDados();
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }
}
