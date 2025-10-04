import java.util.Scanner;
import java.util.ArrayList;

public class CadastroPlanodeSaude {
    Scanner scan = new Scanner(System.in);
    Paciente paciente = new Paciente();
    String nomePlano;
    String idPlano;
    String cpf;
    double[] desconto = new double[13];
    ArrayList<Paciente> pacientes = new ArrayList<>();
    Especializacao especialidade;
    ArrayList<Especializacao> especialidades = new ArrayList<>();
    public void cadastroPlanodeSaude(){
        System.out.println("Digite seu CPF a seguir: ");
        cpf=scan.nextLine();
        for(Paciente paciente : pacientes){
            if (paciente.getCpf().equalsIgnoreCase(cpf)) {
                System.out.println("Digite a seguir os dados do plano de saúde: ");
                System.out.println("Nome:");
                nomePlano=scan.nextLine();
                System.out.println("ID do Plano (2 digitos): ");
                idPlano=scan.nextLine();
                System.out.println("Descontos para áreas da saúde: ");
                for(Especializacao especialidade : especialidades){
                    int i = 0;
                    i++;
                    //agora eu ia fazer o desconto para cada especialidade
                }
            }
        }
    }

}
