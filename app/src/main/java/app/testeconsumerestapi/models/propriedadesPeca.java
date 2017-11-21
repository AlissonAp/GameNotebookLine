package app.testeconsumerestapi.models;

/**
 * Created by Alisson on 18/09/2017.
 */

public class propriedadesPeca {


    private int GbMemoriaRam;			   // Medida em GB
    private int GbPlacaVideo;               // Medida em GB
    private int GbArmazenamento;            // Medida em GB
    private int MhzMemoriaRam;              // Medida em Mhz
    private int GhzProcessador;             // Medida em Ghz
    private int GhzPlacaVideo;              // Medida em Ghz
    private int RpmLeituraEscrita;	       // Medida em RPM
    private int NucleosProcessador;
    private String ModeloProcessador;          // Pentiun, i3, i5, i7, amdfx
    private int BitsPlacaVideo;             // Medida em Bits , ex: 128 bits, 254 bits
    private int cacheProcessador;           // Medida em MB
    private int cacheArmazenamento;         // Medida em MB
    private int MahBateria;
    private int CelulasBateria;             // Medida em miliAmperes, Ex 2800mah
    private String TipoTela;                   // LCD, LED, TOUCH
    private int TamanhoTela;                // 10, 14, 15, 15.6, 17 em polegadas
    private int ConexoesUSB;
    private String PossuiBluetooth;            //S ou N
    private String PossuiWebCam;               //S ou N
    private String PossuiLeitorCd_Dvd;         //S ou N
    private String ResistenciaCarcaca;		   // Fraca, Média, Forte
    private int PesoCarcaca;			       // Medida em gramas
    private String PossuiEntradaHDMI;          // S ou N
    private String SistemaOperacional;         // Windows, Linux

    public int getGbMemoriaRam() {
        return GbMemoriaRam;
    }

    public void setGbMemoriaRam(int gbMemoriaRam) {
        GbMemoriaRam = gbMemoriaRam;
    }

    public int getGbPlacaVideo() {
        return GbPlacaVideo;
    }

    public void setGbPlacaVideo(int gbPlacaVideo) {
        GbPlacaVideo = gbPlacaVideo;
    }

    public int getGbArmazenamento() {
        return GbArmazenamento;
    }

    public void setGbArmazenamento(int gbArmazenamento) {
        GbArmazenamento = gbArmazenamento;
    }

    public int getMhzMemoriaRam() {
        return MhzMemoriaRam;
    }

    public void setMhzMemoriaRam(int mhzMemoriaRam) {
        MhzMemoriaRam = mhzMemoriaRam;
    }

    public int getGhzProcessador() {
        return GhzProcessador;
    }

    public void setGhzProcessador(int ghzProcessador) {
        GhzProcessador = ghzProcessador;
    }

    public int getGhzPlacaVideo() {
        return GhzPlacaVideo;
    }

    public void setGhzPlacaVideo(int ghzPlacaVideo) {
        GhzPlacaVideo = ghzPlacaVideo;
    }

    public int getRpmLeituraEscrita() {
        return RpmLeituraEscrita;
    }

    public void setRpmLeituraEscrita(int rpmLeituraEscrita) {
        RpmLeituraEscrita = rpmLeituraEscrita;
    }

    public int getNucleosProcessador() {
        return NucleosProcessador;
    }

    public void setNucleosProcessador(int nucleosProcessador) {
        NucleosProcessador = nucleosProcessador;
    }

    public String getModeloProcessador() {
        return ModeloProcessador;
    }

    public void setModeloProcessador(String modeloProcessador) {
        ModeloProcessador = modeloProcessador;
    }

    public int getBitsPlacaVideo() {
        return BitsPlacaVideo;
    }

    public void setBitsPlacaVideo(int bitsPlacaVideo) {
        BitsPlacaVideo = bitsPlacaVideo;
    }

    public int getCacheProcessador() {
        return cacheProcessador;
    }

    public void setCacheProcessador(int cacheProcessador) {
        this.cacheProcessador = cacheProcessador;
    }

    public int getCacheArmazenamento() {
        return cacheArmazenamento;
    }

    public void setCacheArmazenamento(int cacheArmazenamento) {
        this.cacheArmazenamento = cacheArmazenamento;
    }

    public int getMahBateria() {
        return MahBateria;
    }

    public void setMahBateria(int mahBateria) {
        MahBateria = mahBateria;
    }

    public int getCelulasBateria() {
        return CelulasBateria;
    }

    public void setCelulasBateria(int celulasBateria) {
        CelulasBateria = celulasBateria;
    }

    public String getTipoTela() {
        return TipoTela;
    }

    public void setTipoTela(String tipoTela) {
        TipoTela = tipoTela;
    }

    public int getTamanhoTela() {
        return TamanhoTela;
    }

    public void setTamanhoTela(int tamanhoTela) {
        TamanhoTela = tamanhoTela;
    }

    public int getConexoesUSB() {
        return ConexoesUSB;
    }

    public void setConexoesUSB(int conexoesUSB) {
        ConexoesUSB = conexoesUSB;
    }

    public String getPossuiBluetooth() {
        return PossuiBluetooth;
    }

    public void setPossuiBluetooth(String possuiBluetooth) {
        PossuiBluetooth = possuiBluetooth;
    }

    public String getPossuiWebCam() {
        return PossuiWebCam;
    }

    public void setPossuiWebCam(String possuiWebCam) {
        PossuiWebCam = possuiWebCam;
    }

    public String getPossuiLeitorCd_Dvd() {
        return PossuiLeitorCd_Dvd;
    }

    public void setPossuiLeitorCd_Dvd(String possuiLeitorCd_Dvd) {
        PossuiLeitorCd_Dvd = possuiLeitorCd_Dvd;
    }

    public String getResistenciaCarcaca() {
        return ResistenciaCarcaca;
    }

    public void setResistenciaCarcaca(String resistenciaCarcaca) {
        ResistenciaCarcaca = resistenciaCarcaca;
    }

    public int getPesoCarcaca() {
        return PesoCarcaca;
    }

    public void setPesoCarcaca(int pesoCarcaca) {
        PesoCarcaca = pesoCarcaca;
    }

    public String getPossuiEntradaHDMI() {
        return PossuiEntradaHDMI;
    }

    public void setPossuiEntradaHDMI(String possuiEntradaHDMI) {
        PossuiEntradaHDMI = possuiEntradaHDMI;
    }

    public String getSistemaOperacional() {
        return SistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        SistemaOperacional = sistemaOperacional;
    }
}
