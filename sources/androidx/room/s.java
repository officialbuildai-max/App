package androidx.room;

import a4.e;
import androidx.room.RoomDatabase;
import androidx.room.a;
import androidx.room.coroutines.ConnectionPool;
import androidx.room.d0;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class s extends androidx.room.a {

    /* renamed from: d, reason: collision with root package name */
    private final androidx.room.c f14806d;

    /* renamed from: e, reason: collision with root package name */
    private final d0 f14807e;

    /* renamed from: f, reason: collision with root package name */
    private final List f14808f;

    /* renamed from: g, reason: collision with root package name */
    private final ConnectionPool f14809g;

    /* renamed from: h, reason: collision with root package name */
    private a4.d f14810h;

    /* loaded from: classes2.dex */
    private static final class a extends d0 {
        public a() {
            super(-1, "", "");
        }

        @Override // androidx.room.d0
        public void a(z3.b connection) {
            Intrinsics.h(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.d0
        public void b(z3.b connection) {
            Intrinsics.h(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.d0
        public void f(z3.b connection) {
            Intrinsics.h(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.d0
        public void g(z3.b connection) {
            Intrinsics.h(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.d0
        public void h(z3.b connection) {
            Intrinsics.h(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.d0
        public void i(z3.b connection) {
            Intrinsics.h(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }

        @Override // androidx.room.d0
        public d0.a j(z3.b connection) {
            Intrinsics.h(connection, "connection");
            throw new IllegalStateException("NOP delegate should never be called");
        }
    }

    /* loaded from: classes2.dex */
    public final class b extends e.a {
        public b(int i11) {
            super(i11);
        }

        @Override // a4.e.a
        public void d(a4.d db2) {
            Intrinsics.h(db2, "db");
            s.this.x(new androidx.room.driver.a(db2));
        }

        @Override // a4.e.a
        public void e(a4.d db2, int i11, int i12) {
            Intrinsics.h(db2, "db");
            g(db2, i11, i12);
        }

        @Override // a4.e.a
        public void f(a4.d db2) {
            Intrinsics.h(db2, "db");
            s.this.z(new androidx.room.driver.a(db2));
            s.this.f14810h = db2;
        }

        @Override // a4.e.a
        public void g(a4.d db2, int i11, int i12) {
            Intrinsics.h(db2, "db");
            s.this.y(new androidx.room.driver.a(db2), i11, i12);
        }
    }

    /* loaded from: classes2.dex */
    public static final class c extends RoomDatabase.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f14812a;

        c(Function1 function1) {
            this.f14812a = function1;
        }

        @Override // androidx.room.RoomDatabase.b
        public void e(a4.d db2) {
            Intrinsics.h(db2, "db");
            this.f14812a.invoke(db2);
        }
    }

    public s(androidx.room.c config, d0 openDelegate) {
        ConnectionPool b11;
        Intrinsics.h(config, "config");
        Intrinsics.h(openDelegate, "openDelegate");
        this.f14806d = config;
        this.f14807e = openDelegate;
        List list = config.f14656e;
        this.f14808f = list == null ? CollectionsKt.l() : list;
        z3.c cVar = config.f14672u;
        if (cVar != null) {
            if (cVar instanceof c4.b) {
                a.b bVar = new a.b(this, cVar);
                String str = config.f14653b;
                b11 = new androidx.room.coroutines.b(bVar, str != null ? str : ":memory:");
            } else {
                b11 = config.f14653b == null ? androidx.room.coroutines.h.b(new a.b(this, cVar), ":memory:") : androidx.room.coroutines.h.a(new a.b(this, cVar), config.f14653b, p(config.f14658g), q(config.f14658g));
            }
            this.f14809g = b11;
        } else {
            if (config.f14654c == null) {
                throw new IllegalArgumentException("SQLiteManager was constructed with both null driver and open helper factory!");
            }
            this.f14809g = new androidx.room.driver.b(new androidx.room.driver.c(config.f14654c.a(e.b.f230f.a(config.f14652a).d(config.f14653b).c(new b(openDelegate.e())).b())));
        }
        H();
    }

    public s(androidx.room.c config, Function1 supportOpenHelperFactory) {
        Intrinsics.h(config, "config");
        Intrinsics.h(supportOpenHelperFactory, "supportOpenHelperFactory");
        this.f14806d = config;
        this.f14807e = new a();
        List list = config.f14656e;
        this.f14808f = list == null ? CollectionsKt.l() : list;
        this.f14809g = new androidx.room.driver.b(new androidx.room.driver.c((a4.e) supportOpenHelperFactory.invoke(I(config, new Function1() { // from class: androidx.room.r
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit D;
                D = s.D(s.this, (a4.d) obj);
                return D;
            }
        }))));
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit D(s sVar, a4.d db2) {
        Intrinsics.h(db2, "db");
        sVar.f14810h = db2;
        return Unit.f67184a;
    }

    private final void H() {
        boolean z10 = o().f14658g == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING;
        a4.e G = G();
        if (G != null) {
            G.setWriteAheadLoggingEnabled(z10);
        }
    }

    private final androidx.room.c I(androidx.room.c cVar, Function1 function1) {
        List list = cVar.f14656e;
        if (list == null) {
            list = CollectionsKt.l();
        }
        return androidx.room.c.b(cVar, null, null, null, null, CollectionsKt.C0(list, new c(function1)), false, null, null, null, null, false, false, null, null, null, null, null, null, null, false, null, null, 4194287, null);
    }

    @Override // androidx.room.a
    public String A(String fileName) {
        Intrinsics.h(fileName, "fileName");
        if (Intrinsics.c(fileName, ":memory:")) {
            return fileName;
        }
        String absolutePath = o().f14652a.getDatabasePath(fileName).getAbsolutePath();
        Intrinsics.e(absolutePath);
        return absolutePath;
    }

    public final void F() {
        this.f14809g.close();
    }

    public final a4.e G() {
        androidx.room.driver.c h11;
        ConnectionPool connectionPool = this.f14809g;
        androidx.room.driver.b bVar = connectionPool instanceof androidx.room.driver.b ? (androidx.room.driver.b) connectionPool : null;
        if (bVar == null || (h11 = bVar.h()) == null) {
            return null;
        }
        return h11.a();
    }

    public final boolean J() {
        a4.d dVar = this.f14810h;
        if (dVar != null) {
            return dVar.isOpen();
        }
        return false;
    }

    public Object K(boolean z10, Function2 function2, Continuation continuation) {
        return this.f14809g.f(z10, function2, continuation);
    }

    @Override // androidx.room.a
    protected List n() {
        return this.f14808f;
    }

    @Override // androidx.room.a
    protected androidx.room.c o() {
        return this.f14806d;
    }

    @Override // androidx.room.a
    protected d0 r() {
        return this.f14807e;
    }
}
