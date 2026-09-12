package androidx.work.impl.workers;

import androidx.work.t;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class ConstraintTrackingWorkerKt {

    /* renamed from: a */
    private static final String f16095a;

    static {
        String i11 = t.i("ConstraintTrkngWrkr");
        Intrinsics.g(i11, "tagWithPrefix(...)");
        f16095a = i11;
    }

    public static final /* synthetic */ String b() {
        return f16095a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(androidx.work.impl.constraints.WorkConstraintsTracker r4, androidx.work.impl.model.j0 r5, kotlin.coroutines.Continuation r6) {
        /*
            boolean r0 = r6 instanceof androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$1 r0 = (androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$1 r0 = new androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)
            goto L50
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r6)
            kotlinx.coroutines.flow.b r4 = r4.d(r5)
            androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2 r6 = new androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$2
            r2 = 0
            r6.<init>(r5, r2)
            kotlinx.coroutines.flow.b r4 = kotlinx.coroutines.flow.d.A(r4, r6)
            androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$$inlined$filterIsInstance$1 r5 = new androidx.work.impl.workers.ConstraintTrackingWorkerKt$awaitConstraintsNotMet$$inlined$filterIsInstance$1
            r5.<init>()
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.d.p(r5, r0)
            if (r6 != r1) goto L50
            return r1
        L50:
            androidx.work.impl.constraints.b$b r6 = (androidx.work.impl.constraints.b.C0142b) r6
            int r4 = r6.a()
            java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.d(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.workers.ConstraintTrackingWorkerKt.c(androidx.work.impl.constraints.WorkConstraintsTracker, androidx.work.impl.model.j0, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
