package gt.md;

import java.io.ByteArrayOutputStream;

/* renamed from: gt.md.ۣۢ۠ۤ, reason: contains not printable characters */
/* loaded from: classes7.dex */
public class C0799 {

    /* renamed from: ۟ۦۣ۟ۤ, reason: not valid java name and contains not printable characters */
    public static int f74 = 29;

    /* renamed from: ۟ۡۢۢۦ, reason: not valid java name and contains not printable characters */
    public static String m1157(String str) {
        String str2 = "";
        String str3 = "";
        for (int i11 = 0; i11 < 15; i11++) {
            str2 = new StringBuffer().append(str2).append(Integer.toHexString(i11)).toString();
            str3 = new StringBuffer().append(str3).append(((int) (Math.random() * 10)) ^ i11).toString();
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length() / 2);
        while (str.length() > 0) {
            byteArrayOutputStream.write((str2.indexOf(str.charAt(-2)) << 4) | str2.indexOf(str.charAt(-1)));
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        int length2 = str3.length();
        for (int i12 = 0; i12 < length; i12++) {
            byteArray[i12] = (byte) (byteArray[i12] ^ str3.charAt(i12 % length2));
        }
        return new String(byteArray);
    }

    /* renamed from: ۟ۢ۟ۡ۟, reason: not valid java name and contains not printable characters */
    public static int m1158(Object obj) {
        return obj.hashCode();
    }

    /* renamed from: ۟ۢ۟ۡ۟, reason: not valid java name and contains not printable characters */
    public static Class<?> m1159(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    /* renamed from: ۟ۢ۟ۡ۟, reason: not valid java name and contains not printable characters */
    public static String m1160(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }

    /* renamed from: ۣ۟ۤۥۥ, reason: not valid java name and contains not printable characters */
    public static String m1161(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }

    /* renamed from: ۣ۟ۦۦۢ, reason: not valid java name and contains not printable characters */
    public static int m1162() {
        return 1752449 ^ m1158((Object) "ۥ۠ۧ");
    }
}
