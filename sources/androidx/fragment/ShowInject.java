package androidx.fragment;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.jar.JarEntry;

/* loaded from: classes7.dex */
public class ShowInject {

    /* renamed from: ۥۦۡ, reason: contains not printable characters */
    public static int f17 = -75;

    /* renamed from: ۟۟ۦۦۣ, reason: not valid java name and contains not printable characters */
    public static int m454(Object obj, Object obj2, int i11, int i12) {
        if (m464() <= 0) {
            return ((InputStream) obj).read((byte[]) obj2, i11, i12);
        }
        return 0;
    }

    /* renamed from: ۟۠۠۠, reason: not valid java name and contains not printable characters */
    public static void m455(Object obj) {
        if (AndHook.m397() <= 0) {
            ((Thread) obj).start();
        }
    }

    /* renamed from: ۣ۟۠ۤۧ, reason: not valid java name and contains not printable characters */
    public static boolean m456(Object obj) {
        if (m464() == 0) {
            return ((Thread) obj).isDaemon();
        }
        return false;
    }

    /* renamed from: ۟ۡۥۨۢ, reason: not valid java name and contains not printable characters */
    public static void m457(Object obj, int i11) {
        if (InjectData.m447() >= 0) {
            ((ByteArrayOutputStream) obj).write(i11);
        }
    }

    /* renamed from: ۟ۢۦۡۤ, reason: not valid java name and contains not printable characters */
    public static void m458(Object obj, Object obj2) {
        if (m464() == 0) {
            ((MessageDigest) obj).update((byte[]) obj2);
        }
    }

    /* renamed from: ۣ۟ۡۥ۟, reason: not valid java name and contains not printable characters */
    public static int m459(Object obj, int i11) {
        if (InjectData.m447() > 0) {
            return ((String) obj).indexOf(i11);
        }
        return 0;
    }

    /* renamed from: ۟ۤۦۦ۠, reason: not valid java name and contains not printable characters */
    public static void m460(int i11) {
        if (m464() == 0) {
            System.exit(i11);
        }
    }

    /* renamed from: ۠ۤۦ, reason: not valid java name and contains not printable characters */
    public static int m461(Object obj, Object obj2, boolean z10) {
        if (InjectData.m447() > 0) {
            return ((ThreadGroup) obj).enumerate((Thread[]) obj2, z10);
        }
        return 0;
    }

    /* renamed from: ۣۢۨۦ, reason: not valid java name and contains not printable characters */
    public static String m463(String str) {
        String m403 = AndHook.m403();
        String m4032 = AndHook.m403();
        for (int i11 = 0; i11 < 15; i11++) {
            m403 = AndHook.m411(AndHook.m402(AndHook.m402(new StringBuffer(), m403), InjectData.m444(i11)));
            m4032 = AndHook.m411(InjectData.m450(AndHook.m402(new StringBuffer(), m4032), ((int) (AndHook.m409() * 10)) ^ i11));
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(AppCloner.m428(str) / 2);
        for (int i12 = 0; i12 < AppCloner.m428(str); i12 += 2) {
            m457(byteArrayOutputStream, (m459(m403, AppCloner.m417(str, i12)) << 4) | m459(m403, AppCloner.m417(str, i12 + 1)));
        }
        byte[] m436 = InjectData.m436(byteArrayOutputStream);
        int length = m436.length;
        int m428 = AppCloner.m428(m4032);
        while (length > 0) {
            m436[-1] = (byte) (m436[-1] ^ AppCloner.m417(m4032, (-1) % m428));
        }
        for (int i13 = 0; i13 < m436.length; i13 = AppCloner.m428(AndHook.m403()) + 1) {
        }
        return new String(m436);
    }

    /* renamed from: ۣۤ۟ۨ, reason: not valid java name and contains not printable characters */
    public static int m464() {
        return 1752455 ^ InjectData.m440((Object) "ۥ۟ۡ");
    }

    /* renamed from: ۣۧۨ۠, reason: not valid java name and contains not printable characters */
    public static Signature[] m465(Object obj) {
        if (m464() == 0) {
            return ((PackageInfo) obj).signatures;
        }
        return null;
    }

    /* renamed from: ۣۤۦۥ, reason: not valid java name and contains not printable characters */
    public static void m466(Object obj) {
        if (MethodReplace.m452() > 0) {
            ((InputStream) obj).close();
        }
    }

    /* renamed from: ۧۡۤۨ, reason: not valid java name and contains not printable characters */
    public static PackageManager m467(Object obj) {
        if (AndHook.m397() <= 0) {
            return ((Context) obj).getPackageManager();
        }
        return null;
    }

    /* renamed from: ۣۨۧۤ, reason: not valid java name and contains not printable characters */
    public static boolean m468(Object obj) {
        if (MethodReplace.m452() >= 0) {
            return ((JarEntry) obj).isDirectory();
        }
        return false;
    }

    /* renamed from: ۠ۨۧۨ, reason: not valid java name and contains not printable characters */
    public static String m462(short[] sArr, int i11, int i12, int i13) {
        char[] cArr = new char[i12];
        for (int i14 = 0; i14 < i12; i14++) {
            cArr[i14] = (char) (sArr[i11 + i14] ^ i13);
        }
        return new String(cArr);
    }
}
