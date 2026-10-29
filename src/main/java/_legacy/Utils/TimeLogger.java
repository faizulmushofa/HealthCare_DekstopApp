package Utils;

import API.LoginApiV2;

public class TimeLogger extends Thread {

    public TimeLogger() {
        setDaemon(true);
    }

    @Override
    public void run() {
        Runtime runtime = Runtime.getRuntime();
        final int MB = 1024 * 1024;
        long lastLoggedUsedMb = -1;

        while (true) {
            try {
                long totalMemory = runtime.totalMemory() / MB;
                long freeMemory = runtime.freeMemory() / MB;
                long usedMemory = totalMemory - freeMemory;
                long maxMemory = runtime.maxMemory() / MB;

                // Hanya log jika ada delta perubahan memori >= 5 MB atau pertama kali jalan
                if (lastLoggedUsedMb == -1 || Math.abs(usedMemory - lastLoggedUsedMb) >= 5) {
                    lastLoggedUsedMb = usedMemory;
                    printMemorySnapshot("STATUS", usedMemory, totalMemory, maxMemory);
                }

                Thread.sleep(2000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public static void logSnapshot(String triggerEvent) {
        Runtime runtime = Runtime.getRuntime();
        final int MB = 1024 * 1024;
        long totalMemory = runtime.totalMemory() / MB;
        long freeMemory = runtime.freeMemory() / MB;
        long usedMemory = totalMemory - freeMemory;
        long maxMemory = runtime.maxMemory() / MB;
        printMemorySnapshot(triggerEvent, usedMemory, totalMemory, maxMemory);
    }

    private static void printMemorySnapshot(String tag, long used, long total, long max) {
        String timestamp = java.time.LocalDateTime.now()
                .format(java.time.format.DateTimeFormatter.ofPattern("HH:mm:ss"));
        String user = LoginApiV2.getUsername();
        String activeUser = (user != null && !user.isEmpty()) ? user : "GUEST";

        // Status bar visual RAM
        int percentage = max > 0 ? (int) ((used * 100) / max) : 0;
        int barLength = 15;
        int filled = (percentage * barLength) / 100;
        StringBuilder bar = new StringBuilder("[");
        for (int i = 0; i < barLength; i++) {
            bar.append(i < filled ? "■" : " ");
        }
        bar.append("]");

        System.out.printf("[%s] [MEM-MONITOR] [%-12s] User: %-8s | RAM: %4d MB / %4d MB %s (%d%%)%n",
                timestamp, tag, activeUser, used, max, bar.toString(), percentage);
    }
}
