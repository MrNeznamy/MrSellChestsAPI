# MrSellChestsAPI

### Maven Dependency

```xml
<repository>
    <id>jitpack.io</id>
    <url>https://jitpack.io</url>
</repository>

<dependency>
    <groupId>com.github.MrNeznamy</groupId>
    <artifactId>MrSellChestsAPI</artifactId>
    <version>21c9fe1105</version>
    <scope>provided</scope>
</dependency>
```

## Usage

### Registering a Custom Shop Provider

You can register your own shop plugin to provide sell prices for MrSellChests.

```java
import eu.mrneznamy.mrSellChests.api.MrSellChestsAPI;
import eu.mrneznamy.mrSellChests.api.PriceProvider;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.OfflinePlayer;

public void registerMyShop() {
    // Get the API instance
    MrSellChestsAPI api = MrSellChestsAPI.getInstance();

    if (api == null) {
        // MrSellChests plugin is not loaded
        return;
    }

    // Create your provider implementation
    PriceProvider myProvider = new PriceProvider() {
        @Override
        public String getName() {
            // This name is used in config.yml under "Provider"
            return "MyCustomShop";
        }

        @Override
        public double getSellPrice(ItemStack item, OfflinePlayer player) {
            // Implement your price logic here
            // Example:
            if (item.getType() == Material.DIAMOND) {
                return 100.0;
            }
            return 0.0; // Return 0.0 if item cannot be sold
        }

        @Override
        public boolean isAvailable() {
            // Check if your shop plugin is enabled/ready
            return true;
        }
    };

    // Register the provider
    api.registerPriceProvider(myProvider);
}
```

### Unregistering

```java
api.unregisterPriceProvider("MyCustomShop");
```
