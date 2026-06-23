package rl.ui;

public class CancelableThread extends Thread {
    private boolean cancelled = false;


    public CancelableThread(Runnable r) {
        super(r);
    }
    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
