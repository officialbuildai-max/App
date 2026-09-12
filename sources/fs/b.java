package fs;

import android.app.Application;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f62582a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static fs.a f62583b;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a() {
            if (b.f62583b == null) {
                b.f62583b = b();
            }
        }

        private final fs.a b() {
            return is.b.f65739a.a();
        }

        public final void c(Application application) {
            Intrinsics.h(application, "application");
            is.b.f65739a.b(application);
        }

        public final void d(int i11) {
            a();
            fs.a aVar = b.f62583b;
            if (aVar != null) {
                aVar.a(i11);
            }
        }

        public final void e(CharSequence charSequence) {
            a();
            fs.a aVar = b.f62583b;
            if (aVar != null) {
                aVar.b(charSequence);
            }
        }
    }
}
