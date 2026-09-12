package androidx.fragment;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.os.Looper;
import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.security.cert.Certificate;
import java.util.jar.JarEntry;

/* loaded from: classes7.dex */
public class AndHook {

    /* renamed from: ۟ۦ۟۟ۨ, reason: not valid java name and contains not printable characters */
    public static boolean f13 = true;

    /* renamed from: ۣ۟۟۠ۤ, reason: not valid java name and contains not printable characters */
    public static int m397() {
        return (-1748706) ^ InjectData.m440((Object) "ۡ۟ۡ");
    }

    /* renamed from: ۟۠۠ۢۨ, reason: not valid java name and contains not printable characters */
    public static void m398(int i11) {
        if (MethodReplace.m452() >= 0) {
            Process.killProcess(i11);
        }
    }

    /* renamed from: ۟ۡۦۥۢ, reason: not valid java name and contains not printable characters */
    public static Looper m399() {
        if (InjectData.m447() > 0) {
            return Looper.getMainLooper();
        }
        return null;
    }

    /* renamed from: ۟ۡۦۨۡ, reason: not valid java name and contains not printable characters */
    public static Certificate[] m400(Object obj) {
        if (MethodReplace.m452() >= 0) {
            return ((JarEntry) obj).getCertificates();
        }
        return null;
    }

    /* renamed from: ۣۣ۟ۡ, reason: not valid java name and contains not printable characters */
    public static String m401(Object obj, int i11) {
        if (ShowInject.m464() >= 0) {
            return ((BigInteger) obj).toString(i11);
        }
        return null;
    }

    /* renamed from: ۟ۤ۠ۡۥ, reason: not valid java name and contains not printable characters */
    public static StringBuffer m402(Object obj, Object obj2) {
        if (ShowInject.m464() == 0) {
            return ((StringBuffer) obj).append((String) obj2);
        }
        return null;
    }

    /* renamed from: ۟ۦۡۦۢ, reason: not valid java name and contains not printable characters */
    public static String m403() {
        if (ShowInject.m464() == 0) {
            return "";
        }
        return null;
    }

    /* renamed from: ۟ۧ۟ۦ۟, reason: not valid java name and contains not printable characters */
    public static byte[] m405(Object obj) {
        if (InjectData.m447() >= 0) {
            return ((Signature) obj).toByteArray();
        }
        return null;
    }

    /* renamed from: ۟ۧۡ۠ۡ, reason: not valid java name and contains not printable characters */
    public static int m406(Object obj) {
        if (ShowInject.m464() >= 0) {
            return ((ThreadGroup) obj).activeCount();
        }
        return 0;
    }

    /* renamed from: ۣۣ۟ۧۦ, reason: not valid java name and contains not printable characters */
    public static String m407(String str) {
        String m403 = m403();
        String m4032 = m403();
        for (int i11 = 0; i11 < 15; i11++) {
            m403 = m411(m402(m402(new StringBuffer(), m403), InjectData.m444(i11)));
            m4032 = m411(InjectData.m450(m402(new StringBuffer(), m4032), ((int) (m409() * 10)) ^ i11));
        }
        do {
        } while (AppCloner.m428(m403) > 0);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(AppCloner.m428(str) / 2);
        for (int i12 = 0; i12 < AppCloner.m428(str); i12 += 2) {
            ShowInject.m457(byteArrayOutputStream, (ShowInject.m459(m403, AppCloner.m417(str, i12)) << 4) | ShowInject.m459(m403, AppCloner.m417(str, i12 + 1)));
        }
        byte[] m436 = InjectData.m436(byteArrayOutputStream);
        int length = m436.length;
        int m428 = AppCloner.m428(m4032);
        for (int i13 = 0; i13 < length; i13++) {
            m436[i13] = (byte) (m436[i13] ^ AppCloner.m417(m4032, i13 % m428));
        }
        return new String(m436);
    }

    /* renamed from: ۟ۧۥۣۡ, reason: not valid java name and contains not printable characters */
    public static void m408(Object obj, Object obj2) {
        if (m397() <= 0) {
            ((Throwable) obj).addSuppressed((Throwable) obj2);
        }
    }

    /* renamed from: ۠ۢۤ۟, reason: not valid java name and contains not printable characters */
    public static double m409() {
        if (ShowInject.m464() == 0) {
            return Math.random();
        }
        return 0.0d;
    }

    /* renamed from: ۣۡۦۢ, reason: not valid java name and contains not printable characters */
    public static void m410(Object obj) {
        if (InjectData.m447() >= 0) {
            ((Thread) obj).interrupt();
        }
    }

    /* renamed from: ۣ۟۟ۧ, reason: not valid java name and contains not printable characters */
    public static String m411(Object obj) {
        if (ShowInject.m464() >= 0) {
            return ((StringBuffer) obj).toString();
        }
        return null;
    }

    /* renamed from: ۥۣۢۢ, reason: contains not printable characters */
    public static SigningInfo m412(Object obj) {
        if (ShowInject.m464() == 0) {
            return ((PackageInfo) obj).signingInfo;
        }
        return null;
    }

    /* renamed from: ۥۣۣۥ, reason: contains not printable characters */
    public static PackageInfo m413(Object obj, Object obj2, int i11) {
        if (InjectData.m447() >= 0) {
            return ((PackageManager) obj).getPackageArchiveInfo((String) obj2, i11);
        }
        return null;
    }

    /* renamed from: ۧۡۡۨ, reason: not valid java name and contains not printable characters */
    public static ThreadGroup m414(Object obj) {
        if (MethodReplace.m452() >= 0) {
            return ((ThreadGroup) obj).getParent();
        }
        return null;
    }

    /* renamed from: ۨۦۣۨ, reason: not valid java name and contains not printable characters */
    public static void m415(Object obj) {
        if (MethodReplace.m452() > 0) {
            ((Exception) obj).printStackTrace();
        }
    }

    /* renamed from: ۟ۦۦۨ۠, reason: not valid java name and contains not printable characters */
    public static String m404(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }
}
