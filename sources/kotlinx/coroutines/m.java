package kotlinx.coroutines;

import kotlin.jvm.functions.Function1;

/* loaded from: classes7.dex */
public interface m extends e2 {

    /* loaded from: classes7.dex */
    public static final class a implements m {

        /* renamed from: a, reason: collision with root package name */
        private final Function1 f68021a;

        public a(Function1 function1) {
            this.f68021a = function1;
        }

        @Override // kotlinx.coroutines.m
        public void a(Throwable th2) {
            this.f68021a.invoke(th2);
        }

        public String toString() {
            return "CancelHandler.UserSupplied[" + p0.a(this.f68021a) + '@' + p0.b(this) + ']';
        }
    }

    void a(Throwable th2);
}
