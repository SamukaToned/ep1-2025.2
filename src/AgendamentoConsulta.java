import java.time.LocalTime;
import java.util.ArrayList;

public class AgendamentoConsulta {
    private Paciente paciente;
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
    
    public String gerenciamentoPaciente(){
        return "Consulta com " + paciente.getNome() +
                " às " + horario.getHour() + ":" + horario.getMinute() +
                " em " + local + " possui o status de " + getStatus();
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

    @Override
    public String toString() {
        return "Consulta com " + medico.getNome() + " para " + paciente.getNome() +
                " às " + horario.getHour() + ":" + horario.getMinute() +
                " em " + local + " será analisada pelo médico.";
    }

    
}
