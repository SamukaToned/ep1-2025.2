import java.util.ArrayList;
public class PlanoDeSaude {
    CadastroPlanodeSaude cadastroPlanodeSaude = new CadastroPlanodeSaude();
    private ArrayList<PlanoDeSaude> planos = new ArrayList();
    private String nomePlano;
    private String idPlano;
    private double[] desconto;

    PlanoDeSaude(String nomePlano, String idPlano, double[] desconto){
        this.nomePlano=cadastroPlanodeSaude.getNomePlano(nomePlano);
        this.idPlano=cadastroPlanodeSaude.getID(idPlano);
        this.desconto=cadastroPlanodeSaude.getDesconto(desconto);
    }
    
    String getNomePlano(String nomePlano){
        return nomePlano;
    }
    
    String getIdPlano(String idPlano){
        return idPlano;
    }

    double[] getDesconto(double[] desconto){
        return desconto;
    }

    public ArrayList<PlanoDeSaude> getPlanos(){
        return planos;
    }
}
