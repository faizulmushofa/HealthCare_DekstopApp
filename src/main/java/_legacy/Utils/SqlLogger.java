package Utils;

/**
 * Log query SQL ke console sebelum dieksekusi.
 * Pakai: SqlLogger.log("SELECT * FROM users WHERE id = ?", id);
 */
public class SqlLogger {

    private static boolean enabled = true; // set false untuk matikan di production

    public static void log(String query, Object... params) {
        if (!enabled) return;
        StringBuilder sb = new StringBuilder();
        sb.append("\n[SQL] ").append(query.replaceAll("\\s+", " ").trim());
        if (params.length > 0) {
            sb.append("\n      params: [");
            for (int i = 0; i < params.length; i++) {
                sb.append(params[i]);
                if (i < params.length - 1) sb.append(", ");
            }
            sb.append("]");
        }
        System.out.println(sb);
    }

    public static void setEnabled(boolean enabled) {
        SqlLogger.enabled = enabled;
    }
}
