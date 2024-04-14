package example;

public class Race {
    public boolean completed = false;
    public Horse[] horses;
    public int winner = 0;

    public static void main(String[] args) {
        Race race = new Race();
        race.gameStart();
        System.out.println("Game Start!");
        System.out.println("No1\tNo2\tNo3\tNo4\tNo5");
        System.out.println("======================");
        while (!race.isCompleted()) {
            race.reportStatus();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        race.reportStatus();
        System.out.println("======================");
        System.out.printf("Game End! The winner is %d", race.winner);
    }

    public Race() {
        horses = new Horse[] {
                new Horse(this, 1),
                new Horse(this, 2),
                new Horse(this, 3),
                new Horse(this, 4),
                new Horse(this, 5)
        };
    }

    public void gameStart() {
        for (Horse horse : horses) {
            horse.start();
        }
    }

    public boolean isCompleted() {
        return completed;
    }

    public void reportStatus() {
        for (Horse horse : horses) {
            System.out.print(horse.getDistance() + "\t");
        }
        System.out.println();
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }
}
