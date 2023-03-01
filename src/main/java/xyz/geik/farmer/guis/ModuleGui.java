package xyz.geik.farmer.guis;

import de.themoep.inventorygui.InventoryGui;
import org.bukkit.entity.Player;
import xyz.geik.farmer.Main;
import xyz.geik.farmer.api.handlers.FarmerModuleGuiCreateEvent;
import xyz.geik.farmer.helpers.gui.GuiHelper;
import xyz.geik.farmer.model.Farmer;

public class ModuleGui {

    public static void showGui(Player player, Farmer farmer) {
        // Gui template as array
        String[] moduleGui = Main.getLangFile().getList("moduleGui.interface").toArray(String[]::new);
        // Inventory object
        InventoryGui gui = new InventoryGui(Main.getInstance(), null, Main.getLangFile().getText("moduleGui.guiName"), moduleGui);
        // Filler item for empty slots
        gui.setFiller(GuiHelper.getFiller());
        // Addons placer
        FarmerModuleGuiCreateEvent event = new FarmerModuleGuiCreateEvent(player, gui, farmer);
        Main.getInstance().getServer().getPluginManager().callEvent(event);
        // Shows gui to player
        if (!event.isCancelled())
            gui.show(player);
    }
}
