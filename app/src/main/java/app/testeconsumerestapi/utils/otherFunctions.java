package app.testeconsumerestapi.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PixelFormat;
import android.util.Base64;
import android.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.testeconsumerestapi.DAO.missoesDAO;
import app.testeconsumerestapi.DAO.pecasDAO;
import app.testeconsumerestapi.Enumerations.categoriasPeca;
import app.testeconsumerestapi.Rest_Consummer.comunicaWSRest;
import app.testeconsumerestapi.db.BancoDados;
import app.testeconsumerestapi.models.EscolhasMissao;
import app.testeconsumerestapi.models.Missao;
import app.testeconsumerestapi.models.Peca;
import app.testeconsumerestapi.models.propriedadesPeca;
import app.testeconsumerestapi.models.regrasMissao;
import app.testeconsumerestapi.stepsSelecaoPecasMissao;

/**
 * Created by Alisson on 01/11/2017.
 */

public class otherFunctions {


    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);


    public static boolean validarEmail(String email){
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public void LoadData(Context contexto){

       new pecasDAO(contexto).InsertPecasFromAPI("",contexto);
       new missoesDAO(contexto).InsertMissoesFromAPI("",contexto);

    }

    public List<Missao> carregarMissoes(Context contexto){

        ArrayList<String> campos = new ArrayList<>();

        campos.add(BancoDados.missaoCodigo);
        campos.add(BancoDados.missaoNome);
        campos.add(BancoDados.missaoObjetivo);
        campos.add(BancoDados.missaoXP);
        campos.add(BancoDados.missaoRegras);

        Cursor c = new missoesDAO(contexto).loadMissoes(campos);

        List<Missao> missoes = new ArrayList<>();

        try{
            while(c.moveToNext()){

                Missao missao = new Missao();

                missao.setNome(c.getString(c.getColumnIndex(BancoDados.missaoNome)));
                missao.setObjetivo(c.getString(c.getColumnIndex(BancoDados.missaoObjetivo)));
                missao.set_id(c.getString(c.getColumnIndex(BancoDados.missaoCodigo)));
                missao.setXP(c.getInt(c.getColumnIndex(BancoDados.missaoXP)));

                regrasMissao regras = new regrasMissao();

                regras = new jsonToModel().regrasMissaoFromJSON(c.getString(c.getColumnIndex(BancoDados.missaoRegras)));

                missao.setRegras(regras);

                missoes.add(missao);
            }

            return missoes;

        }catch (Exception ex){
            System.out.println("Excessao");
            return new ArrayList<Missao>();
        }

    }

    public List<Peca> carregarpecas(Context contexto, categoriasPeca categoria){

        BancoDados bd = new BancoDados(contexto);

        String sql = "Select * From Pecas";

        //if the category passed to parameter then filter specified
        if(categoria != null){
            sql += " Where "+BancoDados.pecaCategoria+ " = "+(categoria.ordinal()+1);
        }

        Cursor c = bd.getReadableDatabase().rawQuery(sql,null);

        List<Peca> pecas = new ArrayList<>();

        try{
            while(c.moveToNext()){

                Peca peca = new Peca();

                peca.set_id(c.getString(c.getColumnIndex(BancoDados.pecaCodigo)));
                peca.setCategoria(c.getInt(c.getColumnIndex(BancoDados.pecaCategoria)));
                peca.setDescricao(c.getString(c.getColumnIndex(BancoDados.pecaDescricao)));
                peca.setInformacoes(c.getString(c.getColumnIndex(BancoDados.pecaInformacoes)));

                propriedadesPeca propsPeca;

                propsPeca = new jsonToModel().propriedadesPecaFromJSON(c.getString(c.getColumnIndex(BancoDados.pecaPropriedades)));

                peca.setPropriedades(propsPeca);
                peca.setImagem(c.getString(c.getColumnIndex(BancoDados.pecaImagem)));
                peca.setNivel(c.getInt(c.getColumnIndex(BancoDados.pecaNivel)));
                peca.setPreco(c.getInt(c.getColumnIndex(BancoDados.pecaPreco)));
                peca.setDataCadastro(c.getString(c.getColumnIndex(BancoDados.pecaCadastro)));

                pecas.add(peca);
            }

            return pecas;

        }catch (Exception ex){
            return new ArrayList<Peca>();
        }

    }

    public Bitmap base64ToBitmap(String base64Image){

        byte[] decodedString = Base64.decode(base64Image, Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

        return decodedByte;

    }

    public ArrayList<String> validateMissao(EscolhasMissao escolhasMissao, Missao missao){


        ArrayList<String> falhas = new ArrayList<>();


        List<Peca> pecas = escolhasMissao.getPecas();

        for (Peca p : pecas){

            //convert category to enumeration
            switch (p.getCategoria()){

                case 1: //Carcaça
                    
                    if(p.getPropriedades().getPesoCarcaca() != 0 && missao.getRegras().getRegraPesoCarcaca() != 0) {

                        /*
                        if (p.getPropriedades().getPesoCarcaca() > missao.getRegras().getRegraPesoCarcaca()) {
                            falhas.add("O peso da carcaça escolhido é superior ao permitido");
                        }

                        */

                        if (p.getPropriedades().getResistenciaCarcaca().indexOf("Fraca") > 0) {
                            if (missao.getRegras().getRegraResistenciaCarcaca().indexOf("Média") > 0 || missao.getRegras().getRegraResistenciaCarcaca().indexOf("Forte") > 0) {
                                falhas.add("A carcaça que você escolheu é muita fraca");
                            }

                        }
                    }
                    break;

                case 2: //PlacaMae
                    
                    if(p.getPropriedades().getConexoesUSB() < missao.getRegras().getRegraConexoesUSB()){
                        falhas.add("Eram necessárias no mínimo "+missao.getRegras().getRegraConexoesUSB() + "conexões usb");
                    }

                    break;

                case 3: // Armazenamento

                    if(p.getPropriedades().getCacheArmazenamento() < missao.getRegras().getRegracacheArmazenamento()){
                        falhas.add("O cache do componente de armazenamento deve ser superior a "+missao.getRegras().getRegracacheArmazenamento() + "MB");
                    }

                    if(p.getPropriedades().getGbArmazenamento() < missao.getRegras().getRegraGbArmazenamento()){
                        falhas.add("A quantidade de armazenamento em disco escolhida é inferior ao mínimo necessário");
                    }


                    break;

                case 4: //Processador

                    if(p.getPropriedades().getCacheProcessador() < missao.getRegras().getRegracacheProcessador()){
                        falhas.add("O cache do processador é inferior ao mínimo necessário");
                    }

                    /*
                    String modProcessador       = p.getPropriedades().getModeloProcessador();
                    String regramodProcessador  = missao.getRegras().getRegraModeloProcessador();

                    if(modProcessador.indexOf("I5") > 0 || modProcessador.indexOf("I7") > 0 || modProcessador.indexOf("FX") > 0 || modProcessador.indexOf("Ryzen") > 0){
                        if(regramodProcessador.indexOf("I3") > 0 || regramodProcessador.indexOf("CELERON") > 0 || regramodProcessador.indexOf("PENTIUM") > 0) {
                            falhas.add("O modelo do processador não é suficiente para dar conta da configuração solicitada na missão");
                        }
                    }

                    */

                    if(p.getPropriedades().getGhzProcessador() < missao.getRegras().getRegraGhzProcessador()){
                        falhas.add("A velocidade em GHz do processador não é suficiente para rodar a configuração solicitada na missão");
                    }

                    if(p.getPropriedades().getNucleosProcessador() < missao.getRegras().getRegraNucleosProcessador()) {
                        falhas.add("A quantidade de nucleos do processos é inferior ao mínimo necessário");
                    }

                    break;

                case 5: // Memória

                    if(p.getPropriedades().getGbMemoriaRam() < missao.getRegras().getRegraGbMemoriaRam()){
                        falhas.add("A quantidade de memória Ram escolhida não é suficiente para rodar a configuração solicitada");
                    }

                    if(p.getPropriedades().getMhzMemoriaRam() < missao.getRegras().getRegraMhzMemoriaRam()){
                        falhas.add("A velocidade em Mhz da memória ram não é suficiente para rodar a configuração solicitada");
                    }

                    break;

                case 6: // Wireless
                    

                    break;

                case 7: // Bateria
                    
                    if(p.getPropriedades().getCelulasBateria() < missao.getRegras().getRegraCelulasBateria()){
                        falhas.add("A potência da bateria não é suficiente para rodar a configuração solicitada");
                    }
                    
                    break;

                case 8: //Periféricos

                    break;

                case 9: //Tela
                    
                    if(p.getPropriedades().getTamanhoTela() < missao.getRegras().getRegraTamanhoTela()) {
                        falhas.add("O tamanho da tela não é suficiente para a configuração solicitada pela missão");
                    }
                    
                    break;

                case 10: //Sistema

                    break;

            }

        }
        
        return falhas;
    }


}
