package example;

public class Join_Method {
    public static void main(String[] args) throws InterruptedException {
        DownloadThread downloadThread=new DownloadThread();
        DownloadThread downloadThread1=new DownloadThread();
        LoadingThread loadingThread=new LoadingThread();
        loadingThread.start();
        downloadThread.start();
        downloadThread1.start();

        downloadThread.join();
        downloadThread1.join();
        loadingThread.terminate();
        System.out.println("Process finished");
    }
}
class LoadingThread extends Thread{
    private volatile boolean live=true;
    @Override
    public void run() {
        while(live){
            System.out.println("downloading.....");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void terminate(){
        this.live=false;
    }
}

class DownloadThread extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Downloaded one file");
    }
}