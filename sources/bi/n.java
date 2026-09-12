package bi;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public static final n f16626a = new n();

    /* renamed from: b, reason: collision with root package name */
    private static String[] f16627b = new String[0];

    /* renamed from: c, reason: collision with root package name */
    private static String[] f16628c = new String[0];

    private n() {
    }

    public static final boolean a(String serverApi) {
        Intrinsics.h(serverApi, "serverApi");
        return ArraysKt.O(f16627b, serverApi);
    }

    public static final boolean b(String serverApi) {
        Intrinsics.h(serverApi, "serverApi");
        return ArraysKt.O(f16628c, serverApi);
    }
}
