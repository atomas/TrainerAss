package air.foi.hr.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.Date;
import java.util.List;

/**
 * Created by izavrski on 14.11.2015..
 */
@Table(name = "Sportas")
public class Sportas extends Model {

    @Column(name = "idSportas")
    private long idSportas;
    @Column(name = "imePrez")
    private String imePrez;
    @Column(name = "datRodjenja")
    private Date datRodjenja;


    public Sportas() {
        super();
    }

    public Sportas(long idSportas,String imePrez,Date datRodjenja ) {
        super();
        this.idSportas=idSportas;
        this.imePrez=imePrez;
        this.datRodjenja=datRodjenja;
    }

    public List<Trenira> treniraSport(){
        return getMany(Trenira.class, "Sportas");
    }

    public long getIdSportas() {

        return idSportas;
    }

    public String getImePrez() {
        return imePrez;
    }

    public Date getDatRodenja() {

        return datRodjenja;
    }

    public void updateSportas(Sportas updatedSportas)
    {
        this.imePrez = updatedSportas.getImePrez();
        this.datRodjenja = updatedSportas.getDatRodenja();
        this.save();
    }
}
