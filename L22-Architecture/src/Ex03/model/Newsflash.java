package Ex03.model;

public class Newsflash {
    private String header;
    private String content;
    private int version;

    public Newsflash(String header, String content){
        this.header = header;
        this.content = content;
        version = 1;
    }

    public int getVersion() {
        return version;
    }

    public String getContent() {
        return content;
    }

    public String getHeader() {
        return header;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void updateVersion() {
        this.version++;
    }

    @Override
    public String toString() {
        return header + ". v. " + version;
    }
}
