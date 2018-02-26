package com.val.codewars;

public class One_Mumbling {
    public static void main(String[] args) {
        System.out.println(accum("helo"));
    }

    public static String accum(String s){
        StringBuilder sb = new StringBuilder();
        Character c;
        for(int i = 0; i < s.length(); i++){

            if(i != 0){
                sb.append("-");
            }
            c = s.charAt(i);
            sb.append(Character.toUpperCase(c));

            c = Character.toLowerCase(c);
            for(int x = 0; x < i; x++){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
