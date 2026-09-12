package androidx.fragment;

import android.content.pm.ApplicationInfo;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/* loaded from: classes7.dex */
public class InjectData {

    /* renamed from: ۟ۤۨۡ, reason: not valid java name and contains not printable characters */
    public static int f15 = -47;

    /* renamed from: ۟۠ۤۧ۠, reason: not valid java name and contains not printable characters */
    public static String m434(String str) {
        String m403 = AndHook.m403();
        String m4032 = AndHook.m403();
        for (int i11 = 0; i11 < 15; i11++) {
            m403 = AndHook.m411(AndHook.m402(AndHook.m402(new StringBuffer(), m403), m444(i11)));
            m4032 = AndHook.m411(m450(AndHook.m402(new StringBuffer(), m4032), ((int) (AndHook.m409() * 10)) ^ i11));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(AppCloner.m428(str) / 2);
        for (int i12 = 0; i12 < AppCloner.m428(str); i12 += 2) {
            ShowInject.m457(byteArrayOutputStream, (ShowInject.m459(m403, AppCloner.m417(str, i12)) << 4) | ShowInject.m459(m403, AppCloner.m417(str, i12 + 1)));
        }
        byte[] m436 = m436(byteArrayOutputStream);
        int length = m436.length;
        int m428 = AppCloner.m428(m4032);
        while (length > 0) {
            m436[-1] = (byte) (m436[-1] ^ AppCloner.m417(m4032, (-1) % m428));
        }
        for (int i13 = 0; i13 < m436.length; i13 = AppCloner.m428(AndHook.m403()) + 1) {
        }
        return new String(m436);
    }

    /* renamed from: ۟۠ۦۢۥ, reason: not valid java name and contains not printable characters */
    public static Object m435(Object obj) {
        if (AndHook.m397() < 0) {
            return ((Enumeration) obj).nextElement();
        }
        return null;
    }

    /* renamed from: ۟ۡۥۦۤ, reason: not valid java name and contains not printable characters */
    public static byte[] m436(Object obj) {
        if (ShowInject.m464() == 0) {
            return ((ByteArrayOutputStream) obj).toByteArray();
        }
        return null;
    }

    /* renamed from: ۟ۤۡ۟ۧ, reason: not valid java name and contains not printable characters */
    public static boolean m437(Object obj) {
        if (MethodReplace.m452() >= 0) {
            return ((Enumeration) obj).hasMoreElements();
        }
        return false;
    }

    /* renamed from: ۟ۨۥۨ, reason: not valid java name and contains not printable characters */
    public static boolean m438(Object obj, Object obj2) {
        if (AndHook.m397() <= 0) {
            return ((String) obj).endsWith((String) obj2);
        }
        return false;
    }

    /* renamed from: ۠۠ۧۤ, reason: not valid java name and contains not printable characters */
    public static Enumeration m439(Object obj) {
        if (m447() > 0) {
            return ((JarFile) obj).entries();
        }
        return null;
    }

    /* renamed from: ۠ۤۡۥ, reason: not valid java name and contains not printable characters */
    public static int m440(Object obj) {
        return obj.hashCode();
    }

    /* renamed from: ۢۢۧۤ, reason: not valid java name and contains not printable characters */
    public static byte[] m443(Object obj) {
        if (m447() >= 0) {
            return ((Certificate) obj).getEncoded();
        }
        return null;
    }

    /* renamed from: ۢۤۡۡ, reason: not valid java name and contains not printable characters */
    public static String m444(int i11) {
        if (MethodReplace.m452() > 0) {
            return Integer.toHexString(i11);
        }
        return null;
    }

    /* renamed from: ۣۢۧ۟, reason: not valid java name and contains not printable characters */
    public static InputStream m445(Object obj, Object obj2) {
        if (AndHook.m397() <= 0) {
            return ((JarFile) obj).getInputStream((ZipEntry) obj2);
        }
        return null;
    }

    /* renamed from: ۣۣۣۥ, reason: not valid java name and contains not printable characters */
    public static Signature[] m446(Object obj) {
        if (AndHook.m397() < 0) {
            return ((SigningInfo) obj).getApkContentsSigners();
        }
        return null;
    }

    /* renamed from: ۤۤۢۨ, reason: not valid java name and contains not printable characters */
    public static int m447() {
        return 1748744 ^ m440((Object) "ۡۦۣ");
    }

    /* renamed from: ۥۨۡ, reason: contains not printable characters */
    public static String m449(Object obj) {
        if (m447() > 0) {
            return ((ApplicationInfo) obj).sourceDir;
        }
        return null;
    }

    /* renamed from: ۣۧ۟ۦ, reason: not valid java name and contains not printable characters */
    public static StringBuffer m450(Object obj, int i11) {
        if (MethodReplace.m452() >= 0) {
            return ((StringBuffer) obj).append(i11);
        }
        return null;
    }

    /* renamed from: ۠ۤۡۥ, reason: not valid java name and contains not printable characters */
    public static Class<?> m441(String str) throws ClassNotFoundException {
        return Class.forName(str);
    }

    /* renamed from: ۠ۤۡۥ, reason: not valid java name and contains not printable characters */
    public static String m442(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }

    /* renamed from: ۥۡۦۡ, reason: contains not printable characters */
    public static String m448(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }
}
