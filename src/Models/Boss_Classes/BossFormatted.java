package Models.Boss_Classes;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class BossFormatted {


    private PriorityQueue<Boss> boss_priority_queue;


    public BossFormatted() {
        Comparator<Boss> comparator = new Comparator<Boss>() {
            public int compare(Boss boss1, Boss boss2) {
                if (boss1.getCurrent_watching() > boss2.getCurrent_watching()) return 1;
                else if (boss1.getCurrent_watching() < boss2.getCurrent_watching()) return -1;
                else return 0;
            }
        };
        this.boss_priority_queue = new PriorityQueue<>(comparator);
    }

    public BossFormatted pushAllBoss(List<Boss> all_bosses) {
        boss_priority_queue.addAll(all_bosses);
        return this;
    }

    public PriorityQueue<Boss> getBoss_priority_queue() {
        return boss_priority_queue;
    }

    public void setBoss_priority_queue(PriorityQueue<Boss> boss_priority_queue) {
        this.boss_priority_queue = boss_priority_queue;
    }
}
