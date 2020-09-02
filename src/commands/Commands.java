package commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import ui.IceBearUI;

public class Commands extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		StringBuilder sb = new StringBuilder(IceBearUI.prefix);
		if (args[0].equalsIgnoreCase(sb.append("greet").toString())) {
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage("Ice Bear has ninja stars.").queue();
		}
	}
}
