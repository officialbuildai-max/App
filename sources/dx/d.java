package dx;

import androidx.view.b0;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f61578a = new d();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f61579b = LazyKt.b(new Function0() { // from class: dx.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 g11;
            g11 = d.g();
            return g11;
        }
    });

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f61580c = LazyKt.b(new Function0() { // from class: dx.b
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 f11;
            f11 = d.f();
            return f11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static final Lazy f61581d = LazyKt.b(new Function0() { // from class: dx.c
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            b0 e11;
            e11 = d.e();
            return e11;
        }
    });

    private d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 e() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 f() {
        return new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final b0 g() {
        return new b0();
    }

    public final b0 d() {
        return (b0) f61579b.getValue();
    }
}
