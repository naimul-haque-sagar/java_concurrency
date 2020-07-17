package example.thread_data_synchronization;

//multiple thread working with multiple object of same class needs static synchronization
class Food{
    public static synchronized void orderFood(String name){
        System.out.println("Food name is "+name);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class FoodOrder extends Thread{
    Food food;
    String name;

    FoodOrder(Food food,String name){
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

public class Static_Synchronized {
    public static void main(String[] args) {
        Food food=new Food();
        Food food1=new Food();
        FoodOrder foodOrder=new FoodOrder(food,"apple");
        FoodOrder foodOrder1=new FoodOrder(food1,"mango");
        foodOrder.start();
        foodOrder1.start();
    }
}