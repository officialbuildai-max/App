package com.mbridge.msdk.splash.manager;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.dycreator.bridge.MBSplashData;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.splash.view.MBSplashNativeView;
import com.mbridge.msdk.splash.view.MBSplashView;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: com.mbridge.msdk.splash.manager.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class C0541a implements com.mbridge.msdk.foundation.feedback.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.splash.middle.a f37466a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f37467b;

        C0541a(com.mbridge.msdk.splash.middle.a aVar, int i11) {
            this.f37466a = aVar;
            this.f37467b = i11;
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
            this.f37466a.a(2, this.f37467b);
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
            this.f37466a.a(2, this.f37467b);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(Context context, MBSplashView mBSplashView, com.mbridge.msdk.splash.common.c cVar, com.mbridge.msdk.splash.inter.a aVar) {
        try {
            MBSplashNativeView mBSplashNativeView = new MBSplashNativeView(context, mBSplashView, cVar);
            if (aVar != null) {
                aVar.a(mBSplashNativeView);
            }
        } catch (Throwable unused) {
            if (aVar != null) {
                aVar.onError("View render error.");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.mbridge.msdk.dycreator.viewdata.base.a aVar, com.mbridge.msdk.splash.middle.a aVar2, CampaignEx campaignEx) {
        float f11;
        int i11;
        float f12;
        if (aVar == null || !(aVar instanceof MBSplashData)) {
            f11 = 0.0f;
            i11 = 0;
            f12 = 0.0f;
        } else {
            MBSplashData mBSplashData = (MBSplashData) aVar;
            f11 = mBSplashData.getxInScreen();
            f12 = mBSplashData.getyInScreen();
            i11 = mBSplashData.getClickType();
        }
        if (aVar2 != null) {
            try {
                aVar2.a(com.mbridge.msdk.splash.common.util.a.a(com.mbridge.msdk.splash.common.util.a.a(i11, f11, f12), campaignEx));
            } catch (Throwable th2) {
                th2.printStackTrace();
                aVar2.a(campaignEx);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(com.mbridge.msdk.splash.middle.a aVar, CampaignEx campaignEx, com.mbridge.msdk.dycreator.viewdata.base.a aVar2) {
        if (campaignEx != null) {
            String campaignUnitId = campaignEx.getCampaignUnitId();
            String requestId = campaignEx.getRequestId();
            int currentCountDown = aVar2 != null ? aVar2.getEffectData().getCurrentCountDown() : 0;
            aVar.a(1, currentCountDown);
            com.mbridge.msdk.foundation.feedback.bean.a b11 = com.mbridge.msdk.foundation.feedback.b.b().b(campaignUnitId + "_" + requestId);
            if (b11 != null) {
                b11.a(campaignEx);
                com.mbridge.msdk.foundation.feedback.b.b().a(campaignUnitId + "_" + requestId, new C0541a(aVar, currentCountDown));
                b11.p();
            }
        }
    }

    public void a(MBSplashView mBSplashView, com.mbridge.msdk.splash.common.c cVar, com.mbridge.msdk.splash.inter.a aVar) {
        Context context = mBSplashView.getContext();
        if (context == null) {
            context = com.mbridge.msdk.foundation.controller.c.m().d();
        }
        if (cVar == null && aVar != null) {
            aVar.onError("The render parameters is unavailable.");
            return;
        }
        String a11 = (cVar == null || cVar.b() == null) ? "" : x.a(cVar.b().getAdZip());
        if (TextUtils.isEmpty(a11)) {
            a(context, mBSplashView, cVar, aVar);
            return;
        }
        if (cVar == null || cVar.b() == null) {
            return;
        }
        if (TextUtils.isEmpty(cVar.b().getAdZip())) {
            a(context, mBSplashView, cVar, aVar);
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            arrayList.add(a11);
            a(arrayList, mBSplashView, cVar, aVar);
        } catch (Exception unused) {
            a(context, mBSplashView, cVar, aVar);
        }
    }

    protected void a(List<String> list, MBSplashView mBSplashView, com.mbridge.msdk.splash.common.c cVar, com.mbridge.msdk.splash.inter.a aVar) {
        throw null;
    }
}
