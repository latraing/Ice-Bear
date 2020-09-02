package ui;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.OnlineStatus;

public class IceBearUI {
	public static JDA jda;
	
	public static void main (String[] args) throws LoginException {
		jda = JDABuilder.createDefault("NzUwODE2OTY4ODY4NjI2NDYy.X1ACyg.cVLcWjFQVzV7HNkYzuJssuRX_f4").build();
		jda.getPresence().setPresence(OnlineStatus.ONLINE, Activity.watching("We Bare Bears"));;
		
	}
}
