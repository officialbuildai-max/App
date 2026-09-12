package g10;

import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: classes7.dex */
public class q extends y {

    /* renamed from: a, reason: collision with root package name */
    static int[] f63281a;

    /* renamed from: b, reason: collision with root package name */
    static int[] f63282b;

    /* renamed from: c, reason: collision with root package name */
    static int f63283c;

    /* renamed from: d, reason: collision with root package name */
    static String f63284d;

    public q() {
        f63281a = r0;
        int[] iArr = {2, 0, 0, 4096, 0, 48, 0, 0, 16384, 0, 0, 0, 0, 0, 0, 0, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306};
        f63282b = r0;
        int[] iArr2 = {Sdk$SDKError.Reason.AD_EXPIRED_VALUE, 286331152, 572662289, 336663074, 286335249, 286331237, 286335249, 18944273};
        f63284d = "ISO-2022-CN";
        f63283c = 9;
    }

    @Override // g10.y
    public int[] a() {
        return f63281a;
    }

    @Override // g10.y
    public String b() {
        return f63284d;
    }

    @Override // g10.y
    public boolean d() {
        return false;
    }

    @Override // g10.y
    public int e() {
        return f63283c;
    }

    @Override // g10.y
    public int[] f() {
        return f63282b;
    }
}
