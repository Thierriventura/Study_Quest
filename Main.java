import java.util.Scanner;

class Personagem {
    String nome;
    int vida;

    public Personagem(String nome, int vida) {
        this.nome = nome;
        this.vida = vida;
    }

    public boolean estaVivo() {
        return this.vida > 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Personagem jogador = new Personagem("Aventureiro", 100);
        Personagem dragao = new Personagem("Dragao de Java", 50);

        System.out.println("=== BATALHA INICIADA ===");

        System.out.println("\nPara derrotar o " + dragao.nome + " voce precisa acertar a pergunta.\n");

        String[] perguntas = {
                "O que e um objeto em Java?",
                "Qual palavra-chave e usada para heranca em Java?",
                "Qual tipo de dado e usado para verdadeiro ou falso?"
        };

        String[][] alternativas = {
                { "1) Instancia de uma classe", "2) Um tipo primitivo de dado" },
                { "1) implements", "2) extends" },
                { "1) boolean", "2) bool" }
        };

        String[] respostasCorretas = { "1", "2", "1" };
        int indicePergunta = 0;

        while (jogador.estaVivo() && dragao.estaVivo() && indicePergunta < perguntas.length) {
            System.out.println("\n--- Rodada " + (indicePergunta + 1) + " ---");
            System.out.println("Pergunta: " + perguntas[indicePergunta]);
            System.out.println(alternativas[indicePergunta][0]);
            System.out.println(alternativas[indicePergunta][1]);
            System.out.print("Sua resposta (1 ou 2): ");

            String respostaUsuario = scanner.nextLine();

            if (respostaUsuario.equals(respostasCorretas[indicePergunta])) {
                System.out.println("\nAcertou! Voce causou 50 de dano ao dragao.");
                dragao.vida -= 50;
            } else {
                System.out.println("\nErrou! O dragao atacou voce e causou 30 de dano.");
                jogador.vida -= 30;
            }

            System.out.println("Sua vida: " + jogador.vida);
            System.out.println("Vida do dragao: " + dragao.vida);

            indicePergunta++;
        }

        System.out.println("\n--- STATUS FINAL ---");
        if (!dragao.estaVivo()) {
            System.out.println("Parabens! Voce derrotou o " + dragao.nome + " e venceu a partida!");
        } else if (!jogador.estaVivo()) {
            System.out.println("Voce perdeu toda a sua vida! Game Over.");
        } else {
            System.out.println("Acabaram as perguntas e a batalha terminou sem um vencedor.");
        }

        scanner.close();
    }
}