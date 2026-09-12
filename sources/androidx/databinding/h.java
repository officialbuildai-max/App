package androidx.databinding;

import androidx.databinding.c;
import androidx.databinding.j;

/* loaded from: classes.dex */
public class h extends c {

    /* renamed from: f, reason: collision with root package name */
    private static final androidx.core.util.h f8631f = new androidx.core.util.h(10);

    /* renamed from: g, reason: collision with root package name */
    private static final c.a f8632g = new a();

    /* loaded from: classes.dex */
    class a extends c.a {
        a() {
        }

        @Override // androidx.databinding.c.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(j.a aVar, j jVar, int i11, b bVar) {
            if (i11 == 1) {
                aVar.b(jVar, bVar.f8633a, bVar.f8634b);
                return;
            }
            if (i11 == 2) {
                aVar.c(jVar, bVar.f8633a, bVar.f8634b);
                return;
            }
            if (i11 == 3) {
                aVar.d(jVar, bVar.f8633a, bVar.f8635c, bVar.f8634b);
            } else if (i11 != 4) {
                aVar.a(jVar);
            } else {
                aVar.e(jVar, bVar.f8633a, bVar.f8634b);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public int f8633a;

        /* renamed from: b, reason: collision with root package name */
        public int f8634b;

        /* renamed from: c, reason: collision with root package name */
        public int f8635c;

        b() {
        }
    }

    public h() {
        super(f8632g);
    }

    private static b m(int i11, int i12, int i13) {
        b bVar = (b) f8631f.acquire();
        if (bVar == null) {
            bVar = new b();
        }
        bVar.f8633a = i11;
        bVar.f8635c = i12;
        bVar.f8634b = i13;
        return bVar;
    }

    public synchronized void n(j jVar, int i11, b bVar) {
        super.d(jVar, i11, bVar);
        if (bVar != null) {
            f8631f.release(bVar);
        }
    }

    public void o(j jVar, int i11, int i12) {
        n(jVar, 1, m(i11, 0, i12));
    }

    public void p(j jVar, int i11, int i12) {
        n(jVar, 2, m(i11, 0, i12));
    }

    public void q(j jVar, int i11, int i12) {
        n(jVar, 4, m(i11, 0, i12));
    }
}
