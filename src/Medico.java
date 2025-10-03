import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Medico extends Pessoa{
    private String crm;
    private String especialidade;
    private double custoDaConsulta;
    private static final DateTimeFormatter formatter = 
    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
    private String horarioDispon;
    private ArrayList<LocalDateTime> horarios = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    
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
    @Override
    public void mostrarDados() {
        System.out.println("O nome é: " + getNome() + "cpf é: " + getCpf() + " o crm é: " + getCrm(crm) + "e a especialidade é: " + getEspecialidade(especialidade));
    }

    public String getEspecialidade(String especialidade){
        return this.especialidade;
    }

    public String getCrm(String crm){
        return this.crm;
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

