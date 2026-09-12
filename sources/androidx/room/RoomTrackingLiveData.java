package androidx.room;

import androidx.room.InvalidationTracker;
import androidx.room.RoomTrackingLiveData;
import androidx.view.LiveData;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class RoomTrackingLiveData extends LiveData {

    /* renamed from: l, reason: collision with root package name */
    private final RoomDatabase f14613l;

    /* renamed from: m, reason: collision with root package name */
    private final k f14614m;

    /* renamed from: n, reason: collision with root package name */
    private final boolean f14615n;

    /* renamed from: o, reason: collision with root package name */
    private final InvalidationTracker.b f14616o;

    /* renamed from: p, reason: collision with root package name */
    private final AtomicBoolean f14617p;

    /* renamed from: q, reason: collision with root package name */
    private final AtomicBoolean f14618q;

    /* renamed from: r, reason: collision with root package name */
    private final AtomicBoolean f14619r;

    /* renamed from: s, reason: collision with root package name */
    private final CoroutineContext f14620s;

    /* loaded from: classes2.dex */
    public static final class a extends InvalidationTracker.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RoomTrackingLiveData f14621b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(String[] strArr, RoomTrackingLiveData roomTrackingLiveData) {
            super(strArr);
            this.f14621b = roomTrackingLiveData;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(RoomTrackingLiveData roomTrackingLiveData) {
            roomTrackingLiveData.w();
        }

        @Override // androidx.room.InvalidationTracker.b
        public void c(Set tables) {
            Intrinsics.h(tables, "tables");
            j.c h11 = j.c.h();
            final RoomTrackingLiveData roomTrackingLiveData = this.f14621b;
            h11.b(new Runnable() { // from class: androidx.room.h0
                @Override // java.lang.Runnable
                public final void run() {
                    RoomTrackingLiveData.a.e(RoomTrackingLiveData.this);
                }
            });
        }
    }

    private RoomTrackingLiveData(RoomDatabase roomDatabase, k kVar, boolean z10, String[] strArr) {
        this.f14613l = roomDatabase;
        this.f14614m = kVar;
        this.f14615n = z10;
        this.f14616o = new a(strArr, this);
        this.f14617p = new AtomicBoolean(true);
        this.f14618q = new AtomicBoolean(false);
        this.f14619r = new AtomicBoolean(false);
        this.f14620s = roomDatabase.K() ? z10 ? roomDatabase.H() : roomDatabase.A() : EmptyCoroutineContext.INSTANCE;
    }

    public /* synthetic */ RoomTrackingLiveData(RoomDatabase roomDatabase, k kVar, boolean z10, String[] strArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(roomDatabase, kVar, z10, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w() {
        boolean h11 = h();
        if (this.f14617p.compareAndSet(false, true) && h11) {
            kotlinx.coroutines.k.d(this.f14613l.x(), this.f14620s, null, new RoomTrackingLiveData$invalidated$1(this, null), 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0069 A[Catch: all -> 0x0033, Exception -> 0x0035, TRY_ENTER, TRY_LEAVE, TryCatch #1 {Exception -> 0x0035, blocks: (B:12:0x002c, B:17:0x0069), top: B:11:0x002c, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0083 A[Catch: all -> 0x0033, TRY_LEAVE, TryCatch #0 {all -> 0x0033, blocks: (B:12:0x002c, B:15:0x0061, B:17:0x0069, B:26:0x0083, B:39:0x0079, B:40:0x0080), top: B:7:0x0022, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x005e -> B:14:0x0061). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0092 -> B:25:0x0094). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object x(kotlin.coroutines.Continuation r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof androidx.room.RoomTrackingLiveData$refresh$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.room.RoomTrackingLiveData$refresh$1 r0 = (androidx.room.RoomTrackingLiveData$refresh$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.room.RoomTrackingLiveData$refresh$1 r0 = new androidx.room.RoomTrackingLiveData$refresh$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L3f
            if (r2 != r4) goto L37
            int r2 = r0.I$0
            java.lang.Object r5 = r0.L$0
            androidx.room.RoomTrackingLiveData r5 = (androidx.room.RoomTrackingLiveData) r5
            kotlin.ResultKt.b(r9)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r7 = r2
            r2 = r9
            r9 = r7
            goto L61
        L33:
            r9 = move-exception
            goto L8c
        L35:
            r9 = move-exception
            goto L79
        L37:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3f:
            kotlin.ResultKt.b(r9)
            java.util.concurrent.atomic.AtomicBoolean r9 = r8.f14619r
            boolean r9 = r9.compareAndSet(r3, r4)
            if (r9 == 0) goto L55
            androidx.room.RoomDatabase r9 = r8.f14613l
            androidx.room.InvalidationTracker r9 = r9.y()
            androidx.room.InvalidationTracker$b r2 = r8.f14616o
            r9.k(r2)
        L55:
            r9 = r8
        L56:
            java.util.concurrent.atomic.AtomicBoolean r2 = r9.f14618q
            boolean r2 = r2.compareAndSet(r3, r4)
            if (r2 == 0) goto L92
            r2 = 0
            r5 = r9
            r9 = r3
        L61:
            java.util.concurrent.atomic.AtomicBoolean r6 = r5.f14617p     // Catch: java.lang.Throwable -> L33
            boolean r6 = r6.compareAndSet(r4, r3)     // Catch: java.lang.Throwable -> L33
            if (r6 == 0) goto L81
            r0.L$0 = r5     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r0.I$0 = r4     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            r0.label = r4     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            java.lang.Object r9 = r5.t(r0)     // Catch: java.lang.Throwable -> L33 java.lang.Exception -> L35
            if (r9 != r1) goto L76
            return r1
        L76:
            r2 = r9
            r9 = r4
            goto L61
        L79:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L33
            java.lang.String r1 = "Exception while computing database live data."
            r0.<init>(r1, r9)     // Catch: java.lang.Throwable -> L33
            throw r0     // Catch: java.lang.Throwable -> L33
        L81:
            if (r9 == 0) goto L86
            r5.n(r2)     // Catch: java.lang.Throwable -> L33
        L86:
            java.util.concurrent.atomic.AtomicBoolean r2 = r5.f14618q
            r2.set(r3)
            goto L94
        L8c:
            java.util.concurrent.atomic.AtomicBoolean r0 = r5.f14618q
            r0.set(r3)
            throw r9
        L92:
            r5 = r9
            r9 = r3
        L94:
            if (r9 == 0) goto La1
            java.util.concurrent.atomic.AtomicBoolean r9 = r5.f14617p
            boolean r9 = r9.get()
            if (r9 != 0) goto L9f
            goto La1
        L9f:
            r9 = r5
            goto L56
        La1:
            kotlin.Unit r9 = kotlin.Unit.f67184a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomTrackingLiveData.x(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.LiveData
    public void l() {
        super.l();
        this.f14614m.b(this);
        kotlinx.coroutines.k.d(this.f14613l.x(), this.f14620s, null, new RoomTrackingLiveData$onActive$1(this, null), 2, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.view.LiveData
    public void m() {
        super.m();
        this.f14614m.c(this);
    }

    public abstract Object t(Continuation continuation);

    /* JADX INFO: Access modifiers changed from: protected */
    public final RoomDatabase u() {
        return this.f14613l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean v() {
        return this.f14615n;
    }
}
