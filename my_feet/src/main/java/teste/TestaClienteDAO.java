/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package teste;

import persistencia.ClienteDAO;

public class TestaClienteDAO {

    public static void main(String[] args)throws Exception {
        var opcao = ClienteDAO.exibirMenu();
        
        while (opcao != 8) {
            try {
                switch (opcao) {
                    case 1: /*FUNCIONANDO*/
                        System.out.println("\n \n" + ClienteDAO.abrirConta() + "\n \n");
                        break;
                        
                    case 2: /*FUNCIONANDO*/
                        System.out.println("\n \n" + ClienteDAO.listarContas() + "\n \n");;
                        break;
                        
                    case 3: /*FUNCIONANDO*/
                        ClienteDAO.menuComprar();
                        break;
                        
                    case 4: /*FUNCIONANDO*/
                        System.out.println("\n \n" + ClienteDAO.excluirConta() + "\n \n");
                        break;
                        
                    case 5: /*FUNCIONANDO*/
                        System.out.println("\n \n" + ClienteDAO.listaConta() + "\n \n");
                        break;
                    
                    case 6: /*FUNCIONANDO*/
                        System.out.println("\n \n" + ClienteDAO.alterarConta() + "\n \n");
                        break;
                        
                    case 7:
                        ClienteDAO.verPedido();
                        break;
                        
                    default: 
                        if (opcao != 8) {
                            System.out.println("\n \n Digite uma opcao valida! \n \n");
                        }
                        break;
                    
                }
            }catch (Exception e) {
                System.out.println(e.getMessage());
            }
            opcao = ClienteDAO.exibirMenu();
            
        }
        
        System.out.println("\n \n Finalizando a aplicao \n \n");
        
    }
    
}
