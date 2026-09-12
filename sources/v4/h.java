package v4;

import androidx.core.os.s;

/* loaded from: classes2.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final String[] f77151a = new String[5];

    /* renamed from: b, reason: collision with root package name */
    private final long[] f77152b = new long[5];

    /* renamed from: c, reason: collision with root package name */
    private int f77153c = 0;

    /* renamed from: d, reason: collision with root package name */
    private int f77154d = 0;

    public void a(String str) {
        int i11 = this.f77153c;
        if (i11 == 5) {
            this.f77154d++;
            return;
        }
        this.f77151a[i11] = str;
        this.f77152b[i11] = System.nanoTime();
        s.a(str);
        this.f77153c++;
    }

    public float b(String str) {
        int i11 = this.f77154d;
        if (i11 > 0) {
            this.f77154d = i11 - 1;
            return 0.0f;
        }
        int i12 = this.f77153c - 1;
        this.f77153c = i12;
        if (i12 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(this.f77151a[i12])) {
            s.b();
            return ((float) (System.nanoTime() - this.f77152b[this.f77153c])) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + this.f77151a[this.f77153c] + ".");
    }
}
