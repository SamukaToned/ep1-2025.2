import java.util.ArrayList;
public class AgendamentoDeConsultas {
    private Medico medico;
    private Paciente paciente;
    //definir data e hora depois de ver sobre localdatetime
    private String local;
    private int status; // 1 é cancelada, 2 concluida e 3 agendada. O status é sempre tido como agendado a priori default. 

    public AgendamentoDeConsultas(Paciente paciente, Medico medico, String local, int status){
        this.paciente=paciente;
        this.medico=medico;
        this.local=local;
        this.status=status;
    }

    public String getlocal(String local){
        return local;
    }

    public void setLocal(String local){
        this.local=local;
    }

    public int getStatus(int status){
        return status;
    }

    public void setStatus(int status){
        this.status=status;
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
// ainda fazer a mudança do plano de saude, visão do paciente da escolha do médico e verificação de consulta.
