package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MainCliente {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			int numeroCliente;
			
			Socket sCliente = new Socket("localhost", 6000);
			
			InputStream is=sCliente.getInputStream();
			DataInputStream flujo_entrada = new	 DataInputStream(is);
			
			OutputStream aux = sCliente.getOutputStream();
			DataOutputStream flujo_salida= new DataOutputStream( aux );
			
			
		    
			String cadena;
			cadena= flujo_entrada.readUTF();
			
			System.out.println("servidor: "+cadena);
			
			String respuesta="Acertado";
			//Boolean comprobacion=;
			
			
			do {
				
				    System.out.println("Escribe el numero");
				    numeroCliente= sc.nextInt();
					flujo_salida.writeInt(numeroCliente);
					
					
					if(respuesta.equalsIgnoreCase(cadena)) {
						break;
					}
					
					cadena = flujo_entrada.readUTF();
					//System.out.println(respuesta);
				
			}while(true);
			
			
			
		
			
			System.out.println("correcto, fin");
				
				
				
		
			
			
			sCliente.close();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
