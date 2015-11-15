package air.foi.hr.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

/**
 * Created by izavrski on 14.11.2015..
 */
@Table(name = "Trener")
public class Trener extends Model {

    @Column(name = "idTrener")
    private long idTrener;
    @Column(name = "imePrez")
    private String imePrez;
    @Column(name = "korIme")
    private String korIme;
    @Column(name = "lozinka")
    private String lozinka;

    public Trener() {
        super();
    }

    public Trener(long idTrener,String imePrez,String korIme,String lozinka ) {
        super();
        this.idTrener=idTrener;
        this.imePrez=imePrez;
        this.korIme=korIme;
        this.lozinka=lozinka;
    }

    public List<Trenira> trenira(){
        return getMany(Trenira.class, "Trener");
    }

    public long getIdTrener() {
        return idTrener;
    }

    public String getImePrez() {
        return imePrez;
    }

    public String getKorIme() {
        return korIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void updateTrener(Trener updatedTrener)
    {
        this.imePrez = updatedTrener.getImePrez();
        this.korIme = updatedTrener.getKorIme();
        this.lozinka = updatedTrener.getLozinka();

        this.save();
    }
}
