import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        String receita, passo, ingredient, quantidade;
        ArrayList<String> passoapasso = new ArrayList<>();
        ArrayList<String> ingredientes = new ArrayList<>();
        ArrayList<String> quantidades = new ArrayList<>();
        int contador = 1, contador2 = 1;


        System.out.println("Digite o nome de Sua receita: ");
        receita = ler.nextLine();

        // while para adição dos ingredientes
        while (true) {
            System.out.printf("\n\nDigite o %d ingrediente de sua receita: ", contador2);
            System.out.println("\nCaso Deseje finalizar a adição de ingredientes não digite nada e aperte ENTER.");
            ingredient = ler.nextLine();
            if (ingredient.isEmpty()) {
                break;
            }
            ingredientes.add(ingredient);

            System.out.print("Quantidade: ");
            quantidade = ler.nextLine();
            quantidades.add(quantidade);

            contador2++;
        }
        // while para adicão dos passo a passos
        while (true) {
            System.out.printf("%d passo: ", contador);
            System.out.println("\nCaso Deseje finalizar a adição de passos não digite nada e aperte ENTER.");
            passo = ler.nextLine();

            if(passo.isEmpty()){
                break;
            }
            
            passoapasso.add(passo);
            contador ++;
        }

        System.out.println(receita);
        System.out.println("\nPIngredientes");

        for(int i = 0; i < ingredientes.size(); i++ ){
            System.out.println((i +1) + ". " + ingredientes.get(i) + " - " + quantidades.get(i));
        }
        System.out.println("\nPasso a passo da receita:");

        for(int i = 0; i < passoapasso.size(); i++ ){
            System.out.println((i +1) + ". " + passoapasso.get(i));
        }

        // Parte qua baixa o arquivo em formato .txt no pc
        try {

            FileWriter arquivo = new FileWriter(receita + ".txt");

            arquivo.write(receita + "\n\n");

            arquivo.write("Ingredientes:\n");

            for(int i = 0; i < ingredientes.size(); i++ ) {

                arquivo.write((i +1) + ". "
                + ingredientes.get(i)
                + " - "
                + quantidades.get(i)
                + "\n");
            }

            arquivo.write("\nModo de Preparo:\n");

            for(int i = 0; i < passoapasso.size(); i++ ) {

                arquivo.write((i +1) + ". "
                + passoapasso.get(i)
                + "\n");
            }

            arquivo.close();

            System.out.println("Arquivo salvo");

        } catch(IOException e) {

            System.out.println("Erro ao salvar arquivo.");
        }            


        ler.close();
    }
}