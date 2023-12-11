import java.util.ArrayList;

import javax.swing.JOptionPane;

public class GestaoEstoque {

  public ArrayList<DoacaoEmEstoque> doacoesEstoque = new ArrayList<DoacaoEmEstoque>();

  public void adicionarDoacoes(DoacaoEmEstoque Doacao) {
    this.doacoesEstoque.add(Doacao);
  }

  public ArrayList<Doacao> doacoesCadastradas = new ArrayList<Doacao>();

  public void cadastrarDoacao(Doacao Doacao) {
    int id = 1;
    for (Doacao d : this.doacoesCadastradas) {
      if (d.getId() >= id) {
        id = d.getId() + 1;
      }
    }
    Doacao.setId(id);
    this.doacoesCadastradas.add(Doacao);
  }

  // Visualizar doações cadastradas
  public String mostrarDoacoesCadastradas() {
    String mensagem = "";
    String quantidadeString = "";
    mensagem += "\n\nAs informações das doações cadastradas são: \n ";

    for (Doacao d : this.doacoesCadastradas) {
      if (d.getCategoria() == "Dinheiro") {
        quantidadeString = "Valor";
      } else {
        quantidadeString = "Quantidade";
      }

      mensagem += "\n ID: " +
          d.getId() +
          "\n Categoria: " +
          d.getCategoria() +
          "\n Descrição: " +
          d.getDescricao() +
          "\n " + quantidadeString + ": " +
          d.getQuantidade() + "\n";
    }

    return mensagem;
  }

  // Editar descrição doação
  public String alterarDescricaoDoacao(int id) {
    boolean encontrado = false;

    for (Doacao d : this.doacoesCadastradas) {
      encontrado = false;
      if (d.getId() == id) {
        encontrado = true;
        d.setDescricao(JOptionPane.showInputDialog("Digite a nova descrição da sua doação: "));

      }
    }
    if (encontrado == true) {
      return "Descrição alterada com sucesso! ";
    } else {

      return "Cadastro da doação não encontrado! ";
    }
  }

  // Excluir doação
  public String deletarDoacao(int id) {
    this.doacoesCadastradas.remove(id);
    return "Cadastro removido com sucesso!";
  }

  // SOBRE O ARRAY DE DOAÇÕES EM ESTOQUE:

  // Dar entrada na doação em estoque

  // Consultar doações em estoque por ID

  // Consultar doações por categoria

}
