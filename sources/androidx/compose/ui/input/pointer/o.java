package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import java.util.List;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private final List f5093a;

    /* renamed from: b, reason: collision with root package name */
    private final g f5094b;

    /* renamed from: c, reason: collision with root package name */
    private final int f5095c;

    /* renamed from: d, reason: collision with root package name */
    private final int f5096d;

    /* renamed from: e, reason: collision with root package name */
    private int f5097e;

    public o(List list) {
        this(list, null);
    }

    public o(List list, g gVar) {
        this.f5093a = list;
        this.f5094b = gVar;
        MotionEvent d11 = d();
        this.f5095c = n.a(d11 != null ? d11.getButtonState() : 0);
        MotionEvent d12 = d();
        this.f5096d = g0.b(d12 != null ? d12.getMetaState() : 0);
        this.f5097e = a();
    }

    private final int a() {
        MotionEvent d11 = d();
        if (d11 == null) {
            List list = this.f5093a;
            int size = list.size();
            for (int i11 = 0; i11 < size; i11++) {
                w wVar = (w) list.get(i11);
                if (p.d(wVar)) {
                    return q.f5098a.e();
                }
                if (p.b(wVar)) {
                    return q.f5098a.d();
                }
            }
            return q.f5098a.c();
        }
        int actionMasked = d11.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    switch (actionMasked) {
                        case 5:
                            break;
                        case 6:
                            break;
                        case 7:
                            break;
                        case 8:
                            return q.f5098a.f();
                        case 9:
                            return q.f5098a.a();
                        case 10:
                            return q.f5098a.b();
                        default:
                            return q.f5098a.g();
                    }
                }
                return q.f5098a.c();
            }
            return q.f5098a.e();
        }
        return q.f5098a.d();
    }

    public final List b() {
        return this.f5093a;
    }

    public final g c() {
        return this.f5094b;
    }

    public final MotionEvent d() {
        g gVar = this.f5094b;
        if (gVar != null) {
            return gVar.c();
        }
        return null;
    }

    public final int e() {
        return this.f5097e;
    }

    public final void f(int i11) {
        this.f5097e = i11;
    }
}
