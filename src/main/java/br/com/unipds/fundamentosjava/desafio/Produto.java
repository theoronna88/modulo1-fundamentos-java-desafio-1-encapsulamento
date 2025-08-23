package br.com.unipds.fundamentosjava.desafio;

public class Produto {

    public int id;
    private String nome;
    private double preco;
    private int quantidadeEmEstoque;

    public Produto(int id, String nome, double preco, int quantidadeEmEstoque) {
        this.id = id;

        if (nome != null && nome.trim().length() > 3) {
            this.nome = nome;
        }else {
            throw new IllegalArgumentException("Nome inválido: O nome do produto deve conter pelo menos 3 caracteres.");
        }
        if (preco > 0) {
            this.preco = preco;
        } else {
            throw new IllegalArgumentException("Preço inválido: O preço deve ser maior que zero.");
        }
        if (quantidadeEmEstoque >= 0) {
            this.quantidadeEmEstoque = quantidadeEmEstoque;
        } else {
            throw new IllegalArgumentException("Quantidade inválida: O estoque não pode ser negativo.");
        }
    }



    @Override
    public String toString() {
        return "Produto [ID=" + id + ", Nome=" + nome + ", Preço=" + preco + ", Estoque=" + quantidadeEmEstoque + "]";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.trim().length() < 3) {
            throw new IllegalArgumentException("Nome inválido: O nome do produto deve conter pelo menos 3 caracteres.");

        }
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        if (preco <= 0) {
            throw new IllegalArgumentException("Preço inválido: O preço deve ser maior que zero.");
        }
        this.preco = preco;
    }

    public int getQuantidadeEmEstoque() {
        return quantidadeEmEstoque;
    }

    public void setQuantidadeEmEstoque(int quantidadeEmEstoque) {
        if (quantidadeEmEstoque < 0) {
            throw new IllegalArgumentException("Quantidade inválida: O estoque não pode ser negativo.");
        }
        this.quantidadeEmEstoque = quantidadeEmEstoque;
    }
}
