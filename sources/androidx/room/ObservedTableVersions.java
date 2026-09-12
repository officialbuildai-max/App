package androidx.room;

import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.y0;

/* loaded from: classes2.dex */
public final class ObservedTableVersions {

    /* renamed from: a, reason: collision with root package name */
    private final y0 f14570a;

    public ObservedTableVersions(int i11) {
        this.f14570a = j1.a(new int[i11]);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(kotlinx.coroutines.flow.c r5, kotlin.coroutines.Continuation r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.room.ObservedTableVersions$collect$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.room.ObservedTableVersions$collect$1 r0 = (androidx.room.ObservedTableVersions$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.ObservedTableVersions$collect$1 r0 = new androidx.room.ObservedTableVersions$collect$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2d:
            kotlin.ResultKt.b(r6)
            goto L3f
        L31:
            kotlin.ResultKt.b(r6)
            kotlinx.coroutines.flow.y0 r6 = r4.f14570a
            r0.label = r3
            java.lang.Object r5 = r6.a(r5, r0)
            if (r5 != r1) goto L3f
            return r1
        L3f:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.ObservedTableVersions.a(kotlinx.coroutines.flow.c, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void b(Set tableIds) {
        Object value;
        int[] iArr;
        Intrinsics.h(tableIds, "tableIds");
        if (tableIds.isEmpty()) {
            return;
        }
        y0 y0Var = this.f14570a;
        do {
            value = y0Var.getValue();
            int[] iArr2 = (int[]) value;
            int length = iArr2.length;
            iArr = new int[length];
            for (int i11 = 0; i11 < length; i11++) {
                iArr[i11] = tableIds.contains(Integer.valueOf(i11)) ? iArr2[i11] + 1 : iArr2[i11];
            }
        } while (!y0Var.e(value, iArr));
    }
}
