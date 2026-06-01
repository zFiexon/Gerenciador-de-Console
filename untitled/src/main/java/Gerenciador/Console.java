import java.io.Serializable;

public class Console implements Serializable {
    private static final long serialVersionUID = 1L;

    private String marca;
    private String modelo;
    private int geracao;

    public Console(String marca, String modelo, int geracao) {
        this.marca = marca;
        this.modelo = modelo;
        this.geracao = geracao;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getGeracao() {
        return geracao;
    }

    @Override
    public String toString() {
        return "Console [" + marca + " " + modelo + " - " + geracao + "ª geração]";
    }
}