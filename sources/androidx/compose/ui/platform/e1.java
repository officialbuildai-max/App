package androidx.compose.ui.platform;

import androidx.compose.ui.j;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class e1 implements androidx.compose.ui.j {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.compose.runtime.c1 f5853a = androidx.compose.runtime.p1.a(1.0f);

    public void a(float f11) {
        this.f5853a.setFloatValue(f11);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public Object fold(Object obj, Function2 function2) {
        return j.a.a(this, obj, function2);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element, kotlin.coroutines.CoroutineContext
    public CoroutineContext.Element get(CoroutineContext.Key key) {
        return j.a.b(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext.Element
    public /* synthetic */ CoroutineContext.Key getKey() {
        return androidx.compose.ui.i.a(this);
    }

    @Override // androidx.compose.ui.j
    public float k() {
        return this.f5853a.getFloatValue();
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext minusKey(CoroutineContext.Key key) {
        return j.a.c(this, key);
    }

    @Override // kotlin.coroutines.CoroutineContext
    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return j.a.d(this, coroutineContext);
    }
}
