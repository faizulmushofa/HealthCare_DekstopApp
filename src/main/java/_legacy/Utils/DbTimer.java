package Utils;

public class DbTimer {
    public static long start() {
        return System.currentTimeMillis();
    }

    public static void log(long startMs, String operationName) {
        long elapsed = System.currentTimeMillis() - startMs;
        String badge;
        if (elapsed > 200) {
            badge = "🔴 [VERY SLOW]";
        } else if (elapsed > 50) {
            badge = "🟡 [MODERATE]";
        } else {
            badge = "🟢 [FAST]";
        }

        System.out.printf("  ↳ %-15s Operation: %-25s | Time: %d ms%n", badge, operationName, elapsed);
    }
}
