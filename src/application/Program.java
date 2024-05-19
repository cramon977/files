package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;

public class Program {

	public static void main (String[] args)   {
		
		
		String path = "c:\\temp\\arquivo.csv";
		Product pro = null;
		List<Product> list = new ArrayList<>();
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			String line = br.readLine();
			
			
			while(line != null) {
				String[] lines = line.split(",");
				String name = lines[0];
				double price = Double.parseDouble(lines[1]);
				int quantity = Integer.parseInt(lines[2]);
				
				pro = new Product(name, price, quantity );
				System.out.println(pro);
				line = br.readLine();
				list.add(pro);
			}
			
		}		
		catch(IOException e) {
			System.out.println("Error! "); e.printStackTrace();
		}
		
		//Created file and sub file:
		
		//subfile
		
		boolean success = new File("c:\\temp\\out").mkdir();
		if(success != false) {
		System.out.println("Directory created successfully: " + success);
		}
		
		//file
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\temp\\out\\summary.csv"))) {
			for (Product p : list) {
				bw.write(p.toString());
				bw.newLine();
			}
		}
		catch(IOException e) {
			System.out.println("Error! "); e.printStackTrace();
		}
		
		
		}
		
	}
