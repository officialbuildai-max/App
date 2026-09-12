package com.mbridge.msdk.thrid.okhttp.internal;

import android.support.v4.media.session.PlaybackStateCompat;
import com.mbridge.msdk.thrid.okhttp.p;
import com.mbridge.msdk.thrid.okhttp.q;
import com.mbridge.msdk.thrid.okhttp.x;
import com.mbridge.msdk.thrid.okhttp.z;
import com.mbridge.msdk.thrid.okio.f;
import com.mbridge.msdk.thrid.okio.s;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes5.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f37955a;

    /* renamed from: c, reason: collision with root package name */
    public static final z f37957c;

    /* renamed from: d, reason: collision with root package name */
    public static final x f37958d;

    /* renamed from: r, reason: collision with root package name */
    private static final Method f37972r;

    /* renamed from: s, reason: collision with root package name */
    private static final Pattern f37973s;

    /* renamed from: b, reason: collision with root package name */
    public static final String[] f37956b = new String[0];

    /* renamed from: e, reason: collision with root package name */
    private static final f f37959e = f.a("efbbbf");

    /* renamed from: f, reason: collision with root package name */
    private static final f f37960f = f.a("feff");

    /* renamed from: g, reason: collision with root package name */
    private static final f f37961g = f.a("fffe");

    /* renamed from: h, reason: collision with root package name */
    private static final f f37962h = f.a("0000ffff");

    /* renamed from: i, reason: collision with root package name */
    private static final f f37963i = f.a("ffff0000");

    /* renamed from: j, reason: collision with root package name */
    public static final Charset f37964j = Charset.forName("UTF-8");

    /* renamed from: k, reason: collision with root package name */
    public static final Charset f37965k = Charset.forName("ISO-8859-1");

    /* renamed from: l, reason: collision with root package name */
    private static final Charset f37966l = Charset.forName("UTF-16BE");

    /* renamed from: m, reason: collision with root package name */
    private static final Charset f37967m = Charset.forName("UTF-16LE");

    /* renamed from: n, reason: collision with root package name */
    private static final Charset f37968n = Charset.forName("UTF-32BE");

    /* renamed from: o, reason: collision with root package name */
    private static final Charset f37969o = Charset.forName("UTF-32LE");

    /* renamed from: p, reason: collision with root package name */
    public static final TimeZone f37970p = TimeZone.getTimeZone("GMT");

    /* renamed from: q, reason: collision with root package name */
    public static final Comparator<String> f37971q = new a();

    /* loaded from: classes5.dex */
    static class a implements Comparator<String> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class b implements ThreadFactory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f37974a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f37975b;

        b(String str, boolean z10) {
            this.f37974a = str;
            this.f37975b = z10;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f37974a);
            thread.setDaemon(this.f37975b);
            return thread;
        }
    }

    static {
        byte[] bArr = new byte[0];
        f37955a = bArr;
        Method method = null;
        f37957c = z.a(null, bArr);
        f37958d = x.a(null, bArr);
        try {
            method = Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class);
        } catch (Exception unused) {
        }
        f37972r = method;
        f37973s = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static int a(char c11) {
        if (c11 >= '0' && c11 <= '9') {
            return c11 - '0';
        }
        if (c11 >= 'a' && c11 <= 'f') {
            return c11 - 'W';
        }
        if (c11 < 'A' || c11 > 'F') {
            return -1;
        }
        return c11 - '7';
    }

    public static int a(String str, int i11, int i12, char c11) {
        while (i11 < i12) {
            if (str.charAt(i11) == c11) {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    public static int a(String str, int i11, int i12, String str2) {
        while (i11 < i12) {
            if (str2.indexOf(str.charAt(i11)) != -1) {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    public static int a(String str, long j11, TimeUnit timeUnit) {
        if (j11 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        long millis = timeUnit.toMillis(j11);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str + " too large.");
        }
        if (millis != 0 || j11 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str + " too small.");
    }

    public static int a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (comparator.compare(strArr[i11], str) == 0) {
                return i11;
            }
        }
        return -1;
    }

    public static AssertionError a(String str, Exception exc) {
        AssertionError assertionError = new AssertionError(str);
        try {
            assertionError.initCause(exc);
        } catch (IllegalStateException unused) {
        }
        return assertionError;
    }

    public static String a(q qVar, boolean z10) {
        String g11;
        if (qVar.g().contains(":")) {
            g11 = "[" + qVar.g() + "]";
        } else {
            g11 = qVar.g();
        }
        if (!z10 && qVar.j() == q.a(qVar.l())) {
            return g11;
        }
        return g11 + ":" + qVar.j();
    }

    public static String a(String str) {
        if (!str.contains(":")) {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (lowerCase.isEmpty()) {
                    return null;
                }
                if (b(lowerCase)) {
                    return null;
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress a11 = (str.startsWith("[") && str.endsWith("]")) ? a(str, 1, str.length() - 1) : a(str, 0, str.length());
        if (a11 == null) {
            return null;
        }
        byte[] address = a11.getAddress();
        if (address.length == 16) {
            return a(address);
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + "'");
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private static String a(byte[] bArr) {
        int i11 = -1;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        while (i13 < bArr.length) {
            int i15 = i13;
            while (i15 < 16 && bArr[i15] == 0 && bArr[i15 + 1] == 0) {
                i15 += 2;
            }
            int i16 = i15 - i13;
            if (i16 > i14 && i16 >= 4) {
                i11 = i13;
                i14 = i16;
            }
            i13 = i15 + 2;
        }
        com.mbridge.msdk.thrid.okio.c cVar = new com.mbridge.msdk.thrid.okio.c();
        while (i12 < bArr.length) {
            if (i12 == i11) {
                cVar.writeByte(58);
                i12 += i14;
                if (i12 == 16) {
                    cVar.writeByte(58);
                }
            } else {
                if (i12 > 0) {
                    cVar.writeByte(58);
                }
                cVar.a(((bArr[i12] & 255) << 8) | (bArr[i12 + 1] & 255));
                i12 += 2;
            }
        }
        return cVar.p();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0078, code lost:
    
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.net.InetAddress a(java.lang.String r12, int r13, int r14) {
        /*
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = 0
            r3 = -1
            r4 = r2
            r5 = r3
            r6 = r5
        L9:
            r7 = 0
            if (r13 >= r14) goto L79
            if (r4 != r0) goto Lf
            return r7
        Lf:
            int r8 = r13 + 2
            r9 = 2
            if (r8 > r14) goto L27
            java.lang.String r10 = "::"
            boolean r10 = r12.regionMatches(r13, r10, r2, r9)
            if (r10 == 0) goto L27
            if (r5 == r3) goto L1f
            return r7
        L1f:
            int r4 = r4 + 2
            r5 = r4
            if (r8 != r14) goto L25
            goto L79
        L25:
            r6 = r8
            goto L4b
        L27:
            if (r4 == 0) goto L34
            java.lang.String r8 = ":"
            r10 = 1
            boolean r8 = r12.regionMatches(r13, r8, r2, r10)
            if (r8 == 0) goto L36
            int r13 = r13 + 1
        L34:
            r6 = r13
            goto L4b
        L36:
            java.lang.String r8 = "."
            boolean r13 = r12.regionMatches(r13, r8, r2, r10)
            if (r13 == 0) goto L4a
            int r13 = r4 + (-2)
            boolean r12 = a(r12, r6, r14, r1, r13)
            if (r12 != 0) goto L47
            return r7
        L47:
            int r4 = r4 + 2
            goto L79
        L4a:
            return r7
        L4b:
            r8 = r2
            r13 = r6
        L4d:
            if (r13 >= r14) goto L60
            char r10 = r12.charAt(r13)
            int r10 = a(r10)
            if (r10 != r3) goto L5a
            goto L60
        L5a:
            int r8 = r8 << 4
            int r8 = r8 + r10
            int r13 = r13 + 1
            goto L4d
        L60:
            int r10 = r13 - r6
            if (r10 == 0) goto L78
            r11 = 4
            if (r10 <= r11) goto L68
            goto L78
        L68:
            int r7 = r4 + 1
            int r10 = r8 >>> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r10
            r1[r4] = r10
            int r4 = r4 + r9
            r8 = r8 & 255(0xff, float:3.57E-43)
            byte r8 = (byte) r8
            r1[r7] = r8
            goto L9
        L78:
            return r7
        L79:
            if (r4 == r0) goto L8a
            if (r5 != r3) goto L7e
            return r7
        L7e:
            int r12 = r4 - r5
            int r13 = 16 - r12
            java.lang.System.arraycopy(r1, r5, r1, r13, r12)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r2)
        L8a:
            java.net.InetAddress r12 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L8f
            return r12
        L8f:
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.c.a(java.lang.String, int, int):java.net.InetAddress");
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static <K, V> Map<K, V> a(Map<K, V> map) {
        return map.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(new LinkedHashMap(map));
    }

    public static ThreadFactory a(String str, boolean z10) {
        return new b(str, z10);
    }

    public static X509TrustManager a() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1) {
                TrustManager trustManager = trustManagers[0];
                if (trustManager instanceof X509TrustManager) {
                    return (X509TrustManager) trustManager;
                }
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e11) {
            throw a("No System TLS", (Exception) e11);
        }
    }

    public static void a(long j11, long j12, long j13) {
        if ((j12 | j13) < 0 || j12 > j11 || j11 - j12 < j13) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e11) {
                throw e11;
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Throwable th2, Throwable th3) {
        Method method = f37972r;
        if (method != null) {
            try {
                method.invoke(th2, th3);
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e11) {
                if (!a(e11)) {
                    throw e11;
                }
            } catch (RuntimeException e12) {
                if (!"bio == null".equals(e12.getMessage())) {
                    throw e12;
                }
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(s sVar, int i11, TimeUnit timeUnit) {
        try {
            return b(sVar, i11, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private static boolean a(String str, int i11, int i12, byte[] bArr, int i13) {
        int i14 = i13;
        while (i11 < i12) {
            if (i14 == bArr.length) {
                return false;
            }
            if (i14 != i13) {
                if (str.charAt(i11) != '.') {
                    return false;
                }
                i11++;
            }
            int i15 = i11;
            int i16 = 0;
            while (i15 < i12) {
                char charAt = str.charAt(i15);
                if (charAt < '0' || charAt > '9') {
                    break;
                }
                if ((i16 == 0 && i11 != i15) || (i16 = ((i16 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i15++;
            }
            if (i15 - i11 == 0) {
                return false;
            }
            bArr[i14] = (byte) i16;
            i14++;
            i11 = i15;
        }
        return i14 == i13 + 4;
    }

    public static String[] a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i11]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i11++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] a(String[] strArr, String str) {
        int length = strArr.length;
        String[] strArr2 = new String[length + 1];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length] = str;
        return strArr2;
    }

    public static int b(String str, int i11, int i12) {
        while (i11 < i12) {
            char charAt = str.charAt(i11);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i11;
            }
            i11++;
        }
        return i12;
    }

    public static p b(List<com.mbridge.msdk.thrid.okhttp.internal.http2.c> list) {
        p.a aVar = new p.a();
        for (com.mbridge.msdk.thrid.okhttp.internal.http2.c cVar : list) {
            com.mbridge.msdk.thrid.okhttp.internal.a.f37953a.a(aVar, cVar.f38113a.h(), cVar.f38114b.h());
        }
        return aVar.a();
    }

    public static boolean b(s sVar, int i11, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long c11 = sVar.b().d() ? sVar.b().c() - nanoTime : Long.MAX_VALUE;
        sVar.b().a(Math.min(c11, timeUnit.toNanos(i11)) + nanoTime);
        try {
            com.mbridge.msdk.thrid.okio.c cVar = new com.mbridge.msdk.thrid.okio.c();
            while (sVar.b(cVar, PlaybackStateCompat.ACTION_PLAY_FROM_URI) != -1) {
                cVar.k();
            }
            if (c11 == Long.MAX_VALUE) {
                sVar.b().a();
                return true;
            }
            sVar.b().a(nanoTime + c11);
            return true;
        } catch (InterruptedIOException unused) {
            if (c11 == Long.MAX_VALUE) {
                sVar.b().a();
                return false;
            }
            sVar.b().a(nanoTime + c11);
            return false;
        } catch (Throwable th2) {
            if (c11 == Long.MAX_VALUE) {
                sVar.b().a();
            } else {
                sVar.b().a(nanoTime + c11);
            }
            throw th2;
        }
    }

    private static boolean b(String str) {
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr2 != null && strArr.length != 0 && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int c(String str) {
        int length = str.length();
        for (int i11 = 0; i11 < length; i11++) {
            char charAt = str.charAt(i11);
            if (charAt <= 31 || charAt >= 127) {
                return i11;
            }
        }
        return -1;
    }

    public static int c(String str, int i11, int i12) {
        for (int i13 = i12 - 1; i13 >= i11; i13--) {
            char charAt = str.charAt(i13);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i13 + 1;
            }
        }
        return i11;
    }

    public static String d(String str, int i11, int i12) {
        int b11 = b(str, i11, i12);
        return str.substring(b11, c(str, b11, i12));
    }

    public static boolean d(String str) {
        return f37973s.matcher(str).matches();
    }
}
