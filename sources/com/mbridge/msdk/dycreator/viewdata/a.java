package com.mbridge.msdk.dycreator.viewdata;

import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* loaded from: classes5.dex */
public class a implements com.mbridge.msdk.dycreator.viewdata.base.a {

    /* renamed from: a, reason: collision with root package name */
    private DyOption f34953a;

    /* renamed from: b, reason: collision with root package name */
    private CampaignEx f34954b;

    public a(DyOption dyOption) {
        this.f34953a = dyOption;
        this.f34954b = dyOption.getCampaignEx();
    }

    @Override // com.mbridge.msdk.dycreator.viewdata.base.a
    public CampaignEx getBindData() {
        return this.f34954b;
    }

    @Override // com.mbridge.msdk.dycreator.viewdata.base.a
    public DyOption getEffectData() {
        return this.f34953a;
    }
}
