import java.util.ArrayList;
import java.util.Scanner;
public class GerenciamentoConsultas {
    private AgendamentoConsulta agendamentoConsulta;
    private ArrayList<AgendamentoConsulta> consultascadastradas = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private CadastroMedico cadastroMedico=new CadastroMedico();
    private boolean gerenciando=true;
    private int definicaoStatus;
    public GerenciamentoConsultas(ArrayList<AgendamentoConsulta> consultascadastradas){
        this.consultascadastradas=consultascadastradas;
    }
    public GerenciamentoConsultas() {
        this.consultascadastradas = new ArrayList<>();
    }
    public void gerenciandoConsultas(CadastroMedico cadastroMedico){
        this.cadastroMedico = cadastroMedico;
        gerenciando=true;
        while (gerenciando) {
            System.out.println("Digite seu CRM a seguir: / 0 para sair");
            String crm;
            crm=scan.nextLine();
            if (crm.equals("0")) break;
                String crmDigitado = crm.replaceAll("[^0-9]", "");
                boolean crmMatchs=false;
                for(AgendamentoConsulta consulta : consultascadastradas){
                    String crmMedico = consulta.getMedico().getCrm().replaceAll("[^0-9]", "");
                    if (crmMedico.equals(crmDigitado)) {
                        crmMatchs=true;
                        boolean encontraConsulta=false;
                        System.out.println("Você possui consultas disponíveis com " + consulta.getPaciente().getNome());
                        System.out.println("Defina o status dessa consulta: 1 - Agendada / 2 - Concluida / 3 - Cancelada");
                        definicaoStatus=scan.nextInt();
                        switch (agendamentoConsulta.getStatus()) {
                            case 1 -> System.out.println("Consulta com" + agendamentoConsulta.getMedico().getNome() + " para " + agendamentoConsulta.getPaciente().getNome() + " às " + 
                            agendamentoConsulta.getHorario().getHour() + ":" + agendamentoConsulta.getHorario().getMinute() + " em " + agendamentoConsulta.getLocal() + " está agendada");
                            case 2 -> System.out.println("Consulta com" + agendamentoConsulta.getMedico().getNome() + " para " + agendamentoConsulta.getPaciente().getNome() + " às " + 
                            agendamentoConsulta.getHorario().getHour() + ":" + agendamentoConsulta.getHorario().getMinute() + " em " + agendamentoConsulta.getLocal() + " está concluída");
                            case 3 -> System.out.println("Consulta com" + agendamentoConsulta.getMedico().getNome() + " para " + agendamentoConsulta.getPaciente().getNome() + " às " + 
                            agendamentoConsulta.getHorario().getHour() + ":" + agendamentoConsulta.getHorario().getMinute() + " em " + agendamentoConsulta.getLocal() + " está cancelada");
        
                            default -> System.out.println("Algo deu errado.");
                            }
                        agendamentoConsulta.setStatus(definicaoStatus);
                        gerenciando=false;
                    }
                } if (!crmMatchs) {
                        System.out.printf("\nNenhuma consulta foi encontrada.\nVocê será redirecionado ao menu de Médicos.");
                        gerenciando=false;
                    
                    
            } if (!crmMatchs) {
                System.out.printf("\nCRM digitado errado ou não encontrado.");
            }


        }
    }
    public ArrayList<AgendamentoConsulta> getconsultasCadastradas(){
        return consultascadastradas;
    }

 
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
