package androidx.media3.exoplayer.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import androidx.media3.common.util.a1;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class x {

    /* loaded from: classes2.dex */
    private static final class a {
        public static boolean a(Throwable th2) {
            return th2 instanceof MediaDrmResetException;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(4:11|12|13|(2:15|16)(2:17|18)) */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        r1 = c(r11, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
    
        if (r1 != null) goto L14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        r8 = r8 + 1;
        r9 = r9.a().j(r1).a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0051, code lost:
    
        throw r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0036, code lost:
    
        r8 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0052, code lost:
    
        androidx.media3.common.util.a1.m(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0055, code lost:
    
        throw r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] a(androidx.media3.datasource.a r8, java.lang.String r9, byte[] r10, java.util.Map r11) {
        /*
            w1.l r0 = new w1.l
            r0.<init>(r8)
            w1.h$b r8 = new w1.h$b
            r8.<init>()
            w1.h$b r8 = r8.j(r9)
            w1.h$b r8 = r8.e(r11)
            r9 = 2
            w1.h$b r8 = r8.d(r9)
            w1.h$b r8 = r8.c(r10)
            r9 = 1
            w1.h$b r8 = r8.b(r9)
            w1.h r2 = r8.a()
            r8 = 0
            r9 = r2
        L26:
            w1.f r10 = new w1.f     // Catch: java.lang.Exception -> L33
            r10.<init>(r0, r9)     // Catch: java.lang.Exception -> L33
            byte[] r8 = com.google.common.io.a.b(r10)     // Catch: java.lang.Throwable -> L36 androidx.media3.datasource.HttpDataSource.InvalidResponseCodeException -> L38
            androidx.media3.common.util.a1.m(r10)     // Catch: java.lang.Exception -> L33
            return r8
        L33:
            r8 = move-exception
            r7 = r8
            goto L56
        L36:
            r8 = move-exception
            goto L52
        L38:
            r11 = move-exception
            java.lang.String r1 = c(r11, r8)     // Catch: java.lang.Throwable -> L36
            if (r1 == 0) goto L51
            int r8 = r8 + 1
            w1.h$b r9 = r9.a()     // Catch: java.lang.Throwable -> L36
            w1.h$b r9 = r9.j(r1)     // Catch: java.lang.Throwable -> L36
            w1.h r9 = r9.a()     // Catch: java.lang.Throwable -> L36
            androidx.media3.common.util.a1.m(r10)     // Catch: java.lang.Exception -> L33
            goto L26
        L51:
            throw r11     // Catch: java.lang.Throwable -> L36
        L52:
            androidx.media3.common.util.a1.m(r10)     // Catch: java.lang.Exception -> L33
            throw r8     // Catch: java.lang.Exception -> L33
        L56:
            androidx.media3.exoplayer.drm.MediaDrmCallbackException r8 = new androidx.media3.exoplayer.drm.MediaDrmCallbackException
            android.net.Uri r3 = r0.e()
            java.util.Map r4 = r0.getResponseHeaders()
            long r5 = r0.d()
            r1 = r8
            r1.<init>(r2, r3, r4, r5, r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.drm.x.a(androidx.media3.datasource.a, java.lang.String, byte[], java.util.Map):byte[]");
    }

    public static int b(Throwable th2, int i11) {
        if (th2 instanceof MediaDrm.MediaDrmStateException) {
            return a1.b0(a1.c0(((MediaDrm.MediaDrmStateException) th2).getDiagnosticInfo()));
        }
        if (a1.f10432a >= 23 && a.a(th2)) {
            return 6006;
        }
        if ((th2 instanceof NotProvisionedException) || d(th2)) {
            return 6002;
        }
        if (th2 instanceof DeniedByServerException) {
            return 6007;
        }
        if (th2 instanceof UnsupportedDrmException) {
            return 6001;
        }
        if (th2 instanceof DefaultDrmSessionManager.MissingSchemeDataException) {
            return 6003;
        }
        if (th2 instanceof KeysExpiredException) {
            return 6008;
        }
        if (i11 == 1) {
            return 6006;
        }
        if (i11 == 2) {
            return 6004;
        }
        if (i11 == 3) {
            return 6002;
        }
        throw new IllegalArgumentException();
    }

    private static String c(HttpDataSource.InvalidResponseCodeException invalidResponseCodeException, int i11) {
        Map<String, List<String>> map;
        List<String> list;
        int i12 = invalidResponseCodeException.responseCode;
        if ((i12 != 307 && i12 != 308) || i11 >= 5 || (map = invalidResponseCodeException.headerFields) == null || (list = map.get(HttpHeaders.LOCATION)) == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public static boolean d(Throwable th2) {
        return a1.f10432a == 34 && (th2 instanceof NoSuchMethodError) && th2.getMessage() != null && th2.getMessage().contains("Landroid/media/NotProvisionedException;.<init>(");
    }

    public static boolean e(Throwable th2) {
        return a1.f10432a == 34 && (th2 instanceof NoSuchMethodError) && th2.getMessage() != null && th2.getMessage().contains("Landroid/media/ResourceBusyException;.<init>(");
    }
}
