package dev.gl.calc.main.enums;

import dev.gl.calc.Configuration;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author gl
 */
public enum RoundingModeLocalized {
    CEILING (RoundingMode.CEILING, "rm_ceiling"),
    DOWN (RoundingMode.DOWN, "rm_down"),
    FLOOR (RoundingMode.FLOOR, "rm_floor"),
    HALF_DOWN (RoundingMode.HALF_DOWN, "rm_half_down"),
    HALF_EVEN (RoundingMode.HALF_EVEN, "rm_half_even"),
    HALF_UP (RoundingMode.HALF_UP, "rm_half_up"),
    UNNECESSARY (RoundingMode.UNNECESSARY, "rm_unnecessary"),
    UP (RoundingMode.UP, "rm_up");

    private RoundingMode roundingMode;
    private String resourceBundleKey;
    private static Map<RoundingMode, RoundingModeLocalized> map = new HashMap<>();
    
    static {
        for (RoundingModeLocalized value : RoundingModeLocalized.values()) {
            map.put(value.roundingMode, value);
        }
    }

    private RoundingModeLocalized(RoundingMode roundingMode, String resourceBundleKey) {
        this.roundingMode = roundingMode;
        this.resourceBundleKey = resourceBundleKey;
    }

    public static RoundingModeLocalized getValueByRoundingMode(RoundingMode rm) {
        return map.get(rm);
    }

    @Override
    public String toString() {
        return Configuration.getResourceBundle().getString(resourceBundleKey);
    }

    public RoundingMode getRoundingMode() {
        return roundingMode;
    }

}
