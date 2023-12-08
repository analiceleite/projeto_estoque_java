import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GestaoVoluntario {

  public ArrayList<Voluntario> listaDeVoluntarios = new ArrayList<Voluntario>();

  public void adicionarVoluntario(Voluntario Voluntario) {
    int id = 1;
    for (Voluntario v: this.listaDeVoluntarios) {
      if ( v.idVoluntario >= id ) {
        id = v.idVoluntario + 1;
      }
    }
    Voluntario.idVoluntario = id;
    this.listaDeVoluntarios.add(Voluntario);
  }

  // Mostrar voluntários cadastrados
  public String mostrarVoluntariosCadastrados() {
    String mensagem = "";
    
    for (Voluntario v : this.listaDeVoluntarios) {
      mensagem += "\n\nOs voluntários cadastrados no sistema são: \n ";
      mensagem += "\n ID: " +
          v.idVoluntario +
          "\n Nome: " +
          v.nomeVoluntario +
          "\n Idade: " +
          v.idadeVoluntario +
          "\n CPF: " +
          v.cpfVoluntario +
          "\n Endereço: " +
          v.enderecoVoluntario +
          "\n Telefone: " +
          v.telefone;
    }
    return mensagem;
  }

  // Editar nome voluntário
  public String alterarNomeVoluntario(int idVoluntario) {
    boolean encontrado = false;

    for (Voluntario v : this.listaDeVoluntarios) {
      int id = 0;
      encontrado = true;
      if (v.idVoluntario == id) {
        v.nomeVoluntario = JOptionPane.showInputDialog("Informe o novo nome do voluntário: ");
      }
    }
    if (encontrado == true) {
      return ("Nome alterado com sucesso! ");
    } else {
      return ("Cadastro não encontrado! ");
    }

  }

  
}
