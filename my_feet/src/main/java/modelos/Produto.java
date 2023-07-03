/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;


public class Produto {
    private int numero_produto;
    private int id_produto;
    private String nome_produto;
    private float preco_produto;
    private String tamanho_produto;
    private Fornecedor fornecedor;

    public int getNumero_produto() {
        return numero_produto;
    }

    public void setNumero_produto(int numero_produto) {
        this.numero_produto = numero_produto;
    }

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public float getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(float preco_produto) {
        this.preco_produto = preco_produto;
    }

    public String getTamanho_produto() {
        return tamanho_produto;
    }

    public void setTamanho_produto(String tamanho_produto) {
        this.tamanho_produto = tamanho_produto;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return
                "\n\n ID: " + getId_produto() +
                "\n Nome: " + getNome_produto() +
                "\n Preco: " + getPreco_produto() +
                "\n Tamanho: " + getTamanho_produto() +
                "\n Fornecedor: " + getFornecedor() ;
    }
    

    

    
        
}
