package model;

public class Deltagelse {
    private boolean canceled;
    private String reason;
    Spiller player;

    Deltagelse(boolean canceled, String reason) {
        this.canceled = canceled;
        this.reason = reason;
        this.player = null;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public String getReason() {
        return reason;
    }

    @Override
    public String toString() {
        return player.getName() + "\t" + reason;
    }
}
