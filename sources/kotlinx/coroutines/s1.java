package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class s1 extends w1 {

    /* renamed from: e, reason: collision with root package name */
    private final Function1 f68040e;

    public s1(Function1 function1) {
        this.f68040e = function1;
    }

    @Override // kotlinx.coroutines.w1
    public boolean u() {
        return false;
    }

    @Override // kotlinx.coroutines.w1
    public void v(Throwable th2) {
        this.f68040e.invoke(th2);
    }
}
