package ep;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public static final e f62097a = new e();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f62098b = LazyKt.b(new Function0() { // from class: ep.d
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV d11;
            d11 = e.d();
            return d11;
        }
    });

    private e() {
    }

    private final MMKV b() {
        return (MMKV) f62098b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV d() {
        MMKV I = MMKV.I("shorts_progress_cache");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    public final long c(String postId) {
        Intrinsics.h(postId, "postId");
        if (postId.length() == 0) {
            return 0L;
        }
        return b().h(postId, 0L);
    }

    public final void e(String postId, long j11) {
        Intrinsics.h(postId, "postId");
        if (postId.length() == 0) {
            return;
        }
        b().t(postId, j11);
    }
}
