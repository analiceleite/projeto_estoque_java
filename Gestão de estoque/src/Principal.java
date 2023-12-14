import javax.swing.JOptionPane;

public class Principal {

  public static void main(String[] args) throws Exception {
    GestaoEstoque ge = new GestaoEstoque();
    GestaoVoluntario gv = new GestaoVoluntario();
    boolean seExiste = false;
    String categoria = "";
    int opcaoMenus = 0;
    int opcaoMenuPrincipal = 0;
    int opcaoMenuEstoque = 0;
    int opcaoCategorias = 0;
    int opcaoMenuVoluntario = 0;
    int opcaoMenuConsulta = 0;
    int opcaoMenuEditarVoluntario = 0;
    int id = 0;

    do {

      opcaoMenus = EntradaSaida.escolherOpcaoMenus();
      switch (opcaoMenus) {
        case 1: // Produtos
          id = EntradaSaida.solicitarId("Acesso restrito!\nInsira seu ID de cadastro para continuar: ");
          if (gv.validarCadastroDoador(id)) {
            opcaoMenuPrincipal = EntradaSaida.escolherOpcaoMenuPrincipal();

            switch (opcaoMenuPrincipal) {
              case 1: // Cadastrar produtos
                Produto p = new Produto();
                opcaoCategorias = EntradaSaida.escolherOpcaoMenuCategorias();

                while (opcaoCategorias != 5) {
                  if (opcaoCategorias == 1) {
                    categoria = "Vestuário";
                  } else if (opcaoCategorias == 2) {
                    categoria = "Alimento";
                  } else if (opcaoCategorias == 3) {
                    categoria = "Móveis";
                  } else if (opcaoCategorias == 4) {
                    categoria = "Dinheiro";
                  } else {
                    EntradaSaida.escolherOpcaoMenuCategorias();
                  }

                  p.setNome(EntradaSaida.SolicitarDadosString("Insira o nome do produto: "));
                  p.setQuantidadeAtual(EntradaSaida.SolicitarDadosInt("Insira a quantidade atual: "));
                  p.setQuantidadeMin(EntradaSaida.SolicitarDadosInt("Insira a quantidade minima: "));

                  p.setCategoria(categoria);
                  ge.cadastrarProduto(p);
                  opcaoCategorias = EntradaSaida.escolherOpcaoMenuCategorias();
                }
                break;
              case 2: // Visualizar produtos cadastrados
                EntradaSaida.mostrarDoacoesCadastradas(ge.mostrarDoacoesCadastradas());
                break;
              case 3: // Editar produtos:
                EntradaSaida.mostrarDoacoesCadastradas(ge.mostrarDoacoesCadastradas());
                id = EntradaSaida.solicitarId("Insira a identificação do produto que deseja alterar: ");
                seExiste = ge.seExiste(id);
                if (seExiste) {
                  String mensagem = ge.mostrarProdutoPorId(id);
                  int produtoEditarOpcoes = EntradaSaida.produtoEditarOpcoes();
                  if (produtoEditarOpcoes == 1) { // Nome
                    String novoNome = EntradaSaida.SolicitarDadosString(mensagem + "\n\nInsira o novo nome do produto: ");
                    boolean result = ge.editarNomeProduto(id, novoNome);
                    if (result) {
                      JOptionPane.showMessageDialog(
                          null,
                          ge.mostrarProdutoPorId(id));
                    } else {
                      JOptionPane.showMessageDialog(null,"Erro na alteração do novo nome, favor tentar novamente");
                    }
                  } else if (produtoEditarOpcoes == 2) { // Categoria
                    int novaCategoriaNum = EntradaSaida.escolherOpcaoMenuCategorias();
                    if (novaCategoriaNum == 1) {
                      categoria = "Vestuário";
                    } else if (novaCategoriaNum == 2) {
                      categoria = "Alimento";
                    } else if (novaCategoriaNum == 3) {
                      categoria = "Móveis";
                    } else if (novaCategoriaNum == 4) {
                      categoria = "Dinheiro";
                    }
                    boolean result = ge.editarCategoriaProduto(id, categoria);
                    if (result) {
                      JOptionPane.showMessageDialog(null,ge.mostrarProdutoPorId(id));
                    } else {
                      JOptionPane.showMessageDialog(null,"Erro na alteração da categoria do produto, favor tentar novamente");
                    }
                  } else if (produtoEditarOpcoes == 3) { // QuantidadeAtual
                    int qtdAtual = EntradaSaida.SolicitarDadosInt(mensagem + "\n\nInsira a quantidade atual do produto: ");
                    boolean result = ge.editarQtdAtualProduto(id, qtdAtual);
                    if (result) {
                      JOptionPane.showMessageDialog(null,ge.mostrarProdutoPorId(id));
                    } else {
                      JOptionPane.showMessageDialog(null,"Erro na alteração da quantidade atual do produto, favor tentar novamente");
                    }
                  } else if (produtoEditarOpcoes == 4) { // QuantidateMin
                    int qtdMin = EntradaSaida.SolicitarDadosInt(mensagem + "\n\nInsira a quantidade atual do produto: ");
                    boolean result = ge.editarQtdMinProduto(id, qtdMin);
                    if (result) {
                      JOptionPane.showMessageDialog(null,ge.mostrarProdutoPorId(id));
                    } else {
                      JOptionPane.showMessageDialog(null,"Erro na alteração da quantidade atual do produto, favor tentar novamente");
                    }
                  } else if (produtoEditarOpcoes == 5) { // Deletar
                    int confirmacao = EntradaSaida.confirmacao( mensagem + "\n\nDeseja deletar o produto " + id + " ?");
                    if (confirmacao == 2) {
                      boolean result = ge.deletarDoacao(id);
                      if (result) {
                        JOptionPane.showMessageDialog(null,"O produto " + id + " foi deletado com sucesso!");
                      } else {
                        JOptionPane.showMessageDialog(null,"O produto " + id + " ainda possui itens em estoque.");
                      }
                    } else {
                      JOptionPane.showMessageDialog(null, "O produto " + id + " não foi deletado.");
                    }
                  }
                } else {
                  JOptionPane.showMessageDialog(null,"Id do produto inexistente!");
                }

                break;
            }
            break;
          }
        case 2: // Doações
          opcaoMenuEstoque = EntradaSaida.escolherOpcaoMenuEstoque();
          switch (opcaoMenuEstoque) {
            case 1: // Entrada estoque
              EntradaSaida.mostrarDoacoesCadastradas(ge.mostrarDoacoesCadastradas());
              id = EntradaSaida.solicitarId("Insira a identificação do produto que deseja doar: ");
              String mensagem = ge.mostrarProdutoPorId(id);
              int qtdEntrada = EntradaSaida.SolicitarDadosInt(mensagem + "\n\nInsira a quantidade que deseja doar deste produto: ");

              boolean result = ge.addQtdAtualProduto(id, qtdEntrada);
              if (result) {
                JOptionPane.showMessageDialog(null, ge.mostrarProdutoPorId(id));
              } else {
                JOptionPane.showMessageDialog(null,"Erro na alteração da quantidade atual do produto, favor tentar novamente");
              }
              break;
            case 2: // Saida estoque
              EntradaSaida.mostrarDoacoesCadastradas(ge.mostrarDoacoesCadastradas());
              id = EntradaSaida.solicitarId("Insira a identificação do produto que deseja doar: ");
              String mensagem2 = ge.mostrarProdutoPorId(id);
              int qtdSaida = EntradaSaida.SolicitarDadosInt(mensagem2 + "\n\nInsira a quantidade que deseja dar baixa deste produto : ");

              boolean result2 = ge.removeQtdAtualProduto(id, qtdSaida);
              if (result2) {
                JOptionPane.showMessageDialog(null, ge.mostrarProdutoPorId(id));
              } else {
                JOptionPane.showMessageDialog(null,"Erro na alteração da quantidade atual do produto, favor tentar novamente");
              }
              break;
            case 3: // Consultar
              opcaoMenuConsulta = EntradaSaida.escolherOpcaoMenuConsulta();
              switch (opcaoMenuConsulta) {
                case 1: // Itens para comprar
                  JOptionPane.showMessageDialog(null,ge.mostrarProdutoComprar());
                  break;
                case 2: // Consulta por id
                  id = EntradaSaida.solicitarId("Insira o ID do produto que deseja buscar: ");
                      seExiste = ge.seExiste(id);
                  if (seExiste) {
                    JOptionPane.showMessageDialog(null, ge.mostrarProdutoPorId(id));
                  } else {
                    JOptionPane.showMessageDialog(null, "Produto não encontrado. Tente outro ID! ");
                  }
                  break;
                case 3: // Consulta por nome
                  String nome = EntradaSaida.SolicitarDadosString("Insira o nome que deseja buscar: ");
                  seExiste = ge.seExisteByNome(nome);
                  if (seExiste) {
                    JOptionPane.showMessageDialog(null, ge.mostrarProdutoPorNome(nome));
                  } else {
                    JOptionPane.showMessageDialog(null, "Produto não encontrado. Tente outro nome! ");
                  }
                  break;
                case 4: // Voltar menu
                  categoria = EntradaSaida.SolicitarDadosString("Insira o nome que deseja buscar: ");
                  seExiste = ge.seExisteByNome(categoria);
                  if (seExiste) {
                    JOptionPane.showMessageDialog(null, ge.mostrarProdutoPorCategoria(categoria));
                  } else {
                    JOptionPane.showMessageDialog(null, "Produto não encontrado. Tente outra categoria! ");
                  }
                  break;
                case 5: // Voltar menu
                  break;
              }
              break;
            case 4:
              // EntradaSaida.escolherOpcaoMenus();
              break;
          }
          break;
        case 3: // Doadores
          opcaoMenuVoluntario = EntradaSaida.escolherOpcaoMenuVoluntario();
          switch (opcaoMenuVoluntario) {
            case 1:
              EntradaSaida.mostrarCadastroVoluntario(gv.cadastrarVoluntario());
              break;
            case 2:
              EntradaSaida.mostrarCadastroVoluntario(
                  gv.mostrarVoluntariosCadastrados());
              break;
            case 3:
              opcaoMenuEditarVoluntario = EntradaSaida.escolherOpcaoMenuEditarVoluntario();
              switch (opcaoMenuEditarVoluntario) {
                case 1: // Editar nome
                id = EntradaSaida.solicitarId("Insira a identificação do doador cujo nome deseja editar: ");
                gv.alterarNomeVoluntario(id);
                break;
                case 2: // Editar idade
                id = EntradaSaida.solicitarId("Insira a identificação do doador cuja idade deseja editar: ");
                gv.alterarIdadeVoluntario(id);
                break;
                case 3: // Editar CPF
                id = EntradaSaida.solicitarId("Insira a identificação do doador cujo CPF deseja editar: ");
                gv.alterarCpfVoluntario(id);
                break;
                case 4: // Editar endereço
                id = EntradaSaida.solicitarId("Insira a identificação do doador cujo endereço deseja editar: ");
                gv.alterarEnderecoVoluntario(id);
                break;
                case 5: // Editar telefone
                id = EntradaSaida.solicitarId("Insira o identificador do doador cujo telefone deseja editar: ");
                gv.alterarTelefoneVoluntario(id);
                break;
                case 6: // Voltar ao menu principal
                EntradaSaida.escolherOpcaoMenus();
                break;
              }
              break;
          }
          break;
      }
    } while (opcaoMenus != 0);
  }
}

