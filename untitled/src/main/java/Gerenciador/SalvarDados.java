package Gerenciador;

import java.io.*;
import java.util.Map;

public class SalvarDados {
    private final String NOME_ARQUIVO = "consoles_db.dat";

    public void salvar(Map<String, Console> dados) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(NOME_ARQUIVO))) {
            out.writeObject(dados);
        }
    }

    @SuppressWarnings("unchecked")
    public Map<String, Console> recuperar() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(NOME_ARQUIVO))) {
            return (Map<String, Console>) in.readObject();
        }
    }
}
