package androidx.view;

import androidx.view.Lifecycle;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class m0 implements r {

    /* renamed from: a, reason: collision with root package name */
    private final SavedStateHandlesProvider f9704a;

    public m0(SavedStateHandlesProvider provider) {
        Intrinsics.h(provider, "provider");
        this.f9704a = provider;
    }

    @Override // androidx.view.r
    public void onStateChanged(u source, Lifecycle.Event event) {
        Intrinsics.h(source, "source");
        Intrinsics.h(event, "event");
        if (event == Lifecycle.Event.ON_CREATE) {
            source.getLifecycle().d(this);
            this.f9704a.c();
        } else {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + event).toString());
        }
    }
}
