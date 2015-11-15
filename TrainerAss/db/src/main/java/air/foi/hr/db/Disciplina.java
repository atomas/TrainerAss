package air.foi.hr.db;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

import java.util.List;

/**
 * Created by izavrski on 14.11.2015..
 */
@Table(name = "Disciplina")
public class Disciplina extends Model{

    @Column(name = "idDisciplina")
    private long idDisciplina;
    @Column(name = "naziv")
    private String naziv;

    public Disciplina() {
        super();
    }

    public Disciplina(long idDisciplina,String naziv ) {
        super();
        this.idDisciplina=idDisciplina;
        this.naziv=naziv;

    }

    public List<Trenira> treniraDis(){
        return getMany(Trenira.class, "Disciplina");
    }

    public long getIdDisciplina() {

        return idDisciplina;
    }

    public String getNaziv() {

        return naziv;
    }

    public void updateDisciplina(Disciplina updatedDisciplina)
    {
        this.naziv = updatedDisciplina.getNaziv();
        this.save();
    }
}
