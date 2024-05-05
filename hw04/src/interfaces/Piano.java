package interfaces;

public class Piano implements Playable, Tunable {

    private boolean isTuned;

    @Override
    public void tune() {
        isTuned = true;
        System.out.println("Пианино настроено");
    }

    @Override
    public void play() {
        if (isTuned) {
            System.out.println("Пианино играет");
        } else {
            System.out.println("Пианино должно быть настроено перед игрой");
        }
    }
}
