package com.transsion.upgradesdk.page;

import com.transsion.upgradesdk.bean.UpgradeData;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes6.dex */
public final class j extends Lambda implements Function0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ aw.i f56748a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(aw.i iVar) {
        super(0);
        this.f56748a = iVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        UpgradeData upgradeData = this.f56748a.f16247h;
        if (upgradeData == null) {
            Intrinsics.z("upgradeData");
            upgradeData = null;
        }
        if (!upgradeData.isForceUpdate()) {
            this.f56748a.dismiss();
        }
        return Unit.f67184a;
    }
}
