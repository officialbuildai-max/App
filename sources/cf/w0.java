package cf;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class w0 extends d {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w0(o0 permissionBuilder) {
        super(permissionBuilder);
        Intrinsics.h(permissionBuilder, "permissionBuilder");
    }

    @Override // cf.e
    public void a(List permissions) {
        Intrinsics.h(permissions, "permissions");
        this.f17227a.z(this);
    }

    @Override // cf.e
    public void request() {
        if (this.f17227a.K()) {
            if (ye.c.f79116a.c(this.f17227a.m())) {
                finish();
                return;
            }
            this.f17227a.getClass();
            o0 o0Var = this.f17227a;
            if (o0Var.f17287q != null) {
                o0Var.E(this);
                List q11 = CollectionsKt.q("android.permission.PICTURE_IN_PICTURE");
                o0 o0Var2 = this.f17227a;
                ze.b bVar = o0Var2.f17287q;
                if (bVar != null) {
                    Intrinsics.e(bVar);
                    bVar.a(b(), q11, true, true);
                    return;
                } else {
                    o0Var2.getClass();
                    Intrinsics.e(null);
                    b();
                    throw null;
                }
            }
        }
        finish();
    }
}
