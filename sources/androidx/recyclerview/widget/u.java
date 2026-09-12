package androidx.recyclerview.widget;

import androidx.collection.x;
import androidx.collection.x0;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class u {

    /* renamed from: a, reason: collision with root package name */
    final x0 f14511a = new x0();

    /* renamed from: b, reason: collision with root package name */
    final x f14512b = new x();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: d, reason: collision with root package name */
        static androidx.core.util.f f14513d = new androidx.core.util.g(20);

        /* renamed from: a, reason: collision with root package name */
        int f14514a;

        /* renamed from: b, reason: collision with root package name */
        RecyclerView.j.c f14515b;

        /* renamed from: c, reason: collision with root package name */
        RecyclerView.j.c f14516c;

        private a() {
        }

        static void a() {
            do {
            } while (f14513d.acquire() != null);
        }

        static a b() {
            a aVar = (a) f14513d.acquire();
            return aVar == null ? new a() : aVar;
        }

        static void c(a aVar) {
            aVar.f14514a = 0;
            aVar.f14515b = null;
            aVar.f14516c = null;
            f14513d.release(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface b {
        void a(RecyclerView.b0 b0Var, RecyclerView.j.c cVar, RecyclerView.j.c cVar2);

        void b(RecyclerView.b0 b0Var);

        void c(RecyclerView.b0 b0Var, RecyclerView.j.c cVar, RecyclerView.j.c cVar2);

        void d(RecyclerView.b0 b0Var, RecyclerView.j.c cVar, RecyclerView.j.c cVar2);
    }

    private RecyclerView.j.c l(RecyclerView.b0 b0Var, int i11) {
        a aVar;
        RecyclerView.j.c cVar;
        int indexOfKey = this.f14511a.indexOfKey(b0Var);
        if (indexOfKey >= 0 && (aVar = (a) this.f14511a.valueAt(indexOfKey)) != null) {
            int i12 = aVar.f14514a;
            if ((i12 & i11) != 0) {
                int i13 = (~i11) & i12;
                aVar.f14514a = i13;
                if (i11 == 4) {
                    cVar = aVar.f14515b;
                } else {
                    if (i11 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    cVar = aVar.f14516c;
                }
                if ((i13 & 12) == 0) {
                    this.f14511a.removeAt(indexOfKey);
                    a.c(aVar);
                }
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(RecyclerView.b0 b0Var, RecyclerView.j.c cVar) {
        a aVar = (a) this.f14511a.get(b0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f14511a.put(b0Var, aVar);
        }
        aVar.f14514a |= 2;
        aVar.f14515b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(RecyclerView.b0 b0Var) {
        a aVar = (a) this.f14511a.get(b0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f14511a.put(b0Var, aVar);
        }
        aVar.f14514a |= 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(long j11, RecyclerView.b0 b0Var) {
        this.f14512b.k(j11, b0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(RecyclerView.b0 b0Var, RecyclerView.j.c cVar) {
        a aVar = (a) this.f14511a.get(b0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f14511a.put(b0Var, aVar);
        }
        aVar.f14516c = cVar;
        aVar.f14514a |= 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(RecyclerView.b0 b0Var, RecyclerView.j.c cVar) {
        a aVar = (a) this.f14511a.get(b0Var);
        if (aVar == null) {
            aVar = a.b();
            this.f14511a.put(b0Var, aVar);
        }
        aVar.f14515b = cVar;
        aVar.f14514a |= 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f14511a.clear();
        this.f14512b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.b0 g(long j11) {
        return (RecyclerView.b0) this.f14512b.e(j11);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h(RecyclerView.b0 b0Var) {
        a aVar = (a) this.f14511a.get(b0Var);
        return (aVar == null || (aVar.f14514a & 1) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean i(RecyclerView.b0 b0Var) {
        a aVar = (a) this.f14511a.get(b0Var);
        return (aVar == null || (aVar.f14514a & 4) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j() {
        a.a();
    }

    public void k(RecyclerView.b0 b0Var) {
        p(b0Var);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.j.c m(RecyclerView.b0 b0Var) {
        return l(b0Var, 8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RecyclerView.j.c n(RecyclerView.b0 b0Var) {
        return l(b0Var, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(b bVar) {
        for (int size = this.f14511a.size() - 1; size >= 0; size--) {
            RecyclerView.b0 b0Var = (RecyclerView.b0) this.f14511a.keyAt(size);
            a aVar = (a) this.f14511a.removeAt(size);
            int i11 = aVar.f14514a;
            if ((i11 & 3) == 3) {
                bVar.b(b0Var);
            } else if ((i11 & 1) != 0) {
                RecyclerView.j.c cVar = aVar.f14515b;
                if (cVar == null) {
                    bVar.b(b0Var);
                } else {
                    bVar.c(b0Var, cVar, aVar.f14516c);
                }
            } else if ((i11 & 14) == 14) {
                bVar.a(b0Var, aVar.f14515b, aVar.f14516c);
            } else if ((i11 & 12) == 12) {
                bVar.d(b0Var, aVar.f14515b, aVar.f14516c);
            } else if ((i11 & 4) != 0) {
                bVar.c(b0Var, aVar.f14515b, null);
            } else if ((i11 & 8) != 0) {
                bVar.a(b0Var, aVar.f14515b, aVar.f14516c);
            }
            a.c(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(RecyclerView.b0 b0Var) {
        a aVar = (a) this.f14511a.get(b0Var);
        if (aVar == null) {
            return;
        }
        aVar.f14514a &= -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(RecyclerView.b0 b0Var) {
        int n11 = this.f14512b.n() - 1;
        while (true) {
            if (n11 < 0) {
                break;
            }
            if (b0Var == this.f14512b.o(n11)) {
                this.f14512b.m(n11);
                break;
            }
            n11--;
        }
        a aVar = (a) this.f14511a.remove(b0Var);
        if (aVar != null) {
            a.c(aVar);
        }
    }
}
