package com.mbridge.msdk.dycreator.binding.response;

import com.mbridge.msdk.dycreator.binding.response.base.BaseRespData;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.dycreator.viewdata.base.a;

/* loaded from: classes5.dex */
public class SplashResData extends BaseRespData {

    /* renamed from: a, reason: collision with root package name */
    private a f34815a;

    /* renamed from: b, reason: collision with root package name */
    private EAction f34816b;

    public a getBaseViewData() {
        return this.f34815a;
    }

    public EAction geteAction() {
        return this.f34816b;
    }

    public void setBaseViewData(a aVar) {
        this.f34815a = aVar;
    }

    public void seteAction(EAction eAction) {
        this.f34816b = eAction;
    }
}
