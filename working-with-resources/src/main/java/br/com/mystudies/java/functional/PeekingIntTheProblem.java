package br.com.mystudies.java.functional;

import java.io.FileWriter;
import java.io.IOException;

public class PeekingIntTheProblem {

	
	public static void main(String[] args) throws IOException {
		final FileWriteExample writeExample = new FileWriteExample("peekaboo.txt");
				
		// with bloc try/finally we ensuring the cleanup
		try {
			writeExample.writeStuff("peek a boo");
		} finally { 
			writeExample.close(); // but if we don't call the close method the resource ( FileWrite ) will open.
		}
		
		
		// use try-with-resources 
		try(final FileWriteARM writeARM = new FileWriteARM("peekaboo.txt")){
			writeARM.writeStuff("peek a boo");
			
			System.out.println("done with the resource");
		}
		
	}
	
	
	// Simple File Write
	public static class FileWriteExample{
		
		private final FileWriter writer;

		public FileWriteExample(final String fileName) throws IOException {
			this.writer = new FileWriter(fileName);
		}
		
		public void writeStuff(final String message) throws IOException {
			writer.write(message);
		}
		
		public void close() throws IOException {
			writer.close();
		}		
	}
	
	
	
		// File Write With ARM ( Automatic Resource Management ) feature introduced in Java 7.
		public static class FileWriteARM implements AutoCloseable{
			
			private final FileWriter writer;

			public FileWriteARM(final String fileName) throws IOException {
				this.writer = new FileWriter(fileName);
			}
			
			public void writeStuff(final String message) throws IOException {
				writer.write(message);
			}
			
			@Override
			public void close() throws IOException {
				writer.close();
			}		
		}
}
