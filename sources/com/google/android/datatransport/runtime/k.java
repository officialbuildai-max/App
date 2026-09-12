package com.google.android.datatransport.runtime;

import java.util.concurrent.Executor;

/* loaded from: classes3.dex */
public final class k implements u8.b {

    /* loaded from: classes3.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final k f24465a = new k();
    }

    public static k a() {
        return a.f24465a;
    }

    public static Executor b() {
        return (Executor) u8.d.d(j.a());
    }

    @Override // uz.a
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Executor get() {
        return b();
    }
}
