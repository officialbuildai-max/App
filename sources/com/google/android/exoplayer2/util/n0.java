package com.google.android.exoplayer2.util;

import android.net.Uri;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public abstract class n0 {
    private static int[] a(String str) {
        int i11;
        int[] iArr = new int[4];
        if (TextUtils.isEmpty(str)) {
            iArr[0] = -1;
            return iArr;
        }
        int length = str.length();
        int indexOf = str.indexOf(35);
        if (indexOf != -1) {
            length = indexOf;
        }
        int indexOf2 = str.indexOf(63);
        if (indexOf2 == -1 || indexOf2 > length) {
            indexOf2 = length;
        }
        int indexOf3 = str.indexOf(47);
        if (indexOf3 == -1 || indexOf3 > indexOf2) {
            indexOf3 = indexOf2;
        }
        int indexOf4 = str.indexOf(58);
        if (indexOf4 > indexOf3) {
            indexOf4 = -1;
        }
        int i12 = indexOf4 + 2;
        if (i12 < indexOf2 && str.charAt(indexOf4 + 1) == '/' && str.charAt(i12) == '/') {
            i11 = str.indexOf(47, indexOf4 + 3);
            if (i11 == -1 || i11 > indexOf2) {
                i11 = indexOf2;
            }
        } else {
            i11 = indexOf4 + 1;
        }
        iArr[0] = indexOf4;
        iArr[1] = i11;
        iArr[2] = indexOf2;
        iArr[3] = length;
        return iArr;
    }

    public static boolean b(String str) {
        return (str == null || a(str)[0] == -1) ? false : true;
    }

    private static String c(StringBuilder sb2, int i11, int i12) {
        int i13;
        int i14;
        if (i11 >= i12) {
            return sb2.toString();
        }
        if (sb2.charAt(i11) == '/') {
            i11++;
        }
        int i15 = i11;
        int i16 = i15;
        while (i15 <= i12) {
            if (i15 == i12) {
                i13 = i15;
            } else if (sb2.charAt(i15) == '/') {
                i13 = i15 + 1;
            } else {
                i15++;
            }
            int i17 = i16 + 1;
            if (i15 == i17 && sb2.charAt(i16) == '.') {
                sb2.delete(i16, i13);
                i12 -= i13 - i16;
            } else {
                if (i15 == i16 + 2 && sb2.charAt(i16) == '.' && sb2.charAt(i17) == '.') {
                    i14 = sb2.lastIndexOf("/", i16 - 2) + 1;
                    int i18 = i14 > i11 ? i14 : i11;
                    sb2.delete(i18, i13);
                    i12 -= i13 - i18;
                } else {
                    i14 = i15 + 1;
                }
                i16 = i14;
            }
            i15 = i16;
        }
        return sb2.toString();
    }

    public static String d(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        int[] a11 = a(str2);
        if (a11[0] != -1) {
            sb2.append(str2);
            c(sb2, a11[1], a11[2]);
            return sb2.toString();
        }
        int[] a12 = a(str);
        if (a11[3] == 0) {
            sb2.append((CharSequence) str, 0, a12[3]);
            sb2.append(str2);
            return sb2.toString();
        }
        if (a11[2] == 0) {
            sb2.append((CharSequence) str, 0, a12[2]);
            sb2.append(str2);
            return sb2.toString();
        }
        int i11 = a11[1];
        if (i11 != 0) {
            int i12 = a12[0] + 1;
            sb2.append((CharSequence) str, 0, i12);
            sb2.append(str2);
            return c(sb2, a11[1] + i12, i12 + a11[2]);
        }
        if (str2.charAt(i11) == '/') {
            sb2.append((CharSequence) str, 0, a12[1]);
            sb2.append(str2);
            int i13 = a12[1];
            return c(sb2, i13, a11[2] + i13);
        }
        int i14 = a12[0] + 2;
        int i15 = a12[1];
        if (i14 >= i15 || i15 != a12[2]) {
            int lastIndexOf = str.lastIndexOf(47, a12[2] - 1);
            int i16 = lastIndexOf == -1 ? a12[1] : lastIndexOf + 1;
            sb2.append((CharSequence) str, 0, i16);
            sb2.append(str2);
            return c(sb2, a12[1], i16 + a11[2]);
        }
        sb2.append((CharSequence) str, 0, i15);
        sb2.append('/');
        sb2.append(str2);
        int i17 = a12[1];
        return c(sb2, i17, a11[2] + i17 + 1);
    }

    public static Uri e(String str, String str2) {
        return Uri.parse(d(str, str2));
    }
}
