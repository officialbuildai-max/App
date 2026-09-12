package com.mbridge.msdk.dycreator.viewmodel;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.dycreator.binding.b;
import com.mbridge.msdk.dycreator.binding.response.SplashResData;
import com.mbridge.msdk.dycreator.bridge.MBSplashData;
import com.mbridge.msdk.dycreator.bus.EventBus;
import com.mbridge.msdk.dycreator.listener.action.EAction;
import com.mbridge.msdk.dycreator.viewobserver.c;
import com.mbridge.msdk.dycreator.viewobserver.d;
import com.mbridge.msdk.dycreator.viewobserver.f;
import com.mbridge.msdk.dycreator.viewobserver.h;
import com.mbridge.msdk.dycreator.wrapper.DyOption;
import com.mbridge.msdk.dycreator.wrapper.DynamicViewBackListener;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.k0;

/* loaded from: classes5.dex */
public class MBSplashViewVModel implements BaseViewModel {

    /* renamed from: a, reason: collision with root package name */
    private d f34966a;

    /* renamed from: b, reason: collision with root package name */
    private c f34967b;

    /* renamed from: c, reason: collision with root package name */
    private f f34968c;

    /* renamed from: d, reason: collision with root package name */
    private h f34969d;

    /* renamed from: e, reason: collision with root package name */
    private DynamicViewBackListener f34970e;

    /* renamed from: f, reason: collision with root package name */
    private DyOption f34971f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.dycreator.viewmodel.MBSplashViewVModel$1, reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f34972a;

        static {
            int[] iArr = new int[EAction.values().length];
            f34972a = iArr;
            try {
                iArr[EAction.DOWNLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f34972a[EAction.CLOSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public MBSplashViewVModel(DyOption dyOption) {
        this.f34971f = dyOption;
        String campaignUnitId = (dyOption == null || dyOption.getCampaignEx() == null) ? "" : dyOption.getCampaignEx().getCampaignUnitId();
        if (TextUtils.isEmpty(campaignUnitId)) {
            EventBus.getDefault().register(this);
        } else {
            EventBus.getDefault().register(campaignUnitId, this);
        }
    }

    private void a(SplashResData splashResData) {
        if (this.f34970e == null || splashResData == null) {
            return;
        }
        int i11 = AnonymousClass1.f34972a[splashResData.geteAction().ordinal()];
        if (i11 == 1 || i11 == 2) {
            b(splashResData);
        }
        this.f34970e.viewClicked(splashResData);
    }

    private void a(Object obj) {
        c cVar = this.f34967b;
        if (cVar != null) {
            cVar.a(obj);
        }
    }

    private void b(SplashResData splashResData) {
        try {
            String str = "";
            if (splashResData.getBaseViewData() != null && splashResData.getBaseViewData().getBindData() != null) {
                str = splashResData.getBaseViewData().getBindData().getCampaignUnitId();
            }
            if (TextUtils.isEmpty(str)) {
                EventBus.getDefault().unregister(this);
                b.a().b();
            } else {
                EventBus.getDefault().unregister(str);
                b.a().b();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            EventBus.getDefault().unregister(this);
            EventBus.getDefault().release();
            b.a().b();
        }
    }

    private void b(Object obj) {
        d dVar = this.f34966a;
        if (dVar != null) {
            dVar.a(obj);
        }
    }

    private void c(Object obj) {
        f fVar = this.f34968c;
        if (fVar != null) {
            fVar.a(obj);
        }
    }

    public void onEventMainThread(SplashResData splashResData) {
        a(splashResData);
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setClickSubject(c cVar) {
        if (cVar != null) {
            this.f34967b = cVar;
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setConcreteSubject(d dVar) {
        if (dVar != null) {
            this.f34966a = dVar;
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setDynamicViewBackListener(DynamicViewBackListener dynamicViewBackListener) {
        if (dynamicViewBackListener != null) {
            this.f34970e = dynamicViewBackListener;
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setEffectSubject(f fVar) {
        if (fVar != null) {
            this.f34968c = fVar;
        }
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setModelDataAndBind() {
        MBSplashData mBSplashData = new MBSplashData(this.f34971f);
        Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
        if (d11 != null) {
            DyOption dyOption = this.f34971f;
            if (dyOption != null) {
                CampaignEx campaignEx = dyOption.getCampaignEx();
                if (campaignEx != null) {
                    mBSplashData.setAdClickText(campaignEx.getAdCall());
                }
                mBSplashData.setCountDownText(d11.getResources().getString(g0.a(d11, this.f34971f.isCanSkip() ? "mbridge_splash_count_time_can_skip" : "mbridge_splash_count_time_can_skip_not", "string")));
            }
            mBSplashData.setNoticeImage(g0.a(d11, "mbridge_splash_notice", "drawable"));
            String p11 = k0.p(d11);
            mBSplashData.setLogoText((TextUtils.isEmpty(p11) || !p11.contains("zh")) ? "AD" : "广告");
        }
        b(mBSplashData);
        a(mBSplashData);
        c(mBSplashData);
    }

    @Override // com.mbridge.msdk.dycreator.viewmodel.BaseViewModel
    public void setReportSubject(h hVar) {
        if (hVar != null) {
            this.f34969d = hVar;
        }
    }
}
