package androidx.fragment;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import java.io.ByteArrayOutputStream;
import java.security.MessageDigest;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/* loaded from: classes7.dex */
public class AppCloner {

    /* renamed from: ۟ۤۥۥۡ, reason: not valid java name and contains not printable characters */
    public static boolean f14;

    /* renamed from: ۟۟ۧۨۡ, reason: not valid java name and contains not printable characters */
    public static ApplicationInfo m416(Object obj) {
        if (ShowInject.m464() == 0) {
            return ((Context) obj).getApplicationInfo();
        }
        return null;
    }

    /* renamed from: ۣ۟۠ۢۢ, reason: not valid java name and contains not printable characters */
    public static char m417(Object obj, int i11) {
        if (InjectData.m447() >= 0) {
            return ((String) obj).charAt(i11);
        }
        return (char) 0;
    }

    /* renamed from: ۟ۦ۟ۦۣ, reason: not valid java name and contains not printable characters */
    public static boolean m418(Object obj, Object obj2) {
        if (MethodReplace.m452() > 0) {
            return ((String) obj).equals(obj2);
        }
        return false;
    }

    /* renamed from: ۣ۟ۧ, reason: not valid java name and contains not printable characters */
    public static boolean m420(Object obj, Object obj2) {
        if (AndHook.m397() <= 0) {
            return ((String) obj).startsWith((String) obj2);
        }
        return false;
    }

    /* renamed from: ۟ۧۥ۟۠, reason: not valid java name and contains not printable characters */
    public static ThreadGroup m421(Object obj) {
        if (InjectData.m447() > 0) {
            return ((Thread) obj).getThreadGroup();
        }
        return null;
    }

    /* renamed from: ۠ۢۥۧ, reason: not valid java name and contains not printable characters */
    public static int m422() {
        return 1750827 ^ InjectData.m440((Object) "ۣۧۨ");
    }

    /* renamed from: ۡ۟ۡۤ, reason: not valid java name and contains not printable characters */
    public static Thread m423() {
        if (ShowInject.m464() >= 0) {
            return Thread.currentThread();
        }
        return null;
    }

    /* renamed from: ۡ۠ۦۥ, reason: not valid java name and contains not printable characters */
    public static int m424() {
        if (AndHook.m397() <= 0) {
            return Build.VERSION.SDK_INT;
        }
        return 0;
    }

    /* renamed from: ۢ۟ۢۨ, reason: not valid java name and contains not printable characters */
    public static String m425(Object obj) {
        if (ShowInject.m464() == 0) {
            return ((JarEntry) obj).getName();
        }
        return null;
    }

    /* renamed from: ۢۧۡۡ, reason: not valid java name and contains not printable characters */
    public static String m426(String str) {
        String m403 = AndHook.m403();
        String m4032 = AndHook.m403();
        for (int i11 = 0; i11 < 15; i11++) {
            m403 = AndHook.m411(AndHook.m402(AndHook.m402(new StringBuffer(), m403), InjectData.m444(i11)));
            m4032 = AndHook.m411(InjectData.m450(AndHook.m402(new StringBuffer(), m4032), ((int) (AndHook.m409() * 10)) ^ i11));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(m428(str) / 2);
        while (m428(str) > 0) {
            ShowInject.m457(byteArrayOutputStream, (ShowInject.m459(m403, m417(str, -2)) << 4) | ShowInject.m459(m403, m417(str, -1)));
        }
        byte[] m436 = InjectData.m436(byteArrayOutputStream);
        int length = m436.length;
        int m428 = m428(m4032);
        for (int i12 = 0; i12 < length; i12++) {
            m436[i12] = (byte) (m436[i12] ^ m417(m4032, i12 % m428));
        }
        return new String(m436);
    }

    /* renamed from: ۥۢ۟ۡ, reason: contains not printable characters */
    public static byte[] m427(Object obj) {
        if (ShowInject.m464() >= 0) {
            return ((MessageDigest) obj).digest();
        }
        return null;
    }

    /* renamed from: ۦۢۡۨ, reason: contains not printable characters */
    public static int m428(Object obj) {
        if (ShowInject.m464() == 0) {
            return ((String) obj).length();
        }
        return 0;
    }

    /* renamed from: ۦۣۡۨ, reason: contains not printable characters */
    public static void m429(long j11) {
        if (ShowInject.m464() == 0) {
            Thread.sleep(j11);
        }
    }

    /* renamed from: ۦۤ۟۟, reason: contains not printable characters */
    public static void m430(Object obj, Object obj2) {
        if (AndHook.m397() < 0) {
            ((Handler) obj).removeCallbacksAndMessages(obj2);
        }
    }

    /* renamed from: ۧۤ۟ۢ, reason: not valid java name and contains not printable characters */
    public static MessageDigest m431(Object obj) {
        if (MethodReplace.m452() >= 0) {
            return MessageDigest.getInstance((String) obj);
        }
        return null;
    }

    /* renamed from: ۧۦۡۨ, reason: not valid java name and contains not printable characters */
    public static void m432(Object obj) {
        if (ShowInject.m464() == 0) {
            ((JarFile) obj).close();
        }
    }

    /* renamed from: ۣۨۢ۟, reason: not valid java name and contains not printable characters */
    public static int m433() {
        if (ShowInject.m464() == 0) {
            return Process.myPid();
        }
        return 0;
    }

    /* renamed from: ۟ۦ۠ۦۨ, reason: not valid java name and contains not printable characters */
    public static String m419(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }
}
