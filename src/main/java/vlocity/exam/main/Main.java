package vlocity.exam.main;

import java.time.LocalDate;
import java.time.Month;

import vlocity.exam.model.Project;
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
		project.setTask(cpc.createDummyTask());
		project.setStardDate(LocalDate.of(2019, Month.JUNE, 3));

		cpc.renderProjectSchedule(project);
	}
}
