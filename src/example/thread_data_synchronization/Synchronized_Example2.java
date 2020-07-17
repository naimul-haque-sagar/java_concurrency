package example.thread_data_synchronization;

public class Synchronized_Example2 {
    public static void main(String[] args) {
        Food2 food1=new Food2();
        Food2 food2=new Food2();
        Food2 food3=new Food2();

        FoodOrder3 foodOrder1=new FoodOrder3(food1,"apple");
        FoodOrder3 foodOrder2=new FoodOrder3(food1,"mango");

        FoodOrder3 foodOrder3=new FoodOrder3(food2,"*");
        FoodOrder3 foodOrder4=new FoodOrder3(food3,"#");

        FoodReceived foodReceived=new FoodReceived(food3,"&");

        foodOrder1.start();
        foodOrder2.start();

        foodOrder3.start();
        foodOrder4.start();

        foodReceived.start();
    }
}

class Food2{
    public static synchronized void orderFood(String name){
        System.out.println("Food name is "+name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void receivedFood(String name){
        System.out.println("Received food "+name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class FoodOrder3 extends Thread{
    Food2 food;
    String name;

    FoodOrder3(Food2 food,String name){
        this.food=food;
        this.name=name;
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            food.orderFood(name);
        }
    }
}

class FoodReceived extends Thread{
    Food2 food;
    String name;

    FoodReceived(Food2 food, String name){
        this.food=food;
        this.name=name;
    }

    @Override
    public void run() {
        for (int i=0;i<5;i++){
            food.receivedFood(name);
        }
    }
}