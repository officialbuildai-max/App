package androidx.room.support;

import a4.e;
import java.io.File;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class n implements e.c {

    /* renamed from: a, reason: collision with root package name */
    private final String f14866a;

    /* renamed from: b, reason: collision with root package name */
    private final File f14867b;

    /* renamed from: c, reason: collision with root package name */
    private final Callable f14868c;

    /* renamed from: d, reason: collision with root package name */
    private final e.c f14869d;

    public n(String str, File file, Callable callable, e.c delegate) {
        Intrinsics.h(delegate, "delegate");
        this.f14866a = str;
        this.f14867b = file;
        this.f14868c = callable;
        this.f14869d = delegate;
    }

    @Override // a4.e.c
    public a4.e a(e.b configuration) {
        Intrinsics.h(configuration, "configuration");
        return new m(configuration.f231a, this.f14866a, this.f14867b, this.f14868c, configuration.f233c.f229a, this.f14869d.a(configuration));
    }
}
