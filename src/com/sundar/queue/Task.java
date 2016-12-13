package com.sundar.queue;

class Task {
	
	String job;
    int priority;
 
    /** Constructor **/
    public Task(String job, int priority)
    {
        this.job = job;
        this.priority = priority; 
    }
    /** toString() **/
    public String toString() 
    {
        return "Job Name : "+ job +"\nPriority : "+ priority;
    }
}
