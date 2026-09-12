package kotlinx.serialization.json.internal;

import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: classes7.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f68433a;

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f68434b;

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f68435c;

    static {
        i iVar = new i();
        f68433a = iVar;
        f68434b = new char[Sdk$SDKError.Reason.ASSET_FAILED_STATUS_CODE_VALUE];
        f68435c = new byte[126];
        iVar.f();
        iVar.e();
    }

    private i() {
    }

    private final void a(char c11, char c12) {
        b(c11, c12);
    }

    private final void b(int i11, char c11) {
        if (c11 != 'u') {
            f68434b[c11] = (char) i11;
        }
    }

    private final void c(char c11, byte b11) {
        d(c11, b11);
    }

    private final void d(int i11, byte b11) {
        f68435c[i11] = b11;
    }

    private final void e() {
        for (int i11 = 0; i11 < 33; i11++) {
            d(i11, Byte.MAX_VALUE);
        }
        d(9, (byte) 3);
        d(10, (byte) 3);
        d(13, (byte) 3);
        d(32, (byte) 3);
        c(',', (byte) 4);
        c(':', (byte) 5);
        c('{', (byte) 6);
        c('}', (byte) 7);
        c('[', (byte) 8);
        c(']', (byte) 9);
        c('\"', (byte) 1);
        c('\\', (byte) 2);
    }

    private final void f() {
        for (int i11 = 0; i11 < 32; i11++) {
            b(i11, 'u');
        }
        b(8, 'b');
        b(9, 't');
        b(10, 'n');
        b(12, 'f');
        b(13, 'r');
        a('/', '/');
        a('\"', '\"');
        a('\\', '\\');
    }
}
