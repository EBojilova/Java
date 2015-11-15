package dictionary;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming {

    private static final int WIN_QUANTITY = 250;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // Shards, Fragments and Motes are the key materials
        LinkedHashMap<String, Integer> keyMaterials = new LinkedHashMap<String, Integer>() {{
            put("fragments", 0);
            put("motes", 0);
            put("shards", 0);
        }};

        // all else is junk. alphabetical order
        TreeMap<String, Integer> junk = new TreeMap<>();
        String keyMaterialCollectedFirst = "";

        while (true) {
            String[] items = scn.nextLine()
                                .split(" ");
            for (int i = 0; i < items.length; i += 2) {
                int quantity = Integer.parseInt(items[i]);
                String item = items[i + 1].toLowerCase();

                if (keyMaterials.containsKey(item)) {
                    keyMaterials.put(item, keyMaterials.get(item) + quantity);

                    if (keyMaterials.get(item) >= WIN_QUANTITY) {
                        keyMaterials.put(item, keyMaterials.get(item) - WIN_QUANTITY);
                        keyMaterialCollectedFirst = item;
                        break;
                    }

                }
                else {
                    if (!junk.containsKey(item)) {
                        junk.put(item, 0);
                    }

                    junk.put(item, junk.get(item) + quantity);
                }
            }

            if (keyMaterialCollectedFirst.length() > 0) {
                break;
            }
        }

        System.out.println(getLegendary(keyMaterialCollectedFirst) + " obtained!");

        // print the remaining shards, fragments, motes, ordered by quantity in descending order
        keyMaterials.entrySet()
                    .stream()
                    .sorted((k1, k2) -> k2.getValue()
                                          .compareTo(k1.getValue()))
                    .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));

        // Finally, print the collected junk items, in alphabetical order
        junk.entrySet()
            .forEach(j -> System.out.println(j.getKey() + ": " + j.getValue()));
    }

    private static String getLegendary(String material) {
        if (material.equals("shards")) {
            return "Shadowmourne";
        }
        if (material.equals("fragments")) {
            return "Valanyr";
        }

        return "Dragonwrath";
    }
}