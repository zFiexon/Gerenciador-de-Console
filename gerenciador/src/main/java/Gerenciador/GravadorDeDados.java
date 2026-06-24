package Gerenciador;

import java.io.*;
import java.util.HashMap;
import java.io.FileInputStream;

public class GravadorDeDados {

    public static final String ARQUIVO_CONSOLES = "consoles.dat";

    public HashMap<String, Console> recuperarConsoles() throws IOException{
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_CONSOLES))){
            return (HashMap<String, Console>) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }


    public void salvarConsoles(HashMap<String,Console> consoles) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONSOLES))){
            out.writeObject(consoles);
        }
    }
}
