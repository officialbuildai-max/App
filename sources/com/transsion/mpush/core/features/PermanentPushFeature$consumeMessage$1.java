package com.transsion.mpush.core.features;

import android.content.Context;
import com.transsion.mpush.api.PermanentPushMessage;
import com.transsion.mpush.core.db.PushDatabase;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.mpush.core.features.PermanentPushFeature$consumeMessage$1", f = "PermanentPushFeature.kt", l = {276}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes6.dex */
public final class PermanentPushFeature$consumeMessage$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $id;
    int label;
    final /* synthetic */ PermanentPushFeature this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermanentPushFeature$consumeMessage$1(PermanentPushFeature permanentPushFeature, String str, Continuation<? super PermanentPushFeature$consumeMessage$1> continuation) {
        super(2, continuation);
        this.this$0 = permanentPushFeature;
        this.$id = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PermanentPushFeature$consumeMessage$1(this.this$0, this.$id, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((PermanentPushFeature$consumeMessage$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        Context context;
        Object obj2;
        CopyOnWriteArrayList copyOnWriteArrayList2;
        Context context2;
        CopyOnWriteArrayList copyOnWriteArrayList3;
        int i11;
        Object k11;
        Object f11 = IntrinsicsKt.f();
        int i12 = this.label;
        if (i12 == 0) {
            ResultKt.b(obj);
            copyOnWriteArrayList = this.this$0.f47591f;
            String str = this.$id;
            Iterator it = copyOnWriteArrayList.iterator();
            while (true) {
                context = null;
                if (!it.hasNext()) {
                    obj2 = null;
                    break;
                }
                obj2 = it.next();
                if (Intrinsics.c(((PermanentPushMessage) obj2).getSubjectId(), str)) {
                    break;
                }
            }
            PermanentPushMessage permanentPushMessage = (PermanentPushMessage) obj2;
            if (permanentPushMessage != null) {
                copyOnWriteArrayList2 = this.this$0.f47591f;
                copyOnWriteArrayList2.remove(permanentPushMessage);
                PushDatabase.Companion companion = PushDatabase.INSTANCE;
                context2 = this.this$0.f47587b;
                if (context2 == null) {
                    Intrinsics.z("context");
                } else {
                    context = context2;
                }
                companion.b(context).k0().a(permanentPushMessage);
                copyOnWriteArrayList3 = this.this$0.f47591f;
                int size = copyOnWriteArrayList3.size();
                i11 = this.this$0.f47594i;
                if (size < i11) {
                    PermanentPushFeature permanentPushFeature = this.this$0;
                    this.label = 1;
                    k11 = permanentPushFeature.k(this);
                    if (k11 == f11) {
                        return f11;
                    }
                } else {
                    this.this$0.o();
                }
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f67184a;
    }
}
