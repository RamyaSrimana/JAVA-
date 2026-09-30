package thread;

class Table implements Runnable {
    private int number;
    Table(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }
}

public class MultiplicationTable {
    public static void main(String[] args) {
    	Table table = new Table(5);
        Thread t1 = new Thread(table);
        t1.start();
    }
}
