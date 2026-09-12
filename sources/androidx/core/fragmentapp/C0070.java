package androidx.core.fragmentapp;

import androidx.core.C0077;
import androidx.core.appcompat.C0067;
import androidx.core.appcompat.C0068;
import java.io.ByteArrayOutputStream;

/* renamed from: androidx.core.fragmentapp.۟۠ۦۥ, reason: contains not printable characters */
/* loaded from: classes7.dex */
public class C0070 {

    /* renamed from: ۧۢۨۦ, reason: collision with root package name */
    public static boolean f8219 = true;

    /* renamed from: ۠ۧۡۦ, reason: not valid java name and contains not printable characters */
    public static String m295(String str) {
        String m241 = C0067.m241();
        String m2412 = C0067.m241();
        for (int i11 = 0; i11 < 15; i11++) {
            m241 = C0068.m250(C0071.m308(C0071.m308(new StringBuffer(), m241), C0067.m221(i11)));
            m2412 = C0068.m250(C0067.m228(C0071.m308(new StringBuffer(), m2412), ((int) (C0077.m353() * 10)) ^ i11));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(C0077.m375(str) / 2);
        while (C0077.m375(str) > 0) {
            C0077.m385(byteArrayOutputStream, (C0067.m236(m241, C0068.m292(str, -2)) << 4) | C0067.m236(m241, C0068.m292(str, -1)));
        }
        byte[] m231 = C0067.m231(byteArrayOutputStream);
        int length = m231.length;
        int m375 = C0077.m375(m2412);
        for (int i12 = 0; i12 < length; i12++) {
            m231[i12] = (byte) (m231[i12] ^ C0068.m292(m2412, i12 % m375));
        }
        return new String(m231);
    }

    /* renamed from: ۥۧ۟۟, reason: contains not printable characters */
    public static int m297() {
        return (-1748861) ^ C0068.m288((Object) "ۡۦ۟");
    }

    /* renamed from: ۤۢۥ۟, reason: not valid java name and contains not printable characters */
    public static String m296(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }
}
