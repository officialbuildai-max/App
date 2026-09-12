package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    final b f14444a;

    /* renamed from: b, reason: collision with root package name */
    final a f14445b = new a();

    /* renamed from: c, reason: collision with root package name */
    final List f14446c = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        long f14447a = 0;

        /* renamed from: b, reason: collision with root package name */
        a f14448b;

        a() {
        }

        private void c() {
            if (this.f14448b == null) {
                this.f14448b = new a();
            }
        }

        void a(int i11) {
            if (i11 < 64) {
                this.f14447a &= ~(1 << i11);
                return;
            }
            a aVar = this.f14448b;
            if (aVar != null) {
                aVar.a(i11 - 64);
            }
        }

        int b(int i11) {
            a aVar = this.f14448b;
            return aVar == null ? i11 >= 64 ? Long.bitCount(this.f14447a) : Long.bitCount(this.f14447a & ((1 << i11) - 1)) : i11 < 64 ? Long.bitCount(this.f14447a & ((1 << i11) - 1)) : aVar.b(i11 - 64) + Long.bitCount(this.f14447a);
        }

        boolean d(int i11) {
            if (i11 < 64) {
                return (this.f14447a & (1 << i11)) != 0;
            }
            c();
            return this.f14448b.d(i11 - 64);
        }

        void e(int i11, boolean z10) {
            if (i11 >= 64) {
                c();
                this.f14448b.e(i11 - 64, z10);
                return;
            }
            long j11 = this.f14447a;
            boolean z11 = (Long.MIN_VALUE & j11) != 0;
            long j12 = (1 << i11) - 1;
            this.f14447a = ((j11 & (~j12)) << 1) | (j11 & j12);
            if (z10) {
                h(i11);
            } else {
                a(i11);
            }
            if (z11 || this.f14448b != null) {
                c();
                this.f14448b.e(0, z11);
            }
        }

        boolean f(int i11) {
            if (i11 >= 64) {
                c();
                return this.f14448b.f(i11 - 64);
            }
            long j11 = 1 << i11;
            long j12 = this.f14447a;
            boolean z10 = (j12 & j11) != 0;
            long j13 = j12 & (~j11);
            this.f14447a = j13;
            long j14 = j11 - 1;
            this.f14447a = (j13 & j14) | Long.rotateRight((~j14) & j13, 1);
            a aVar = this.f14448b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.f14448b.f(0);
            }
            return z10;
        }

        void g() {
            this.f14447a = 0L;
            a aVar = this.f14448b;
            if (aVar != null) {
                aVar.g();
            }
        }

        void h(int i11) {
            if (i11 < 64) {
                this.f14447a |= 1 << i11;
            } else {
                c();
                this.f14448b.h(i11 - 64);
            }
        }

        public String toString() {
            if (this.f14448b == null) {
                return Long.toBinaryString(this.f14447a);
            }
            return this.f14448b.toString() + "xx" + Long.toBinaryString(this.f14447a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface b {
        void a(View view);

        RecyclerView.b0 b(View view);

        void c(int i11);

        void d(View view, int i11);

        void e();

        int f(View view);

        void g(View view);

        View getChildAt(int i11);

        int getChildCount();

        void h(int i11);

        void i(View view, int i11, ViewGroup.LayoutParams layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.f14444a = bVar;
    }

    private int h(int i11) {
        if (i11 < 0) {
            return -1;
        }
        int childCount = this.f14444a.getChildCount();
        int i12 = i11;
        while (i12 < childCount) {
            int b11 = i11 - (i12 - this.f14445b.b(i12));
            if (b11 == 0) {
                while (this.f14445b.d(i12)) {
                    i12++;
                }
                return i12;
            }
            i12 += b11;
        }
        return -1;
    }

    private void l(View view) {
        this.f14446c.add(view);
        this.f14444a.a(view);
    }

    private boolean t(View view) {
        if (!this.f14446c.remove(view)) {
            return false;
        }
        this.f14444a.g(view);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(View view, int i11, boolean z10) {
        int childCount = i11 < 0 ? this.f14444a.getChildCount() : h(i11);
        this.f14445b.e(childCount, z10);
        if (z10) {
            l(view);
        }
        this.f14444a.d(view, childCount);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(View view, boolean z10) {
        a(view, -1, z10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(View view, int i11, ViewGroup.LayoutParams layoutParams, boolean z10) {
        int childCount = i11 < 0 ? this.f14444a.getChildCount() : h(i11);
        this.f14445b.e(childCount, z10);
        if (z10) {
            l(view);
        }
        this.f14444a.i(view, childCount, layoutParams);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i11) {
        int h11 = h(i11);
        this.f14445b.f(h11);
        this.f14444a.c(h11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View e(int i11) {
        int size = this.f14446c.size();
        for (int i12 = 0; i12 < size; i12++) {
            View view = (View) this.f14446c.get(i12);
            RecyclerView.b0 b11 = this.f14444a.b(view);
            if (b11.getLayoutPosition() == i11 && !b11.isInvalid() && !b11.isRemoved()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View f(int i11) {
        return this.f14444a.getChildAt(h(i11));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f14444a.getChildCount() - this.f14446c.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View i(int i11) {
        return this.f14444a.getChildAt(i11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        return this.f14444a.getChildCount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(View view) {
        int f11 = this.f14444a.f(view);
        if (f11 >= 0) {
            this.f14445b.h(f11);
            l(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(View view) {
        int f11 = this.f14444a.f(view);
        if (f11 == -1 || this.f14445b.d(f11)) {
            return -1;
        }
        return f11 - this.f14445b.b(f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean n(View view) {
        return this.f14446c.contains(view);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o() {
        this.f14445b.g();
        for (int size = this.f14446c.size() - 1; size >= 0; size--) {
            this.f14444a.g((View) this.f14446c.get(size));
            this.f14446c.remove(size);
        }
        this.f14444a.e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(View view) {
        int f11 = this.f14444a.f(view);
        if (f11 < 0) {
            return;
        }
        if (this.f14445b.f(f11)) {
            t(view);
        }
        this.f14444a.h(f11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(int i11) {
        int h11 = h(i11);
        View childAt = this.f14444a.getChildAt(h11);
        if (childAt == null) {
            return;
        }
        if (this.f14445b.f(h11)) {
            t(childAt);
        }
        this.f14444a.h(h11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(View view) {
        int f11 = this.f14444a.f(view);
        if (f11 == -1) {
            t(view);
            return true;
        }
        if (!this.f14445b.d(f11)) {
            return false;
        }
        this.f14445b.f(f11);
        t(view);
        this.f14444a.h(f11);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void s(View view) {
        int f11 = this.f14444a.f(view);
        if (f11 < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (this.f14445b.d(f11)) {
            this.f14445b.a(f11);
            t(view);
        } else {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
    }

    public String toString() {
        return this.f14445b.toString() + ", hidden list:" + this.f14446c.size();
    }
}
