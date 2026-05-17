import java.nio.channels.Pipe.SourceChannel;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        String receita, passo;
        ArrayList<String> passoapasso = new ArrayList<>();
        int contador = 1;


        System.out.println("Digite o nome de Sua receita: ");
        receita = ler.nextLine();

        while (true) {
            System.out.printf("%d passo: ", contador);
            System.out.println("\nCaso Deseje finalizar a receita não digite nada e aperte ENTER.");
            passo = ler.nextLine();

            if(passo.isEmpty()){
                break;
            }
            
            passoapasso.add(passo);
            contador ++;
        }

        System.out.println(receita);
        System.out.println("\nPasso a passo da receita:");
        for(int i = 0; i < passoapasso.size(); i++ ){
            System.out.println((i +1) + ". " + passoapasso.get(i));
        }

        ler.close();
    }
}