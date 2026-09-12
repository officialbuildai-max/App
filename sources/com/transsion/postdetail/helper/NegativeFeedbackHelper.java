package com.transsion.postdetail.helper;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.n0;

/* loaded from: classes6.dex */
public final class NegativeFeedbackHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final NegativeFeedbackHelper f48903a = new NegativeFeedbackHelper();

    /* renamed from: b, reason: collision with root package name */
    private static final String f48904b = "NegativeFeedbackHelper";

    /* renamed from: c, reason: collision with root package name */
    private static final Lazy f48905c = LazyKt.b(new Function0() { // from class: com.transsion.postdetail.helper.e
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            xo.b h11;
            h11 = NegativeFeedbackHelper.h();
            return h11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private static volatile String f48906d;

    /* renamed from: e, reason: collision with root package name */
    private static volatile String f48907e;

    private NegativeFeedbackHelper() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final xo.b g() {
        return (xo.b) f48905c.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final xo.b h() {
        return (xo.b) zg.c.f79537e.a().h(xo.b.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(String str, String str2, String str3, String str4, n0 n0Var, Function0 function0) {
        kotlinx.coroutines.k.d(n0Var, null, null, new NegativeFeedbackHelper$submitFeedback$1(str, str2, str3, str4, function0, null), 3, null);
    }

    public final String e() {
        String str = f48907e;
        f48907e = null;
        return str;
    }

    public final String f() {
        String str = f48906d;
        f48906d = null;
        return str;
    }

    public final void i(String str) {
        f48907e = str;
    }

    public final void j(String str) {
        f48906d = str;
    }

    public final void k(String postId, String str, Context context, n0 lifecycleScope, String pageName, Function0 function0) {
        Intrinsics.h(postId, "postId");
        Intrinsics.h(context, "context");
        Intrinsics.h(lifecycleScope, "lifecycleScope");
        Intrinsics.h(pageName, "pageName");
        kotlinx.coroutines.k.d(lifecycleScope, null, null, new NegativeFeedbackHelper$show$1(context, pageName, postId, str, lifecycleScope, function0, null), 3, null);
    }
}
