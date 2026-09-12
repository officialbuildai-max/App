package androidx.activity.result;

import f.g;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: c, reason: collision with root package name */
    private boolean f998c;

    /* renamed from: e, reason: collision with root package name */
    private boolean f1000e;

    /* renamed from: f, reason: collision with root package name */
    private long f1001f;

    /* renamed from: a, reason: collision with root package name */
    private g.f f996a = g.c.f62239a;

    /* renamed from: b, reason: collision with root package name */
    private int f997b = f.e.f62234b.a();

    /* renamed from: d, reason: collision with root package name */
    private g.b f999d = g.b.a.f62237a;

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: c, reason: collision with root package name */
        private boolean f1004c;

        /* renamed from: e, reason: collision with root package name */
        private boolean f1006e;

        /* renamed from: f, reason: collision with root package name */
        private long f1007f;

        /* renamed from: a, reason: collision with root package name */
        private g.f f1002a = g.c.f62239a;

        /* renamed from: b, reason: collision with root package name */
        private int f1003b = f.e.f62234b.a();

        /* renamed from: d, reason: collision with root package name */
        private g.b f1005d = g.b.a.f62237a;

        public final e a() {
            e eVar = new e();
            eVar.k(this.f1002a);
            eVar.j(this.f1003b);
            eVar.l(this.f1004c);
            eVar.i(this.f1005d);
            eVar.h(this.f1006e);
            eVar.g(this.f1007f);
            return eVar;
        }

        public final a b(g.b defaultTab) {
            Intrinsics.h(defaultTab, "defaultTab");
            this.f1005d = defaultTab;
            return this;
        }

        public final a c(int i11) {
            this.f1003b = i11;
            return this;
        }

        public final a d(g.f mediaType) {
            Intrinsics.h(mediaType, "mediaType");
            this.f1002a = mediaType;
            return this;
        }

        public final a e(boolean z10) {
            this.f1004c = z10;
            return this;
        }
    }

    public final long a() {
        return this.f1001f;
    }

    public final g.b b() {
        return this.f999d;
    }

    public final int c() {
        return this.f997b;
    }

    public final g.f d() {
        return this.f996a;
    }

    public final boolean e() {
        return this.f1000e;
    }

    public final boolean f() {
        return this.f998c;
    }

    public final void g(long j11) {
        this.f1001f = j11;
    }

    public final void h(boolean z10) {
        this.f1000e = z10;
    }

    public final void i(g.b bVar) {
        Intrinsics.h(bVar, "<set-?>");
        this.f999d = bVar;
    }

    public final void j(int i11) {
        this.f997b = i11;
    }

    public final void k(g.f fVar) {
        Intrinsics.h(fVar, "<set-?>");
        this.f996a = fVar;
    }

    public final void l(boolean z10) {
        this.f998c = z10;
    }
}
