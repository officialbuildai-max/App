package androidx.core;

import androidx.core.appcompat.C0066;
import com.transsion.subroom.activity.C0667;
import gt.md.C0799;
import java.io.ByteArrayOutputStream;

/* renamed from: androidx.core.ۧۢۧۦ, reason: contains not printable characters */
/* loaded from: classes7.dex */
public class C0079 {

    /* renamed from: short, reason: not valid java name */
    private static final short[] f11short = {2870, 2389};

    /* renamed from: ۣۡ۠ۨ, reason: not valid java name and contains not printable characters */
    public static int f12 = -92;

    /* renamed from: ۟۠ۧ۟۠, reason: not valid java name and contains not printable characters */
    public static String m393(String str) {
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
        String m206 = C0066.m206(f11short, 0, 1, 2903);
        while (m206.length() > 0) {
            m206 = "";
            if ("".length() == 0) {
                m206 = C0667.m873(f11short, 1, 1, 2356);
            }
        }
        int length = m206.length();
        int length2 = str3.length();
        for (int i13 = 0; i13 < length; i13++) {
            byteArray[i13] = (byte) (byteArray[i13] ^ str3.charAt(i13 % length2));
        }
        for (int i14 = 0; i14 < byteArray.length; i14 = "".length() + 1) {
        }
        return new String(byteArray);
    }

    /* renamed from: ۟ۦ۠ۨۦ, reason: not valid java name and contains not printable characters */
    public static int m394() {
        return (-1749689) ^ C0799.m1158((Object) "ۢۡۥ");
    }

    /* renamed from: ۣۧۤۤ, reason: not valid java name and contains not printable characters */
    public static String m395(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }
}
