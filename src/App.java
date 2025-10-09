import java.util.InputMismatchException;
import java.util.Scanner;
public class App {
    static Scanner scan = new Scanner(System.in);
    static CadastroMedico cadastroMedico = new CadastroMedico();
    static CadastroPaciente cadastroPaciente = new CadastroPaciente();
    static GerenciamentoConsultas gerenciamentoConsultas = new GerenciamentoConsultas();
    static Consultas consultas = new Consultas(cadastroPaciente, cadastroMedico, gerenciamentoConsultas.getconsultasCadastradas());
    static CadastroPlanodeSaude cadastroPlanodeSaude = new CadastroPlanodeSaude();
    static Internacoes internacoes = new Internacoes(cadastroMedico, cadastroPaciente);
    static GerenciamentoInternacoes gerenciamentoInternacoes = new GerenciamentoInternacoes();
    public static void main(String[] args){
        int choice1;
        int choice2=0;
        boolean isRunning=true;
        System.out.println("--------------------------------------------");
        System.out.println("Sistema de Gerenciamento Hospitalar");
        System.out.println("--------------------------------------------");
        
        try {
            while (isRunning) {
                System.out.println("-------------------------");
                System.out.println("O Usuário é: ");
                System.out.printf("1 - Médico\n2 - Paciente\n3 - Sair\n");
                System.out.println("-------------------------");
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
    double valorInternacao = 0;
    while (isChoosing) {
        try{
            System.out.println("----------------");
        System.out.println("Menu Medico");
        System.out.println("----------------");
        System.out.println("Digite o que deseja fazer:");
        System.out.printf("1 - Cadastro\n2 - Gerenciamento de Consultas\n3 - Gerenciamento de Internacoes\n4 - Mostar Medicos\n5 - Voltar\n6 - Voltar\n");
        choice2=scan.nextInt();
        switch (choice2) {
            case 1 -> cadastroMedico.cadastroMedico();
            case 2 -> gerenciamentoConsultas.gerenciandoConsultas(cadastroMedico);
            case 3 -> gerenciamentoInternacoes.gerenciamentoInternacoes(cadastroMedico, valorInternacao);
            case 4 -> cadastroMedico.listaMedicos();
            case 5 -> {System.out.println("Voltando...");
            isChoosing=false;}
            default -> {System.out.println("Valor Inválido");}
            }
        }catch(InputMismatchException e){
            System.out.println("Entrada inválida. Digite um número inteiro.");
            scan.nextLine();
        }
    
        }
    }
    public static void menuPaciente(boolean isRunning, int choice2){
    boolean isChoosing=true;
    AgendamentoConsulta agendamentoConsulta = new AgendamentoConsulta(null, null, null, null, choice2);
    while (isChoosing) {
        try{
            System.out.println("----------------");
            System.out.println("Menu Paciente");
            System.out.println("----------------");
            System.out.println("Digite o que deseja fazer:");
            System.out.printf("1 - Cadastro\n 2 - Realizar uma Consulta\n 3 - Agendar uma Internação\n 4 - Acessar Histórico de Consultas\n 5 - Cadastrar um Plano de Saúde\n 6 - Mostrar Pacientes\n 7 - Status de Consultas\n 8 - Status de Internação\n 9 - Voltar\n");
            choice2=scan.nextInt();
            switch (choice2) {
                case 1 -> cadastroPaciente.cadastroPaciente();
                case 2 -> consultas.EscolhaConsultas();
                case 3 -> internacoes.internacoes();
                case 4 -> gerenciamentoConsultas.historicoConsultas();
                case 5 -> cadastroPlanodeSaude.CadastroPlanoSaude();
                case 6 -> cadastroPaciente.listarPacientes();
                case 7 -> agendamentoConsulta.mostrarConsultas();
                case 8 -> internacoes.mostrarInternacoes();
                case 9 -> {System.out.println("Voltando...");
                isChoosing=false;}
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