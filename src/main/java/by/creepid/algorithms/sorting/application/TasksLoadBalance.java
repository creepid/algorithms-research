/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.application;

import by.creepid.algorithms.sorting.fast.QuickSorting;
import by.creepid.algorithms.sorting.priority.IndexedPriorityQueue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author rusakovich
 */
public class TasksLoadBalance {

    private int processorsCount;
    private Task[] tasks;
    private List<Task> executed = Collections.EMPTY_LIST;

    public TasksLoadBalance(int processorsCount, Task[] tasks) {
        this.processorsCount = processorsCount;
        this.tasks = tasks;
        sort();
        executeTasks();
    }

    private void sort() {
        QuickSorting.sort(tasks);
    }

    private void executeTasks() {
        List<Task> tasksList = new ArrayList<Task>(Arrays.asList(tasks));
        Iterator<Task> taskIterator = tasksList.iterator();

        IndexedPriorityQueue<Task> pq = new IndexedPriorityQueue<>(processorsCount);

        for (int i = 0; i < processorsCount; i++) {
            pq.insert(i, taskIterator.next());
        }

        executed = new ArrayList<>();
        while (!pq.isEmpty()) {
            executed.add(pq.min());
            int i = pq.deleteMin();
            if (taskIterator.hasNext()) {
                pq.insert(i, taskIterator.next());
            }
        }

    }

    public List<Task> getExecuted() {
        return executed;
    }

}
