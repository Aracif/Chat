import java.net.*;
import java.io.*;

class Server {
	private static final String SERVER_IP = "192.168.1.147";
	private static final int PORT_NUM = 49152;

	public static void main(String[] args) throws IOException{
		ServerSocket ss = new ServerSocket(PORT_NUM);
		Socket s = ss.accept();
		
		DataInputStream din = new DataInputStream(s.getInputStream());
		DataOutputStream dout = new DataOutputStream(s.getOutputStream());
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String msgin="",msgout="";
		while(!msgin.equals("end")){
			msgin = din.readUTF();
			System.out.println(msgin);
			msgout=br.readLine();
			dout.writeUTF(msgout);
			dout.flush();						
		}
		
	}
}
