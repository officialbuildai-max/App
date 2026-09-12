package androidx.compose.ui.input.pointer;

import androidx.compose.ui.node.LayoutNode;

/* loaded from: classes.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    private final LayoutNode f5049a;

    /* renamed from: b, reason: collision with root package name */
    private final f f5050b;

    /* renamed from: c, reason: collision with root package name */
    private final x f5051c = new x();

    /* renamed from: d, reason: collision with root package name */
    private final androidx.compose.ui.node.q f5052d = new androidx.compose.ui.node.q();

    /* renamed from: e, reason: collision with root package name */
    private boolean f5053e;

    public a0(LayoutNode layoutNode) {
        this.f5049a = layoutNode;
        this.f5050b = new f(layoutNode.o());
    }

    public final void a() {
        this.f5050b.b();
    }

    public final int b(y yVar, i0 i0Var, boolean z10) {
        boolean z11;
        if (this.f5053e) {
            return b0.a(false, false);
        }
        boolean z12 = true;
        try {
            this.f5053e = true;
            g b11 = this.f5051c.b(yVar, i0Var);
            int n11 = b11.b().n();
            for (int i11 = 0; i11 < n11; i11++) {
                w wVar = (w) b11.b().o(i11);
                if (!wVar.i() && !wVar.l()) {
                }
                z11 = false;
                break;
            }
            z11 = true;
            int n12 = b11.b().n();
            for (int i12 = 0; i12 < n12; i12++) {
                w wVar2 = (w) b11.b().o(i12);
                if (z11 || p.b(wVar2)) {
                    LayoutNode.r0(this.f5049a, wVar2.h(), this.f5052d, h0.g(wVar2.n(), h0.f5073a.d()), false, 8, null);
                    if (!this.f5052d.isEmpty()) {
                        this.f5050b.a(wVar2.f(), this.f5052d, p.b(wVar2));
                        this.f5052d.clear();
                    }
                }
            }
            this.f5050b.e();
            boolean c11 = this.f5050b.c(b11, z10);
            if (!b11.d()) {
                int n13 = b11.b().n();
                for (int i13 = 0; i13 < n13; i13++) {
                    w wVar3 = (w) b11.b().o(i13);
                    if (p.j(wVar3) && wVar3.p()) {
                        break;
                    }
                }
            }
            z12 = false;
            int a11 = b0.a(c11, z12);
            this.f5053e = false;
            return a11;
        } catch (Throwable th2) {
            this.f5053e = false;
            throw th2;
        }
    }

    public final void c() {
        if (this.f5053e) {
            return;
        }
        this.f5051c.a();
        this.f5050b.d();
    }
}
