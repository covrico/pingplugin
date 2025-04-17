package com.covri.pingplugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;
import java.util.Map;

public class PingListener implements Listener {
    private final Map<Player, Boolean> pingEnabled = new HashMap<>();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        pingEnabled.put(event.getPlayer(), true);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage();
        Player sender = event.getPlayer();
        String[] words = message.split(" ");

        for (String word : words) {
            if (word.startsWith("@")) {
                String username = word.substring(1);
                Player mentionedPlayer = Bukkit.getPlayer(username);

                if (mentionedPlayer != null && pingEnabled.getOrDefault(mentionedPlayer, true)) {
                    // Highlight the username
                    String highlighted = ChatColor.valueOf(PingPlugin.getInstance().getConfig().getString("ping.color")) + username;
                    message = message.replace(word, highlighted);

                    // Play sound to mentioned player
                    mentionedPlayer.playSound(mentionedPlayer.getLocation(), Sound.valueOf(PingPlugin.getInstance().getConfig().getString("ping.sound")), 1.0f, 1.0f);

                    // Send hover text
                    mentionedPlayer.spigot().sendMessage(
                            new net.md_5.bungee.api.chat.TextComponent("You've been pinged by " + sender.getName())
                    );
                }
            }
        }

        event.setMessage(message);
    }

    public boolean isPingEnabled(Player player) {
        return pingEnabled.getOrDefault(player, true);
    }

    public void setPingEnabled(Player player, boolean enabled) {
        pingEnabled.put(player, enabled);
    }
}