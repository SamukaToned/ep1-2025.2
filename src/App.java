import java.util.Scanner;
public class App {
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args){
        int choice1;
        int choice2=0;
        boolean isRunning=true;
        boolean isChoosing = true;
        boolean isChoosing2 = true;
        System.out.printf("************************************\nSistema de Gerenciamento Hospitalar\n************************************\n");
        while (isRunning) {
            while (isChoosing) {
                System.out.println("O Usuário : ");
                System.out.printf("1 - Médico\n2 - Paciente\n 3 - Sair");
                choice1=scan.nextInt();
                switch (choice1) {
                    case 1 -> menuMedico(isRunning, choice2, isChoosing);
                    case 2 -> {System.out.println("Menu paciente");
                    isChoosing=false;}
                    case 3 -> {System.out.println("Sair");
                    isChoosing=false; isRunning=false;}
                    default -> {System.out.println("Valor Invalido");
                    isChoosing=false;}
            }
            }

            
        }


        

    }
    public static void menuMedico(boolean isRunning, int choice2, boolean isChoosing){
    System.out.println("*************");
    System.out.println("Menu Medico");
    System.out.println("*************");
    System.out.println("Digite o que deseja fazer:");
    System.out.printf("1 - Cadastro\n 2 - Gerenciamento de Consultas\n 3 - Diagnosticos\n 4 - Gerenciamento de Internacoes\n 5 - Relatorio\n 6 - Sair\n");
    choice2=scan.nextInt();
    switch (choice2) {
        case 1 -> System.out.println("Cadastro");
        case 2 -> System.out.println("Gerenciamento de Consultas");
        case 3 -> System.out.println("Diagnosticos");
        case 4 -> System.out.println("Gerenciamento Internacoes");
        case 5 -> System.out.println("Relatorios");
        case 6 -> {System.out.println("Saindo...");
        isRunning=false; isChoosing=false;}
        default -> {System.out.println("Valor Invalido");}
    }
}

}

