package app.testeconsumerestapi.utils;

/**
 * Created by Alisson on 02/11/2017.
 */

public class config_urls_rest {

    public static String baseURL           = "https://apinode20171234.herokuapp.com";

    public static String urlBuscarPecas    = "/pecas/";
    public static String urlBuscarMissoes  = "/missoes/";
    public static String urlBuscarUsuarios = "/usuarios/";

    public static String urlDeletarPeca    = "/pecas/deletar/";
    public static String urlDeletarMissao  = "/missoes/deletar/";
    public static String urlDeletarUsuario = "/usuarios/deletar/";

    public static String urlValidarUsuario = "/usuarios/validar/@email/@senha";
    public static String urlCriarUsuario   = "/usuarios/cadastrar/";


}
