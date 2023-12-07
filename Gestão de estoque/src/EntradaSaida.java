
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

    public static int escolherOpcaoMenus() {

    String s1[] = {"1 - Gerenciar cadastro de doações ", "2 - Gerenciar estoque de doações", "3 - Gerenciar cadastro de voluntários"};

    JComboBox c1 = new JComboBox<>(s1);
    String mensagem = "--------- Sistema de gerenciamento de doações  ---------";
    Object[] exibicaoUsuario = {mensagem, c1};
    JOptionPane.showMessageDialog(null, exibicaoUsuario);

    return c1.getSelectedIndex()+1;
    }

    public static int escolherOpcaoMenuPrincipal() {

    String s1[] = {"1 - Cadastrar doação", "2 - Visualizar doações cadastradas", "3 - Alterar descrição de alguma doação", "4 - Excluir cadastro de alguma doação", "5 - Voltar ao menu inicial" };

    JComboBox c1 = new JComboBox<>(s1);
    String mensagem = "--------- Gerenciar cadastro de doações ---------";
    Object[] exibicaoUsuario = {mensagem, c1};
    JOptionPane.showMessageDialog(null, exibicaoUsuario);

    return c1.getSelectedIndex()+1;
    }

    public static int escolherOpcaoMenuCategorias() {
    String s1[] = {"1 - Vestuário", "2 - Alimento ", "3 - Móveis", "4 - Dinheiro", "5 - Voltar ao menu principal" };

    JComboBox c1 = new JComboBox<>(s1);
    String mensagem = "Escolha a categoria da doação que deseja cadastrar: ";
    Object[] exibicaoUsuario = {mensagem, c1};
    JOptionPane.showMessageDialog(null, exibicaoUsuario);

    return c1.getSelectedIndex()+1;
    }
    
    public static int escolherOpcaoMenuEstoque() {

    String s1[] = {"1 - Dar entrada em doações para o estoque", "2 - Consultar doações em estoque por ID", "3 - Consultar doações por categoria" };

    JComboBox c1 = new JComboBox<>(s1);
    String mensagem = "--------- Gerenciar estoque de doações ---------";
    Object[] exibicaoUsuario = {mensagem, c1};
    JOptionPane.showMessageDialog(null, exibicaoUsuario);

    return c1.getSelectedIndex()+1;
    }

    public static int escolherOpcaoMenuVoluntario() {

    String s1[] = {"1 - Realizar cadastro para voluntariado", "2 - Visualizar voluntários cadastrados", "3 - Editar nome voluntário"};

    JComboBox c1 = new JComboBox<>(s1);
    String mensagem = "--------- Gerenciar cadastro de voluntários ---------";
    Object[] exibicaoUsuario = {mensagem, c1};
    JOptionPane.showMessageDialog(null, exibicaoUsuario);

    return c1.getSelectedIndex()+1;
    }

    public static String SolicitarDadosPessoais(String msg) {
        return JOptionPane.showInputDialog(null, msg);
    }

    public static int solicitarId(String msg) {
        return Integer.parseInt(JOptionPane.showInputDialog("Informe " + msg + " do cadastro que deseja consultar: "));
    }

    public static void mostrarDoacoesCadastradas(String mostrarDoacoesCadastradas) {
        JOptionPane.showMessageDialog(null, mostrarDoacoesCadastradas);
    }

    public static void mostrarCadastroVoluntario(String mostrarCadastroVoluntario) {
        JOptionPane.showMessageDialog(null, mostrarCadastroVoluntario);
    }

    // System.out.println("Insira o seu usuário: ");
    // String user = System.console().readLine();
    // return b.procurarUsuario(user, b);
    // return JOption.showInputDialog("Insira o seu usuário")

}