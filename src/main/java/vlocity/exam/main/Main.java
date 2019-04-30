package vlocity.exam.main;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import vlocity.exam.model.Project;
import vlocity.exam.model.Task;
import vlocity.exam.scheduler.ProjectScheduler;

public class Main {
	/**
	 * Main method
	 * @param args
	 */
	public static void main(String[] args) {
		ProjectScheduler cpc = new ProjectScheduler();
		Project project = new Project();
		project.setName("Vlocity Exam");
		project.setTask(createDummyTask());
		project.setStardDate(LocalDate.of(2019, Month.JUNE, 3));

		cpc.renderProjectSchedule(project);
	}
	
	/**
	 * Create Dummy Task for testing purpose
	 * @return List<Task>
	 */
	private static List<Task> createDummyTask() {
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
