package interfaces;

public class Guitar implements Tunable, Playable {

    private boolean isTuned;

    @Override
    public void tune() {
        isTuned = true;
        System.out.println("Гитара настроена");
    }

    @Override
    public void play() {
        if (isTuned) {
            System.out.println("Гитара играет");
        } else {
            System.out.println("Гитара должна быть настроена перед игрой");
        }
    }
}
