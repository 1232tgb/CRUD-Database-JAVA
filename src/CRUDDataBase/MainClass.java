package CRUDDataBase;

import static java.lang.System.out;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        out.println("Entre com o seu usuario:");
        String usuario = sc.next();
        out.println("Entre com a senha:");
        String password = sc.next();
        DataManager dm = new DataManager(usuario, password);
        boolean continua = true;
        while (continua) {

            out.println("\nEscolha uma das seguintes opções do menu");
            out.println("1 - Inserir registro");
            out.println("2 - Atualizar registro");
            out.println("3 - Deletar registro");
            out.println("4 - Ler registro");
            out.println("5 - Sair");

            int opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    dm.Save();
                    break;
                case 2:
                    dm.Update();
                    break;
                case 3:
                    dm.Delete();
                    break;
                case 4:
                    dm.Consult();
                    break;
                case 5:
                    dm.CloseConection();
                    continua = false;
                    break;
            }
        }
        out.println("Você saiu do programa.");
    }

}
