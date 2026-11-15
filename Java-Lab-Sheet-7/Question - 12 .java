class Question12 {
    static class BankAccount {
        private int balance = 2000;
        private final Object lock = new Object();

        void withdraw(int amount) {
            synchronized (lock) {
                if (balance >= amount) {
                    balance -= amount;
                }
            }
        }

        int getBalance() {
            synchronized (lock) {
                return balance;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) account.withdraw(1);
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) account.withdraw(1);
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Final balance: " + account.getBalance());
    }
}
