import java.util.Scanner;
import java.util.ArrayList;
public class CadastroMedico {
    Medico medico = new Medico();
    Scanner scan = new Scanner(System.in);
    private ArrayList<Medico> medicos = new ArrayList<>();

    public void cadastroMedico(){
        boolean isRegistering=true;
        while (isRegistering) {
            String nome;
            String cpf;
            String crm;
            String especialidade;
            double custo;
            String horario;
            int escolha;
            System.out.println("Digite a sequir o seguintes dados:");
            System.out.printf("Nome: ");
            nome=scan.nextLine();
            System.out.printf("\nIdade: ");
            cpf = scan.nextLine();
            System.out.printf("\nCRM: ");
            crm = scan.nextLine();
            System.out.printf("\nEspecialidade: ");
            especialidade = scan.nextLine();
            System.out.printf("\nCusto da Consulta: ");
            custo = scan.nextDouble();
            scan.nextLine();
            System.out.printf("\nHorários: ");
            scan.nextLine();
            horario=scan.nextLine();
            this.medicos.add(new Medico(nome, cpf, crm, especialidade, custo, horario));
            System.out.println("Você deseja continuar? 0 - Sim / 1 - Não");
            escolha = scan.nextInt();
            if (escolha==1) {
                isRegistering=false;
            }
        }
    }
    public ArrayList<Medico> getMedicos() {
        return medicos;
    }
    
}
//ta dando algo estanho na hora do horarios, isso vai ser alterado de qualquer forma pq vou usar a arraylist de horarios, mas de uma olhada
