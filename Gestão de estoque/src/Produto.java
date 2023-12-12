import javax.swing.JOptionPane;

public class Produto {
    private String categoria;
    private String nome;
    private int id;
    private int quantidadeAtual;
    private int quantidadeMin;
    private String dinheiro;
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }
    public void setQuantidadeAtual(int quantidade) {
        this.quantidadeAtual = quantidade;
    }
    public int getQuantidadeMin() {
        return quantidadeMin;
    }
    public void setQuantidadeMin(int quantidade) {
        this.quantidadeMin = quantidade;
    }
    public String getDinheiro() {
        return dinheiro;
    }
    public void setDinheiro(String dinheiro) {
        this.dinheiro = dinheiro;
    }

}
