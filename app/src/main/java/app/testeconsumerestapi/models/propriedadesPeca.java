package app.testeconsumerestapi.models;

/**
 * Created by Alisson on 18/09/2017.
 */

public class propriedadesPeca {


    private Number GbMemoriaRam;			   // Medida em GB
    private Number GbPlacaVideo;               // Medida em GB
    private Number GbArmazenamento;            // Medida em GB
    private Number MhzMemoriaRam;              // Medida em Mhz
    private Number GhzProcessador;             // Medida em Ghz
    private Number GhzPlacaVideo;              // Medida em Ghz
    private Number RpmLeituraEscrita;	       // Medida em RPM
    private Number NucleosProcessador;
    private String ModeloProcessador;          // Pentiun, i3, i5, i7, amdfx
    private Number BitsPlacaVideo;             // Medida em Bits , ex: 128 bits, 254 bits
    private Number cacheProcessador;           // Medida em MB
    private Number cacheArmazenamento;         // Medida em MB
    private Number MahBateria;
    private Number CelulasBateria;             // Medida em miliAmperes, Ex 2800mah
    private String TipoTela;                   // LCD, LED, TOUCH
    private Number TamanhoTela;                // 10, 14, 15, 15.6, 17 em polegadas
    private Number ConexoesUSB;
    private String PossuiBluetooth;            //S ou N
    private String PossuiWebCam;               //S ou N
    private String PossuiLeitorCd_Dvd;         //S ou N
    private String ResistenciaCarcaca;		   // Fraca, Média, Forte
    private Number PesoCarcaca;			       // Medida em gramas
    private String PossuiEntradaHDMI;          // S ou N
    private String SistemaOperacional;         // Windows, Linux

    public Number getGbMemoriaRam() {
        return GbMemoriaRam;
    }

    public void setGbMemoriaRam(Number gbMemoriaRam) {
        GbMemoriaRam = gbMemoriaRam;
    }

    public Number getGbPlacaVideo() {
        return GbPlacaVideo;
    }

    public void setGbPlacaVideo(Number gbPlacaVideo) {
        GbPlacaVideo = gbPlacaVideo;
    }

    public Number getGbArmazenamento() {
        return GbArmazenamento;
    }

    public void setGbArmazenamento(Number gbArmazenamento) {
        GbArmazenamento = gbArmazenamento;
    }

    public Number getMhzMemoriaRam() {
        return MhzMemoriaRam;
    }

    public void setMhzMemoriaRam(Number mhzMemoriaRam) {
        MhzMemoriaRam = mhzMemoriaRam;
    }

    public Number getGhzProcessador() {
        return GhzProcessador;
    }

    public void setGhzProcessador(Number ghzProcessador) {
        GhzProcessador = ghzProcessador;
    }

    public Number getGhzPlacaVideo() {
        return GhzPlacaVideo;
    }

    public void setGhzPlacaVideo(Number ghzPlacaVideo) {
        GhzPlacaVideo = ghzPlacaVideo;
    }

    public Number getRpmLeituraEscrita() {
        return RpmLeituraEscrita;
    }

    public void setRpmLeituraEscrita(Number rpmLeituraEscrita) {
        RpmLeituraEscrita = rpmLeituraEscrita;
    }

    public Number getNucleosProcessador() {
        return NucleosProcessador;
    }

    public void setNucleosProcessador(Number nucleosProcessador) {
        NucleosProcessador = nucleosProcessador;
    }

    public String getModeloProcessador() {
        return ModeloProcessador;
    }

    public void setModeloProcessador(String modeloProcessador) {
        ModeloProcessador = modeloProcessador;
    }

    public Number getBitsPlacaVideo() {
        return BitsPlacaVideo;
    }

    public void setBitsPlacaVideo(Number bitsPlacaVideo) {
        BitsPlacaVideo = bitsPlacaVideo;
    }

    public Number getCacheProcessador() {
        return cacheProcessador;
    }

    public void setCacheProcessador(Number cacheProcessador) {
        this.cacheProcessador = cacheProcessador;
    }

    public Number getCacheArmazenamento() {
        return cacheArmazenamento;
    }

    public void setCacheArmazenamento(Number cacheArmazenamento) {
        this.cacheArmazenamento = cacheArmazenamento;
    }

    public Number getMahBateria() {
        return MahBateria;
    }

    public void setMahBateria(Number mahBateria) {
        MahBateria = mahBateria;
    }

    public Number getCelulasBateria() {
        return CelulasBateria;
    }

    public void setCelulasBateria(Number celulasBateria) {
        CelulasBateria = celulasBateria;
    }

    public String getTipoTela() {
        return TipoTela;
    }

    public void setTipoTela(String tipoTela) {
        TipoTela = tipoTela;
    }

    public Number getTamanhoTela() {
        return TamanhoTela;
    }

    public void setTamanhoTela(Number tamanhoTela) {
        TamanhoTela = tamanhoTela;
    }

    public Number getConexoesUSB() {
        return ConexoesUSB;
    }

    public void setConexoesUSB(Number conexoesUSB) {
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

    public Number getPesoCarcaca() {
        return PesoCarcaca;
    }

    public void setPesoCarcaca(Number pesoCarcaca) {
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
