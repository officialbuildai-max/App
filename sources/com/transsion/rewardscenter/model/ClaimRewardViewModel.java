package com.transsion.rewardscenter.model;

import android.app.Application;
import androidx.view.b0;
import androidx.view.u0;
import com.transsion.rewardscenterapi.ClaimReceiverRequest;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class ClaimRewardViewModel extends androidx.view.b {

    /* renamed from: b, reason: collision with root package name */
    private final b0 f51006b;

    /* renamed from: c, reason: collision with root package name */
    private final b0 f51007c;

    /* renamed from: d, reason: collision with root package name */
    private final b0 f51008d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ClaimRewardViewModel(Application application) {
        super(application);
        Intrinsics.h(application, "application");
        this.f51006b = new b0(Boolean.FALSE);
        this.f51007c = new b0();
        this.f51008d = new b0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(String str) {
        if (str.length() != 0) {
            kotlinx.coroutines.k.d(u0.a(this), null, null, new ClaimRewardViewModel$claim$1(str, this, null), 3, null);
        } else {
            this.f51006b.n(Boolean.FALSE);
            this.f51007c.n(new Pair(null, null));
        }
    }

    public final b0 e() {
        return this.f51008d;
    }

    public final b0 f() {
        return this.f51007c;
    }

    public final b0 g() {
        return this.f51006b;
    }

    public final void h(ClaimReceiverRequest requestBody) {
        Intrinsics.h(requestBody, "requestBody");
        kotlinx.coroutines.k.d(u0.a(this), null, null, new ClaimRewardViewModel$submitAndClaim$1(this, requestBody, null), 3, null);
    }
}
