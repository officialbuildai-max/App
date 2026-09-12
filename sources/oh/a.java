package oh;

import android.graphics.Bitmap;

/* loaded from: classes4.dex */
public abstract class a {
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final int a(android.graphics.Bitmap r17, int r18, int r19) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.String r3 = "bitmap"
            kotlin.jvm.internal.Intrinsics.h(r0, r3)
            r3 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            kotlin.Result$Companion r4 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L81
            int r4 = r17.getWidth()     // Catch: java.lang.Throwable -> L81
            int r5 = r17.getHeight()     // Catch: java.lang.Throwable -> L81
            if (r4 <= 0) goto L8e
            if (r5 <= 0) goto L8e
            if (r1 < r2) goto L1f
            goto L8e
        L1f:
            r6 = 0
            int r1 = kotlin.ranges.RangesKt.f(r1, r6)     // Catch: java.lang.Throwable -> L81
            int r2 = kotlin.ranges.RangesKt.i(r2, r5)     // Catch: java.lang.Throwable -> L81
            kotlin.ranges.IntRange r1 = kotlin.ranges.RangesKt.t(r1, r2)     // Catch: java.lang.Throwable -> L81
            r2 = 10
            kotlin.ranges.IntProgression r1 = kotlin.ranges.RangesKt.s(r1, r2)     // Catch: java.lang.Throwable -> L81
            int r5 = r1.getFirst()     // Catch: java.lang.Throwable -> L81
            int r7 = r1.getLast()     // Catch: java.lang.Throwable -> L81
            int r1 = r1.getStep()     // Catch: java.lang.Throwable -> L81
            if (r1 <= 0) goto L42
            if (r5 <= r7) goto L46
        L42:
            if (r1 >= 0) goto L89
            if (r7 > r5) goto L89
        L46:
            r8 = r6
            r9 = r8
            r10 = r9
            r11 = r10
        L4a:
            kotlin.ranges.IntRange r12 = kotlin.ranges.RangesKt.t(r6, r4)     // Catch: java.lang.Throwable -> L81
            kotlin.ranges.IntProgression r12 = kotlin.ranges.RangesKt.s(r12, r2)     // Catch: java.lang.Throwable -> L81
            int r13 = r12.getFirst()     // Catch: java.lang.Throwable -> L81
            int r14 = r12.getLast()     // Catch: java.lang.Throwable -> L81
            int r12 = r12.getStep()     // Catch: java.lang.Throwable -> L81
            if (r12 <= 0) goto L62
            if (r13 <= r14) goto L66
        L62:
            if (r12 >= 0) goto L83
            if (r14 > r13) goto L83
        L66:
            int r15 = r0.getPixel(r13, r5)     // Catch: java.lang.Throwable -> L81
            int r16 = android.graphics.Color.red(r15)     // Catch: java.lang.Throwable -> L81
            int r8 = r8 + r16
            int r16 = android.graphics.Color.green(r15)     // Catch: java.lang.Throwable -> L81
            int r9 = r9 + r16
            int r15 = android.graphics.Color.blue(r15)     // Catch: java.lang.Throwable -> L81
            int r10 = r10 + r15
            int r11 = r11 + 1
            if (r13 == r14) goto L83
            int r13 = r13 + r12
            goto L66
        L81:
            r0 = move-exception
            goto La0
        L83:
            if (r5 == r7) goto L87
            int r5 = r5 + r1
            goto L4a
        L87:
            r6 = r11
            goto L8c
        L89:
            r8 = r6
            r9 = r8
            r10 = r9
        L8c:
            if (r6 != 0) goto L90
        L8e:
            r0 = r3
            goto L97
        L90:
            int r8 = r8 / r6
            int r9 = r9 / r6
            int r10 = r10 / r6
            int r0 = android.graphics.Color.rgb(r8, r9, r10)     // Catch: java.lang.Throwable -> L81
        L97:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: java.lang.Throwable -> L81
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)     // Catch: java.lang.Throwable -> L81
            goto Laa
        La0:
            kotlin.Result$Companion r1 = kotlin.Result.INSTANCE
            java.lang.Object r0 = kotlin.ResultKt.a(r0)
            java.lang.Object r0 = kotlin.Result.m1185constructorimpl(r0)
        Laa:
            java.lang.Throwable r1 = kotlin.Result.m1188exceptionOrNullimpl(r0)
            if (r1 != 0) goto Lb1
            goto Lb5
        Lb1:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)
        Lb5:
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: oh.a.a(android.graphics.Bitmap, int, int):int");
    }

    public static /* synthetic */ int b(Bitmap bitmap, int i11, int i12, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = bitmap.getHeight();
        }
        return a(bitmap, i11, i12);
    }
}
