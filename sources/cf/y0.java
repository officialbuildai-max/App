package cf;

import android.provider.Settings;
import androidx.core.app.ActivityCompat;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class y0 extends d {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public y0(o0 permissionBuilder) {
        super(permissionBuilder);
        Intrinsics.h(permissionBuilder, "permissionBuilder");
    }

    @Override // cf.e
    public void a(List permissions) {
        Intrinsics.h(permissions, "permissions");
        this.f17227a.B(this);
    }

    @Override // cf.e
    public void request() {
        boolean z10;
        if (!this.f17227a.M()) {
            finish();
            return;
        }
        if (this.f17227a.p() < 23) {
            this.f17227a.f17280j.add("android.permission.WRITE_SETTINGS");
            this.f17227a.f17276f.remove("android.permission.WRITE_SETTINGS");
            finish();
            return;
        }
        if (Settings.System.canWrite(this.f17227a.m())) {
            finish();
            return;
        }
        this.f17227a.getClass();
        if (this.f17227a.f17287q == null) {
            finish();
            return;
        }
        if (d().getBoolean("android.permission.WRITE_SETTINGS", false)) {
            z10 = ActivityCompat.j(this.f17227a.m(), "android.permission.WRITE_SETTINGS");
        } else {
            d().putBoolean("android.permission.WRITE_SETTINGS", true);
            z10 = true;
        }
        this.f17227a.E(this);
        List q11 = CollectionsKt.q("android.permission.WRITE_SETTINGS");
        o0 o0Var = this.f17227a;
        ze.b bVar = o0Var.f17287q;
        if (bVar != null) {
            Intrinsics.e(bVar);
            bVar.a(b(), q11, true, !z10);
        } else {
            o0Var.getClass();
            Intrinsics.e(null);
            b();
            throw null;
        }
    }
}
