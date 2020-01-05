package Models;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class MasterStudentFormated {
    private HashMap<DayName, PriorityQueue<MasterStudent>> day_secretary;
    private HashMap<Integer, PriorityQueue<MasterStudent>> period_secretary;
    private HashMap<DayName, PriorityQueue<MasterStudent>> day_favorite_secretary;
    private HashMap<Integer, PriorityQueue<MasterStudent>> period_favorite_secretary;
    private Comparator<MasterStudent> comparator = new Comparator<MasterStudent>() {
        public int compare(MasterStudent master_student1, MasterStudent master_student2) {
            if (master_student1.getCurrent_watching() < master_student2.getCurrent_watching()) return -1;
            if (master_student1.getCurrent_watching() > master_student2.getCurrent_watching()) return 1;
            return 0;
        }
    };

    public MasterStudentFormated() {
        this.day_secretary = new HashMap<>();
        this.period_secretary = new HashMap<>();
        this.day_favorite_secretary = new HashMap<>();
        this.period_favorite_secretary = new HashMap<>();
    }

    public void pushAllMasterStudent(List<MasterStudent> all_master_student) {
        for (int i = 0; i < all_master_student.size(); i++) {
            Limitation basic_limitation = all_master_student.get(i).getBasic_limitaction();
            Limitation favorite_limitation = all_master_student.get(i).getUn_basic_limitaction();
            if (basic_limitation != null) {
                if (basic_limitation.getAvailable_days() != null) {
                    for (int j = 0; j < basic_limitation.getAvailable_days().size(); j++) {

                        if (this.day_secretary.get(basic_limitation.getAvailable_days().get(j)) == null) {
                            this.day_secretary.put(basic_limitation.getAvailable_days().get(j), new PriorityQueue<MasterStudent>(10, comparator));
                        }
                        this.day_secretary.get(basic_limitation.getAvailable_days().get(j)).add(all_master_student.get(i));

                    }
                }
                if (basic_limitation.getAvailable_period() != null) {
                    for (int j = 0; j < basic_limitation.getAvailable_period().size(); j++) {
                        if (this.period_secretary.get(basic_limitation.getAvailable_period().get(j)) == null) {
                            this.period_secretary.put(basic_limitation.getAvailable_period().get(j), new PriorityQueue<>(comparator));
                        }
                        this.period_secretary.get(basic_limitation.getAvailable_period().get(j)).add(all_master_student.get(i));

                    }
                }
            }

            if (favorite_limitation != null) {
                if (favorite_limitation.getAvailable_days() != null) {
                    for (int j = 0; j < favorite_limitation.getAvailable_days().size(); j++) {
                        if (this.day_favorite_secretary.get(favorite_limitation.getAvailable_days().get(j)) == null) {
                            this.day_favorite_secretary.put(favorite_limitation.getAvailable_days().get(j), new PriorityQueue<MasterStudent>(comparator));
                        }
                        this.day_favorite_secretary.get(favorite_limitation.getAvailable_days().get(j)).add(all_master_student.get(i));

                    }
                }
                if (favorite_limitation.getAvailable_period() != null) {
                    for (int j = 0; j < favorite_limitation.getAvailable_period().size(); j++) {
                        if (this.period_favorite_secretary.get(favorite_limitation.getAvailable_period().get(j)) == null) {
                            this.period_favorite_secretary.put(favorite_limitation.getAvailable_period().get(j), new PriorityQueue<MasterStudent>(comparator));
                        }
                        this.period_favorite_secretary.get(favorite_limitation.getAvailable_period().get(j)).add(all_master_student.get(i));

                    }
                }
            }

        }
        System.out.println("Finished");

    }

    public HashMap<DayName, PriorityQueue<MasterStudent>> getDay_secretary() {
        return day_secretary;
    }

    public void setDay_secretary(HashMap<DayName, PriorityQueue<MasterStudent>> day_secretary) {
        this.day_secretary = day_secretary;
    }

    public HashMap<Integer, PriorityQueue<MasterStudent>> getPeriod_secretary() {
        return period_secretary;
    }

    public void setPeriod_secretary(HashMap<Integer, PriorityQueue<MasterStudent>> period_secretary) {
        this.period_secretary = period_secretary;
    }

    public HashMap<DayName, PriorityQueue<MasterStudent>> getDay_favorite_secretary() {
        return day_favorite_secretary;
    }

    public void setDay_favorite_secretary(HashMap<DayName, PriorityQueue<MasterStudent>> day_favorite_secretary) {
        this.day_favorite_secretary = day_favorite_secretary;
    }

    public HashMap<Integer, PriorityQueue<MasterStudent>> getPeriod_favorite_secretary() {
        return period_favorite_secretary;
    }

    public void setPeriod_favorite_secretary(HashMap<Integer, PriorityQueue<MasterStudent>> period_favorite_secretary) {
        this.period_favorite_secretary = period_favorite_secretary;
    }
}
