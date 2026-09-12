package hh;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nh.m;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f64587a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static boolean f64588b;

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Application application) {
            Intrinsics.h(application, "application");
            if (c.f64588b) {
                return;
            }
            c.f64588b = true;
            Utils.b(application);
            m.f70597a.f();
            b.f64584b.a().e(application);
        }
    }
}
