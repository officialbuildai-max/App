package z0;

import android.graphics.Insets;
import android.graphics.Rect;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: e, reason: collision with root package name */
    public static final c f79247e = new c(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f79248a;

    /* renamed from: b, reason: collision with root package name */
    public final int f79249b;

    /* renamed from: c, reason: collision with root package name */
    public final int f79250c;

    /* renamed from: d, reason: collision with root package name */
    public final int f79251d;

    /* loaded from: classes2.dex */
    static class a {
        static Insets a(int i11, int i12, int i13, int i14) {
            return Insets.of(i11, i12, i13, i14);
        }
    }

    private c(int i11, int i12, int i13, int i14) {
        this.f79248a = i11;
        this.f79249b = i12;
        this.f79250c = i13;
        this.f79251d = i14;
    }

    public static c a(c cVar, c cVar2) {
        return c(Math.max(cVar.f79248a, cVar2.f79248a), Math.max(cVar.f79249b, cVar2.f79249b), Math.max(cVar.f79250c, cVar2.f79250c), Math.max(cVar.f79251d, cVar2.f79251d));
    }

    public static c b(c cVar, c cVar2) {
        return c(Math.min(cVar.f79248a, cVar2.f79248a), Math.min(cVar.f79249b, cVar2.f79249b), Math.min(cVar.f79250c, cVar2.f79250c), Math.min(cVar.f79251d, cVar2.f79251d));
    }

    public static c c(int i11, int i12, int i13, int i14) {
        return (i11 == 0 && i12 == 0 && i13 == 0 && i14 == 0) ? f79247e : new c(i11, i12, i13, i14);
    }

    public static c d(Rect rect) {
        return c(rect.left, rect.top, rect.right, rect.bottom);
    }

    public static c e(c cVar, c cVar2) {
        return c(cVar.f79248a - cVar2.f79248a, cVar.f79249b - cVar2.f79249b, cVar.f79250c - cVar2.f79250c, cVar.f79251d - cVar2.f79251d);
    }

    public static c f(Insets insets) {
        int i11;
        int i12;
        int i13;
        int i14;
        i11 = insets.left;
        i12 = insets.top;
        i13 = insets.right;
        i14 = insets.bottom;
        return c(i11, i12, i13, i14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || c.class != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        return this.f79251d == cVar.f79251d && this.f79248a == cVar.f79248a && this.f79250c == cVar.f79250c && this.f79249b == cVar.f79249b;
    }

    public Insets g() {
        return a.a(this.f79248a, this.f79249b, this.f79250c, this.f79251d);
    }

    public int hashCode() {
        return (((((this.f79248a * 31) + this.f79249b) * 31) + this.f79250c) * 31) + this.f79251d;
    }

    public String toString() {
        return "Insets{left=" + this.f79248a + ", top=" + this.f79249b + ", right=" + this.f79250c + ", bottom=" + this.f79251d + '}';
    }
}
