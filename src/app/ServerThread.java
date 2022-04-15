package app;

import java.io.IOException;


/** Class for the server threads*/
public class ServerThread extends Thread {
	/** Runs the threads to start and cleanup servers*/
	public void run() {
		// Start the Sever on port 6666 (which will not return until the Shutdown Command is received!
		// and then on exit, clean everything up which will exit this thread
		Server server = new Server();
		try 
		{
			server.start(6666);
			server.cleanup();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}