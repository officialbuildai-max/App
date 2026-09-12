package androidx.room;

import a4.e;
import android.database.Cursor;
import androidx.room.RoomDatabase;
import com.mbridge.msdk.MBridgeConstans;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes2.dex */
public class f0 extends e.a {

    /* renamed from: h, reason: collision with root package name */
    public static final a f14758h = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private androidx.room.c f14759c;

    /* renamed from: d, reason: collision with root package name */
    private final List f14760d;

    /* renamed from: e, reason: collision with root package name */
    private final b f14761e;

    /* renamed from: f, reason: collision with root package name */
    private final String f14762f;

    /* renamed from: g, reason: collision with root package name */
    private final String f14763g;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(a4.d db2) {
            Intrinsics.h(db2, "db");
            Cursor i02 = db2.i0("SELECT name, type FROM sqlite_master WHERE type = 'table' OR type = 'view'");
            try {
                List c11 = CollectionsKt.c();
                while (i02.moveToNext()) {
                    String string = i02.getString(0);
                    Intrinsics.e(string);
                    if (!StringsKt.W(string, "sqlite_", false, 2, null) && !Intrinsics.c(string, "android_metadata")) {
                        c11.add(TuplesKt.a(string, Boolean.valueOf(Intrinsics.c(i02.getString(1), MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW))));
                    }
                }
                List<Pair> a11 = CollectionsKt.a(c11);
                CloseableKt.a(i02, null);
                for (Pair pair : a11) {
                    String str = (String) pair.component1();
                    if (((Boolean) pair.component2()).booleanValue()) {
                        db2.E("DROP VIEW IF EXISTS " + str);
                    } else {
                        db2.E("DROP TABLE IF EXISTS " + str);
                    }
                }
            } finally {
            }
        }

        public final boolean b(a4.d db2) {
            Intrinsics.h(db2, "db");
            Cursor i02 = db2.i0("SELECT count(*) FROM sqlite_master WHERE name != 'android_metadata'");
            try {
                boolean z10 = false;
                if (i02.moveToFirst()) {
                    if (i02.getInt(0) == 0) {
                        z10 = true;
                    }
                }
                CloseableKt.a(i02, null);
                return z10;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(i02, th2);
                    throw th3;
                }
            }
        }

        public final boolean c(a4.d db2) {
            Intrinsics.h(db2, "db");
            Cursor i02 = db2.i0("SELECT 1 FROM sqlite_master WHERE type = 'table' AND name='room_master_table'");
            try {
                boolean z10 = false;
                if (i02.moveToFirst()) {
                    if (i02.getInt(0) != 0) {
                        z10 = true;
                    }
                }
                CloseableKt.a(i02, null);
                return z10;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    CloseableKt.a(i02, th2);
                    throw th3;
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public final int f14764a;

        public b(int i11) {
            this.f14764a = i11;
        }

        public abstract void a(a4.d dVar);

        public abstract void b(a4.d dVar);

        public abstract void c(a4.d dVar);

        public abstract void d(a4.d dVar);

        public abstract void e(a4.d dVar);

        public abstract void f(a4.d dVar);

        public abstract c g(a4.d dVar);
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f14765a;

        /* renamed from: b, reason: collision with root package name */
        public final String f14766b;

        public c(boolean z10, String str) {
            this.f14765a = z10;
            this.f14766b = str;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f0(androidx.room.c configuration, b delegate, String identityHash, String legacyHash) {
        super(delegate.f14764a);
        Intrinsics.h(configuration, "configuration");
        Intrinsics.h(delegate, "delegate");
        Intrinsics.h(identityHash, "identityHash");
        Intrinsics.h(legacyHash, "legacyHash");
        this.f14760d = configuration.f14656e;
        this.f14759c = configuration;
        this.f14761e = delegate;
        this.f14762f = identityHash;
        this.f14763g = legacyHash;
    }

    private final void h(a4.d dVar) {
        if (!f14758h.c(dVar)) {
            c g11 = this.f14761e.g(dVar);
            if (g11.f14765a) {
                this.f14761e.e(dVar);
                j(dVar);
                return;
            } else {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g11.f14766b);
            }
        }
        Cursor b02 = dVar.b0(new a4.a("SELECT identity_hash FROM room_master_table WHERE id = 42 LIMIT 1"));
        try {
            String string = b02.moveToFirst() ? b02.getString(0) : null;
            CloseableKt.a(b02, null);
            if (Intrinsics.c(this.f14762f, string) || Intrinsics.c(this.f14763g, string)) {
                return;
            }
            throw new IllegalStateException("Room cannot verify the data integrity. Looks like you've changed schema but forgot to update the version number. You can simply fix this by increasing the version number. Expected identity hash: " + this.f14762f + ", found: " + string);
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                CloseableKt.a(b02, th2);
                throw th3;
            }
        }
    }

    private final void i(a4.d dVar) {
        dVar.E("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
    }

    private final void j(a4.d dVar) {
        i(dVar);
        dVar.E(c0.a(this.f14762f));
    }

    @Override // a4.e.a
    public void b(a4.d db2) {
        Intrinsics.h(db2, "db");
        super.b(db2);
    }

    @Override // a4.e.a
    public void d(a4.d db2) {
        Intrinsics.h(db2, "db");
        boolean b11 = f14758h.b(db2);
        this.f14761e.a(db2);
        if (!b11) {
            c g11 = this.f14761e.g(db2);
            if (!g11.f14765a) {
                throw new IllegalStateException("Pre-packaged database has an invalid schema: " + g11.f14766b);
            }
        }
        j(db2);
        this.f14761e.c(db2);
        List list = this.f14760d;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((RoomDatabase.b) it.next()).a(db2);
            }
        }
    }

    @Override // a4.e.a
    public void e(a4.d db2, int i11, int i12) {
        Intrinsics.h(db2, "db");
        g(db2, i11, i12);
    }

    @Override // a4.e.a
    public void f(a4.d db2) {
        Intrinsics.h(db2, "db");
        super.f(db2);
        h(db2);
        this.f14761e.d(db2);
        List list = this.f14760d;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((RoomDatabase.b) it.next()).e(db2);
            }
        }
        this.f14759c = null;
    }

    @Override // a4.e.a
    public void g(a4.d db2, int i11, int i12) {
        List d11;
        Intrinsics.h(db2, "db");
        androidx.room.c cVar = this.f14759c;
        if (cVar != null && (d11 = cVar.f14655d.d(i11, i12)) != null) {
            this.f14761e.f(db2);
            Iterator it = d11.iterator();
            while (it.hasNext()) {
                ((y3.c) it.next()).b(new androidx.room.driver.a(db2));
            }
            c g11 = this.f14761e.g(db2);
            if (g11.f14765a) {
                this.f14761e.e(db2);
                j(db2);
                return;
            } else {
                throw new IllegalStateException("Migration didn't properly handle: " + g11.f14766b);
            }
        }
        androidx.room.c cVar2 = this.f14759c;
        if (cVar2 == null || cVar2.e(i11, i12)) {
            throw new IllegalStateException("A migration from " + i11 + " to " + i12 + " was required but not found. Please provide the necessary Migration path via RoomDatabase.Builder.addMigration(Migration ...) or allow for destructive migrations via one of the RoomDatabase.Builder.fallbackToDestructiveMigration* methods.");
        }
        if (cVar2.f14671t) {
            f14758h.a(db2);
        } else {
            this.f14761e.b(db2);
        }
        List list = this.f14760d;
        if (list != null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                ((RoomDatabase.b) it2.next()).c(db2);
            }
        }
        this.f14761e.a(db2);
    }
}
