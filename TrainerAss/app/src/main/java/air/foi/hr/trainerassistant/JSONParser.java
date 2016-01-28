package air.foi.hr.trainerassistant;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import air.foi.hr.trainerassistant.model.Atleticar;
import air.foi.hr.trainerassistant.model.Disciplina;

public class JSONParser {

    //parsiranje atleticara
    public static List<Atleticar> parseAtleticar(String content) {

        try {
            JSONArray jsonArray = new JSONArray(content);
            List<Atleticar> atleticar = new ArrayList<Atleticar>();

            for (int i = 0; i < jsonArray.length(); i++) {

                Atleticar a = new Atleticar();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                a.setId(jsonObject.getInt("id"));
                a.setIme(jsonObject.getString("ime"));
                a.setPrezime(jsonObject.getString("prezime"));
                atleticar.add(a);

            }

            return atleticar;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

    //parsiranje disciplina
    public static List<Disciplina> parseDisciplina(String content) {

        try {
            //content koji dobijes spremis u json array
            JSONArray jsonArray = new JSONArray(content);
            List<Disciplina> disciplina = new ArrayList<Disciplina>();
            for (int i = 0; i < jsonArray.length(); i++) {

                //dok ne dode do kraja, za svaku disciplinu koja postoji u jsonarrayu, prodi kroz nju i spremi je u listu
                Disciplina d = new Disciplina();
                JSONObject jsonOject = jsonArray.getJSONObject(i);
                d.setId(jsonOject.getInt("id"));
                d.setNaziv(jsonOject.getString("naziv"));
                d.setOpis(jsonOject.getString("opis"));

                disciplina.add(d);

            }
            return disciplina;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

    }

}
