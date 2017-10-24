package br.com.mystudies.java.functional;

import static java.nio.file.Paths.get;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.concurrent.TimeUnit;

public class WatchingAFileChange {

	public static void main(String[] args) throws IOException, InterruptedException {


		final Path path = get("./src/main/resources"); // change some file in resources dir. to see work of Watch Service.

		final WatchService watchService =
				path.getFileSystem().newWatchService();


		path.register(watchService, ENTRY_MODIFY);


		System.out.println("Report any file changed within next 1 minute...");


		WatchKey watchKey =
				watchService.poll(1, TimeUnit.MINUTES);

		if(watchKey != null){
			watchKey.pollEvents()
				.stream()
				.forEach(event -> System.out.println(event.context()));
		}
	}
	
}

