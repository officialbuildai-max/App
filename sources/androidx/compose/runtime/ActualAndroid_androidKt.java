package androidx.compose.runtime;

import android.os.Looper;
import android.util.Log;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public abstract class ActualAndroid_androidKt {

    /* renamed from: a, reason: collision with root package name */
    private static final Lazy f3624a = LazyKt.b(new Function0<u0>() { // from class: androidx.compose.runtime.ActualAndroid_androidKt$DefaultMonotonicFrameClock$2
        @Override // kotlin.jvm.functions.Function0
        public final u0 invoke() {
            return Looper.getMainLooper() != null ? DefaultChoreographerFrameClock.f3673a : SdkStubsFallbackFrameClock.f3738a;
        }
    });

    /* renamed from: b, reason: collision with root package name */
    private static final long f3625b;

    static {
        long j11;
        try {
            j11 = Looper.getMainLooper().getThread().getId();
        } catch (Exception unused) {
            j11 = -1;
        }
        f3625b = j11;
    }

    public static final c1 a(float f11) {
        return new ParcelableSnapshotMutableFloatState(f11);
    }

    public static final e1 b(int i11) {
        return new ParcelableSnapshotMutableIntState(i11);
    }

    public static final androidx.compose.runtime.snapshots.r c(Object obj, q2 q2Var) {
        return new ParcelableSnapshotMutableState(obj, q2Var);
    }

    public static final long d() {
        return f3625b;
    }

    public static final void e(String str, Throwable th2) {
        Log.e("ComposeInternal", str, th2);
    }
}
