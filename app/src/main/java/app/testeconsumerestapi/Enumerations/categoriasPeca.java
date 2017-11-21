package app.testeconsumerestapi.Enumerations;

/**
 * Created by Alisson on 16/11/2017.
 */

public enum categoriasPeca {

    Carcaca(1), PlacaMae(2), Armazenamento(3), Processador(4), Memoria(5), Wireless(6), Bateria(7), Perifericos(8), Tela(9), Sistema(10);

    private final int value;

    categoriasPeca(int value) {
        this.value = value;
    }

    public int getValue(Integer categoria) {
        return value;
    }


}
