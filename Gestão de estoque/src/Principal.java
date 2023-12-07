import javax.swing.JOptionPane;

public class Principal {
    public static void main(String[] args) throws Exception {

        GestaoEstoque ge = new GestaoEstoque();
        GestaoVoluntario gv = new GestaoVoluntario();
        boolean voluntarioValido = Validacao.validarIdadeVoluntario(0);
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
                                    d.id = Integer.parseInt(EntradaSaida.SolicitarDadosPessoais("Insira o ID do cadastro: "));
                                    d.descricao = EntradaSaida.SolicitarDadosPessoais("Insira a descrição da doação: ");
                                    d.quantidade = EntradaSaida.SolicitarDadosPessoais("Insira a quantidade: ");
                                    d.categoria = "Vestuário";
                                    ge.cadastrarDoacao(d);
                                    EntradaSaida.escolherOpcaoMenuPrincipal();
                                    break;
                                case 2:
                                    d.id = Integer.parseInt(EntradaSaida.SolicitarDadosPessoais("Insira o ID do cadastro: "));
                                    d.descricao = EntradaSaida.SolicitarDadosPessoais("Insira a descrição da doação: ");
                                    d.quantidade = EntradaSaida.SolicitarDadosPessoais("Insira a quantidade: ");
                                    d.categoria = "Alimento";
                                    ge.cadastrarDoacao(d);
                                    EntradaSaida.escolherOpcaoMenuPrincipal();
                                    break;
                                case 3: 
                                    d.id = Integer.parseInt(EntradaSaida.SolicitarDadosPessoais("Insira o ID do cadastro: "));
                                    d.descricao = EntradaSaida.SolicitarDadosPessoais("Insira a descrição da doação: ");
                                    d.quantidade = EntradaSaida.SolicitarDadosPessoais("Insira a quantidade: ");
                                    d.categoria = "Móveis";
                                    ge.cadastrarDoacao(d);
                                    EntradaSaida.escolherOpcaoMenuPrincipal();
                                    break;
                                case 4:
                                    d.id = Integer.parseInt(EntradaSaida.SolicitarDadosPessoais("Insira o ID do cadastro: "));
                                    d.categoria = "Dinheiro";
                                    d.descricao = EntradaSaida.SolicitarDadosPessoais("Insira a descrição (este campo é opcional):");

                                    // while (doarDinheiro == false) {
                                    // d.dinheiro = EntradaSaida.SolicitarDadosPessoais("Insira o valor: ");
                                    // Validacao.validarSeForDinheiro(d);
                                    // }

                                    ge.cadastrarDoacao(d);
                                    EntradaSaida.escolherOpcaoMenuPrincipal();
                                    break;

                                case 5:
                                    EntradaSaida.escolherOpcaoMenus();
                                    break;

                                default:
                                    System.exit(0);
                                    break;
                            }
                            break;

                        case 2:
                        EntradaSaida.mostrarDoacoesCadastradas(ge.mostrarDoacoesCadastradas());
                        EntradaSaida.escolherOpcaoMenuPrincipal();
                        break;

                    }


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

                    default:

                    break;
                    }

                case 3:
                EntradaSaida.escolherOpcaoMenuVoluntario();
                switch (opcaoMenuVoluntario) {
                    case 1:
                        Voluntario v = new Voluntario();
                        v.idVoluntario = Integer.parseInt(EntradaSaida.SolicitarDadosPessoais("Insira o ID do voluntário: "));
                        v.nomeVoluntario = EntradaSaida.SolicitarDadosPessoais("Informe o nome do voluntário: ");
                        while (voluntarioValido == false) {
                            v.idadeVoluntario = Integer.parseInt(EntradaSaida.SolicitarDadosPessoais("Informe a idade (o voluntário deve ser acima de 18 anos): "));
                            voluntarioValido = Validacao.validarIdadeVoluntario(v.idadeVoluntario);
                        }
                        v.enderecoVoluntario = EntradaSaida.SolicitarDadosPessoais("Informe o endereço: ");
                        v.telefone = EntradaSaida.SolicitarDadosPessoais("Informe o telefone: ");
                        gv.adicionarVoluntario(v);
                        JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
                    break;
                    case 2:
                        EntradaSaida.mostrarCadastroVoluntario(gv.mostrarVoluntariosCadastrados());
                        break;
                    case 3:
                        // Editar nome voluntário
                        break;

                        }

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
