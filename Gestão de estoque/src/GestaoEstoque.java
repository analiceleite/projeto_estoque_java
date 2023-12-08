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
      if ( d.id >= id ) {
        id = d.id + 1;
      }
    }
    Doacao.id = id;
    this.doacoesCadastradas.add(Doacao);
  }

  // Visualizar doações cadastradas
  public String mostrarDoacoesCadastradas() {
    String mensagem = "";
    String quantidadeString = "";

    for (Doacao d : this.doacoesCadastradas) {
      if (d.categoria == "Dinheiro") {
        quantidadeString = "Valor";
      } else {
        quantidadeString = "Quantidade";
      }
      mensagem += "\n\nAs informações das doações cadastradas são: \n ";
      mensagem += "\n ID: " +
          d.id +
          "\n Categoria: " +
          d.categoria +
          "\n Descrição: " +
          d.descricao +
          "\n "+ quantidadeString +": " +
          d.quantidade;
    }


    return mensagem;
  }

  // Editar descrição doação
  public String alterarDescricaoDoacao(int id) {
    boolean encontrado = false;

    for (Doacao d : this.doacoesCadastradas) {
      encontrado = true;
      if (d.id == id) {
        d.descricao = JOptionPane.showInputDialog("Digite a nova descrição da sua doação: ");
      }
    }
    if (encontrado == true) {
      return ("Descrição alterada com sucesso! ");
    } else {
      return ("Cadastro da doação não encontrado! ");
    }

  }
  
  // Editar categoria doação
  public String alterarCategoriaDoacao(int id) {
    boolean encontrado = false;

    for (Doacao d : this.doacoesCadastradas) {
      encontrado = true;
      if (d.id == id) {
        d.categoria = JOptionPane.showInputDialog("Digite o novo ID do cadastro: ");
      }
    }
    if (encontrado == true) {
      return ("Categoria alterada com sucesso! ");
    } else {
      return ("Cadastro não encontrado! ");
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
