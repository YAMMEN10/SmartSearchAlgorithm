package Models;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class BossFormatted {



    private PriorityQueue<Boss> boss_queue;


    private Comparator<Boss> comparator = new Comparator<Boss>() {
        public int compare(Boss boss1, Boss boss2) {
            if (boss1.getCurrent_watching() < boss2.getCurrent_watching()) return -1;
            if (boss1.getCurrent_watching() > boss2.getCurrent_watching()) return 1;
            return 0;
        }
    };

    public BossFormatted() {

        boss_queue = new PriorityQueue<>(comparator);
    }

    public void pushAllBoss(List<Boss> bosses) {
        boss_queue.addAll(bosses);
        System.out.println();
    }

    public PriorityQueue<Boss> getBoss_queue() {
        return boss_queue;
    }

    public void setBoss_queue(PriorityQueue<Boss> boss_queue) {
        this.boss_queue = boss_queue;
    }
}
