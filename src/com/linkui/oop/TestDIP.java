package com.linkui.oop;

/**
 * A demo to show Dependency Inverse Principle (DIP)
 * 
 * @author linkui
 *
 */

public class TestDIP {
	public static void main(String[] args) {
		System.out.println("########## Using constructor ############");
		Reporter errorReporter1 = new SMSReporter();
		ErrorManager em1 = new ErrorManager(errorReporter1);
		em1.handleError();

		System.out.println("########## Using setter ############");
		Reporter errorReporter2 = new DirectReporter();
		ErrorManager em2 = new ErrorManager();
		em2.setReporter(errorReporter2);
		em2.handleError();
	}
}

class ErrorManager {
	public Reporter getReporter() {
		return reporter;
	}

	String error = "this is a test error message";
	Reporter reporter = null;

	/**
	 * Inject details with constructor
	 * 
	 * @param concreteReporter
	 */
	public ErrorManager(Reporter concreteReporter) {
		this.reporter = concreteReporter;
	}

	/**
	 * Overloaded empty constructor
	 */
	public ErrorManager() {
	}

	/**
	 * Inject details with Setter()
	 * 
	 * @param reporter
	 */
	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}

	public void handleError() {
		reporter.reportError(error);
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Error reported!");
	}
}

interface Reporter {
	public void reportError(String errorMsg);
}

class EmailReporter implements Reporter {

	@Override
	public void reportError(String errorMsg) {
		System.out.println("Reporting errors through Email.");
	}

}

class SMSReporter implements Reporter {

	@Override
	public void reportError(String errorMsg) {
		System.out.println("Reporting errors through SMS.");
	}

}

class DirectReporter implements Reporter {

	@Override
	public void reportError(String errorMsg) {
		System.out.println("Reporting errors by someone directly.");
	}

}