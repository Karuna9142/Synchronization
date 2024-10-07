package com.synchronization;

//without useing synchroniz
class Table
{
	synchronized void printTable(int n)
	{
		for(int i = 1; i<=5; i++)
		{
			System.out.println(n*i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				
				System.out.println(e);
			}
		}	
	}
}
class MyThread1 extends Thread
{
	Table t;
	MyThread1(Table t)
	{
		this.t = t;
	}
	public void run()
	{
		t.printTable(5);
	}
}
class MyThread2 extends Thread
{
	Table t;
	MyThread2(Table t)
	{
		this.t = t;
	}
	public void run()
	{
		t.printTable(2);
	}
}

public class SynchronizationEx {

	public static void main(String[] args) {
		
		Table tb = new Table();
		
		MyThread1 t1 = new MyThread1(tb) ;
		MyThread2 t2 = new MyThread2(tb) ;
		
		t1.start();
		t2.start();
		

	}

}
