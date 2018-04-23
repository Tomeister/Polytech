package FourthLab;

public class FourthLab {

    public static void main(String[] args) {

        int[] inputArgs = new int[2];
        try {
            for (int i = 0; i < inputArgs.length; i++) {
                inputArgs[i] = Integer.parseInt(args[i]);
                if ( inputArgs[i]<0) {
                    System.out.println("ERROR - there was negative arg");
                    System.exit(1);
                }

                System.out.println("args [" + i + "] = " + inputArgs[i]);
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Incorrect args format");
            System.exit(1);
        }

        Stock stock = new Stock(inputArgs[0],inputArgs[1]);
        Producer producer = new Producer(stock);
        Boxer boxer = new Boxer(stock);
        new Thread(producer).start();
        new Thread(boxer).start();
    }
}

class Stock {
    int workers;
    int box;

    public Stock(int workers, int box) {
        this.workers = workers;
        this.box = box;
    }

    int getWorkers() {
        return workers;
    }

    int getBox() {
        return box;
    }

    public synchronized void put(int i) {
        System.out.println("Worker_" + i);
        notify();
        try {
            wait();
        }
        catch (InterruptedException e) {}
    }

    public synchronized void box(int i) {
        System.out.print("ящик №" + i + " собрал ");
        notify();
        try {
            wait();
        }
        catch (InterruptedException e) {}
    }

    public void helper (String message) {
        System.out.println(message);
    }

}

class Producer implements Runnable {
        Stock stock;

        Producer(Stock stock) {
            this.stock = stock;
        }

        @Override
        public void run() {
            stock.helper("Дополнительный работник сообщает, что ");
            while (stock.getWorkers() <= stock.getBox()) {
                for (int i = 1; i < stock.getWorkers() +1; i++) {
                    stock.put(i);
                }
            }
            while (stock.getWorkers() >= stock.getBox()) {
                for (int i = 1; i < stock.getWorkers() +1; i++) {
                    stock.put(i);
                }
            }
        }
    }

class Boxer implements Runnable {
    Stock stock;

    Boxer(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void run() {
        for (int i = 1; i < stock.getBox() +1; i++) {
            stock.box(i);
        }
    }
}


