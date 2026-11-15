class Question01 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Your Name");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
                return;
            }
        }
    }

    public static void main(String[] args) {
        Question01 t = new Question01();
        t.start();
    }
}
