import java.util.ArrayList;
import java.util.Scanner;
public class GerenciamentoInternacoes {
    private Internacoes internacoes;
    private ArrayList<Internacoes> internacoesfeitas = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    private CadastroMedico cadastroMedico;
    boolean gerenciandointernacoes=true;
    private double valorInternacao;
    public GerenciamentoInternacoes(ArrayList<Internacoes> internacoesfeitas){
        this.internacoesfeitas=internacoesfeitas;
    }
    public GerenciamentoInternacoes() {
        this.internacoesfeitas = new ArrayList<>();
    }
    public void gerenciamentoInternacoes(CadastroMedico cadastroMedico, double valorInternacao){
        this.cadastroMedico = cadastroMedico;
        gerenciandointernacoes=true;
        int definicaoStatusInternacao;
        while (gerenciandointernacoes) {
            System.out.println("Digite seu CRM a seguir: / 0 para sair");
            String crm;
            crm=scan.nextLine();
            if (crm.equals("0")) break;
                String crmDigitado = crm.replaceAll("[^0-9]", "");
                boolean crmMatchs=false;
                for(Internacoes internacoes : internacoesfeitas){
                    String crmMedico = internacoes.medico.getCrm().replaceAll("[^0-9]", "");
                    if (crmMedico.equals(crmDigitado)) {
                        crmMatchs=true;
                        System.out.println("Você possui solicitações de Internação disponíveis com " + internacoes.paciente.getNome());
                        System.out.println("Defina o status dessa Internação: 1 - Agendada / 2 - Concluida / 3 - Cancelada");
                        definicaoStatusInternacao=scan.nextInt();
                        scan.nextLine();
                        switch (definicaoStatusInternacao) {
                            case 1 -> {
                            System.out.println("Defina o valor da internação: "); 
                            valorInternacao=scan.nextDouble();
                            this.valorInternacao=valorInternacao;
                            System.out.println("A internação com " + internacoes.medico.getNome() + " para " + internacoes.paciente.getNome() + " em " + 
                            internacoes.getData() + " no quarto " + internacoes.getNumQuarto() + " com o valor de R$" + valorInternacao + " está agendada"); }
                            case 2 -> System.out.println("A internação com " + internacoes.medico.getNome() + " para " + internacoes.paciente.getNome() + " às " + 
                            internacoes.getData() + " em " + internacoes.getNumQuarto() + " está concluída");
                            case 3 -> System.out.println("A internação com " + internacoes.medico.getNome() + " para " + internacoes.paciente.getNome() + " às " + 
                            internacoes.getData() + " em " + internacoes.getNumQuarto() + " está cancelada");
        
                            default -> System.out.println("Algo deu errado.");
                            }
                        internacoes.setStatusInternacao(definicaoStatusInternacao);
                        return;
                    }
                
                }   
                if (!crmMatchs) {
                    System.out.printf("\nCRM digitado errado ou não encontrado.");
                    gerenciandointernacoes=false;
                }
        }
    }
    public double getValorInternacao(){
        return valorInternacao;
    }
    
}
