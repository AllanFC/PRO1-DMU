package model;

public class Vagt {
    private final int timer;

    // komposition 0..* --> 1 Job
    Job job; // OBS: package visible

    // associering --> 1 Frivillig
    private Frivillig frivillig;

    // OBS: package visible
    Vagt(int timer, Frivillig frivillig) {
        this.timer = timer;
        this.setFrivillig(frivillig);
    }

    public int getTimer() {
        return timer;
    }

    //-------------------------------------------------------------------------

    public Job getJob() {
        return job;
    }

    //-------------------------------------------------------------------------

    public Frivillig getFrivillig() {
        return frivillig;
    }

    /** Pre: Denne vagt er ikke knyttet til en anden frivillig. */
    public void setFrivillig(Frivillig frivillig) {
        this.frivillig = frivillig;
        frivillig.vagter.add(this);
    }
}
