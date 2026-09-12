package zf;

import android.content.Context;
import android.os.Bundle;
import com.therouter.router.Navigator;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private Bundle f79535a = new Bundle();

    public final Bundle a() {
        return this.f79535a;
    }

    public boolean b(Context context, Navigator navigator) {
        Intrinsics.h(context, "context");
        Intrinsics.h(navigator, "navigator");
        return false;
    }

    public void c() {
    }

    public final void d(Bundle b11) {
        Intrinsics.h(b11, "b");
        this.f79535a = b11;
    }
}
