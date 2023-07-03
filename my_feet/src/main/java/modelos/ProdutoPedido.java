/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

public class ProdutoPedido {
    
    private Pedido pedido;
    private Produto produto;
    private int quantidadeProduto;

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    @Override
    public String toString() {
        return  "\n\n\n---------------------------------------------" +
                "\n\n Dados Pedido: " + getPedido() +
                "\n\n" +
                "\n Dados Produto: " + getProduto() +
                "\n Quantidade: " + getQuantidadeProduto() +
                "\n---------------------------------------------";
    }
    
    
    
}
