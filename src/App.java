import java.util.Scanner;
public class App {
    static Scanner scan = new Scanner(System.in);
    static CadastroMedico cadastroMedico = new CadastroMedico();
    public static void main(String[] args){
        int choice1;
        int choice2=0;
        boolean isRunning=true;
        System.out.printf("************************************\nSistema de Gerenciamento Hospitalar\n************************************\n");
        while (isRunning) {
                System.out.println("O Usuário é: ");
                System.out.printf("1 - Médico\n2 - Paciente\n 3 - Sair\n");
                choice1=scan.nextInt();
                switch (choice1) {
                    case 1 -> menuMedico(isRunning, choice2);
                    case 2 -> menuPaciente(isRunning, choice2);
                    case 3 -> {System.out.println("Saindo...");
                    isRunning=false;}
                    default -> System.out.println("Valor Inválido");
                    
            }

            
        }


        

    }
    public static void menuMedico(boolean isRunning, int choice2){
    boolean isChoosing=true;
    Medico medico = new Medico();
    while (isChoosing) {
        System.out.println("*************");
        System.out.println("Menu Medico");
        System.out.println("*************");
        System.out.println("Digite o que deseja fazer:");
        System.out.printf("1 - Cadastro\n 2 - Gerenciamento de Consultas\n 3 - Diagnosticos\n 4 - Gerenciamento de Internacoes\n 5 - Relatorio\n 6 - Sair\n");
        choice2=scan.nextInt();
        switch (choice2) {
            case 1 -> cadastroMedico.cadastroMedico();
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
    public static void menuPaciente(boolean isRunning, int choice2){
    boolean isChoosing=true;
    while (isChoosing) {
        System.out.println("*************");
        System.out.println("Menu Paciente");
        System.out.println("*************");
        System.out.println("Digite o que deseja fazer:");
        System.out.printf("1 - Cadastro\n 2 - Realizar uma Consulta\n 3 - Agendar uma Internação\n 4 - Acessar Histórico de Consultas\n 5 - Cadastrar um Plano de Saúde\n 6 - Sair\n");
        choice2=scan.nextInt();
        switch (choice2) {
            case 1 -> System.out.println("Cadastro");
            case 2 -> System.out.println("Realizar uma Consulta");
            case 3 -> System.out.println("Agendar uma Internação");
            case 4 -> System.out.println("Acessar Histórico de Consultas");
            case 5 -> System.out.println(" Cadastrar um Plano de Saúde");
            case 6 -> {System.out.println("Saindo...");
            isRunning=false; isChoosing=false;}
            default -> {System.out.println("Valor Invalido");}
    }
    
    }
}

}

//fazer coisa da exception e salvar arquivos