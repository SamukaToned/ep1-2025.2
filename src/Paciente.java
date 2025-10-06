public class Paciente extends Pessoa {
    private int idade;
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
}
