import javax.swing.JOptionPane; 

public class Validacao {

    // Validar usuário
    public static boolean validarIdadeVoluntario(int idadeVoluntario) {
        

        if (idadeVoluntario >= 18) {
            return true;
        }else{
            JOptionPane.showMessageDialog(null, "Não é possível seguir com o cadastro, o doador deve ser maior de 18 anos!");
            return false;
        }
    }

    
}
        

        
    


   

