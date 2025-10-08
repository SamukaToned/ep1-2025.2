import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
public class CadastroPaciente {
    Paciente paciente = new Paciente();
    Scanner scan = new Scanner(System.in);
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<PacienteEspecial> pacientesespeciais = new ArrayList<>();

    public void cadastroPaciente(){
        boolean isRegistering=true;
        int evitarSpaceNome=0;
        while (isRegistering) {
            String nome = "";
            String cpf = "";
            int idade = 0;
            int escolha;
            if (evitarSpaceNome==1) {
                scan.nextLine();
            }
            System.out.println("Digite a sequir o seguintes dados:");
            System.out.printf("Nome: ");
            nome=scan.nextLine();
            System.out.printf("\nCPF: ");
            cpf = scan.nextLine();
            System.out.printf("\nIdade: ");
                try {
                    idade = scan.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Digite um número válido para a idade. Inteiro");
                }

            this.pacientes.add(new Paciente(nome, cpf, idade));

                try {
                    System.out.println("Você deseja continuar? 0 - Sim / 1 - Não");
                    escolha = scan.nextInt();
                    if (escolha==1) {
                        isRegistering=false;
                    } else evitarSpaceNome=1;
                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido, tem que ser inteiro, ou 0 ou 1");
                }
        }
    }
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }
    public ArrayList<PacienteEspecial> getPacienteEspeciais(){
        return pacientesespeciais;
    }
    
    public void listarPacientes(){
        if (paciente==null) {
            System.out.println("Nenhum paciente foi cadastrado.");
        } else{
            System.out.println("Esses são os pacientes cadastrados: ");
            for(Paciente paciente : pacientes){
                System.out.println(paciente);
            }
        }
    }
}
    

//ta dando bosta em alguma coisa ai, da uma olhada, não sei se tá bom a consulta. 
