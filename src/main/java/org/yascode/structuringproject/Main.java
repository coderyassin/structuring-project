package org.yascode.structuringproject;

import io.micrometer.common.util.StringUtils;

import java.util.UUID;

public class Main {

    public static void main(String[] args) {
        /*DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse("2023-11-09T20:15:00", dateTimeFormatter);
        LocalDateTime parse1 = LocalDateTime.parse("2023-11-09T20:15:00");*/

        /*try {
            Long aLong = Long.valueOf(null);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());

        }*/
        /*LocalDateTime value = LocalDateTime.of(2023, Month.NOVEMBER, 13, 11, 56);

        Map<String, List<String>> map = new HashMap<>();

        List<String> list = new ArrayList<>();

        list.add("test1");

        map.put("str1", list);

        if(map.containsKey("str11")) {
            map.get("str1").add("test2");
        }
        else {
            List<String> list2 = new ArrayList<>();
            list2.add("toto1");
            map.put("to", list2);

            map.put("to", new ArrayList<>() {
                {
                    add("Geeks");
                    add("for");
                    add("Geeks");
                }
            });
        }

        map.forEach((s, l) -> {
            System.out.println("---------------------------");
            System.out.println(s);
            l.forEach(System.out::println);
            System.out.println("---------------------------");
        });*/

        System.out.println(UUID.randomUUID().toString());



    }

}
