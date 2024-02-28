import java.util.ArrayList;
import java.util.List;

public class BreakController implements Runnable {
    private int secondsToStop;
    private List<IndexDurationPair> threads;
    int idOfStoppedThread = -1;

    public void SetThreads(List<IndexDurationPair> thr){
        threads = thr;
    }

    public BreakController(int secondsToStop){
        this.secondsToStop = secondsToStop;
        threads = new ArrayList<>();
    }

    public synchronized int GetStopStatus(){
        return idOfStoppedThread;
    }

    public synchronized void SetDuration(int duration){
        secondsToStop = duration;
    }

    public synchronized int GetDuration(){
        return secondsToStop;
    }

    @Override
    public void run() {
        int tempDuration = threads.get(0).GetDuration();
        try{      
            for(int i = 0; i < threads.size();i++){
                Thread.sleep(tempDuration*1000);
                idOfStoppedThread = threads.get(i).GetId();
                if(i > 0)
                    tempDuration = threads.get(i).GetDuration() - threads.get(i-1).GetDuration();
                Thread.sleep(500);
            }      
            
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        
    }
}
