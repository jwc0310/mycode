

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client2
{
	private static final int		PORT	= 54321;
	private static ExecutorService	exec	= Executors.newCachedThreadPool();


	public static void main(String[] args)
	{
		try{
			new Client2();
		}catch(Exception e){
		}
		
	}


	public Client2()
	{
		try
		{
			Socket socket = new Socket("10.253.164.49",PORT);
			exec.execute(new Sender(socket));

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String msg;
			while ((msg = br.readLine()) != null)
			{
				System.out.println(msg);
			}
		}
		catch (Exception e)
		{

		}
	}   
    //�ͻ����̻߳�ȡ����̨������Ϣ
	static class Sender implements Runnable
	{
		private Socket	socket;
		public Sender(Socket socket)
		{
			this.socket = socket;
		}
		public void run()
		{
			try
			{
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
				String msg;

				while (true)
				{
					msg = br.readLine();
					pw.println(msg);

					if (msg.trim().equals("exit"))
					{
						pw.close();
						br.close();
						exec.shutdownNow();
						break;
					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}  
}

