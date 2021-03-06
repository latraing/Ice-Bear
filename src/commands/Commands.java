package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import ui.IceBearUI;

/**
 * Holds a list of commands that Ice Bear responds to.
 * 
 * @author Noss
 */
public class Commands extends ListenerAdapter {
	/**
	 * Defines what Ice Bear should do given different commands.
	 * @param event the event that details a message being sent (and received).
	 */
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if (args[0].equalsIgnoreCase(IceBearUI.prefix + "greet")) {
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage("Ice Bear has ninja stars.").queue();
		} else if (args[0].equalsIgnoreCase(IceBearUI.prefix + "info")) {
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage("Noss told Ice Bear to come.").queue();
		} else if (args[0].equalsIgnoreCase(IceBearUI.prefix + "whencheck")) {
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage("Say when.").queue();
		}
	}
}
