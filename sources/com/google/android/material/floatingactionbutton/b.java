package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Property;
import android.view.View;
import androidx.core.util.i;
import java.util.ArrayList;
import java.util.List;
import oa.h;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public abstract class b implements f {

    /* renamed from: a, reason: collision with root package name */
    private final Context f29035a;

    /* renamed from: b, reason: collision with root package name */
    private final ExtendedFloatingActionButton f29036b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayList f29037c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private final com.google.android.material.floatingactionbutton.a f29038d;

    /* renamed from: e, reason: collision with root package name */
    private h f29039e;

    /* renamed from: f, reason: collision with root package name */
    private h f29040f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(ExtendedFloatingActionButton extendedFloatingActionButton) {
            return Float.valueOf(oa.a.a(0.0f, 1.0f, (Color.alpha(extendedFloatingActionButton.getCurrentTextColor()) / 255.0f) / Color.alpha(extendedFloatingActionButton.E.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.f29036b.E.getDefaultColor()))));
        }

        @Override // android.util.Property
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(ExtendedFloatingActionButton extendedFloatingActionButton, Float f11) {
            int colorForState = extendedFloatingActionButton.E.getColorForState(extendedFloatingActionButton.getDrawableState(), b.this.f29036b.E.getDefaultColor());
            ColorStateList valueOf = ColorStateList.valueOf(Color.argb((int) (oa.a.a(0.0f, Color.alpha(colorForState) / 255.0f, f11.floatValue()) * 255.0f), Color.red(colorForState), Color.green(colorForState), Color.blue(colorForState)));
            if (f11.floatValue() == 1.0f) {
                extendedFloatingActionButton.B(extendedFloatingActionButton.E);
            } else {
                extendedFloatingActionButton.B(valueOf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(ExtendedFloatingActionButton extendedFloatingActionButton, com.google.android.material.floatingactionbutton.a aVar) {
        this.f29036b = extendedFloatingActionButton;
        this.f29035a = extendedFloatingActionButton.getContext();
        this.f29038d = aVar;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public void a() {
        this.f29038d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public h c() {
        return this.f29040f;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final void e(Animator.AnimatorListener animatorListener) {
        this.f29037c.remove(animatorListener);
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public void f() {
        this.f29038d.b();
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final void h(Animator.AnimatorListener animatorListener) {
        this.f29037c.add(animatorListener);
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final void i(h hVar) {
        this.f29040f = hVar;
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public AnimatorSet j() {
        return n(o());
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public final List k() {
        return this.f29037c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimatorSet n(h hVar) {
        ArrayList arrayList = new ArrayList();
        if (hVar.j("opacity")) {
            arrayList.add(hVar.f("opacity", this.f29036b, View.ALPHA));
        }
        if (hVar.j("scale")) {
            arrayList.add(hVar.f("scale", this.f29036b, View.SCALE_Y));
            arrayList.add(hVar.f("scale", this.f29036b, View.SCALE_X));
        }
        if (hVar.j("width")) {
            arrayList.add(hVar.f("width", this.f29036b, ExtendedFloatingActionButton.J));
        }
        if (hVar.j("height")) {
            arrayList.add(hVar.f("height", this.f29036b, ExtendedFloatingActionButton.K));
        }
        if (hVar.j("paddingStart")) {
            arrayList.add(hVar.f("paddingStart", this.f29036b, ExtendedFloatingActionButton.L));
        }
        if (hVar.j("paddingEnd")) {
            arrayList.add(hVar.f("paddingEnd", this.f29036b, ExtendedFloatingActionButton.M));
        }
        if (hVar.j("labelOpacity")) {
            arrayList.add(hVar.f("labelOpacity", this.f29036b, new a(Float.class, "LABEL_OPACITY_PROPERTY")));
        }
        AnimatorSet animatorSet = new AnimatorSet();
        oa.b.a(animatorSet, arrayList);
        return animatorSet;
    }

    public final h o() {
        h hVar = this.f29040f;
        if (hVar != null) {
            return hVar;
        }
        if (this.f29039e == null) {
            this.f29039e = h.d(this.f29035a, g());
        }
        return (h) i.g(this.f29039e);
    }

    @Override // com.google.android.material.floatingactionbutton.f
    public void onAnimationStart(Animator animator) {
        this.f29038d.c(animator);
    }
}
