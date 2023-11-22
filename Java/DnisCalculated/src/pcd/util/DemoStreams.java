package pcd.util;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.Arrays;


public class DemoStreams implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String atributoCadena = "Hola";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			DemoStreams prueba = new DemoStreams();
	
			// Ficheros Binarios
			FileOutputStream fSalida = new FileOutputStream("Fichero.dat");
			BufferedOutputStream bufferSalida = new BufferedOutputStream(fSalida);
			byte[] arrayb = new byte[100];
			for (int i=0;i<100;i++){
				arrayb[i] = (byte) i;
			}
			bufferSalida.write(arrayb);
			bufferSalida.close();
			
			FileInputStream fEntrada = new FileInputStream("Fichero.dat");
			BufferedInputStream bufferEntrada = new BufferedInputStream(fEntrada);
			
			byte[] arrayb2 = new byte[100];
			bufferEntrada.read(arrayb2);
			System.out.println(Arrays.toString(arrayb2));
			bufferEntrada.close();
			
			// Ficheros de Datos primitivos
			FileOutputStream fDataSalida= new FileOutputStream("FicheroData.dat");
			DataOutputStream bufferDataSalida = new DataOutputStream(fDataSalida);
			for (int i=0;i<100;i++){
				bufferDataSalida.writeInt(i);
			}
			bufferDataSalida.close();
			
			FileInputStream fDataEntrada= new FileInputStream("FicheroData.dat");
			DataInputStream bufferDataEntrada = new DataInputStream(fDataEntrada);
			try {
				while (true) {
					int dato = bufferDataEntrada.readInt();
					System.out.print(dato+":");
				}
			}
			catch (EOFException e){
				bufferEntrada.close();		
			}
			
			// Ficheros de Texto
			FileWriter fTextoSalida= new FileWriter ("FicheroTexto.txt");
			BufferedWriter bTextoSalida= new BufferedWriter(fTextoSalida);
			for (int i=0;i<100;i++){
				bTextoSalida.write(10.5 + ":\n");
			}
			bTextoSalida.close();
			
			FileReader fTextoEntrada= new FileReader("FicheroTexto.txt");
			BufferedReader bTextoEntrada = new BufferedReader(fTextoEntrada);
			String linea = new String();
			System.out.println();
			while((linea=bTextoEntrada.readLine())!= null) {
				System.out.print(linea);
			}

			// Serializacion
			FileOutputStream fos = new FileOutputStream("FicheroObjetos.bin"); 
			ObjectOutputStream out = new ObjectOutputStream(fos); 
			out.writeObject(prueba); 
			
			FileInputStream fis = new FileInputStream("FicheroObjetos.bin"); 
			ObjectInputStream in = new ObjectInputStream(fis); 
			DemoStreams nuevoObjeto = (DemoStreams) in.readObject(); 
			System.out.println();
			System.out.println(nuevoObjeto);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	@Override
	public String toString() {
		return "PruebaFicheros [atributoCadena=" + atributoCadena + "]";
	}

}