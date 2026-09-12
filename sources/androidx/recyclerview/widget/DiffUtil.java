package androidx.recyclerview.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class DiffUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator f14208a = new Comparator<c>() { // from class: androidx.recyclerview.widget.DiffUtil.1
        @Override // java.util.Comparator
        public int compare(c cVar, c cVar2) {
            return cVar.f14211a - cVar2.f14211a;
        }
    };

    /* loaded from: classes2.dex */
    public static abstract class a {
        public abstract boolean a(int i11, int i12);

        public abstract boolean b(int i11, int i12);

        public Object c(int i11, int i12) {
            return null;
        }

        public abstract int d();

        public abstract int e();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final int[] f14209a;

        /* renamed from: b, reason: collision with root package name */
        private final int f14210b;

        b(int i11) {
            int[] iArr = new int[i11];
            this.f14209a = iArr;
            this.f14210b = iArr.length / 2;
        }

        int[] a() {
            return this.f14209a;
        }

        int b(int i11) {
            return this.f14209a[i11 + this.f14210b];
        }

        void c(int i11, int i12) {
            this.f14209a[i11 + this.f14210b] = i12;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f14211a;

        /* renamed from: b, reason: collision with root package name */
        public final int f14212b;

        /* renamed from: c, reason: collision with root package name */
        public final int f14213c;

        c(int i11, int i12, int i13) {
            this.f14211a = i11;
            this.f14212b = i12;
            this.f14213c = i13;
        }

        int a() {
            return this.f14211a + this.f14213c;
        }

        int b() {
            return this.f14212b + this.f14213c;
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: a, reason: collision with root package name */
        private final List f14214a;

        /* renamed from: b, reason: collision with root package name */
        private final int[] f14215b;

        /* renamed from: c, reason: collision with root package name */
        private final int[] f14216c;

        /* renamed from: d, reason: collision with root package name */
        private final a f14217d;

        /* renamed from: e, reason: collision with root package name */
        private final int f14218e;

        /* renamed from: f, reason: collision with root package name */
        private final int f14219f;

        /* renamed from: g, reason: collision with root package name */
        private final boolean f14220g;

        d(a aVar, List list, int[] iArr, int[] iArr2, boolean z10) {
            this.f14214a = list;
            this.f14215b = iArr;
            this.f14216c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.f14217d = aVar;
            this.f14218e = aVar.e();
            this.f14219f = aVar.d();
            this.f14220g = z10;
            a();
            e();
        }

        private void a() {
            c cVar = this.f14214a.isEmpty() ? null : (c) this.f14214a.get(0);
            if (cVar == null || cVar.f14211a != 0 || cVar.f14212b != 0) {
                this.f14214a.add(0, new c(0, 0, 0));
            }
            this.f14214a.add(new c(this.f14218e, this.f14219f, 0));
        }

        private void d(int i11) {
            int size = this.f14214a.size();
            int i12 = 0;
            for (int i13 = 0; i13 < size; i13++) {
                c cVar = (c) this.f14214a.get(i13);
                while (i12 < cVar.f14212b) {
                    if (this.f14216c[i12] == 0 && this.f14217d.b(i11, i12)) {
                        int i14 = this.f14217d.a(i11, i12) ? 8 : 4;
                        this.f14215b[i11] = (i12 << 4) | i14;
                        this.f14216c[i12] = (i11 << 4) | i14;
                        return;
                    }
                    i12++;
                }
                i12 = cVar.b();
            }
        }

        private void e() {
            for (c cVar : this.f14214a) {
                for (int i11 = 0; i11 < cVar.f14213c; i11++) {
                    int i12 = cVar.f14211a + i11;
                    int i13 = cVar.f14212b + i11;
                    int i14 = this.f14217d.a(i12, i13) ? 1 : 2;
                    this.f14215b[i12] = (i13 << 4) | i14;
                    this.f14216c[i13] = (i12 << 4) | i14;
                }
            }
            if (this.f14220g) {
                f();
            }
        }

        private void f() {
            int i11 = 0;
            for (c cVar : this.f14214a) {
                while (i11 < cVar.f14211a) {
                    if (this.f14215b[i11] == 0) {
                        d(i11);
                    }
                    i11++;
                }
                i11 = cVar.a();
            }
        }

        private static f g(Collection collection, int i11, boolean z10) {
            f fVar;
            Iterator it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    fVar = null;
                    break;
                }
                fVar = (f) it.next();
                if (fVar.f14221a == i11 && fVar.f14223c == z10) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                f fVar2 = (f) it.next();
                if (z10) {
                    fVar2.f14222b--;
                } else {
                    fVar2.f14222b++;
                }
            }
            return fVar;
        }

        public void b(j jVar) {
            int i11;
            androidx.recyclerview.widget.d dVar = jVar instanceof androidx.recyclerview.widget.d ? (androidx.recyclerview.widget.d) jVar : new androidx.recyclerview.widget.d(jVar);
            int i12 = this.f14218e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i13 = this.f14218e;
            int i14 = this.f14219f;
            for (int size = this.f14214a.size() - 1; size >= 0; size--) {
                c cVar = (c) this.f14214a.get(size);
                int a11 = cVar.a();
                int b11 = cVar.b();
                while (true) {
                    if (i13 <= a11) {
                        break;
                    }
                    i13--;
                    int i15 = this.f14215b[i13];
                    if ((i15 & 12) != 0) {
                        int i16 = i15 >> 4;
                        f g11 = g(arrayDeque, i16, false);
                        if (g11 != null) {
                            int i17 = (i12 - g11.f14222b) - 1;
                            dVar.onMoved(i13, i17);
                            if ((i15 & 4) != 0) {
                                dVar.onChanged(i17, 1, this.f14217d.c(i13, i16));
                            }
                        } else {
                            arrayDeque.add(new f(i13, (i12 - i13) - 1, true));
                        }
                    } else {
                        dVar.onRemoved(i13, 1);
                        i12--;
                    }
                }
                while (i14 > b11) {
                    i14--;
                    int i18 = this.f14216c[i14];
                    if ((i18 & 12) != 0) {
                        int i19 = i18 >> 4;
                        f g12 = g(arrayDeque, i19, true);
                        if (g12 == null) {
                            arrayDeque.add(new f(i14, i12 - i13, false));
                        } else {
                            dVar.onMoved((i12 - g12.f14222b) - 1, i13);
                            if ((i18 & 4) != 0) {
                                dVar.onChanged(i13, 1, this.f14217d.c(i19, i14));
                            }
                        }
                    } else {
                        dVar.onInserted(i13, 1);
                        i12++;
                    }
                }
                int i20 = cVar.f14211a;
                int i21 = cVar.f14212b;
                for (i11 = 0; i11 < cVar.f14213c; i11++) {
                    if ((this.f14215b[i20] & 15) == 2) {
                        dVar.onChanged(i20, 1, this.f14217d.c(i20, i21));
                    }
                    i20++;
                    i21++;
                }
                i13 = cVar.f14211a;
                i14 = cVar.f14212b;
            }
            dVar.a();
        }

        public void c(RecyclerView.Adapter adapter) {
            b(new androidx.recyclerview.widget.b(adapter));
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class e {
        public abstract boolean areContentsTheSame(Object obj, Object obj2);

        public abstract boolean areItemsTheSame(Object obj, Object obj2);

        @Nullable
        public Object getChangePayload(@NonNull Object obj, @NonNull Object obj2) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class f {

        /* renamed from: a, reason: collision with root package name */
        int f14221a;

        /* renamed from: b, reason: collision with root package name */
        int f14222b;

        /* renamed from: c, reason: collision with root package name */
        boolean f14223c;

        f(int i11, int i12, boolean z10) {
            this.f14221a = i11;
            this.f14222b = i12;
            this.f14223c = z10;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        int f14224a;

        /* renamed from: b, reason: collision with root package name */
        int f14225b;

        /* renamed from: c, reason: collision with root package name */
        int f14226c;

        /* renamed from: d, reason: collision with root package name */
        int f14227d;

        public g() {
        }

        public g(int i11, int i12, int i13, int i14) {
            this.f14224a = i11;
            this.f14225b = i12;
            this.f14226c = i13;
            this.f14227d = i14;
        }

        int a() {
            return this.f14227d - this.f14226c;
        }

        int b() {
            return this.f14225b - this.f14224a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        public int f14228a;

        /* renamed from: b, reason: collision with root package name */
        public int f14229b;

        /* renamed from: c, reason: collision with root package name */
        public int f14230c;

        /* renamed from: d, reason: collision with root package name */
        public int f14231d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f14232e;

        h() {
        }

        int a() {
            return Math.min(this.f14230c - this.f14228a, this.f14231d - this.f14229b);
        }

        boolean b() {
            return this.f14231d - this.f14229b != this.f14230c - this.f14228a;
        }

        boolean c() {
            return this.f14231d - this.f14229b > this.f14230c - this.f14228a;
        }

        c d() {
            if (b()) {
                return this.f14232e ? new c(this.f14228a, this.f14229b, a()) : c() ? new c(this.f14228a, this.f14229b + 1, a()) : new c(this.f14228a + 1, this.f14229b, a());
            }
            int i11 = this.f14228a;
            return new c(i11, this.f14229b, this.f14230c - i11);
        }
    }

    private static h a(g gVar, a aVar, b bVar, b bVar2, int i11) {
        int b11;
        int i12;
        int i13;
        boolean z10 = (gVar.b() - gVar.a()) % 2 == 0;
        int b12 = gVar.b() - gVar.a();
        int i14 = -i11;
        for (int i15 = i14; i15 <= i11; i15 += 2) {
            if (i15 == i14 || (i15 != i11 && bVar2.b(i15 + 1) < bVar2.b(i15 - 1))) {
                b11 = bVar2.b(i15 + 1);
                i12 = b11;
            } else {
                b11 = bVar2.b(i15 - 1);
                i12 = b11 - 1;
            }
            int i16 = gVar.f14227d - ((gVar.f14225b - i12) - i15);
            int i17 = (i11 == 0 || i12 != b11) ? i16 : i16 + 1;
            while (i12 > gVar.f14224a && i16 > gVar.f14226c && aVar.b(i12 - 1, i16 - 1)) {
                i12--;
                i16--;
            }
            bVar2.c(i15, i12);
            if (z10 && (i13 = b12 - i15) >= i14 && i13 <= i11 && bVar.b(i13) >= i12) {
                h hVar = new h();
                hVar.f14228a = i12;
                hVar.f14229b = i16;
                hVar.f14230c = b11;
                hVar.f14231d = i17;
                hVar.f14232e = true;
                return hVar;
            }
        }
        return null;
    }

    public static d b(a aVar) {
        return c(aVar, true);
    }

    public static d c(a aVar, boolean z10) {
        int e11 = aVar.e();
        int d11 = aVar.d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new g(0, e11, 0, d11));
        int i11 = ((((e11 + d11) + 1) / 2) * 2) + 1;
        b bVar = new b(i11);
        b bVar2 = new b(i11);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            g gVar = (g) arrayList2.remove(arrayList2.size() - 1);
            h e12 = e(gVar, aVar, bVar, bVar2);
            if (e12 != null) {
                if (e12.a() > 0) {
                    arrayList.add(e12.d());
                }
                g gVar2 = arrayList3.isEmpty() ? new g() : (g) arrayList3.remove(arrayList3.size() - 1);
                gVar2.f14224a = gVar.f14224a;
                gVar2.f14226c = gVar.f14226c;
                gVar2.f14225b = e12.f14228a;
                gVar2.f14227d = e12.f14229b;
                arrayList2.add(gVar2);
                gVar.f14225b = gVar.f14225b;
                gVar.f14227d = gVar.f14227d;
                gVar.f14224a = e12.f14230c;
                gVar.f14226c = e12.f14231d;
                arrayList2.add(gVar);
            } else {
                arrayList3.add(gVar);
            }
        }
        Collections.sort(arrayList, f14208a);
        return new d(aVar, arrayList, bVar.a(), bVar2.a(), z10);
    }

    private static h d(g gVar, a aVar, b bVar, b bVar2, int i11) {
        int b11;
        int i12;
        int i13;
        boolean z10 = Math.abs(gVar.b() - gVar.a()) % 2 == 1;
        int b12 = gVar.b() - gVar.a();
        int i14 = -i11;
        for (int i15 = i14; i15 <= i11; i15 += 2) {
            if (i15 == i14 || (i15 != i11 && bVar.b(i15 + 1) > bVar.b(i15 - 1))) {
                b11 = bVar.b(i15 + 1);
                i12 = b11;
            } else {
                b11 = bVar.b(i15 - 1);
                i12 = b11 + 1;
            }
            int i16 = (gVar.f14226c + (i12 - gVar.f14224a)) - i15;
            int i17 = (i11 == 0 || i12 != b11) ? i16 : i16 - 1;
            while (i12 < gVar.f14225b && i16 < gVar.f14227d && aVar.b(i12, i16)) {
                i12++;
                i16++;
            }
            bVar.c(i15, i12);
            if (z10 && (i13 = b12 - i15) >= i14 + 1 && i13 <= i11 - 1 && bVar2.b(i13) <= i12) {
                h hVar = new h();
                hVar.f14228a = b11;
                hVar.f14229b = i17;
                hVar.f14230c = i12;
                hVar.f14231d = i16;
                hVar.f14232e = false;
                return hVar;
            }
        }
        return null;
    }

    private static h e(g gVar, a aVar, b bVar, b bVar2) {
        if (gVar.b() >= 1 && gVar.a() >= 1) {
            int b11 = ((gVar.b() + gVar.a()) + 1) / 2;
            bVar.c(1, gVar.f14224a);
            bVar2.c(1, gVar.f14225b);
            for (int i11 = 0; i11 < b11; i11++) {
                h d11 = d(gVar, aVar, bVar, bVar2, i11);
                if (d11 != null) {
                    return d11;
                }
                h a11 = a(gVar, aVar, bVar, bVar2, i11);
                if (a11 != null) {
                    return a11;
                }
            }
        }
        return null;
    }
}
