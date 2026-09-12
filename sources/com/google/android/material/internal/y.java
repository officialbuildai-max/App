package com.google.android.material.internal;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* loaded from: classes4.dex */
public class y {

    /* renamed from: c, reason: collision with root package name */
    private float f29334c;

    /* renamed from: d, reason: collision with root package name */
    private float f29335d;

    /* renamed from: g, reason: collision with root package name */
    private xa.d f29338g;

    /* renamed from: a, reason: collision with root package name */
    private final TextPaint f29332a = new TextPaint(1);

    /* renamed from: b, reason: collision with root package name */
    private final xa.f f29333b = new a();

    /* renamed from: e, reason: collision with root package name */
    private boolean f29336e = true;

    /* renamed from: f, reason: collision with root package name */
    private WeakReference f29337f = new WeakReference(null);

    /* loaded from: classes4.dex */
    class a extends xa.f {
        a() {
        }

        @Override // xa.f
        public void a(int i11) {
            y.this.f29336e = true;
            b bVar = (b) y.this.f29337f.get();
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // xa.f
        public void b(Typeface typeface, boolean z10) {
            if (z10) {
                return;
            }
            y.this.f29336e = true;
            b bVar = (b) y.this.f29337f.get();
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a();

        int[] getState();

        boolean onStateChange(int[] iArr);
    }

    public y(b bVar) {
        j(bVar);
    }

    private float c(String str) {
        if (str == null) {
            return 0.0f;
        }
        return Math.abs(this.f29332a.getFontMetrics().ascent);
    }

    private float d(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f29332a.measureText(charSequence, 0, charSequence.length());
    }

    private void i(String str) {
        this.f29334c = d(str);
        this.f29335d = c(str);
        this.f29336e = false;
    }

    public xa.d e() {
        return this.f29338g;
    }

    public float f(String str) {
        if (!this.f29336e) {
            return this.f29335d;
        }
        i(str);
        return this.f29335d;
    }

    public TextPaint g() {
        return this.f29332a;
    }

    public float h(String str) {
        if (!this.f29336e) {
            return this.f29334c;
        }
        i(str);
        return this.f29334c;
    }

    public void j(b bVar) {
        this.f29337f = new WeakReference(bVar);
    }

    public void k(xa.d dVar, Context context) {
        if (this.f29338g != dVar) {
            this.f29338g = dVar;
            if (dVar != null) {
                dVar.o(context, this.f29332a, this.f29333b);
                b bVar = (b) this.f29337f.get();
                if (bVar != null) {
                    this.f29332a.drawableState = bVar.getState();
                }
                dVar.n(context, this.f29332a, this.f29333b);
                this.f29336e = true;
            }
            b bVar2 = (b) this.f29337f.get();
            if (bVar2 != null) {
                bVar2.a();
                bVar2.onStateChange(bVar2.getState());
            }
        }
    }

    public void l(boolean z10) {
        this.f29336e = z10;
    }

    public void m(boolean z10) {
        this.f29336e = z10;
    }

    public void n(Context context) {
        this.f29338g.n(context, this.f29332a, this.f29333b);
    }
}
