package h1;

import java.util.ArrayList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList f64175a = new ArrayList();

    public final void a(b listener) {
        Intrinsics.h(listener, "listener");
        this.f64175a.add(listener);
    }

    public final void b() {
        for (int n11 = CollectionsKt.n(this.f64175a); -1 < n11; n11--) {
            ((b) this.f64175a.get(n11)).onRelease();
        }
    }

    public final void c(b listener) {
        Intrinsics.h(listener, "listener");
        this.f64175a.remove(listener);
    }
}
