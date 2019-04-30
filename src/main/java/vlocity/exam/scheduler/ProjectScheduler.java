package vlocity.exam.scheduler;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import vlocity.exam.model.Project;
import vlocity.exam.model.Task;

public class ProjectScheduler {
	
	private LocalDate date;

	/**
	 * The start point on where to process project to give schedule to entire task
	 * @param project
	 */
	public void renderProjectSchedule(Project project) {
		date = project.getStardDate();
		scheduleTask(project.getTask());
	}

	/**
	 * This will give schedule to task
	 * @param tasks
	 */
	private void scheduleTask(List<Task> tasks) {
		for (Task task : tasks) {
			if (task.getTask() == null) {
				date = add(date, task);
			} else {
				scheduleTask(task.getTask());
				date = add(date, task);
			}
		}
	}

	/**
	 * Adding date to LocalDate that skip weekend
	 * @param date
	 * @param task
	 * @return LocalDate
	 */
	private LocalDate add(LocalDate date, Task task) {
		int manDays = task.getManDays();
		System.out.println("Task name: " + task.getName());
		System.out.println("Duration " + manDays + " day/s");
		System.out.println("Start date: " + date);
		if (manDays < 1) {
			return date;
		}

		LocalDate result = date;
		int addedDays = 0;
		while (addedDays < manDays) {
			result = result.plusDays(1);
			if (!(result.getDayOfWeek() == DayOfWeek.SATURDAY || result.getDayOfWeek() == DayOfWeek.SUNDAY)) {
				++addedDays;
			}
		}
		
		//TODO: Add skip holiday
		
		System.out.println("End date: " + result);
		System.out.println("===================");
		return result;
	}

	/**
	 * Create Dummy Task for testing purpose
	 * @return List<Task>
	 */
	public List<Task> createDummyTask() {
		Task task1 = new Task();
		Task task1a = new Task();
		Task task1aa = new Task();
		Task task1b = new Task();
		Task task1c = new Task();
		
		task1aa.setName("task 1aa");
		task1aa.setManDays(10);
		
		task1a.setName("task 1a");
		task1a.setManDays(2);
		task1a.setTask(Arrays.asList(task1aa));
		
		task1b.setName("task 1b");
		task1b.setManDays(3);
		
		task1c.setName("task 1c");
		task1c.setManDays(4);
		
		task1.setName("task 1");
		task1.setManDays(4);
		task1.setTask(Arrays.asList(task1a, task1b, task1c));
		
		Task task2 = new Task();
		Task task2a = new Task();
		
		task2a.setName("task 2a");
		task2a.setManDays(5);
		
		task2.setName("task 2");
		task2.setManDays(3);
		task2.setTask(Arrays.asList(task2a));
		
		Task task3 = new Task();
		
		task3.setName("task 3");
		task3.setManDays(1);
		
		return Arrays.asList(task1, task2, task3);
	}
}
