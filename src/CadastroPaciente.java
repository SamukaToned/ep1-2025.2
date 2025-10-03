import java.util.Scanner;
import java.util.ArrayList;
public class CadastroPaciente {
    Paciente paciente = new Paciente();
    Scanner scan = new Scanner(System.in);
    private ArrayList<Paciente> pacientes = new ArrayList<>();

    public void cadastroPaciente(){
        boolean isRegistering=true;
        while (isRegistering) {
            String nome;
            String cpf;
            int idade;
            //falta histórico de consultas e historico de internações
            int escolha;
            System.out.println("Digite a sequir o seguintes dados:");
            System.out.printf("Nome: ");
            nome=scan.nextLine();
            System.out.printf("\nCPF: ");
            cpf = scan.nextLine();
            System.out.printf("\nIdade: ");
            idade = scan.nextInt();
            this.pacientes.add(new Paciente(nome, cpf, idade));
            System.out.println("Você deseja continuar? 0 - Sim / 1 - Não");
            escolha = scan.nextInt();
            if (escolha==1) {
                isRegistering=false;
            }
        }
        scan.close();
    }
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
    
}
