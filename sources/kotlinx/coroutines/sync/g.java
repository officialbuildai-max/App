package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.z;

/* loaded from: classes7.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    private static final z f68109a = new z("NO_OWNER");

    /* renamed from: b, reason: collision with root package name */
    private static final z f68110b = new z("ALREADY_LOCKED_BY_OWNER");

    public static final a a(boolean z10) {
        return new f(z10);
    }

    public static /* synthetic */ a b(boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        return a(z10);
    }
}
