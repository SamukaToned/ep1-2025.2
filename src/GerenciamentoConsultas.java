import java.util.ArrayList;
import java.util.Scanner;
public class GerenciamentoConsultas {
    private AgendamentoConsulta consulta;
    private ArrayList<AgendamentoConsulta> consultascadastradas = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private CadastroMedico cadastroMedico=new CadastroMedico();
    private boolean gerenciando=true;
    public GerenciamentoConsultas(ArrayList<AgendamentoConsulta> consultascadastradas){
        this.consultascadastradas=consultascadastradas;
    }
    public GerenciamentoConsultas() {
        this.consultascadastradas = new ArrayList<>();
    }
    public void gerenciandoConsultas(CadastroMedico cadastroMedico){
        this.cadastroMedico = cadastroMedico;
        gerenciando=true;
        int definicaoStatus;
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
                        System.out.println("Você possui consultas disponíveis com " + consulta.getPaciente().getNome());
                        System.out.println("Defina o status dessa consulta: 1 - Agendada / 2 - Concluida / 3 - Cancelada");
                        definicaoStatus=scan.nextInt();
                        scan.nextLine();
                        switch (definicaoStatus) {
                            case 1 -> System.out.println("Consulta com " + consulta.getMedico().getNome() + " para " + consulta.getPaciente().getNome() + " às " + 
                            consulta.getHorario().getHour() + ":" + consulta.getHorario().getMinute() + " em " + consulta.getLocal() + " está agendada");
                            case 2 -> System.out.println("Consulta com " + consulta.getMedico().getNome() + " para " + consulta.getPaciente().getNome() + " às " + 
                            consulta.getHorario().getHour() + ":" + consulta.getHorario().getMinute() + " em " + consulta.getLocal() + " está concluída");
                            case 3 -> System.out.println("Consulta com " + consulta.getMedico().getNome() + " para " + consulta.getPaciente().getNome() + " às " + 
                            consulta.getHorario().getHour() + ":" + consulta.getHorario().getMinute() + " em " + consulta.getLocal() + " está cancelada");
        
                            default -> System.out.println("Algo deu errado.");
                            }
                        consulta.setStatus(definicaoStatus);
                        return;
                    }
                
                }   
                if (!crmMatchs) {
                    System.out.printf("\nCRM digitado errado ou não encontrado.");
                    gerenciando=false;
                }
        }
    }
    public ArrayList<AgendamentoConsulta> getconsultasCadastradas(){
        return consultascadastradas;
    }

 
    public void historicoConsultas(){
        boolean historicoExiste = false;
        for(AgendamentoConsulta consulta : consultascadastradas){
            if (consulta.getStatus()==2) {
            System.out.println("O paciente " + consulta.getPaciente().getNome() + " teve uma consulta com " + consulta.getMedico().getNome()
             + " com o tópico de " + consulta.getMedico().getEspecialidade());
             historicoExiste=true;
        }
        } if (!historicoExiste) {
            System.out.println("Não há nenhuma consulta concluída cadastrada");
        }
    }

    
}
