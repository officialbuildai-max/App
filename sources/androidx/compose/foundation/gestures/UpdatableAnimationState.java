package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.animation.core.v0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FloatCompanionObject;

/* loaded from: classes.dex */
public final class UpdatableAnimationState {

    /* renamed from: f, reason: collision with root package name */
    private static final a f2782f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    public static final int f2783g = 8;

    /* renamed from: h, reason: collision with root package name */
    private static final androidx.compose.animation.core.k f2784h = new androidx.compose.animation.core.k(0.0f);

    /* renamed from: a, reason: collision with root package name */
    private final v0 f2785a;

    /* renamed from: b, reason: collision with root package name */
    private long f2786b = Long.MIN_VALUE;

    /* renamed from: c, reason: collision with root package name */
    private androidx.compose.animation.core.k f2787c = f2784h;

    /* renamed from: d, reason: collision with root package name */
    private boolean f2788d;

    /* renamed from: e, reason: collision with root package name */
    private float f2789e;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final androidx.compose.animation.core.k a() {
            return UpdatableAnimationState.f2784h;
        }

        public final boolean b(float f11) {
            return Math.abs(f11) < 0.01f;
        }
    }

    public UpdatableAnimationState(androidx.compose.animation.core.g gVar) {
        this.f2785a = gVar.a(VectorConvertersKt.b(FloatCompanionObject.f67404a));
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a7, code lost:
    
        if (r13 != 0.0f) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:48:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0028  */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v19 */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x009f -> B:24:0x00a2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(kotlin.jvm.functions.Function1 r13, kotlin.jvm.functions.Function0 r14, kotlin.coroutines.Continuation r15) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.UpdatableAnimationState.h(kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final float i() {
        return this.f2789e;
    }

    public final void j(float f11) {
        this.f2789e = f11;
    }
}
