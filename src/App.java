public class App {
    public static void main(String[] args) throws Exception {
        int threadAnount = 5;
        BreakController breakController = new BreakController(4);
        for(int i = 0;  i < threadAnount; i++){
            new WorkingThread(i, breakController, 1).start();
        }
        new Thread(breakController).start();
    }
}
