package androidx.room;

import a4.e;
import android.content.Context;
import android.content.Intent;
import androidx.room.RoomDatabase;
import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public final Context f14652a;

    /* renamed from: b, reason: collision with root package name */
    public final String f14653b;

    /* renamed from: c, reason: collision with root package name */
    public final e.c f14654c;

    /* renamed from: d, reason: collision with root package name */
    public final RoomDatabase.d f14655d;

    /* renamed from: e, reason: collision with root package name */
    public final List f14656e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f14657f;

    /* renamed from: g, reason: collision with root package name */
    public final RoomDatabase.JournalMode f14658g;

    /* renamed from: h, reason: collision with root package name */
    public final Executor f14659h;

    /* renamed from: i, reason: collision with root package name */
    public final Executor f14660i;

    /* renamed from: j, reason: collision with root package name */
    public final Intent f14661j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f14662k;

    /* renamed from: l, reason: collision with root package name */
    public final boolean f14663l;

    /* renamed from: m, reason: collision with root package name */
    private final Set f14664m;

    /* renamed from: n, reason: collision with root package name */
    public final String f14665n;

    /* renamed from: o, reason: collision with root package name */
    public final File f14666o;

    /* renamed from: p, reason: collision with root package name */
    public final Callable f14667p;

    /* renamed from: q, reason: collision with root package name */
    public final RoomDatabase.e f14668q;

    /* renamed from: r, reason: collision with root package name */
    public final List f14669r;

    /* renamed from: s, reason: collision with root package name */
    public final List f14670s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f14671t;

    /* renamed from: u, reason: collision with root package name */
    public final z3.c f14672u;

    /* renamed from: v, reason: collision with root package name */
    public final CoroutineContext f14673v;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f14674w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f14675x;

    public c(Context context, String str, e.c cVar, RoomDatabase.d migrationContainer, List list, boolean z10, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, Intent intent, boolean z11, boolean z12, Set set, String str2, File file, Callable callable, RoomDatabase.e eVar, List typeConverters, List autoMigrationSpecs, boolean z13, z3.c cVar2, CoroutineContext coroutineContext) {
        Intrinsics.h(context, "context");
        Intrinsics.h(migrationContainer, "migrationContainer");
        Intrinsics.h(journalMode, "journalMode");
        Intrinsics.h(queryExecutor, "queryExecutor");
        Intrinsics.h(transactionExecutor, "transactionExecutor");
        Intrinsics.h(typeConverters, "typeConverters");
        Intrinsics.h(autoMigrationSpecs, "autoMigrationSpecs");
        this.f14652a = context;
        this.f14653b = str;
        this.f14654c = cVar;
        this.f14655d = migrationContainer;
        this.f14656e = list;
        this.f14657f = z10;
        this.f14658g = journalMode;
        this.f14659h = queryExecutor;
        this.f14660i = transactionExecutor;
        this.f14661j = intent;
        this.f14662k = z11;
        this.f14663l = z12;
        this.f14664m = set;
        this.f14665n = str2;
        this.f14666o = file;
        this.f14667p = callable;
        this.f14668q = eVar;
        this.f14669r = typeConverters;
        this.f14670s = autoMigrationSpecs;
        this.f14671t = z13;
        this.f14672u = cVar2;
        this.f14673v = coroutineContext;
        this.f14674w = intent != null;
        this.f14675x = true;
    }

    public static /* synthetic */ c b(c cVar, Context context, String str, e.c cVar2, RoomDatabase.d dVar, List list, boolean z10, RoomDatabase.JournalMode journalMode, Executor executor, Executor executor2, Intent intent, boolean z11, boolean z12, Set set, String str2, File file, Callable callable, RoomDatabase.e eVar, List list2, List list3, boolean z13, z3.c cVar3, CoroutineContext coroutineContext, int i11, Object obj) {
        if (obj == null) {
            return cVar.a((i11 & 1) != 0 ? cVar.f14652a : context, (i11 & 2) != 0 ? cVar.f14653b : str, (i11 & 4) != 0 ? cVar.f14654c : cVar2, (i11 & 8) != 0 ? cVar.f14655d : dVar, (i11 & 16) != 0 ? cVar.f14656e : list, (i11 & 32) != 0 ? cVar.f14657f : z10, (i11 & 64) != 0 ? cVar.f14658g : journalMode, (i11 & 128) != 0 ? cVar.f14659h : executor, (i11 & 256) != 0 ? cVar.f14660i : executor2, (i11 & 512) != 0 ? cVar.f14661j : intent, (i11 & 1024) != 0 ? cVar.f14662k : z11, (i11 & 2048) != 0 ? cVar.f14663l : z12, (i11 & 4096) != 0 ? cVar.f14664m : set, (i11 & 8192) != 0 ? cVar.f14665n : str2, (i11 & 16384) != 0 ? cVar.f14666o : file, (i11 & 32768) != 0 ? cVar.f14667p : callable, (i11 & 65536) != 0 ? cVar.f14668q : eVar, (i11 & 131072) != 0 ? cVar.f14669r : list2, (i11 & 262144) != 0 ? cVar.f14670s : list3, (i11 & 524288) != 0 ? cVar.f14671t : z13, (i11 & 1048576) != 0 ? cVar.f14672u : cVar3, (i11 & 2097152) != 0 ? cVar.f14673v : coroutineContext);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copy");
    }

    public final c a(Context context, String str, e.c cVar, RoomDatabase.d migrationContainer, List list, boolean z10, RoomDatabase.JournalMode journalMode, Executor queryExecutor, Executor transactionExecutor, Intent intent, boolean z11, boolean z12, Set set, String str2, File file, Callable callable, RoomDatabase.e eVar, List typeConverters, List autoMigrationSpecs, boolean z13, z3.c cVar2, CoroutineContext coroutineContext) {
        Intrinsics.h(context, "context");
        Intrinsics.h(migrationContainer, "migrationContainer");
        Intrinsics.h(journalMode, "journalMode");
        Intrinsics.h(queryExecutor, "queryExecutor");
        Intrinsics.h(transactionExecutor, "transactionExecutor");
        Intrinsics.h(typeConverters, "typeConverters");
        Intrinsics.h(autoMigrationSpecs, "autoMigrationSpecs");
        return new c(context, str, cVar, migrationContainer, list, z10, journalMode, queryExecutor, transactionExecutor, intent, z11, z12, set, str2, file, callable, eVar, typeConverters, autoMigrationSpecs, z13, cVar2, coroutineContext);
    }

    public final Set c() {
        return this.f14664m;
    }

    public final boolean d() {
        return this.f14675x;
    }

    public boolean e(int i11, int i12) {
        return androidx.room.util.g.d(this, i11, i12);
    }

    public final void f(boolean z10) {
        this.f14675x = z10;
    }
}
