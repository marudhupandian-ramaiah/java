package com.learn.designpatterns;

import java.util.Scanner;

public class ChainOfResponsibility {

	public static void main(String[] args) {

		DispenseChain chain100 = new Dispense100();
		DispenseChain chain50 = new Dispense50();
		DispenseChain chain20 = new Dispense20();
		DispenseChain chain10 = new Dispense10();

		chain100.setNextChain(chain50);
		chain50.setNextChain(chain20);
		chain20.setNextChain(chain10);

		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter amount to be disbursed in multiples of 10 :");
			int amt = scanner.nextInt();

			if (amt % 10 != 0) {
				System.out.println("Sorry, enter amount in muliples of 10 only");
			} else {
				System.out.println("Amount disburse details,");
				chain100.dispense(amt);
			}
		}

	}

}

interface DispenseChain {

	public void setNextChain(DispenseChain chain);

	public void dispense(int amt);

}

class Dispense100 implements DispenseChain {

	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain chain) {
		this.chain = chain;
	}

	@Override
	public void dispense(int amt) {

		if (amt >= 100) {

			int noteCount = amt / 100;
			int reminder = amt % 100;

			System.out.println("100 * " + noteCount);

			if (reminder != 0) {
				System.out.println("Sending it to next amount dispenser handler 100 -> 50");
				this.chain.dispense(reminder);
			}

		} else {

			System.out.println("100s cant be disbursed. Sending it to next amount dispenser handler");
			this.chain.dispense(amt);
		}

	}

}

class Dispense50 implements DispenseChain {

	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain chain) {
		this.chain = chain;
	}

	@Override
	public void dispense(int amt) {

		if (amt >= 50) {

			int noteCount = amt / 50;
			int reminder = amt % 50;

			System.out.println("50 * " + noteCount);

			if (reminder != 0) {
				System.out.println("Sending it to next amount dispenser handler 50 -> 20");
				this.chain.dispense(reminder);
			}

		} else {
			System.out.println("50s cant be disbursed. Sending it to next amount dispenser handler");
			this.chain.dispense(amt);
		}

	}

}

class Dispense20 implements DispenseChain {

	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain chain) {
		this.chain = chain;
	}

	@Override
	public void dispense(int amt) {

		if (amt >= 20) {

			int noteCount = amt / 20;
			int reminder = amt % 20;

			System.out.println("20 * " + noteCount);

			if (reminder != 0) {
				System.out.println("Sending it to next amount dispenser handler 20 -> 10");
				this.chain.dispense(reminder);
			}

		} else {
			System.out.println("20s cant be disbursed. Sending it to next amount dispenser handler");
			this.chain.dispense(amt);
		}

	}

}

class Dispense10 implements DispenseChain {

	private DispenseChain chain;

	@Override
	public void setNextChain(DispenseChain chain) {
		this.chain = chain;
	}

	@Override
	public void dispense(int amt) {

		if (amt >= 10) {

			int noteCount = amt / 10;
			int reminder = amt % 10;

			System.out.println("10 * " + noteCount);

			if (reminder != 0) {
				System.out.println("Sending it to next amount dispenser handler 10 -> 0");
				this.chain.dispense(reminder);
			}

		} else {
			System.out.println("10s cant be disbursed. Sending it to next amount dispenser handler");
			this.chain.dispense(amt);

		}
	}

}
