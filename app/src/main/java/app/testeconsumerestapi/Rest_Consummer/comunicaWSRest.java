package app.testeconsumerestapi.Rest_Consummer;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.Console;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Diego on 08/10/2017.
 */

public class comunicaWSRest extends AsyncTask<Void, Void, Void> {

    private String url = "";
    private String metodo = "GET"; //Metodo default
    private String enviar = "";
    private String retorno = "";
    private int    httpCode = 0;
    private String data = "";


    @Override
    protected Void doInBackground(Void... voids) {

        connect();

        return null;
    }

    public void connect() {

        try {

            URL url = new URL(this.url);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod(this.metodo);

            urlConnection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            urlConnection.setDoOutput(true);
            urlConnection.setDoInput(true);

            if(this.metodo == "POST" || this.metodo == "PUT"){
                try(DataOutputStream wr = new DataOutputStream( urlConnection.getOutputStream())) {
                    wr.write(data.getBytes());
                }
            }

            urlConnection.connect();
            InputStream inputStream = urlConnection.getInputStream();
            if (inputStream == null) {
                return;
            }

            //Verifica retorno do servidor
            setHttpCode(urlConnection.getResponseCode());

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String linha;
            StringBuffer buffer = new StringBuffer();
            while ((linha = reader.readLine()) != null) {
                buffer.append(linha + "\n");
            }
            if (buffer.length() == 0) {
                return;
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    System.out.println("Erro fechando o stream" + e.toString());
                }
            }

            System.out.println("Dados: " + buffer.toString());

            this.retorno = buffer.toString();

            return;

        } catch (final Exception e) {


            System.out.println("Erro: " + e.getMessage());
            e.printStackTrace();
            return;

        }

    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getEnviar() {
        return enviar;
    }

    public void setEnviar(String enviar) {
        this.enviar = enviar;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
