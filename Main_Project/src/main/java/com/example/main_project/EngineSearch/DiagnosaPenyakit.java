package com.example.main_project.EngineSearch;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


public class DiagnosaPenyakit {
    private static final Map<String, String> penyakitMap = new HashMap();
    public static void main(String[] var0) {
        penyakitMap.put("demam,batuk kering,nyeri tenggorokan", "Influenza");
        penyakitMap.put("demam,batuk berdahak,sesak napas", "Pneumonia");
        penyakitMap.put("sakit kepala,mual,muntah,leher kaku", "Meningitis");
        Scanner var1 = new Scanner(System.in);
        System.out.println("=== Diagnosa Penyakit Berdasarkan Keluhan ===");
        System.out.print("Masukkan keluhan pasien: ");
        String var2 = var1.nextLine().toLowerCase();
        ArrayList var3 = new ArrayList();

        for(String var5 : getSemuaGejala()) {
            if (var2.contains(var5)) {
                var3.add(var5);
            }
        }

        String var6 = cariPenyakit(var3);
        System.out.println("\nGejala terdeteksi: " + String.valueOf(var3));
        System.out.println("Hasil Diagnosa: " + var6);
    }

    private static Set<String> getSemuaGejala() {
        HashSet var0 = new HashSet();

        for(String var2 : penyakitMap.keySet()) {
            String[] var3 = var2.split(",");
            Collections.addAll(var0, var3);
        }

        return var0;
    }

    private static String cariPenyakit(List<String> var0) {
        for(Map.Entry var2 : penyakitMap.entrySet()) {
            List var3 = Arrays.asList(((String)var2.getKey()).split(","));
            if (var0.containsAll(var3)) {
                return "Kemungkinan penyakit: " + (String)var2.getValue();
            }
        }

        return "Belum dapat dipastikan. Silakan konsultasi lebih lanjut.";
    }
}
