import java.io.*;
import java.net.*;
class Client {

	private static String getIpAddress() throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the host IP address to connect to... ");
		return br.readLine();
	}

	private static int getPortNum() throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please enter the host IP address to connect to... ");
		return Integer.parseInt(br.readLine());
	}
	public static void main(String[] args){
		try{
			Socket s = new Socket(getIpAddress(), getPortNum());
			DataInputStream din = new DataInputStream(s.getInputStream());
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String msgin="",msgout="";
			while(!msgin.equals("end")){
				msgout =br.readLine();
				dout.writeUTF(msgout);
				msgin = din.readUTF();
				System.out.print(msgin);
			}
		}
		catch(Exception e){

		}
	}
}
