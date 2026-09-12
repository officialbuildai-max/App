package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.c5;
import androidx.compose.ui.graphics.d5;
import androidx.compose.ui.graphics.j1;
import androidx.compose.ui.graphics.q4;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class n extends l {

    /* renamed from: a, reason: collision with root package name */
    private final String f4935a;

    /* renamed from: b, reason: collision with root package name */
    private final List f4936b;

    /* renamed from: c, reason: collision with root package name */
    private final int f4937c;

    /* renamed from: d, reason: collision with root package name */
    private final j1 f4938d;

    /* renamed from: e, reason: collision with root package name */
    private final float f4939e;

    /* renamed from: f, reason: collision with root package name */
    private final j1 f4940f;

    /* renamed from: g, reason: collision with root package name */
    private final float f4941g;

    /* renamed from: h, reason: collision with root package name */
    private final float f4942h;

    /* renamed from: i, reason: collision with root package name */
    private final int f4943i;

    /* renamed from: j, reason: collision with root package name */
    private final int f4944j;

    /* renamed from: k, reason: collision with root package name */
    private final float f4945k;

    /* renamed from: l, reason: collision with root package name */
    private final float f4946l;

    /* renamed from: m, reason: collision with root package name */
    private final float f4947m;

    /* renamed from: n, reason: collision with root package name */
    private final float f4948n;

    private n(String str, List list, int i11, j1 j1Var, float f11, j1 j1Var2, float f12, float f13, int i12, int i13, float f14, float f15, float f16, float f17) {
        super(null);
        this.f4935a = str;
        this.f4936b = list;
        this.f4937c = i11;
        this.f4938d = j1Var;
        this.f4939e = f11;
        this.f4940f = j1Var2;
        this.f4941g = f12;
        this.f4942h = f13;
        this.f4943i = i12;
        this.f4944j = i13;
        this.f4945k = f14;
        this.f4946l = f15;
        this.f4947m = f16;
        this.f4948n = f17;
    }

    public /* synthetic */ n(String str, List list, int i11, j1 j1Var, float f11, j1 j1Var2, float f12, float f13, int i12, int i13, float f14, float f15, float f16, float f17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, i11, j1Var, f11, j1Var2, f12, f13, i12, i13, f14, f15, f16, f17);
    }

    public final j1 a() {
        return this.f4938d;
    }

    public final float c() {
        return this.f4939e;
    }

    public final String e() {
        return this.f4935a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && n.class == obj.getClass()) {
            n nVar = (n) obj;
            return Intrinsics.c(this.f4935a, nVar.f4935a) && Intrinsics.c(this.f4938d, nVar.f4938d) && this.f4939e == nVar.f4939e && Intrinsics.c(this.f4940f, nVar.f4940f) && this.f4941g == nVar.f4941g && this.f4942h == nVar.f4942h && c5.e(this.f4943i, nVar.f4943i) && d5.e(this.f4944j, nVar.f4944j) && this.f4945k == nVar.f4945k && this.f4946l == nVar.f4946l && this.f4947m == nVar.f4947m && this.f4948n == nVar.f4948n && q4.d(this.f4937c, nVar.f4937c) && Intrinsics.c(this.f4936b, nVar.f4936b);
        }
        return false;
    }

    public final List f() {
        return this.f4936b;
    }

    public final int h() {
        return this.f4937c;
    }

    public int hashCode() {
        int hashCode = ((this.f4935a.hashCode() * 31) + this.f4936b.hashCode()) * 31;
        j1 j1Var = this.f4938d;
        int hashCode2 = (((hashCode + (j1Var != null ? j1Var.hashCode() : 0)) * 31) + Float.floatToIntBits(this.f4939e)) * 31;
        j1 j1Var2 = this.f4940f;
        return ((((((((((((((((((hashCode2 + (j1Var2 != null ? j1Var2.hashCode() : 0)) * 31) + Float.floatToIntBits(this.f4941g)) * 31) + Float.floatToIntBits(this.f4942h)) * 31) + c5.f(this.f4943i)) * 31) + d5.f(this.f4944j)) * 31) + Float.floatToIntBits(this.f4945k)) * 31) + Float.floatToIntBits(this.f4946l)) * 31) + Float.floatToIntBits(this.f4947m)) * 31) + Float.floatToIntBits(this.f4948n)) * 31) + q4.e(this.f4937c);
    }

    public final j1 j() {
        return this.f4940f;
    }

    public final float l() {
        return this.f4941g;
    }

    public final int m() {
        return this.f4943i;
    }

    public final int n() {
        return this.f4944j;
    }

    public final float o() {
        return this.f4945k;
    }

    public final float p() {
        return this.f4942h;
    }

    public final float q() {
        return this.f4947m;
    }

    public final float r() {
        return this.f4948n;
    }

    public final float s() {
        return this.f4946l;
    }
}
