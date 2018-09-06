package org.sonar.samples.java.background;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class BackWork {
	private String projectAnalyzedPath;
	private String toolsPath;
	private String findFilePath;
	
	

	
	public BackWork(String path, boolean findFile) throws IOException, InterruptedException {
		if (!findFile) {
			this.projectAnalyzedPath = path;
			this.toolsPath = findPath("Berk-Internship");
			
			//System.out.println("222222222222222222222222222222");
			
		}
		else {
			findFilePath = findPath(path);
		}
	}
	
	private String findPath(String file) throws IOException, InterruptedException {
		Runtime r = Runtime.getRuntime();
		Process p = r.exec(new String[] { "cmd.exe", "/c", "cd C:/Users && dir /b/s " + file });
		BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String path = input.readLine();
		input.close();
		p.getInputStream().close();
		return path;
	}
	
	private String createFolder(String path) {
		File create = new File(path);
		create.mkdir();
		return path;
	}
	
	public void deleteFolder(String path) {
		File toDelete = new File(path);
		String[] entries = toDelete.list();
		for (String s : entries) {
			File currentFile = new File(toDelete.getPath(), s);
			currentFile.deleteOnExit();
		}
	}
	
	public String getFindFilePath() {
		return findFilePath;
	}

	
}


