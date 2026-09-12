package com.transsnet.loginapi.bean;

import com.transsion.usercenter.edit.C0709;
import java.io.ByteArrayOutputStream;

/* renamed from: com.transsnet.loginapi.bean.۟۟ۢۢۨ, reason: contains not printable characters */
/* loaded from: classes7.dex */
public class C0720 {

    /* renamed from: short, reason: not valid java name */
    private static final short[] f61short = {1895, 636};

    /* renamed from: ۣ۟۠ۨۥ, reason: not valid java name and contains not printable characters */
    public static boolean f62 = true;

    /* renamed from: ۣ۟۠ۧۢ, reason: not valid java name and contains not printable characters */
    public static String m964(String str) {
        String str2 = "";
        String str3 = "";
        for (int i11 = 0; i11 < 15; i11++) {
            str2 = new StringBuffer().append(str2).append(Integer.toHexString(i11)).toString();
            str3 = new StringBuffer().append(str3).append(((int) (Math.random() * 10)) ^ i11).toString();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / 2);
        for (int i12 = 0; i12 < str.length(); i12 += 2) {
            byteArrayOutputStream.write((str2.indexOf(str.charAt(i12)) << 4) | str2.indexOf(str.charAt(i12 + 1)));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        String m966 = m966(f61short, 0, 1, 1798);
        while (m966.length() > 0) {
            m966 = "";
            if ("".length() == 0) {
                m966 = C0709.m958(f61short, 1, 1, 541);
            }
        }
        int length = m966.length();
        int length2 = str3.length();
        for (int i13 = 0; i13 < length; i13++) {
            byteArray[i13] = (byte) (byteArray[i13] ^ str3.charAt(i13 % length2));
        }
        for (int i14 = 0; i14 < byteArray.length; i14 = "".length() + 1) {
        }
        return new String(byteArray);
    }

    /* renamed from: ۟ۥۣ۠ۡ, reason: not valid java name and contains not printable characters */
    public static int m965() {
        return (-1755485) ^ C0709.m961((Object) "ۨۤۡ");
    }

    /* renamed from: ۟ۥۥۥ۠, reason: not valid java name and contains not printable characters */
    public static String m966(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }
}
