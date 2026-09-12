package androidx.room.driver;

import a4.e;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class c implements z3.c {

    /* renamed from: a, reason: collision with root package name */
    private final e f14744a;

    public c(e openHelper) {
        Intrinsics.h(openHelper, "openHelper");
        this.f14744a = openHelper;
    }

    public final e a() {
        return this.f14744a;
    }

    @Override // z3.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a open(String fileName) {
        Intrinsics.h(fileName, "fileName");
        return new a(this.f14744a.getWritableDatabase());
    }
}
