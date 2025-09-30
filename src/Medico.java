public class Medico extends Pessoa{
    private String crm;
    private String especialidade;
    private double custoDaConsulta;
    //agenda de horários ainda falta, fazer depois

    public Medico(String nome, String cpf){
        super(nome, cpf);
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

}

