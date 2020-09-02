package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.OnlineStatus;

public class IceBearUI {
	public static JDA jda;
	
	public static void main (String[] args) throws LoginException, FileNotFoundException {
		Scanner tokenReader = new Scanner(new File("token.txt"));
		jda = JDABuilder.createDefault(tokenReader.next()).build();
		jda.getPresence().setPresence(OnlineStatus.ONLINE, Activity.watching("We Bare Bears"));;
		
	}
}
