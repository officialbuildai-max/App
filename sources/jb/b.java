package jb;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private final Bundle f66106a = new Bundle();

    public final Bundle a() {
        return this.f66106a;
    }

    public final void b(String key, long j11) {
        Intrinsics.h(key, "key");
        this.f66106a.putLong(key, j11);
    }

    public final void c(String key, String value) {
        Intrinsics.h(key, "key");
        Intrinsics.h(value, "value");
        this.f66106a.putString(key, value);
    }
}
