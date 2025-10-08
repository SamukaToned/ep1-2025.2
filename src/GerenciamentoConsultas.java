import java.util.ArrayList;
import java.util.Scanner;
public class GerenciamentoConsultas {
    Consultas consultas;
    AgendamentoConsulta agendamentoConsulta;
    ArrayList<AgendamentoConsulta> consultascadastradas = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    Medico medico;
    CadastroMedico cadastroMedico;
    boolean gerenciando=true;
    String crm;
    int definicaoStatus;
    public void gerenciandoConsultas(){
        String crmDigitado = crm.replaceAll("[^0-9]", "");
        while (gerenciando) {
            ArrayList<Medico> medicos=cadastroMedico.getMedicos();
            System.out.println("Digite seu CRM a seguir: ");
            crm=scan.nextLine();
            boolean crmMatchs=false;
            for(Medico medico : medicos){
                String crmMedico = medico.getCpf().replaceAll("[^0-9]", "");
                if (crmDigitado.equals(crmMedico)) {
                    crmMatchs=true;
                    this.medico=medico;
                    boolean encontraConsulta=false;
                    for(AgendamentoConsulta agendamentoConsulta : consultascadastradas){
                        if (agendamentoConsulta.getMedico().getCrm().equals(crmDigitado)) {
                            System.out.println("Você possui consultas disponíveis para gerenciar o seu status: ");
                            agendamentoConsulta.gerenciamentoPaciente();
                            System.out.println("Defina o status dessa consulta: 1 - Agendada / 2 - Concluida / 3 - Cancelada");
                            definicaoStatus=scan.nextInt();
                            agendamentoConsulta.setStatus(definicaoStatus);
                        }
                    } if (!encontraConsulta) {
                        System.out.printf("\nNenhuma consulta foi encontrada.\nVocê será redirecionado ao menu de Médicos.");
                        gerenciando=false;
                    }
                    
                } 
            } if (!crmMatchs) {
                System.out.printf("\nCRM digitado errado ou não encontrado.\nVocê será redirecionado ao menu de Médicos.");
                gerenciando=false;
            }


        }
    }

    public void statusConsultas(){
        switch (agendamentoConsulta.getStatus()) {
            case 1 -> System.out.println("Consulta com" + agendamentoConsulta.getMedico().getNome() + " para " + agendamentoConsulta.getPaciente().getNome() + " às " + 
            agendamentoConsulta.getHorario().getHour() + ":" + agendamentoConsulta.getHorario().getMinute() + " em " + agendamentoConsulta.getLocal() + " está agendada");
            case 2 -> System.out.println("Consulta com" + agendamentoConsulta.getMedico().getNome() + " para " + agendamentoConsulta.getPaciente().getNome() + " às " + 
            agendamentoConsulta.getHorario().getHour() + ":" + agendamentoConsulta.getHorario().getMinute() + " em " + agendamentoConsulta.getLocal() + " está concluída");
            case 3 -> System.out.println("Consulta com" + agendamentoConsulta.getMedico().getNome() + " para " + agendamentoConsulta.getPaciente().getNome() + " às " + 
            agendamentoConsulta.getHorario().getHour() + ":" + agendamentoConsulta.getHorario().getMinute() + " em " + agendamentoConsulta.getLocal() + " está cancelada");
        
            default -> System.out.println("Algo deu errado.");

        }
    }
// se pa compensa usar o sistema de cpf nesses 2 e exception. 
    public void historicoConsultas(){
        boolean historicoExiste = false;
        for(AgendamentoConsulta agendamentoConsulta : consultascadastradas){
            if (agendamentoConsulta.getStatus()==2) {
            System.out.println("O paciente " + agendamentoConsulta.getPaciente().getNome() + " teve uma consulta com " + agendamentoConsulta.getMedico().getNome()
             + " com o tópico de " + agendamentoConsulta.getMedico().getEspecialidade());
        }
        } if (!historicoExiste) {
            System.out.println("Não há nenhuma consulta concluída cadastrada");
        }
    }

    
}
