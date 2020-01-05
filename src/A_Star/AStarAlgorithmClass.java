package A_Star;

import Models.Boss_Classes.Boss;
import Models.Day_Classes.DayName;
import Models.Master_Student_Classes.MasterStudent;
import Models.Period_Classes.Period;
import Models.Period_Classes.PeriodInformation;
import Models.Rule_Classes.Rule;
import Models.Secretary_Classes.Secretary;
import Models.State_Classes.CurrentState;
import Models.Theater_Classes.Theater;
import Models.Theater_Classes.TheaterInformation;
import javafx.util.Pair;

import java.util.*;

public class AStarAlgorithmClass {
    private Rule rules;
    private List<List<MasterStudent>> master_students_require;


    public AStarAlgorithmClass(Rule rules) {
        this.rules = rules;
        this.master_students_require = new ArrayList<>();
    }

    public List<CurrentState> aStarSearch(CurrentState current_state) {
        PriorityQueue<CurrentState> priorityQueue = initPriorityQueue();
        HashSet<CurrentState> visited = new HashSet<>();

        priorityQueue.add(current_state);
        CurrentState pop_State = null;

        while (!priorityQueue.isEmpty()) {
            pop_State = priorityQueue.remove();

            if (!visited.contains(pop_State)) {
                visited.add(pop_State);

                // if last element in PQ reached
//                if (current.equals(endNode)) return reconstructPath(parentMap, startNode, endNode, 0);

                PriorityQueue<CurrentState> chile_state = getChildesState(pop_State);

//                for (MapNode neighbor : neighbors) {
//                    if (!visited.contains(neighbor)) {
//
//                        // calculate predicted distance to the end node
//                        double predictedDistance = neighbor.getLocation().distance(endNode.getLocation());
//
//                        // 1. calculate distance to neighbor. 2. calculate dist from start node
//                        double neighborDistance = current.calculateDistance(neighbor);
//                        double totalDistance = current.getDistanceToStart() + neighborDistance + predictedDistance;

                // check if distance smaller
//                        if (totalDistance < distances.get(neighbor)) {
//                            // update n's distance
//                            distances.put(neighbor, totalDistance);
//                            // used for PriorityQueue
//                            neighbor.setDistanceToStart(totalDistance);
//                            neighbor.setPredictedDistance(predictedDistance);
//                            // set parent
//                            parentMap.put(neighbor, current);
//                            // enqueue
//                            priorityQueue.add(neighbor);
//                        }
            }
//                }
//            }
        }
        return null;
    }

    private PriorityQueue<CurrentState> getChildesState(CurrentState pop_state) {
        for (int day = pop_state.getDay(); day < rules.getDays_information().size(); day++) {
            List<PeriodInformation> all_period_in_current_day = rules.getDays_information().get(day).getPeriod_information();
            for (int period = pop_state.getPeriod(); period < all_period_in_current_day.size(); period++) {
                PriorityQueue<Boss> temp_all_boss_priority_queue = copyQueueForPeriod(rules.getBoss_priority_queue());
                PriorityQueue<Secretary> temp_all_secretary_priority_queue = copyQueueForPeriod(rules.getSecretary_priority_queue());
                PriorityQueue<MasterStudent> temp_all_master_student_priority_queue = copyQueueForPeriod(rules.getMaster_student_priority_queue());
                List<Integer> copied_theater_in_current_state = new ArrayList<>();
                this.copyList(getTheaterSize(), copied_theater_in_current_state);
                List<Integer> all_theater_in_current_state = getBestTheaterForCurrentPeriod(pop_state.getDays().get(day).getPeriods().get(period),
                        copied_theater_in_current_state);
                for (int theater = 0; theater < all_theater_in_current_state.size(); theater++) {
                    getBosses(day, period, theater, pop_state, temp_all_boss_priority_queue, temp_all_secretary_priority_queue, rules.getMaster_students());
                }

            }
        }
        return null;
    }

    private void getBosses(int day, int period, int theater, CurrentState pop_state, PriorityQueue<Boss> temp_all_boss_priority_queue,
                           PriorityQueue<Secretary> temp_all_secretary_priority_queue, List<MasterStudent> temp_all_master_student_priority_queue) {
        for (int boss = 0; boss < temp_all_boss_priority_queue.size(); boss++) {
            Boss item_boss = temp_all_boss_priority_queue.peek();
            int max_watcher = 0;
            if (item_boss.getType().equals("Engineer")) {
                max_watcher = rules.getProfessor_watches() - pop_state.getAll_bosses().get(item_boss.getName());
            } else if (item_boss.getType().equals("Doctor")) {
                max_watcher = rules.getEngineer_watches() - pop_state.getAll_bosses().get(item_boss.getName());
            }
            if (max_watcher > 0) {
                if (!bossIfExist(day, period, item_boss, pop_state)) {
                    if (item_boss.getBasic_limitaction().getAvailable_days().size() == 0 ||
                            item_boss.getBasic_limitaction().getAvailable_days().contains(DayName.valueOf(pop_state.getDays().get(day).getDay_information().getDay_name()))) {
                        if (item_boss.getBasic_limitaction().getAvailable_period().size() == 0 ||
                                item_boss.getBasic_limitaction().getAvailable_period().contains(pop_state.getDays().get(day).getPeriods().get(period).getPeriod_information().getPeriod_number())) {
//                        System.out.println("Not Exist");
                            for (int secretary = 0; secretary < temp_all_secretary_priority_queue.size(); secretary++) {
                                Secretary item_secretary = temp_all_secretary_priority_queue.peek();
                                if (item_secretary.getBasic_limitaction().getAvailable_days().size() != 0 ||
                                        item_secretary.getBasic_limitaction().getAvailable_days().contains(DayName.valueOf(pop_state.getDays().get(day).getDay_information().getDay_name()))) {
                                    if (item_secretary.getBasic_limitaction().getAvailable_period().size() == 0 ||
                                            item_secretary.getBasic_limitaction().getAvailable_period().contains(pop_state.getDays().get(day).getPeriods().get(period).getPeriod_information().getPeriod_number())) {

                                        //testing
                                        MasterStudent[]a = new MasterStudent[3];
                                        a[0] = temp_all_master_student_priority_queue.get(0);
                                        a[1] = temp_all_master_student_priority_queue.get(1);
                                        a[2] = temp_all_master_student_priority_queue.get(1);
                                        combinations2(a, 2, 0, new MasterStudent[2]);

                                        //                            pop_state.getDays().get(day).getPeriods().get(period).getTheaters().add(new Theater());
                                        //                        pop_state.getDays().get(day).getPeriods().get(period).getTheaters().get(theater).setBoss_theater(item_boss);
                                        //                        pop_state.getAll_bosses().put(item_boss.getName(), pop_state.getAll_bosses().get(item_boss.getName()) + 1);
                                        //                        temp_all_priority_queue.remove(item_boss);
                                        //                        boss = -1;
                                        System.out.println("a");
                                    }
                                }
                            }


                        }
                    }
                }
            }
        }
    }


    void combinations2(MasterStudent[] arr, int len, int startPosition, MasterStudent[] result){
        if (len == 0){
            this.master_students_require.add(Arrays.asList(result));
            return;
        }
        for (int i = startPosition; i <= arr.length-len; i++){
            result[result.length - len] = arr[i];
            combinations2(arr, len-1, i+1, result);
        }
    }

    private Boolean bossIfExist(int day, int period, Boss boss, CurrentState pop_state) {
        List<Theater> all_theater = pop_state.getDays().get(day).getPeriods().get(period).getTheaters();
        for (int i = 0; i < all_theater.size(); i++) {
            if (all_theater.get(i).getBoss_theater().equals(boss)) return true;
        }
        return false;
    }

    private PriorityQueue<CurrentState> initPriorityQueue() {
        Comparator<CurrentState> comparator = new Comparator<CurrentState>() {
            public int compare(CurrentState current_state1, CurrentState current_state2) {
                if (current_state1.getWeight() < current_state2.getWeight()) return -1;
                if (current_state1.getWeight() > current_state2.getWeight()) return 1;
                return 0;
            }
        };
        return new PriorityQueue<CurrentState>(comparator);
    }

    private List<Integer> getBestTheaterForCurrentPeriod(Period period, List<Integer> theaters_size) {
        BinarySearch binarySearch = new BinarySearch();
        List<Integer> best_theaters = new ArrayList<>();
        int total_student = period.getPeriod_information().getTotal_student();
        while (total_student > 0) {
            Pair<Integer, Integer> pair = binarySearch.binarySearch(theaters_size, 0, theaters_size.size() - 1, total_student);
//            total_student -= pair.getValue();
            period.getPeriod_information().setTotal_student(total_student -= pair.getValue());
            best_theaters.add(pair.getKey());
            theaters_size.remove(pair.getValue());
        }
        return best_theaters;
    }

    private List<Integer> getTheaterSize() {
        List<Integer> theaterSize = new ArrayList<>();
        List<TheaterInformation> theaterInformations = rules.getTheaters();
        for (TheaterInformation theaterInformation : theaterInformations) {
            theaterSize.add(theaterInformation.getStudents_size());
        }
        return theaterSize;
    }

    public void copyList(List source, List destination) {
        destination.addAll(source);
    }

    public PriorityQueue copyQueueForPeriod(PriorityQueue priorityQueue) {
        return new PriorityQueue<>(priorityQueue);
    }

    public Rule getRules() {
        return rules;
    }

    public void setRules(Rule rules) {
        this.rules = rules;
    }


}
