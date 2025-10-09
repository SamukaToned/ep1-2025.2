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
        if (getStatus()==1) {
            System.out.println("Consulta com " + paciente.getNome() + " às " + horario.getHour() + ":" + horario.getMinute() + " em " + local + " possui o status de " + "Agendada");
        } else if (getStatus()==2){
            System.out.println("Consulta com " + paciente.getNome() + " às " + horario.getHour() + ":" + horario.getMinute() + " em " + local + " possui o status de " + "Concluída");
        } else if(getStatus()==3){
            System.out.println("Consulta com " + paciente.getNome() + " às " + horario.getHour() + ":" + horario.getMinute() + " em " + local + " possui o status de " + "Cancelada");
        }
    }
    

    @Override
    public String toString() {
        return "Consulta com " + medico.getNome() + " para " + paciente.getNome() +
                " às " + horario.getHour() + ":" + horario.getMinute() +
                " em " + local + " será analisada pelo médico.";
    }

}
