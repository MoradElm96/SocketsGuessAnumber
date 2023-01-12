package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int puerto = 6000;
		ServerSocket servidor = null;
		
		int numeroAdivinar = (int) (Math.random() * 100 + 1);
		try {
			servidor = new ServerSocket(puerto);
			System.out.println("escucho en el puerto 6000");
			Socket cliente1 = servidor.accept();

			InputStream is = cliente1.getInputStream();
			DataInputStream flujo_entrada = new DataInputStream(is);

			OutputStream aux = cliente1.getOutputStream();
			DataOutputStream flujo_salida = new DataOutputStream(aux);
			
			
			
			flujo_salida.writeUTF("Bienvenido al servidor, ¿Seras capaz de adivinar el numero entre 1 y 100?");

			int respuesta;
			System.out.println("//"+numeroAdivinar +"//");
	
			
		
			
			do {
					//recibimos el numero
				respuesta = flujo_entrada.readInt();
				System.out.println("Respuesta:" + respuesta);
				
				if (respuesta < numeroAdivinar) {
					flujo_salida.writeUTF("mayor");
					
					
				} else if(respuesta> numeroAdivinar){
					flujo_salida.writeUTF("menor");
					
				}else {
					flujo_salida.writeUTF("Acertado");
					break;
				}
				

			} while (respuesta != numeroAdivinar);
			
			//comprobacion=true;
			//System.out.println(respuesta);
			//flujo_salida.writeBoolean(comprobacion);

			cliente1.close();
			servidor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
