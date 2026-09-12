package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;

/* loaded from: classes.dex */
class d {

    /* renamed from: a, reason: collision with root package name */
    private final CheckedTextView f2043a;

    /* renamed from: b, reason: collision with root package name */
    private ColorStateList f2044b = null;

    /* renamed from: c, reason: collision with root package name */
    private PorterDuff.Mode f2045c = null;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2046d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f2047e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f2048f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(CheckedTextView checkedTextView) {
        this.f2043a = checkedTextView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        Drawable a11 = androidx.core.widget.b.a(this.f2043a);
        if (a11 != null) {
            if (this.f2046d || this.f2047e) {
                Drawable mutate = a1.a.r(a11).mutate();
                if (this.f2046d) {
                    a1.a.o(mutate, this.f2044b);
                }
                if (this.f2047e) {
                    a1.a.p(mutate, this.f2045c);
                }
                if (mutate.isStateful()) {
                    mutate.setState(this.f2043a.getDrawableState());
                }
                this.f2043a.setCheckMarkDrawable(mutate);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList b() {
        return this.f2044b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PorterDuff.Mode c() {
        return this.f2045c;
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
            android.widget.CheckedTextView r0 = r10.f2043a
            android.content.Context r0 = r0.getContext()
            int[] r1 = androidx.appcompat.R$styleable.CheckedTextView
            r2 = 0
            androidx.appcompat.widget.j0 r0 = androidx.appcompat.widget.j0.v(r0, r11, r1, r12, r2)
            android.widget.CheckedTextView r3 = r10.f2043a
            android.content.Context r4 = r3.getContext()
            int[] r5 = androidx.appcompat.R$styleable.CheckedTextView
            android.content.res.TypedArray r7 = r0.r()
            r9 = 0
            r6 = r11
            r8 = r12
            androidx.core.view.ViewCompat.saveAttributeDataForStyleable(r3, r4, r5, r6, r7, r8, r9)
            int r11 = androidx.appcompat.R$styleable.CheckedTextView_checkMarkCompat     // Catch: java.lang.Throwable -> L3d
            boolean r11 = r0.s(r11)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L3f
            int r11 = androidx.appcompat.R$styleable.CheckedTextView_checkMarkCompat     // Catch: java.lang.Throwable -> L3d
            int r11 = r0.n(r11, r2)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L3f
            android.widget.CheckedTextView r12 = r10.f2043a     // Catch: java.lang.Throwable -> L3d android.content.res.Resources.NotFoundException -> L3f
            android.content.Context r1 = r12.getContext()     // Catch: java.lang.Throwable -> L3d android.content.res.Resources.NotFoundException -> L3f
            android.graphics.drawable.Drawable r11 = g.a.b(r1, r11)     // Catch: java.lang.Throwable -> L3d android.content.res.Resources.NotFoundException -> L3f
            r12.setCheckMarkDrawable(r11)     // Catch: java.lang.Throwable -> L3d android.content.res.Resources.NotFoundException -> L3f
            goto L5c
        L3d:
            r11 = move-exception
            goto L8c
        L3f:
            int r11 = androidx.appcompat.R$styleable.CheckedTextView_android_checkMark     // Catch: java.lang.Throwable -> L3d
            boolean r11 = r0.s(r11)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L5c
            int r11 = androidx.appcompat.R$styleable.CheckedTextView_android_checkMark     // Catch: java.lang.Throwable -> L3d
            int r11 = r0.n(r11, r2)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L5c
            android.widget.CheckedTextView r12 = r10.f2043a     // Catch: java.lang.Throwable -> L3d
            android.content.Context r1 = r12.getContext()     // Catch: java.lang.Throwable -> L3d
            android.graphics.drawable.Drawable r11 = g.a.b(r1, r11)     // Catch: java.lang.Throwable -> L3d
            r12.setCheckMarkDrawable(r11)     // Catch: java.lang.Throwable -> L3d
        L5c:
            int r11 = androidx.appcompat.R$styleable.CheckedTextView_checkMarkTint     // Catch: java.lang.Throwable -> L3d
            boolean r11 = r0.s(r11)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L6f
            android.widget.CheckedTextView r11 = r10.f2043a     // Catch: java.lang.Throwable -> L3d
            int r12 = androidx.appcompat.R$styleable.CheckedTextView_checkMarkTint     // Catch: java.lang.Throwable -> L3d
            android.content.res.ColorStateList r12 = r0.c(r12)     // Catch: java.lang.Throwable -> L3d
            androidx.core.widget.b.b(r11, r12)     // Catch: java.lang.Throwable -> L3d
        L6f:
            int r11 = androidx.appcompat.R$styleable.CheckedTextView_checkMarkTintMode     // Catch: java.lang.Throwable -> L3d
            boolean r11 = r0.s(r11)     // Catch: java.lang.Throwable -> L3d
            if (r11 == 0) goto L88
            android.widget.CheckedTextView r11 = r10.f2043a     // Catch: java.lang.Throwable -> L3d
            int r12 = androidx.appcompat.R$styleable.CheckedTextView_checkMarkTintMode     // Catch: java.lang.Throwable -> L3d
            r1 = -1
            int r12 = r0.k(r12, r1)     // Catch: java.lang.Throwable -> L3d
            r1 = 0
            android.graphics.PorterDuff$Mode r12 = androidx.appcompat.widget.y.e(r12, r1)     // Catch: java.lang.Throwable -> L3d
            androidx.core.widget.b.c(r11, r12)     // Catch: java.lang.Throwable -> L3d
        L88:
            r0.x()
            return
        L8c:
            r0.x()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.d.d(android.util.AttributeSet, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e() {
        if (this.f2048f) {
            this.f2048f = false;
        } else {
            this.f2048f = true;
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(ColorStateList colorStateList) {
        this.f2044b = colorStateList;
        this.f2046d = true;
        a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(PorterDuff.Mode mode) {
        this.f2045c = mode;
        this.f2047e = true;
        a();
    }
}
