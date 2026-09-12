package androidx.compose.foundation;

import androidx.compose.ui.f;
import androidx.compose.ui.node.m1;
import androidx.compose.ui.node.n1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class s extends f.c implements m1, androidx.compose.ui.node.p {

    /* renamed from: q, reason: collision with root package name */
    public static final a f3240q = new a(null);

    /* renamed from: r, reason: collision with root package name */
    public static final int f3241r = 8;

    /* renamed from: n, reason: collision with root package name */
    private boolean f3242n;

    /* renamed from: o, reason: collision with root package name */
    private final boolean f3243o;

    /* renamed from: p, reason: collision with root package name */
    private androidx.compose.ui.layout.l f3244p;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final t D1() {
        if (!k1()) {
            return null;
        }
        m1 a11 = n1.a(this, t.f3263p);
        if (a11 instanceof t) {
            return (t) a11;
        }
        return null;
    }

    private final void E1() {
        t D1;
        androidx.compose.ui.layout.l lVar = this.f3244p;
        if (lVar != null) {
            Intrinsics.e(lVar);
            if (!lVar.F() || (D1 = D1()) == null) {
                return;
            }
            D1.D1(this.f3244p);
        }
    }

    @Override // androidx.compose.ui.node.m1
    public Object D() {
        return f3240q;
    }

    public final void F1(boolean z10) {
        if (z10 == this.f3242n) {
            return;
        }
        if (z10) {
            E1();
        } else {
            t D1 = D1();
            if (D1 != null) {
                D1.D1(null);
            }
        }
        this.f3242n = z10;
    }

    @Override // androidx.compose.ui.f.c
    public boolean i1() {
        return this.f3243o;
    }

    @Override // androidx.compose.ui.node.p
    public void v(androidx.compose.ui.layout.l lVar) {
        this.f3244p = lVar;
        if (this.f3242n) {
            if (lVar.F()) {
                E1();
                return;
            }
            t D1 = D1();
            if (D1 != null) {
                D1.D1(null);
            }
        }
    }
}
