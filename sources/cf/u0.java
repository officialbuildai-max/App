package cf;

import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class u0 extends d {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u0(o0 permissionBuilder) {
        super(permissionBuilder);
        Intrinsics.h(permissionBuilder, "permissionBuilder");
    }

    @Override // cf.e
    public void a(List permissions) {
        Intrinsics.h(permissions, "permissions");
        HashSet hashSet = new HashSet(this.f17227a.f17280j);
        hashSet.addAll(permissions);
        if (hashSet.isEmpty()) {
            finish();
        } else {
            this.f17227a.y(hashSet, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009c  */
    @Override // cf.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void request() {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            cf.o0 r1 = r5.f17227a
            java.util.Set r1 = r1.f17275e
            java.util.Iterator r1 = r1.iterator()
        Ld:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L33
            java.lang.Object r2 = r1.next()
            java.lang.String r2 = (java.lang.String) r2
            ye.c r3 = ye.c.f79116a
            cf.o0 r4 = r5.f17227a
            androidx.fragment.app.FragmentActivity r4 = r4.m()
            boolean r3 = r3.f(r4, r2)
            if (r3 == 0) goto L2f
            cf.o0 r3 = r5.f17227a
            java.util.Set r3 = r3.f17280j
            r3.add(r2)
            goto Ld
        L2f:
            r0.add(r2)
            goto Ld
        L33:
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L3d
            r5.finish()
            return
        L3d:
            cf.o0 r1 = r5.f17227a
            boolean r2 = r1.f17277g
            if (r2 == 0) goto La7
            r1.getClass()
            cf.o0 r1 = r5.f17227a
            ze.b r1 = r1.f17287q
            if (r1 == 0) goto La7
            int r1 = r0.size()
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L7b
            java.lang.Object r1 = r0.get(r2)
            java.lang.String r4 = "get(...)"
            kotlin.jvm.internal.Intrinsics.g(r1, r4)
            java.lang.String r1 = (java.lang.String) r1
            com.tencent.mmkv.MMKV r4 = r5.d()
            boolean r4 = r4.getBoolean(r1, r2)
            if (r4 == 0) goto L74
            cf.o0 r4 = r5.f17227a
            androidx.fragment.app.FragmentActivity r4 = r4.m()
            boolean r1 = androidx.core.app.ActivityCompat.j(r4, r1)
            goto L7c
        L74:
            com.tencent.mmkv.MMKV r4 = r5.d()
            r4.putBoolean(r1, r3)
        L7b:
            r1 = r3
        L7c:
            cf.o0 r4 = r5.f17227a
            r4.f17277g = r2
            java.util.Set r2 = r4.f17281k
            r2.addAll(r0)
            cf.o0 r2 = r5.f17227a
            r2.E(r5)
            cf.o0 r2 = r5.f17227a
            ze.b r4 = r2.f17287q
            if (r4 == 0) goto L9c
            kotlin.jvm.internal.Intrinsics.e(r4)
            cf.f r2 = r5.b()
            r1 = r1 ^ r3
            r4.a(r2, r0, r3, r1)
            goto Lae
        L9c:
            r2.getClass()
            r0 = 0
            kotlin.jvm.internal.Intrinsics.e(r0)
            r5.b()
            throw r0
        La7:
            cf.o0 r0 = r5.f17227a
            java.util.Set r1 = r0.f17275e
            r0.y(r1, r5)
        Lae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cf.u0.request():void");
    }
}
