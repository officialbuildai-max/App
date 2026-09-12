package androidx.core.app;

import android.content.res.Configuration;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private final boolean f8200a;

    /* renamed from: b, reason: collision with root package name */
    private Configuration f8201b;

    public x(boolean z10) {
        this.f8200a = z10;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x(boolean z10, Configuration newConfig) {
        this(z10);
        Intrinsics.h(newConfig, "newConfig");
        this.f8201b = newConfig;
    }

    public final boolean a() {
        return this.f8200a;
    }
}
