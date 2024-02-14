package reader_writer;

class Reader extends Thread {
    private Database db;
    private Thread thread;

    public Reader(Database db, String name) {

        this.db = db;
        thread = new Thread(this, name);
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

    public Thread getThread() {
        return thread;
    }
}
