package reader_writer;

public class MainClass {
    public static void main(String[] args) {
        Database db = new Database();
        new Reader(db).start();
        new Reader(db).start();
        new Reader(db).start();
        new Writer(db).start();
    }
}
