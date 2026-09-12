package androidx.work.impl.utils;

import android.net.NetworkRequest;
import android.os.Build;
import androidx.work.NetworkType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class x {

    /* loaded from: classes2.dex */
    public static final /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16081a;

        static {
            int[] iArr = new int[NetworkType.values().length];
            try {
                iArr[NetworkType.METERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NetworkType.UNMETERED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NetworkType.NOT_ROAMING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f16081a = iArr;
        }
    }

    public static final NetworkRequest a(NetworkType networkType) {
        Intrinsics.h(networkType, "<this>");
        if (networkType == NetworkType.NOT_REQUIRED) {
            return null;
        }
        NetworkRequest.Builder removeCapability = new NetworkRequest.Builder().addCapability(12).addCapability(16).removeCapability(15).removeCapability(13);
        if (Build.VERSION.SDK_INT >= 30 && networkType == NetworkType.TEMPORARILY_UNMETERED) {
            return removeCapability.addCapability(25).build();
        }
        int i11 = a.f16081a[networkType.ordinal()];
        if (i11 == 1) {
            removeCapability = removeCapability.addTransportType(0);
        } else if (i11 == 2) {
            removeCapability = removeCapability.addCapability(11);
        } else if (i11 == 3) {
            removeCapability = removeCapability.addCapability(18);
        }
        return removeCapability.build();
    }
}
