package events;

import java.util.Random;

import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * Defines what Ice Bear will do when a user joins the discord server.
 * 
 * @author Noss
 */
public class GuildMemberJoin extends ListenerAdapter {
	/**
	 * List of messages that Ice Bear can deliver when someone joins.
	 */
	String[] messages = {
			"Ice Bear welcomes you. [member]",
			"Ice Bear appreciates having you. [member]",
			"Ice Bear wants to get to know [member] better."
	};
	
	/**
	 * Upon a user joining the discord server, this method defines what Ice Bear should do.
	 * @param event the event that tells that a person joined
	 */
	@Override
	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		Random rand = new Random();
		int number = rand.nextInt(messages.length);
		event.getGuild().getDefaultChannel().sendTyping().queue();
		event.getGuild().getDefaultChannel().sendMessage(messages[number].replace("[member]", event.getMember().getAsMention())).queue();
		if (event.getUser().isBot()) {
			event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("199757851424587787")).complete();
		} else {
			event.getGuild().addRoleToMember(event.getMember(), event.getGuild().getRoleById("293608728975114240")).complete();
		}
	}
	
}
