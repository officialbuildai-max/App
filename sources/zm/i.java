package zm;

import androidx.view.b0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public static final i f79561a = new i();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f79562b = LazyKt.b(new Function0() { // from class: zm.h
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 c11;
            c11 = i.c();
            return c11;
        }
    });

    private i() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 c() {
        return new b0();
    }

    public final b0 b() {
        return (b0) f79562b.getValue();
    }
}
