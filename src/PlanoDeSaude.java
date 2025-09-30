import java.util.ArrayList;
public class PlanoDeSaude {
    private int desconto;
    private String especializacao;
    private String tipoDePlano;
    ArrayList<String> especs = new ArrayList<>();
    //em algum momento adicionarei os tipos de especializacoes do projeto no geral

    PlanoDeSaude(String tipoDePlano, String especializacao){
        this.tipoDePlano=tipoDePlano;
        this.especializacao=especializacao;
    }

    public String getEspecializacao(String especializacao){
        return especializacao;}

    public void setEspecializacao(String especializacao){
        this.especializacao=especializacao;}

    public String getTipoDePlano(String tipoDePlano){
        return tipoDePlano;}
    
    public void setTipoDePlano(String tipoDePlano){
        this.tipoDePlano=tipoDePlano;}

    public int tipoDeDesconto(int desconto, String especializacao){
    //vai ter haver com o tipo de espec, mas ainda vou pensar cm farei o tipo de espec
        return desconto;
    }
}
