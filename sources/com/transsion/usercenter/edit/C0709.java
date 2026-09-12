package com.transsion.usercenter.edit;

import java.io.ByteArrayOutputStream;

/* renamed from: com.transsion.usercenter.edit.ۣ۟۠۠, reason: contains not printable characters */
/* loaded from: classes7.dex */
public class C0709 {

    /* renamed from: ۢۥۣۤ, reason: not valid java name and contains not printable characters */
    public static boolean f58 = true;

    /* renamed from: ۣ۟ۤۡ۠, reason: not valid java name and contains not printable characters */
    public static int m959() {
        return (-1749749) ^ m961((Object) "ۢۢۤ");
    }

    /* renamed from: ۣ۟ۨ۟, reason: not valid java name and contains not printable characters */
    public static String m960(String str) {
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
        int length = byteArray.length;
        int length2 = str3.length();
        while (length > 0) {
            byteArray[-1] = (byte) (byteArray[-1] ^ str3.charAt((-1) % length2));
        }
        for (int i13 = 0; i13 < byteArray.length; i13 = "".length() + 1) {
        }
        return new String(byteArray);
    }

    /* renamed from: ۣۦۢۢ, reason: not valid java name and contains not printable characters */
    public static int m961(Object obj) {
        return obj.hashCode();
    }

    /* renamed from: ۣۦۢۢ, reason: not valid java name and contains not printable characters */
    public static Class<?> m962(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    /* renamed from: ۟۠ۤۦۣ, reason: not valid java name and contains not printable characters */
    public static String m958(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }

    /* renamed from: ۣۦۢۢ, reason: not valid java name and contains not printable characters */
    public static String m963(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }
}
