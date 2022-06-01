package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class Festival {
    private final String navn;
    private final LocalDate fraDato;
    private final LocalDate tilDato;

    // komposition 1 --> 0..* Job
    private final ArrayList<Job> jobs = new ArrayList<>();

    public Festival(String navn, LocalDate fraDato, LocalDate tilDato) {
        this.navn = navn;
        this.fraDato = fraDato;
        this.tilDato = tilDato;
    }

    public String getNavn() {
        return navn;
    }

    public LocalDate getFraDato() {
        return fraDato;
    }

    public LocalDate getTilDato() {
        return tilDato;
    }

    //-------------------------------------------------------------------------

    public ArrayList<Job> getJobs() {
        return new ArrayList<>(jobs);
    }

    public Job opretJob(String kode, String beskrivelse, LocalDate dato,
                        int timeHonorar, int antalTimer) {
        Job job = new Job(kode, beskrivelse, dato, timeHonorar, antalTimer);
        jobs.add(job);
        return job;
    }

    //-------------------------------------------------------------------------

    // S2 (5 p)
    public int budgetteretJobUdgift() {
        int samletUdgift = 0;
        for (Job job : jobs) {
            samletUdgift += job.getTimeHonorar() * job.getAntalTimer();
        }
        return samletUdgift;
    }

    //-------------------------------------------------------------------------

    // S3 (7 p)
    public int realiseretJobUdgift() {
        int samletUdgift = 0;
        for (Job job : jobs) {
            int antalTimerUdfoert = 0;
            for (Vagt vagt : job.getVagter()) {
                antalTimerUdfoert += vagt.getTimer();
            }
            samletUdgift += job.getTimeHonorar() * antalTimerUdfoert;
        }
        return samletUdgift;
    }

    //-------------------------------------------------------------------------

    // Del af S8 (13 p)
    public ArrayList<String> gaverTilFrivillige() {
        ArrayList<String> list = new ArrayList<>();
        for (Job job  : jobs) {
            for (Vagt vagt : job.getVagter()) {
                String s = vagt.getFrivillig().gaveBeskrivelse();
                list.add(s);
            }
        }
        Collections.sort(list);
        return list;
    }

    //-------------------------------------------------------------------------

    // til brug i gui
    @Override
    public String toString() {
        return navn + " " + fraDato + " " + tilDato;
    }
}
