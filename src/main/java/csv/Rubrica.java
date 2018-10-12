package csv;

public class Rubrica {
    private String nome;
    private String cognome;
    private int nmedaglie;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getNmedaglie() {
        return nmedaglie;
    }

    public void setNmedaglie(int nmedaglie) {
        this.nmedaglie = nmedaglie;
    }

    @Override
    public String toString() {
        return "Rubrica{" +
                "Nome= '" + nome + '\'' +
                ", Cognome= '" + cognome + '\'' +
                ", N.medaglie= " + nmedaglie +
                '}';
    }
}
