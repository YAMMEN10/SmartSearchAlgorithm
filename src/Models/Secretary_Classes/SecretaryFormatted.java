package Models.Secretary_Classes;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SecretaryFormatted {
    private PriorityQueue<Secretary> secretary_priority_queue;

    public SecretaryFormatted() {
        Comparator<Secretary> comparator = new Comparator<Secretary>() {
            public int compare(Secretary secretary1, Secretary secretary2) {
                if (secretary1.getCurrent_watching() > secretary2.getCurrent_watching()) return 1;
                else if (secretary1.getCurrent_watching() < secretary2.getCurrent_watching()) return -1;
                else return 0;
            }
        };
        this.secretary_priority_queue = new PriorityQueue<Secretary>(comparator);
    }

    public SecretaryFormatted pushAllSecretary(List<Secretary> all_secretaries) {
        this.secretary_priority_queue.addAll(all_secretaries);
        return this;
    }

    public PriorityQueue<Secretary> getSecretary_priority_queue() {
        return secretary_priority_queue;
    }

    public void setSecretary_priority_queue(PriorityQueue<Secretary> secretary_priority_queue) {
        this.secretary_priority_queue = secretary_priority_queue;
    }
}
