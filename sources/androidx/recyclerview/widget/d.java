package androidx.recyclerview.widget;

/* loaded from: classes2.dex */
public class d implements j {

    /* renamed from: a, reason: collision with root package name */
    final j f14439a;

    /* renamed from: b, reason: collision with root package name */
    int f14440b = 0;

    /* renamed from: c, reason: collision with root package name */
    int f14441c = -1;

    /* renamed from: d, reason: collision with root package name */
    int f14442d = -1;

    /* renamed from: e, reason: collision with root package name */
    Object f14443e = null;

    public d(j jVar) {
        this.f14439a = jVar;
    }

    public void a() {
        int i11 = this.f14440b;
        if (i11 == 0) {
            return;
        }
        if (i11 == 1) {
            this.f14439a.onInserted(this.f14441c, this.f14442d);
        } else if (i11 == 2) {
            this.f14439a.onRemoved(this.f14441c, this.f14442d);
        } else if (i11 == 3) {
            this.f14439a.onChanged(this.f14441c, this.f14442d, this.f14443e);
        }
        this.f14443e = null;
        this.f14440b = 0;
    }

    @Override // androidx.recyclerview.widget.j
    public void onChanged(int i11, int i12, Object obj) {
        int i13;
        if (this.f14440b == 3) {
            int i14 = this.f14441c;
            int i15 = this.f14442d;
            if (i11 <= i14 + i15 && (i13 = i11 + i12) >= i14 && this.f14443e == obj) {
                this.f14441c = Math.min(i11, i14);
                this.f14442d = Math.max(i15 + i14, i13) - this.f14441c;
                return;
            }
        }
        a();
        this.f14441c = i11;
        this.f14442d = i12;
        this.f14443e = obj;
        this.f14440b = 3;
    }

    @Override // androidx.recyclerview.widget.j
    public void onInserted(int i11, int i12) {
        int i13;
        if (this.f14440b == 1 && i11 >= (i13 = this.f14441c)) {
            int i14 = this.f14442d;
            if (i11 <= i13 + i14) {
                this.f14442d = i14 + i12;
                this.f14441c = Math.min(i11, i13);
                return;
            }
        }
        a();
        this.f14441c = i11;
        this.f14442d = i12;
        this.f14440b = 1;
    }

    @Override // androidx.recyclerview.widget.j
    public void onMoved(int i11, int i12) {
        a();
        this.f14439a.onMoved(i11, i12);
    }

    @Override // androidx.recyclerview.widget.j
    public void onRemoved(int i11, int i12) {
        int i13;
        if (this.f14440b == 2 && (i13 = this.f14441c) >= i11 && i13 <= i11 + i12) {
            this.f14442d += i12;
            this.f14441c = i11;
        } else {
            a();
            this.f14441c = i11;
            this.f14442d = i12;
            this.f14440b = 2;
        }
    }
}
