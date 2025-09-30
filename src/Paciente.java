public class Paciente extends Pessoa {
    private int idade;
    private int numeroDeConsultas;
    private String[] historicoDeConsultas;
    public Paciente(String nome, String cpf, int idade){
        super(nome, cpf);
        this.idade = idade;
    }
    
    @Override
    public void mostrarDados() {
        System.out.println("O nome e: " + getNome() + " o cpf e: " + getCpf() + " e idade e: " + idade );
    }

    int getNumeroDeConsultas(){
        return this.numeroDeConsultas;
    }

    
    void setNumeroDeConsultas(int numeroDeConsultas){
        this.numeroDeConsultas=numeroDeConsultas;
    }

    String[] getHistoricoDeConsultas(){
        return this.historicoDeConsultas;
    }    

    void setNumeroDeConsultas(String[] historicoDeConsultas){
        this.historicoDeConsultas=historicoDeConsultas;
    }

}
