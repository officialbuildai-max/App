package androidx.room.coroutines;

import androidx.room.RoomDatabase;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public abstract class FlowUtil {
    public static final kotlinx.coroutines.flow.b a(final RoomDatabase db2, final boolean z10, String[] tableNames, final Function1 block) {
        Intrinsics.h(db2, "db");
        Intrinsics.h(tableNames, "tableNames");
        Intrinsics.h(block, "block");
        final kotlinx.coroutines.flow.b j11 = kotlinx.coroutines.flow.d.j(db2.y().l((String[]) Arrays.copyOf(tableNames, tableNames.length), true));
        return new kotlinx.coroutines.flow.b() { // from class: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1

            /* renamed from: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2, reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements kotlinx.coroutines.flow.c {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ kotlinx.coroutines.flow.c f14692a;

                /* renamed from: b, reason: collision with root package name */
                final /* synthetic */ RoomDatabase f14693b;

                /* renamed from: c, reason: collision with root package name */
                final /* synthetic */ boolean f14694c;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Function1 f14695d;

                @Metadata(k = 3, mv = {2, 0, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
                @DebugMetadata(c = "androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2", f = "FlowBuilder.kt", l = {224, Sdk$SDKError.Reason.STALE_CACHED_RESPONSE_VALUE}, m = "emit")
                /* renamed from: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1, reason: invalid class name */
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

                public AnonymousClass2(kotlinx.coroutines.flow.c cVar, RoomDatabase roomDatabase, boolean z10, Function1 function1) {
                    this.f14692a = cVar;
                    this.f14693b = roomDatabase;
                    this.f14694c = z10;
                    this.f14695d = function1;
                }

                /* JADX WARN: Removed duplicated region for block: B:19:0x0062 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:20:0x003c  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
                @Override // kotlinx.coroutines.flow.c
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public final java.lang.Object emit(java.lang.Object r8, kotlin.coroutines.Continuation r9) {
                    /*
                        r7 = this;
                        boolean r0 = r9 instanceof androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r9
                        androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1 r0 = (androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.label = r1
                        goto L18
                    L13:
                        androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1 r0 = new androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1
                        r0.<init>(r9)
                    L18:
                        java.lang.Object r9 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L3c
                        if (r2 == r4) goto L34
                        if (r2 != r3) goto L2c
                        kotlin.ResultKt.b(r9)
                        goto L63
                    L2c:
                        java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                        java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                        r8.<init>(r9)
                        throw r8
                    L34:
                        java.lang.Object r8 = r0.L$0
                        kotlinx.coroutines.flow.c r8 = (kotlinx.coroutines.flow.c) r8
                        kotlin.ResultKt.b(r9)
                        goto L57
                    L3c:
                        kotlin.ResultKt.b(r9)
                        kotlinx.coroutines.flow.c r9 = r7.f14692a
                        java.util.Set r8 = (java.util.Set) r8
                        androidx.room.RoomDatabase r8 = r7.f14693b
                        boolean r2 = r7.f14694c
                        kotlin.jvm.functions.Function1 r5 = r7.f14695d
                        r0.L$0 = r9
                        r0.label = r4
                        java.lang.Object r8 = androidx.room.util.b.f(r8, r4, r2, r5, r0)
                        if (r8 != r1) goto L54
                        return r1
                    L54:
                        r6 = r9
                        r9 = r8
                        r8 = r6
                    L57:
                        r2 = 0
                        r0.L$0 = r2
                        r0.label = r3
                        java.lang.Object r8 = r8.emit(r9, r0)
                        if (r8 != r1) goto L63
                        return r1
                    L63:
                        kotlin.Unit r8 = kotlin.Unit.f67184a
                        return r8
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.b
            public Object a(kotlinx.coroutines.flow.c cVar, Continuation continuation) {
                Object a11 = kotlinx.coroutines.flow.b.this.a(new AnonymousClass2(cVar, db2, z10, block), continuation);
                return a11 == IntrinsicsKt.f() ? a11 : Unit.f67184a;
            }
        };
    }
}
