package androidx.room.driver;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class a implements z3.b {

    /* renamed from: a, reason: collision with root package name */
    private final a4.d f14742a;

    public a(a4.d db2) {
        Intrinsics.h(db2, "db");
        this.f14742a = db2;
    }

    @Override // z3.b, java.lang.AutoCloseable
    public void close() {
        this.f14742a.close();
    }

    public final a4.d d() {
        return this.f14742a;
    }

    @Override // z3.b
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public d D0(String sql) {
        Intrinsics.h(sql, "sql");
        return d.f14745d.a(this.f14742a, sql);
    }
}
