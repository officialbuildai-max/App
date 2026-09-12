package androidx.datastore.core;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u008a@"}, d2 = {"<anonymous>", "", "T"}, k = 3, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$readDataOrHandleCorruption$3", f = "DataStoreImpl.kt", l = {387, 388, 390}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DataStoreImpl$readDataOrHandleCorruption$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<Object> $newData;
    final /* synthetic */ Ref.IntRef $version;
    Object L$0;
    int label;
    final /* synthetic */ DataStoreImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readDataOrHandleCorruption$3(Ref.ObjectRef<Object> objectRef, DataStoreImpl dataStoreImpl, Ref.IntRef intRef, Continuation<? super DataStoreImpl$readDataOrHandleCorruption$3> continuation) {
        super(1, continuation);
        this.$newData = objectRef;
        this.this$0 = dataStoreImpl;
        this.$version = intRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new DataStoreImpl$readDataOrHandleCorruption$3(this.$newData, this.this$0, this.$version, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((DataStoreImpl$readDataOrHandleCorruption$3) create(continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Ref.IntRef intRef;
        Object obj2;
        Ref.ObjectRef<Object> objectRef;
        Object x10;
        T t11;
        Ref.IntRef intRef2;
        Object obj3;
        Object f11 = IntrinsicsKt.f();
        int i11 = this.label;
        try {
        } catch (CorruptionException unused) {
            Ref.IntRef intRef3 = this.$version;
            DataStoreImpl dataStoreImpl = this.this$0;
            Object obj4 = this.$newData.element;
            this.L$0 = intRef3;
            this.label = 3;
            Object B = dataStoreImpl.B(obj4, true, this);
            if (B == f11) {
                return f11;
            }
            intRef = intRef3;
            obj2 = B;
        }
        if (i11 == 0) {
            ResultKt.b(obj);
            objectRef = this.$newData;
            DataStoreImpl dataStoreImpl2 = this.this$0;
            this.L$0 = objectRef;
            this.label = 1;
            x10 = dataStoreImpl2.x(this);
            t11 = x10;
            if (x10 == f11) {
                return f11;
            }
        } else {
            if (i11 != 1) {
                if (i11 == 2) {
                    intRef2 = (Ref.IntRef) this.L$0;
                    ResultKt.b(obj);
                    obj3 = obj;
                    intRef2.element = ((Number) obj3).intValue();
                    return Unit.f67184a;
                }
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                intRef = (Ref.IntRef) this.L$0;
                ResultKt.b(obj);
                obj2 = obj;
                intRef.element = ((Number) obj2).intValue();
                return Unit.f67184a;
            }
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.b(obj);
            t11 = obj;
        }
        objectRef.element = t11;
        intRef2 = this.$version;
        k r11 = this.this$0.r();
        this.L$0 = intRef2;
        this.label = 2;
        Object a11 = r11.a(this);
        obj3 = a11;
        if (a11 == f11) {
            return f11;
        }
        intRef2.element = ((Number) obj3).intValue();
        return Unit.f67184a;
    }
}
