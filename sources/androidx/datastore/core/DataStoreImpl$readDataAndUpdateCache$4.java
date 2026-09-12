package androidx.datastore.core;

import com.vungle.ads.internal.protos.Sdk$SDKError;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0004\u0012\u00020\u00010\u0003\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "", "locked", "Lkotlin/Pair;", "Landroidx/datastore/core/r;", "<anonymous>", "(Z)Lkotlin/Pair;"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.datastore.core.DataStoreImpl$readDataAndUpdateCache$4", f = "DataStoreImpl.kt", l = {306, Sdk$SDKError.Reason.ASSET_FAILED_TO_DELETE_VALUE}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class DataStoreImpl$readDataAndUpdateCache$4 extends SuspendLambda implements Function2<Boolean, Continuation<? super Pair<? extends r, ? extends Boolean>>, Object> {
    final /* synthetic */ int $cachedVersion;
    Object L$0;
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ DataStoreImpl this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataStoreImpl$readDataAndUpdateCache$4(DataStoreImpl dataStoreImpl, int i11, Continuation<? super DataStoreImpl$readDataAndUpdateCache$4> continuation) {
        super(2, continuation);
        this.this$0 = dataStoreImpl;
        this.$cachedVersion = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        DataStoreImpl$readDataAndUpdateCache$4 dataStoreImpl$readDataAndUpdateCache$4 = new DataStoreImpl$readDataAndUpdateCache$4(this.this$0, this.$cachedVersion, continuation);
        dataStoreImpl$readDataAndUpdateCache$4.Z$0 = ((Boolean) obj).booleanValue();
        return dataStoreImpl$readDataAndUpdateCache$4;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Boolean) obj).booleanValue(), (Continuation<? super Pair<? extends r, Boolean>>) obj2);
    }

    public final Object invoke(boolean z10, Continuation<? super Pair<? extends r, Boolean>> continuation) {
        return ((DataStoreImpl$readDataAndUpdateCache$4) create(Boolean.valueOf(z10), continuation)).invokeSuspend(Unit.f67184a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Throwable th2;
        int i11;
        boolean z10;
        r rVar;
        boolean z11;
        Object f11 = IntrinsicsKt.f();
        boolean z12 = this.label;
        try {
        } catch (Throwable th3) {
            if (z12 != 0) {
                k r11 = this.this$0.r();
                this.L$0 = th3;
                this.Z$0 = z12;
                this.label = 2;
                Object a11 = r11.a(this);
                if (a11 == f11) {
                    return f11;
                }
                z10 = z12;
                th2 = th3;
                obj = a11;
            } else {
                boolean z13 = z12;
                th2 = th3;
                i11 = this.$cachedVersion;
                z10 = z13;
            }
        }
        if (z12 == 0) {
            ResultKt.b(obj);
            boolean z14 = this.Z$0;
            DataStoreImpl dataStoreImpl = this.this$0;
            this.Z$0 = z14;
            this.label = 1;
            obj = dataStoreImpl.y(z14, this);
            z12 = z14;
            if (obj == f11) {
                return f11;
            }
        } else {
            if (z12 != 1) {
                if (z12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                z10 = this.Z$0;
                th2 = (Throwable) this.L$0;
                ResultKt.b(obj);
                i11 = ((Number) obj).intValue();
                o oVar = new o(th2, i11);
                z11 = z10;
                rVar = oVar;
                return TuplesKt.a(rVar, Boxing.a(z11));
            }
            boolean z15 = this.Z$0;
            ResultKt.b(obj);
            z12 = z15;
        }
        rVar = (r) obj;
        z11 = z12;
        return TuplesKt.a(rVar, Boxing.a(z11));
    }
}
