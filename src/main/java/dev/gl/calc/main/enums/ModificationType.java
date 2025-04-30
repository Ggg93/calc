package dev.gl.calc.main.enums;

import java.util.List;

/**
 *
 * @author gl
 */
public enum ModificationType {
    MAKING_DECIMAL,
    SQUARING,
    ROOT,
    PERCENT;
    
    public static String showModificationAsSingleString(List<ModificationType> mods, String value) {
        StringBuilder sb = new StringBuilder(value);
        for (int i = 0; i < mods.size(); i++) {
            ModificationType mod = mods.get(i);
            switch (mod) {
                case MAKING_DECIMAL:
                    sb.insert(0, "1/(");
                    sb.append(")");
                    break;
                case SQUARING:
                    sb.insert(0, "sqr(");
                    sb.append(")");
                    break;
                case ROOT:
                    sb.insert(0, "√(");
                    sb.append(")");
                    break;
            }
        }
        return sb.toString();
    }
}
