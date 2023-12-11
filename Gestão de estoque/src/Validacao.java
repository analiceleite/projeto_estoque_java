import javax.swing.JOptionPane;

public class Validacao {

    // Validar usuário
    public static boolean validarIdadeVoluntario(int idadeVoluntario) {
        boolean voluntarioValido = false;

        if (idadeVoluntario >= 18) {
            voluntarioValido = true;

            if (idadeVoluntario < 18) {
                JOptionPane.showMessageDialog(null, "Não é possível seguir com o cadastro, o doador deve ser maior de 18 anos!");
            }
            return voluntarioValido;
        }
        return voluntarioValido;
    }

    // Validar cadastro usuário

    public static boolean validarCadastroDoador(int idVoluntario) {
        boolean cadastroValido = false;
        int id = 0;

        if (id == idVoluntario) {
            cadastroValido = true;

            } else {
                JOptionPane.showMessageDialog(null, "Cadastro não encontrado! Faça o cadastro para dar sequência.");
                GestaoVoluntario gv = new GestaoVoluntario();
                EntradaSaida.mostrarCadastroVoluntario(gv.cadastrarVoluntario());
            }
            return cadastroValido;
        }
    }
        

        
    


   

