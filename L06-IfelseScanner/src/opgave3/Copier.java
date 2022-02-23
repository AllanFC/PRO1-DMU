package opgave3;

public class Copier {
    private int paperCount;
    private boolean paperJam;

    public Copier(){
        paperCount = 0;
    }

    public Copier(int paperCount){
        this.paperCount = paperCount;
    }

    public int getPaperCount() {
        return paperCount;
    }

    public void insertPaper(int amount){
        if(paperCount + amount <= 500) {
            paperCount = amount;
        } else {
            System.out.println("ERROR: Too much paper inserted! Papertray can only contain 500 pieces");
        }
    }

    public void makeCopy(){
        if(paperCount > 0 && !paperJam){
            paperCount -= 1;
        } else if(paperCount <= 0){
            System.out.println("ERROR: Papertray is empty! Insert paper");
        } else {
            System.out.println("ERROR: Paperjam! please resolve to use copier");
        }
    }

    public void makePaperJam(){
        paperJam = true;
    }

    public void fixJam(){
        paperJam = false;
        System.out.println("Copier is now working again");
    }
}
