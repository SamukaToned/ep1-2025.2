import java.util.Scanner;
import java.util.ArrayList;

public class CadastroPlanodeSaude {
    Scanner scan = new Scanner(System.in);
    Paciente pacientee;
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
                int i = 0;
                for(Especializacao especialidade : especialidades){
                    i++;
                    System.out.println(especialidade + "Desconto: %");
                    desconto[i]=scan.nextDouble();
                }
                i=0;
                if (paciente.getIdade() > 60) {
                    for(i=0; i<13; i++){
                        desconto[i]*=2;
                    }
                }

            } else{
                nomePlano="Não cadastrado";
                idPlano="Não cadastrado;";
                for(int i=0; i<13; i++){
                    desconto[i]=0;
                }
            }
        }
    }
    String getNomePlano(){
        return nomePlano;
    }

    String getID(){
        return idPlano;
    }

    double[] getDesconto(){
        return desconto;
    }


}
