import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestaoVoluntario {

  boolean validarIdadeVoluntario = false;

  public ArrayList<Voluntario> listaDeVoluntarios = new ArrayList<Voluntario>();

  public void adicionarVoluntario(Voluntario Voluntario) {
    int id = 1;
    for (Voluntario v : this.listaDeVoluntarios) {
      if (v.getIdVoluntario() >= id) {
        id = v.getIdVoluntario() + 1;
      }
    }
    Voluntario.setIdVoluntario(id);
    this.listaDeVoluntarios.add(Voluntario);
  }

  // Validar maior idade do voluntário
  public static boolean validarIdadeVoluntario(int idadeVoluntario) {

    if (idadeVoluntario >= 18) {
      return true;
    } else {

      JOptionPane.showMessageDialog(null, "Não é possível seguir com o cadastro, o doador deve ser maior de 18 anos!");
      return false;
    }
  }

  // Cadastrar voluntários
  public String cadastrarVoluntario() {

    Voluntario v = new Voluntario();

    v.setNomeVoluntario(EntradaSaida.SolicitarDadosString("Informe o nome do doador: "));

    do {
      v.setIdadeVoluntario(
          Integer.parseInt(EntradaSaida.SolicitarDadosString("Informe a idade (o doador deve ser acima de 18 anos): ")));
    } while (!Validacao.validarIdadeVoluntario(v.getIdadeVoluntario()));

    v.setEnderecoVoluntario(EntradaSaida.SolicitarDadosString("Informe o endereço: "));
    v.setCpfVoluntario(EntradaSaida.SolicitarDadosString("Informe o CPF: "));
    v.setTelefone(EntradaSaida.SolicitarDadosString("Informe o telefone: "));
    adicionarVoluntario(v);
    return "Cadastro realizado com sucesso!\nSeu ID é: " + v.getIdVoluntario();
  }

  // Mostrar voluntários cadastrados
  public String mostrarVoluntariosCadastrados() {
    String mensagem = "";

    for (Voluntario v : this.listaDeVoluntarios) {
      mensagem += "\n\nOs doadores cadastrados no sistema são: \n ";
      mensagem += "\n ID: " +
          v.getIdVoluntario() +
          "\n Nome: " +
          v.getNomeVoluntario() +
          "\n Idade: " +
          v.getIdadeVoluntario() +
          "\n CPF: " +
          v.getCpfVoluntario() +
          "\n Endereço: " +
          v.getEnderecoVoluntario() +
          "\n Telefone: " +
          v.getTelefone();
    }
    return mensagem;
  }

  // Editar nome voluntário
  public String alterarNomeVoluntario(int idVoluntario) {

    for (Voluntario v : this.listaDeVoluntarios) {
      if (v.getIdVoluntario() == idVoluntario) {
        v.setNomeVoluntario(JOptionPane.showInputDialog("Informe o novo nome do doador: "));
      }
    }
    return ("Nome alterado com sucesso! ");
  }

  // Validação de cadastro
  public boolean validarCadastroDoador(int idVoluntario) {
    boolean cadastroValido = false;
    boolean voluntarioValido = false;

    for (Voluntario v : this.listaDeVoluntarios) {
      if (v.getIdVoluntario() == idVoluntario) {
        voluntarioValido = true;
      }
    }
    if (voluntarioValido == true) {
      cadastroValido = true;

    } else {
      JOptionPane.showMessageDialog(null, "Cadastro não encontrado! \nFaça o cadastro para dar sequência.");
    }
    return cadastroValido;
  }

  // Editar idade voluntário
  public String alterarIdadeVoluntario(int idVoluntario) {

    for (Voluntario v : this.listaDeVoluntarios) {
      if (v.getIdVoluntario() == idVoluntario) {
        v.setIdadeVoluntario (Integer.parseInt(JOptionPane.showInputDialog("Informe a idade do doador: ")));
      }
    }
    return ("Idade alterada com sucesso! ");
  }


  // Editar cpf voluntário 
   public String alterarCpfVoluntario(int idVoluntario) {

    for (Voluntario v : this.listaDeVoluntarios) {
      if (v.getIdVoluntario() == idVoluntario) {
        v.setCpfVoluntario (JOptionPane.showInputDialog("Informe o CPF atualizado do doador: "));
      }
    }
    return ("CPF alterado com sucesso! ");
  }

  // Editar endereço voluntário
  public String alterarEnderecoVoluntario (int idVoluntario) {

    for (Voluntario v : this.listaDeVoluntarios) {
      if (v.getIdVoluntario() == idVoluntario) {
        v.setEnderecoVoluntario(JOptionPane.showInputDialog("Informe o novo endereço do doador: "));
      }
    }
    return ("CPF alterado com sucesso! ");
  }
  // Editar telefone voluntário
   public String alterarTelefoneVoluntario (int idVoluntario) {

    for (Voluntario v : this.listaDeVoluntarios) {
      if (v.getIdVoluntario() == idVoluntario) {
        v.setTelefone(JOptionPane.showInputDialog("Informe o novo telefone para contato do doador: "));
      }
    }
    return ("Contato alterado com sucesso! ");
  }

}
