class Question06 extends Thread {
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Working... " + i);
                Thread.sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Question06 t = new Question06();

        System.out.println("Before start: " + t.isAlive());
        t.start();
        System.out.println("While running: " + t.isAlive());

        t.join();
        System.out.println("After finish: " + t.isAlive());
    }
}
