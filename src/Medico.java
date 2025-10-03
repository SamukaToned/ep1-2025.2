import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Medico extends Pessoa{
    private String crm;
    private String especialidade;
    private double custoDaConsulta;
    private static final DateTimeFormatter formatter = 
    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private String horarioDispon;
    private ArrayList<LocalDateTime> horarios = new ArrayList<>();
    
    public Medico(){
        this.crm="";
        this.especialidade="";
        this.custoDaConsulta=0;
        this.horarioDispon="";
    }

    public Medico(String nome, String cpf, String crm, String especialidade, double custoDaConsulta, String horarioDispon){
        super(nome, cpf);
        this.crm=crm;
        this.especialidade=especialidade;
        this.custoDaConsulta=custoDaConsulta;
        this.horarioDispon=horarioDispon;
    }


    public void adicionarHorarios(String horariosDispon){
        LocalDateTime horario = LocalDateTime.parse(horarioDispon, formatter);
        horarios.add(horario);
    }

    public String getEspecialidade(){
        return especialidade;
    }

    public String getCrm(){
        return crm;
    }

    public double getCustoDaConsulta(){
        return custoDaConsulta;
    }

    public void setCustoDaConsulta(double custoDaConsulta){
        this.custoDaConsulta=custoDaConsulta;
    }

    public ArrayList<LocalDateTime> getHorarios(){
        return horarios;
    }

    @Override
    public String toString(){
        return "***************" +
        "Nome: " + getNome() +
        "\nCPF: " + getCpf() +
        "\nCRM" + getCrm() + 
        "\nEspecialidade" + getEspecialidade() + 
        "\nCusto de Consulta: R$" + custoDaConsulta + 
        "\nHorários: " + horarioDispon +
        "***************";
    }
}

//ainda terei de ver sobre tempo provavelmente