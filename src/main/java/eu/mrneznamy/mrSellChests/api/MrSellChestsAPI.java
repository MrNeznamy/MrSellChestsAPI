package eu.mrneznamy.mrSellChests.api;

public abstract class MrSellChestsAPI {

    private static MrSellChestsAPI instance;

    public static MrSellChestsAPI getInstance() {
        return instance;
    }

    public static void setInstance(MrSellChestsAPI api) {
        instance = api;
    }

    /**
     * Register a new PriceProvider
     * @param provider The provider implementation
     */
    public abstract void registerPriceProvider(PriceProvider provider);

    /**
     * Unregister a PriceProvider by name
     * @param name The name of the provider
     */
    public abstract void unregisterPriceProvider(String name);

    /**
     * Get a registered PriceProvider
     * @param name The name of the provider
     * @return The provider or null if not found
     */
    public abstract PriceProvider getPriceProvider(String name);

    /**
     * Get the currently active PriceProvider (based on config)
     * @return The active provider
     */
    public abstract PriceProvider getActiveProvider();
}
