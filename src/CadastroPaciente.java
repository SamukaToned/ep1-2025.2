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
            int escolha;
            System.out.println("Digite a sequir o seguintes dados:");
            System.out.printf("Nome: ");
            nome=scan.nextLine();
            System.out.printf("\nCPF: ");
            cpf = scan.nextLine();
            System.out.printf("\nIdade: ");
            while (true) {
                try {
                    System.out.print("Idade: ");
                    idade = Integer.parseInt(scan.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Digite um número válido para a idade.");
                }
            }

            this.pacientes.add(new Paciente(nome, cpf, idade));
            while (true) {
                try {
                    System.out.println("Você deseja continuar? 0 - Sim / 1 - Não");
                    escolha = Integer.parseInt(scan.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Precisa ser entre 0 e");
                }
            }
            System.out.println("Você deseja continuar? 0 - Sim / 1 - Não");
            escolha = scan.nextInt();
            if (escolha==1) {
                isRegistering=false;
            }
            
        }
    }
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
    
}
//ta dando bosta em alguma coisa ai, da uma olhada, não sei se tá bom a consulta. 
