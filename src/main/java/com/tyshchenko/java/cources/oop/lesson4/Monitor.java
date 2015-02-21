package com.tyshchenko.java.cources.oop.lesson4;

import java.io.File;

public class Monitor {
	private String file;
	private FileEvenListener event;
	
	public Monitor(String file, FileEvenListener event) {
		this.file = file;
		this.event = event;
	}

	public void start() {
		while (true) {
			File f = new File(file);
			
			if (f.exists() && f.isFile()) {
				if (event != null)
					event.onFileAdded(file);
				
				break;
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
			
			System.out.println("Waiting...");
		}
	}

	public static void main(String[] args) {
		Monitor m = new Monitor("c:\\1.txt", new FileEvent());
		m.start();
	}
}
