public class PacienteEspecial extends Paciente {

    private String nomePlano,iD;
    private double[] desconto;
    PlanoDeSaude planoDeSaude;
    public PacienteEspecial(String nome, String cpf, int idade, String nomePlano, String iD, double[] desconto) {
    super(nome, cpf, idade);
    this.nomePlano = nomePlano;
    this.iD = iD;
    this.desconto = desconto;
}
    public String getIDPE(){
        return iD;
    }
    public String getnomePlanoPE(){
        return nomePlano;
    }
    public double[] getDescontoPE(){
        return desconto;
    }
    @Override
    public String toString(){
        return "***************\n" +
        "Nome: " + getNome() +
        "\nCPF: " + getCpf() +
        "\nIdade" + getIdade() +
        "\nNome Plano de Saúde" + 
        nomePlano +
        "\nID" + iD +
        "\n***************";
    }
}
