package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CompoundButton;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final CompoundButton f2057a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f2058b = null;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f2059c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2060d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f2061e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2062f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(CompoundButton compoundButton) {
        this.f2057a = compoundButton;
    }

    void a() {
        Drawable a11 = androidx.core.widget.c.a(this.f2057a);
        if (a11 != null) {
            if (this.f2060d || this.f2061e) {
                Drawable mutate = a1.a.r(a11).mutate();
                if (this.f2060d) {
                    a1.a.o(mutate, this.f2058b);
                }
                if (this.f2061e) {
                    a1.a.p(mutate, this.f2059c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f2057a.getDrawableState());
                }
                this.f2057a.setButtonDrawable(mutate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.f2058b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        return this.f2059c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0064 A[Catch: all -> 0x003d, TryCatch #1 {all -> 0x003d, blocks: (B:3:0x001f, B:5:0x0027, B:8:0x002f, B:9:0x005c, B:11:0x0064, B:12:0x006f, B:14:0x0077, B:21:0x003f, B:23:0x0047, B:25:0x004f), top: B:2:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0077 A[Catch: all -> 0x003d, TRY_LEAVE, TryCatch #1 {all -> 0x003d, blocks: (B:3:0x001f, B:5:0x0027, B:8:0x002f, B:9:0x005c, B:11:0x0064, B:12:0x006f, B:14:0x0077, B:21:0x003f, B:23:0x0047, B:25:0x004f), top: B:2:0x001f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d(android.util.AttributeSet r11, int r12) {
        /*
            r10 = this;
            android.widget.CompoundButton r0 = r10.f2057a
            android.content.Context r0 = r0.getContext()
            int[] r1 = androidx.appcompat.R$styleable.CompoundButton
            r2 = 0
            androidx.appcompat.widget.j0 r0 = androidx.appcompat.widget.j0.v(r0, r11, r1, r12, r2)
            android.widget.CompoundButton r3 = r10.f2057a
            android.content.Context r4 = r3.getContext()
            int[] r5 = androidx.appcompat.R$styleable.CompoundButton
            android.content.res.TypedArray r7 = r0.r()
            r9 = 0
            r6 = r11
            r8 = r12
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r3, r4, r5, r6, r7, r8, r9)
            int r11 = androidx.appcompat.R$styleable.CompoundButton_buttonCompat     // Catch: java.lang.Throwable -> L3d
            boolean r11 = r0.s(r11)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L3f
            int r11 = androidx.appcompat.R$styleable.CompoundButton_buttonCompat     // Catch: java.lang.Throwable -> L3d
            int r11 = r0.n(r11, r2)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L3f
            android.widget.CompoundButton r12 = r10.f2057a     // Catch: java.lang.Throwable -> L3d android.content.res.Resources.NotFoundException -> L3f
            android.content.Context r1 = r12.getContext()     // Catch: java.lang.Throwable -> L3d android.content.res.Resources.NotFoundException -> L3f
            android.graphics.drawable.Drawable r11 = g.a.b(r1, r11)     // Catch: java.lang.Throwable -> L3d android.content.res.Resources.NotFoundException -> L3f
            r12.setButtonDrawable(r11)     // Catch: java.lang.Throwable -> L3d android.content.res.Resources.NotFoundException -> L3f
            goto L5c
        L3d:
            r11 = move-exception
            goto L8c
        L3f:
            int r11 = androidx.appcompat.R$styleable.CompoundButton_android_button     // Catch: java.lang.Throwable -> L3d
            boolean r11 = r0.s(r11)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L5c
            int r11 = androidx.appcompat.R$styleable.CompoundButton_android_button     // Catch: java.lang.Throwable -> L3d
            int r11 = r0.n(r11, r2)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L5c
            android.widget.CompoundButton r12 = r10.f2057a     // Catch: java.lang.Throwable -> L3d
            android.content.Context r1 = r12.getContext()     // Catch: java.lang.Throwable -> L3d
            android.graphics.drawable.Drawable r11 = g.a.b(r1, r11)     // Catch: java.lang.Throwable -> L3d
            r12.setButtonDrawable(r11)     // Catch: java.lang.Throwable -> L3d
        L5c:
            int r11 = androidx.appcompat.R$styleable.CompoundButton_buttonTint     // Catch: java.lang.Throwable -> L3d
            boolean r11 = r0.s(r11)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L6f
            android.widget.CompoundButton r11 = r10.f2057a     // Catch: java.lang.Throwable -> L3d
            int r12 = androidx.appcompat.R$styleable.CompoundButton_buttonTint     // Catch: java.lang.Throwable -> L3d
            android.content.res.ColorStateList r12 = r0.c(r12)     // Catch: java.lang.Throwable -> L3d
            androidx.core.widget.c.d(r11, r12)     // Catch: java.lang.Throwable -> L3d
        L6f:
            int r11 = androidx.appcompat.R$styleable.CompoundButton_buttonTintMode     // Catch: java.lang.Throwable -> L3d
            boolean r11 = r0.s(r11)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L88
            android.widget.CompoundButton r11 = r10.f2057a     // Catch: java.lang.Throwable -> L3d
            int r12 = androidx.appcompat.R$styleable.CompoundButton_buttonTintMode     // Catch: java.lang.Throwable -> L3d
            r1 = -1
            int r12 = r0.k(r12, r1)     // Catch: java.lang.Throwable -> L3d
            r1 = 0
            android.graphics.PorterDuff$Mode r12 = androidx.appcompat.widget.y.e(r12, r1)     // Catch: java.lang.Throwable -> L3d
            androidx.core.widget.c.e(r11, r12)     // Catch: java.lang.Throwable -> L3d
        L88:
            r0.x()
            return
        L8c:
            r0.x()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.e.d(android.util.AttributeSet, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.f2062f) {
            this.f2062f = false;
        } else {
            this.f2062f = true;
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ColorStateList colorStateList) {
        this.f2058b = colorStateList;
        this.f2060d = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(PorterDuff.Mode mode) {
        this.f2059c = mode;
        this.f2061e = true;
        a();
    }
}
