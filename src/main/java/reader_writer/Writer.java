package reader_writer;

class Writer extends Thread {
    private Database db;
    private Thread thread;

    public Writer(Database db, String name) {
        this.db = db;
        thread = new Thread(this, name);
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

    public Thread getThread() {
        return thread;
    }
}
