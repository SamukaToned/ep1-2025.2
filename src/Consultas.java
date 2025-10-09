import java.util.ArrayList;
import java.util.InputMismatchException;
import java.time.LocalTime;
import java.util.Scanner;
public class Consultas {
    private Paciente paciente;
    private PacienteEspecial pacienteEspecial;
    private LocalTime horarioConsulta;
    private String local;
    int status=0;
    Scanner scan = new Scanner(System.in);
    boolean isConsulting=true;
    CadastroMedico cadastroMedico;
    CadastroPaciente cadastroPaciente;
    
    private ArrayList<AgendamentoConsulta> consultascadastradas;
    public Consultas(CadastroPaciente cadastroPaciente, CadastroMedico cadastroMedico, ArrayList<AgendamentoConsulta> consultascadastradas) {
        this.cadastroPaciente = cadastroPaciente;
        this.cadastroMedico = cadastroMedico;
        this.consultascadastradas = consultascadastradas;
    }
    public void EscolhaConsultas(){
        boolean isChoosingconsulta = true;
        ArrayList<Paciente> pacientes=cadastroPaciente.getPacientes();
        ArrayList<PacienteEspecial> pacientesespeciais = cadastroPaciente.getPacienteEspeciais();
        String cpf;
        while (isChoosingconsulta) {
            if (pacientes.isEmpty()) {
                System.out.printf("Nenhum paciente cadastrado ainda.\nVocê será redirecionado para o menu Pacientes para cadastrar um usuário.");
                isChoosingconsulta=false;
            }
            System.out.println("Digite seu CPF a seguir: ");
            cpf = scan.nextLine();
            String cpfDigitado = cpf.replaceAll("[^0-9]", "");
            boolean cpfMatchs=false;
            for(Paciente paciente : pacientes){
                String cpfPaciente = paciente.getCpf().replaceAll("[^0-9]", "");
                if (cpfDigitado.equals(cpfPaciente)) {
                    cpfMatchs=true;
                    this.paciente=paciente;
                    escolhaEspecialidades(pacientesespeciais);
                    isChoosingconsulta=false;
                    break;
                }
            }
            if(!cpfMatchs){
                System.out.printf("CPF errado ou Usuário não cadastrado");
                isChoosingconsulta=false;
            }
        }
        
    }

    public void escolhaEspecialidades(ArrayList<PacienteEspecial> pacientesespeciais){
        int planoDeSaudecadastrado;
        String id;
        while (isConsulting) {
                System.out.println("Você possui algum plano de saúde cadastrado? 0 - Sim / 1 - Não ");
                try{
                    planoDeSaudecadastrado=scan.nextInt();
                    scan.nextLine();
                    if (planoDeSaudecadastrado==0) {
                    System.out.println("Insira o ID do plano a seguir:");
                    id=scan.nextLine();
                    boolean idMatches=false;
                    for(PacienteEspecial pacienteEspecial : pacientesespeciais){
                        String idDigitado = id.replaceAll("[^0-9]", "");
                        String idPlano = pacienteEspecial.getIDPE().replaceAll("[^0-9]", "");
                        if (idDigitado.equals(idPlano)) {
                            idMatches=true;
                            this.pacienteEspecial=pacienteEspecial;
                            break;
                        }else{
                        if(!idMatches){
                            System.out.printf("ID errado ou Plano de Saúde não cadastrado.\nVocê continuará o cadastro sem o plano.");
                        }
                        }           
                
                    }
                }
                }catch(InputMismatchException e){
                    System.out.println("Digite valores inteiros.");
                    scan.nextLine();
                }
                
                    System.out.println("Você deseja ter uma consulta em qual área?");
                    System.out.printf("\n1 - OFTAMOLOGIA\n2 - PEDIATRIA\n3 - DERMATOLOGIA\n4 - CARDIOLOGIA\n5 - PSIQUIATRIA\n6 - NEUROLOGIA\n7 - ORTOPEDIA\n");
                    System.out.printf("8 - GASTROENTOLOGIA\n9 - GINECOLOGIA\n10 - ONCOLOGIA\n11 - UROLOGIA\n12 - ENDOCRINOLGIA\n13 - HEMATOLOGIA\n");
                    int escolha = scan.nextInt();
                    scan.nextLine();
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
        boolean temHorarios = true;
        while (temHorarios) {
            for(Medico medico : medicos){
            if (medico.getEspecialidade()==especialidade) {
                System.out.println("Médico disponível" + medico.getNome());
                
                ArrayList<LocalTime> horarios = medico.getHorarios();
                if (horarios.isEmpty()) {
                    System.out.println("Sem horários disponíveis"); 
                    temHorarios=false;
                } else{
                    System.out.println("Horários disponíveis:");
                    for (int i = 0; i < horarios.size(); i++) {
                        System.out.println((i + 1) + " - " + horarios.get(i));
                    }
                    System.out.println("Escolha o número do horário desejado: ");
                    int escolhaHorario = scan.nextInt();
                    if (escolhaHorario < 1 || escolhaHorario > horarios.size()) {
                        System.out.println("Escolha inválida!");
                        continue;
                    }
                    scan.nextLine();
                    horarioConsulta = horarios.get(escolhaHorario - 1);
                    isFound=true;
                    local = "Escritório de " + medico.getNome();
                    System.out.println("Realizando consulta com o " + medico.getNome());
                    AgendamentoConsulta agendamentoConsulta = new AgendamentoConsulta(paciente, medico, horarioConsulta, local, status);
                    System.out.println(agendamentoConsulta);
                    System.out.println("O preço a se pagar da consulta será R$" + medico.getCustoDaConsulta());
                    consultascadastradas.add(agendamentoConsulta);
                    temHorarios=false;
                    this.isConsulting=false;

                }

                }
                
            }
            if (isFound==false) {
            System.out.println("Nenhum médico foi especialista da área de " + especialidade + " trabalha nesse hospital.");
            temHorarios=false;
            this.isConsulting=false;

        }
        } 
        }
    
    }                          
    