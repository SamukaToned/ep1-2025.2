import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Medico extends Pessoa{
    private String crm;
    private String especialidade;
    private double custoDaConsulta;
    private static final DateTimeFormatter formatter = 
    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:");
    private String horarioDispon;
    private ArrayList<LocalDateTime> horarios = new ArrayList<>();


    public Medico(String nome, String cpf){
        super(nome, cpf);
    }

    public Medico(String especialidade){
        this.especialidade=especialidade;
    }

    public void adicionarHorarios(String horariosDispon){
        LocalDateTime horario = LocalDateTime.parse(horarioDispon, formatter);
        horarios.add(horario);
    }
    @Override
    public void mostrarDados() {
        System.out.println("O nome é: " + getNome() + "cpf é: " + getCpf() + " o crm é: " + crm + "e a especialidade é: " + especialidade);
    }

    public String getEspecialidade(String especialidade){
        return this.especialidade;
    }

    public void setEspecialidade(String especialidade){
        this.especialidade=especialidade;
    }

    public String getCrm(String crm){
        return this.crm;
    }

    public void setCrm(String crm){
        this.crm=crm;
    }

    public double getCustoDaConsulta(double custoDaConsulta){
        return this.custoDaConsulta;
    }

    public void setCustoDaConsulta(double custoDaConsulta){
        this.custoDaConsulta=custoDaConsulta;
    }

    public ArrayList<LocalDateTime> getHorarios(){
        return horarios;
    }

}

