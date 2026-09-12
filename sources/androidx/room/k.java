package androidx.room;

import androidx.view.LiveData;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    private final RoomDatabase f14786a;

    /* renamed from: b, reason: collision with root package name */
    private final Set f14787b;

    public k(RoomDatabase database) {
        Intrinsics.h(database, "database");
        this.f14786a = database;
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap());
        Intrinsics.g(newSetFromMap, "newSetFromMap(...)");
        this.f14787b = newSetFromMap;
    }

    public final LiveData a(String[] tableNames, boolean z10, Function1 lambdaFunction) {
        Intrinsics.h(tableNames, "tableNames");
        Intrinsics.h(lambdaFunction, "lambdaFunction");
        return new b0(this.f14786a, this, z10, tableNames, lambdaFunction);
    }

    public final void b(LiveData liveData) {
        Intrinsics.h(liveData, "liveData");
        this.f14787b.add(liveData);
    }

    public final void c(LiveData liveData) {
        Intrinsics.h(liveData, "liveData");
        this.f14787b.remove(liveData);
    }
}
