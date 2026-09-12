package androidx.compose.foundation;

import android.content.Context;
import android.widget.EdgeEffect;

/* loaded from: classes.dex */
final class p {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3222a;

    /* renamed from: b, reason: collision with root package name */
    private final int f3223b;

    /* renamed from: c, reason: collision with root package name */
    private long f3224c = o0.t.f70747b.a();

    /* renamed from: d, reason: collision with root package name */
    private EdgeEffect f3225d;

    /* renamed from: e, reason: collision with root package name */
    private EdgeEffect f3226e;

    /* renamed from: f, reason: collision with root package name */
    private EdgeEffect f3227f;

    /* renamed from: g, reason: collision with root package name */
    private EdgeEffect f3228g;

    /* renamed from: h, reason: collision with root package name */
    private EdgeEffect f3229h;

    /* renamed from: i, reason: collision with root package name */
    private EdgeEffect f3230i;

    /* renamed from: j, reason: collision with root package name */
    private EdgeEffect f3231j;

    /* renamed from: k, reason: collision with root package name */
    private EdgeEffect f3232k;

    public p(Context context, int i11) {
        this.f3222a = context;
        this.f3223b = i11;
    }

    private final EdgeEffect e() {
        EdgeEffect a11 = o.f3221a.a(this.f3222a);
        a11.setColor(this.f3223b);
        if (!o0.t.e(this.f3224c, o0.t.f70747b.a())) {
            a11.setSize(o0.t.g(this.f3224c), o0.t.f(this.f3224c));
        }
        return a11;
    }

    private final boolean n(EdgeEffect edgeEffect) {
        if (edgeEffect == null) {
            return false;
        }
        return !edgeEffect.isFinished();
    }

    private final boolean x(EdgeEffect edgeEffect) {
        if (edgeEffect == null) {
            return false;
        }
        return !(o.f3221a.b(edgeEffect) == 0.0f);
    }

    public final boolean A() {
        return x(this.f3225d);
    }

    public final void B(long j11) {
        this.f3224c = j11;
        EdgeEffect edgeEffect = this.f3225d;
        if (edgeEffect != null) {
            edgeEffect.setSize(o0.t.g(j11), o0.t.f(j11));
        }
        EdgeEffect edgeEffect2 = this.f3226e;
        if (edgeEffect2 != null) {
            edgeEffect2.setSize(o0.t.g(j11), o0.t.f(j11));
        }
        EdgeEffect edgeEffect3 = this.f3227f;
        if (edgeEffect3 != null) {
            edgeEffect3.setSize(o0.t.f(j11), o0.t.g(j11));
        }
        EdgeEffect edgeEffect4 = this.f3228g;
        if (edgeEffect4 != null) {
            edgeEffect4.setSize(o0.t.f(j11), o0.t.g(j11));
        }
        EdgeEffect edgeEffect5 = this.f3229h;
        if (edgeEffect5 != null) {
            edgeEffect5.setSize(o0.t.g(j11), o0.t.f(j11));
        }
        EdgeEffect edgeEffect6 = this.f3230i;
        if (edgeEffect6 != null) {
            edgeEffect6.setSize(o0.t.g(j11), o0.t.f(j11));
        }
        EdgeEffect edgeEffect7 = this.f3231j;
        if (edgeEffect7 != null) {
            edgeEffect7.setSize(o0.t.f(j11), o0.t.g(j11));
        }
        EdgeEffect edgeEffect8 = this.f3232k;
        if (edgeEffect8 != null) {
            edgeEffect8.setSize(o0.t.f(j11), o0.t.g(j11));
        }
    }

    public final EdgeEffect f() {
        EdgeEffect edgeEffect = this.f3226e;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect e11 = e();
        this.f3226e = e11;
        return e11;
    }

    public final EdgeEffect g() {
        EdgeEffect edgeEffect = this.f3230i;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect e11 = e();
        this.f3230i = e11;
        return e11;
    }

    public final EdgeEffect h() {
        EdgeEffect edgeEffect = this.f3227f;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect e11 = e();
        this.f3227f = e11;
        return e11;
    }

    public final EdgeEffect i() {
        EdgeEffect edgeEffect = this.f3231j;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect e11 = e();
        this.f3231j = e11;
        return e11;
    }

    public final EdgeEffect j() {
        EdgeEffect edgeEffect = this.f3228g;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect e11 = e();
        this.f3228g = e11;
        return e11;
    }

    public final EdgeEffect k() {
        EdgeEffect edgeEffect = this.f3232k;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect e11 = e();
        this.f3232k = e11;
        return e11;
    }

    public final EdgeEffect l() {
        EdgeEffect edgeEffect = this.f3225d;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect e11 = e();
        this.f3225d = e11;
        return e11;
    }

    public final EdgeEffect m() {
        EdgeEffect edgeEffect = this.f3229h;
        if (edgeEffect != null) {
            return edgeEffect;
        }
        EdgeEffect e11 = e();
        this.f3229h = e11;
        return e11;
    }

    public final boolean o() {
        return n(this.f3226e);
    }

    public final boolean p() {
        return x(this.f3230i);
    }

    public final boolean q() {
        return x(this.f3226e);
    }

    public final boolean r() {
        return n(this.f3227f);
    }

    public final boolean s() {
        return x(this.f3231j);
    }

    public final boolean t() {
        return x(this.f3227f);
    }

    public final boolean u() {
        return n(this.f3228g);
    }

    public final boolean v() {
        return x(this.f3232k);
    }

    public final boolean w() {
        return x(this.f3228g);
    }

    public final boolean y() {
        return n(this.f3225d);
    }

    public final boolean z() {
        return x(this.f3229h);
    }
}
