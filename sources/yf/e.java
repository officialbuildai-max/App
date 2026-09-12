package yf;

import com.therouter.TheRouter;
import com.therouter.TheRouterKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class e extends d {

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f79130f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(String taskName, String dependsOn) {
        super(true, taskName, dependsOn, null);
        Intrinsics.h(taskName, "taskName");
        Intrinsics.h(dependsOn, "dependsOn");
    }

    public /* synthetic */ e(String str, String str2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i11 & 2) != 0 ? "" : str2);
    }

    private final boolean i() {
        boolean z10;
        while (true) {
            for (String str : b()) {
                z10 = z10 && TheRouter.f40758a.e().i(str).e();
            }
            return z10;
        }
    }

    @Override // yf.d
    public void g() {
        this.f79130f = true;
        if (c() == 2 || !i()) {
            return;
        }
        TheRouterKt.d("FlowTask", "Virtual Flow Task " + d() + " done", null, 4, null);
        h(2);
        TheRouter theRouter = TheRouter.f40758a;
        theRouter.e().m();
        theRouter.e().l(d());
    }

    public final void j() {
        if (this.f79130f) {
            g();
        }
    }
}
