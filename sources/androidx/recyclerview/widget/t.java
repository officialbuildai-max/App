package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: classes2.dex */
class t {

    /* renamed from: a, reason: collision with root package name */
    final b f14504a;

    /* renamed from: b, reason: collision with root package name */
    a f14505b = new a();

    /* loaded from: classes2.dex */
    static class a {

        /* renamed from: a, reason: collision with root package name */
        int f14506a = 0;

        /* renamed from: b, reason: collision with root package name */
        int f14507b;

        /* renamed from: c, reason: collision with root package name */
        int f14508c;

        /* renamed from: d, reason: collision with root package name */
        int f14509d;

        /* renamed from: e, reason: collision with root package name */
        int f14510e;

        a() {
        }

        void a(int i11) {
            this.f14506a = i11 | this.f14506a;
        }

        boolean b() {
            int i11 = this.f14506a;
            if ((i11 & 7) != 0 && (i11 & c(this.f14509d, this.f14507b)) == 0) {
                return false;
            }
            int i12 = this.f14506a;
            if ((i12 & 112) != 0 && (i12 & (c(this.f14509d, this.f14508c) << 4)) == 0) {
                return false;
            }
            int i13 = this.f14506a;
            if ((i13 & 1792) != 0 && (i13 & (c(this.f14510e, this.f14507b) << 8)) == 0) {
                return false;
            }
            int i14 = this.f14506a;
            return (i14 & 28672) == 0 || (i14 & (c(this.f14510e, this.f14508c) << 12)) != 0;
        }

        int c(int i11, int i12) {
            if (i11 > i12) {
                return 1;
            }
            return i11 == i12 ? 2 : 4;
        }

        void d() {
            this.f14506a = 0;
        }

        void e(int i11, int i12, int i13, int i14) {
            this.f14507b = i11;
            this.f14508c = i12;
            this.f14509d = i13;
            this.f14510e = i14;
        }
    }

    /* loaded from: classes2.dex */
    interface b {
        int a(View view);

        int b();

        int c();

        int d(View view);

        View getChildAt(int i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(b bVar) {
        this.f14504a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View a(int i11, int i12, int i13, int i14) {
        int b11 = this.f14504a.b();
        int c11 = this.f14504a.c();
        int i15 = i12 > i11 ? 1 : -1;
        View view = null;
        while (i11 != i12) {
            View childAt = this.f14504a.getChildAt(i11);
            this.f14505b.e(b11, c11, this.f14504a.a(childAt), this.f14504a.d(childAt));
            if (i13 != 0) {
                this.f14505b.d();
                this.f14505b.a(i13);
                if (this.f14505b.b()) {
                    return childAt;
                }
            }
            if (i14 != 0) {
                this.f14505b.d();
                this.f14505b.a(i14);
                if (this.f14505b.b()) {
                    view = childAt;
                }
            }
            i11 += i15;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(View view, int i11) {
        this.f14505b.e(this.f14504a.b(), this.f14504a.c(), this.f14504a.a(view), this.f14504a.d(view));
        if (i11 == 0) {
            return false;
        }
        this.f14505b.d();
        this.f14505b.a(i11);
        return this.f14505b.b();
    }
}
