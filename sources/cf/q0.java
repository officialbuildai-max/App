package cf;

import android.os.Build;
import androidx.core.app.ActivityCompat;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class q0 extends d {

    /* renamed from: f, reason: collision with root package name */
    public static final a f17293f = new a(null);

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(o0 permissionBuilder) {
        super(permissionBuilder);
        Intrinsics.h(permissionBuilder, "permissionBuilder");
    }

    @Override // cf.e
    public void a(List permissions) {
        Intrinsics.h(permissions, "permissions");
        this.f17227a.u(this);
    }

    @Override // cf.e
    public void request() {
        boolean z10;
        if (this.f17227a.G()) {
            if (Build.VERSION.SDK_INT < 33) {
                this.f17227a.f17276f.remove("android.permission.BODY_SENSORS_BACKGROUND");
                this.f17227a.f17279i.add("android.permission.BODY_SENSORS_BACKGROUND");
                finish();
                return;
            }
            ye.c cVar = ye.c.f79116a;
            if (cVar.f(this.f17227a.m(), "android.permission.BODY_SENSORS_BACKGROUND")) {
                finish();
                return;
            }
            if (cVar.f(this.f17227a.m(), "android.permission.BODY_SENSORS")) {
                this.f17227a.getClass();
                if (this.f17227a.f17287q == null) {
                    a(CollectionsKt.l());
                    return;
                }
                if (d().getBoolean("android.permission.BODY_SENSORS_BACKGROUND", false)) {
                    z10 = ActivityCompat.j(this.f17227a.m(), "android.permission.BODY_SENSORS_BACKGROUND");
                } else {
                    d().putBoolean("android.permission.BODY_SENSORS_BACKGROUND", true);
                    z10 = true;
                }
                this.f17227a.E(this);
                List q11 = CollectionsKt.q("android.permission.BODY_SENSORS_BACKGROUND");
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
