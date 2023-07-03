/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author Administrator
 */
public class Cliente extends PessoaFisica {
    private int id_cliente;
    private int numero_cliente;
    private String dataCadastro;
    private String tipoCliente;
    
    
    
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
    
    public String getCpf() {
        return super.getCpf();
    }
    
    public void setCpf(String cpf) {
        super.setCpf(cpf);
    }
    
    public String getDataNascimento() {
        return super.getDataNascimento();
    }
    
    public void setDataNascimento(String dataNascimento) {
        super.setDataNascimento(dataNascimento);
    }
    
    public String getSexo() {
        return super.getSexo();
    }
    
    public void setSexo(String sexo) {
        super.setSexo(sexo);
    }
   
    public int getNumero_cliente() {
        return numero_cliente;
    }

    public void setNumero_cliente(int numero_cliente) {
        this.numero_cliente = numero_cliente;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    @Override
    public String toString() {
        return  "\n--------------------------------\n" +
                "\n Dados do cliente: " +
                "\n ID: " + getId_cliente() +
                "\n Nome: " + getNome() +
                "\n Endereco: " + getEndereco() +
                "\n Telefone fixo: " + getTelefoneFixo() +
                "\n Email: " + getEmail() +
                "\n Sexo: " + getSexo() +
                "\n CPF: " + getCpf() +
                "\n Data de Nascimento: " + getDataNascimento() +
                "\n----------------------------------";
    }

    
    
   
    
    

    
}
