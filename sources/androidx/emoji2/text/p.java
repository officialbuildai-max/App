package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;

/* loaded from: classes.dex */
public class p {

    /* renamed from: d, reason: collision with root package name */
    private static final ThreadLocal f9222d = new ThreadLocal();

    /* renamed from: a, reason: collision with root package name */
    private final int f9223a;

    /* renamed from: b, reason: collision with root package name */
    private final n f9224b;

    /* renamed from: c, reason: collision with root package name */
    private volatile int f9225c = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar, int i11) {
        this.f9224b = nVar;
        this.f9223a = i11;
    }

    private androidx.emoji2.text.flatbuffer.b g() {
        ThreadLocal threadLocal = f9222d;
        androidx.emoji2.text.flatbuffer.b bVar = (androidx.emoji2.text.flatbuffer.b) threadLocal.get();
        if (bVar == null) {
            bVar = new androidx.emoji2.text.flatbuffer.b();
            threadLocal.set(bVar);
        }
        this.f9224b.d().k(bVar, this.f9223a);
        return bVar;
    }

    public void a(Canvas canvas, float f11, float f12, Paint paint) {
        Typeface g11 = this.f9224b.g();
        Typeface typeface = paint.getTypeface();
        paint.setTypeface(g11);
        canvas.drawText(this.f9224b.c(), this.f9223a * 2, 2, f11, f12, paint);
        paint.setTypeface(typeface);
    }

    public int b(int i11) {
        return g().i(i11);
    }

    public int c() {
        return g().j();
    }

    public int d() {
        return this.f9225c & 3;
    }

    public int e() {
        return g().l();
    }

    public int f() {
        return g().m();
    }

    public short h() {
        return g().n();
    }

    public int i() {
        return g().o();
    }

    public boolean j() {
        return g().k();
    }

    public boolean k() {
        return (this.f9225c & 4) > 0;
    }

    public void l(boolean z10) {
        int d11 = d();
        if (z10) {
            this.f9225c = d11 | 4;
        } else {
            this.f9225c = d11;
        }
    }

    public void m(boolean z10) {
        int i11 = this.f9225c & 4;
        this.f9225c = z10 ? i11 | 2 : i11 | 1;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append(", id:");
        sb2.append(Integer.toHexString(f()));
        sb2.append(", codepoints:");
        int c11 = c();
        for (int i11 = 0; i11 < c11; i11++) {
            sb2.append(Integer.toHexString(b(i11)));
            sb2.append(" ");
        }
        return sb2.toString();
    }
}
