package main.runner;

import reader.Dataset;

public class Runner {

	public static void main(String[] args) {
		Dataset d = new Dataset(args[0]);
		for (String s : d.fileContent)
		{
			System.out.println(s);
		}

		System.out.println("=============================");

		d.swapChars();
		for (String s : d.fileContent)
		{
			System.out.println(s);
		}
	}

}
