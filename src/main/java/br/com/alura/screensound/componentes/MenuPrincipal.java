package br.com.alura.screensound.componentes;

import br.com.alura.screensound.models.Artista;
import br.com.alura.screensound.models.TiposArtistas;
import br.com.alura.screensound.repositories.ArtistaRepository;

import java.util.Scanner;

public class MenuPrincipal {

    private Scanner scan = new Scanner(System.in);
    private ArtistaRepository artistaRepository;


    public MenuPrincipal(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
    }

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
                     cadastrarArtista();
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

    private void cadastrarArtista() {

        var continuar = "S";

        while (continuar.equalsIgnoreCase("S")) {
            System.out.println("\nInforme o nome do artista: ");
            var nome = scan.nextLine();
            System.out.println("\nInforme o tipo do artista (solo, dupla ou banda)");
            var tipoEmString = scan.nextLine();
            TiposArtistas tipo = TiposArtistas.fromString(tipoEmString);
            Artista artista = new Artista(nome, tipo);
            artistaRepository.save(artista);
            System.out.println("\nArtista cadastrado! Deseja cadastrar outor artista (S/N)?");
            continuar = scan.nextLine();
        }
    }

}
