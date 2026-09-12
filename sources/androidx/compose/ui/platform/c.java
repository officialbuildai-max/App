package androidx.compose.ui.platform;

import androidx.compose.ui.text.style.ResolvedTextDirection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class c extends androidx.compose.ui.platform.a {

    /* renamed from: f, reason: collision with root package name */
    private static c f5822f;

    /* renamed from: c, reason: collision with root package name */
    private androidx.compose.ui.text.z f5825c;

    /* renamed from: d, reason: collision with root package name */
    public static final a f5820d = new a(null);

    /* renamed from: e, reason: collision with root package name */
    public static final int f5821e = 8;

    /* renamed from: g, reason: collision with root package name */
    private static final ResolvedTextDirection f5823g = ResolvedTextDirection.Rtl;

    /* renamed from: h, reason: collision with root package name */
    private static final ResolvedTextDirection f5824h = ResolvedTextDirection.Ltr;

    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            if (c.f5822f == null) {
                c.f5822f = new c(null);
            }
            c cVar = c.f5822f;
            Intrinsics.f(cVar, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator");
            return cVar;
        }
    }

    private c() {
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final int i(int i11, ResolvedTextDirection resolvedTextDirection) {
        androidx.compose.ui.text.z zVar = this.f5825c;
        androidx.compose.ui.text.z zVar2 = null;
        if (zVar == null) {
            Intrinsics.z("layoutResult");
            zVar = null;
        }
        int t11 = zVar.t(i11);
        androidx.compose.ui.text.z zVar3 = this.f5825c;
        if (zVar3 == null) {
            Intrinsics.z("layoutResult");
            zVar3 = null;
        }
        if (resolvedTextDirection != zVar3.w(t11)) {
            androidx.compose.ui.text.z zVar4 = this.f5825c;
            if (zVar4 == null) {
                Intrinsics.z("layoutResult");
            } else {
                zVar2 = zVar4;
            }
            return zVar2.t(i11);
        }
        androidx.compose.ui.text.z zVar5 = this.f5825c;
        if (zVar5 == null) {
            Intrinsics.z("layoutResult");
            zVar5 = null;
        }
        return androidx.compose.ui.text.z.o(zVar5, i11, false, 2, null) - 1;
    }

    @Override // androidx.compose.ui.platform.f
    public int[] a(int i11) {
        int i12;
        if (d().length() <= 0 || i11 >= d().length()) {
            return null;
        }
        if (i11 < 0) {
            androidx.compose.ui.text.z zVar = this.f5825c;
            if (zVar == null) {
                Intrinsics.z("layoutResult");
                zVar = null;
            }
            i12 = zVar.p(0);
        } else {
            androidx.compose.ui.text.z zVar2 = this.f5825c;
            if (zVar2 == null) {
                Intrinsics.z("layoutResult");
                zVar2 = null;
            }
            int p11 = zVar2.p(i11);
            i12 = i(p11, f5823g) == i11 ? p11 : p11 + 1;
        }
        androidx.compose.ui.text.z zVar3 = this.f5825c;
        if (zVar3 == null) {
            Intrinsics.z("layoutResult");
            zVar3 = null;
        }
        if (i12 >= zVar3.m()) {
            return null;
        }
        return c(i(i12, f5823g), i(i12, f5824h) + 1);
    }

    @Override // androidx.compose.ui.platform.f
    public int[] b(int i11) {
        int i12;
        if (d().length() <= 0 || i11 <= 0) {
            return null;
        }
        if (i11 > d().length()) {
            androidx.compose.ui.text.z zVar = this.f5825c;
            if (zVar == null) {
                Intrinsics.z("layoutResult");
                zVar = null;
            }
            i12 = zVar.p(d().length());
        } else {
            androidx.compose.ui.text.z zVar2 = this.f5825c;
            if (zVar2 == null) {
                Intrinsics.z("layoutResult");
                zVar2 = null;
            }
            int p11 = zVar2.p(i11);
            i12 = i(p11, f5824h) + 1 == i11 ? p11 : p11 - 1;
        }
        if (i12 < 0) {
            return null;
        }
        return c(i(i12, f5823g), i(i12, f5824h) + 1);
    }

    public final void j(String str, androidx.compose.ui.text.z zVar) {
        f(str);
        this.f5825c = zVar;
    }
}
