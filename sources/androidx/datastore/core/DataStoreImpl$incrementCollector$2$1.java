package androidx.datastore.core;

import androidx.datastore.core.DataStoreImpl;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"T", "Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$incrementCollector$2$1", f = "DataStoreImpl.kt", l = {134, 135}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DataStoreImpl$incrementCollector$2$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ DataStoreImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class a implements kotlinx.coroutines.flow.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ DataStoreImpl f8661a;

        a(DataStoreImpl dataStoreImpl) {
            this.f8661a = dataStoreImpl;
        }

        /* JADX WARN: Code restructure failed: missing block: B:3:0x000e, code lost:
        
            r2 = r1.f8661a.w(true, r3);
         */
        @Override // kotlinx.coroutines.flow.c
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(kotlin.Unit r2, kotlin.coroutines.Continuation r3) {
            /*
                r1 = this;
                androidx.datastore.core.DataStoreImpl r2 = r1.f8661a
                androidx.datastore.core.h r2 = androidx.datastore.core.DataStoreImpl.d(r2)
                androidx.datastore.core.r r2 = r2.a()
                boolean r2 = r2 instanceof androidx.datastore.core.i
                if (r2 != 0) goto L1f
                androidx.datastore.core.DataStoreImpl r2 = r1.f8661a
                r0 = 1
                java.lang.Object r2 = androidx.datastore.core.DataStoreImpl.l(r2, r0, r3)
                java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                if (r2 != r3) goto L1c
                return r2
            L1c:
                kotlin.Unit r2 = kotlin.Unit.f67184a
                return r2
            L1f:
                kotlin.Unit r2 = kotlin.Unit.f67184a
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.core.DataStoreImpl$incrementCollector$2$1.a.emit(kotlin.Unit, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$incrementCollector$2$1(DataStoreImpl dataStoreImpl, Continuation<? super DataStoreImpl$incrementCollector$2$1> continuation) {
        super(2, continuation);
        this.this$0 = dataStoreImpl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DataStoreImpl$incrementCollector$2$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((DataStoreImpl$incrementCollector$2$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        DataStoreImpl.InitDataStore initDataStore;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            initDataStore = this.this$0.f8649i;
            this.label = 1;
            if (initDataStore.a(this) == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                return Unit.f67184a;
            }
            ResultKt.b(obj);
        }
        kotlinx.coroutines.flow.b j11 = kotlinx.coroutines.flow.d.j(this.this$0.r().c());
        a aVar = new a(this.this$0);
        this.label = 2;
        if (j11.a(aVar, this) == f11) {
            return f11;
        }
        return Unit.f67184a;
    }
}
