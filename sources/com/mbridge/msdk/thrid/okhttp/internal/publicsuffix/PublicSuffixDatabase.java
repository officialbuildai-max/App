package com.mbridge.msdk.thrid.okhttp.internal.publicsuffix;

import com.mbridge.msdk.thrid.okhttp.internal.c;
import com.mbridge.msdk.thrid.okhttp.internal.platform.g;
import com.mbridge.msdk.thrid.okio.e;
import com.mbridge.msdk.thrid.okio.j;
import com.mbridge.msdk.thrid.okio.l;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes5.dex */
public final class PublicSuffixDatabase {

    /* renamed from: e, reason: collision with root package name */
    private static final byte[] f38302e = {42};

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f38303f = new String[0];

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f38304g = {"*"};

    /* renamed from: h, reason: collision with root package name */
    private static final PublicSuffixDatabase f38305h = new PublicSuffixDatabase();

    /* renamed from: a, reason: collision with root package name */
    private final AtomicBoolean f38306a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    private final CountDownLatch f38307b = new CountDownLatch(1);

    /* renamed from: c, reason: collision with root package name */
    private byte[] f38308c;

    /* renamed from: d, reason: collision with root package name */
    private byte[] f38309d;

    public static PublicSuffixDatabase a() {
        return f38305h;
    }

    private static String a(byte[] bArr, byte[][] bArr2, int i11) {
        int i12;
        boolean z10;
        int i13;
        int i14;
        int length = bArr.length;
        int i15 = 0;
        while (i15 < length) {
            int i16 = (i15 + length) / 2;
            while (i16 > -1 && bArr[i16] != 10) {
                i16--;
            }
            int i17 = i16 + 1;
            int i18 = 1;
            while (true) {
                i12 = i17 + i18;
                if (bArr[i12] == 10) {
                    break;
                }
                i18++;
            }
            int i19 = i12 - i17;
            int i20 = i11;
            boolean z11 = false;
            int i21 = 0;
            int i22 = 0;
            while (true) {
                if (z11) {
                    i13 = 46;
                    z10 = false;
                } else {
                    z10 = z11;
                    i13 = bArr2[i20][i21] & 255;
                }
                i14 = i13 - (bArr[i17 + i22] & 255);
                if (i14 == 0) {
                    i22++;
                    i21++;
                    if (i22 == i19) {
                        break;
                    }
                    if (bArr2[i20].length != i21) {
                        z11 = z10;
                    } else {
                        if (i20 == bArr2.length - 1) {
                            break;
                        }
                        i20++;
                        i21 = -1;
                        z11 = true;
                    }
                } else {
                    break;
                }
            }
            if (i14 >= 0) {
                if (i14 <= 0) {
                    int i23 = i19 - i22;
                    int length2 = bArr2[i20].length - i21;
                    while (true) {
                        i20++;
                        if (i20 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i20].length;
                    }
                    if (length2 >= i23) {
                        if (length2 <= i23) {
                            return new String(bArr, i17, i19, c.f37964j);
                        }
                    }
                }
                i15 = i12 + 1;
            }
            length = i16;
        }
        return null;
    }

    private String[] a(String[] strArr) {
        String str;
        String str2;
        String str3;
        int i11 = 0;
        if (this.f38306a.get() || !this.f38306a.compareAndSet(false, true)) {
            try {
                this.f38307b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            c();
        }
        synchronized (this) {
            if (this.f38308c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length];
        for (int i12 = 0; i12 < strArr.length; i12++) {
            bArr[i12] = strArr[i12].getBytes(c.f37964j);
        }
        int i13 = 0;
        while (true) {
            str = null;
            if (i13 >= length) {
                str2 = null;
                break;
            }
            str2 = a(this.f38308c, bArr, i13);
            if (str2 != null) {
                break;
            }
            i13++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i14 = 0; i14 < bArr2.length - 1; i14++) {
                bArr2[i14] = f38302e;
                str3 = a(this.f38308c, bArr2, i14);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            while (true) {
                if (i11 >= length - 1) {
                    break;
                }
                String a11 = a(this.f38309d, bArr, i11);
                if (a11 != null) {
                    str = a11;
                    break;
                }
                i11++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        }
        if (str2 == null && str3 == null) {
            return f38304g;
        }
        String[] split = str2 != null ? str2.split("\\.") : f38303f;
        String[] split2 = str3 != null ? str3.split("\\.") : f38303f;
        return split.length > split2.length ? split : split2;
    }

    private void b() throws IOException {
        InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream(okhttp3.internal.publicsuffix.PublicSuffixDatabase.PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        e a11 = l.a(new j(l.a(resourceAsStream)));
        try {
            byte[] bArr = new byte[a11.readInt()];
            a11.readFully(bArr);
            byte[] bArr2 = new byte[a11.readInt()];
            a11.readFully(bArr2);
            synchronized (this) {
                this.f38308c = bArr;
                this.f38309d = bArr2;
            }
            this.f38307b.countDown();
        } finally {
            c.a(a11);
        }
    }

    private void c() {
        boolean z10 = false;
        while (true) {
            try {
                try {
                    b();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z10 = true;
                } catch (IOException e11) {
                    g.d().a(5, "Failed to read public suffix list", e11);
                    if (z10) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th2) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th2;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
    }

    public String a(String str) {
        int length;
        int length2;
        if (str == null) {
            throw new NullPointerException("domain == null");
        }
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] a11 = a(split);
        if (split.length == a11.length && a11[0].charAt(0) != '!') {
            return null;
        }
        if (a11[0].charAt(0) == '!') {
            length = split.length;
            length2 = a11.length;
        } else {
            length = split.length;
            length2 = a11.length + 1;
        }
        StringBuilder sb2 = new StringBuilder();
        String[] split2 = str.split("\\.");
        for (int i11 = length - length2; i11 < split2.length; i11++) {
            sb2.append(split2[i11]);
            sb2.append('.');
        }
        sb2.deleteCharAt(sb2.length() - 1);
        return sb2.toString();
    }
}
