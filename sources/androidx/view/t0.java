package androidx.view;

import java.io.Closeable;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import q1.f;

/* loaded from: classes.dex */
public abstract class t0 {
    private final f impl = new f();

    @Deprecated
    public /* synthetic */ void addCloseable(Closeable closeable) {
        Intrinsics.h(closeable, "closeable");
        f fVar = this.impl;
        if (fVar != null) {
            fVar.d(closeable);
        }
    }

    public void addCloseable(AutoCloseable closeable) {
        Intrinsics.h(closeable, "closeable");
        f fVar = this.impl;
        if (fVar != null) {
            fVar.d(closeable);
        }
    }

    public final void addCloseable(String key, AutoCloseable closeable) {
        Intrinsics.h(key, "key");
        Intrinsics.h(closeable, "closeable");
        f fVar = this.impl;
        if (fVar != null) {
            fVar.e(key, closeable);
        }
    }

    public final void clear$lifecycle_viewmodel_release() {
        f fVar = this.impl;
        if (fVar != null) {
            fVar.f();
        }
        onCleared();
    }

    public final <T extends AutoCloseable> T getCloseable(String key) {
        Intrinsics.h(key, "key");
        f fVar = this.impl;
        if (fVar != null) {
            return (T) fVar.h(key);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCleared() {
    }
}
