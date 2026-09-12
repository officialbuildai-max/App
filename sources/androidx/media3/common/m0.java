package androidx.media3.common;

import androidx.media3.common.util.a1;
import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: classes2.dex */
public final class m0 {

    /* renamed from: e, reason: collision with root package name */
    public static final m0 f10193e = new m0(0, 0);

    /* renamed from: f, reason: collision with root package name */
    private static final String f10194f = a1.C0(0);

    /* renamed from: g, reason: collision with root package name */
    private static final String f10195g = a1.C0(1);

    /* renamed from: h, reason: collision with root package name */
    private static final String f10196h = a1.C0(3);

    /* renamed from: a, reason: collision with root package name */
    public final int f10197a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10198b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10199c;

    /* renamed from: d, reason: collision with root package name */
    public final float f10200d;

    public m0(int i11, int i12) {
        this(i11, i12, 1.0f);
    }

    public m0(int i11, int i12, float f11) {
        this.f10197a = i11;
        this.f10198b = i12;
        this.f10199c = 0;
        this.f10200d = f11;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        return this.f10197a == m0Var.f10197a && this.f10198b == m0Var.f10198b && this.f10200d == m0Var.f10200d;
    }

    public int hashCode() {
        return ((((Sdk$SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE + this.f10197a) * 31) + this.f10198b) * 31) + Float.floatToRawIntBits(this.f10200d);
    }
}
