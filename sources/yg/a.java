package yg;

import com.tn.lib.net.cons.HeaderType;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Interceptor;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0996a f79131a = new C0996a(null);

    /* renamed from: yg.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0996a {
        private C0996a() {
        }

        public /* synthetic */ C0996a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Interceptor a() {
            pg.b b11 = pg.a.f72569a.b();
            return (b11 != null ? b11.a() : null) == HeaderType.ONE_ROOM ? new c() : new c();
        }
    }
}
