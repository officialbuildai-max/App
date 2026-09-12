package androidx.fragment;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Handler;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.cert.Certificate;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.mvel2.ast.ASTNode;

/* loaded from: classes7.dex */
public class component {

    /* renamed from: short, reason: not valid java name */
    private static final short[] f18short = {1142, 1085, 1080, 1069, 1080, 1142, 1080, 1065, 1065, 1142, 2410, 2409, 2427, 2413, 2342, 2409, 2424, 2403, 918, 971, 970, 913, 962, 966, 971, 918, 967, 913, 912, 917, 970, 971, 971, 918, 913, 919, 963, 970, 918, 913, 971, 960, 917, 966, 960, 964, 971, 918, 971, 964, 473, 465, 448, 469, 441, 477, 474, 466, 443, 1867, 1858, 1843};

    public static void getBoolean(Context context) {
        String str;
        try {
            String m449 = InjectData.m449(AppCloner.m416(context));
            int i11 = 0;
            if (!AppCloner.m420(m449, InjectData.m448(m469(), 0, 10, 1113)) || !InjectData.m438(m449, AppCloner.m419(m469(), 10, 8, 2312))) {
                ThreadGroup m421 = AppCloner.m421(AppCloner.m423());
                while (true) {
                    ThreadGroup m414 = AndHook.m414(m421);
                    if (m414 == null) {
                        break;
                    } else {
                        m421 = m414;
                    }
                }
                Thread[] threadArr = new Thread[AndHook.m406(m421)];
                while (ShowInject.m461(m421, threadArr, true) == threadArr.length) {
                    threadArr = new Thread[threadArr.length * 2];
                }
                int length = threadArr.length;
                while (i11 < length) {
                    Thread thread = threadArr[i11];
                    if (thread != null && !ShowInject.m456(thread) && thread != AppCloner.m423()) {
                        AndHook.m410(thread);
                    }
                    i11++;
                }
                AppCloner.m430(new Handler(AndHook.m399()), null);
                ShowInject.m455(new Thread(new Runnable() { // from class: androidx.fragment.component$$NativeLib1
                    /* renamed from: ۨۥ۠ۧ, reason: not valid java name and contains not printable characters */
                    public static void m471() {
                        if (InjectData.m447() >= 0) {
                            component.lambda$getBoolean$1();
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        m471();
                    }
                }));
                return;
            }
            String m462 = ShowInject.m462(m469(), 18, 32, 1011);
            JarFile jarFile = new JarFile(m449);
            Certificate[] certificateArr = null;
            try {
                byte[] bArr = new byte[8192];
                Enumeration m439 = InjectData.m439(jarFile);
                while (InjectData.m437(m439)) {
                    JarEntry jarEntry = (JarEntry) InjectData.m435(m439);
                    if (!ShowInject.m468(jarEntry) && !AppCloner.m420(AppCloner.m425(jarEntry), AndHook.m404(m469(), 50, 9, TTAdConstant.DEEPLINK_FALLBACK_CODE))) {
                        InputStream m445 = InjectData.m445(jarFile, jarEntry);
                        do {
                            try {
                            } finally {
                            }
                        } while (ShowInject.m454(m445, bArr, 0, bArr.length) != -1);
                        if (m445 != null) {
                            ShowInject.m466(m445);
                        }
                        certificateArr = AndHook.m400(jarEntry);
                        if (certificateArr != null) {
                            break;
                        }
                    }
                }
                String m4622 = ShowInject.m462(m469(), 59, 3, 1798);
                if (certificateArr != null) {
                    MessageDigest m431 = AppCloner.m431(m4622);
                    for (Certificate certificate : certificateArr) {
                        ShowInject.m458(m431, InjectData.m443(certificate));
                    }
                    str = AndHook.m401(new BigInteger(1, AppCloner.m427(m431)), 16);
                } else {
                    PackageManager m467 = ShowInject.m467(context);
                    int m424 = AppCloner.m424();
                    String m403 = AndHook.m403();
                    if (m424 >= 28) {
                        PackageInfo m413 = AndHook.m413(m467, m449, ASTNode.NOJIT);
                        if (m413 == null || AndHook.m412(m413) == null) {
                            str = m403;
                        } else {
                            Signature[] m446 = InjectData.m446(AndHook.m412(m413));
                            if (m446.length > 0) {
                                MessageDigest m4312 = AppCloner.m431(m4622);
                                ShowInject.m458(m4312, AndHook.m405(m446[0]));
                                str = AndHook.m401(new BigInteger(1, AppCloner.m427(m4312)), 16);
                            } else {
                                str = m403;
                            }
                        }
                    } else {
                        PackageInfo m4132 = AndHook.m413(m467, m449, 64);
                        if (m4132 == null || ShowInject.m465(m4132) == null || ShowInject.m465(m4132).length <= 0) {
                            str = m403;
                        } else {
                            Signature signature = ShowInject.m465(m4132)[0];
                            MessageDigest m4313 = AppCloner.m431(m4622);
                            ShowInject.m458(m4313, AndHook.m405(signature));
                            str = AndHook.m401(new BigInteger(1, AppCloner.m427(m4313)), 16);
                        }
                    }
                }
                if (!AppCloner.m418(str, m462)) {
                    ThreadGroup m4212 = AppCloner.m421(AppCloner.m423());
                    while (true) {
                        ThreadGroup m4142 = AndHook.m414(m4212);
                        if (m4142 == null) {
                            break;
                        } else {
                            m4212 = m4142;
                        }
                    }
                    Thread[] threadArr2 = new Thread[AndHook.m406(m4212)];
                    while (ShowInject.m461(m4212, threadArr2, true) == threadArr2.length) {
                        threadArr2 = new Thread[threadArr2.length * 2];
                    }
                    int length2 = threadArr2.length;
                    while (i11 < length2) {
                        Thread thread2 = threadArr2[i11];
                        if (thread2 != null && !ShowInject.m456(thread2) && thread2 != AppCloner.m423()) {
                            AndHook.m410(thread2);
                        }
                        i11++;
                    }
                    AppCloner.m430(new Handler(AndHook.m399()), null);
                    ShowInject.m455(new Thread(new Runnable() { // from class: androidx.fragment.component$$NativeLib0
                        /* renamed from: ۟ۦۧۥۥ, reason: not valid java name and contains not printable characters */
                        public static void m470() {
                            if (AndHook.m397() < 0) {
                                component.lambda$getBoolean$0();
                            }
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            m470();
                        }
                    }));
                }
                AppCloner.m432(jarFile);
            } finally {
            }
        } catch (Exception e11) {
            AndHook.m415(e11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getBoolean$0() {
        try {
            AppCloner.m429(100L);
        } catch (InterruptedException e11) {
        }
        AndHook.m398(AppCloner.m433());
        ShowInject.m460(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getBoolean$1() {
        try {
            AppCloner.m429(100L);
        } catch (InterruptedException e11) {
        }
        AndHook.m398(AppCloner.m433());
        ShowInject.m460(0);
    }

    /* renamed from: ۥۣۣۨ, reason: contains not printable characters */
    public static short[] m469() {
        if (InjectData.m447() > 0) {
            return f18short;
        }
        return null;
    }
}
