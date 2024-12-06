package me.mchiappinam.pdghkit;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class Comando implements CommandExecutor, Listener {
	private Main plugin;
	public Comando(Main main) {
		plugin=main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("kit")) {
			if(args.length==0) {
				sendHelp(sender);
				return true;
			}
			if(args[0].equalsIgnoreCase("nb")) {
				if(args.length>1) {
					sender.sendMessage("§3[Ⓚⓘⓣⓢ] §cUse /kit nb");
					return true;
				}
				if (plugin.nb.contains(sender.getName().toLowerCase())) {
					sender.sendMessage("§3[Ⓚⓘⓣⓢ] §cAguarde para pedir esse kit novamente.");
					return true;
				}
				plugin.nb.add(sender.getName().toLowerCase());
				plugin.startTask((Player) sender);
				Kit((Player) sender);
				return true;
			}else if(args[0].equalsIgnoreCase("vip")) {
				if(args.length>1) {
					sender.sendMessage("§3[Ⓚⓘⓣⓢ] §cUse /kit vip");
					return true;
				}
				if(!sender.hasPermission("pdgh.vip")) {
					sender.sendMessage("§cApenas §6§lVIPs §cpodem usar esse kit.");
					sender.sendMessage("§eAdquira seu §6§lVIP §eem §cwww.pdgh.com.br §ee tenha diversas vantagens.");
					return true;
				}
				if (plugin.vip.contains(sender.getName().toLowerCase())) {
					sender.sendMessage("§3[Ⓚⓘⓣⓢ] §cAguarde o servidor reiniciar para pegar o kit §6§lVIP §cnovamente.");
					return true;
				}
				plugin.vip.add(sender.getName().toLowerCase());
				KitVIP((Player) sender);
				return true;
			}
			sendHelp(sender);
			return true;
		}
		return false;
	}
	
	private void sendHelp(CommandSender sender) {
		sender.sendMessage("§3Ⓚⓘⓣⓢ ⓓⓘⓢⓟⓞⓝⓘⓥⓔⓘⓢ");
		sender.sendMessage("§2/kit nb -§a- Kit para iniciantes.");
		if(sender.hasPermission("pdgh.vip"))
			sender.sendMessage("§2/kit vip -§a- Kit para §6§lVIPs§a.");
		else
			sender.sendMessage("§c/kit vip -§a- Kit para §6§lVIPs§a.");
	}
	


	public void Kit(Player p) {
		p.getInventory().addItem(new ItemStack(Material.getMaterial(270), 1));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(269), 1));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(271), 1));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(50), 3));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(297), 3));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(54), 1));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(58), 1));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(17), 1));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(284), 1));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(6), 1));
		p.sendMessage("§eKit nb recebido com sucesso.");
	}

	public void KitVIP(Player p) {
		p.getInventory().addItem(new ItemStack(Material.getMaterial(30188), 10));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(264), 10));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(388), 3));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(266), 10));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(265), 10));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(263), 64));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(263), 64));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(24907), 10, (short) 1));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(89), 5));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(320), 32));
		p.getInventory().addItem(new ItemStack(Material.getMaterial(6353), 1));
    	p.sendMessage("§eKit §6§lVIP §erecebido com sucesso.");
    	p.sendMessage("§eVocê poderá pedir seu kit novamente quando o servidor se reiniciar.");
	}
	
}
