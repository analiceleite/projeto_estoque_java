import javax.swing.JOptionPane;

public class Validacao {

    // Validar usuário
    public static boolean validarIdadeVoluntario(int idadeVoluntario) {
        boolean voluntarioValido = false;
        String mensagem = "";

        if (idadeVoluntario >= 18) {
            voluntarioValido = true;

            if (idadeVoluntario < 18) {
            }
            return voluntarioValido;
        }
        return voluntarioValido;
    }

    // Validar cadastro usuário

    // Validar se é dinheiro a doação
    public static boolean validarSeForDinheiro(Doacao d) {
        boolean doarDinheiro = false;
        if (d.categoria == "Dinheiro") {
            doarDinheiro = true;

            if (d.categoria != "Dinheiro") {

            }
            return doarDinheiro;
        }
        return doarDinheiro;
    }


    // Validar id doação (não pode repetir id nos cadastros)
}
