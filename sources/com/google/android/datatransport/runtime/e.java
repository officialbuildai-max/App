package com.google.android.datatransport.runtime;

import a9.n0;
import a9.w0;
import android.content.Context;
import com.google.android.datatransport.runtime.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public abstract class e {

    /* loaded from: classes3.dex */
    private static final class b implements u.a {

        /* renamed from: a, reason: collision with root package name */
        private Context f24443a;

        private b() {
        }

        @Override // com.google.android.datatransport.runtime.u.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(Context context) {
            this.f24443a = (Context) u8.d.b(context);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.u.a
        public u build() {
            u8.d.a(this.f24443a, Context.class);
            return new c(this.f24443a);
        }
    }

    /* loaded from: classes3.dex */
    private static final class c extends u {

        /* renamed from: a, reason: collision with root package name */
        private final c f24444a;

        /* renamed from: b, reason: collision with root package name */
        private uz.a f24445b;

        /* renamed from: c, reason: collision with root package name */
        private uz.a f24446c;

        /* renamed from: d, reason: collision with root package name */
        private uz.a f24447d;

        /* renamed from: e, reason: collision with root package name */
        private uz.a f24448e;

        /* renamed from: f, reason: collision with root package name */
        private uz.a f24449f;

        /* renamed from: g, reason: collision with root package name */
        private uz.a f24450g;

        /* renamed from: h, reason: collision with root package name */
        private uz.a f24451h;

        /* renamed from: i, reason: collision with root package name */
        private uz.a f24452i;

        /* renamed from: j, reason: collision with root package name */
        private uz.a f24453j;

        /* renamed from: k, reason: collision with root package name */
        private uz.a f24454k;

        /* renamed from: l, reason: collision with root package name */
        private uz.a f24455l;

        /* renamed from: m, reason: collision with root package name */
        private uz.a f24456m;

        /* renamed from: n, reason: collision with root package name */
        private uz.a f24457n;

        private c(Context context) {
            this.f24444a = this;
            i(context);
        }

        private void i(Context context) {
            this.f24445b = u8.a.a(k.a());
            u8.b a11 = u8.c.a(context);
            this.f24446c = a11;
            t8.h a12 = t8.h.a(a11, c9.c.a(), c9.d.a());
            this.f24447d = a12;
            this.f24448e = u8.a.a(t8.j.a(this.f24446c, a12));
            this.f24449f = w0.a(this.f24446c, a9.g.a(), a9.i.a());
            this.f24450g = u8.a.a(a9.h.a(this.f24446c));
            this.f24451h = u8.a.a(n0.a(c9.c.a(), c9.d.a(), a9.j.a(), this.f24449f, this.f24450g));
            y8.g b11 = y8.g.b(c9.c.a());
            this.f24452i = b11;
            y8.i a13 = y8.i.a(this.f24446c, this.f24451h, b11, c9.d.a());
            this.f24453j = a13;
            uz.a aVar = this.f24445b;
            uz.a aVar2 = this.f24448e;
            uz.a aVar3 = this.f24451h;
            this.f24454k = y8.d.a(aVar, aVar2, a13, aVar3, aVar3);
            uz.a aVar4 = this.f24446c;
            uz.a aVar5 = this.f24448e;
            uz.a aVar6 = this.f24451h;
            this.f24455l = z8.p.a(aVar4, aVar5, aVar6, this.f24453j, this.f24445b, aVar6, c9.c.a(), c9.d.a(), this.f24451h);
            uz.a aVar7 = this.f24445b;
            uz.a aVar8 = this.f24451h;
            this.f24456m = z8.t.a(aVar7, aVar8, this.f24453j, aVar8);
            this.f24457n = u8.a.a(v.a(c9.c.a(), c9.d.a(), this.f24454k, this.f24455l, this.f24456m));
        }

        @Override // com.google.android.datatransport.runtime.u
        a9.d d() {
            return (a9.d) this.f24451h.get();
        }

        @Override // com.google.android.datatransport.runtime.u
        t h() {
            return (t) this.f24457n.get();
        }
    }

    public static u.a a() {
        return new b();
    }
}
