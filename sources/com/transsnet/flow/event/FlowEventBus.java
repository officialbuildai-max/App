package com.transsnet.flow.event;

import androidx.annotation.Keep;
import androidx.view.Lifecycle;
import androidx.view.t0;
import androidx.view.u;
import androidx.view.u0;
import com.cloud.tmc.integration.event.EventConstants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.x0;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.k;
import kotlinx.coroutines.t1;

@Keep
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\u0011\u001a\u00020\u000f\"\b\b\u0000\u0010\f*\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012JS\u0010\u001a\u001a\u00020\u0019\"\b\b\u0000\u0010\f*\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u001a\u0010\u001bJ>\u0010\u001c\u001a\u00020\u000f\"\b\b\u0000\u0010\f*\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000f0\u000eH\u0086@¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010 \u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u001e¢\u0006\u0004\b \u0010!J\u0015\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\"\u0010#J\u0015\u0010$\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b$\u0010#J\u0015\u0010&\u001a\u00020%2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b&\u0010'R<\u0010*\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0(j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R<\u0010,\u001a*\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0(j\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b`)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010+¨\u0006-"}, d2 = {"Lcom/transsnet/flow/event/FlowEventBus;", "Landroidx/lifecycle/t0;", "<init>", "()V", "", EventConstants.KEY_EVENT_NAME, "", "isSticky", "Lkotlinx/coroutines/flow/x0;", "", "getEventFlow", "(Ljava/lang/String;Z)Lkotlinx/coroutines/flow/x0;", "T", AppMeasurementSdk.ConditionalUserProperty.VALUE, "Lkotlin/Function1;", "", "onReceived", "invokeReceived", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "Landroidx/lifecycle/u;", "lifecycleOwner", "Landroidx/lifecycle/Lifecycle$State;", "minState", "Lkotlinx/coroutines/i0;", "dispatcher", "Lkotlinx/coroutines/t1;", "observeEvent", "(Landroidx/lifecycle/u;Ljava/lang/String;Landroidx/lifecycle/Lifecycle$State;Lkotlinx/coroutines/i0;ZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/t1;", "observeWithoutLifecycle", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "timeMillis", "postEvent", "(Ljava/lang/String;Ljava/lang/Object;J)V", "removeStickEvent", "(Ljava/lang/String;)V", "clearStickEvent", "", "getEventObserverCount", "(Ljava/lang/String;)I", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "eventFlows", "Ljava/util/HashMap;", "stickyEventFlows", "FlowEvent_release"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
@SourceDebugExtension
/* loaded from: classes.dex */
public final class FlowEventBus extends t0 {
    private final HashMap<String, x0> eventFlows = new HashMap<>();
    private final HashMap<String, x0> stickyEventFlows = new HashMap<>();

    /* loaded from: classes7.dex */
    static final class a implements kotlinx.coroutines.flow.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1 f60372b;

        a(Function1 function1) {
            this.f60372b = function1;
        }

        @Override // kotlinx.coroutines.flow.c
        public final Object emit(Object obj, Continuation continuation) {
            FlowEventBus.this.invokeReceived(obj, this.f60372b);
            return Unit.f67184a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final x0 getEventFlow(String eventName, boolean isSticky) {
        x0 x0Var = isSticky ? this.stickyEventFlows.get(eventName) : this.eventFlows.get(eventName);
        if (x0Var == null) {
            x0Var = d1.b(isSticky ? 1 : 0, Integer.MAX_VALUE, null, 4, null);
            if (isSticky) {
                this.stickyEventFlows.put(eventName, x0Var);
            } else {
                this.eventFlows.put(eventName, x0Var);
            }
        }
        return x0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> void invokeReceived(Object value, Function1<? super T, Unit> onReceived) {
        c b11;
        c b12;
        try {
            Intrinsics.f(value, "null cannot be cast to non-null type T of com.transsnet.flow.event.FlowEventBus.invokeReceived");
            onReceived.invoke(value);
        } catch (ClassCastException e11) {
            String message = e11.getMessage();
            if (message == null || (b12 = b.f60377a.b()) == null) {
                return;
            }
            b12.log("class cast error on message received: " + value, message);
        } catch (Exception e12) {
            String message2 = e12.getMessage();
            if (message2 == null || (b11 = b.f60377a.b()) == null) {
                return;
            }
            b11.log("error on message received: " + value, message2);
        }
    }

    public final void clearStickEvent(String eventName) {
        Intrinsics.h(eventName, "eventName");
        x0 x0Var = this.stickyEventFlows.get(eventName);
        if (x0Var != null) {
            x0Var.f();
        }
    }

    public final int getEventObserverCount(String eventName) {
        i1 c11;
        i1 c12;
        Intrinsics.h(eventName, "eventName");
        x0 x0Var = this.stickyEventFlows.get(eventName);
        int i11 = 0;
        int intValue = (x0Var == null || (c12 = x0Var.c()) == null) ? 0 : ((Number) c12.getValue()).intValue();
        x0 x0Var2 = this.eventFlows.get(eventName);
        if (x0Var2 != null && (c11 = x0Var2.c()) != null) {
            i11 = ((Number) c11.getValue()).intValue();
        }
        return intValue + i11;
    }

    public final <T> t1 observeEvent(u lifecycleOwner, String eventName, Lifecycle.State minState, i0 dispatcher, boolean isSticky, Function1<? super T, Unit> onReceived) {
        Intrinsics.h(lifecycleOwner, "lifecycleOwner");
        Intrinsics.h(eventName, "eventName");
        Intrinsics.h(minState, "minState");
        Intrinsics.h(dispatcher, "dispatcher");
        Intrinsics.h(onReceived, "onReceived");
        return EventUtilsKt.launchWhenStateAtLeast(lifecycleOwner, minState, new FlowEventBus$observeEvent$1(this, eventName, isSticky, dispatcher, onReceived, null));
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object observeWithoutLifecycle(java.lang.String r5, boolean r6, kotlin.jvm.functions.Function1<? super T, kotlin.Unit> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r4 = this;
            boolean r0 = r8 instanceof com.transsnet.flow.event.FlowEventBus$observeWithoutLifecycle$1
            if (r0 == 0) goto L13
            r0 = r8
            com.transsnet.flow.event.FlowEventBus$observeWithoutLifecycle$1 r0 = (com.transsnet.flow.event.FlowEventBus$observeWithoutLifecycle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsnet.flow.event.FlowEventBus$observeWithoutLifecycle$1 r0 = new com.transsnet.flow.event.FlowEventBus$observeWithoutLifecycle$1
            r0.<init>(r4, r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L2d:
            kotlin.ResultKt.b(r8)
            goto L46
        L31:
            kotlin.ResultKt.b(r8)
            kotlinx.coroutines.flow.x0 r5 = r4.getEventFlow(r5, r6)
            com.transsnet.flow.event.FlowEventBus$a r6 = new com.transsnet.flow.event.FlowEventBus$a
            r6.<init>(r7)
            r0.label = r3
            java.lang.Object r5 = r5.a(r6, r0)
            if (r5 != r1) goto L46
            return r1
        L46:
            kotlin.KotlinNothingValueException r5 = new kotlin.KotlinNothingValueException
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.flow.event.FlowEventBus.observeWithoutLifecycle(java.lang.String, boolean, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void postEvent(String eventName, Object value, long timeMillis) {
        Intrinsics.h(eventName, "eventName");
        Intrinsics.h(value, "value");
        c b11 = b.f60377a.b();
        if (b11 != null) {
            b11.log("post Event:" + eventName);
        }
        Iterator it = CollectionsKt.p(getEventFlow(eventName, false), getEventFlow(eventName, true)).iterator();
        while (it.hasNext()) {
            k.d(u0.a(this), null, null, new FlowEventBus$postEvent$1$1(timeMillis, (x0) it.next(), value, null), 3, null);
        }
    }

    public final void removeStickEvent(String eventName) {
        Intrinsics.h(eventName, "eventName");
        this.stickyEventFlows.remove(eventName);
    }
}
