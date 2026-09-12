package androidx.datastore.preferences.core;

import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class PreferenceDataStore implements androidx.datastore.core.f {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.datastore.core.f f8735a;

    public PreferenceDataStore(androidx.datastore.core.f delegate) {
        Intrinsics.h(delegate, "delegate");
        this.f8735a = delegate;
    }

    @Override // androidx.datastore.core.f
    public Object a(Function2 function2, Continuation continuation) {
        return this.f8735a.a(new PreferenceDataStore$updateData$2(function2, null), continuation);
    }

    @Override // androidx.datastore.core.f
    public kotlinx.coroutines.flow.b getData() {
        return this.f8735a.getData();
    }
}
