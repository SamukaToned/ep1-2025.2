import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Internacoes {
    private Paciente paciente;
    private Medico medico;
    private String dataEntrada;
    private String dataSaida;
    private int quarto;
    private double custo;
    DateTimeFormatter formatter = 
    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:");
    LocalDateTime comecoInternacaoDiaHr = LocalDateTime.parse(dataEntrada, formatter);
    LocalDateTime fimInternacaoDiaHr = LocalDateTime.parse(dataSaida, formatter);

    public Internacoes(Paciente paciente, Medico medico, int quarto, double custo, String dataEntrada, String dataSaida){
        this.paciente=paciente;
        this.medico=medico;
        this.quarto=quarto;
        this.custo=custo;
        this.dataEntrada=dataEntrada;
        this.dataSaida=dataSaida;
    }

    String getDataEntrada(String dataEntrada){
        return dataEntrada;
    }

    void setDataEntrada(String dataEntrada){
        this.dataEntrada=dataEntrada;
    }

    String getDataSaida(String dataSaida){
        return dataSaida;
    }

    void setDataSaida(String dataSaida){
        this.dataSaida=dataSaida;
    }

    int getQuarto(int quarto){
        return quarto;
    }

    void setQuarto(int quarto){
        this.quarto=quarto;
    }

    double getCusto(double custo){
        return custo;
    }

    void setCusto(double custo){
        this.custo=custo;
    }

    //falta metodo semelhante ao de consulta e talvez mais coisa q eu n vi
    

}
