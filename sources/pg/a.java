package pg;

import android.app.Application;
import android.util.Log;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0912a f72569a = new C0912a(null);

    /* renamed from: b, reason: collision with root package name */
    private static Application f72570b;

    /* renamed from: c, reason: collision with root package name */
    private static b f72571c;

    /* renamed from: d, reason: collision with root package name */
    private static boolean f72572d;

    /* renamed from: pg.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0912a {
        private C0912a() {
        }

        public /* synthetic */ C0912a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return a.f72572d;
        }

        public final b b() {
            return a.f72571c;
        }

        public final boolean c() {
            b b11 = b();
            return (b11 != null ? b11.c() : false) || Log.isLoggable("net_proxy_tag", 3);
        }

        public final boolean d() {
            b b11;
            if (a() || (b11 = b()) == null) {
                return false;
            }
            return b11.d();
        }

        public final void e(Application application) {
            a.f72570b = application;
        }

        public final void f(Application application, b bVar) {
            Intrinsics.h(application, "application");
            e(application);
            i(bVar);
        }

        public final void g(boolean z10) {
            a.f72572d = z10;
        }

        public final void h(boolean z10) {
            g(z10);
        }

        public final void i(b bVar) {
            a.f72571c = bVar;
        }
    }
}
