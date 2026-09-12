package androidx.window.layout;

import android.app.Activity;
import android.content.Context;
import androidx.window.extensions.layout.WindowLayoutComponent;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* loaded from: classes2.dex */
public interface x {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15457a = a.f15458a;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f15458a = new a();

        /* renamed from: b, reason: collision with root package name */
        private static final String f15459b = Reflection.b(x.class).g();

        /* renamed from: c, reason: collision with root package name */
        private static y f15460c = m.f15423a;

        private a() {
        }

        public final x a(Context context) {
            Intrinsics.h(context, "context");
            return f15460c.a(new WindowInfoTrackerImpl(f0.f15420a, b(context)));
        }

        public final v b(Context context) {
            Intrinsics.h(context, "context");
            p pVar = null;
            try {
                WindowLayoutComponent m11 = SafeWindowLayoutComponentProvider.f15388a.m();
                if (m11 != null) {
                    pVar = new p(m11);
                }
            } catch (Throwable unused) {
            }
            return pVar == null ? t.f15445c.a(context) : pVar;
        }
    }

    kotlinx.coroutines.flow.b a(Activity activity);
}
