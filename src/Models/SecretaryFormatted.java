package Models;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class SecretaryFormatted {
    private HashMap<DayName, PriorityQueue<Secretary>> day_secretary;
    private HashMap<Integer, PriorityQueue<Secretary>> period_secretary;
    private HashMap<DayName, PriorityQueue<Secretary>> day_favorite_secretary;
    private HashMap<Integer, PriorityQueue<Secretary>> period_favorite_secretary;
    private Comparator<Secretary> comparator = new Comparator<Secretary>() {
        public int compare(Secretary secretary1, Secretary secretary2) {
            if (secretary1.getCurrent_watching() < secretary2.getCurrent_watching()) return -1;
            if (secretary1.getCurrent_watching() > secretary2.getCurrent_watching()) return 1;
            return 0;
        }
    };

    public SecretaryFormatted() {
        this.day_secretary = new HashMap<>();
        this.period_secretary = new HashMap<>();
        this.day_favorite_secretary = new HashMap<>();
        this.period_favorite_secretary = new HashMap<>();
    }

    public void pushAllSecretary(List<Secretary> all_secretary) {
        for (int i = 0; i < all_secretary.size(); i++) {
            Limitation basic_liitation = all_secretary.get(i).getBasic_limitaction();
            Limitation favorite_liitation = all_secretary.get(i).getUn_basic_limitaction();
            if (basic_liitation != null) {
                if (basic_liitation.getAvailable_days() != null) {
                    for (int j = 0; j < basic_liitation.getAvailable_days().size(); j++) {

                        if (this.day_secretary.get(basic_liitation.getAvailable_days().get(j)) == null) {
                            this.day_secretary.put(basic_liitation.getAvailable_days().get(j), new PriorityQueue<Secretary>(10, comparator));
                        }
                            this.day_secretary.get(basic_liitation.getAvailable_days().get(j)).add(all_secretary.get(i));

                    }
                }
                if (basic_liitation.getAvailable_period() != null) {
                    for (int j = 0; j < basic_liitation.getAvailable_period().size(); j++) {
                        if (this.period_secretary.get(basic_liitation.getAvailable_period().get(j)) == null) {
                            this.period_secretary.put(basic_liitation.getAvailable_period().get(j), new PriorityQueue<>(comparator));
                        }
                            this.period_secretary.get(basic_liitation.getAvailable_period().get(j)).add(all_secretary.get(i));

                    }
                }
            }

            if (favorite_liitation != null) {
                if (favorite_liitation.getAvailable_days() != null) {
                    for (int j = 0; j < favorite_liitation.getAvailable_days().size(); j++) {
                        if (this.day_favorite_secretary.get(favorite_liitation.getAvailable_days().get(j)) == null) {
                            this.day_favorite_secretary.put(favorite_liitation.getAvailable_days().get(j), new PriorityQueue<Secretary>(comparator));
                        }
                            this.day_favorite_secretary.get(favorite_liitation.getAvailable_days().get(j)).add(all_secretary.get(i));

                    }
                }
                if (favorite_liitation.getAvailable_period() != null) {
                    for (int j = 0; j < favorite_liitation.getAvailable_period().size(); j++) {
                        if (this.period_favorite_secretary.get(favorite_liitation.getAvailable_period().get(j)) == null) {
                            this.period_favorite_secretary.put(favorite_liitation.getAvailable_period().get(j), new PriorityQueue<Secretary>(comparator));
                        }
                            this.period_favorite_secretary.get(favorite_liitation.getAvailable_period().get(j)).add(all_secretary.get(i));

                    }
                }
            }

        }
        System.out.println("Finished");

    }

    public HashMap<DayName, PriorityQueue<Secretary>> getDay_secretary() {
        return day_secretary;
    }

    public void setDay_secretary(HashMap<DayName, PriorityQueue<Secretary>> day_secretary) {
        this.day_secretary = day_secretary;
    }

    public HashMap<Integer, PriorityQueue<Secretary>> getPeriod_secretary() {
        return period_secretary;
    }

    public void setPeriod_secretary(HashMap<Integer, PriorityQueue<Secretary>> period_secretary) {
        this.period_secretary = period_secretary;
    }

    public HashMap<DayName, PriorityQueue<Secretary>> getDay_favorite_secretary() {
        return day_favorite_secretary;
    }

    public void setDay_favorite_secretary(HashMap<DayName, PriorityQueue<Secretary>> day_favorite_secretary) {
        this.day_favorite_secretary = day_favorite_secretary;
    }

    public HashMap<Integer, PriorityQueue<Secretary>> getPeriod_favorite_secretary() {
        return period_favorite_secretary;
    }

    public void setPeriod_favorite_secretary(HashMap<Integer, PriorityQueue<Secretary>> period_favorite_secretary) {
        this.period_favorite_secretary = period_favorite_secretary;
    }
}
