package br.com.alura.screensound.componentes;

import br.com.alura.screensound.models.Artista;
import br.com.alura.screensound.models.Musica;
import br.com.alura.screensound.models.TiposArtistas;
import br.com.alura.screensound.repositories.ArtistaRepository;

import java.util.List;
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
                     cadastrarMusica();
                     break;
                 case 3:
                     listarMusicas();
                     break;
                 case 4:
                     buscarMusicaPeloArtista();
                     break;
                 case 5:
                     perquisarDadosDoArtista();
                     break;
                 case 0:
                     System.out.println("Saindo...");
                     break;
                 default:
                     System.out.println("Opção inválida! Tente novamente.");
             }
         }
    }

    private void perquisarDadosDoArtista() {
        System.out.println("Informe o nome do artista:");
        var nome = scan.nextLine();
        var artista = artistaRepository.findByNomeContainingIgnoreCase(nome);
        System.out.println(artista);
    }

    private void buscarMusicaPeloArtista() {
        System.out.println("Informe o nome do artista:");
        var nomeDoArtista = scan.nextLine();
        List<Musica> musicas = artistaRepository.buscarMusicasPorArtista(nomeDoArtista);
        musicas.forEach(System.out::println);
    }


    private void listarMusicas() {
        List<Artista> artistas = artistaRepository.findAll();
        artistas.forEach(a -> a.getMusicas().forEach(System.out::println));
    }

    private void cadastrarMusica() {
        System.out.println("Informe o nome do artista para cadastrar sua música:");
        var nomeArtista = scan.nextLine();
        var artista = artistaRepository.findByNomeContainingIgnoreCase(nomeArtista);

        if (artista.isPresent()) {
            System.out.println("\nInforme o nome da música: ");
            var nome = scan.nextLine();

            System.out.println("\nInforme o nome do álbum");
            var album = scan.nextLine();

            Musica musica = new Musica(nome, album);
            musica.setArtista(artista.get());

            artista.get().getMusicas().add(musica);
            artistaRepository.save(artista.get());

            System.out.println("\nMúsica cadastrada!");
        } else {
            System.out.println("Artista não encontrado!");
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
            System.out.println("\nArtista cadastrado! Deseja cadastrar outro artista (S/N)?");
            continuar = scan.nextLine();
        }
    }

}
