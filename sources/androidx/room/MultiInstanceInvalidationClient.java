package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.InvalidationTracker;
import androidx.room.i;
import androidx.room.j;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.x0;

/* loaded from: classes2.dex */
public final class MultiInstanceInvalidationClient {

    /* renamed from: a, reason: collision with root package name */
    private final String f14542a;

    /* renamed from: b, reason: collision with root package name */
    private final InvalidationTracker f14543b;

    /* renamed from: c, reason: collision with root package name */
    private final Context f14544c;

    /* renamed from: d, reason: collision with root package name */
    private final kotlinx.coroutines.n0 f14545d;

    /* renamed from: e, reason: collision with root package name */
    private final AtomicBoolean f14546e;

    /* renamed from: f, reason: collision with root package name */
    private int f14547f;

    /* renamed from: g, reason: collision with root package name */
    private j f14548g;

    /* renamed from: h, reason: collision with root package name */
    private final x0 f14549h;

    /* renamed from: i, reason: collision with root package name */
    private final a f14550i;

    /* renamed from: j, reason: collision with root package name */
    private final i f14551j;

    /* renamed from: k, reason: collision with root package name */
    private final ServiceConnection f14552k;

    /* loaded from: classes2.dex */
    public static final class a extends InvalidationTracker.b {
        a(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.InvalidationTracker.b
        public boolean b() {
            return true;
        }

        @Override // androidx.room.InvalidationTracker.b
        public void c(Set tables) {
            Intrinsics.h(tables, "tables");
            if (MultiInstanceInvalidationClient.this.f14546e.get()) {
                return;
            }
            try {
                j jVar = MultiInstanceInvalidationClient.this.f14548g;
                if (jVar != null) {
                    jVar.Z(MultiInstanceInvalidationClient.this.f14547f, (String[]) tables.toArray(new String[0]));
                }
            } catch (RemoteException e11) {
                Log.w("ROOM", "Cannot broadcast invalidation", e11);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements ServiceConnection {
        b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder service) {
            Intrinsics.h(name, "name");
            Intrinsics.h(service, "service");
            MultiInstanceInvalidationClient.this.f14548g = j.a.Y0(service);
            MultiInstanceInvalidationClient.this.j();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Intrinsics.h(name, "name");
            MultiInstanceInvalidationClient.this.f14548g = null;
        }
    }

    public MultiInstanceInvalidationClient(Context context, String name, InvalidationTracker invalidationTracker) {
        Intrinsics.h(context, "context");
        Intrinsics.h(name, "name");
        Intrinsics.h(invalidationTracker, "invalidationTracker");
        this.f14542a = name;
        this.f14543b = invalidationTracker;
        this.f14544c = context.getApplicationContext();
        this.f14545d = invalidationTracker.o().x();
        this.f14546e = new AtomicBoolean(true);
        this.f14549h = d1.a(0, 0, BufferOverflow.SUSPEND);
        this.f14550i = new a(invalidationTracker.p());
        this.f14551j = new i.a() { // from class: androidx.room.MultiInstanceInvalidationClient$invalidationCallback$1
            @Override // androidx.room.i
            public void n(String[] tables) {
                kotlinx.coroutines.n0 n0Var;
                Intrinsics.h(tables, "tables");
                n0Var = MultiInstanceInvalidationClient.this.f14545d;
                kotlinx.coroutines.k.d(n0Var, null, null, new MultiInstanceInvalidationClient$invalidationCallback$1$onInvalidation$1(tables, MultiInstanceInvalidationClient.this, null), 3, null);
            }
        };
        this.f14552k = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        try {
            j jVar = this.f14548g;
            if (jVar != null) {
                this.f14547f = jVar.r0(this.f14551j, this.f14542a);
            }
        } catch (RemoteException e11) {
            Log.w("ROOM", "Cannot register multi-instance invalidation callback", e11);
        }
    }

    public final kotlinx.coroutines.flow.b h(final String[] resolvedTableNames) {
        Intrinsics.h(resolvedTableNames, "resolvedTableNames");
        final x0 x0Var = this.f14549h;
        return new kotlinx.coroutines.flow.b() { // from class: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1

            /* renamed from: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2, reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements kotlinx.coroutines.flow.c {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.flow.c f14555a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ String[] f14556b;

                @Metadata(k = 3, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
                @DebugMetadata(c = "androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2", f = "MultiInstanceInvalidationClient.android.kt", l = {239}, m = "emit")
                /* renamed from: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1, reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(kotlinx.coroutines.flow.c cVar, String[] strArr) {
                    this.f14555a = cVar;
                    this.f14556b = strArr;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
                @Override // kotlinx.coroutines.flow.c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r11, kotlin.coroutines.Continuation r12) {
                    /*
                        r10 = this;
                        boolean r0 = r12 instanceof androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r12
                        androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1 r0 = (androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1 r0 = new androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1
                        r0.<init>(r12)
                    L18:
                        java.lang.Object r12 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.label
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r12)
                        goto L7c
                    L29:
                        java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                        java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                        r11.<init>(r12)
                        throw r11
                    L31:
                        kotlin.ResultKt.b(r12)
                        kotlinx.coroutines.flow.c r12 = r10.f14555a
                        java.util.Set r11 = (java.util.Set) r11
                        java.util.Set r2 = kotlin.collections.SetsKt.b()
                        java.lang.String[] r4 = r10.f14556b
                        int r5 = r4.length
                        r6 = 0
                    L40:
                        if (r6 >= r5) goto L64
                        r7 = r4[r6]
                        r8 = r11
                        java.lang.Iterable r8 = (java.lang.Iterable) r8
                        java.util.Iterator r8 = r8.iterator()
                    L4b:
                        boolean r9 = r8.hasNext()
                        if (r9 == 0) goto L61
                        java.lang.Object r9 = r8.next()
                        java.lang.String r9 = (java.lang.String) r9
                        boolean r9 = kotlin.text.StringsKt.H(r7, r9, r3)
                        if (r9 == 0) goto L4b
                        r2.add(r7)
                        goto L4b
                    L61:
                        int r6 = r6 + 1
                        goto L40
                    L64:
                        java.util.Set r11 = kotlin.collections.SetsKt.a(r2)
                        java.util.Collection r11 = (java.util.Collection) r11
                        boolean r2 = r11.isEmpty()
                        if (r2 == 0) goto L71
                        r11 = 0
                    L71:
                        if (r11 == 0) goto L7c
                        r0.label = r3
                        java.lang.Object r11 = r12.emit(r11, r0)
                        if (r11 != r1) goto L7c
                        return r1
                    L7c:
                        kotlin.Unit r11 = kotlin.Unit.f67184a
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.b
            public Object a(kotlinx.coroutines.flow.c cVar, Continuation continuation) {
                Object a11 = kotlinx.coroutines.flow.b.this.a(new AnonymousClass2(cVar, resolvedTableNames), continuation);
                return a11 == IntrinsicsKt.f() ? a11 : Unit.f67184a;
            }
        };
    }

    public final InvalidationTracker i() {
        return this.f14543b;
    }

    public final void k(Intent serviceIntent) {
        Intrinsics.h(serviceIntent, "serviceIntent");
        if (this.f14546e.compareAndSet(true, false)) {
            this.f14544c.bindService(serviceIntent, this.f14552k, 1);
            this.f14543b.j(this.f14550i);
        }
    }

    public final void l() {
        if (this.f14546e.compareAndSet(false, true)) {
            this.f14543b.z(this.f14550i);
            try {
                j jVar = this.f14548g;
                if (jVar != null) {
                    jVar.W0(this.f14551j, this.f14547f);
                }
            } catch (RemoteException e11) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e11);
            }
            this.f14544c.unbindService(this.f14552k);
        }
    }
}
