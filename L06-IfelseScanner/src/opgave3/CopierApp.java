package opgave3;

public class CopierApp {
    public static void main(String[] args) {
        Copier copy = new Copier();

        copy.insertPaper(1);
        System.out.println(copy.getPaperCount());
        copy.makePaperJam();
        copy.makeCopy();
        copy.fixJam();
        copy.makeCopy();
        copy.makeCopy();
        copy.insertPaper(501);
        System.out.println(copy.getPaperCount());
    }
}
