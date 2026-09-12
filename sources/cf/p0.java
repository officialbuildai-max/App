package cf;

import android.os.Build;
import androidx.core.app.ActivityCompat;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class p0 extends d {

    /* renamed from: f, reason: collision with root package name */
    public static final a f17290f = new a(null);

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(o0 permissionBuilder) {
        super(permissionBuilder);
        Intrinsics.h(permissionBuilder, "permissionBuilder");
    }

    @Override // cf.e
    public void a(List permissions) {
        Intrinsics.h(permissions, "permissions");
        this.f17227a.t(this);
    }

    @Override // cf.e
    public void request() {
        boolean z10;
        if (this.f17227a.F()) {
            if (Build.VERSION.SDK_INT < 29) {
                this.f17227a.f17276f.remove("android.permission.ACCESS_BACKGROUND_LOCATION");
                this.f17227a.f17279i.add("android.permission.ACCESS_BACKGROUND_LOCATION");
                finish();
                return;
            }
            ye.c cVar = ye.c.f79116a;
            if (cVar.f(this.f17227a.m(), "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                finish();
                return;
            }
            boolean f11 = cVar.f(this.f17227a.m(), "android.permission.ACCESS_FINE_LOCATION");
            boolean f12 = cVar.f(this.f17227a.m(), "android.permission.ACCESS_COARSE_LOCATION");
            if (f11 || f12) {
                this.f17227a.getClass();
                if (this.f17227a.f17287q == null) {
                    a(CollectionsKt.l());
                    return;
                }
                if (d().getBoolean("android.permission.ACCESS_BACKGROUND_LOCATION", false)) {
                    z10 = ActivityCompat.j(this.f17227a.m(), "android.permission.ACCESS_BACKGROUND_LOCATION");
                } else {
                    d().putBoolean("android.permission.ACCESS_BACKGROUND_LOCATION", true);
                    z10 = true;
                }
                this.f17227a.E(this);
                List q11 = CollectionsKt.q("android.permission.ACCESS_BACKGROUND_LOCATION");
                o0 o0Var = this.f17227a;
                ze.b bVar = o0Var.f17287q;
                if (bVar != null) {
                    Intrinsics.e(bVar);
                    bVar.a(b(), q11, true, !z10);
                    return;
                } else {
                    o0Var.getClass();
                    Intrinsics.e(null);
                    b();
                    throw null;
                }
            }
        }
        finish();
    }
}
