package interfaces;

public class Main {

    public static void main(String[] args) {

        Playable drums = new Drums();
        Playable guitar = new Guitar();
        Playable piano = new Piano();

        Playable[] instruments = new Playable[]{drums, guitar, piano};

        for (Playable instrument : instruments) {
            instrument.play();
        }

        for (Playable instrument : instruments) {
            ((Tunable) instrument).tune();
        }

        for (Playable instrument : instruments) {
            instrument.play();
        }
    }
}
