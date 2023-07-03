/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Administrator
 */
public class Fornecedor extends PessoaJuridica{
    
    private int numeroFornecedor;
    
    public String GetNome() {
        return super.getNome();
    }
    
    public void setNome(String nome) {
        super.setNome(nome);
    }
    
    public String getEndereco(){
        return super.getEndereco();
    }
    
    public void setEndereco(String endereco ) {
        super.setEndereco(endereco);
    }
    
    public String getTelefoneFixo() {
        return super.getTelefoneFixo();
    }
    
    public void setTelefoneFixo(String telefoneFixo) {
        super.setTelefoneFixo(telefoneFixo);
    }
    
    public String getEmail() {
        return super.getEmail();
    }
    
    public void setEmail(String email) {
        super.setEmail(email);
    }

    public int getNumeroFornecedor() {
        return numeroFornecedor;
    }

    public void setNumeroFornecedor(int numeroFornecedor) {
        this.numeroFornecedor = numeroFornecedor;
    }

    @Override
    public String toString() {
        return
                "\n\n Nome: " + getNome() +
                "\n Endereco: " + getEndereco() +
                "\n Telefone fixo: " + getTelefoneFixo() +
                "\n Email: " + getEmail();
    }
    
    
    
}
