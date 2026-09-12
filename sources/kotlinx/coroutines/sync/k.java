package kotlinx.coroutines.sync;

import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.z;

/* loaded from: classes7.dex */
public abstract class k {

    /* renamed from: a */
    private static final int f68112a;

    /* renamed from: b */
    private static final z f68113b;

    /* renamed from: c */
    private static final z f68114c;

    /* renamed from: d */
    private static final z f68115d;

    /* renamed from: e */
    private static final z f68116e;

    /* renamed from: f */
    private static final int f68117f;

    static {
        int e11;
        int e12;
        e11 = c0.e("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, null);
        f68112a = e11;
        f68113b = new z("PERMIT");
        f68114c = new z("TAKEN");
        f68115d = new z("BROKEN");
        f68116e = new z("CANCELLED");
        e12 = c0.e("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, null);
        f68117f = e12;
    }

    public static final h a(int i11, int i12) {
        return new j(i11, i12);
    }

    public static /* synthetic */ h b(int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i12 = 0;
        }
        return a(i11, i12);
    }

    public static final /* synthetic */ z d() {
        return f68115d;
    }

    public static final /* synthetic */ z e() {
        return f68116e;
    }

    public static final /* synthetic */ int f() {
        return f68112a;
    }

    public static final /* synthetic */ z g() {
        return f68113b;
    }

    public static final /* synthetic */ int h() {
        return f68117f;
    }

    public static final /* synthetic */ z i() {
        return f68114c;
    }

    public static final l j(long j11, l lVar) {
        return new l(j11, lVar, 0);
    }
}
