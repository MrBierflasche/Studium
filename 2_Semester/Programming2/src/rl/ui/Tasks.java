package rl.ui;

public class Tasks {
    public static Thread startInBackground(Runnable Task){
        Thread t = new CancelableThread(Task);
        t.start();
        return t;
    }

    public static void setCancelled(){
        if (Thread.currentThread() instanceof CancelableThread ct){
            ct.setCancelled(true);
        }
    }
}
