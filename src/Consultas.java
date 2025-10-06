import java.util.ArrayList;
import java.time.LocalTime;
import java.util.Scanner;
public class Consultas {
    private Medico medico;
    private Paciente paciente;
    private LocalTime horarioConsulta;
    private String local;
    private int escolha;
    int status=0;
    Scanner scan = new Scanner(System.in);
    boolean isConsulting=true;
    CadastroMedico cadastroMedico = new CadastroMedico();
    CadastroPaciente cadastroPaciente = new CadastroPaciente();
    public void EscolhaConsultas(){
        boolean isChoosingconsulta = true;
        int choosingconsulta;
        String cpf;
        while (isChoosingconsulta) {
            System.out.println("Digite seu CPF a seguir: ");
            cpf = scan.nextLine();
            ArrayList<Paciente> pacientes=cadastroPaciente.getPacientes();
            int valordeverificacao=0;
            for(Paciente paciente : pacientes){
                if (cpf==paciente.getCpf()) {
                valordeverificacao++;
                while (isConsulting) {
                System.out.println("Você deseja ter uma consulta em qual área?");
                System.out.printf("\n1 - OFTAMOLOGIA\n2 - PEDIATRIA\n3 - DERMATOLOGIA\n4 - CARDIOLOGIA\n5 - PSIQUIATRIA\n6 - NEUROLOGIA\n7 - ORTOPEDIA\n");
                System.out.printf("8 - GASTROENTOLOGIA\n9 - GINECOLOGIA\n10 - ONCOLOGIA\n11 - UROLOGIA\n12 - ENDOCRINOLGIA\n13 - HEMATOLOGIA\n");
                escolha = scan.nextInt();
                ArrayList<Medico> medicos = cadastroMedico.getMedicos();
                switch (escolha) {
                    case 1 -> verificarMedicosEspecialidade(medicos, Especializacao.OFTAMOLOGIA, isChoosingconsulta);
                    case 2 -> verificarMedicosEspecialidade(medicos, Especializacao.PEDIATRIA, isChoosingconsulta);
                    case 3 -> verificarMedicosEspecialidade(medicos, Especializacao.DERMATOLOGIA, isChoosingconsulta);
                    case 4 -> verificarMedicosEspecialidade(medicos, Especializacao.CARDIOLOGIA, isChoosingconsulta);
                    case 5 -> verificarMedicosEspecialidade(medicos, Especializacao.PSIQUIATRIA, isChoosingconsulta);
                    case 6 -> verificarMedicosEspecialidade(medicos, Especializacao.NEUROLOGIA, isChoosingconsulta);
                    case 7 -> verificarMedicosEspecialidade(medicos, Especializacao.ORTOPEDIA, isChoosingconsulta);
                    case 8 -> verificarMedicosEspecialidade(medicos, Especializacao.GASTROENTOLOGIA, isChoosingconsulta);
                    case 9 -> verificarMedicosEspecialidade(medicos, Especializacao.GINECOLOGIA, isChoosingconsulta);
                    case 10 -> verificarMedicosEspecialidade(medicos, Especializacao.ONCOLOGIA, isChoosingconsulta);
                    case 11 -> verificarMedicosEspecialidade(medicos, Especializacao.UROLOGIA, isChoosingconsulta);
                    case 12 -> verificarMedicosEspecialidade(medicos, Especializacao.ENDOCRINOLGIA, isChoosingconsulta);
                    case 13 -> verificarMedicosEspecialidade(medicos, Especializacao.HEMATOLOGIA, isChoosingconsulta);
                    default -> System.out.println("Valor Inválido");
                    
                }
            }
            
        }   else{
                if(valordeverificacao==0){
                    System.out.println("CPF errado ou Usuário não cadastrado. Deseja retornar a tela inicial? 0 - Sim / 1 - Não");
                    choosingconsulta = scan.nextInt();
                    if (choosingconsulta==0) {
                        isChoosingconsulta=false;
                    }
                }
            }
                
            }
        }
    }
 
    private void verificarMedicosEspecialidade(ArrayList<Medico> medicos, Especializacao especialidade, boolean isChoosingconsulta){
        boolean isFound = false;
        boolean temHorarios = true;
        while (temHorarios) {
            for(Medico medico : medicos){
            if (medico.getEspecialidade()==especialidade) {
                System.out.println("Médico disponível" + medico);
                

                ArrayList<LocalTime> horarios = medico.getHorarios();
                if (horarios.isEmpty()) {
                    System.out.println("Sem horários disponíveis"); 
                    temHorarios=false;
                } else{
                    System.out.println("Horários disponíveis:");
                    for (int i = 0; i < horarios.size(); i++) {
                    System.out.println((i + 1) + " - " + horarios.get(i));
                }
                    isFound=true;
                    System.out.println("Realizando consulta com o " + medico.getNome());
                    AgendamentoConsulta agendamentoConsulta = new AgendamentoConsulta(paciente, medico, horarioConsulta, local, status);
                    System.out.println(agendamentoConsulta);
                    System.out.println("Consulta realizada com sucesso.");
                    temHorarios=false;
                    isChoosingconsulta=false;

                }

                }
                
            }
            if (isFound==false) {
            System.out.println("Nenhum médico foi especialista da área de " + especialidade + " trabalha nesse hospital.");
        }
        } 
        }
                          
    }
// falta ainda fazer coisa do plano de saude e o fim da consulta, não é tanto mais ainda quebrarei cabeça
