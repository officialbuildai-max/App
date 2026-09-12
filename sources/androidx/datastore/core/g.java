package androidx.datastore.core;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f8675a = new g();

    private g() {
    }

    public final f a(s storage, j1.b bVar, List migrations, n0 scope) {
        Intrinsics.h(storage, "storage");
        Intrinsics.h(migrations, "migrations");
        Intrinsics.h(scope, "scope");
        c cVar = bVar;
        if (bVar == null) {
            cVar = new j1.a();
        }
        return new DataStoreImpl(storage, CollectionsKt.e(DataMigrationInitializer.f8639a.b(migrations)), cVar, scope);
    }
}
