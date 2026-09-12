package gz;

import com.tencent.mmkv.MMKV;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f64159a = new b();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f64160b = LazyKt.b(new Function0() { // from class: gz.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MMKV c11;
            c11 = b.c();
            return c11;
        }
    });

    private b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV c() {
        MMKV J = MMKV.J("dyso_config", 2);
        Intrinsics.g(J, "mmkvWithID(...)");
        return J;
    }

    public final MMKV b() {
        return (MMKV) f64160b.getValue();
    }
}
