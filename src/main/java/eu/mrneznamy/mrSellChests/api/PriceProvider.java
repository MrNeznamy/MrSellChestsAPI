package eu.mrneznamy.mrSellChests.api;

import org.bukkit.OfflinePlayer;
import org.bukkit.inventory.ItemStack;

public interface PriceProvider {
    /**
     * Get the name of the provider (e.g. "MyShop", "EconomyShopGUI")
     * @return provider name
     */
    String getName();

    /**
     * Get the sell price of an item for a player
     * @param item The item to sell
     * @param player The player selling the item
     * @return The price per item, or 0.0 if not sellable
     */
    double getSellPrice(ItemStack item, OfflinePlayer player);

    /**
     * Check if the provider is available/enabled
     * @return true if available
     */
    boolean isAvailable();
}
