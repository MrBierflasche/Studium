package rl.ui;

public class CountDownDemo {

    public void countDown() {
        for (int i = 10; i >= 0; i--) {
            if (i > 0) {
                try{
                    System.out.println(i);
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    throw new RuntimeException(e);
                }

            }
            else {
                System.out.println("go");
            }
        }
    }

    static void main() throws InterruptedException {
        CountDownDemo demo = new CountDownDemo();
        Thread thread = new Thread(demo::countDown);
        //thread.setDaemon(true);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();

        System.out.println("Ende");
    }
}
