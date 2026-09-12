package androidx.work.impl.utils;

import android.net.NetworkRequest;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public static final r f16075a = new r();

    private r() {
    }

    public static final NetworkRequest a(int[] capabilities, int[] transports) {
        int[] iArr;
        Intrinsics.h(capabilities, "capabilities");
        Intrinsics.h(transports, "transports");
        NetworkRequest.Builder builder = new NetworkRequest.Builder();
        for (int i11 : capabilities) {
            try {
                builder.addCapability(i11);
            } catch (IllegalArgumentException e11) {
                androidx.work.t.e().l(v.f16077b.a(), "Ignoring adding capability '" + i11 + '\'', e11);
            }
        }
        iArr = w.f16080a;
        for (int i12 : iArr) {
            if (!ArraysKt.M(capabilities, i12)) {
                try {
                    builder.removeCapability(i12);
                } catch (IllegalArgumentException e12) {
                    androidx.work.t.e().l(v.f16077b.a(), "Ignoring removing default capability '" + i12 + '\'', e12);
                }
            }
        }
        for (int i13 : transports) {
            builder.addTransportType(i13);
        }
        NetworkRequest build = builder.build();
        Intrinsics.g(build, "build(...)");
        return build;
    }

    public final v b(int[] capabilities, int[] transports) {
        Intrinsics.h(capabilities, "capabilities");
        Intrinsics.h(transports, "transports");
        return new v(a(capabilities, transports));
    }

    public final boolean c(NetworkRequest request, int i11) {
        boolean hasCapability;
        Intrinsics.h(request, "request");
        hasCapability = request.hasCapability(i11);
        return hasCapability;
    }

    public final boolean d(NetworkRequest request, int i11) {
        boolean hasTransport;
        Intrinsics.h(request, "request");
        hasTransport = request.hasTransport(i11);
        return hasTransport;
    }
}
