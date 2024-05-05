package interfaces;

public class Drums implements Tunable, Playable {

    private boolean isTuned;

    @Override
    public void tune() {
        isTuned = true;
        System.out.println("Барабаны настроены");
    }

    @Override
    public void play() {
        if (isTuned) {
            System.out.println("Барабаны играют");
        } else {
            System.out.println("Барабаны должны быть настроены перед игрой");
        }
    }
}
