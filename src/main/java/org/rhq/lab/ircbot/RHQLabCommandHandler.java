package org.rhq.lab.ircbot;

import org.apache.commons.lang3.StringUtils;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.ListenerAdapter;
import org.pircbotx.hooks.events.MessageEvent;
import org.pircbotx.hooks.events.PrivateMessageEvent;

import com.redhat.jonlab.cli.CmdLineExecutor;


public class RHQLabCommandHandler extends ListenerAdapter<PircBotX> {
	public static final String RHQLAB = "!lab";

//	@Override
//	public void onMessage(MessageEvent<PircBotX> event) {
//		try {
//			processMessage(event);
//		} catch (Exception e) {
//			event.respond("Error: " + e.getMessage());
//		}
//	}
	
	@Override
	public void onPrivateMessage(PrivateMessageEvent<PircBotX> event) throws Exception {
	
		String[] output = new CmdLineExecutor().execute(event.getMessage().split(" "));
		for(String s:output) {
			event.respond(s);
		}
       	System.out.println(event.getUser().getNick() + " > " +event.getMessage());
    }
}