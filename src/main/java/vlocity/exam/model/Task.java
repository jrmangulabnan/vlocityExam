package vlocity.exam.model;

import java.util.List;

public class Task {
	private String name;
	private int manDays;
	private List<Task> task;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getManDays() {
		return manDays;
	}

	public void setManDays(int manDays) {
		this.manDays = manDays;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

}
