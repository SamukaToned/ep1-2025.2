import java.time.LocalTime;
import java.util.ArrayList;
public class Medico extends Pessoa{
    private String crm;
    private double custoDaConsulta;

    private ArrayList<LocalTime> horarios = new ArrayList<>();
    private Especializacao especialidade;
    
    public Medico(){
        this.crm="";
        this.especialidade=null;
        this.custoDaConsulta=0;
    }

    public Medico(String nome, String cpf, String crm, Especializacao especialidade, double custoDaConsulta){
        super(nome, cpf);
        this.crm=crm;
        this.especialidade=especialidade;
        this.custoDaConsulta=custoDaConsulta;
    }


    public void adicionarHorario(String horarioDispon) {
        int hora = Integer.parseInt(horarioDispon.split(":")[0]);
        int minuto = Integer.parseInt(horarioDispon.split(":")[1]);

        LocalTime horario = LocalTime.of(hora, minuto);
        horarios.add(horario);
    }

    public Especializacao getEspecialidade(){
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

    public ArrayList<LocalTime> getHorarios(){
        return horarios;
    }

    @Override
    public String toString(){
        return "Nome: " + getNome() +
        "\nCPF: " + getCpf() +
        "\nCRM: " + getCrm() + 
        "\nEspecialidade - " + getEspecialidade() + 
        "\nCusto de Consulta: R$" + custoDaConsulta + 
        "\nHorários: De Segunda a Sexta: " + getHorarios();
    }
}

//ainda terei de ver sobre tempo provavelmente