package rpg_ambiental_pack;

import java.util.Scanner;

public class Jogo {

    // Método principal
    public static void main(String[] args) {

        // Entrada de dados 
        Scanner sc = new Scanner(System.in);

        System.out.println("=== ECOCITY RPG ===");

        System.out.print("Digite o nome do seu personagem: ");
        String nome = sc.nextLine();

        // Instanciação de objeto 
        Jogador jogador = new Jogador(nome);

        System.out.println("\nVocê chegou em uma cidade tomada pela poluição...");
        System.out.println("Sua missão é restaurar o equilíbrio ambiental!\n");

        // Vetor de objetos 
        Inimigo[] inimigos = {
            new Inimigo("Poluidor Industrial", 40, 10),
            new Inimigo("Desmatador", 50, 12),
            new Inimigo("Chefe: Senhor da Poluição", 80, 15)
        };

        // Estrutura de repetição
        for (int i = 0; i < inimigos.length; i++) {

            Inimigo inimigo = inimigos[i];

            System.out.println("\nUm inimigo apareceu: " + inimigo.nome);

            // Loop de combate
            while (jogador.estaVivo() && inimigo.estaVivo()) {

                System.out.println("\nSua vida: " + jogador.getVida());
                System.out.println("Vida do inimigo: " + inimigo.getVida());

                System.out.println("\nEscolha uma ação:");
                System.out.println("1 - Atacar");
                System.out.println("2 - Curar");
                System.out.println("3 - Tentar fugir");

                int escolha = sc.nextInt();

                // Estrutura condicional
                switch (escolha) {
                    case 1:
                        jogador.atacar(inimigo); // chamada de método
                        break;
                    case 2:
                        jogador.curar();
                        break;
                    case 3:
                        System.out.println("Você fugiu do combate!");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }

                // Ação do inimigo
                if (inimigo.estaVivo() && escolha != 3) {
                    inimigo.atacar(jogador);
                }

                if (escolha == 3) break;
            }

            if (!jogador.estaVivo()) break;

            System.out.println("\nVocê derrotou " + inimigo.nome + "!");
        }

        // Resultado final
        if (jogador.estaVivo()) {
            System.out.println("\nPARABÉNS! Você salvou a cidade da poluição! 🌱🌎");
        } else {
            System.out.println("\nVocê falhou... A cidade foi destruída 😢");
        }

        sc.close(); 
    }
}
