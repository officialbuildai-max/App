package androidx.room;

import androidx.room.RoomDatabase;
import androidx.room.a;
import androidx.room.d0;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: c, reason: collision with root package name */
    public static final C0122a f14641c = new C0122a(null);

    /* renamed from: a, reason: collision with root package name */
    private boolean f14642a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f14643b;

    /* renamed from: androidx.room.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0122a {
        private C0122a() {
        }

        public /* synthetic */ C0122a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public final class b implements z3.c {

        /* renamed from: a, reason: collision with root package name */
        private final z3.c f14644a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f14645b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: androidx.room.a$b$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C0123a implements Function1 {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f14646a;

            C0123a(String str) {
                this.f14646a = str;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Void invoke(Throwable error) {
                Intrinsics.h(error, "error");
                throw new IllegalStateException("Unable to open database '" + this.f14646a + "'. Was a proper path / name used in Room's database builder?", error);
            }
        }

        public b(a aVar, z3.c actual) {
            Intrinsics.h(actual, "actual");
            this.f14645b = aVar;
            this.f14644a = actual;
        }

        private final z3.b b(final String str) {
            x3.b bVar = new x3.b(str, (this.f14645b.f14642a || this.f14645b.f14643b || Intrinsics.c(str, ":memory:")) ? false : true);
            final a aVar = this.f14645b;
            return (z3.b) bVar.b(new Function0() { // from class: androidx.room.b
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    z3.b c11;
                    c11 = a.b.c(a.this, this, str);
                    return c11;
                }
            }, new C0123a(str));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final z3.b c(a aVar, b bVar, String str) {
            if (aVar.f14643b) {
                throw new IllegalStateException("Recursive database initialization detected. Did you try to use the database instance during initialization? Maybe in one of the callbacks?");
            }
            z3.b open = bVar.f14644a.open(str);
            if (aVar.f14642a) {
                aVar.g(open);
            } else {
                try {
                    aVar.f14643b = true;
                    aVar.i(open);
                } finally {
                    aVar.f14643b = false;
                }
            }
            return open;
        }

        @Override // z3.c
        public z3.b open(String fileName) {
            Intrinsics.h(fileName, "fileName");
            return b(this.f14645b.A(fileName));
        }
    }

    /* loaded from: classes2.dex */
    public /* synthetic */ class c {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14647a;

        static {
            int[] iArr = new int[RoomDatabase.JournalMode.values().length];
            try {
                iArr[RoomDatabase.JournalMode.TRUNCATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f14647a = iArr;
        }
    }

    private final void B(z3.b bVar) {
        l(bVar);
        z3.a.a(bVar, c0.a(r().c()));
    }

    private final void f(z3.b bVar) {
        Object m1185constructorimpl;
        d0.a j11;
        if (t(bVar)) {
            z3.e D0 = bVar.D0("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1");
            try {
                String n02 = D0.A0() ? D0.n0(0) : null;
                AutoCloseableKt.a(D0, null);
                if (Intrinsics.c(r().c(), n02) || Intrinsics.c(r().d(), n02)) {
                    return;
                }
                throw new IllegalStateException(("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + r().c() + ", found: " + n02).toString());
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    AutoCloseableKt.a(D0, th2);
                    throw th3;
                }
            }
        }
        z3.a.a(bVar, "BEGIN EXCLUSIVE TRANSACTION");
        try {
            Result.Companion companion = Result.INSTANCE;
            j11 = r().j(bVar);
        } catch (Throwable th4) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th4));
        }
        if (!j11.f14736a) {
            throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + j11.f14737b).toString());
        }
        r().h(bVar);
        B(bVar);
        m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        if (Result.m1192isSuccessimpl(m1185constructorimpl)) {
            z3.a.a(bVar, "END TRANSACTION");
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null) {
            Result.m1184boximpl(m1185constructorimpl);
        } else {
            z3.a.a(bVar, "ROLLBACK TRANSACTION");
            throw m1188exceptionOrNullimpl;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(z3.b bVar) {
        k(bVar);
        h(bVar);
        r().g(bVar);
    }

    private final void h(z3.b bVar) {
        z3.e D0 = bVar.D0("PRAGMA busy_timeout");
        try {
            D0.A0();
            long j11 = D0.getLong(0);
            AutoCloseableKt.a(D0, null);
            if (j11 < 3000) {
                z3.a.a(bVar, "PRAGMA busy_timeout = 3000");
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                AutoCloseableKt.a(D0, th2);
                throw th3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i(z3.b bVar) {
        Object m1185constructorimpl;
        j(bVar);
        k(bVar);
        h(bVar);
        z3.e D0 = bVar.D0("PRAGMA user_version");
        try {
            D0.A0();
            int i11 = (int) D0.getLong(0);
            AutoCloseableKt.a(D0, null);
            if (i11 != r().e()) {
                z3.a.a(bVar, "BEGIN EXCLUSIVE TRANSACTION");
                try {
                    Result.Companion companion = Result.INSTANCE;
                    if (i11 == 0) {
                        x(bVar);
                    } else {
                        y(bVar, i11, r().e());
                    }
                    z3.a.a(bVar, "PRAGMA user_version = " + r().e());
                    m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
                }
                if (Result.m1192isSuccessimpl(m1185constructorimpl)) {
                    z3.a.a(bVar, "END TRANSACTION");
                }
                Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
                if (m1188exceptionOrNullimpl != null) {
                    z3.a.a(bVar, "ROLLBACK TRANSACTION");
                    throw m1188exceptionOrNullimpl;
                }
            }
            z(bVar);
        } finally {
        }
    }

    private final void j(z3.b bVar) {
        if (o().f14658g == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            z3.a.a(bVar, "PRAGMA journal_mode = WAL");
        } else {
            z3.a.a(bVar, "PRAGMA journal_mode = TRUNCATE");
        }
    }

    private final void k(z3.b bVar) {
        if (o().f14658g == RoomDatabase.JournalMode.WRITE_AHEAD_LOGGING) {
            z3.a.a(bVar, "PRAGMA synchronous = NORMAL");
        } else {
            z3.a.a(bVar, "PRAGMA synchronous = FULL");
        }
    }

    private final void l(z3.b bVar) {
        z3.a.a(bVar, "CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private final void m(z3.b bVar) {
        if (!o().f14671t) {
            r().b(bVar);
            return;
        }
        z3.e D0 = bVar.D0("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
        try {
            List c11 = CollectionsKt.c();
            while (D0.A0()) {
                String n02 = D0.n0(0);
                if (!StringsKt.W(n02, "sqlite_", false, 2, null) && !Intrinsics.c(n02, "android_metadata")) {
                    c11.add(TuplesKt.a(n02, Boolean.valueOf(Intrinsics.c(D0.n0(1), MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW))));
                }
            }
            List<Pair> a11 = CollectionsKt.a(c11);
            AutoCloseableKt.a(D0, null);
            for (Pair pair : a11) {
                String str = (String) pair.component1();
                if (((Boolean) pair.component2()).booleanValue()) {
                    z3.a.a(bVar, "DROP VIEW IF EXISTS " + str);
                } else {
                    z3.a.a(bVar, "DROP TABLE IF EXISTS " + str);
                }
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                AutoCloseableKt.a(D0, th2);
                throw th3;
            }
        }
    }

    private final boolean s(z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
        try {
            boolean z10 = false;
            if (D0.A0()) {
                if (D0.getLong(0) == 0) {
                    z10 = true;
                }
            }
            AutoCloseableKt.a(D0, null);
            return z10;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                AutoCloseableKt.a(D0, th2);
                throw th3;
            }
        }
    }

    private final boolean t(z3.b bVar) {
        z3.e D0 = bVar.D0("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name = 'room_master_table'");
        try {
            boolean z10 = false;
            if (D0.A0()) {
                if (D0.getLong(0) != 0) {
                    z10 = true;
                }
            }
            AutoCloseableKt.a(D0, null);
            return z10;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                AutoCloseableKt.a(D0, th2);
                throw th3;
            }
        }
    }

    private final void u(z3.b bVar) {
        Iterator it = n().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.b) it.next()).b(bVar);
        }
    }

    private final void v(z3.b bVar) {
        Iterator it = n().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.b) it.next()).d(bVar);
        }
    }

    private final void w(z3.b bVar) {
        Iterator it = n().iterator();
        while (it.hasNext()) {
            ((RoomDatabase.b) it.next()).f(bVar);
        }
    }

    public String A(String fileName) {
        Intrinsics.h(fileName, "fileName");
        return fileName;
    }

    protected abstract List n();

    protected abstract androidx.room.c o();

    /* JADX INFO: Access modifiers changed from: protected */
    public final int p(RoomDatabase.JournalMode journalMode) {
        Intrinsics.h(journalMode, "<this>");
        int i11 = c.f14647a[journalMode.ordinal()];
        if (i11 == 1) {
            return 1;
        }
        if (i11 == 2) {
            return 4;
        }
        throw new IllegalStateException(("Can't get max number of reader for journal mode '" + journalMode + '\'').toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int q(RoomDatabase.JournalMode journalMode) {
        Intrinsics.h(journalMode, "<this>");
        int i11 = c.f14647a[journalMode.ordinal()];
        if (i11 == 1 || i11 == 2) {
            return 1;
        }
        throw new IllegalStateException(("Can't get max number of writers for journal mode '" + journalMode + '\'').toString());
    }

    protected abstract d0 r();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void x(z3.b connection) {
        Intrinsics.h(connection, "connection");
        boolean s11 = s(connection);
        r().a(connection);
        if (!s11) {
            d0.a j11 = r().j(connection);
            if (!j11.f14736a) {
                throw new IllegalStateException(("Pre-packaged database has an invalid schema: " + j11.f14737b).toString());
            }
        }
        B(connection);
        r().f(connection);
        u(connection);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void y(z3.b connection, int i11, int i12) {
        Intrinsics.h(connection, "connection");
        List b11 = androidx.room.util.g.b(o().f14655d, i11, i12);
        if (b11 == null) {
            if (!androidx.room.util.g.d(o(), i11, i12)) {
                m(connection);
                v(connection);
                r().a(connection);
                return;
            } else {
                throw new IllegalStateException(("A migration from " + i11 + " to " + i12 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* functions.").toString());
            }
        }
        r().i(connection);
        Iterator it = b11.iterator();
        while (it.hasNext()) {
            ((y3.c) it.next()).b(connection);
        }
        d0.a j11 = r().j(connection);
        if (j11.f14736a) {
            r().h(connection);
            B(connection);
        } else {
            throw new IllegalStateException(("Migration didn't properly handle: " + j11.f14737b).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void z(z3.b connection) {
        Intrinsics.h(connection, "connection");
        f(connection);
        r().g(connection);
        w(connection);
        this.f14642a = true;
    }
}
