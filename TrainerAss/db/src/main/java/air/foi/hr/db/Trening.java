package air.foi.hr.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;

/**
 * Created by izavrski on 14.11.2015..
 */

@Table(name = "Trening")
public class Trening extends Model {

    @Column(name = "idTrening")
    private long idTrening;
    @Column(name = "vrijeme")
    private Date vrijeme;
    @Column(name = "idTrenira")
    private long idTrenira;
    @Column(name = "prisutan")
    private boolean prisutan;
    @Column(name = "rezultat")
    private float rezultat;

    @Column(name = "trenira")
    private Trenira trenira;

    public Trening() {
        super();
    }

    public Trening(long idTrening,Date vrijeme,long idTrenira,boolean prisutan, float rezultat) {
        super();
        this.idTrening=idTrening;
        this.vrijeme=vrijeme;
        this.idTrenira=idTrenira;
        this.prisutan=prisutan;
        this.rezultat=rezultat;
    }

    public long getIdTrening() {
        return idTrening;
    }

    public Date getVrijeme() {
        return vrijeme;
    }

    public long getIdTrenira() {
        return idTrenira;
    }

    public boolean isPrisutan() {
        return prisutan;
    }

    public float getRezultat() {
        return rezultat;
    }

    public Trenira getTrenira() {
        return trenira;
    }

    public void setTrenira(Trenira trenira) {
        this.trenira = trenira;
    }
}
