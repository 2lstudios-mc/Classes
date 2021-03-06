package dev._2lstudios.classes.placeholders;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import dev._2lstudios.classes.enums.ClassType;
import dev._2lstudios.classes.managers.ClassPlayerManager;
import dev._2lstudios.classes.plugin.ClassPlayer;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;

public class ClassesPlaceholders extends PlaceholderExpansion {
  private final Plugin plugin;
  
  private final ClassPlayerManager classPlayerManager;
  
  public ClassesPlaceholders(Plugin plugin, ClassPlayerManager classPlayerManager) {
    this.plugin = plugin;
    this.classPlayerManager = classPlayerManager;
  }
  
  public String getIdentifier() {
    return "Classes";
  }
  
  public String getAuthor() {
    return this.plugin.getDescription().getAuthors().toString();
  }
  
  public String getVersion() {
    return this.plugin.getDescription().getVersion();
  }
  
  public String onPlaceholderRequest(Player player, String identifier) {
    if (player != null && !identifier.isEmpty()) {
      if (identifier.equalsIgnoreCase("energy")) {
        ClassPlayer classPlayer = this.classPlayerManager.get(player);
        if (classPlayer.getClassType() == ClassType.BARD)
          return String.valueOf(classPlayer.getEnergy()); 
      } 
      return "0";
    } 
    return null;
  }
}
