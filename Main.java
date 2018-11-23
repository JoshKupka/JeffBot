package com.joshkupka.development.JeffBot;

import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.entity.Permissionable;
import org.javacord.api.entity.channel.TextChannel;
import org.javacord.api.entity.message.Message;
import org.javacord.api.entity.message.MessageAuthor;
import org.javacord.api.entity.permission.Permissions;
import org.javacord.api.entity.permission.Role;
import org.javacord.api.entity.permission.RoleBuilder;
import org.javacord.api.entity.server.Server;
import org.javacord.api.entity.server.ServerUpdater;
import org.javacord.api.entity.user.User;
import org.javacord.api.event.server.role.UserRoleAddEvent;
import org.javacord.core.entity.permission.PermissionsImpl;
import org.javacord.core.entity.server.ServerImpl;
import org.javacord.core.event.server.role.UserRoleAddEventImpl;

import java.time.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

public class Main {

	public static void main(String[] args) {
		
		LocalDateTime Time = LocalDateTime.now();
		
		DiscordApi api = new DiscordApiBuilder().setToken("").login().join();
		System.out.println("Logged in at " +  Time);
		
		Collection<Role> availableRoles = api.getRoles();
		List Roles = new ArrayList(availableRoles);
		int i = Roles.size();

		int c = i;

		List AllowedRoles = new ArrayList();
		Object NSFW = Roles.get(1);
		AllowedRoles.add(NSFW);
		int h = AllowedRoles.size();

		AllowedRoles.get(0).toString().indexOf('n');
		

		System.out.println(AllowedRoles.get(0).toString().indexOf('n'));
		String beginParse = AllowedRoles.get(0).toString().substring(36);
		
		AllowedRoles.get(0).toString().substring(35);
		
		System.out.println(i);
		TextChannel rolesChannel = api.getTextChannelById(515545790114955265L).get();
		
		while(c >= 1){
			System.out.println(Roles.get(c -1));
			c--;
		}
		
		api.addMessageCreateListener(event -> {
			Message message = event.getMessage();
			MessageAuthor messageAuthor = message.getAuthor();
			if (message.getContent().contains("!role")) {
				if(event.getChannel() == rolesChannel) {
					String Command = message.getContent();
					Command.length();
					String requestedRole = Command.substring(6);
					System.out.println(requestedRole);
					System.out.println(i);
					String parseCheck;
					int d = h;
					while (d >= 1) {
						int BP = AllowedRoles.get(d -1).toString().indexOf('n') + (6);
						parseCheck = AllowedRoles.toString().substring(BP);
						if(parseCheck.contains(requestedRole)) {
							CompletableFuture<User> addingToUser = messageAuthor.getApi().getUserById(messageAuthor.getId());
							api.
							api.getUserById(messageAuthor.getId());
							System.out.println(addingToUser);
							break;
						}
						d--;
					}
				} else {
					}
				}
		});
	}
}
