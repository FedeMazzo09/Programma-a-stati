public class Cavallo {
    private String nome;
    private int eta;
    private String razza;
    private String colore;
    private String proprietario;

    public Cavallo(String nome, int eta, String razza, String colore, String proprietario) {
        this.nome = nome;
        this.eta = eta;
        this.razza = razza;
        this.colore = colore;
        this.proprietario = proprietario;
    }

    public String toString() {
        return nome + "," + eta + "," + razza + "," + colore + "," + proprietario;
    }
}
