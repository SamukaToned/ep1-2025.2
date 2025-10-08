import java.util.Scanner;
import java.util.ArrayList;
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

            System.out.println("Você deseja continuar? 0 - Sim / 1 - Não");
            escolha = scan.nextInt();
            
            evitarSpaceNome++;
            if (escolha==1) {
                isRegistering=false;
            }
        }   
    }
    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public void listaMedicos(){
        System.out.println("Esses são os médicos cadastrados: ");
        for(Medico medico : medicos){
            System.out.println(medico);
        }
    }
}
//tem que testar ainda se funcionou, faça mais exceptions dps
