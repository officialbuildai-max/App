package com.transsnet.loginapi.bean;

import com.transsion.usercenter.edit.C0709;
import java.io.ByteArrayOutputStream;

/* renamed from: com.transsnet.loginapi.bean.ۡۥۢۧ, reason: contains not printable characters */
/* loaded from: classes7.dex */
public class C0722 {

    /* renamed from: ۥۤۡۢ, reason: contains not printable characters */
    public static int f64 = -1;

    /* renamed from: ۟۟ۢ۟ۨ, reason: not valid java name and contains not printable characters */
    public static String m970(String str) {
        String str2 = "";
        String str3 = "";
        for (int i11 = 0; i11 < 15; i11++) {
            str2 = new StringBuffer().append(str2).append(Integer.toHexString(i11)).toString();
            str3 = new StringBuffer().append(str3).append(((int) (Math.random() * 10)) ^ i11).toString();
        }
        do {
        } while (str2.length() > 0);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / 2);
        for (int i12 = 0; i12 < str.length(); i12 += 2) {
            byteArrayOutputStream.write((str2.indexOf(str.charAt(i12)) << 4) | str2.indexOf(str.charAt(i12 + 1)));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        int length2 = str3.length();
        for (int i13 = 0; i13 < length; i13++) {
            byteArray[i13] = (byte) (byteArray[i13] ^ str3.charAt(i13 % length2));
        }
        return new String(byteArray);
    }

    /* renamed from: ۧۡۢۧ, reason: not valid java name and contains not printable characters */
    public static int m972() {
        return 1751727 ^ C0709.m961((Object) "ۤۦۧ");
    }

    /* renamed from: ۣۢۨ۟, reason: not valid java name and contains not printable characters */
    public static String m971(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }
}
