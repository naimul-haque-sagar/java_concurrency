package example.thread_data_synchronization;

public class Synchronized_Example1 {
    public static void main(String[] args) {
        Food1 food1=new Food1();
        FoodOrder1 foodOrder1=new FoodOrder1(food1,"apple");
        FoodOrder1 foodOrder2=new FoodOrder1(food1,"mango");
        foodOrder1.start();
        foodOrder2.start();
    }
}

class Food1{
    public synchronized void orderFood(String name){
        System.out.println("Food name is "+name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }

    public synchronized void receivedFood(String name){
        System.out.println("Received food "+name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new AssertionError(e);
        }
    }
}

class FoodOrder1 extends Thread{
    Food1 food1;
    String name;

    FoodOrder1(Food1 food,String name){
        this.food1=food;
        this.name=name;
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            food1.orderFood(name);
        }
    }
}

class FoodOrderReceived extends Thread{
    Food1 food1;
    String name;

    FoodOrderReceived(Food1 food, String name){
        this.food1=food;
        this.name=name;
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            food1.receivedFood(name);
        }
    }
}