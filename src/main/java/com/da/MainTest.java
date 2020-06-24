package com.da;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

public class MainTest {

//    public static void main(String[] args) {
//        String old = "$2a$10$YO.97h5NV0ioJwMF/L4xZusY4jnBefM2u2YdjKNlWnyPravWNj2Ly";
//        String newpw = "123456";
//
//        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//        if (passwordEncoder.matches(newpw,passwordEncoder.encode(newpw))) {
//            System.out.println("true");
//        } else {
//            System.out.println("False");
//        }
//    }
    public static List<String> Searchxauconchung (List<String> a, String b){

        List<String> result = new ArrayList<>();

        Map<String, Double> listString_Tile = new HashMap<String, Double>();



        for (int i = 0; i< a.size();i++){

            String strC = a.get(i).toUpperCase();

            String strD = b.toUpperCase();

            String strA[] = strC.split(" ");

            String strB[] = strD.split(" ");

            List<String> arrayA = new ArrayList<String>();

            List<String> arrayB = new ArrayList<String>();

            arrayA = Arrays.asList(strA);

            System.out.println("arrayA: " +strA );

            arrayB = Arrays.asList(strB);

            System.out.println("arrayB: " +strB );

            List<String> arrayMap = new ArrayList<String>();

            for(int k = 0; k< arrayA.size();k++ ){

                for (int h = 0; h<arrayB.size();h++){

                    if(arrayA.get(k).equals(arrayB.get(h))){

                        arrayMap.add(arrayA.get(k));

                    }

                }

            }

            double Tile = (double) Math.round(((Double.valueOf(arrayMap.size())) /arrayA.size())*100)/100;

            System.out.println("Ti le: " +Tile);

            listString_Tile.put(strC, Tile);

        }

        List<Map.Entry<String, Double>> list =

                new LinkedList<Map.Entry<String, Double>>(listString_Tile.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {

            public int compare(Map.Entry<String, Double> o1,

                               Map.Entry<String, Double> o2) {

                return (o1.getValue()).compareTo(o2.getValue());

            }

        });

        System.out.println("ducnd: " +list.get(0).getKey());

        for (int u = 0; u < list.size(); u++){

            result.add(list.get(u).getKey());

        }

        return result;

    }



    public static void main(String[] args) {

        List<String> a = new ArrayList<String>();

        String b = "Hoàng hoc đại học bách khoa";

        a.add(b);

        String c = "Hoàng học cấp ba chuyên phan bội châu";

        String g = "Hoàng học Cấp ba chuyên phan bội châu";

        a.add(c);

        a.add(g);

        String d = "HOàng học cấp";

        System.out.println(a);

        List<String> e = Searchxauconchung(a,d);





    }
}
