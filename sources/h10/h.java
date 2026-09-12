package h10;

import java.util.Arrays;

/* loaded from: classes7.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    private final String f64225a;

    /* renamed from: b, reason: collision with root package name */
    private final String f64226b;

    /* renamed from: c, reason: collision with root package name */
    private final o f64227c;

    /* renamed from: d, reason: collision with root package name */
    private final Object[] f64228d;

    public h(String str, String str2, o oVar, Object... objArr) {
        this.f64225a = str;
        this.f64226b = str2;
        this.f64227c = oVar;
        this.f64228d = objArr;
    }

    public o a() {
        return this.f64227c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] b() {
        return this.f64228d;
    }

    public String c() {
        return this.f64226b;
    }

    public String d() {
        return this.f64225a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        return this.f64225a.equals(hVar.f64225a) && this.f64226b.equals(hVar.f64226b) && this.f64227c.equals(hVar.f64227c) && Arrays.equals(this.f64228d, hVar.f64228d);
    }

    public int hashCode() {
        return ((this.f64225a.hashCode() ^ Integer.rotateLeft(this.f64226b.hashCode(), 8)) ^ Integer.rotateLeft(this.f64227c.hashCode(), 16)) ^ Integer.rotateLeft(Arrays.hashCode(this.f64228d), 24);
    }

    public String toString() {
        return this.f64225a + " : " + this.f64226b + ' ' + this.f64227c + ' ' + Arrays.toString(this.f64228d);
    }
}
