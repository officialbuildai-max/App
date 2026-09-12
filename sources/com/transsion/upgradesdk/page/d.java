package com.transsion.upgradesdk.page;

import com.transsion.upgradesdk.bean.UpgradeData;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class d extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f56730a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(f fVar) {
        super(0);
        this.f56730a = fVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        UpgradeData upgradeData = this.f56730a.f56739h;
        if (upgradeData == null) {
            Intrinsics.z("upgradeData");
            upgradeData = null;
        }
        if (!upgradeData.isForceUpdate()) {
            this.f56730a.dismiss();
        }
        return Unit.f67184a;
    }
}
