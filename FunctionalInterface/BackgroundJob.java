public class BackgroundJob {
    public static void main(String[] args) throws InterruptedException {
        Runnable job = () -> {
            try { Thread.sleep(300); System.out.println("Background job done"); }
            catch (InterruptedException e) { Thread.currentThread().interrupt(); }
        };
        Thread t = new Thread(job);
        t.start();
        t.join(); // wait for demo purposes
    }
}
