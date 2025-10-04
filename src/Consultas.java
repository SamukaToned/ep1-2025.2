import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class Consultas {
    private Medico medico;
    private Paciente paciente;
    private String horarioConsulta;
    private static final DateTimeFormatter formatter = 
    DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:");
    private String local;
    private int escolha;
    Scanner scan = new Scanner(System.in);
    boolean isConsulting=true;

    public void AgendamentodeConsultas(){
        while (isConsulting) {
            System.out.println("Você deseja ter uma consulta em qual área?");
            System.out.printf("\n1 - OFTAMOLOGIA\n2 - PEDIATRIA\n3 - DERMATOLOGIA\n4 - CARDIOLOGIA\n5 - PSIQUIATRIA\n6 - NEUROLOGIA\n7 - ORTOPEDIA\n");
            System.out.printf("8 - GASTROENTOLOGIA\n9 - GINECOLOGIA\n10 - ONCOLOGIA\n11 - UROLOGIA\n12 - ENDOCRINOLGIA\n13 - HEMATOLOGIA\n");
            escolha = scan.nextInt();
            switch (escolha) {
                //falta os switch case ai, faz o que falta pq depois de ja ter melhorado o cadastro fica mais de boa, mas tem que testar ainda 
                
                default:System.out.println("Valor Inválido");
                    
            }
        }
    }
    public void agendamentoMedico(Medico medico){
        if (medico.getEspecialidade().equals(medico)) {
            
        }
    }
}
