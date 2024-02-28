public class WorkingThread extends Thread{
    private  int id;
    private int step;
    private final BreakController breakController;
    private long count = 0;
    

    public WorkingThread(int id, int step, BreakController breakController){
        this.id = id;
        this.breakController = breakController;
        this.step = step;
    }

    @Override
    public void run() {

        int i = 0;
        long sum = 0;
        boolean canStop = false;

        do{
            sum += i;
            i += step;
            canStop = breakController.GetStopStatus() == id;
            count++;
        }while(!canStop);
        
        System.out.printf("%d - %d, count: %d\n", id, sum, count);
    }
}