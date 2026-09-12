package ap;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f16171a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f16172b = LazyKt.b(new Function0() { // from class: ap.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            boolean c11;
            c11 = b.c();
            return Boolean.valueOf(c11);
        }
    });

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c() {
        return false;
    }

    public final boolean b() {
        return ((Boolean) f16172b.getValue()).booleanValue();
    }
}
