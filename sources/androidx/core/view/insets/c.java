package androidx.core.view.insets;

import android.graphics.RectF;
import androidx.core.view.insets.f;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
class c implements f.c {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f8488a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    private final f f8489b;

    /* renamed from: c, reason: collision with root package name */
    private z0.c f8490c;

    /* renamed from: d, reason: collision with root package name */
    private z0.c f8491d;

    /* renamed from: e, reason: collision with root package name */
    private int f8492e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f8493f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(f fVar, List list) {
        z0.c cVar = z0.c.f79247e;
        this.f8490c = cVar;
        this.f8491d = cVar;
        f(list, false);
        f(list, true);
        fVar.g(this);
        this.f8489b = fVar;
    }

    private void f(List list, boolean z10) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            Protection protection = (Protection) list.get(i11);
            if (protection.occupiesCorners() == z10) {
                Object controller = protection.getController();
                if (controller != null) {
                    throw new IllegalStateException(protection + " is already controlled by " + controller);
                }
                protection.setController(this);
                this.f8488a.add(protection);
            }
        }
    }

    private void j() {
        z0.c cVar = z0.c.f79247e;
        for (int size = this.f8488a.size() - 1; size >= 0; size--) {
            cVar = z0.c.a(cVar, ((Protection) this.f8488a.get(size)).dispatchInsets(this.f8490c, this.f8491d, cVar));
        }
    }

    @Override // androidx.core.view.insets.f.c
    public void a() {
        int i11 = this.f8492e;
        boolean z10 = i11 > 0;
        int i12 = i11 - 1;
        this.f8492e = i12;
        if (z10 && i12 == 0) {
            j();
        }
    }

    @Override // androidx.core.view.insets.f.c
    public void b(int i11, z0.c cVar, RectF rectF) {
        z0.c cVar2 = this.f8491d;
        for (int size = this.f8488a.size() - 1; size >= 0; size--) {
            Protection protection = (Protection) this.f8488a.get(size);
            int side = protection.getSide();
            if ((side & i11) != 0) {
                protection.setSystemVisible(true);
                if (side == 1) {
                    int i12 = cVar2.f79248a;
                    if (i12 > 0) {
                        protection.setSystemInsetAmount(cVar.f79248a / i12);
                    }
                    protection.setSystemAlpha(rectF.left);
                } else if (side == 2) {
                    int i13 = cVar2.f79249b;
                    if (i13 > 0) {
                        protection.setSystemInsetAmount(cVar.f79249b / i13);
                    }
                    protection.setSystemAlpha(rectF.top);
                } else if (side == 4) {
                    int i14 = cVar2.f79250c;
                    if (i14 > 0) {
                        protection.setSystemInsetAmount(cVar.f79250c / i14);
                    }
                    protection.setSystemAlpha(rectF.right);
                } else if (side == 8) {
                    int i15 = cVar2.f79251d;
                    if (i15 > 0) {
                        protection.setSystemInsetAmount(cVar.f79251d / i15);
                    }
                    protection.setSystemAlpha(rectF.bottom);
                }
            }
        }
    }

    @Override // androidx.core.view.insets.f.c
    public void c(z0.c cVar, z0.c cVar2) {
        this.f8490c = cVar;
        this.f8491d = cVar2;
        j();
    }

    @Override // androidx.core.view.insets.f.c
    public void d() {
        this.f8492e++;
    }

    @Override // androidx.core.view.insets.f.c
    public void e(int i11) {
        for (int size = this.f8488a.size() - 1; size >= 0; size--) {
            ((Protection) this.f8488a.get(size)).dispatchColorHint(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        if (this.f8493f) {
            return;
        }
        this.f8493f = true;
        this.f8489b.n(this);
        for (int size = this.f8488a.size() - 1; size >= 0; size--) {
            ((Protection) this.f8488a.get(size)).setController(null);
        }
        this.f8488a.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Protection h(int i11) {
        return (Protection) this.f8488a.get(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int i() {
        return this.f8488a.size();
    }
}
