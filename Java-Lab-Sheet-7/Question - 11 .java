class Question11 {
    static class BankAccount {
        private int balance = 2000;

        synchronized void withdraw(int amount) {
            if (balance >= amount) {
                balance -= amount;
            }
        }

        int getBalance() {
            return balance;
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
