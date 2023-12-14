import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GestaoEstoque {

  public ArrayList<DoacaoEmEstoque> doacoesEstoque = new ArrayList<DoacaoEmEstoque>();

  public void adicionarDoacoes(DoacaoEmEstoque Doacao) {
    this.doacoesEstoque.add(Doacao);
  }

  public ArrayList<Produto> doacoesCadastradas = new ArrayList<Produto>();

  public void cadastrarProduto(Produto Produto) {
    int id = 1;
    for (Produto d : this.doacoesCadastradas) {
      if (d.getId() >= id) {
        id = d.getId() + 1;
      }
    }
    Produto.setId(id);
    this.doacoesCadastradas.add(Produto);
  }

  // Visualizar doações cadastradas
  public String mostrarDoacoesCadastradas() {
    String mensagem = "";
    String quantidadeString = "";
    mensagem += "\n\nAs informações das doações cadastradas são: \n ";

    for (Produto d : this.doacoesCadastradas) {
      if (d.getCategoria() == "Dinheiro") {
        quantidadeString = "Valor";
      } else {
        quantidadeString = "Quantidade";
      }

      mensagem +=
        "\n ID: " +
        d.getId() +
        "\n Categoria: " +
        d.getCategoria() +
        "\n Descrição: " +
        d.getNome() +
        "\n " +
        quantidadeString +
        " atual: " +
        d.getQuantidadeAtual() +
        "\n" +
        quantidadeString +
        " min: " +
        d.getQuantidadeMin() +
        "\n";
    }

    return mensagem;
  }

  // Editar descrição doação
  public String alterarDescricaoDoacao(int id) {
    boolean encontrado = false;

    for (Produto d : this.doacoesCadastradas) {
      encontrado = false;
      if (d.getId() == id) {
        encontrado = true;
        d.setNome(
          JOptionPane.showInputDialog("Digite a nova descrição da sua doação: ")
        );
      }
    }
    if (encontrado == true) {
      return "Descrição alterada com sucesso! ";
    } else {
      return "Cadastro da doação não encontrado! ";
    }
  }

  // Excluir doação
  public boolean deletarDoacao(int id) {
    boolean result = false;
    for (Produto p : this.doacoesCadastradas) {
      if (p.getId() == id) {
        if (p.getQuantidadeAtual() == 0) {
          try {
            this.doacoesCadastradas.remove(p);
            result = true;
            break;
          } catch (Exception e) {
            result = false;
          }
        }
      }
    }
    return result;
  }

  public boolean seExiste(int id) {
    boolean encontrado = false;

    for (Produto p : this.doacoesCadastradas) {
      if (p.getId() == id) {
        encontrado = true;
      }
    }
    return encontrado;
  }

  public boolean seExisteByNome(String nome) {
    boolean encontrado = false;

    for (Produto p : this.doacoesCadastradas) {
      if (p.getNome() == nome) {
        encontrado = true;
      }
    }
    return encontrado;
  }

  public boolean seExisteByCategoria(String categoria) {
    boolean encontrado = false;

    for (Produto p : this.doacoesCadastradas) {
      if (p.getCategoria() == categoria) {
        encontrado = true;
      }
    }
    return encontrado;
  }

  public String mostrarProdutoPorId(int id) {
    String mensagem = "";

    for (Produto p : this.doacoesCadastradas) {
      if (p.getId() == id) {
        mensagem +=
          "O produto selecionado é:\n" +
          "\nID: " +
          p.getId() +
          "\nNome: " +
          p.getNome() +
          "\nCategoria: " +
          p.getCategoria() +
          "\nQuantidade em estoque: " +
          p.getQuantidadeAtual() +
          "\nQuantidade minima permitida: " +
          p.getQuantidadeMin();
      }
    }
    return mensagem;
  }

  public String mostrarProdutoPorNome(String nome) {
    String mensagem = "";

    for (Produto p : this.doacoesCadastradas) {
      if (p.getNome() == nome) {
        mensagem +=
          "O produto selecionado é:\n" +
          "\nID: " +
          p.getId() +
          "\nNome: " +
          p.getNome() +
          "\nCategoria: " +
          p.getCategoria() +
          "\nQuantidade em estoque: " +
          p.getQuantidadeAtual() +
          "\nQuantidade minima permitida: " +
          p.getQuantidadeMin();
      }
    }
    return mensagem;
  }

    public String mostrarProdutoPorCategoria(String categoria) {
    String mensagem = "";

    for (Produto p : this.doacoesCadastradas) {
      if (p.getCategoria() == categoria) {
        mensagem +=
          "O produto selecionado é:\n" +
          "\nID: " +
          p.getId() +
          "\nNome: " +
          p.getNome() +
          "\nCategoria: " +
          p.getCategoria() +
          "\nQuantidade em estoque: " +
          p.getQuantidadeAtual() +
          "\nQuantidade minima permitida: " +
          p.getQuantidadeMin();
      }
    }
    return mensagem;
  }

  public String mostrarProdutoComprar() {
    String mensagem = "";
    String quantidadeString = "";
    mensagem += "\n\nAs informações das doações cadastradas são: \n ";

    for (Produto p1 : this.doacoesCadastradas) {
      if (p1.getCategoria() == "Dinheiro") {
        quantidadeString = "Valor";
      } else {
        quantidadeString = "Quantidade";
      }
      for (Produto p : this.doacoesCadastradas) {
        if (p.getQuantidadeAtual() <= p.getQuantidadeMin()) {
          mensagem +=
            "\n ID: " +
            p.getId() +
            "\n Categoria: " +
            p.getCategoria() +
            "\n Descrição: " +
            p.getNome() +
            "\n " +
            quantidadeString +
            "Atual: " +
            p.getQuantidadeAtual() +
            "\n" +
            quantidadeString +
            "Min: " +
            p.getQuantidadeMin() +
            "\n";
        }
      }
    }
    if (mensagem.length() < 50) {
      mensagem = "Nenhum item encontrado!";
    }
    return mensagem;
  }

  public boolean editarNomeProduto(int id, String nome) {
    boolean result = false;

    for (Produto p : this.doacoesCadastradas) {
      if (p.getId() == id) {
        try {
          p.setNome(nome);
          result = true;
        } catch (Exception e) {
          result = false;
        }
      }
    }
    return result;
  }

  public boolean editarCategoriaProduto(int id, String categoria) {
    boolean result = false;

    for (Produto p : this.doacoesCadastradas) {
      if (p.getId() == id) {
        try {
          p.setCategoria(categoria);
          result = true;
        } catch (Exception e) {
          result = false;
        }
      }
    }
    return result;
  }

  // SOBRE O ARRAY DE DOAÇÕES EM ESTOQUE:

  public boolean editarQtdAtualProduto(int id, int qtdAtual) {
    boolean result = false;

    for (Produto p : this.doacoesCadastradas) {
      if (p.getId() == id) {
        try {
          p.setQuantidadeAtual(qtdAtual);
          result = true;
        } catch (Exception e) {
          result = false;
        }
      }
    }
    return result;
  }

  public boolean editarQtdMinProduto(int id, int qtdMin) {
    boolean result = false;

    for (Produto p : this.doacoesCadastradas) {
      if (p.getId() == id) {
        try {
          p.setQuantidadeMin(qtdMin);
          result = true;
        } catch (Exception e) {
          result = false;
        }
      }
    }
    return result;
  }

  public boolean addQtdAtualProduto(int id, int qtdAtual) {
    boolean result = false;

    for (Produto p : this.doacoesCadastradas) {
      if (p.getId() == id) {
        try {
          int qtd = p.getQuantidadeAtual();
          int novaQtd = qtd + qtdAtual;
          p.setQuantidadeAtual(novaQtd);
          result = true;
        } catch (Exception e) {
          result = false;
        }
      }
    }
    return result;
  }

  // Dar entrada na doação em estoque

  public boolean removeQtdAtualProduto(int id, int qtdSaida) {
    boolean result = false;

    for (Produto p : this.doacoesCadastradas) {
      if (p.getId() == id) {
        try {
          int qtd = p.getQuantidadeAtual();
          int novaQtd = qtd - qtdSaida;
          if (novaQtd >= 0) {
            p.setQuantidadeAtual(novaQtd);
            result = true;
          } else {
            JOptionPane.showMessageDialog(
              null,
              "Erro na alteração da quantidade atual do produto. Valor final menor do que o minimo permitido"
            );
          }
        } catch (Exception e) {
          result = false;
        }
      }
    }
    return result;
  }
}
