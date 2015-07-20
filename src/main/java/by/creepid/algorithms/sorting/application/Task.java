/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.creepid.algorithms.sorting.application;

import java.io.Serializable;

/**
 *
 * @author rusakovich
 */
public class Task implements Serializable, Comparable<Task> {

    private String name;
    private long executionTimeInMillis;

    public Task() {
    }

    public Task(String name, long executionTimeInMillis) {
        this.name = name;
        this.executionTimeInMillis = executionTimeInMillis;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getExecutionTimeInMillis() {
        return executionTimeInMillis;
    }

    public void setExecutionTimeInMillis(long executionTimeInMillis) {
        this.executionTimeInMillis = executionTimeInMillis;
    }

    @Override
    public int compareTo(Task other) {
        long otherTime = other.executionTimeInMillis;
        return (int) (this.executionTimeInMillis - otherTime);
    }

    @Override
    public String toString() {
        return name + ": " + executionTimeInMillis + " milliseconds";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (!(o instanceof Task)) {
            return false;
        }

        Task other = (Task) o;
        if (this.executionTimeInMillis != other.executionTimeInMillis) {
            return false;
        }

        return this.name.equals(other.name);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (executionTimeInMillis + 0);
        result = prime * result + name.hashCode();
        return result;
    }

}
