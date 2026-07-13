package Gerenciador;

import java.io.Serializable;
import java.util.Objects;

public class Console implements Serializable {
    private String marca;
    private String modelo;
    private int geracao;
    private int id;


    public Console(String marca, String modelo, int geracao, int id) {
        this.marca = marca;
        this.modelo = modelo;
        this.geracao = geracao;
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getGeracao() {
        return geracao;
    }

    public void setGeracao(int geracao) {
        this.geracao = geracao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Console console = (Console) o;
        return geracao == console.geracao && id == console.id
                && Objects.equals(marca, console.marca)
                && Objects.equals(modelo, console.modelo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, modelo, geracao, id);
    }

    @Override
    public String toString() {
        return "Console: " +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", geracao=" + geracao +
                ", id=" + id;
    }
}
