package app.testeconsumerestapi.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by Alisson on 30/09/2017.
 */

public class BancoDados extends SQLiteOpenHelper{

    private static final int VERSAO_BANCO = 1;
    private static final String BANCO_CLIENTE = "bd_infoAPI.db";
    private static String QUERY_CREATE;

    private SQLiteDatabase db;

    //Tabelas
    public static final String tblUsuarios     = "Usuarios";
    public static final String tblPecas        = "Pecas";
    public static final String tblMissoes      = "Missoes";

    //Campos Usuários
    public static final String usuarioNome         = "nome";
    public static final String usuarioSenha        = "senha";
    public static final String usuarioEmail        = "email";
    public static final String usuarioNivel        = "nivel";
    public static final String usuarioPontuacao    = "pontuacao";
    public static final String usuarioUltMissao    = "ultimaMissao";
    public static final String usuarioDinheiro     = "dinheiro";
    public static final String usuarioUltAcesso    = "ultimoAcesso";

    //Campos peças
    public static final String pecaCodigo      = "codigo";
    public static final String pecaDescricao   = "descricao";
    public static final String pecaCategoria   = "categoria";
    public static final String pecaInformacoes = "informacoes";
    public static final String pecaPreco       = "preco";
    public static final String pecaPropriedades= "propriedades";
    public static final String pecaNivel       = "nivel";
    public static final String pecaImagem      = "imagem";
    public static final String pecaCadastro    = "datacadastro";

    //Campos missões
    public static final String missaoCodigo    = "codigo";
    public static final String missaoNome      = "nome";
    public static final String missaoObjetivo  = "objetivo";
    public static final String missaoRegras    = "regras";
    public static final String missaoCadastro  = "dataCadastro";
    public static final String missaoXP        = "xp";

    public static final String selectMissao    =  "SELECT * FROM "+tblMissoes+ ";";
    public static final String selectPeca      =  "SELECT * FROM "+tblPecas+ ";";
    public static final String selectUsuario   =  "SELECT * FROM "+tblUsuarios+ ";";

    public BancoDados(Context context){
        super(context,BANCO_CLIENTE,null,VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{

            createTables(db);

        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Exclui as tabelas caso existir
        db.execSQL("DROP TABLE IF EXISTS "+tblMissoes+ "");
        db.execSQL("DROP TABLE IF EXISTS "+tblUsuarios+ "");
        db.execSQL("DROP TABLE IF EXISTS "+tblPecas+ "");

        createTables(db);
    }


    public void createTables(SQLiteDatabase db){

        String QUERY_CREATE1 = "CREATE TABLE " +tblUsuarios +" ("+
                "codigo INTEGER PRIMARY KEY autoincrement,"+
                usuarioNome +" TEXT,"+
                usuarioSenha+" TEXT,"+
                usuarioEmail+" TEXT,"+
                usuarioNivel+" INTEGER,"+
                usuarioPontuacao+" INTEGER,"+
                usuarioUltMissao+" INTEGER,"+
                usuarioDinheiro+" INTEGER,"+
                usuarioUltAcesso+" TEXT )";

        String QUERY_CREATE2 = "CREATE TABLE "+ tblPecas+ " ("+
                pecaCodigo+" TEXT PRIMARY KEY,"+
                pecaDescricao+" TEXT,"+
                pecaCategoria+" INTEGER,"+
                pecaInformacoes+" TEXT,"+
                pecaPreco+" DOUBLE,"+
                pecaPropriedades+" TEXT,"+
                pecaNivel+" INTEGER,"+
                pecaImagem+" TEXT,"+
                pecaCadastro+" TEXT )";

        String QUERY_CREATE3 = "CREATE TABLE "+tblMissoes+" ("+
                missaoCodigo+" TEXT PRIMARY KEY ,"+
                missaoNome+" TEXT ,"+
                missaoObjetivo+" TEXT ,"+
                missaoRegras+" TEXT ,"+
                missaoCadastro+" TEXT ,"+
                missaoXP+ " INTEGER )";

                try {
                    db.execSQL(QUERY_CREATE1);
                }catch(Exception ex){

                }
                try {
                    db.execSQL(QUERY_CREATE2);
                }catch(Exception ex){

                }
                try {
                    db.execSQL(QUERY_CREATE3);
                }catch(Exception ex){

                }

    }

    public Cursor selectDate(String tabela, ArrayList<String> fields){

        Cursor cursor;
        String[] campos = new String[fields.size()];

        for (int i = 0; i < campos.length; i++) {
            campos[i] = fields.get(i);
        }

        db = this.getReadableDatabase();
        cursor = db.query(tabela, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;

    }


}
