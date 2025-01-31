import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        Autor autor01 = new Autor(1,"Colleen Hoover",new Date());
        Autor autor02 = new Autor(2,"John Green", new Date());
        Autor autor03 = new Autor(3,"Bonnie Garmus",new Date());
        Autor autor04 = new Autor(4,"Jostein Gaarder", new Date());
        Autor autor05 = new Autor(5,"Toshikazu Kawaguchi", new Date());


        biblioteca.adicionarAutor(autor01);
        biblioteca.adicionarAutor(autor02);
        biblioteca.adicionarAutor(autor03);
        biblioteca.adicionarAutor(autor04);
        biblioteca.adicionarAutor(autor05);

        Livro livro01 = new Livro(1,"É assim que acaba", autor01);
        Livro livro02 = new Livro (2,"A culpa é das estrelas", autor02);
        Livro livro03 = new Livro(3,"É assim que começa", autor01);
        Livro livro04 = new Livro (4,"Uma questão de química", autor03);
        Livro livro05 = new Livro(5,"O mundo de Sofia", autor04);
        Livro livro06 = new Livro (6,"Antes que o café esfrie", autor05);
        Livro livro07 = new Livro(7,"A garota das laranjas", autor04);
        Livro livro08 = new Livro (8,"Todas as suas imperfeições", autor01);
        Livro livro09 = new Livro(9,"Antes que o café esfrie 2", autor05);
        Livro livro10 = new Livro (10,"O teorema de katherine", autor02);

        biblioteca.adicionarLivro(livro01);
        biblioteca.adicionarLivro(livro02);
        biblioteca.adicionarLivro(livro03);
        biblioteca.adicionarLivro(livro04);
        biblioteca.adicionarLivro(livro05);
        biblioteca.adicionarLivro(livro06);
        biblioteca.adicionarLivro(livro07);
        biblioteca.adicionarLivro(livro08);
        biblioteca.adicionarLivro(livro09);
        biblioteca.adicionarLivro(livro10);

        while(true) {
            System.out.println("Deseja visualizar os livros disponíveis no momento para emprestimo? (sim/não)");
            String resposta = scanner.nextLine().toLowerCase();

            if(resposta.equals("sim")) {
                List<Livro> livrosDisponiveis = biblioteca.listarLivrosDisponiveis();

                if (livrosDisponiveis.isEmpty()) {
                    System.out.println("Não há livros disponíveis no momento");
                } else {
                    System.out.println("Livros disponíveis");
                    for (Livro livro : livrosDisponiveis) {
                        System.out.println(livro.getId() + ":" + livro.getTitulo());
                    }


                    System.out.println("Digite o ID do livro que voce deseja emprestar:");
                    int idLivro = scanner.nextInt();
                    scanner.nextLine();

                    Livro livroSelecionado = biblioteca.buscarLivroPorId(idLivro);

                    if (livroSelecionado != null && livroSelecionado.isDisponivel()) {
                        System.out.println("Digite seu nome:");
                        String nomeUsuario = scanner.nextLine();

                        biblioteca.emprestarLivros(livroSelecionado, nomeUsuario);
                        System.out.println("O livro " + livroSelecionado.getTitulo() + " foi emprestado para " + nomeUsuario);
                    } else {
                        System.out.println("Livro não encontrado ou não disponivel para emprestimo");
                    }

                }
            } else if(resposta.equals("nao")) {
                System.out.println("Obrigado por utilizar o sistema da biblioteca.");
                break;
            } else {
                System.out.println("Resposta inválida. Por favor, responsa 'sim'ou 'nao'. ");
            }
        }

            scanner.close();
      }
    }

