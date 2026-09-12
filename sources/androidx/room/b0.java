package androidx.room;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class b0 extends RoomTrackingLiveData {

    /* renamed from: t, reason: collision with root package name */
    private final Function1 f14651t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(RoomDatabase database, k container, boolean z10, String[] tableNames, Function1 lambdaFunction) {
        super(database, container, z10, tableNames, null);
        Intrinsics.h(database, "database");
        Intrinsics.h(container, "container");
        Intrinsics.h(tableNames, "tableNames");
        Intrinsics.h(lambdaFunction, "lambdaFunction");
        this.f14651t = lambdaFunction;
    }

    @Override // androidx.room.RoomTrackingLiveData
    public Object t(Continuation continuation) {
        return androidx.room.util.b.f(u(), true, v(), this.f14651t, continuation);
    }
}
