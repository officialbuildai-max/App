package wt;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import wt.b;

/* loaded from: classes7.dex */
public interface b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f78072a = a.f78073a;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f78073a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final Lazy f78074b = LazyKt.b(new Function0() { // from class: wt.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                d c11;
                c11 = b.a.c();
                return c11;
            }
        });

        private a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final d c() {
            return new d();
        }

        public final b b() {
            return (b) f78074b.getValue();
        }
    }

    void init();
}
