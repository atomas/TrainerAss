package model;


public class Atleticar {

    private int id, visina, tezina;
    private String ime, prezime, datum_rodenja;
    private boolean nazocan;
    private String vrijeme, disciplina;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVisina() {
        return visina;
    }

    public void setVisina(int visina) {
        this.visina = visina;
    }

    public int getTezina() {
        return tezina;
    }

    public void setTezina(int tezina) {
        this.tezina = tezina;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getDatum_rodenja() {
        return datum_rodenja;
    }

    public void setDatum_rodenja(String datum_rodenja) {
        this.datum_rodenja = datum_rodenja;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public boolean isNazocan() {
        return nazocan;
    }

    public void setNazocan(boolean nazocan) {
        this.nazocan = nazocan;
    }

    public String getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(String vrijeme) {
        this.vrijeme = vrijeme;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }
}
