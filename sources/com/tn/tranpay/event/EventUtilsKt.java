package com.tn.tranpay.event;

import androidx.annotation.Keep;
import androidx.view.Lifecycle;
import androidx.view.u;
import androidx.view.v;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.t1;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aM\u0010\u000b\u001a\u00020\n\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022'\u0010\t\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004¢\u0006\u0002\b\bH\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, d2 = {"T", "Landroidx/lifecycle/u;", "Landroidx/lifecycle/Lifecycle$State;", "minState", "Lkotlin/Function2;", "Lkotlinx/coroutines/n0;", "Lkotlin/coroutines/Continuation;", "", "Lkotlin/ExtensionFunctionType;", "block", "Lkotlinx/coroutines/t1;", "launchWhenStateAtLeast", "(Landroidx/lifecycle/u;Landroidx/lifecycle/Lifecycle$State;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/t1;", "lib_release"}, k = 2, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes4.dex */
public final class EventUtilsKt {
    @Keep
    public static final <T> t1 launchWhenStateAtLeast(u uVar, Lifecycle.State minState, Function2<? super n0, ? super Continuation<? super T>, ? extends Object> block) {
        t1 d11;
        Intrinsics.h(uVar, "<this>");
        Intrinsics.h(minState, "minState");
        Intrinsics.h(block, "block");
        d11 = k.d(v.a(uVar), null, null, new EventUtilsKt$launchWhenStateAtLeast$1(uVar, minState, block, null), 3, null);
        return d11;
    }
}
