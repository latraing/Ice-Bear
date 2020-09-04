package events;

import java.util.Random;

import net.dv8tion.jda.api.events.guild.member.GuildMemberRemoveEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * Defines what Ice Bear should do when a user leaves the discord server.
 * 
 * @author Noss
 */
public class GuildMemberLeave extends ListenerAdapter {
	/**
	 * List of messages that Ice Bear can deliver when someone leaves.
	 */
	String[] messages = {
			"Ice Bear will miss you. [member]",
			"Ice Bear wished you could stay longer. [member]",
			"Ice Bear wasn't cool enough for [member]."
	};
	
	/**
	 * Upon a user leaving the discord server, this method defines what Ice Bear should do.
	 * @param event the event that tells that a person left
	 */
	public void onGuildMemberRemove(GuildMemberRemoveEvent event) {
		Random rand = new Random();
		int number = rand.nextInt(messages.length);
		event.getGuild().getDefaultChannel().sendTyping().queue();
		event.getGuild().getDefaultChannel().sendMessage(messages[number].replace("[member]", event.getUser().getAsMention())).queue();
	}
}
