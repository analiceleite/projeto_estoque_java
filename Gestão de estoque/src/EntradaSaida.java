
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

    public static int escolherOpcaoMenus() {

    String s1[] = {"1 - Produtos ", "2 - Doações", "3 - Doadores"};

    JComboBox<String> c1 = new JComboBox<>(s1);
    String mensagem = "--------- Sistema de gerenciamento de doações  ---------";
    Object[] exibicaoUsuario = {mensagem, c1};
    JOptionPane.showMessageDialog(null, exibicaoUsuario);

    return c1.getSelectedIndex()+1;
    }

    public static int escolherOpcaoMenuPrincipal() {

    String s1[] = {"1 - Cadastrar produto", "2 - Visualizar produtos cadastrados", "3 - Editar"};

    JComboBox<String> c1 = new JComboBox<>(s1);
    String mensagem = "--------- Gerenciar cadastro de doações ---------";
    Object[] exibicaoUsuario = {mensagem, c1};
    JOptionPane.showMessageDialog(null, exibicaoUsuario);

    return c1.getSelectedIndex()+1;
    }

    public static int escolherOpcaoMenuCategorias() {
    String s1[] = {"1 - Vestuário", "2 - Alimento ", "3 - Móveis", "4 - Dinheiro", "5 - Voltar ao menu principal" };

    JComboBox<String> c1 = new JComboBox<>(s1);
    String mensagem = "Escolha a categoria da doação que deseja cadastrar: ";
    Object[] exibicaoUsuario = {mensagem, c1};
    JOptionPane.showMessageDialog(null, exibicaoUsuario);

    return c1.getSelectedIndex()+1;
    }
    
    public static int escolherOpcaoMenuEstoque() {

    String s1[] = {"1 - Doar", "2 - Retirar", "3 - Consultar", "4 - Voltar para o menu principal" };

    JComboBox<String> c1 = new JComboBox<>(s1);
    String mensagem = "--------- Gerenciar estoque de doações ---------";
    Object[] exibicaoUsuario = {mensagem, c1};
    JOptionPane.showMessageDialog(null, exibicaoUsuario);

    return c1.getSelectedIndex()+1;
    }

    public static int escolherOpcaoMenuVoluntario() {

    String s1[] = {"1 - Realizar cadastro doador", "2 - Visualizar doadores cadastrados", "3 - Editar dados"};

    JComboBox<String> c1 = new JComboBox<>(s1);
    String mensagem = "--------- Gerenciar cadastro de voluntários ---------";
    Object[] exibicaoUsuario = {mensagem, c1};
    JOptionPane.showMessageDialog(null, exibicaoUsuario);

    return c1.getSelectedIndex()+1;
    }

    public static String SolicitarDadosString(String msg) {

           String a;
        do{
             a = JOptionPane.showInputDialog(null, msg);

            if(a.equals("")){
                
                JOptionPane.showMessageDialog(null, "Você tende a digitar algo.");
               
            }
         
        }while(a.equals(""));
        return a;       

    }

    public static int SolicitarDadosInt(String msg) {
        int par01 = 0;
        try {
            par01 = Integer.parseInt(JOptionPane.showInputDialog(null, msg));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Digite um valor númerico inteiro maior que 0.");
            par01 = EntradaSaida.SolicitarDadosInt(msg);
        }
       return par01;
    }

    public static int solicitarId(String msg) {
        int par01 = 0;
        try {
            par01 = Integer.parseInt(JOptionPane.showInputDialog(msg));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Digite um cadastro válido! ");
            par01 = EntradaSaida.solicitarId(msg);
        }
        return par01;
    }

    public static void mostrarDoacoesCadastradas(String mostrarDoacoesCadastradas) {
        JOptionPane.showMessageDialog(null, mostrarDoacoesCadastradas);
    }

    public static void mostrarCadastroVoluntario(String mostrarCadastroVoluntario) {
        JOptionPane.showMessageDialog(null, mostrarCadastroVoluntario);
    }

    public static int produtoEditarOpcoes() {
        
    String s1[] = {"1 - Nome ", "2 - Categoria", "3 - Quantidade em estoque", "4 - Quantidade minima", "5 - Deletar"};

    JComboBox<String> c1 = new JComboBox<>(s1);
    String mensagem = "--------- Edição do produto  ---------";
    Object[] exibicaoUsuario = {mensagem, c1};
    JOptionPane.showMessageDialog(null, exibicaoUsuario);

    return c1.getSelectedIndex()+1;
    }

    public static int confirmacao(String msg) {
        
    String s1[] = {"1 - Não ", "2 - Sim"};

    JComboBox<String> c1 = new JComboBox<>(s1);
    String mensagem = ""+msg;
    Object[] exibicaoUsuario = {mensagem, c1};
    JOptionPane.showMessageDialog(null, exibicaoUsuario);

    return c1.getSelectedIndex()+1;
    }

    public static int escolherOpcaoMenuConsulta() {
        String s1[] = {"1 - Itens para comprar", "2 - Consulta por ID", "3 - Consulta por nome", "4 - Consulta por categoria", "5 - Voltar para o menu principal"};

        JComboBox<String> c1 = new JComboBox<>(s1);
        String mensagem = "--------- Consultas ---------";
        Object[] exibicaoUsuario = {mensagem, c1};
        JOptionPane.showMessageDialog(null, exibicaoUsuario);

        return c1.getSelectedIndex()+1;
    }
    
    public static int escolherOpcaoMenuEditarVoluntario() {
        
    String s1[] = {"1 - Nome ", "2 - Idade", "3 - CPF", "4 - Endereço", "5 - Telefone", "6 - Voltar ao menu principal"};

    JComboBox<String> c1 = new JComboBox<>(s1);
    String mensagem = "--------- Edição dados do doador  ---------";
    Object[] exibicaoUsuario = {mensagem, c1};
    JOptionPane.showMessageDialog(null, exibicaoUsuario);

    return c1.getSelectedIndex()+1;
    }

}