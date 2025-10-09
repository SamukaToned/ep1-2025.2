import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;

public class AgendamentoConsulta {
    private Paciente paciente = new Paciente();
    private Medico medico;
    private LocalTime horario;
    private String local;
    private int status=0;

    private static ArrayList<AgendamentoConsulta> consultascadastradas = new ArrayList<>();
    public AgendamentoConsulta(Paciente paciente, Medico medico, LocalTime horario, String local, int status) {
        this.paciente = paciente;
        this.medico = medico;
        this.horario = horario;
        this.local = local;
        this.status = status;
    }
    

    public static void adicionarConsulta(AgendamentoConsulta consulta) {
        consultascadastradas.add(consulta);
    }

   public static ArrayList<AgendamentoConsulta> getConsultas() {
        return consultascadastradas;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public LocalTime getHorario() {
        return horario;
    }

    public String getLocal() {
        return local;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
            
    public void mostrarConsultas(){
        if (consultascadastradas.isEmpty()) {
            System.out.println("Nenhuma consulta foi agendada ainda.");
            return;
        }
        System.out.println("--------------------------------------");
        System.out.println("Consultas cadastradas:");
        for (AgendamentoConsulta consulta : consultascadastradas) {
        String statusTexto = switch (consulta.getStatus()) {
            case 1 -> "Agendada";
            case 2 -> "Concluída";
            case 3 -> "Cancelada";
            default -> "Indefinido";
        };
        System.out.println("Consulta com " + consulta.getMedico().getNome()
                + " para " + consulta.getPaciente().getNome()
                + " às " + consulta.getHorario().getHour() + ":" + String.format("%02d", consulta.getHorario().getMinute())
                + " em " + consulta.getLocal()
                + " - Status: " + statusTexto);
        }   
        System.out.println("--------------------------------------");

    }
    
    private static void salvarConsultaCSV(AgendamentoConsulta consulta) {
        try (FileWriter writer = new FileWriter("consultas.csv", true)) {
            writer.append(consulta.getPaciente().getNome()).append(",")
                  .append(consulta.getPaciente().getCpf()).append(",")
                  .append(consulta.getMedico().getNome()).append(",")
                  .append(consulta.getMedico().getCrm()).append(",")
                  .append(consulta.getMedico().getEspecialidade().toString()).append(",")
                  .append(consulta.getHorario().toString()).append(",")
                  .append(consulta.getLocal()).append(",")
                  .append(String.valueOf(consulta.getStatus())).append("\n");

            writer.flush();
            System.out.println("Consulta salva no arquivo consultas.csv");
        } catch (IOException e) {
            System.out.println("Erro ao salvar consulta no CSV: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Consulta com " + medico.getNome() + " para " + paciente.getNome() +
                " às " + horario.getHour() + ":" + horario.getMinute() +
                " em " + local + " será analisada pelo médico.";
    }

}
