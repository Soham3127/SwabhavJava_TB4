package com.solidprinciples.ISP;


public interface IWorker extends IWorkable, ILunchInterval {
	
	void startWork();
	
	void stopWork();
	
	void eat();
	
	void drink();

	void rest();

}

