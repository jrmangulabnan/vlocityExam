package vlocity.exam.model;

import java.time.LocalDate;
import java.util.List;

public class Project {
	private String name;
	private List<Task> task;
	private LocalDate stardDate;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Task> getTask() {
		return task;
	}

	public void setTask(List<Task> task) {
		this.task = task;
	}

	public LocalDate getStardDate() {
		return stardDate;
	}

	public void setStardDate(LocalDate stardDate) {
		this.stardDate = stardDate;
	}

}
