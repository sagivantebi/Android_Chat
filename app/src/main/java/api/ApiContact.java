package api;

public class ApiContact {
    public String id;
    public String name;
    public String server;
    public String last;
    public String lastdate;

    public ApiContact(String id, String name, String server, String last, String lastdate) {
        this.id = id;
        this.name = name;
        this.server = server;
        this.last = last;
        this.lastdate = lastdate;
    }
}
