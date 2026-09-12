package g10;

import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: classes7.dex */
public class r extends y {

    /* renamed from: a, reason: collision with root package name */
    static int[] f63285a;

    /* renamed from: b, reason: collision with root package name */
    static int[] f63286b;

    /* renamed from: c, reason: collision with root package name */
    static int f63287c;

    /* renamed from: d, reason: collision with root package name */
    static String f63288d;

    public r() {
        f63285a = r0;
        int[] iArr = {2, 570425344, 0, 4096, 458752, 3, 0, 0, 1030, 1280, 0, 0, 0, 0, 0, 0, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306, 572662306};
        f63286b = r0;
        int[] iArr2 = {Sdk$SDKError.Reason.AD_EXPIRED_VALUE, 286331153, 572662306, 1091653905, 303173905, 287445265};
        f63288d = "ISO-2022-JP";
        f63287c = 8;
    }

    @Override // g10.y
    public int[] a() {
        return f63285a;
    }

    @Override // g10.y
    public String b() {
        return f63288d;
    }

    @Override // g10.y
    public boolean d() {
        return false;
    }

    @Override // g10.y
    public int e() {
        return f63287c;
    }

    @Override // g10.y
    public int[] f() {
        return f63286b;
    }
}
