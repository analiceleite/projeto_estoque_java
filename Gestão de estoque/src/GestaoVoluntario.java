import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GestaoVoluntario {

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

  // Cadastrar voluntários

  public String cadastrarVoluntario() {

    boolean voluntarioValido = Validacao.validarCadastroDoador(0);

    Voluntario v = new Voluntario();

    v.setNomeVoluntario(EntradaSaida.SolicitarDadosPessoais("Informe o nome do doador: "));
    while (voluntarioValido == false) {
      v.setIdadeVoluntario(Integer.parseInt(EntradaSaida.SolicitarDadosPessoais( "Informe a idade (o doador deve ser acima de 18 anos): ")));
      voluntarioValido = Validacao.validarIdadeVoluntario(v.getIdadeVoluntario());
    }
    v.setEnderecoVoluntario(EntradaSaida.SolicitarDadosPessoais("Informe o endereço: "));
    v.setCpfVoluntario(EntradaSaida.SolicitarDadosPessoais("Informe o CPF: "));
    v.setTelefone(EntradaSaida.SolicitarDadosPessoais("Informe o telefone: "));
    adicionarVoluntario(v);

    return "Cadastro realizado com sucesso!";
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
    boolean encontrado = false;

    for (Voluntario v : this.listaDeVoluntarios) {
      int id = 0;
      encontrado = true;
      if (v.getIdVoluntario() == id) {
        v.setNomeVoluntario(JOptionPane.showInputDialog("Informe o novo nome do doador: "));
      }
    }
    if (encontrado == true) {
      return ("Nome alterado com sucesso! ");
    } else {
      return ("Cadastro não encontrado! ");
    }

  }

}
