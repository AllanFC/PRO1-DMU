package model;

public class Detagelse {
    private boolean canceled;
    private String reason;
    private Spiller player;

    Detagelse(boolean canceled, String reason, Spiller player) {
        this.canceled = canceled;
        this.reason = reason;
        this.player = player;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public String getReason() {
        return reason;
    }
}
