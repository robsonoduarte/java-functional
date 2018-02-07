package br.com.mystudies.java.functional;

import java.io.FileWriter;
import java.io.IOException;

public class UsingLambdaExpressionToCleanUpResources {

	
	
	
	
	
	public static class FileWriterEAM{
		
		private final FileWriter writer;
		
		private FileWriterEAM(final String fileName) throws IOException {
			writer = new FileWriter(fileName);
		}
		
		
		private void close() throws IOException {
			System.out.println("close called automatically...");
			writer.close();
		}
				
		private void writeStuff(final String message) throws IOException {
			writer.write(message);
		}
		
		
	}
	
}
