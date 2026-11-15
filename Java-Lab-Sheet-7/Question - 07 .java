class Question07 extends Thread {
    public void run() {
        long sum = 0;
        for (int i = 1; i <= 10000; i++) {
            sum += i;
        }
        System.out.println("Sum: " + sum);
    }

    public static void main(String[] args) throws InterruptedException {
        Question07 t = new Question07();
        t.start();
        t.join();
        System.out.println("Task finished");
    }
}
