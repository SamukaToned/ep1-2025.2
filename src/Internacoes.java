import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
public class Internacoes {
    private Paciente paciente;
    private Medico medico;
    private LocalDateTime dataEntrada;
    private String horaEntrada;
    private String dataSaida;
    private int[] quarto= {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private double custo;
    Scanner scan = new Scanner(System.in);
    CadastroMedico cadastroMedico;
    CadastroPaciente cadastroPaciente;

    public void internacoes(){
        boolean isChoosinginternacao = true;
        ArrayList<Paciente> pacientes=cadastroPaciente.getPacientes();
        ArrayList<PacienteEspecial> pacientesespeciais = cadastroPaciente.getPacienteEspeciais();
        String cpf;
        while (isChoosinginternacao) {
            if (pacientes.isEmpty()) {
                System.out.printf("Nenhum paciente cadastrado ainda.\nVocê será redirecionado para o menu Pacientes para cadastrar um usuário.");
                isChoosinginternacao=false;
            }
            System.out.println("Digite seu CPF a seguir: ");
            cpf = scan.nextLine();
            boolean cpfMatchs=false;
            String cpfDigitado = cpf.replaceAll("[^0-9]", "");
            for(Paciente paciente : pacientes){
                String cpfPaciente = paciente.getCpf().replaceAll("[^0-9]", "");
                if (cpfDigitado.equals(cpfPaciente)) {
                    cpfMatchs=true;
                    this.paciente=paciente;
                    agendandoInternacao();
                    isChoosinginternacao=false;
                    break;
                }
                cpf=null;
                if(!cpfMatchs){
                    System.out.printf("CPF errado ou Usuário não cadastrado");
                    isChoosinginternacao=false;
                }
            }
        }

    }

    private void agendandoInternacao(){
        System.out.println("Você deseja fazer uma internação em qual área?: ");
        System.out.printf("\n1 - OFTAMOLOGIA\n2 - PEDIATRIA\n3 - DERMATOLOGIA\n4 - CARDIOLOGIA\n5 - PSIQUIATRIA\n6 - NEUROLOGIA\n7 - ORTOPEDIA\n");
        System.out.printf("8 - GASTROENTOLOGIA\n9 - GINECOLOGIA\n10 - ONCOLOGIA\n11 - UROLOGIA\n12 - ENDOCRINOLGIA\n13 - HEMATOLOGIA\n");
        int escolha = scan.nextInt();
        scan.nextLine();

        ArrayList<Medico> medicos = cadastroMedico.getMedicos();

        switch (escolha) {
            case 1 -> conclusaoMedicosInternacao(medicos, Especializacao.OFTAMOLOGIA);
            case 2 -> conclusaoMedicosInternacao(medicos, Especializacao.PEDIATRIA);
            case 3 -> conclusaoMedicosInternacao(medicos, Especializacao.DERMATOLOGIA);
            case 4 -> conclusaoMedicosInternacao(medicos, Especializacao.CARDIOLOGIA);
            case 5 -> conclusaoMedicosInternacao(medicos, Especializacao.PSIQUIATRIA);
            case 6 -> conclusaoMedicosInternacao(medicos, Especializacao.NEUROLOGIA);
            case 7 -> conclusaoMedicosInternacao(medicos, Especializacao.ORTOPEDIA);
            case 8 -> conclusaoMedicosInternacao(medicos, Especializacao.GASTROENTOLOGIA);
            case 9 -> conclusaoMedicosInternacao(medicos, Especializacao.GINECOLOGIA);
            case 10 -> conclusaoMedicosInternacao(medicos, Especializacao.ONCOLOGIA);
            case 11 -> conclusaoMedicosInternacao(medicos, Especializacao.UROLOGIA);
            case 12 -> conclusaoMedicosInternacao(medicos, Especializacao.ENDOCRINOLGIA);
            case 13 -> conclusaoMedicosInternacao(medicos, Especializacao.HEMATOLOGIA);
            default -> System.out.println("Valor Inválido");
                    }
    }

    private void conclusaoMedicosInternacao(ArrayList<Medico> medicos, Especializacao especialidade){
        boolean isFound = false;
        boolean temHorarios = true;
        while (temHorarios) {
            for(Medico medico : medicos){
            if (medico.getEspecialidade()==especialidade) {
                System.out.println("Médico disponível" + medico);
                System.out.println("O hospital possui 10 quartos disponíveis para internação.");    
                System.out.println("De 1 a 10 escolha um deles para que ocorra a internação.");
                String estadoQuarto;
                for(int i = 0; i < 10; i++){
                    if (this.quarto[i]==0) {
                        estadoQuarto="Vazio";
                    } else {
                        estadoQuarto="Ocupado";
                    }
                    System.out.println("Quarto número " + i + " está " + estadoQuarto);
                }
                int quartos = scan.nextInt();
                scan.nextLine();
                if (quartos<1 || quartos>10) {
                    System.out.println("Valor inválido, escolha entre 1 e 10.");
                    return;
                }
                if (this.quarto[quartos]!=0) {
                    System.out.println("Quarto já ocupado, escolha outro.");
                    return;
                }
                this.quarto[quartos]=1;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
                DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
                LocalDateTime dataInternacao = null;
                String dataEntradaString;
                while (dataInternacao==null) {
                    try {
                        System.out.println("Digite a data para o começo da internação (dd/mm/yy)");
                        dataEntradaString = scan.nextLine();
                        LocalDate data = LocalDate.parse(dataEntradaString, formatter);
                        System.out.println("Digite o horário da Internação (HH:mm)");
                        System.out.println("O Hospital apenas faz internações agendadas entre os horários de 7:00 até 11:00 e 16:00 até 20:00 ");
                        horaEntrada = scan.nextLine();
                        Double horaInt = Double.parseDouble(horaEntrada);
                        if (horaInt<7||horaInt>11&&horaInt<16||horaInt>20) {
                            System.out.println("O Hospital não faz internações nesse horário.");
                        }
                        LocalTime hora = LocalTime.parse(horaEntrada, formatterHora);

                        dataInternacao = LocalDateTime.of(data, hora);

                }   catch (DateTimeParseException e) {
                        System.out.println("Data ou hora inválida. Tente novamente no formato dd/mm/yy e HH:mm.");
                }
                }
                this.dataEntrada=dataInternacao;
                System.out.println("O Médico será notificado e verificará o preço da internação e se a data está disponível.");
            }
                
            }
            if (isFound==false) {
            System.out.println("Nenhum médico foi especialista da área de " + especialidade + " trabalha nesse hospital.");
        }
        } 
    }
    

}
