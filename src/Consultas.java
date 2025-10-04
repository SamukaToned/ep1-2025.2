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
    CadastroMedico cadastroMedico = new CadastroMedico();

    public void AgendamentodeConsultas(){
        while (isConsulting) {
            System.out.println("Você deseja ter uma consulta em qual área?");
            System.out.printf("\n1 - OFTAMOLOGIA\n2 - PEDIATRIA\n3 - DERMATOLOGIA\n4 - CARDIOLOGIA\n5 - PSIQUIATRIA\n6 - NEUROLOGIA\n7 - ORTOPEDIA\n");
            System.out.printf("8 - GASTROENTOLOGIA\n9 - GINECOLOGIA\n10 - ONCOLOGIA\n11 - UROLOGIA\n12 - ENDOCRINOLGIA\n13 - HEMATOLOGIA\n");
            escolha = scan.nextInt();

            ArrayList<Medico> medicos = cadastroMedico.getMedicos();
            switch (escolha) {
                case 1 -> verificarMedicosEspecialidade(medicos, Especializacao.OFTAMOLOGIA);
                case 2 -> verificarMedicosEspecialidade(medicos, Especializacao.PEDIATRIA);
                case 3 -> verificarMedicosEspecialidade(medicos, Especializacao.DERMATOLOGIA);
                case 4 -> verificarMedicosEspecialidade(medicos, Especializacao.CARDIOLOGIA);
                case 5 -> verificarMedicosEspecialidade(medicos, Especializacao.PSIQUIATRIA);
                case 6 -> verificarMedicosEspecialidade(medicos, Especializacao.NEUROLOGIA);
                case 7 -> verificarMedicosEspecialidade(medicos, Especializacao.ORTOPEDIA);
                case 8 -> verificarMedicosEspecialidade(medicos, Especializacao.GASTROENTOLOGIA);
                case 9 -> verificarMedicosEspecialidade(medicos, Especializacao.GINECOLOGIA);
                case 10 -> verificarMedicosEspecialidade(medicos, Especializacao.ONCOLOGIA);
                case 11 -> verificarMedicosEspecialidade(medicos, Especializacao.UROLOGIA);
                case 12 -> verificarMedicosEspecialidade(medicos, Especializacao.ENDOCRINOLGIA);
                case 13 -> verificarMedicosEspecialidade(medicos, Especializacao.HEMATOLOGIA);
                default -> System.out.println("Valor Inválido");
                    
            }
        }
    }
 
    private void verificarMedicosEspecialidade(ArrayList<Medico> medicos, Especializacao especialidade){
        boolean isFound = false;
        for(Medico medico : medicos){
            if (medico.getEspecialidade()==especialidade) {
                System.out.println("Médico disponível" + medico);
                isFound=true;
                int choice3=0;
                System.out.println("Realizar consulta com o " + medico.getNome() + "?" + "0 - Sim / 1 - Não");
                choice3 = scan.nextInt();
                if(choice3==0){
                
                

                }

                }

            }
            if (isFound==false) {
            System.out.println("Nenhum médico foi especialista da área de " + especialidade + " trabalha nesse hospital.");
        } 
        }
                          
    }
// falta ainda fazer coisa do plano de saude e o fim da consulta, não é tanto mais ainda quebrarei cabeça
