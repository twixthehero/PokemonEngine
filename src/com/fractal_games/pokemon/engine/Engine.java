package com.fractal_games.pokemon.engine;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Frame;

public class Engine extends Applet implements Runnable
{
	private static final int WIDTH = 640;
	private static final int HEIGHT = 360;
	
	private static final int UPDATES_PER_SECOND = 60;
	private static final int UPDATE_TIME = 1000 / UPDATES_PER_SECOND;
	
	@Override
	public void init()
	{
		setSize(WIDTH, HEIGHT);
		setBackground(Color.BLACK);
		setFocusable(true);
		
		Frame frame = (Frame)getParent().getParent();
		frame.setTitle("Engine");
	}
	
	@Override
	public void start()
	{
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void stop()
	{
		
	}
	
	@Override
	public void destroy()
	{
		
	}
	
	@Override
	public void run()
	{
		long startTime, timeTaken, timeLeft;
		
		while (true)
		{
			startTime = System.nanoTime();
			
			//update
			
			repaint();
			
			timeTaken = System.nanoTime() - startTime;
			timeLeft = UPDATE_TIME - timeTaken;
			
			if (timeLeft < 10) timeLeft = 10;
			
			try
			{
				Thread.sleep(timeLeft);
			}
			catch (InterruptedException e) { }
		}
	}
}