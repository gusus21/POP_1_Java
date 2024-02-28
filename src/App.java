import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        int threadAnount = 5;
        Random ran = new Random();
        List<IndexDurationPair> map = new ArrayList<IndexDurationPair>();

        BreakController brc = new BreakController(5);
        for(int i = 0;  i < threadAnount; i++){
            int step = ran.nextInt(1, 10);
            int duration = ran.nextInt(1, 5);
            map.add(new IndexDurationPair(i, duration));
            new WorkingThread(i, step, brc).start();
        }

        List<IndexDurationPair> sorted = sortThreads(map);
        brc.SetThreads(sorted);
        new Thread(brc).start();;
    }

    public static List<IndexDurationPair> sortThreads(List<IndexDurationPair> idp){
        Collections.sort(idp, new Comparator<IndexDurationPair>() {
            public int compare(IndexDurationPair idp1, IndexDurationPair idp2){
                return idp1.compareTo(idp2);
            }
        });

        return idp;
    }
}
