package g00;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private SparseBooleanArray f63179a = new SparseBooleanArray();

    /* renamed from: b, reason: collision with root package name */
    private SparseArray f63180b = new SparseArray();

    /* renamed from: c, reason: collision with root package name */
    private int f63181c;

    /* renamed from: d, reason: collision with root package name */
    private int f63182d;

    /* renamed from: e, reason: collision with root package name */
    private int f63183e;

    /* renamed from: f, reason: collision with root package name */
    private float f63184f;

    /* renamed from: g, reason: collision with root package name */
    private int f63185g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f63186h;

    /* renamed from: i, reason: collision with root package name */
    private a f63187i;

    /* loaded from: classes7.dex */
    public interface a {
        void onDeselected(int i11, int i12);

        void onEnter(int i11, int i12, float f11, boolean z10);

        void onLeave(int i11, int i12, float f11, boolean z10);

        void onSelected(int i11, int i12);
    }

    private void a(int i11) {
        a aVar = this.f63187i;
        if (aVar != null) {
            aVar.onDeselected(i11, this.f63181c);
        }
        this.f63179a.put(i11, true);
    }

    private void b(int i11, float f11, boolean z10, boolean z11) {
        if (this.f63186h || i11 == this.f63182d || this.f63185g == 1 || z11) {
            a aVar = this.f63187i;
            if (aVar != null) {
                aVar.onEnter(i11, this.f63181c, f11, z10);
            }
            this.f63180b.put(i11, Float.valueOf(1.0f - f11));
        }
    }

    private void c(int i11, float f11, boolean z10, boolean z11) {
        if (!this.f63186h && i11 != this.f63183e && this.f63185g != 1) {
            int i12 = this.f63182d;
            if (((i11 != i12 - 1 && i11 != i12 + 1) || ((Float) this.f63180b.get(i11, Float.valueOf(0.0f))).floatValue() == 1.0f) && !z11) {
                return;
            }
        }
        a aVar = this.f63187i;
        if (aVar != null) {
            aVar.onLeave(i11, this.f63181c, f11, z10);
        }
        this.f63180b.put(i11, Float.valueOf(f11));
    }

    private void d(int i11) {
        a aVar = this.f63187i;
        if (aVar != null) {
            aVar.onSelected(i11, this.f63181c);
        }
        this.f63179a.put(i11, false);
    }

    public int e() {
        return this.f63182d;
    }

    public int f() {
        return this.f63185g;
    }

    public int g() {
        return this.f63181c;
    }

    public void h(int i11) {
        this.f63185g = i11;
    }

    public void i(int i11, float f11, int i12) {
        boolean z10;
        float f12 = i11 + f11;
        float f13 = this.f63184f;
        boolean z11 = f13 <= f12;
        if (this.f63185g == 0) {
            for (int i13 = 0; i13 < this.f63181c; i13++) {
                if (i13 != this.f63182d) {
                    if (!this.f63179a.get(i13)) {
                        a(i13);
                    }
                    if (((Float) this.f63180b.get(i13, Float.valueOf(0.0f))).floatValue() != 1.0f) {
                        c(i13, 1.0f, false, true);
                    }
                }
            }
            b(this.f63182d, 1.0f, false, true);
            d(this.f63182d);
        } else {
            if (f12 == f13) {
                return;
            }
            int i14 = i11 + 1;
            if (f11 == 0.0f && z11) {
                i14 = i11 - 1;
                z10 = false;
            } else {
                z10 = true;
            }
            for (int i15 = 0; i15 < this.f63181c; i15++) {
                if (i15 != i11 && i15 != i14 && ((Float) this.f63180b.get(i15, Float.valueOf(0.0f))).floatValue() != 1.0f) {
                    c(i15, 1.0f, z11, true);
                }
            }
            if (!z10) {
                float f14 = 1.0f - f11;
                c(i14, f14, true, false);
                b(i11, f14, true, false);
            } else if (z11) {
                c(i11, f11, true, false);
                b(i14, f11, true, false);
            } else {
                float f15 = 1.0f - f11;
                c(i14, f15, false, false);
                b(i11, f15, false, false);
            }
        }
        this.f63184f = f12;
    }

    public void j(int i11) {
        this.f63183e = this.f63182d;
        this.f63182d = i11;
        d(i11);
        for (int i12 = 0; i12 < this.f63181c; i12++) {
            if (i12 != this.f63182d && !this.f63179a.get(i12)) {
                a(i12);
            }
        }
    }

    public void k(a aVar) {
        this.f63187i = aVar;
    }

    public void l(boolean z10) {
        this.f63186h = z10;
    }

    public void m(int i11) {
        this.f63181c = i11;
        this.f63179a.clear();
        this.f63180b.clear();
    }
}
