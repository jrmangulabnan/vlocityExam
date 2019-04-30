package vlocity.exam.scheduler;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vlocity.exam.model.Project;
import vlocity.exam.model.Task;

public class ProjectScheduler {
	private final static Logger logger = LoggerFactory.getLogger(ProjectScheduler.class);
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
			if (Optional.ofNullable(task.getTask()).orElse(new ArrayList<Task>()).isEmpty()) {
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
		//TODO: put schedule in a model here????
		
		logger.info("Task name: {}", task.getName());
		logger.info("Duration {} day/s", manDays);
		logger.info("Start date: {}", date);
		logger.info("End date: {}", result);
		logger.info("====================");
		return result;
	}
}
