package reader_writer;

public class MainClass {

    public static void main(String[] args) {

        Database db = new Database();

        for (int i = 0; i < 3; i++) {
            Reader reader = new Reader(db, "Читатель_" + i);
            reader.getThread().start();
        }

        for (int i = 0; i < 3; i++) {
            Writer consumer = new Writer(db, "Писатель_" + i);
            consumer.getThread().start();
        }
    }
}
