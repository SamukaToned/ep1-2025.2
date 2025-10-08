import java.util.InputMismatchException;
import java.util.Scanner;
public class App {
    static Scanner scan = new Scanner(System.in);
    static CadastroMedico cadastroMedico = new CadastroMedico();
    static CadastroPaciente cadastroPaciente = new CadastroPaciente();
    static Consultas consultas = new Consultas(cadastroPaciente, cadastroMedico);
    static CadastroPlanodeSaude cadastroPlanodeSaude = new CadastroPlanodeSaude();
    static GerenciamentoConsultas gerenciamentoConsultas = new GerenciamentoConsultas();
    public static void main(String[] args){
        int choice1;
        int choice2=0;
        boolean isRunning=true;
        System.out.printf("************************************\nSistema de Gerenciamento Hospitalar\n************************************\n");
        
        try {
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
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Digite um número inteiro.");
            scan.nextLine();
        } catch(Exception e){
            System.out.println("Houve um erro inesperado: " + e.getMessage());
        }

    }
    public static void menuMedico(boolean isRunning, int choice2){
    boolean isChoosing=true;
    while (isChoosing) {
        try{
            System.out.println("*************");
        System.out.println("Menu Medico");
        System.out.println("*************");
        System.out.println("Digite o que deseja fazer:");
        System.out.printf("1 - Cadastro\n 2 - Gerenciamento de Consultas\n 3 - Diagnosticos\n 4 - Gerenciamento de Internacoes\n 5 - Relatorio\n 6 - Mostar Medicos\n 7 - Sair\n");
        choice2=scan.nextInt();
        switch (choice2) {
            case 1 -> cadastroMedico.cadastroMedico();
            case 2 -> gerenciamentoConsultas.gerenciandoConsultas();
            case 3 -> System.out.println("Diagnosticos");
            case 4 -> System.out.println("Gerenciamento Internacoes");
            case 5 -> System.out.println("Relatorios");
            case 6 -> cadastroMedico.listaMedicos();
            case 7 -> {System.out.println("Saindo...");
            isRunning=false; isChoosing=false;}
            default -> {System.out.println("Valor Inválido");}
            }
        }catch(InputMismatchException e){
            
        }
    
        }
    }
    public static void menuPaciente(boolean isRunning, int choice2){
    boolean isChoosing=true;
    while (isChoosing) {
        try{
            System.out.println("*************");
            System.out.println("Menu Paciente");
            System.out.println("*************");
            System.out.println("Digite o que deseja fazer:");
            System.out.printf("1 - Cadastro\n 2 - Realizar uma Consulta\n 3 - Agendar uma Internação\n 4 - Acessar Histórico de Consultas\n 5 - Cadastrar um Plano de Saúde\n 6 - Mostrar Pacientes\n 7 - Status de Consultas\n 8 - Sair\n");
            choice2=scan.nextInt();
            switch (choice2) {
                case 1 -> cadastroPaciente.cadastroPaciente();
                case 2 -> consultas.EscolhaConsultas();
                case 3 -> System.out.println("Agendar uma Internação");
                case 4 -> gerenciamentoConsultas.historicoConsultas();
                case 5 -> cadastroPlanodeSaude.CadastroPlanoSaude();
                case 6 -> cadastroPaciente.listarPacientes();
                case 7 -> gerenciamentoConsultas.statusConsultas();
                case 8 -> {System.out.println("Saindo...");
                isRunning=false; isChoosing=false;}
                default -> {System.out.println("Valor Invalido");}
            }
        }catch(InputMismatchException e){
            System.out.println("Entrada inválida. Digite um número inteiro.");
            scan.nextLine();
        }
    }
}
}

//fazer coisa da exception e salvar arquivos