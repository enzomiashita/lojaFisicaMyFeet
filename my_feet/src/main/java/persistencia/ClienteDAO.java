
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelos.Pedido;
import modelos.Cliente;
import modelos.Produto;
import modelos.ProdutoPedido;

public class ClienteDAO {
    
    protected static Connection connection;

    protected static PreparedStatement st;

    protected static ResultSet rs;
    
    protected static Scanner teclado = new Scanner(System.in).useDelimiter("\n");
    
    protected static int idCliente = 0;

    
    public static int exibirMenu() {
        System.out.println("""
                \n \nMy Feet - ESCOLHA UMA OPÇÃO:
                1 - Cadastrar Cliente
                2 - Listar clientes
                3 - Comprar
                4 - Excluir cliente
                5 - Listar um cliente especifico
                6 - Alterar cliente
                7 - Ver pedido(s)
                8 - Sair
                """);
        
        return teclado.nextInt();
    }
    
    public static boolean verificar(String campo)throws Exception {
        try {
            String sql = "SELECT * FROM tbCliente WHERE id_cliente = ? OR email_cliente = ?";
            
            connection = GerenteDeConexao.getConnection();
            
            st = connection.prepareStatement(sql);
            
            st.setString(1, campo);
            
            st.setString(2, campo);
            
            rs = st.executeQuery();
            
            if (rs.next()) {
                return true;
            }else {
                return false;
            }
            
            
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean verificarCpf(String campo, String campo2)throws Exception {
        try {
            String sql = "SELECT * FROM tbCliente WHERE cpf_cliente = ? AND email_cliente = ?";
            
            connection = GerenteDeConexao.getConnection();
            
            st = connection.prepareStatement(sql);
            
            st.setString(1, campo);
            
            st.setString(2, campo2);
            
            rs = st.executeQuery();
            
            if (rs.next()) {
                return true;
            }else {
                return false;
            }
            
            
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    
    
    public static boolean verificarID(int campo)throws Exception {
        try {
            String sql = "SELECT * FROM tbCliente WHERE id_cliente = ? OR email_cliente = ?";
            
            connection = GerenteDeConexao.getConnection();
            
            st = connection.prepareStatement(sql);
            
            st.setInt(1, campo);
            
            st.setInt(2, campo);
            
            rs = st.executeQuery();
            
            if (rs.next()) {
                return true;
            }else {
                return false;
            }
            
            
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static String retornaCampos(int id_cliente, String campo)throws Exception {
        
        String sql = "";
        String valor = "";
        
        
        try {
            
                
             
                sql = "SELECT " +campo+ " FROM tbCliente WHERE id_cliente = ?";
            
                connection = GerenteDeConexao.getConnection();
                
                st = connection.prepareStatement(sql);
                
                st.setInt(1, id_cliente);
                
                rs = st.executeQuery();
                
                if(rs.next()) {
                    valor = rs.getString(campo);
                }
                
                st.close();
                
                return valor;
            
            
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return "falha ao tentar buscar o campo";
        }
        
    }
    
    public static int retornaID(int id_cliente) {
        
        int id = 0;
        
        try {
            
            String sql = "SELECT id_cliente FROM tbCliente WHERE id_cliente = ?";
            
            connection = GerenteDeConexao.getConnection();
            
            st = connection.prepareStatement(sql);
            
            st.setInt(1, id_cliente);
            
            rs = st.executeQuery();
            
            if (rs.next()) {
               id = rs.getInt("id_cliente"); 
            }
            
            st.close();
            
            return id;
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return id;
        }
        
    }
    
    /*public static String retornaValor(String campo, int id) {
        
        String valor = "";
        
        try {
            
            String sql = "SELECT " + campo + " FROM tbCliente WHERE id = ?";
            
            connection = GerenteDeConexao.getConnection();
                
            st = connection.prepareStatement(sql);
                
            st.setInt(1, id);
                
            rs = st.executeQuery();
            
            valor = rs.getString(campo);
            
            return valor;
            
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return valor;
        }
        
    }*/
    
  public static int verificarComSenha(String email)throws Exception {
        
        int id_cliente = 0;
        
        try {
            String sql = "SELECT * FROM tbCliente WHERE email_cliente = ?";
            
            connection = GerenteDeConexao.getConnection();
            
            st = connection.prepareStatement(sql);
            
            st.setString(1, email);
            
            rs = st.executeQuery();
            
            if (rs.next()) {
                id_cliente = rs.getInt("id_cliente");
                return id_cliente;
            }else {
                return id_cliente;
            }
            
            
        }catch(Exception e) {
            System.out.println(e.getMessage());
            return id_cliente;
        }
    }
    
    public static String abrirConta()throws Exception {
        String resultado = "";
        String nome_cliente = "";
        String email_cliente = "";
        String cpf_cliente = "";
        String endereco_cliente = "";
        String telefoneFixo_cliente = "";
        String sexo_cliente = "";
        String data_nascimento_cliente = "";
        
        
        int ret = 0;
        
        Cliente cliente = new Cliente();
        
        System.out.println("\n \n Insira os valores e tecle ENTER <>");
        
        
        System.out.println("Nome do(a) cliente: ");
        nome_cliente = teclado.next();
        
        System.out.println("Email do(a) cliente: ");
        email_cliente = teclado.next();
        
        System.out.println("CPF do(a) cliente: ");
        cpf_cliente = teclado.next();
        
        System.out.println("Endereco do(a) cliente: ");
        endereco_cliente = teclado.next();
        
        System.out.println("Telefone do(a) cliente: ");
        telefoneFixo_cliente = teclado.next();
        
        System.out.println("Sexo do(a) cliente: ");
        sexo_cliente = teclado.next();
        
        System.out.println("Data de nascimento do(a) cliente: ");
        data_nascimento_cliente = teclado.next();
        
        try {
        
            if (ClienteDAO.verificar(email_cliente)) {
                resultado = "\n \n Cliente ja cadastrado! \n \n";
            } else {
                try {
                    String sql2 = "INSERT INTO tbCliente(nome_cliente, endereco_cliente, telefoneFixo_cliente, email_cliente, sexo_cliente, cpf_cliente, data_nascimento_cliente) VALUES(?, ?, ?, ?, ?, ?, ?)" ;

                    connection = GerenteDeConexao.getConnection();

                    st = connection.prepareStatement(sql2);

                    st.setString(1, nome_cliente);
                    st.setString(2, endereco_cliente);
                    st.setString(3, telefoneFixo_cliente);
                    st.setString(4, email_cliente);
                    st.setString(5, sexo_cliente);
                    st.setString(6, cpf_cliente);
                    st.setString(7, data_nascimento_cliente);

                    ret = st.executeUpdate();

                    resultado = "\n \n Cadastro feito com exito! \n \n";

                    st.close();


                } catch (Exception e) {
                    System.out.println(e.getMessage());

                    resultado = "\n \n Cadastro falhou! \n \n";
                }
            }
            
            
        
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        st.close();
        return resultado;
    }
    
    public static List<Cliente> listarContas()throws Exception {
        
        List<Cliente> listCliente = new ArrayList<Cliente>();
        
        try {
            
        String sql = "SELECT * FROM tbCliente";
        
        connection = GerenteDeConexao.getConnection();
        
        st = connection.prepareStatement(sql);
        
        rs = st.executeQuery();
        
        int i = 0;
        
        while (rs.next()) {
            
            i++;
            
            Cliente c = new Cliente();
            
            c.setNumero_cliente(i);
            
            c.setId_cliente(rs.getInt("id_cliente"));
            
            c.setNome(rs.getString("nome_cliente"));
                  
            c.setEndereco(rs.getString("endereco_cliente"));
            
            c.setTelefoneFixo(rs.getString("telefoneFixo_cliente"));
            
            c.setEmail(rs.getString("email_cliente"));   
            
            c.setSexo(rs.getString("sexo_cliente"));
            
            c.setCpf(rs.getString("cpf_cliente"));
            
            c.setDataNascimento(rs.getString("data_nascimento_cliente"));

            listCliente.add(c);
            
        }
        
        st.close();
        
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            
        }
        
        
        return listCliente;
        
    }
    
    public static void menuComprar()throws Exception {
        List<Produto> listProduto = new ArrayList<Produto>();
        
        int i = 0;
        int ret = 0;
        
        
        try {
            
            String sql = "SELECT * FROM tbProduto";
            
            connection = GerenteDeConexao.getConnection();
            
            st = connection.prepareStatement(sql);
            
            rs = st.executeQuery();
            
            while(rs.next()) {
                Produto p = new Produto();
                
                i++;
                
                p.setNumero_produto(i);
                
                p.setId_produto(rs.getInt("id_produto"));
                
                p.setNome_produto(rs.getString("nome_produto"));
                
                p.setPreco_produto(rs.getFloat("preco_produto"));
                
                p.setTamanho_produto(rs.getString("tamanho_produto"));
                
                listProduto.add(p);
                
                
            }
            
            
            
            st.close();
            
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(listProduto);;
        ClienteDAO.comprar();
        
        
    }
    
    public static void comprar()throws Exception {
        List<Produto> listProduto = new ArrayList<Produto>();
        
        int ret = 0;
        
        try {
            
            int id_produto = 1;
            int quantidade_produto = 1;
            int id_cliente = 0;
            
            while(id_produto != 0) {
                System.out.println("\n \n Adcionar ao pedido (DIGITE 0 PARA SAIR)");
                System.out.println("Insira o ID do produto e tecle ENTER");
                id_produto = teclado.nextInt();

                if (verificarProduto(id_produto)) {
                    
                    System.out.println("Insira o ID do cliente que ira fazer a compra e tecle ENTER");
                    id_cliente = teclado.nextInt();
                    
                    if (ClienteDAO.verificarID(id_cliente)) {
                        
                        idCliente = id_cliente;
                        
                        System.out.println("Digite a quantidade");
                        quantidade_produto = teclado.nextInt();

                        String sql2 = "SELECT * FROM tbProduto WHERE id_produto = ?";

                        connection = GerenteDeConexao.getConnection();

                        st = connection.prepareStatement(sql2);

                        st.setInt(1, id_produto);

                        rs = st.executeQuery();

                        int i = 0;

                        System.out.println("Insira a data do pedido e tecle ENTER");
                        String data_pedido = teclado.next();

                        if(rs.next()) {

                            String nome_produto = rs.getString("nome_produto");

                            double preco_produto = rs.getFloat("preco_produto");

                            String tamanho_produto = rs.getString("tamanho_produto");

                            int id = rs.getInt("id_produto");

                            id_cliente = ClienteDAO.retornaID(id_cliente);


                            System.out.println(ClienteDAO.adcionarAoPedido(id_cliente, data_pedido, id, quantidade_produto, nome_produto, preco_produto, tamanho_produto ));

                        }

                        st.close();
                    }else {
                        System.out.println("\n\nCliente nao existe!\n\n");
                    }
                }else if (id_produto > 0) {
                    System.out.println("\n \n Produto nao encontrado!");
                }    
            }
            
            System.out.println("\n \n Obrigado! \n \n");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean verificarProduto(int id_produto) {
        
        try {
            
            String sql = "SELECT * FROM tbProduto WHERE id_produto = ?";
            
            connection = GerenteDeConexao.getConnection();
            
            st = connection.prepareStatement(sql);
            
            st.setInt(1, id_produto);
            
            rs = st.executeQuery();
            
            if(rs.next()) {
                return true;
            }else {
                return false;
            }
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
    
    
    public static String adcionarAoPedido(int id_cliente, String data_pedido, int id_produto, int quantidade_produto, String nome_produto, double preco_produto, String tamanho_produto  ) {
        String resultado = "";
        int ret = 0;
        
        
        try {
            
            String sql = "INSERT INTO tbPedido(id_cliente, data_pedido, ind_pedido_finalizado) VALUES(?, ?, 'n')";

            connection = GerenteDeConexao.getConnection();
            
            st = connection.prepareStatement(sql);
            
            st.setFloat(1, id_cliente);
            
            st.setString(2, data_pedido);
            
            ret = st.executeUpdate();
            
            st.close();
            
            if(ClienteDAO.adcionarPedidoProduto(id_produto, quantidade_produto, nome_produto, preco_produto, tamanho_produto)) {
                resultado = "\n \n Produto adcionado com sucesso! \n \n";
            }    
            
            
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
            resultado = "\n \n Falha ao adcionar o produto \n \n";
        }
        
        return resultado;
    }
    
    public static boolean adcionarPedidoProduto(int id_produto, int quantidade_produto, String nome_produto, double preco_produto, String tamanho_produto) {
        int ret = 0;
        try {
            
            String sql = "INSERT INTO tbProdutoPedido(id_produto, nome_produto, quantidade_produto, preco_produto, tamanho_produto) VALUES (?, ?, ?, ?, ?)";
            
            connection = GerenteDeConexao.getConnection();
            
            st = connection.prepareStatement(sql);
            
            st.setInt(1, id_produto);
            
            st.setString(2, nome_produto);
            
            st.setInt(3, quantidade_produto);
            
            st.setDouble(4, preco_produto);
            
            st.setString(5, tamanho_produto);
            
            ret = st.executeUpdate();
            
            st.close();
            
            return true;
            
        }catch (Exception e){
            System.out.println(e.getMessage());
            
            return false;
        }
        
    }
    
    public static String excluirConta()throws Exception {
        String resultado = "";
        String email_cliente = "";
        int ret = 0;
        
        System.out.println("\n \nExcluir cliente");
        System.out.println("Digite o email da cliente");
        email_cliente = teclado.next();
        
        
        if (ClienteDAO.verificar(email_cliente)) {
            try {
                String sql = "DELETE FROM tbCliente WHERE email_cliente = ?";

                connection = GerenteDeConexao.getConnection();

                st = connection.prepareStatement(sql);
                
                st.setString(1, email_cliente);

                ret = st.executeUpdate();

                resultado = " \n \nCliente excluida com exito! \n \n";

                st.close();
            }catch (Exception e) {
                System.out.println(e.getMessage());
                resultado = "\n \n Falhou! \n \n";
            }

        }else {
            resultado = "\n \n Email nao cadastrado! \n \n";
        }
        return resultado;
    }
    
    public static List<Cliente> listaConta()throws Exception {
        List<Cliente> listCliente = new ArrayList<Cliente>();
        
        System.out.println("\n \nListar um cliente");
        System.out.println("Digite o email do cliente");
        String email_cliente = teclado.next();
        
        if(ClienteDAO.verificar(email_cliente)) {
            
            try {
                
                String sql = "SELECT * FROM tbCliente WHERE email_cliente = ?";
                
                connection = GerenteDeConexao.getConnection();
                
                st = connection.prepareStatement(sql);
                
                st.setString(1, email_cliente);
                
                rs = st.executeQuery();
                
                int i = 0;
                
                while(rs.next()) {
                    
                    i++;
                    
                    Cliente c = new Cliente();
            
                    c.setNumero_cliente(i);
                    
                    c.setId_cliente(rs.getInt("id_cliente"));

                    c.setNome(rs.getString("nome_cliente"));

                    c.setEndereco(rs.getString("endereco_cliente"));

                    c.setTelefoneFixo(rs.getString("telefoneFixo_cliente"));

                    c.setEmail(rs.getString("email_cliente"));   

                    c.setSexo(rs.getString("sexo_cliente"));

                    c.setCpf(rs.getString("cpf_cliente"));

                    c.setDataNascimento(rs.getString("data_nascimento_cliente"));

                    listCliente.add(c);
                    
                }
                
                st.close();
                
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
            
        }else {
            System.out.println("\n \n Email nao cadastrado! \n \n");
        }
        
        return listCliente;
    }
    
    public static String alterarConta()throws Exception {
        String resultado = "";
        int opcao = 0;
        
        System.out.println("\n \n Alterar Conta");
        System.out.println("Digite o email da conta");
        String email = teclado.next();
        
        System.out.println("Digite o cpf da conta");
        String cpf = teclado.next();
        
        if (ClienteDAO.verificarCpf(cpf, email)) {
            
            int id_cliente = ClienteDAO.verificarComSenha(email);
            
            while (opcao != 8) {
                
                System.out.println("""
                   \n \n Alterar conta - ESCOLHA O CAMPO QUE DESEJA ALTERAR:
                    1 - Nome
                    2 - Email
                    3 - Telefone
                    4 - Endereco
                    5 - Cpf
                    6 - Sexo
                    7 - Data de nascimento
                    8 - Cancelar
                    """);
                opcao = teclado.nextInt();
                
                switch(opcao) {
                    case 1:
                        System.out.println("Digite o novo nome da conta");
                        String nome_cliente = teclado.next();
                        System.out.println(ClienteDAO.alterarSql(opcao, id_cliente, nome_cliente));
                        break;
                    
                    case 2:
                        System.out.println("Digite o novo email da conta");
                        String email_cliente = teclado.next();
                        System.out.println(ClienteDAO.alterarSql(opcao, id_cliente, email_cliente));
                        break;
                        
                    case 3:
                        System.out.println("Digite o novo telefone da conta");
                        String telefone_cliente = teclado.next();
                        System.out.println(ClienteDAO.alterarSql(opcao, id_cliente, telefone_cliente));
                        break;
                        
                    case 4:
                        System.out.println("Digite o novo endereco da conta");
                        String endereco_cliente = teclado.next();
                        System.out.println(ClienteDAO.alterarSql(opcao, id_cliente, endereco_cliente));
                        break;
                        
                    case 5:
                        System.out.println("Digite o novo cpf da conta");
                        String cpf_cliente = teclado.next();
                        System.out.println(ClienteDAO.alterarSql(opcao, id_cliente, cpf_cliente));
                        break;
                        
                    case 6:
                        System.out.println("Digite o novo sexo do(a) cliente");
                        String sexo_cliente = teclado.next();
                        System.out.println(ClienteDAO.alterarSql(opcao, id_cliente, sexo_cliente));
                        break;
                        
                    case 7:
                        System.out.println("Digite a nova data de nascimento do(a) cliente");
                        String data_nascimento_cliente = teclado.next();
                        System.out.println(ClienteDAO.alterarSql(opcao, id_cliente, data_nascimento_cliente));
                        break;
                        
                    default: 
                        if (opcao != 8) {
                            System.out.println("Digite uma opcao valida!");
                        }
                        break;
                        
                }
                    
            }
            
            resultado = "\n \n Operacao cancelada!\n \n";
            
            
        }else {
            resultado = "\n \n CPF e/ou email invalido(s)! \n \n ";
        }
        
        return resultado;
    }
    
    public static String alterarSql(int opcao, int id_cliente, String campo)throws Exception {
        String resultado = "";
        String escolha = "";
        int ret = 0;
        String sql = "";
        
        
        try {
            switch (opcao) {
                case 1:
                        sql = "UPDATE tbCliente SET nome_cliente = ? WHERE id_cliente = ?";
                        break;
                    
                    case 2:
                        sql = "UPDATE tbCliente SET email_cliente = ? WHERE id_cliente = ?";
                        break;
                        
                    case 3:
                        sql = "UPDATE tbCliente SET telefoneFixo_cliente = ? WHERE id_cliente = ?";
                        break;
                        
                    case 4:
                        sql = "UPDATE tbCliente SET endereco_cliente = ? WHERE id_cliente = ?";
                        break;
                        
                    case 5:
                        sql = "UPDATE tbCliente SET cpf_cliente = ? WHERE id_cliente = ?";
                        break;
                        
                    case 6:
                        sql = "UPDATE tbCliente SET sexo_cliente = ? WHERE id_cliente = ?";
                        break;
                        
                    case 7:
                        sql = "UPDATE tbCliente SET data_nascimento_cliente = ? WHERE id_cliente = ?";
                        break;  
                    
            }
            
            
            
            connection = GerenteDeConexao.getConnection();
            
            st = connection.prepareStatement(sql);
            
            st.setString(1, campo);
            
            st.setInt(2, id_cliente);
            
            ret = st.executeUpdate();
            
            resultado = "\n \n Alteracao feita com exito \n \n";
            
            st.close();
            
        }catch(Exception e) {
            System.out.println(e.getMessage());
            resultado = "\n \n Alteracao falhou! \n \n";
        }
        
        return resultado;
    }
    
    public static void verPedido()throws Exception {
        List<ProdutoPedido> listPedido = new ArrayList();
        
        try {
            
            String sql = "SELECT pp.id_produto, pp.nome_produto, pp.quantidade_produto, pp.preco_produto, pp.tamanho_produto, p.numero_pedido, p.id_cliente, p.data_pedido, p.ind_pedido_finalizado, c.nome_cliente, c.id_cliente, c.endereco_cliente, c.telefoneFixo_cliente, c.email_cliente, c.cpf_cliente, c.data_nascimento_cliente, c.sexo_cliente FROM tbProdutoPedido pp INNER JOIN tbPedido p ON pp.numero_pedido = p.numero_pedido INNER JOIN tbCliente c ON c.id_cliente = p.id_cliente AND p.ind_pedido_finalizado = 'n'";
            
            connection = GerenteDeConexao.getConnection();
            
            st = connection.prepareStatement(sql);
            
            rs = st.executeQuery();
            
            int i = 0;
            
            while(rs.next()) {
                i++;

                Pedido p = new Pedido();
                Produto pr = new Produto();
                ProdutoPedido pp = new ProdutoPedido();
                Cliente c = new Cliente();

                
                p.setNumeroPedido(rs.getInt("p.numero_pedido"));
                
                p.setDataPedido(rs.getString("p.data_pedido"));
                
                c.setId_cliente(rs.getInt("c.id_cliente"));
                
                c.setNome(rs.getString("nome_cliente"));
                
                c.setEndereco(rs.getString("endereco_cliente"));
                
                c.setTelefoneFixo(rs.getString("telefoneFixo_cliente"));
                
                c.setEmail(rs.getString("email_cliente"));
                                
                c.setCpf(rs.getString("cpf_cliente"));
                
                c.setDataNascimento(rs.getString("data_nascimento_cliente"));
                
                c.setSexo(rs.getString("sexo_cliente"));

                p.setCliente(c);
                
                
                
                
                pr.setId_produto(rs.getInt("pp.id_produto"));
                
                pr.setNome_produto(rs.getString("pp.nome_produto"));
                
                pr.setNumero_produto(i);
                
                pr.setPreco_produto(rs.getFloat("pp.preco_produto"));
                
                pr.setTamanho_produto(rs.getString("pp.tamanho_produto"));
                

                
                pp.setQuantidadeProduto(rs.getInt("pp.quantidade_produto"));
                
                pp.setPedido(p);
                
                pp.setProduto(pr);
                
                
                
                listPedido.add(pp);
                
            }
            
            st.close();
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\n \n" + listPedido + "\n \n"); 
        ClienteDAO.opcoesPedido();
    }
    
    public static Cliente leUmCliente(int id) {
        
        Cliente c = new Cliente();
        
        try {
            
            String sql = "SELECT * FROM tbCliente WHERE id_cliente = ?";
            
            connection = GerenteDeConexao.getConnection();
            
            st = connection.prepareStatement(sql);
            
            st.setInt(1, id);
            
            rs = st.executeQuery();
            
            if(rs.next()) {
                
                c.setId_cliente(rs.getInt("id_cliente"));
                
                c.setNome(rs.getString("nome_cliente"));
                
                c.setEndereco(rs.getString("endereco_cliente"));
                
                c.setTelefoneFixo(rs.getString("telefoneFixo_cliente"));
                
                c.setEmail(rs.getString("email_cliente"));
                                
                c.setCpf(rs.getString("cpf_cliente"));
                
                c.setDataNascimento(rs.getString("data_nascimento_cliente"));
                
                c.setSexo(rs.getString("sexo_cliente"));
            }
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return c;
    }
    
    public static void opcoesPedido()throws Exception {
        int opcao = 1;
        
        while (opcao != 4) {
            System.out.println("""
                   \n \n My Feet - ESCOLHA UMA OPÇÃO:
                    1 - Finalizar Compras
                    2 - Remover item
                    3 - Atualizar
                    4 - Cancelar
                    """);
            opcao = teclado.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.println(ClienteDAO.finalizarPedido());
                    break;
                    
                case 2:
                    System.out.println(ClienteDAO.removerItem());
                    break;
                    
                case 3: 
                    verPedidoAtualizado();
                    break;
                    
                default: 
                        if (opcao != 4) {
                            System.out.println("Digite uma opcao valida!");
                        }
                        break;
                    
                    
            }
        }
        
    }
    
    public static void verPedidoAtualizado()throws Exception {
        List<ProdutoPedido> listPedido = new ArrayList<ProdutoPedido>();
        
        try {
            
            String sql = "SELECT pp.id_produto, pp.nome_produto, pp.quantidade_produto, pp.preco_produto, pp.tamanho_produto, p.numero_pedido, p.id_cliente, p.data_pedido, p.ind_pedido_finalizado, c.nome_cliente, c.id_cliente, c.endereco_cliente, c.telefoneFixo_cliente, c.email_cliente, c.cpf_cliente, c.data_nascimento_cliente, c.sexo_cliente FROM tbProdutoPedido pp INNER JOIN tbPedido p ON pp.numero_pedido = p.numero_pedido INNER JOIN tbCliente c ON c.id_cliente = p.id_cliente AND p.ind_pedido_finalizado = 'n'";
            
            connection = GerenteDeConexao.getConnection();
            
            st = connection.prepareStatement(sql);
            
            rs = st.executeQuery();
            
            int i = 0;
            
            while(rs.next()) {
                
                i++;

                Pedido p = new Pedido();
                Produto pr = new Produto();
                ProdutoPedido pp = new ProdutoPedido();
                Cliente c = new Cliente();

                
                p.setNumeroPedido(rs.getInt("p.numero_pedido"));
                
                p.setDataPedido(rs.getString("p.data_pedido"));
                
                c.setId_cliente(rs.getInt("c.id_cliente"));
                
                c.setNome(rs.getString("nome_cliente"));
                
                c.setEndereco(rs.getString("endereco_cliente"));
                
                c.setTelefoneFixo(rs.getString("telefoneFixo_cliente"));
                
                c.setEmail(rs.getString("email_cliente"));
                                
                c.setCpf(rs.getString("cpf_cliente"));
                
                c.setDataNascimento(rs.getString("data_nascimento_cliente"));
                
                c.setSexo(rs.getString("sexo_cliente"));

                p.setCliente(c);
                
                
                
                
                pr.setId_produto(rs.getInt("pp.id_produto"));
                
                pr.setNome_produto(rs.getString("pp.nome_produto"));
                
                pr.setNumero_produto(i);
                
                pr.setPreco_produto(rs.getFloat("pp.preco_produto"));
                
                pr.setTamanho_produto(rs.getString("pp.tamanho_produto"));
                

                
                pp.setQuantidadeProduto(rs.getInt("pp.quantidade_produto"));
                
                pp.setPedido(p);
                
                pp.setProduto(pr);
                
                
                
                listPedido.add(pp);
                
                
            }
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("\n \n" + listPedido + "\n \n"); 
    }
    
    public static String removerItem() {
        String resultado = "";
        int ret = 0;
        int numeroPedido = 0;
        
        System.out.println("\n \nREMOVER PRODUTO");
        System.out.println("Digite o numero do pedido do produto e tecle ENTER");
        numeroPedido = teclado.nextInt();
        
        if(verificarPedido(numeroPedido)) {

            try {

                String sql = "DELETE FROM tbPedido WHERE numero_pedido = ?";

                connection = GerenteDeConexao.getConnection();

                st = connection.prepareStatement(sql);

                st.setInt(1, numeroPedido);

                ret = st.executeUpdate();
                
                resultado = "\n \n Produto removido com sucesso! \n \n";
                
                st.close();

            }catch (Exception e) {
                System.out.println(e.getMessage());
                resultado = "\n \n Falha ao tentar remover o produto \n \n";
            }
        } else {
            resultado = "\n \nEste pedido nao existe! \n \n";
        }
        
        return resultado;
    }
    
    public static boolean verificarPedido(int numeroPedido) {
        
        try{
            
            String sql = "SELECT * FROM tbPedido WHERE numero_pedido = ?";
            
            connection = GerenteDeConexao.getConnection();
            
            st = connection.prepareStatement(sql);
            
            st.setInt(1, numeroPedido);
            
            rs = st.executeQuery();
            
            if(rs.next()) {
                return true;
            }else{
                return false;
            }
            
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        
    }
    
    public static String finalizarPedido() {
        String resultado = "";
        int ret = 0;
        
        try {
            
            System.out.println("DIGITE O NUMERO DO PEDIDO! E TECLE ENTER");
            int numeroPedido = teclado.nextInt();
            
            String sql = "UPDATE tbPedido SET ind_pedido_finalizado = 's' WHERE numero_pedido = ?";
            
            connection = GerenteDeConexao.getConnection();
            
            st = connection.prepareStatement(sql);
            
            st.setInt(1, numeroPedido);
            
            ret = st.executeUpdate();
            
            resultado = "\n \n Obrigado por comprar na My Feet! \n \n";
            
            st.close();
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
            resultado = " \n \n Falha ao finalizar o pedido \n \n";
        }
        
        return resultado;
    }
    
    public static boolean verificarProdutoNoPedido(int id_produto) {
        
        
        try {
            
            String sql = "SELECT * FROM tbProdutoPedido WHERE id_produto = ?";
            
            connection = GerenteDeConexao.getConnection();
            
            st = connection.prepareStatement(sql);
            
            st.setInt(1, id_produto);
            
            rs = st.executeQuery();
            
            if(rs.next()) {
                return false;
            }else {
                return true;
            }
            
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    /*SOMENTE ADM*/
    public static String adcionarProduto()throws Exception {
    
        String resultado = "";
        
        return resultado;
    
    }

    
    
    
}
