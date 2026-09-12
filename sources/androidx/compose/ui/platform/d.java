package androidx.compose.ui.platform;

import android.graphics.Rect;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class d extends androidx.compose.ui.platform.a {

    /* renamed from: h, reason: collision with root package name */
    private static d f5834h;

    /* renamed from: c, reason: collision with root package name */
    private androidx.compose.ui.text.z f5837c;

    /* renamed from: d, reason: collision with root package name */
    private SemanticsNode f5838d;

    /* renamed from: e, reason: collision with root package name */
    private Rect f5839e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f5832f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public static final int f5833g = 8;

    /* renamed from: i, reason: collision with root package name */
    private static final ResolvedTextDirection f5835i = ResolvedTextDirection.Rtl;

    /* renamed from: j, reason: collision with root package name */
    private static final ResolvedTextDirection f5836j = ResolvedTextDirection.Ltr;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final d a() {
            if (d.f5834h == null) {
                d.f5834h = new d(null);
            }
            d dVar = d.f5834h;
            Intrinsics.f(dVar, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.PageTextSegmentIterator");
            return dVar;
        }
    }

    private d() {
        this.f5839e = new Rect();
    }

    public /* synthetic */ d(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final int i(int i11, ResolvedTextDirection resolvedTextDirection) {
        androidx.compose.ui.text.z zVar = this.f5837c;
        androidx.compose.ui.text.z zVar2 = null;
        if (zVar == null) {
            Intrinsics.z("layoutResult");
            zVar = null;
        }
        int t11 = zVar.t(i11);
        androidx.compose.ui.text.z zVar3 = this.f5837c;
        if (zVar3 == null) {
            Intrinsics.z("layoutResult");
            zVar3 = null;
        }
        if (resolvedTextDirection != zVar3.w(t11)) {
            androidx.compose.ui.text.z zVar4 = this.f5837c;
            if (zVar4 == null) {
                Intrinsics.z("layoutResult");
            } else {
                zVar2 = zVar4;
            }
            return zVar2.t(i11);
        }
        androidx.compose.ui.text.z zVar5 = this.f5837c;
        if (zVar5 == null) {
            Intrinsics.z("layoutResult");
            zVar5 = null;
        }
        return androidx.compose.ui.text.z.o(zVar5, i11, false, 2, null) - 1;
    }

    @Override // androidx.compose.ui.platform.f
    public int[] a(int i11) {
        int m11;
        androidx.compose.ui.text.z zVar = null;
        if (d().length() <= 0 || i11 >= d().length()) {
            return null;
        }
        try {
            SemanticsNode semanticsNode = this.f5838d;
            if (semanticsNode == null) {
                Intrinsics.z("node");
                semanticsNode = null;
            }
            int round = Math.round(semanticsNode.i().e());
            int f11 = RangesKt.f(0, i11);
            androidx.compose.ui.text.z zVar2 = this.f5837c;
            if (zVar2 == null) {
                Intrinsics.z("layoutResult");
                zVar2 = null;
            }
            int p11 = zVar2.p(f11);
            androidx.compose.ui.text.z zVar3 = this.f5837c;
            if (zVar3 == null) {
                Intrinsics.z("layoutResult");
                zVar3 = null;
            }
            float u11 = zVar3.u(p11) + round;
            androidx.compose.ui.text.z zVar4 = this.f5837c;
            if (zVar4 == null) {
                Intrinsics.z("layoutResult");
                zVar4 = null;
            }
            androidx.compose.ui.text.z zVar5 = this.f5837c;
            if (zVar5 == null) {
                Intrinsics.z("layoutResult");
                zVar5 = null;
            }
            if (u11 < zVar4.u(zVar5.m() - 1)) {
                androidx.compose.ui.text.z zVar6 = this.f5837c;
                if (zVar6 == null) {
                    Intrinsics.z("layoutResult");
                } else {
                    zVar = zVar6;
                }
                m11 = zVar.q(u11);
            } else {
                androidx.compose.ui.text.z zVar7 = this.f5837c;
                if (zVar7 == null) {
                    Intrinsics.z("layoutResult");
                } else {
                    zVar = zVar7;
                }
                m11 = zVar.m();
            }
            return c(f11, i(m11 - 1, f5836j) + 1);
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    @Override // androidx.compose.ui.platform.f
    public int[] b(int i11) {
        int i12;
        androidx.compose.ui.text.z zVar = null;
        if (d().length() <= 0 || i11 <= 0) {
            return null;
        }
        try {
            SemanticsNode semanticsNode = this.f5838d;
            if (semanticsNode == null) {
                Intrinsics.z("node");
                semanticsNode = null;
            }
            int round = Math.round(semanticsNode.i().e());
            int i13 = RangesKt.i(d().length(), i11);
            androidx.compose.ui.text.z zVar2 = this.f5837c;
            if (zVar2 == null) {
                Intrinsics.z("layoutResult");
                zVar2 = null;
            }
            int p11 = zVar2.p(i13);
            androidx.compose.ui.text.z zVar3 = this.f5837c;
            if (zVar3 == null) {
                Intrinsics.z("layoutResult");
                zVar3 = null;
            }
            float u11 = zVar3.u(p11) - round;
            if (u11 > 0.0f) {
                androidx.compose.ui.text.z zVar4 = this.f5837c;
                if (zVar4 == null) {
                    Intrinsics.z("layoutResult");
                } else {
                    zVar = zVar4;
                }
                i12 = zVar.q(u11);
            } else {
                i12 = 0;
            }
            if (i13 == d().length() && i12 < p11) {
                i12++;
            }
            return c(i(i12, f5835i), i13);
        } catch (IllegalStateException unused) {
            return null;
        }
    }

    public final void j(String str, androidx.compose.ui.text.z zVar, SemanticsNode semanticsNode) {
        f(str);
        this.f5837c = zVar;
        this.f5838d = semanticsNode;
    }
}
