import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
public class CadastroMedico {
    Medico medico = new Medico();
    Scanner scan = new Scanner(System.in);
    private ArrayList<Medico> medicos = new ArrayList<>();

    public void cadastroMedico(){
        boolean isRegistering=true;
        int evitarSpaceNome=0;
        while (isRegistering) {
            String nome, cpf, crm, especialidadeValor;
            Especializacao especialidade = null;
            double custo;
            String horario;
            int escolha;
        
            if (evitarSpaceNome!=0) {
                scan.nextLine();
            }

            System.out.println("Digite a sequir o seguintes dados:");
            System.out.printf("Nome: ");
            nome=scan.nextLine();

            System.out.printf("\nCPF: ");
            cpf = scan.nextLine();

            System.out.printf("\nCRM: ");
            crm = scan.nextLine();

            boolean especialidadeisntValid = true;
            while (especialidadeisntValid) {
                System.out.printf("\nEspecialidade: ");
                especialidadeValor=scan.nextLine().toUpperCase();
                try {
                    especialidade = Especializacao.valueOf(especialidadeValor);
                    especialidadeisntValid = false;
                } catch (IllegalArgumentException e){
                    System.out.println("O Hospital não possui funcionários com a especialidade " + especialidadeValor + ", temos médicos especializados nas a seguir: ");
                    for(Especializacao especializacao : Especializacao.values()){
                        System.out.println(" - " + especializacao);
                    }
                }
            }

            System.out.printf("\nCusto da Consulta: ");
            custo = scan.nextDouble();
            scan.nextLine();

            Medico medico = new Medico(nome, cpf, crm, especialidade, custo);
            System.out.print("\nHorarios: (0 para encerrar)\n");
            while (true) {
                horario=scan.nextLine();
                if (horario.equals("0"))break;
                try{
                    medico.adicionarHorario(horario);
                } catch (Exception e){
                    System.out.println("Formato inválido, utilize o formato HH:MM");
                }
            };

            this.medicos.add(medico);

            try {
                    System.out.println("Você deseja continuar? 0 - Sim / 1 - Não");
                    boolean escolhaCerta=false;
                    while (!escolhaCerta) {
                        escolha = scan.nextInt();
                        if (escolha!=1 && escolha!=0) {
                            System.out.println("Valor inválido, digite um inteiro entre 1 e 0.");
                        }else{
                            if (escolha==1) {
                                isRegistering=false;
                                escolhaCerta=true;
                            }else evitarSpaceNome=1;
                        }
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Valor inválido, tem que ser inteiro.");
                }
            
        }   
    }
    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public void listaMedicos(){
        System.out.println("-------------------------------");
        System.out.println("Esses são os médicos cadastrados: ");
        for(Medico medico : medicos){
            System.out.println(medico);
        }
        System.out.println("-------------------------------");
    }
    
    private void salvarMedicoCSV(Medico medico) {
    try (FileWriter writer = new FileWriter("medicos.csv", true)) {
        List<String> horariosEmString = medico.getHorarios().stream()
            .map(LocalTime::toString) 
            .collect(Collectors.toList());
        String horarios = String.join(";", horariosEmString); 

        writer.append(medico.getNome()).append(",")
              .append(medico.getCpf()).append(",")
              .append(medico.getCrm()).append(",")
              .append(medico.getEspecialidade().toString()).append(",")
              .append(String.valueOf(medico.getCustoDaConsulta())).append(",")
              .append(horarios).append("\n");

        writer.flush();
        System.out.println("Dados dos médicos cadastrados salvos em medicos.csv");
    } catch (IOException e) {
        System.out.println("Erro ao salvar dados no CSV: " + e.getMessage());
    }
}
    
}
