import java.util.Random;

public class ConsumerAndProducer {
    public static void main(String[] args) {
        Stock stock = new Stock();
        Producer producer = new Producer(stock);
        Consumer consumer = new Consumer(stock);
          new Thread(producer).start();
          new Thread(consumer).start();
    }

}

class Producer implements Runnable {
    Stock stock;
    Producer(Stock stock){
        this.stock=stock;
    }

    Random random = new Random(47);

    @Override
    public void run(){
        for (int i = 1; i < 100; i++) {

            stock.put(random.nextInt(100));
        }
    }
}

class Consumer implements Runnable {
    Stock stock;
    Consumer(Stock stock){
        this.stock=stock;
    }
    Random random = new Random(47);

    @Override
    public void run(){
        for (int i = 1; i < 100; i++) {
            stock.get(random.nextInt(100));
        }
    }
}

class Stock {
    private int product=0;

    public synchronized void get(int random) {
        while (product<1) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println("Покупатель купил товар " + random );
        notify();
    }

    public synchronized void put(int random) {
        while (product>=1) {
            try {
                wait();
            }
            catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println("Производитель добавил товар " + random);
        System.out.println("Товаров на складе: " + product);
        notify();
    }
}