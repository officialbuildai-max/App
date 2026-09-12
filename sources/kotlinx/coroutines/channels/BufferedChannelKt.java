package kotlinx.coroutines.channels;

import kotlin.jvm.functions.Function3;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.internal.c0;
import kotlinx.coroutines.internal.z;

/* loaded from: classes7.dex */
public abstract class BufferedChannelKt {

    /* renamed from: a, reason: collision with root package name */
    private static final j f67784a = new j(-1, null, null, 0);

    /* renamed from: b, reason: collision with root package name */
    public static final int f67785b;

    /* renamed from: c, reason: collision with root package name */
    private static final int f67786c;

    /* renamed from: d, reason: collision with root package name */
    public static final z f67787d;

    /* renamed from: e, reason: collision with root package name */
    private static final z f67788e;

    /* renamed from: f, reason: collision with root package name */
    private static final z f67789f;

    /* renamed from: g, reason: collision with root package name */
    private static final z f67790g;

    /* renamed from: h, reason: collision with root package name */
    private static final z f67791h;

    /* renamed from: i, reason: collision with root package name */
    private static final z f67792i;

    /* renamed from: j, reason: collision with root package name */
    private static final z f67793j;

    /* renamed from: k, reason: collision with root package name */
    private static final z f67794k;

    /* renamed from: l, reason: collision with root package name */
    private static final z f67795l;

    /* renamed from: m, reason: collision with root package name */
    private static final z f67796m;

    /* renamed from: n, reason: collision with root package name */
    private static final z f67797n;

    /* renamed from: o, reason: collision with root package name */
    private static final z f67798o;

    /* renamed from: p, reason: collision with root package name */
    private static final z f67799p;

    /* renamed from: q, reason: collision with root package name */
    private static final z f67800q;

    /* renamed from: r, reason: collision with root package name */
    private static final z f67801r;

    /* renamed from: s, reason: collision with root package name */
    private static final z f67802s;

    static {
        int e11;
        int e12;
        e11 = c0.e("kotlinx.coroutines.bufferedChannel.segmentSize", 32, 0, 0, 12, null);
        f67785b = e11;
        e12 = c0.e("kotlinx.coroutines.bufferedChannel.expandBufferCompletionWaitIterations", 10000, 0, 0, 12, null);
        f67786c = e12;
        f67787d = new z("BUFFERED");
        f67788e = new z("SHOULD_BUFFER");
        f67789f = new z("S_RESUMING_BY_RCV");
        f67790g = new z("RESUMING_BY_EB");
        f67791h = new z("POISONED");
        f67792i = new z("DONE_RCV");
        f67793j = new z("INTERRUPTED_SEND");
        f67794k = new z("INTERRUPTED_RCV");
        f67795l = new z("CHANNEL_CLOSED");
        f67796m = new z("SUSPEND");
        f67797n = new z("SUSPEND_NO_WAITER");
        f67798o = new z("FAILED");
        f67799p = new z("NO_RECEIVE_RESULT");
        f67800q = new z("CLOSE_HANDLER_CLOSED");
        f67801r = new z("CLOSE_HANDLER_INVOKED");
        f67802s = new z("NO_CLOSE_CAUSE");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long A(int i11) {
        if (i11 == 0) {
            return 0L;
        }
        if (i11 != Integer.MAX_VALUE) {
            return i11;
        }
        return Long.MAX_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean B(kotlinx.coroutines.n nVar, Object obj, Function3 function3) {
        Object tryResume = nVar.tryResume(obj, null, function3);
        if (tryResume == null) {
            return false;
        }
        nVar.completeResume(tryResume);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean C(kotlinx.coroutines.n nVar, Object obj, Function3 function3, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            function3 = null;
        }
        return B(nVar, obj, function3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long v(long j11, boolean z10) {
        return (z10 ? 4611686018427387904L : 0L) + j11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long w(long j11, int i11) {
        return (i11 << 60) + j11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final j x(long j11, j jVar) {
        return new j(j11, jVar, jVar.y(), 0);
    }

    public static final KFunction y() {
        return BufferedChannelKt$createSegmentFunction$1.INSTANCE;
    }

    public static final z z() {
        return f67795l;
    }
}
