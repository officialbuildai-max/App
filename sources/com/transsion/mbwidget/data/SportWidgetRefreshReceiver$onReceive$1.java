package com.transsion.mbwidget.data;

import android.appwidget.AppWidgetManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import com.transsion.mbwidget.SportSchedulePreviewWidgetProvider;
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
import lg.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
@DebugMetadata(c = "com.transsion.mbwidget.data.SportWidgetRefreshReceiver$onReceive$1", f = "SportWidgetRefreshReceiver.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
/* loaded from: classes5.dex */
final class SportWidgetRefreshReceiver$onReceive$1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $ctx;
    final /* synthetic */ BroadcastReceiver.PendingResult $pendingResult;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/n0;", "", "<anonymous>", "(Lkotlinx/coroutines/n0;)V"}, k = 3, mv = {2, 1, 0})
    @DebugMetadata(c = "com.transsion.mbwidget.data.SportWidgetRefreshReceiver$onReceive$1$1", f = "SportWidgetRefreshReceiver.kt", l = {33}, m = "invokeSuspend")
    /* renamed from: com.transsion.mbwidget.data.SportWidgetRefreshReceiver$onReceive$1$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<n0, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object f11 = IntrinsicsKt.f();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                SportWidgetDataManager sportWidgetDataManager = SportWidgetDataManager.f46300a;
                this.label = 1;
                if (sportWidgetDataManager.g(this) == f11) {
                    return f11;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SportWidgetRefreshReceiver$onReceive$1(Context context, BroadcastReceiver.PendingResult pendingResult, Continuation<? super SportWidgetRefreshReceiver$onReceive$1> continuation) {
        super(2, continuation);
        this.$ctx = context;
        this.$pendingResult = pendingResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SportWidgetRefreshReceiver$onReceive$1(this.$ctx, this.$pendingResult, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(n0 n0Var, Continuation<? super Unit> continuation) {
        return ((SportWidgetRefreshReceiver$onReceive$1) create(n0Var, continuation)).invokeSuspend(Unit.f67184a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        try {
            try {
                a.C0856a c0856a = lg.a.f68962a;
                c0856a.c("SportWidget", "SportWidgetRefreshReceiver: alarm fired at " + System.currentTimeMillis(), true);
                kotlinx.coroutines.j.b(null, new AnonymousClass1(null), 1, null);
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this.$ctx);
                int[] appWidgetIds = appWidgetManager.getAppWidgetIds(new ComponentName(this.$ctx, (Class<?>) SportSchedulePreviewWidgetProvider.class));
                Intrinsics.e(appWidgetIds);
                if (appWidgetIds.length == 0) {
                    c0856a.c("SportWidget", "SportWidgetRefreshReceiver: no sport widget instance, skip", true);
                } else {
                    Context context = this.$ctx;
                    for (int i11 : appWidgetIds) {
                        SportSchedulePreviewWidgetProvider.Companion companion = SportSchedulePreviewWidgetProvider.INSTANCE;
                        Intrinsics.e(context);
                        Intrinsics.e(appWidgetManager);
                        companion.q(context, appWidgetManager, i11, true);
                    }
                    lg.a.f68962a.c("SportWidget", "SportWidgetRefreshReceiver: refreshed " + appWidgetIds.length + " sport widget(s)", true);
                }
            } catch (Exception e11) {
                a.C0856a c0856a2 = lg.a.f68962a;
                a.C0856a.k(c0856a2, "SportWidget", "SportWidgetRefreshReceiver error: " + e11.getMessage(), e11, false, 8, null);
                c0856a2.c("SportWidget", "SportWidgetRefreshReceiver FAILED: " + e11.getMessage(), true);
            }
            this.$pendingResult.finish();
            return Unit.f67184a;
        } catch (Throwable th2) {
            this.$pendingResult.finish();
            throw th2;
        }
    }
}
