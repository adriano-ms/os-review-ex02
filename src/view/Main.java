package view;

import java.util.concurrent.Semaphore;

import threads.TimedThread;

public class Main {

	public static void main(String[] args) {
		
		int processesAmount = 20;
		
		Semaphore mutex = new Semaphore(1);
		TimedThread[] processes = new TimedThread[processesAmount];
		
		for(int i = 0; i < processesAmount; i++) 
			processes[i] = new TimedThread(mutex);
		
		bubbleSort(processes);
		
		for(TimedThread process : processes) 
			process.start();

	}
	
	public static void bubbleSort(TimedThread[] processes) {
		int size = processes.length;
		for(int i = 1; i <= size; i++) 
			for(int j = 0; j < size - i; j++) 
				if(processes[j].getTime() > processes[j + 1].getTime()) {
					TimedThread aux = processes[j];
					processes[j] = processes[j + 1];
					processes[j + 1] = aux;
				}
	}

}
