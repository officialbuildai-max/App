package androidx.compose.ui.text;

import androidx.compose.ui.graphics.j1;
import androidx.compose.ui.graphics.m1;
import androidx.compose.ui.graphics.z4;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

/* loaded from: classes.dex */
public final class MultiParagraph {

    /* renamed from: a, reason: collision with root package name */
    private final MultiParagraphIntrinsics f6102a;

    /* renamed from: b, reason: collision with root package name */
    private final int f6103b;

    /* renamed from: c, reason: collision with root package name */
    private final boolean f6104c;

    /* renamed from: d, reason: collision with root package name */
    private final float f6105d;

    /* renamed from: e, reason: collision with root package name */
    private final float f6106e;

    /* renamed from: f, reason: collision with root package name */
    private final int f6107f;

    /* renamed from: g, reason: collision with root package name */
    private final List f6108g;

    /* renamed from: h, reason: collision with root package name */
    private final List f6109h;

    private MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j11, int i11, boolean z10) {
        boolean z11;
        this.f6102a = multiParagraphIntrinsics;
        this.f6103b = i11;
        if (o0.b.n(j11) != 0 || o0.b.m(j11) != 0) {
            throw new IllegalArgumentException("Setting Constraints.minWidth and Constraints.minHeight is not supported, these should be the default zero values instead.");
        }
        ArrayList arrayList = new ArrayList();
        List f11 = multiParagraphIntrinsics.f();
        int size = f11.size();
        int i12 = 0;
        int i13 = 0;
        float f12 = 0.0f;
        int i14 = 0;
        while (i14 < size) {
            n nVar = (n) f11.get(i14);
            l c11 = q.c(nVar.b(), o0.c.b(0, o0.b.l(j11), 0, o0.b.g(j11) ? RangesKt.f(o0.b.k(j11) - q.d(f12), i12) : o0.b.k(j11), 5, null), this.f6103b - i13, z10);
            float height = f12 + c11.getHeight();
            int h11 = i13 + c11.h();
            List list = f11;
            arrayList.add(new m(c11, nVar.c(), nVar.a(), i13, h11, f12, height));
            if (c11.k() || (h11 == this.f6103b && i14 != CollectionsKt.n(this.f6102a.f()))) {
                z11 = true;
                i13 = h11;
                f12 = height;
                break;
            } else {
                i14++;
                i13 = h11;
                f12 = height;
                i12 = 0;
                f11 = list;
            }
        }
        z11 = false;
        this.f6106e = f12;
        this.f6107f = i13;
        this.f6104c = z11;
        this.f6109h = arrayList;
        this.f6105d = o0.b.l(j11);
        List arrayList2 = new ArrayList(arrayList.size());
        int size2 = arrayList.size();
        for (int i15 = 0; i15 < size2; i15++) {
            m mVar = (m) arrayList.get(i15);
            List u11 = mVar.e().u();
            ArrayList arrayList3 = new ArrayList(u11.size());
            int size3 = u11.size();
            for (int i16 = 0; i16 < size3; i16++) {
                y.i iVar = (y.i) u11.get(i16);
                arrayList3.add(iVar != null ? mVar.i(iVar) : null);
            }
            CollectionsKt.B(arrayList2, arrayList3);
        }
        if (arrayList2.size() < this.f6102a.g().size()) {
            int size4 = this.f6102a.g().size() - arrayList2.size();
            ArrayList arrayList4 = new ArrayList(size4);
            for (int i17 = 0; i17 < size4; i17++) {
                arrayList4.add(null);
            }
            arrayList2 = CollectionsKt.B0(arrayList2, arrayList4);
        }
        this.f6108g = arrayList2;
    }

    public /* synthetic */ MultiParagraph(MultiParagraphIntrinsics multiParagraphIntrinsics, long j11, int i11, boolean z10, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiParagraphIntrinsics, j11, i11, z10);
    }

    private final void B(int i11) {
        if (i11 < 0 || i11 >= b().i().length()) {
            throw new IllegalArgumentException(("offset(" + i11 + ") is out of bounds [0, " + b().length() + ')').toString());
        }
    }

    private final void C(int i11) {
        if (i11 < 0 || i11 > b().i().length()) {
            throw new IllegalArgumentException(("offset(" + i11 + ") is out of bounds [0, " + b().length() + ']').toString());
        }
    }

    private final void D(int i11) {
        if (i11 < 0 || i11 >= this.f6107f) {
            throw new IllegalArgumentException(("lineIndex(" + i11 + ") is out of bounds [0, " + this.f6107f + ')').toString());
        }
    }

    private final AnnotatedString b() {
        return this.f6102a.e();
    }

    public final float[] a(final long j11, final float[] fArr, int i11) {
        B(b0.j(j11));
        C(b0.i(j11));
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = i11;
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        i.d(this.f6109h, j11, new Function1<m, Unit>() { // from class: androidx.compose.ui.text.MultiParagraph$fillBoundingBoxes$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((m) obj);
                return Unit.f67184a;
            }

            public final void invoke(m mVar) {
                long j12 = j11;
                float[] fArr2 = fArr;
                Ref.IntRef intRef2 = intRef;
                Ref.FloatRef floatRef2 = floatRef;
                long b11 = c0.b(mVar.m(mVar.f() > b0.j(j12) ? mVar.f() : b0.j(j12)), mVar.m(mVar.b() < b0.i(j12) ? mVar.b() : b0.i(j12)));
                mVar.e().n(b11, fArr2, intRef2.element);
                int h11 = intRef2.element + (b0.h(b11) * 4);
                for (int i12 = intRef2.element; i12 < h11; i12 += 4) {
                    int i13 = i12 + 1;
                    float f11 = fArr2[i13];
                    float f12 = floatRef2.element;
                    fArr2[i13] = f11 + f12;
                    int i14 = i12 + 3;
                    fArr2[i14] = fArr2[i14] + f12;
                }
                intRef2.element = h11;
                floatRef2.element += mVar.e().getHeight();
            }
        });
        return fArr;
    }

    public final ResolvedTextDirection c(int i11) {
        C(i11);
        m mVar = (m) this.f6109h.get(i11 == b().length() ? CollectionsKt.n(this.f6109h) : i.a(this.f6109h, i11));
        return mVar.e().r(mVar.m(i11));
    }

    public final y.i d(int i11) {
        B(i11);
        m mVar = (m) this.f6109h.get(i.a(this.f6109h, i11));
        return mVar.i(mVar.e().t(mVar.m(i11)));
    }

    public final y.i e(int i11) {
        C(i11);
        m mVar = (m) this.f6109h.get(i11 == b().length() ? CollectionsKt.n(this.f6109h) : i.a(this.f6109h, i11));
        return mVar.i(mVar.e().d(mVar.m(i11)));
    }

    public final boolean f() {
        return this.f6104c;
    }

    public final float g() {
        if (this.f6109h.isEmpty()) {
            return 0.0f;
        }
        return ((m) this.f6109h.get(0)).e().e();
    }

    public final float h() {
        return this.f6106e;
    }

    public final MultiParagraphIntrinsics i() {
        return this.f6102a;
    }

    public final float j() {
        if (this.f6109h.isEmpty()) {
            return 0.0f;
        }
        m mVar = (m) CollectionsKt.u0(this.f6109h);
        return mVar.l(mVar.e().o());
    }

    public final float k(int i11) {
        D(i11);
        m mVar = (m) this.f6109h.get(i.b(this.f6109h, i11));
        return mVar.l(mVar.e().s(mVar.n(i11)));
    }

    public final int l() {
        return this.f6107f;
    }

    public final int m(int i11, boolean z10) {
        D(i11);
        m mVar = (m) this.f6109h.get(i.b(this.f6109h, i11));
        return mVar.j(mVar.e().g(mVar.n(i11), z10));
    }

    public final int n(int i11) {
        m mVar = (m) this.f6109h.get(i11 >= b().length() ? CollectionsKt.n(this.f6109h) : i11 < 0 ? 0 : i.a(this.f6109h, i11));
        return mVar.k(mVar.e().p(mVar.m(i11)));
    }

    public final int o(float f11) {
        m mVar = (m) this.f6109h.get(i.c(this.f6109h, f11));
        return mVar.d() == 0 ? mVar.g() : mVar.k(mVar.e().l(mVar.o(f11)));
    }

    public final float p(int i11) {
        D(i11);
        m mVar = (m) this.f6109h.get(i.b(this.f6109h, i11));
        return mVar.e().m(mVar.n(i11));
    }

    public final float q(int i11) {
        D(i11);
        m mVar = (m) this.f6109h.get(i.b(this.f6109h, i11));
        return mVar.e().i(mVar.n(i11));
    }

    public final int r(int i11) {
        D(i11);
        m mVar = (m) this.f6109h.get(i.b(this.f6109h, i11));
        return mVar.j(mVar.e().f(mVar.n(i11)));
    }

    public final float s(int i11) {
        D(i11);
        m mVar = (m) this.f6109h.get(i.b(this.f6109h, i11));
        return mVar.l(mVar.e().c(mVar.n(i11)));
    }

    public final ResolvedTextDirection t(int i11) {
        C(i11);
        m mVar = (m) this.f6109h.get(i11 == b().length() ? CollectionsKt.n(this.f6109h) : i.a(this.f6109h, i11));
        return mVar.e().b(mVar.m(i11));
    }

    public final List u() {
        return this.f6109h;
    }

    public final List v() {
        return this.f6108g;
    }

    public final float w() {
        return this.f6105d;
    }

    public final void x(m1 m1Var, long j11, z4 z4Var, androidx.compose.ui.text.style.i iVar, z.h hVar, int i11) {
        m1Var.n();
        List list = this.f6109h;
        int size = list.size();
        for (int i12 = 0; i12 < size; i12++) {
            m mVar = (m) list.get(i12);
            mVar.e().q(m1Var, j11, z4Var, iVar, hVar, i11);
            m1Var.c(0.0f, mVar.e().getHeight());
        }
        m1Var.j();
    }

    public final void z(m1 m1Var, j1 j1Var, float f11, z4 z4Var, androidx.compose.ui.text.style.i iVar, z.h hVar, int i11) {
        androidx.compose.ui.text.platform.b.a(this, m1Var, j1Var, f11, z4Var, iVar, hVar, i11);
    }
}
