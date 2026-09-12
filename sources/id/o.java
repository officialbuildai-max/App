package id;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* loaded from: classes5.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    private static final Charset f65323a = Charset.defaultCharset();

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f65324b = Charset.forName("SJIS");

    /* renamed from: c, reason: collision with root package name */
    public static final Charset f65325c;

    /* renamed from: d, reason: collision with root package name */
    private static final Charset f65326d;

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f65327e;

    static {
        Charset charset;
        try {
            charset = Charset.forName("GB2312");
        } catch (UnsupportedCharsetException unused) {
            charset = null;
        }
        f65325c = charset;
        Charset forName = Charset.forName("EUC_JP");
        f65326d = forName;
        Charset charset2 = f65324b;
        Charset charset3 = f65323a;
        f65327e = charset2.equals(charset3) || forName.equals(charset3);
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x0110 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.nio.charset.Charset a(byte[] r21, java.util.Map r22) {
        /*
            Method dump skipped, instructions count: 355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: id.o.a(byte[], java.util.Map):java.nio.charset.Charset");
    }
}
