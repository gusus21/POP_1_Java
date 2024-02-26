public class BreakController implements Runnable {

    private boolean canStop = false;
    private int secondsToStop;

    public BreakController(int secondsToStop){
        this.secondsToStop = secondsToStop;
    }

    public synchronized boolean GetStopStatus(){
        return canStop;
    }

    @Override
    public void run() {
        try{
            Thread.sleep(secondsToStop*1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        canStop = true;
    }
}
