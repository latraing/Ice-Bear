package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import commands.Commands;
import events.GuildMemberJoin;
import events.GuildMemberLeave;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.OnlineStatus;

/**
 * The user interface for Ice Bear. Starts up Ice Bear.
 * 
 * @author Noss
 */
public class IceBearUI {
	/** Java discord app object */
	public static JDA jda;
	/** Prefix for Ice Bear */
	public static String prefix = ";";
	
	/**
	 * Starts the program
	 * @param args command line arguments not used
	 * @throws LoginException when the bot cannot be connected
	 * @throws FileNotFoundException when the login token file cannot be found
	 */
	public static void main (String[] args) throws LoginException, FileNotFoundException {
		Scanner tokenReader = new Scanner(new File("token.txt"));
		jda = JDABuilder.createDefault(tokenReader.next(), GatewayIntent.GUILD_MEMBERS, GatewayIntent.GUILD_VOICE_STATES, GatewayIntent.GUILD_MESSAGES).build();
		jda.getPresence().setPresence(OnlineStatus.ONLINE, Activity.watching("We Bare Bears"));
		jda.addEventListener(new Commands());
		jda.addEventListener(new GuildMemberJoin());
		jda.addEventListener(new GuildMemberLeave());

	}
}
