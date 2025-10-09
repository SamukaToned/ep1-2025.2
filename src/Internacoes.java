import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
public class Internacoes {
    private String horaEntrada;
    private int[] quarto= {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int quartoIndex;
    Scanner scan = new Scanner(System.in);
    CadastroMedico cadastroMedico;
    CadastroPaciente cadastroPaciente;
    Paciente paciente;
    Medico medico;
    GerenciamentoInternacoes gerenciamentoInternacoes;
    private LocalDateTime dataEntrada;
    private int status;
    private static ArrayList<Internacoes> internacoesfeitas = new ArrayList<>();
    public Internacoes(CadastroMedico cadastroMedico, CadastroPaciente cadastroPaciente) {
    this.cadastroMedico = cadastroMedico;
    this.cadastroPaciente = cadastroPaciente;
    }

    public void internacoes(){
  
        boolean isChoosinginternacao = true;
        ArrayList<Paciente> pacientes=cadastroPaciente.getPacientes();
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
                }
            if(!cpfMatchs){
                System.out.printf("CPF errado ou Usuário não cadastrado");
                isChoosinginternacao=false;
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
        boolean agendandoInternacao = true;
        while (agendandoInternacao) {
            boolean isFound = false;
            for(Medico medico : medicos){
            if (medico.getEspecialidade()==especialidade) {
                isFound=true;
                System.out.println("Médico disponível" + medico.getNome());
                escolhendoQuarto();
                escolhendoHoraData();
                System.out.println("O Médico será notificado, verificará o preço da internação e se a data está disponível.");
                agendandoInternacao=false;
            }
                
            }
            if (isFound==false) {
            System.out.println("Nenhum médico foi especialista da área de " + especialidade + " trabalha nesse hospital.");
        }
        } 
    }

    public void escolhendoQuarto(){
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
            System.out.println("Valor inválido, escolha entre 0 e 9.");
            return;
        }
        if (this.quarto[quartos-1] != 0) {
            System.out.println("Quarto já ocupado, escolha outro.");
            return;
        }
        this.quarto[quartos-1] = 1;
        this.quartoIndex=quartos-1;
    }

    public void escolhendoHoraData(){
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
                        LocalTime hora = LocalTime.parse(horaEntrada, formatterHora);
                        boolean horarioValido = (hora.isAfter(LocalTime.of(6, 59)) && hora.isBefore(LocalTime.of(11, 1))) ||
                        (hora.isAfter(LocalTime.of(15, 59)) && hora.isBefore(LocalTime.of(20, 1)));
                        dataInternacao = LocalDateTime.of(data, hora);
                        if (!horarioValido) {
                            System.out.println("O hospital não faz internações nesse horário. Tente novamente entre 07:00–11:00 ou 16:00–20:00.");
                            continue;
                        }

                }   catch (DateTimeParseException e) {
                        System.out.println("Data ou hora inválida. Tente novamente no formato dd/mm/yy e HH:mm.");
                }
                }
                this.dataEntrada=dataInternacao;
    }
    public void adicionarInternacao(Internacoes internacoes){
        internacoesfeitas.add(internacoes);
    }
    public LocalDateTime getData(){
        return dataEntrada;
    }
    public int getNumQuarto(){
        return quartoIndex;
    }
    public void setStatusInternacao(int status) {
        this.status = status;
    }
    public int getStatusInternacao(){
        return status;
    }
    public void mostrarInternacoes(){
        if (getStatusInternacao()==1) {
            System.out.println("A internação com " + medico.getNome() + " para " + paciente.getNome() + " em " + getData() + " no quarto " + getNumQuarto() + " com o valor de R$" + gerenciamentoInternacoes.getValorInternacao() + " está agendada");
        } else if (getStatusInternacao()==2){
            System.out.println("A internação com " + medico.getNome() + " às " + getData()  + " no quarto " + getNumQuarto() + " com o valor de R$" + gerenciamentoInternacoes.getValorInternacao() +"está concluída");
        } else if(getStatusInternacao()==3){
            System.out.println("A internação com " + medico.getNome() + " às " + getData()  + " no quarto " + getNumQuarto() + " com o valor de R$" + gerenciamentoInternacoes.getValorInternacao() + "está cancelada");
        }
    }
}
