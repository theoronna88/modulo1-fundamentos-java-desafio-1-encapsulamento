package br.com.unipds.fundamentosjava.desafio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class ProdutoTest {

    @Test
    @DisplayName("Deve lançar exceção quando um nome inválido é passado ao construtor, nome curto")
    void construtor_QuandoNomeInvalido_DeveLancarExcecao() {
        assertThatThrownBy(() -> {
            new Produto(1, "TV", 2000.00, 10);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Nome inválido");
    }

    @Test
    @DisplayName("Deve lançar exceção quando um nome inválido é passado ao construtor, null")
    void construtor_QuandoNomeNull_DeveLancarExcecao() {
        assertThatThrownBy(() -> {
            new Produto(1, null, 2000.00, 10);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Nome inválido");
    }

    @Test
    @DisplayName("Deve lançar exceção quando o preço passado ao construtor for zero")
    void construtor_QuandoPrecoZero_DeveLancarExcecao() {
        assertThatThrownBy(() -> {
            new Produto(2, "Geladeira", 0.00, 5);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Preço inválido");
    }

    @Test
    @DisplayName("Deve lançar exceção quando o estoque passado ao construtor é negativo")
    void construtor_QuandoEstoqueNegativo_DeveLancarExcecao() {
        assertThatThrownBy(() -> {
            new Produto(3, "Microondas", 500.00, -3);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Quantidade inválida");
    }

    @Test
    @DisplayName("Deve lançar exceção quando um nome inválido é passado no setNome, null")
    void setNome_QuandoNomeInvalido_DeveLancarExcecao() {
        Produto produto = new Produto(4, "Fogão", 1500.00, 8);
        assertThatThrownBy(() -> {
            produto.setNome(null);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Nome inválido");
    }

    @Test
    @DisplayName("Deve lançar exceção quando um nome inválido é passado no setNome, curto" )
    void setNome_QuandoNomeCurto_DeveLancarExcecao() {
        Produto produto = new Produto(5, "Liquidificador", 300.00, 15);
        assertThatThrownBy(() -> {
            produto.setNome("AB");
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Nome inválido");
    }

    @Test
    @DisplayName("Deve lançar exceção quando o preço passado no setPreco é zero" )
    void setPreco_QuandoPrecoZero_DeveLancarExcecao() {
        Produto produto = new Produto(6, "Aspirador", 800.00, 12);
        assertThatThrownBy(() -> {
            produto.setPreco(0.00);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Preço inválido");
    }

    @Test
    @DisplayName("Deve lançar exceção quando o preço passado no setPreco é negativo" )
    void setPreco_QuandoPrecoNegativo_DeveLancarExcecao() {
        Produto produto = new Produto(7, "Ventilador", 400.00, 20);
        assertThatThrownBy(() -> {
            produto.setPreco(-50.00);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Preço inválido");
    }


    @Test
    @DisplayName("Deve lançar exceção quando o estoque passado no setQuantidadeEmEstoque é negativo")
    void setQuantidadeEmEstoque_QuandoEstoqueNegativo_DeveLancarExcecao() {
        Produto produto = new Produto(8, "Ar Condicionado", 2500.00, 7);
        assertThatThrownBy(() -> {
            produto.setQuantidadeEmEstoque(-1);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("Quantidade inválida");
    }


    @Test
    @DisplayName("Deve criar um produto com sucesso quando todos os parâmetros são válidos")
    void construtor_QuandoParametrosValidos_DeveCriarProdutoComSucesso() {
        Produto produto = new Produto(9, "Smartphone", 1500.00, 30);
        // Verifica se o produto foi criado com os valores corretos
        assertThat(produto.id).isEqualTo(9);
        assertThat(produto.getNome()).isEqualTo("Smartphone");
        assertThat(produto.getPreco()).isEqualTo(1500.00);
        assertThat(produto.getQuantidadeEmEstoque()).isEqualTo(30);
    }

    @Test
    @DisplayName("Deve alterar o nome do produto com sucesso quando um nome válido é passado ao setNome")
    void setNome_QuandoNomeValido_DeveAlterarNomeComSucesso() {
        Produto produto = new Produto(10, "Tablet", 800.00, 25);
        produto.setNome("Tablet Pro");
        assertThat(produto.getNome()).isEqualTo("Tablet Pro");
    }

    @Test
    @DisplayName("Deve alterar o preço do produto com sucesso quando um preço válido é passado ao setPreco")
    void setPreco_QuandoPrecoValido_DeveAlterarPrecoComSucesso() {
        Produto produto = new Produto(11, "Câmera", 1200.00, 18);
        produto.setPreco(1100.00);
        assertThat(produto.getPreco()).isEqualTo(1100.00);
    }

    @Test
    @DisplayName("Deve alterar a quantidade em estoque do produto com sucesso quando um valor válido é passado ao setQuantidadeEmEstoque")
    void setQuantidadeEmEstoque_QuandoEstoqueValido_DeveAlterarEstoqueComSucesso() {
        Produto produto = new Produto(12, "Fone de Ouvido", 300.00, 40);
        produto.setQuantidadeEmEstoque(35);
        assertThat(produto.getQuantidadeEmEstoque()).isEqualTo(35);
    }
}
