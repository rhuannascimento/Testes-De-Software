package stringsearch;

import java.util.Scanner;

public class MainSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Digite um inteiro positivo entre 1 e 20: ");
            int len = Integer.parseInt(sc.nextLine().trim());
            StringSearch.validateLength(len);

            System.out.print("Digite uma cadeia de caracteres com comprimento " + len + ": ");
            String s = sc.nextLine();
            while (!StringSearch.matchesLength(s, len)) {
                System.out.print("Comprimento incorreto. Digite novamente: ");
                s = sc.nextLine();
            }

            boolean continuar = true;
            while (continuar) {
                System.out.print("Digite um caractere para procurar: ");
                String line = sc.nextLine();
                if (line.isEmpty()) {
                    System.out.println("Nenhum caractere informado.");
                } else {
                    char c = line.charAt(0);
                    int pos = StringSearch.findFirstChar(s, c);
                    if (pos == -1) System.out.println("Caractere não encontrado na cadeia.");
                    else System.out.println("Caractere encontrado na posição: " + pos);
                }

                System.out.print("Deseja procurar outro caractere? (s/n): ");
                String ans = sc.nextLine().trim().toLowerCase();
                continuar = ans.startsWith("s");
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida para o inteiro.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
