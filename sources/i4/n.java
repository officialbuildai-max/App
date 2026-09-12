package i4;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    private final Context f65086a;

    /* renamed from: b, reason: collision with root package name */
    private final g f65087b;

    /* renamed from: c, reason: collision with root package name */
    private final c f65088c;

    /* renamed from: d, reason: collision with root package name */
    private final g f65089d;

    /* renamed from: e, reason: collision with root package name */
    private final g f65090e;

    public n(Context context, j4.c taskExecutor, g batteryChargingTracker, c batteryNotLowTracker, g gVar, g storageNotLowTracker) {
        Intrinsics.h(context, "context");
        Intrinsics.h(taskExecutor, "taskExecutor");
        Intrinsics.h(batteryChargingTracker, "batteryChargingTracker");
        Intrinsics.h(batteryNotLowTracker, "batteryNotLowTracker");
        Intrinsics.h(storageNotLowTracker, "storageNotLowTracker");
        this.f65086a = context;
        this.f65087b = batteryChargingTracker;
        this.f65088c = batteryNotLowTracker;
        this.f65089d = gVar;
        this.f65090e = storageNotLowTracker;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ n(android.content.Context r8, j4.c r9, i4.g r10, i4.c r11, i4.g r12, i4.g r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r7 = this;
            r0 = r14 & 4
            java.lang.String r1 = "getApplicationContext(...)"
            if (r0 == 0) goto L14
            i4.a r0 = new i4.a
            android.content.Context r3 = r8.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.g(r3, r1)
            r0.<init>(r3, r9)
            r3 = r0
            goto L15
        L14:
            r3 = r10
        L15:
            r0 = r14 & 8
            if (r0 == 0) goto L27
            i4.c r0 = new i4.c
            android.content.Context r4 = r8.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.g(r4, r1)
            r0.<init>(r4, r9)
            r4 = r0
            goto L28
        L27:
            r4 = r11
        L28:
            r0 = r14 & 16
            if (r0 == 0) goto L41
            int r0 = android.os.Build.VERSION.SDK_INT
            r5 = 28
            if (r0 >= r5) goto L3e
            android.content.Context r0 = r8.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.g(r0, r1)
            i4.g r0 = i4.i.a(r0, r9)
            goto L3f
        L3e:
            r0 = 0
        L3f:
            r5 = r0
            goto L42
        L41:
            r5 = r12
        L42:
            r0 = r14 & 32
            if (r0 == 0) goto L54
            i4.l r0 = new i4.l
            android.content.Context r6 = r8.getApplicationContext()
            kotlin.jvm.internal.Intrinsics.g(r6, r1)
            r0.<init>(r6, r9)
            r6 = r0
            goto L55
        L54:
            r6 = r13
        L55:
            r0 = r7
            r1 = r8
            r2 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.n.<init>(android.content.Context, j4.c, i4.g, i4.c, i4.g, i4.g, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final g a() {
        return this.f65087b;
    }

    public final c b() {
        return this.f65088c;
    }

    public final Context c() {
        return this.f65086a;
    }

    public final g d() {
        return this.f65089d;
    }

    public final g e() {
        return this.f65090e;
    }
}
