package androidx.view;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public static final q f9721a = new q();

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicBoolean f9722b = new AtomicBoolean(false);

    /* loaded from: classes.dex */
    public static final class a extends j {
        @Override // androidx.view.j, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            Intrinsics.h(activity, "activity");
            i0.INSTANCE.c(activity);
        }
    }

    private q() {
    }

    public static final void a(Context context) {
        Intrinsics.h(context, "context");
        if (f9722b.getAndSet(true)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        Intrinsics.f(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new a());
    }
}
