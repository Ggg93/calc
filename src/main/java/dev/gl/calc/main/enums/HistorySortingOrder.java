package dev.gl.calc.main.enums;

import dev.gl.calc.Configuration;

/**
 *
 * @author gl
 */
public enum HistorySortingOrder {
    FIRST_TO_LAST ("history_sorting_order_ftl"),
    LAST_TO_FIRST ("history_sorting_order_ltf");
    
    private String resourceBundleKey;

    private HistorySortingOrder(String resourceBundleKey) {
        this.resourceBundleKey = resourceBundleKey;
    }

    @Override
    public String toString() {
        return Configuration.getResourceBundle().getString(resourceBundleKey);
    }
    
}
