package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements c {
    private d p(b bVar) {
        return (d) bVar.d();
    }

    @Override // androidx.cardview.widget.c
    public void a(b bVar, float f11) {
        p(bVar).h(f11);
    }

    @Override // androidx.cardview.widget.c
    public float b(b bVar) {
        return p(bVar).d();
    }

    @Override // androidx.cardview.widget.c
    public void c(b bVar, float f11) {
        bVar.f().setElevation(f11);
    }

    @Override // androidx.cardview.widget.c
    public float d(b bVar) {
        return p(bVar).c();
    }

    @Override // androidx.cardview.widget.c
    public ColorStateList e(b bVar) {
        return p(bVar).b();
    }

    @Override // androidx.cardview.widget.c
    public float f(b bVar) {
        return b(bVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.c
    public void g(b bVar) {
        o(bVar, d(bVar));
    }

    @Override // androidx.cardview.widget.c
    public void h(b bVar, Context context, ColorStateList colorStateList, float f11, float f12, float f13) {
        bVar.b(new d(colorStateList, f11));
        View f14 = bVar.f();
        f14.setClipToOutline(true);
        f14.setElevation(f12);
        o(bVar, f13);
    }

    @Override // androidx.cardview.widget.c
    public float i(b bVar) {
        return bVar.f().getElevation();
    }

    @Override // androidx.cardview.widget.c
    public void j(b bVar) {
        o(bVar, d(bVar));
    }

    @Override // androidx.cardview.widget.c
    public void k(b bVar) {
        if (!bVar.c()) {
            bVar.a(0, 0, 0, 0);
            return;
        }
        float d11 = d(bVar);
        float b11 = b(bVar);
        int ceil = (int) Math.ceil(e.a(d11, b11, bVar.e()));
        int ceil2 = (int) Math.ceil(e.b(d11, b11, bVar.e()));
        bVar.a(ceil, ceil2, ceil, ceil2);
    }

    @Override // androidx.cardview.widget.c
    public void l() {
    }

    @Override // androidx.cardview.widget.c
    public float m(b bVar) {
        return b(bVar) * 2.0f;
    }

    @Override // androidx.cardview.widget.c
    public void n(b bVar, ColorStateList colorStateList) {
        p(bVar).f(colorStateList);
    }

    @Override // androidx.cardview.widget.c
    public void o(b bVar, float f11) {
        p(bVar).g(f11, bVar.c(), bVar.e());
        k(bVar);
    }
}
