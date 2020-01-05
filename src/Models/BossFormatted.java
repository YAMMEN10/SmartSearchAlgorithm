package Models;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class BossFormatted {
    private HashMap<Integer, PriorityQueue<Boss>> boss_map_available_periods;
    private PriorityQueue<Boss> boss_map_not_have_available_periods;

    private HashMap<Integer, PriorityQueue<Boss>> boss_map_favorite_periods;
    private PriorityQueue<Boss> boss_map_not_have_favorite_periods;

    private HashMap<DayName, PriorityQueue<Boss>> boss_map_available_days;
    private PriorityQueue<Boss> boss_map_not_have_available_days;

    private HashMap<DayName, PriorityQueue<Boss>> boss_map_favorite_days;
    private PriorityQueue<Boss> boss_map_not_have_favorite_days;


    private Comparator<Boss> comparator = new Comparator<Boss>() {
        public int compare(Boss boss1, Boss boss2) {
            if (boss1.getCurrent_watching() < boss2.getCurrent_watching()) return -1;
            if (boss1.getCurrent_watching() > boss2.getCurrent_watching()) return 1;
            return 0;
        }
    };

    public BossFormatted() {
        boss_map_available_periods = new HashMap<>();
        boss_map_not_have_available_periods = new PriorityQueue<>();

        boss_map_available_days = new HashMap<>();
        boss_map_not_have_available_days = new PriorityQueue<>();

        boss_map_favorite_periods = new HashMap<>();
        boss_map_not_have_favorite_periods = new PriorityQueue<>();


        boss_map_favorite_days = new HashMap<>();
        boss_map_not_have_favorite_days = new PriorityQueue<>();
    }

    public void pushAllBoss(List<Boss> bosses) {
        for (Boss boss : bosses) {

            if (boss.getBasic_limitaction().getAvailable_period().size() > 0) {
                List<Integer> avaliable_period = boss.getBasic_limitaction().getAvailable_period();
                for (int i = 0; i < avaliable_period.size(); i++) {
                    if (!boss_map_available_periods.containsKey(avaliable_period.get(i))) {
                        boss_map_available_periods.put(avaliable_period.get(i), new PriorityQueue<>(comparator));
                    }
                    boss_map_available_periods.get(avaliable_period.get(i)).add(boss);
                }
            } else {
                this.boss_map_not_have_available_periods.add(boss);
            }
            if (boss.getBasic_limitaction().getAvailable_days().size() > 0) {
                List<DayName> avaliable_day = boss.getBasic_limitaction().getAvailable_days();
                for (int i = 0; i < avaliable_day.size(); i++) {
                    if (!boss_map_available_days.containsKey(avaliable_day.get(i))) {
                        boss_map_available_days.put(avaliable_day.get(i), new PriorityQueue<>(comparator));
                    }
                    boss_map_available_days.get(avaliable_day.get(i)).add(boss);
                }
            } else {
                this.boss_map_not_have_available_days.add(boss);
            }


            if (boss.getUn_basic_limitaction().getAvailable_period().size() > 0) {
                List<Integer> favorite_periods = boss.getUn_basic_limitaction().getAvailable_period();
                for (int i = 0; i < favorite_periods.size(); i++) {
                    if (!boss_map_favorite_periods.containsKey(favorite_periods.get(i))) {
                        boss_map_favorite_periods.put(favorite_periods.get(i), new PriorityQueue<>(comparator));
                    }
                    boss_map_favorite_periods.get(favorite_periods.get(i)).add(boss);
                }
            }else {
                this.boss_map_not_have_favorite_periods.add(boss);
            }


            if (boss.getUn_basic_limitaction().getAvailable_days().size() > 0) {

                List<DayName> favorite_day = boss.getUn_basic_limitaction().getAvailable_days();
                for (int i = 0; i < favorite_day.size(); i++) {
                    if (!boss_map_favorite_days.containsKey(favorite_day.get(i))) {
                        boss_map_favorite_days.put(favorite_day.get(i), new PriorityQueue<>(comparator));
                    }
                    boss_map_favorite_days.get(favorite_day.get(i)).add(boss);
                }

            }else {
                this.boss_map_not_have_favorite_days.add(boss);
            }


        }

    }


    public HashMap<Integer, PriorityQueue<Boss>> getBoss_map_available_periods() {
        return boss_map_available_periods;
    }

    public void setBoss_map_available_periods(HashMap<Integer, PriorityQueue<Boss>> boss_map_available_periods) {
        this.boss_map_available_periods = boss_map_available_periods;
    }

    public PriorityQueue<Boss> getBoss_map_not_have_available_periods() {
        return boss_map_not_have_available_periods;
    }

    public void setBoss_map_not_have_available_periods(PriorityQueue<Boss> boss_map_not_have_available_periods) {
        this.boss_map_not_have_available_periods = boss_map_not_have_available_periods;
    }

    public HashMap<Integer, PriorityQueue<Boss>> getBoss_map_favorite_periods() {
        return boss_map_favorite_periods;
    }

    public void setBoss_map_favorite_periods(HashMap<Integer, PriorityQueue<Boss>> boss_map_favorite_periods) {
        this.boss_map_favorite_periods = boss_map_favorite_periods;
    }

    public PriorityQueue<Boss> getBoss_map_not_have_favorite_periods() {
        return boss_map_not_have_favorite_periods;
    }

    public void setBoss_map_not_have_favorite_periods(PriorityQueue<Boss> boss_map_not_have_favorite_periods) {
        this.boss_map_not_have_favorite_periods = boss_map_not_have_favorite_periods;
    }

    public HashMap<DayName, PriorityQueue<Boss>> getBoss_map_available_days() {
        return boss_map_available_days;
    }

    public void setBoss_map_available_days(HashMap<DayName, PriorityQueue<Boss>> boss_map_available_days) {
        this.boss_map_available_days = boss_map_available_days;
    }

    public PriorityQueue<Boss> getBoss_map_not_have_available_days() {
        return boss_map_not_have_available_days;
    }

    public void setBoss_map_not_have_available_days(PriorityQueue<Boss> boss_map_not_have_available_days) {
        this.boss_map_not_have_available_days = boss_map_not_have_available_days;
    }

    public HashMap<DayName, PriorityQueue<Boss>> getBoss_map_favorite_days() {
        return boss_map_favorite_days;
    }

    public void setBoss_map_favorite_days(HashMap<DayName, PriorityQueue<Boss>> boss_map_favorite_days) {
        this.boss_map_favorite_days = boss_map_favorite_days;
    }

    public PriorityQueue<Boss> getBoss_map_not_have_favorite_days() {
        return boss_map_not_have_favorite_days;
    }

    public void setBoss_map_not_have_favorite_days(PriorityQueue<Boss> boss_map_not_have_favorite_days) {
        this.boss_map_not_have_favorite_days = boss_map_not_have_favorite_days;
    }
}
