package androidx.work.impl.utils;

import android.net.NetworkRequest;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
final class u {

    /* renamed from: a, reason: collision with root package name */
    public static final u f16076a = new u();

    private u() {
    }

    public final int[] a(NetworkRequest request) {
        int[] capabilities;
        Intrinsics.h(request, "request");
        capabilities = request.getCapabilities();
        Intrinsics.g(capabilities, "getCapabilities(...)");
        return capabilities;
    }

    public final int[] b(NetworkRequest request) {
        int[] transportTypes;
        Intrinsics.h(request, "request");
        transportTypes = request.getTransportTypes();
        Intrinsics.g(transportTypes, "getTransportTypes(...)");
        return transportTypes;
    }
}
