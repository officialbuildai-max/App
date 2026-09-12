package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class a implements l.a {

    /* renamed from: a, reason: collision with root package name */
    private androidx.core.util.f f14418a;

    /* renamed from: b, reason: collision with root package name */
    final ArrayList f14419b;

    /* renamed from: c, reason: collision with root package name */
    final ArrayList f14420c;

    /* renamed from: d, reason: collision with root package name */
    final InterfaceC0119a f14421d;

    /* renamed from: e, reason: collision with root package name */
    Runnable f14422e;

    /* renamed from: f, reason: collision with root package name */
    final boolean f14423f;

    /* renamed from: g, reason: collision with root package name */
    final l f14424g;

    /* renamed from: h, reason: collision with root package name */
    private int f14425h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.recyclerview.widget.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0119a {
        void a(int i11, int i12);

        void b(b bVar);

        void c(b bVar);

        void d(int i11, int i12);

        void e(int i11, int i12, Object obj);

        RecyclerView.b0 f(int i11);

        void g(int i11, int i12);

        void h(int i11, int i12);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        int f14426a;

        /* renamed from: b, reason: collision with root package name */
        int f14427b;

        /* renamed from: c, reason: collision with root package name */
        Object f14428c;

        /* renamed from: d, reason: collision with root package name */
        int f14429d;

        b(int i11, int i12, int i13, Object obj) {
            this.f14426a = i11;
            this.f14427b = i12;
            this.f14429d = i13;
            this.f14428c = obj;
        }

        String a() {
            int i11 = this.f14426a;
            return i11 != 1 ? i11 != 2 ? i11 != 4 ? i11 != 8 ? "??" : "mv" : "up" : "rm" : "add";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            int i11 = this.f14426a;
            if (i11 != bVar.f14426a) {
                return false;
            }
            if (i11 == 8 && Math.abs(this.f14429d - this.f14427b) == 1 && this.f14429d == bVar.f14427b && this.f14427b == bVar.f14429d) {
                return true;
            }
            if (this.f14429d != bVar.f14429d || this.f14427b != bVar.f14427b) {
                return false;
            }
            Object obj2 = this.f14428c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f14428c)) {
                    return false;
                }
            } else if (bVar.f14428c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f14426a * 31) + this.f14427b) * 31) + this.f14429d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + a() + ",s:" + this.f14427b + "c:" + this.f14429d + ",p:" + this.f14428c + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(InterfaceC0119a interfaceC0119a) {
        this(interfaceC0119a, false);
    }

    a(InterfaceC0119a interfaceC0119a, boolean z10) {
        this.f14418a = new androidx.core.util.g(30);
        this.f14419b = new ArrayList();
        this.f14420c = new ArrayList();
        this.f14425h = 0;
        this.f14421d = interfaceC0119a;
        this.f14423f = z10;
        this.f14424g = new l(this);
    }

    private void c(b bVar) {
        v(bVar);
    }

    private void d(b bVar) {
        v(bVar);
    }

    private void f(b bVar) {
        boolean z10;
        char c11;
        int i11 = bVar.f14427b;
        int i12 = bVar.f14429d + i11;
        char c12 = 65535;
        int i13 = i11;
        int i14 = 0;
        while (i13 < i12) {
            if (this.f14421d.f(i13) != null || h(i13)) {
                if (c12 == 0) {
                    k(a(2, i11, i14, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c11 = 1;
            } else {
                if (c12 == 1) {
                    v(a(2, i11, i14, null));
                    z10 = true;
                } else {
                    z10 = false;
                }
                c11 = 0;
            }
            if (z10) {
                i13 -= i14;
                i12 -= i14;
                i14 = 1;
            } else {
                i14++;
            }
            i13++;
            c12 = c11;
        }
        if (i14 != bVar.f14429d) {
            b(bVar);
            bVar = a(2, i11, i14, null);
        }
        if (c12 == 0) {
            k(bVar);
        } else {
            v(bVar);
        }
    }

    private void g(b bVar) {
        int i11 = bVar.f14427b;
        int i12 = bVar.f14429d + i11;
        int i13 = 0;
        boolean z10 = -1;
        int i14 = i11;
        while (i11 < i12) {
            if (this.f14421d.f(i11) != null || h(i11)) {
                if (!z10) {
                    k(a(4, i14, i13, bVar.f14428c));
                    i14 = i11;
                    i13 = 0;
                }
                z10 = true;
            } else {
                if (z10) {
                    v(a(4, i14, i13, bVar.f14428c));
                    i14 = i11;
                    i13 = 0;
                }
                z10 = false;
            }
            i13++;
            i11++;
        }
        if (i13 != bVar.f14429d) {
            Object obj = bVar.f14428c;
            b(bVar);
            bVar = a(4, i14, i13, obj);
        }
        if (z10) {
            v(bVar);
        } else {
            k(bVar);
        }
    }

    private boolean h(int i11) {
        int size = this.f14420c.size();
        for (int i12 = 0; i12 < size; i12++) {
            b bVar = (b) this.f14420c.get(i12);
            int i13 = bVar.f14426a;
            if (i13 == 8) {
                if (n(bVar.f14429d, i12 + 1) == i11) {
                    return true;
                }
            } else if (i13 == 1) {
                int i14 = bVar.f14427b;
                int i15 = bVar.f14429d + i14;
                while (i14 < i15) {
                    if (n(i14, i12 + 1) == i11) {
                        return true;
                    }
                    i14++;
                }
            } else {
                continue;
            }
        }
        return false;
    }

    private void k(b bVar) {
        int i11;
        int i12 = bVar.f14426a;
        if (i12 == 1 || i12 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int z10 = z(bVar.f14427b, i12);
        int i13 = bVar.f14427b;
        int i14 = bVar.f14426a;
        if (i14 == 2) {
            i11 = 0;
        } else {
            if (i14 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i11 = 1;
        }
        int i15 = 1;
        for (int i16 = 1; i16 < bVar.f14429d; i16++) {
            int z11 = z(bVar.f14427b + (i11 * i16), bVar.f14426a);
            int i17 = bVar.f14426a;
            if (i17 == 2 ? z11 != z10 : !(i17 == 4 && z11 == z10 + 1)) {
                b a11 = a(i17, z10, i15, bVar.f14428c);
                l(a11, i13);
                b(a11);
                if (bVar.f14426a == 4) {
                    i13 += i15;
                }
                i15 = 1;
                z10 = z11;
            } else {
                i15++;
            }
        }
        Object obj = bVar.f14428c;
        b(bVar);
        if (i15 > 0) {
            b a12 = a(bVar.f14426a, z10, i15, obj);
            l(a12, i13);
            b(a12);
        }
    }

    private void v(b bVar) {
        this.f14420c.add(bVar);
        int i11 = bVar.f14426a;
        if (i11 == 1) {
            this.f14421d.g(bVar.f14427b, bVar.f14429d);
            return;
        }
        if (i11 == 2) {
            this.f14421d.d(bVar.f14427b, bVar.f14429d);
            return;
        }
        if (i11 == 4) {
            this.f14421d.e(bVar.f14427b, bVar.f14429d, bVar.f14428c);
        } else {
            if (i11 == 8) {
                this.f14421d.a(bVar.f14427b, bVar.f14429d);
                return;
            }
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    private int z(int i11, int i12) {
        int i13;
        int i14;
        for (int size = this.f14420c.size() - 1; size >= 0; size--) {
            b bVar = (b) this.f14420c.get(size);
            int i15 = bVar.f14426a;
            if (i15 == 8) {
                int i16 = bVar.f14427b;
                int i17 = bVar.f14429d;
                if (i16 < i17) {
                    i14 = i16;
                    i13 = i17;
                } else {
                    i13 = i16;
                    i14 = i17;
                }
                if (i11 < i14 || i11 > i13) {
                    if (i11 < i16) {
                        if (i12 == 1) {
                            bVar.f14427b = i16 + 1;
                            bVar.f14429d = i17 + 1;
                        } else if (i12 == 2) {
                            bVar.f14427b = i16 - 1;
                            bVar.f14429d = i17 - 1;
                        }
                    }
                } else if (i14 == i16) {
                    if (i12 == 1) {
                        bVar.f14429d = i17 + 1;
                    } else if (i12 == 2) {
                        bVar.f14429d = i17 - 1;
                    }
                    i11++;
                } else {
                    if (i12 == 1) {
                        bVar.f14427b = i16 + 1;
                    } else if (i12 == 2) {
                        bVar.f14427b = i16 - 1;
                    }
                    i11--;
                }
            } else {
                int i18 = bVar.f14427b;
                if (i18 <= i11) {
                    if (i15 == 1) {
                        i11 -= bVar.f14429d;
                    } else if (i15 == 2) {
                        i11 += bVar.f14429d;
                    }
                } else if (i12 == 1) {
                    bVar.f14427b = i18 + 1;
                } else if (i12 == 2) {
                    bVar.f14427b = i18 - 1;
                }
            }
        }
        for (int size2 = this.f14420c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = (b) this.f14420c.get(size2);
            if (bVar2.f14426a == 8) {
                int i19 = bVar2.f14429d;
                if (i19 == bVar2.f14427b || i19 < 0) {
                    this.f14420c.remove(size2);
                    b(bVar2);
                }
            } else if (bVar2.f14429d <= 0) {
                this.f14420c.remove(size2);
                b(bVar2);
            }
        }
        return i11;
    }

    @Override // androidx.recyclerview.widget.l.a
    public b a(int i11, int i12, int i13, Object obj) {
        b bVar = (b) this.f14418a.acquire();
        if (bVar == null) {
            return new b(i11, i12, i13, obj);
        }
        bVar.f14426a = i11;
        bVar.f14427b = i12;
        bVar.f14429d = i13;
        bVar.f14428c = obj;
        return bVar;
    }

    @Override // androidx.recyclerview.widget.l.a
    public void b(b bVar) {
        if (this.f14423f) {
            return;
        }
        bVar.f14428c = null;
        this.f14418a.release(bVar);
    }

    public int e(int i11) {
        int size = this.f14419b.size();
        for (int i12 = 0; i12 < size; i12++) {
            b bVar = (b) this.f14419b.get(i12);
            int i13 = bVar.f14426a;
            if (i13 != 1) {
                if (i13 == 2) {
                    int i14 = bVar.f14427b;
                    if (i14 <= i11) {
                        int i15 = bVar.f14429d;
                        if (i14 + i15 > i11) {
                            return -1;
                        }
                        i11 -= i15;
                    } else {
                        continue;
                    }
                } else if (i13 == 8) {
                    int i16 = bVar.f14427b;
                    if (i16 == i11) {
                        i11 = bVar.f14429d;
                    } else {
                        if (i16 < i11) {
                            i11--;
                        }
                        if (bVar.f14429d <= i11) {
                            i11++;
                        }
                    }
                }
            } else if (bVar.f14427b <= i11) {
                i11 += bVar.f14429d;
            }
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i() {
        int size = this.f14420c.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.f14421d.c((b) this.f14420c.get(i11));
        }
        x(this.f14420c);
        this.f14425h = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        i();
        int size = this.f14419b.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) this.f14419b.get(i11);
            int i12 = bVar.f14426a;
            if (i12 == 1) {
                this.f14421d.c(bVar);
                this.f14421d.g(bVar.f14427b, bVar.f14429d);
            } else if (i12 == 2) {
                this.f14421d.c(bVar);
                this.f14421d.h(bVar.f14427b, bVar.f14429d);
            } else if (i12 == 4) {
                this.f14421d.c(bVar);
                this.f14421d.e(bVar.f14427b, bVar.f14429d, bVar.f14428c);
            } else if (i12 == 8) {
                this.f14421d.c(bVar);
                this.f14421d.a(bVar.f14427b, bVar.f14429d);
            }
            Runnable runnable = this.f14422e;
            if (runnable != null) {
                runnable.run();
            }
        }
        x(this.f14419b);
        this.f14425h = 0;
    }

    void l(b bVar, int i11) {
        this.f14421d.b(bVar);
        int i12 = bVar.f14426a;
        if (i12 == 2) {
            this.f14421d.h(i11, bVar.f14429d);
        } else {
            if (i12 != 4) {
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
            }
            this.f14421d.e(i11, bVar.f14429d, bVar.f14428c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(int i11) {
        return n(i11, 0);
    }

    int n(int i11, int i12) {
        int size = this.f14420c.size();
        while (i12 < size) {
            b bVar = (b) this.f14420c.get(i12);
            int i13 = bVar.f14426a;
            if (i13 == 8) {
                int i14 = bVar.f14427b;
                if (i14 == i11) {
                    i11 = bVar.f14429d;
                } else {
                    if (i14 < i11) {
                        i11--;
                    }
                    if (bVar.f14429d <= i11) {
                        i11++;
                    }
                }
            } else {
                int i15 = bVar.f14427b;
                if (i15 > i11) {
                    continue;
                } else if (i13 == 2) {
                    int i16 = bVar.f14429d;
                    if (i11 < i15 + i16) {
                        return -1;
                    }
                    i11 -= i16;
                } else if (i13 == 1) {
                    i11 += bVar.f14429d;
                }
            }
            i12++;
        }
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean o(int i11) {
        return (i11 & this.f14425h) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean p() {
        return this.f14419b.size() > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        return (this.f14420c.isEmpty() || this.f14419b.isEmpty()) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r(int i11, int i12, Object obj) {
        if (i12 < 1) {
            return false;
        }
        this.f14419b.add(a(4, i11, i12, obj));
        this.f14425h |= 4;
        return this.f14419b.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean s(int i11, int i12) {
        if (i12 < 1) {
            return false;
        }
        this.f14419b.add(a(1, i11, i12, null));
        this.f14425h |= 1;
        return this.f14419b.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean t(int i11, int i12, int i13) {
        if (i11 == i12) {
            return false;
        }
        if (i13 != 1) {
            throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
        }
        this.f14419b.add(a(8, i11, i12, null));
        this.f14425h |= 8;
        return this.f14419b.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean u(int i11, int i12) {
        if (i12 < 1) {
            return false;
        }
        this.f14419b.add(a(2, i11, i12, null));
        this.f14425h |= 2;
        return this.f14419b.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        this.f14424g.b(this.f14419b);
        int size = this.f14419b.size();
        for (int i11 = 0; i11 < size; i11++) {
            b bVar = (b) this.f14419b.get(i11);
            int i12 = bVar.f14426a;
            if (i12 == 1) {
                c(bVar);
            } else if (i12 == 2) {
                f(bVar);
            } else if (i12 == 4) {
                g(bVar);
            } else if (i12 == 8) {
                d(bVar);
            }
            Runnable runnable = this.f14422e;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f14419b.clear();
    }

    void x(List list) {
        int size = list.size();
        for (int i11 = 0; i11 < size; i11++) {
            b((b) list.get(i11));
        }
        list.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y() {
        x(this.f14419b);
        x(this.f14420c);
        this.f14425h = 0;
    }
}
