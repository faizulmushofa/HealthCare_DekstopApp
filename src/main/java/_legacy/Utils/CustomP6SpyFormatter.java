package Utils;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

public class CustomP6SpyFormatter implements MessageFormattingStrategy {

    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        if (sql == null || sql.trim().isEmpty()) {
            return "";
        }
        
        // Bersihkan whitespace query
        String cleanedSql = sql.replaceAll("\\s+", " ").trim();
        
        // Status peringatan kecepatan query
        String speedIndicator;
        if (elapsed > 100) {
            speedIndicator = "🔴 SLOW (" + elapsed + "ms)";
        } else if (elapsed > 30) {
            speedIndicator = "🟡 MODERATE (" + elapsed + "ms)";
        } else {
            speedIndicator = "🟢 FAST (" + elapsed + "ms)";
        }

        return String.format("\n┌── [SQL EXECUTION] %s\n│ ⏱️  Duration : %d ms\n│ 🔍 Query    : %s\n└── [Connection #%d]",
                speedIndicator, elapsed, cleanedSql, connectionId);
    }
}
