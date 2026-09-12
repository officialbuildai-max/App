package com.google.common.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.common.base.b f30299a;

    /* renamed from: b, reason: collision with root package name */
    private final boolean f30300b;

    /* renamed from: c, reason: collision with root package name */
    private final d f30301c;

    /* renamed from: d, reason: collision with root package name */
    private final int f30302d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.google.common.base.b f30303a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.google.common.base.o$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class C0405a extends c {
            C0405a(o oVar, CharSequence charSequence) {
                super(oVar, charSequence);
            }

            @Override // com.google.common.base.o.c
            int e(int i11) {
                return i11 + 1;
            }

            @Override // com.google.common.base.o.c
            int f(int i11) {
                return a.this.f30303a.e(this.f30307c, i11);
            }
        }

        a(com.google.common.base.b bVar) {
            this.f30303a = bVar;
        }

        @Override // com.google.common.base.o.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public c a(o oVar, CharSequence charSequence) {
            return new C0405a(oVar, charSequence);
        }
    }

    /* loaded from: classes4.dex */
    class b implements Iterable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CharSequence f30305a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ o f30306b;

        b(o oVar, CharSequence charSequence) {
            this.f30305a = charSequence;
            this.f30306b = oVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.f30306b.j(this.f30305a);
        }

        public String toString() {
            g h11 = g.h(", ");
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            StringBuilder b11 = h11.b(sb2, this);
            b11.append(']');
            return b11.toString();
        }
    }

    /* loaded from: classes4.dex */
    private static abstract class c extends AbstractIterator {

        /* renamed from: c, reason: collision with root package name */
        final CharSequence f30307c;

        /* renamed from: d, reason: collision with root package name */
        final com.google.common.base.b f30308d;

        /* renamed from: e, reason: collision with root package name */
        final boolean f30309e;

        /* renamed from: f, reason: collision with root package name */
        int f30310f = 0;

        /* renamed from: g, reason: collision with root package name */
        int f30311g;

        protected c(o oVar, CharSequence charSequence) {
            this.f30308d = oVar.f30299a;
            this.f30309e = oVar.f30300b;
            this.f30311g = oVar.f30302d;
            this.f30307c = charSequence;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.base.AbstractIterator
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public String a() {
            int f11;
            int i11 = this.f30310f;
            while (true) {
                int i12 = this.f30310f;
                if (i12 == -1) {
                    return (String) b();
                }
                f11 = f(i12);
                if (f11 == -1) {
                    f11 = this.f30307c.length();
                    this.f30310f = -1;
                } else {
                    this.f30310f = e(f11);
                }
                int i13 = this.f30310f;
                if (i13 == i11) {
                    int i14 = i13 + 1;
                    this.f30310f = i14;
                    if (i14 > this.f30307c.length()) {
                        this.f30310f = -1;
                    }
                } else {
                    while (i11 < f11 && this.f30308d.g(this.f30307c.charAt(i11))) {
                        i11++;
                    }
                    while (f11 > i11 && this.f30308d.g(this.f30307c.charAt(f11 - 1))) {
                        f11--;
                    }
                    if (!this.f30309e || i11 != f11) {
                        break;
                    }
                    i11 = this.f30310f;
                }
            }
            int i15 = this.f30311g;
            if (i15 == 1) {
                f11 = this.f30307c.length();
                this.f30310f = -1;
                while (f11 > i11 && this.f30308d.g(this.f30307c.charAt(f11 - 1))) {
                    f11--;
                }
            } else {
                this.f30311g = i15 - 1;
            }
            return this.f30307c.subSequence(i11, f11).toString();
        }

        abstract int e(int i11);

        abstract int f(int i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public interface d {
        Iterator a(o oVar, CharSequence charSequence);
    }

    private o(d dVar) {
        this(dVar, false, com.google.common.base.b.i(), Integer.MAX_VALUE);
    }

    private o(d dVar, boolean z10, com.google.common.base.b bVar, int i11) {
        this.f30301c = dVar;
        this.f30300b = z10;
        this.f30299a = bVar;
        this.f30302d = i11;
    }

    public static o f(char c11) {
        return g(com.google.common.base.b.f(c11));
    }

    public static o g(com.google.common.base.b bVar) {
        m.o(bVar);
        return new o(new a(bVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Iterator j(CharSequence charSequence) {
        return this.f30301c.a(this, charSequence);
    }

    public o e() {
        return new o(this.f30301c, true, this.f30299a, this.f30302d);
    }

    public Iterable h(CharSequence charSequence) {
        m.o(charSequence);
        return new b(this, charSequence);
    }

    public List i(CharSequence charSequence) {
        m.o(charSequence);
        Iterator j11 = j(charSequence);
        ArrayList arrayList = new ArrayList();
        while (j11.hasNext()) {
            arrayList.add((String) j11.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public o k() {
        return l(com.google.common.base.b.k());
    }

    public o l(com.google.common.base.b bVar) {
        m.o(bVar);
        return new o(this.f30301c, this.f30300b, bVar, this.f30302d);
    }
}
