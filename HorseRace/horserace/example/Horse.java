package example;

public class Horse extends Thread{
    private Race race;
    private int distance = 0;
    private int track;

    public Horse(Race race, int track) {
        this.race = race;
        this.track = track;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public void run() {
        while (!race.isCompleted()) {
            distance += (int)(Math.random() * 10);
            if (distance >= 100) {
                distance = 100;
                race.setCompleted(true);
                race.setWinner(track);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
    }
}
