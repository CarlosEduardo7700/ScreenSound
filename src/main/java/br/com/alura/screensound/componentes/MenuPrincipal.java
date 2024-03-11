package br.com.alura.screensound.componentes;

import java.util.Scanner;

public class MenuPrincipal {

    private Scanner scan = new Scanner(System.in);

    public void exibirMenu() {
         var opcao = -1;

         while (opcao != 0) {
             System.out.println("""
                     
                     Escolha uma das opções abaixo:
                     
                     1 - Cadastrar artista
                     2 - Cadastrar músicas
                     3 - Listar músicas
                     4 - Buscar músicas pelo artista
                     5 - Pesquisar dados sobre um artista
                     
                     0 - Sair...
                     
                     Informe uma opção:
                     """);

             opcao = scan.nextInt();
             scan.nextLine();

             switch (opcao) {
                 case 1:
                     System.out.println("Cadastrando artista...");
                     break;
                 case 2:
                     System.out.println("Cadastrando música...");
                     break;
                 case 3:
                     System.out.println("Listando músicas...");
                     break;
                 case 4:
                     System.out.println("Buscando músicas...");
                     break;
                 case 5:
                     System.out.println("Pesquisando dados...");
                     break;
                 case 0:
                     System.out.println("Saindo...");
                     break;
                 default:
                     System.out.println("Opção inválida! Tente novamente.");
             }
         }
    }

}
