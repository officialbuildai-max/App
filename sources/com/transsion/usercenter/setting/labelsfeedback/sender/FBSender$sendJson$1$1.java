package com.transsion.usercenter.setting.labelsfeedback.sender;

import android.app.Application;
import androidx.view.LiveData;
import androidx.work.ExistingWorkPolicy;
import androidx.work.WorkManager;
import androidx.work.v;
import androidx.work.w;
import com.transsion.usercenter.setting.labelsfeedback.sender.FBSender;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.usercenter.setting.labelsfeedback.sender.FBSender$sendJson$1$1", f = "FBSender.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes7.dex */
public final class FBSender$sendJson$1$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Application $application;
    final /* synthetic */ String $json;
    final /* synthetic */ LiveData $liveData;
    final /* synthetic */ FBSender.a $observer;
    final /* synthetic */ AtomicBoolean $schedulingFailureHandled;
    final /* synthetic */ v $senderWorker;
    final /* synthetic */ FBSender $this_runCatching;
    final /* synthetic */ WorkManager $workManager;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FBSender$sendJson$1$1(LiveData liveData, FBSender.a aVar, WorkManager workManager, v vVar, Application application, AtomicBoolean atomicBoolean, FBSender fBSender, String str, Continuation<? super FBSender$sendJson$1$1> continuation) {
        super(2, continuation);
        this.$liveData = liveData;
        this.$observer = aVar;
        this.$workManager = workManager;
        this.$senderWorker = vVar;
        this.$application = application;
        this.$schedulingFailureHandled = atomicBoolean;
        this.$this_runCatching = fBSender;
        this.$json = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(n0 n0Var, w wVar, LiveData liveData, FBSender.a aVar, AtomicBoolean atomicBoolean, FBSender fBSender, String str) {
        Object m1185constructorimpl;
        try {
            Result.Companion companion = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl((w.b.c) wVar.a().get());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            liveData.o(aVar);
            if (atomicBoolean.compareAndSet(false, true)) {
                fBSender.h(str, m1188exceptionOrNullimpl);
            }
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        FBSender$sendJson$1$1 fBSender$sendJson$1$1 = new FBSender$sendJson$1$1(this.$liveData, this.$observer, this.$workManager, this.$senderWorker, this.$application, this.$schedulingFailureHandled, this.$this_runCatching, this.$json, continuation);
        fBSender$sendJson$1$1.L$0 = obj;
        return fBSender$sendJson$1$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((FBSender$sendJson$1$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m1185constructorimpl;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        final n0 n0Var = (n0) this.L$0;
        final LiveData liveData = this.$liveData;
        final FBSender.a aVar = this.$observer;
        WorkManager workManager = this.$workManager;
        v vVar = this.$senderWorker;
        Application application = this.$application;
        final AtomicBoolean atomicBoolean = this.$schedulingFailureHandled;
        final FBSender fBSender = this.$this_runCatching;
        final String str = this.$json;
        try {
            Result.Companion companion = Result.INSTANCE;
            liveData.k(aVar);
            final w a11 = workManager.a("feedback work name", ExistingWorkPolicy.REPLACE, vVar).a();
            Intrinsics.g(a11, "enqueue(...)");
            a11.a().addListener(new Runnable() { // from class: com.transsion.usercenter.setting.labelsfeedback.sender.b
                @Override // java.lang.Runnable
                public final void run() {
                    FBSender$sendJson$1$1.d(n0.this, a11, liveData, aVar, atomicBoolean, fBSender, str);
                }
            }, androidx.core.content.b.getMainExecutor(application));
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        LiveData liveData2 = this.$liveData;
        FBSender.a aVar2 = this.$observer;
        AtomicBoolean atomicBoolean2 = this.$schedulingFailureHandled;
        FBSender fBSender2 = this.$this_runCatching;
        String str2 = this.$json;
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl != null) {
            liveData2.o(aVar2);
            if (atomicBoolean2.compareAndSet(false, true)) {
                fBSender2.h(str2, m1188exceptionOrNullimpl);
            }
        }
        return Unit.f67184a;
    }
}
