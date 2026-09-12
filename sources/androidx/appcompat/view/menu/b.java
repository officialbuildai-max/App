package androidx.appcompat.view.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.l;
import androidx.appcompat.view.menu.m;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class b implements l {

    /* renamed from: a, reason: collision with root package name */
    protected Context f1483a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f1484b;

    /* renamed from: c, reason: collision with root package name */
    protected f f1485c;

    /* renamed from: d, reason: collision with root package name */
    protected LayoutInflater f1486d;

    /* renamed from: e, reason: collision with root package name */
    protected LayoutInflater f1487e;

    /* renamed from: f, reason: collision with root package name */
    private l.a f1488f;

    /* renamed from: g, reason: collision with root package name */
    private int f1489g;

    /* renamed from: h, reason: collision with root package name */
    private int f1490h;

    /* renamed from: i, reason: collision with root package name */
    protected m f1491i;

    /* renamed from: j, reason: collision with root package name */
    private int f1492j;

    public b(Context context, int i11, int i12) {
        this.f1483a = context;
        this.f1486d = LayoutInflater.from(context);
        this.f1489g = i11;
        this.f1490h = i12;
    }

    protected void a(View view, int i11) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1491i).addView(view, i11);
    }

    @Override // androidx.appcompat.view.menu.l
    public void b(f fVar, boolean z10) {
        l.a aVar = this.f1488f;
        if (aVar != null) {
            aVar.b(fVar, z10);
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean c(f fVar, h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void d(l.a aVar) {
        this.f1488f = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [androidx.appcompat.view.menu.f] */
    @Override // androidx.appcompat.view.menu.l
    public boolean f(q qVar) {
        l.a aVar = this.f1488f;
        q qVar2 = qVar;
        if (aVar == null) {
            return false;
        }
        if (qVar == null) {
            qVar2 = this.f1485c;
        }
        return aVar.c(qVar2);
    }

    @Override // androidx.appcompat.view.menu.l
    public int getId() {
        return this.f1492j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.appcompat.view.menu.l
    public void h(boolean z10) {
        ViewGroup viewGroup = (ViewGroup) this.f1491i;
        if (viewGroup == null) {
            return;
        }
        f fVar = this.f1485c;
        int i11 = 0;
        if (fVar != null) {
            fVar.t();
            ArrayList G = this.f1485c.G();
            int size = G.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                h hVar = (h) G.get(i13);
                if (s(i12, hVar)) {
                    View childAt = viewGroup.getChildAt(i12);
                    h itemData = childAt instanceof m.a ? ((m.a) childAt).getItemData() : null;
                    View p11 = p(hVar, childAt, viewGroup);
                    if (hVar != itemData) {
                        p11.setPressed(false);
                        p11.jumpDrawablesToCurrentState();
                    }
                    if (p11 != childAt) {
                        a(p11, i12);
                    }
                    i12++;
                }
            }
            i11 = i12;
        }
        while (i11 < viewGroup.getChildCount()) {
            if (!n(viewGroup, i11)) {
                i11++;
            }
        }
    }

    @Override // androidx.appcompat.view.menu.l
    public boolean j(f fVar, h hVar) {
        return false;
    }

    @Override // androidx.appcompat.view.menu.l
    public void k(Context context, f fVar) {
        this.f1484b = context;
        this.f1487e = LayoutInflater.from(context);
        this.f1485c = fVar;
    }

    public abstract void l(h hVar, m.a aVar);

    public m.a m(ViewGroup viewGroup) {
        return (m.a) this.f1486d.inflate(this.f1490h, viewGroup, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean n(ViewGroup viewGroup, int i11) {
        viewGroup.removeViewAt(i11);
        return true;
    }

    public l.a o() {
        return this.f1488f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View p(h hVar, View view, ViewGroup viewGroup) {
        m.a m11 = view instanceof m.a ? (m.a) view : m(viewGroup);
        l(hVar, m11);
        return (View) m11;
    }

    public m q(ViewGroup viewGroup) {
        if (this.f1491i == null) {
            m mVar = (m) this.f1486d.inflate(this.f1489g, viewGroup, false);
            this.f1491i = mVar;
            mVar.initialize(this.f1485c);
            h(true);
        }
        return this.f1491i;
    }

    public void r(int i11) {
        this.f1492j = i11;
    }

    public abstract boolean s(int i11, h hVar);
}
