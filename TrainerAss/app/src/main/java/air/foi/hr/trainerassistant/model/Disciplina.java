package air.foi.hr.trainerassistant.model;

import java.util.List;

public class Disciplina {

    private int id;
    private String naziv, opis;
    private boolean nazocan;
    private List<Atleticar> atleticarList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public boolean isNazocan() {
        return nazocan;
    }
    public void setNazocan(boolean nazocan) {
        this.nazocan = nazocan;
    }

    public List<Atleticar> getAtleticarList() {
        return atleticarList;
    }

    public void setAtleticarList(List<Atleticar> atleticarList) {
        this.atleticarList = atleticarList;
    }
}
