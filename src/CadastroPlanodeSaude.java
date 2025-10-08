import java.util.Scanner;
import java.util.ArrayList;

public class CadastroPlanodeSaude {
    Scanner scan = new Scanner(System.in);
    Paciente paciente;
    String nomePlano;
    String idPlano;
    String cpf;
    double[] desconto = new double[13];
    ArrayList<Paciente> pacientes = new ArrayList<>();
    Especializacao especialidade;
    ArrayList<Especializacao> especialidades = new ArrayList<>();
    public void CadastroPlanoSaude(){
        System.out.println("Digite seu CPF a seguir: ");
        cpf=scan.nextLine();
        boolean founded=false;
        String cpfDigitado = cpf.replaceAll("[^0-9]", "");
        try{
            for(Paciente paciente : pacientes){
            String cpfPaciente = paciente.getCpf().replaceAll("[^0-9]", "");
            if (cpfDigitado.equalsIgnoreCase(cpfPaciente)) {
                founded=true;
                System.out.println("Digite a seguir os dados do plano de saúde: ");
                System.out.println("Nome:");
                nomePlano=scan.nextLine();
                System.out.println("ID do Plano (2 digitos): ");
                idPlano=scan.nextLine();
                System.out.println("Descontos para áreas da saúde: ");
                for(int i = 0; i < especialidades.size() && i < desconto.length; i++){
                    System.out.println(especialidade + "Desconto: %");
                    desconto[i]=scan.nextDouble();
                }
               
                if (paciente.getIdade() > 60) {
                    for(int i=0; i<13; i++){
                        desconto[i]*=2;
                    }
                } break;
            }
        }
        }catch(java.lang.NullPointerException e){
            System.out.println("Nenhum cpf foi cadastrado.");
        }
        if (!founded) {
            System.out.println("Cpf digitado errado ou usuário não cadastrado, você será redirecionado para o menu de pacientes.");
        }
    }
    public String getNomePlano(){
        return nomePlano;
    }

    public String getID(){
        return idPlano;
    }

    public double[] getDesconto(){
        return desconto;
    }


}
