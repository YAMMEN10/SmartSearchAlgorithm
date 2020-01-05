package Models.Master_Student_Classes;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MasterStudentFormatted {
    private PriorityQueue<MasterStudent> master_student_priority_queue;

    public MasterStudentFormatted() {
        Comparator<MasterStudent> comparator = new Comparator<MasterStudent>() {
            public int compare(MasterStudent master_student1, MasterStudent master_student2) {
                if (master_student1.getCurrent_watching() > master_student2.getCurrent_watching()) return 1;
                else if (master_student1.getCurrent_watching() < master_student2.getCurrent_watching()) return -1;
                else return 0;
            }
        };

        this.master_student_priority_queue = new PriorityQueue<MasterStudent>(comparator);
    }

    public MasterStudentFormatted pushAllMasterStudent(List<MasterStudent> all_master_student) {
        master_student_priority_queue.addAll(all_master_student);
        return this;
    }

    public PriorityQueue<MasterStudent> getMaster_student_priority_queue() {
        return master_student_priority_queue;
    }

    public void setMaster_student_priority_queue(PriorityQueue<MasterStudent> master_student_priority_queue) {
        this.master_student_priority_queue = master_student_priority_queue;
    }
}
