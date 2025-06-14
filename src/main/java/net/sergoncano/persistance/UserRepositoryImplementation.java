package net.sergoncano.persistance;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import net.sergoncano.domain.UserRepository;
import net.sergoncano.domain.model.User;

public class UserRepositoryImplementation implements UserRepository {
	private static final File databaseFile = new File("./resources/Database.txt");

	public Optional<User> getByUUID(UUID uuid) {
		Scanner sc = new Scanner(databaseFile);
		ArrayList<User> list = parseDatabase(sc);
		for(User user : list) {
			if(user.getUUID().equals(uuid)) {
				sc.close();
				return Optional.of(user);
			}
		}
		sc.close();
		return Optional.empty();
	}

	public void AddUser(UUID uuid, String name) {
		try {
		FileWriter fw = new FileWriter(databaseFile, true);
		} catch(IOException e) {
			System.out.println("An error has occurred");
		}
		fw.println(uuid.toString() + " " + name + "0");
		fw.close();
	}

	public void addScoreToUser(User user, int score) {
		Scanner sc = new Scanner(databaseFile);
		ArrayList<User> db = parseDatabase(sc);
		sc.close();
		FileWriter fw = new FileWriter(databaseFile, false);
		for(User dbuser : db) {
			if(user.equals(dbuser)) {
				fw.println(dbuser.getUUID().toString() + " " + dbuser.getName() + " " + dbuser.getScore()+1);
			} else {
				fw.println(dbuser.getUUID().toString() + " " + dbuser.getName() + " " + dbuser.getScore());
			}
		}
		fw.close();
	}

	public int getSumOfScores() {
		Scanner sc;
		try {
			sc = new Scanner(databaseFile);
		} catch(FileNotFoundException e) {
			System.out.println("Database not found");
			return -1;
		}
		ArrayList<User> db = parseDatabase(sc);
		sc.close();
		int totalScore = 0;
		for(User user : db) {
			totalScore += user.getScore();
		}
		return totalScore;
	}

	private ArrayList<User> parseDatabase(Scanner sc) {
		ArrayList<User> list = new ArrayList<>();
		int lineCounter = 0;
		while(sc.hasNextLine()) {
			lineCounter++;
			try {
				String line = sc.nextLine();
				String[] parsedLine = line.trim().split(" ");
				UUID uuid = UUID.fromString(parsedLine[0]);
				String userName = parsedLine[1];
				int score = Integer.parseInt(parsedLine[2]);
				list.add(new User(uuid, userName, score));
			} catch(java.util.InputMismatchException e) {
				System.out.println("Error in line: " + lineCounter);
			}
		}
		return list;
	}
}
