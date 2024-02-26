public class WorkingThread extends Thread{
    private  int id;
    private int step;
    private final BreakController breakController;

    public WorkingThread(int id, BreakController controller, int step){
        this.id = id;
        breakController = controller;
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
            canStop = breakController.GetStopStatus();
        }while(!canStop);
        
        System.out.println(id + " - " + sum);
    }
}