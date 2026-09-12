package androidx.work.impl;

import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class i0 {

    /* renamed from: a, reason: collision with root package name */
    private static final String f15771a;

    /* renamed from: b, reason: collision with root package name */
    private static final String[] f15772b;

    static {
        String i11 = androidx.work.t.i("WrkDbPathHelper");
        Intrinsics.g(i11, "tagWithPrefix(...)");
        f15771a = i11;
        f15772b = new String[]{"-journal", "-shm", "-wal"};
    }
}
