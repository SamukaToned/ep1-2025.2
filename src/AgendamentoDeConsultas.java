import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class AgendamentoDeConsultas {
    private Medico medico;
    private Paciente paciente;
    private String horarioConsulta;
    private static final DateTimeFormatter formatter = 
    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:");
    private String local;
    private int status; // 1 é cancelada, 2 concluida e 3 agendada. O status é sempre tido como agendado a priori default. 
    //não terminei essa parte, ainda tá faltando coisa.
    public AgendamentoDeConsultas(Paciente paciente, Medico medico, String local, int status){
        this.paciente=paciente;
        this.medico=medico;
        this.local=local;
        this.status=status;
    }
    

    public String getlocal(String local){
        return local;
    }

    public int getStatus(int status){
        return status;
    }

    public void agendamento(Paciente paciente, Medico medico, String local, int status){
        switch (status) {
            //adicionar dia e local ainda.
            case 1 ->{
                System.out.println("A consulta do paciente " + paciente.getNome() + "com o médico " + medico.getNome() + "foi cancelada.");
                status=1;
                    }
            case 2 ->{
                System.out.println("A consulta do paciente " + paciente.getNome() + "com o médico " + medico.getNome() + "foi concluida.");
                status=2;        
                    }
            default -> {
                System.out.println("A consulta do paciente " + paciente.getNome() + "com o médico " + medico.getNome() + "está agendada para o dia");
                status=3;
                        }
        }
    }
    }

//provavelmente vai mudar mt aqui ainda