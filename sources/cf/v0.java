package cf;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class v0 extends d {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v0(o0 permissionBuilder) {
        super(permissionBuilder);
        Intrinsics.h(permissionBuilder, "permissionBuilder");
    }

    @Override // cf.e
    public void a(List permissions) {
        Intrinsics.h(permissions, "permissions");
        this.f17227a.x(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006b  */
    @Override // cf.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void request() {
        /*
            r5 = this;
            cf.o0 r0 = r5.f17227a
            boolean r0 = r0.J()
            if (r0 == 0) goto L76
            ye.c r0 = ye.c.f79116a
            cf.o0 r1 = r5.f17227a
            androidx.fragment.app.FragmentActivity r1 = r1.m()
            boolean r0 = r0.b(r1)
            if (r0 == 0) goto L1a
            r5.finish()
            return
        L1a:
            cf.o0 r0 = r5.f17227a
            r0.getClass()
            cf.o0 r0 = r5.f17227a
            ze.b r0 = r0.f17287q
            if (r0 == 0) goto L76
            com.tencent.mmkv.MMKV r0 = r5.d()
            r1 = 0
            java.lang.String r2 = "android.permission.POST_NOTIFICATIONS"
            boolean r0 = r0.getBoolean(r2, r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r3 = 33
            r4 = 1
            if (r1 < r3) goto L4b
            if (r0 == 0) goto L44
            cf.o0 r0 = r5.f17227a
            androidx.fragment.app.FragmentActivity r0 = r0.m()
            boolean r0 = androidx.core.app.ActivityCompat.j(r0, r2)
            goto L4c
        L44:
            com.tencent.mmkv.MMKV r0 = r5.d()
            r0.putBoolean(r2, r4)
        L4b:
            r0 = r4
        L4c:
            cf.o0 r1 = r5.f17227a
            r1.E(r5)
            java.lang.String[] r1 = new java.lang.String[]{r2}
            java.util.List r1 = kotlin.collections.CollectionsKt.q(r1)
            cf.o0 r2 = r5.f17227a
            ze.b r3 = r2.f17287q
            if (r3 == 0) goto L6b
            kotlin.jvm.internal.Intrinsics.e(r3)
            cf.f r2 = r5.b()
            r0 = r0 ^ r4
            r3.a(r2, r1, r4, r0)
            return
        L6b:
            r2.getClass()
            r0 = 0
            kotlin.jvm.internal.Intrinsics.e(r0)
            r5.b()
            throw r0
        L76:
            r5.finish()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cf.v0.request():void");
    }
}
