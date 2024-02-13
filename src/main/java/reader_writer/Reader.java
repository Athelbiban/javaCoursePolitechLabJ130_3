package reader_writer;

class Reader extends Thread {
    private Database db;

    public Reader(Database db) {
        this.db = db;
    }

    @Override
    public void run() {
        while (true) {
            try {
                db.startRead();
                Thread.sleep((int)(Math.random() * 1000));
                db.endRead();
                Thread.sleep((int)(Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
