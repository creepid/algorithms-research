/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.application;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author rusakovich
 */
public class TasksLoadBalanceTest {

    public TasksLoadBalanceTest() {
    }

    @Test
    public void testSomeMethod() {
        int processorsCount = 3;

        Task[] tasks = new Task[5];
        tasks[0] = new Task("Open browser", 5000l);
        tasks[1] = new Task("Close explorer", 500l);
        tasks[2] = new Task("Go to dir", 850l);
        tasks[3] = new Task("Save file", 3000l);
        tasks[4] = new Task("Search the file", 23000l);

        TasksLoadBalance lb = new TasksLoadBalance(processorsCount, tasks);
        List<Task> executed = lb.getExecuted();

        Task[] expected = new Task[5];
        expected[0] = new Task("Close explorer", 500l);
        expected[1] = new Task("Go to dir", 850l);
        expected[2] = new Task("Save file", 3000l);
        expected[3] = new Task("Open browser", 5000l);
        expected[4] = new Task("Search the file", 23000l);

        Assert.assertArrayEquals(expected, executed.toArray(new Task[5]));
    }

}
