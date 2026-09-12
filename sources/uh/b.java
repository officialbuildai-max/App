package uh;

import android.app.Application;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f76876a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static uh.a f76877b;

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a() {
            if (b.f76877b == null) {
                b.f76877b = b();
            }
        }

        private final uh.a b() {
            return xh.b.f78428a.a();
        }

        public final void c(Application application) {
            Intrinsics.h(application, "application");
            xh.b.f78428a.b(application);
        }

        public final void d(int i11) {
            a();
            uh.a aVar = b.f76877b;
            if (aVar != null) {
                aVar.a(i11);
            }
        }

        public final void e(CharSequence charSequence) {
            a();
            uh.a aVar = b.f76877b;
            if (aVar != null) {
                aVar.b(charSequence);
            }
        }

        public final void f(CharSequence charSequence, int i11) {
            a();
            uh.a aVar = b.f76877b;
            if (aVar != null) {
                aVar.d(charSequence, i11);
            }
        }

        public final void g(int i11, CharSequence text, int i12, int i13, int i14) {
            Intrinsics.h(text, "text");
            a();
            uh.a aVar = b.f76877b;
            if (aVar != null) {
                aVar.c(i11, text, i12, i13, i14);
            }
        }
    }
}
