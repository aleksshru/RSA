package com.company;

import java.nio.charset.StandardCharsets;

public class Do {
    int p = 11;
    int q = 17;

    String encrypt(String str){
        int n;
        n=p*q;
        int phi=(p-1)*(q-1);
        int[] mas = Look.getD(phi);
        int e=mas[0];
        int d=mas[1];
        phi=(p-1)*(q-1);
        StringBuffer enc = new StringBuffer();
        byte mas1[] = str.getBytes(StandardCharsets.UTF_8);
        int[] encryptmas = new int[mas1.length];
        int k =0;
        for (byte i : mas1){
            encryptmas[k]=Mod.mod(i,e,n);
            enc.append(encryptmas[k] + " ");
        }
        return enc.toString();
    }
    String decrypt(String str){
        int n;

        n=p*q;
        int phi=(p-1)*(q-1);
        int[] mas = Look.getD(phi);
        int e=mas[0];
        int d=mas[1];
        StringBuffer enc = new StringBuffer();
        String[] mass = str.split(" ");
        int mas1[] = new int[mass.length];
        int o = 0;
        for (String i : mass){
            mas1[o]=Integer.parseInt(i);
            o++;
        }
        int[] decryptmas = new int[mas1.length];
        int k =0;
        for (int i : mas1){
            decryptmas[k]=Mod.mod(i,d,n);
            enc.append((char)decryptmas[k]);
        }
        return enc.toString();
    }

    public void setP(int p) {
        this.p = p;
    }

    public void setQ(int q) {
        this.q = q;
    }
}
