package reader_writer;

class Writer extends Thread {
    private Database db;

    public Writer(Database db) {
        this.db = db;
    }

    @Override
    public void run() {
        while (true) {
            try {
                db.startWrite();
                Thread.sleep((int)(Math.random() * 1000));
                db.endWrite();
                Thread.sleep((int)(Math.random() * 1000));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
