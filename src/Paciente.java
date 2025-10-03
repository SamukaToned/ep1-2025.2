public class Paciente extends Pessoa {
    private int idade;
    private int numeroDeConsultas;
    private String[] historicoDeConsultas;
    public Paciente(){
        this.idade = 0;
    }
    
    public Paciente(String nome, String cpf, int idade){
        super(nome, cpf);
        this.idade = idade;
    }
    
    int getIdade(){
        return idade;
    }

    String[] getHistoricoDeConsultas(){
        return this.historicoDeConsultas;
    }    

    void setNumeroDeConsultas(String[] historicoDeConsultas){
        this.historicoDeConsultas=historicoDeConsultas;
    }

}
