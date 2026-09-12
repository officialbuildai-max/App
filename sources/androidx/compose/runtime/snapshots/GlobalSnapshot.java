package androidx.compose.runtime.snapshots;

import kotlin.KotlinNothingValueException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public final class GlobalSnapshot extends b {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public GlobalSnapshot(int r4, androidx.compose.runtime.snapshots.SnapshotIdSet r5) {
        /*
            r3 = this;
            java.lang.Object r0 = androidx.compose.runtime.snapshots.SnapshotKt.I()
            monitor-enter(r0)
            java.util.List r1 = androidx.compose.runtime.snapshots.SnapshotKt.h()     // Catch: java.lang.Throwable -> L17
            java.lang.Object r2 = kotlin.collections.CollectionsKt.G0(r1)     // Catch: java.lang.Throwable -> L17
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2     // Catch: java.lang.Throwable -> L17
            if (r2 != 0) goto L19
            androidx.compose.runtime.snapshots.GlobalSnapshot$1$1$1 r2 = new androidx.compose.runtime.snapshots.GlobalSnapshot$1$1$1     // Catch: java.lang.Throwable -> L17
            r2.<init>()     // Catch: java.lang.Throwable -> L17
            goto L19
        L17:
            r4 = move-exception
            goto L1f
        L19:
            monitor-exit(r0)
            r0 = 0
            r3.<init>(r4, r5, r0, r2)
            return
        L1f:
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.snapshots.GlobalSnapshot.<init>(int, androidx.compose.runtime.snapshots.SnapshotIdSet):void");
    }

    @Override // androidx.compose.runtime.snapshots.b
    public k C() {
        throw new IllegalStateException("Cannot apply the global snapshot directly. Call Snapshot.advanceGlobalSnapshot");
    }

    @Override // androidx.compose.runtime.snapshots.b
    public b Q(final Function1 function1, final Function1 function12) {
        j b02;
        b02 = SnapshotKt.b0(new Function1<SnapshotIdSet, b>() { // from class: androidx.compose.runtime.snapshots.GlobalSnapshot$takeNestedMutableSnapshot$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final b invoke(SnapshotIdSet snapshotIdSet) {
                int i11;
                synchronized (SnapshotKt.I()) {
                    i11 = SnapshotKt.f4001e;
                    SnapshotKt.f4001e = i11 + 1;
                }
                return new b(i11, snapshotIdSet, function1, function12);
            }
        });
        return (b) b02;
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public Void m(j jVar) {
        u.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public Void n(j jVar) {
        u.b();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public void d() {
        synchronized (SnapshotKt.I()) {
            q();
            Unit unit = Unit.f67184a;
        }
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public void o() {
        SnapshotKt.B();
    }

    @Override // androidx.compose.runtime.snapshots.b, androidx.compose.runtime.snapshots.j
    public j x(final Function1 function1) {
        j b02;
        b02 = SnapshotKt.b0(new Function1<SnapshotIdSet, g>() { // from class: androidx.compose.runtime.snapshots.GlobalSnapshot$takeNestedSnapshot$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final g invoke(SnapshotIdSet snapshotIdSet) {
                int i11;
                synchronized (SnapshotKt.I()) {
                    i11 = SnapshotKt.f4001e;
                    SnapshotKt.f4001e = i11 + 1;
                }
                return new g(i11, snapshotIdSet, function1);
            }
        });
        return b02;
    }
}
