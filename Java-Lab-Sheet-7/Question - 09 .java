class Question09 {
    public static void main(String[] args) {
        int[] priorities = {1, 3, 5, 7, 10};

        for (int i = 0; i < priorities.length; i++) {
            final int number = i + 1;
            Thread t = new Thread(() -> {
                for (int j = 1; j <= 5; j++) {
                    System.out.println(Thread.currentThread().getName()
                            + " - Print " + j);
                }
            }, "Thread-" + number);

            t.setPriority(priorities[i]);
            System.out.println(t.getName() + " priority: " + t.getPriority());
            t.start();
        }
    }
}
