package j1;

import androidx.datastore.core.CorruptionException;
import androidx.datastore.core.c;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class b implements c {

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f65827a;

    public b(Function1 produceNewData) {
        Intrinsics.h(produceNewData, "produceNewData");
        this.f65827a = produceNewData;
    }

    @Override // androidx.datastore.core.c
    public Object a(CorruptionException corruptionException, Continuation continuation) {
        return this.f65827a.invoke(corruptionException);
    }
}
