package androidx.room.support;

import a4.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class l implements e.c {

    /* renamed from: a, reason: collision with root package name */
    private final e.c f14855a;

    /* renamed from: b, reason: collision with root package name */
    private final AutoCloser f14856b;

    public l(e.c delegate, AutoCloser autoCloser) {
        Intrinsics.h(delegate, "delegate");
        Intrinsics.h(autoCloser, "autoCloser");
        this.f14855a = delegate;
        this.f14856b = autoCloser;
    }

    @Override // a4.e.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public AutoClosingRoomOpenHelper a(e.b configuration) {
        Intrinsics.h(configuration, "configuration");
        return new AutoClosingRoomOpenHelper(this.f14855a.a(configuration), this.f14856b);
    }
}
