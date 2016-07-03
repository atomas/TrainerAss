 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpManager {

    //get data kada nesto treba slati na server
    public static String getData(RequestPackage p) {

        BufferedReader reader = null;
        String uri = p.getUri();

        try {
            //na koji link se salje
            URL url = new URL(uri);
            //uspostavlja se http conection
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            //postavljanje metode za taj request
            con.setRequestMethod(p.getMethod());
            //omogucavanje upisivanja vrijednost koje se zahtjevaju na apiju
            con.setDoOutput(true);
            //upis vrijednosti u body
            OutputStreamWriter writer = new OutputStreamWriter(
                    con.getOutputStream());
            //encodiranje upisanih vrijednosti
            writer.write(p.getEncodedParams());
            //nakon sto se upise sve, za slucaj da je nesto ostalo poziva seflush kako bi bili sigurni da je writer prazan
            writer.flush();
            StringBuilder sb = new StringBuilder();
            //content koji ce se vratiti sa servera se sprema u reader, iz kojeg se cita odgovor sa servera
            reader = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            return sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

    }

    public static String getData(String uri) {

        BufferedReader reader = null;

        try {
            URL url = new URL(uri);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            StringBuilder sb = new StringBuilder();
            reader = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            return sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }

    }

}
