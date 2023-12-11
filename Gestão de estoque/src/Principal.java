import javax.swing.JOptionPane;
public class Principal {
    public static void main(String[] args) throws Exception {

        GestaoEstoque ge = new GestaoEstoque();
        GestaoVoluntario gv = new GestaoVoluntario();
        int opcaoMenus = 0;
        int opcaoMenuPrincipal = 0;
        int opcaoMenuEstoque = 0;
        int opcaoCategorias = 0;
        int opcaoMenuVoluntario = 0;
        int id = 0;

        do {

            // Fazer a validação do login

            opcaoMenus = EntradaSaida.escolherOpcaoMenus();
            switch (opcaoMenus) {
                case 1:
                    opcaoMenuPrincipal = EntradaSaida.escolherOpcaoMenuPrincipal();
                        switch (opcaoMenuPrincipal) {
                            case 1:
                                Doacao d = new Doacao();
                                opcaoCategorias = EntradaSaida.escolherOpcaoMenuCategorias();
                                
                                switch (opcaoCategorias) {
                                    case 1:
                                        d.setDescricao(EntradaSaida.SolicitarDadosPessoais("Insira a descrição da doação: "));
                                        d.setQuantidade(EntradaSaida.SolicitarDadosPessoais("Insira a quantidade: "));
                                        d.setCategoria("Vestuário");
                                        ge.cadastrarDoacao(d);
                                        break;
                                    case 2:
                                        d.setDescricao(EntradaSaida.SolicitarDadosPessoais("Insira a descrição da doação: "));
                                        d.setQuantidade(EntradaSaida.SolicitarDadosPessoais("Insira a quantidade: "));
                                        d.setCategoria("Alimento");
                                        ge.cadastrarDoacao(d);
                                        break;
                                    case 3:
                                        d.setDescricao(EntradaSaida.SolicitarDadosPessoais("Insira a descrição da doação: "));
                                        d.setQuantidade(EntradaSaida.SolicitarDadosPessoais("Insira a quantidade: "));
                                        d.setCategoria("Móveis");
                                        ge.cadastrarDoacao(d);
                                        break;
                                    case 4:
                                        d.setCategoria("Dinheiro");
                                        d.setDescricao(EntradaSaida.SolicitarDadosPessoais("Insira a descrição da doação (campo opcional): "));
                                        d.setQuantidade(EntradaSaida.SolicitarDadosPessoais("Insira o valor: "));
                                        ge.cadastrarDoacao(d);
                                        break;
                                }
                            
                                break;

                            case 2:
                                EntradaSaida.mostrarDoacoesCadastradas(ge.mostrarDoacoesCadastradas());
                                break;

                            case 3:
                                // Alterar descrição de alguma doação:
                                id = EntradaSaida.solicitarId("ID");
                                JOptionPane.showMessageDialog(null, ge.alterarDescricaoDoacao(id));
                                break;

                            case 4:
                                // Excluir cadastro de alguma doação:
                                EntradaSaida.solicitarId("ID");
                                JOptionPane.showMessageDialog(null, ge.deletarDoacao(id));
                                break;

                        }
                        break;
                    
                case 2:

                    EntradaSaida.escolherOpcaoMenuEstoque();

                    switch (opcaoMenuEstoque) {
                        case 1:
                            // Dar entrada em doações para o estoque
                            break;
                        case 2:
                            // Consultar doações em estoque
                            break;
                        case 3:
                            // Consultar doações por categoria
                            break;
                        case 4:
                            EntradaSaida.escolherOpcaoMenuPrincipal();
                            break;
                    }

                case 3:

                    opcaoMenuVoluntario = EntradaSaida.escolherOpcaoMenuVoluntario();
                    switch (opcaoMenuVoluntario) {
                        case 1:
                            EntradaSaida.mostrarCadastroVoluntario(gv.cadastrarVoluntario());
                            break;
                        case 2:
                            EntradaSaida.mostrarCadastroVoluntario(gv.mostrarVoluntariosCadastrados());
                            break;
                        case 3:
                            EntradaSaida.mostrarCadastroVoluntario(gv.alterarNomeVoluntario(id));
                            break;
                        case 4:
                            EntradaSaida.solicitarId("ID");
                            JOptionPane.showMessageDialog(null, ge.deletarDoacao(id));
                            EntradaSaida.escolherOpcaoMenuPrincipal();
                            break;
                        case 5:
                            EntradaSaida.escolherOpcaoMenus();
                            break;
                    }
                    break;
            }
        } while (opcaoMenus != 0);
    }
}

// // case 3:
// // Alterar descrição de alguma doação
// EntradaSaida.solicitarId("ID");
// JOptionPane.showMessageDialog(null, ge.alterarDescricaoDoacao(id));
// break;

// case 9:
// // Motrar voluntários cadastrados:
// EntradaSaida.mostrarCadastroVoluntario(gv.mostrarVoluntariosCadastrados());
// break;
