
package Level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EncryptDecrypt {

	public static void main(String[] args) throws IOException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("\nEnter the path of the file to be encrypted/decrypted :: ");
		String filepath = scanner.nextLine();
		System.out.println("1. Encrypt file \t 2.Decrypt file ");
		System.out.print("Enter your choice :: ");
		int choice = scanner.nextInt();
		scanner.nextLine();
		
		BufferedReader reader = new BufferedReader(new FileReader(filepath));
		BufferedWriter writer = new BufferedWriter(new FileWriter(filepath + ".encrypted"));
		
		if(choice == 1) {
		    System.out.println("\nEncrypting...");
		    StringBuilder encryptedContent = new StringBuilder();
		    String line = "";
		    try {
		        while ((line = reader.readLine())!= null) {
		            StringBuilder encryptedLine = new StringBuilder();
		            for(char c : line.toCharArray()) {
		                char encryptedChar = (char) (c^5); 
		                encryptedLine.append(encryptedChar);
		            }
		            encryptedContent.append(encryptedLine).append("\n");
		        }
		        writer.write(encryptedContent.toString());
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            reader.close();
		            writer.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		    System.out.println("Encryption finished...");
		    
		}else if(choice == 2) {
		    System.out.println("\nDecrypting...");
		    StringBuilder decryptedContent = new StringBuilder();
		    String line = "";
		    try {
		        while ((line = reader.readLine())!= null) {
		            StringBuilder decryptedLine = new StringBuilder();
		            for(char c : line.toCharArray()) {
		                char decryptedChar = (char) (c^5); 
		                decryptedLine.append(decryptedChar);
		            }
		            decryptedContent.append(decryptedLine).append("\n");
		        }
		        writer.write(decryptedContent.toString());
		    } catch (IOException e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            reader.close();
		            writer.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		    System.out.println("Decryption finished...");
		}
		else {
			System.out.println("Invalid Choice");
		}
		
		
		scanner.close();
	
	}

}
