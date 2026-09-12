package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.w;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: classes.dex */
public final class DefaultFlingBehavior implements g {

    /* renamed from: a, reason: collision with root package name */
    private w f2724a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.compose.ui.j f2725b;

    /* renamed from: c, reason: collision with root package name */
    private int f2726c;

    public DefaultFlingBehavior(w wVar, androidx.compose.ui.j jVar) {
        this.f2724a = wVar;
        this.f2725b = jVar;
    }

    public /* synthetic */ DefaultFlingBehavior(w wVar, androidx.compose.ui.j jVar, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(wVar, (i11 & 2) != 0 ? ScrollableKt.e() : jVar);
    }

    @Override // androidx.compose.foundation.gestures.g
    public Object a(k kVar, float f11, Continuation continuation) {
        this.f2726c = 0;
        return kotlinx.coroutines.i.g(this.f2725b, new DefaultFlingBehavior$performFling$2(f11, this, kVar, null), continuation);
    }

    public final w b() {
        return this.f2724a;
    }

    public final int c() {
        return this.f2726c;
    }

    public final void d(w wVar) {
        this.f2724a = wVar;
    }

    public final void e(int i11) {
        this.f2726c = i11;
    }
}
