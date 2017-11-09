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

    private static final int VERSAO_BANCO = 3;
    private static final String BANCO_CLIENTE = "bd_notebookLine.db";
    private static String QUERY_CREATE;

    private SQLiteDatabase db;

    //Tabelas
    public static final String tblUsuarios     = "Pecas";
    public static final String tblPecas        = "Pecas";
    public static final String tblMissoes      = "Missoes";

    //Campos Usuários
    public static final String usuarioNome         = "user_nome";
    public static final String usuarioSenha        = "user_senha";
    public static final String usuarioEmail        = "user_email";
    public static final String usuarioNivel        = "user_nivel";
    public static final String usuarioPontuacao    = "user_pontuacao";
    public static final String usuarioUltMissao    = "user_ultimaMissao";
    public static final String usuarioDinheiro     = "user_dinheiro";
    public static final String usuarioUltAcesso    = "user_ultimoAcesso";

    //Campos peças
    public static final String pecaCodigo      = "peca_codigo";
    public static final String pecaDescricao   = "peca_descricao";
    public static final String pecaCategoria   = "peca_categoria";
    public static final String pecaInformacoes = "peca_informacoes";
    public static final String pecaPreco       = "peca_preco";
    public static final String pecaPropriedades= "peca_propriedades";
    public static final String pecaNivel       = "peca_nivel";
    public static final String pecaImagem      = "peca_imagem";
    public static final String pecaCadastro    = "peca_datacadastro";

    //Campos missões
    public static final String missaoCodigo    = "missao_codigo";
    public static final String missaoNome      = "missao_nome";
    public static final String missaoObjetivo  = "missao_objetivo";
    public static final String missaoRegras    = "missao_regras";
    public static final String missaoCadastro  = "missao_dataCadastro";


    public static final String selectMissao    =  "SELECT * FROM "+tblMissoes+ ";";
    public static final String selectPeca      =  "SELECT * FROM "+tblPecas+ ";";
    public static final String selectUsuario   =  "SELECT * FROM "+tblUsuarios+ ";";

    public BancoDados(Context context){
        super(context,BANCO_CLIENTE,null,VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try{

            createTables();

        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //Exclui as tabelas caso existir
        db.execSQL("DROP TABLE "+tblMissoes+ "");
        db.execSQL("DROP TABLE "+tblUsuarios+ "");
        db.execSQL("DROP TABLE "+tblPecas+ "");

        createTables();
    }


    public void createTables(){

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
                missaoCodigo+" TEXT PRIMARY KEY,"+
                missaoNome+" TEXT,"+
                missaoObjetivo+" TEXT,"+
                missaoRegras+" TEXT,"+
                missaoCadastro+" TEXT )";


                db.execSQL(QUERY_CREATE1);
                db.execSQL(QUERY_CREATE2);
                db.execSQL(QUERY_CREATE3);

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
