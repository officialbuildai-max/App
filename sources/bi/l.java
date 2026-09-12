package bi;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public static final l f16622a = new l();

    /* renamed from: b, reason: collision with root package name */
    private static String[] f16623b = new String[0];

    /* renamed from: c, reason: collision with root package name */
    private static String[] f16624c = new String[0];

    private l() {
    }

    public static final boolean a(String path) {
        Intrinsics.h(path, "path");
        return ArraysKt.O(f16623b, path);
    }

    public static final boolean b(String path) {
        Intrinsics.h(path, "path");
        return ArraysKt.O(f16624c, path);
    }
}
