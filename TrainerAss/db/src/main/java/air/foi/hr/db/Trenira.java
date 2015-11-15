package air.foi.hr.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

/**
 * Created by izavrski on 14.11.2015..
 */

@Table(name = "Trenira")
public class Trenira extends Model{

    @Column(name = "idTrenira")
    private long idTrenira;
    @Column(name = "idTrener")
    private long idTrener;
    @Column(name = "idSportas")
    private long idSportas;
    @Column(name = "idDisciplina")
    private long idDisciplina;

    @Column(name = "trener")
    private Trener trener;

    @Column(name = "sportas")
    private Sportas sportas;

    @Column(name = "disciplina")
    private Disciplina disciplina;

    public Trenira() {
        super();
    }

    public Trenira(long idTrenira, long idTrener,long idSportas,long idDisciplina ) {
        super();
        this.idTrenira=idTrenira;
        this.idTrener=idTrener;
        this.idSportas=idSportas;
        this.idDisciplina=idDisciplina;
    }

    public long getIdTrenira() {
        return idTrenira;
    }

    public long getIdTrener() {
        return idTrener;
    }

    public long getIdSportas() {
        return idSportas;
    }

    public long getIdDisciplina() {
        return idDisciplina;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Sportas getSportas() {
        return sportas;
    }

    public Trener getTrener() {
        return trener;
    }

    public void updateTrenira(Trenira updatedTrenira)
    {
        this.idTrener = updatedTrenira.getIdTrener();
        this.idSportas = updatedTrenira.getIdSportas();
        this.idDisciplina = updatedTrenira.getIdDisciplina();

        this.save();
    }


}
