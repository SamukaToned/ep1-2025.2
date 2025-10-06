import java.util.ArrayList;
public class PlanoDeSaude {
    CadastroPlanodeSaude cadastroPlanodeSaude = new CadastroPlanodeSaude();
    private ArrayList<PlanoDeSaude> planos = new ArrayList();
    private String nomePlano;
    private String idPlano;
    private double[] desconto;

    PlanoDeSaude(String nomePlano, String idPlano, double[] desconto){
        this.nomePlano=cadastroPlanodeSaude.getNomePlano();
        this.idPlano=cadastroPlanodeSaude.getID();
        this.desconto=cadastroPlanodeSaude.getDesconto();
    }
    
    String getNomePlano(){
        return nomePlano;
    }
    
    String getIdPlano(){
        return idPlano;
    }

    double[] getDesconto(){
        return desconto;
    }

    public ArrayList<PlanoDeSaude> getPlanos(){
        return planos;
    }
}
