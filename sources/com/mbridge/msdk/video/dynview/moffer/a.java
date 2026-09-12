package com.mbridge.msdk.video.dynview.moffer;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.video.dynview.listener.g;
import com.mbridge.msdk.video.module.MBridgeNativeEndCardView;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f39087c;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, SoftReference<MOfferModel>> f39088a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    private int f39089b = 500;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.video.dynview.moffer.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0558a implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewGroup f39090a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MOfferModel f39091b;

        C0558a(ViewGroup viewGroup, MOfferModel mOfferModel) {
            this.f39090a = viewGroup;
            this.f39091b = mOfferModel;
        }

        @Override // com.mbridge.msdk.video.dynview.listener.g
        public void a(int i11, String str) {
            o0.b("MOfferEnergize", str);
        }

        @Override // com.mbridge.msdk.video.dynview.listener.g
        public void a(ViewGroup viewGroup, CampaignUnit campaignUnit) {
            ViewGroup viewGroup2;
            if (viewGroup == null || (viewGroup2 = this.f39090a) == null) {
                return;
            }
            try {
                a.this.a(this.f39091b, viewGroup2, viewGroup, campaignUnit);
            } catch (Exception e11) {
                o0.b("MOfferEnergize", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MOfferModel f39093a;

        b(MOfferModel mOfferModel) {
            this.f39093a = mOfferModel;
        }

        @Override // java.lang.Runnable
        public void run() {
            MOfferModel mOfferModel = this.f39093a;
            if (mOfferModel != null) {
                mOfferModel.checkViewVisiableState();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MOfferModel f39095a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ViewGroup f39096b;

        c(MOfferModel mOfferModel, ViewGroup viewGroup) {
            this.f39095a = mOfferModel;
            this.f39096b = viewGroup;
        }

        @Override // com.mbridge.msdk.video.dynview.listener.g
        public void a(int i11, String str) {
        }

        @Override // com.mbridge.msdk.video.dynview.listener.g
        public void a(ViewGroup viewGroup, CampaignUnit campaignUnit) {
            if (viewGroup == null || campaignUnit == null) {
                return;
            }
            try {
                a.this.a(this.f39095a, this.f39096b, viewGroup, campaignUnit);
            } catch (Exception e11) {
                o0.b("MOfferEnergize", e11.getMessage());
            }
        }
    }

    private a() {
    }

    private int a(String str) {
        return g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), str, "id");
    }

    public static a a() {
        a aVar;
        if (f39087c != null) {
            return f39087c;
        }
        synchronized (a.class) {
            try {
                if (f39087c == null) {
                    f39087c = new a();
                }
                aVar = f39087c;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    private void a(ViewGroup viewGroup) {
        View findViewById;
        if (viewGroup != null && viewGroup.getBackground() == null) {
            try {
                Drawable drawable = com.mbridge.msdk.foundation.controller.c.m().d().getResources().getDrawable(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_more_offer_default_bg", "drawable"));
                if (drawable == null || (findViewById = viewGroup.findViewById(a("mbridge_moreoffer_hls"))) == null) {
                    return;
                }
                findViewById.setBackground(drawable);
            } catch (Exception e11) {
                o0.b("MOfferEnergize", e11.getMessage());
            }
        }
    }

    private void a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        try {
            if (viewGroup instanceof MBridgeNativeEndCardView) {
                RelativeLayout relativeLayout = ((MBridgeNativeEndCardView) viewGroup).isDyXmlSuccess() ? (RelativeLayout) viewGroup.findViewById(-1642631508) : (RelativeLayout) viewGroup.findViewById(a("mbridge_native_ec_layout"));
                ArrayList arrayList = new ArrayList();
                arrayList.add(relativeLayout);
                new com.mbridge.msdk.video.dynview.ui.b().a(arrayList, 0, t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 100.0f), this.f39089b);
            }
            RelativeLayout relativeLayout2 = (RelativeLayout) viewGroup.findViewById(a("mbridge_reward_moreoffer_layout"));
            if (relativeLayout2 == null) {
                relativeLayout2 = (RelativeLayout) viewGroup.findViewById(-82036151);
            }
            if (relativeLayout2 == null) {
                viewGroup.addView(viewGroup2);
            } else if (viewGroup.isShown()) {
                relativeLayout2.setVisibility(0);
                relativeLayout2.addView(viewGroup2);
            }
        } catch (Exception e11) {
            o0.b("MOfferEnergize", e11.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004b A[Catch: Exception -> 0x002e, TryCatch #0 {Exception -> 0x002e, blocks: (B:35:0x0003, B:37:0x0009, B:39:0x0013, B:41:0x0021, B:5:0x0034, B:7:0x0038, B:9:0x0041, B:10:0x0057, B:11:0x004b, B:12:0x0083, B:14:0x0087, B:16:0x0090, B:17:0x00d0, B:18:0x00f7, B:20:0x0106, B:32:0x00ac), top: B:34:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0087 A[Catch: Exception -> 0x002e, TryCatch #0 {Exception -> 0x002e, blocks: (B:35:0x0003, B:37:0x0009, B:39:0x0013, B:41:0x0021, B:5:0x0034, B:7:0x0038, B:9:0x0041, B:10:0x0057, B:11:0x004b, B:12:0x0083, B:14:0x0087, B:16:0x0090, B:17:0x00d0, B:18:0x00f7, B:20:0x0106, B:32:0x00ac), top: B:34:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0106 A[Catch: Exception -> 0x002e, TRY_LEAVE, TryCatch #0 {Exception -> 0x002e, blocks: (B:35:0x0003, B:37:0x0009, B:39:0x0013, B:41:0x0021, B:5:0x0034, B:7:0x0038, B:9:0x0041, B:10:0x0057, B:11:0x004b, B:12:0x0083, B:14:0x0087, B:16:0x0090, B:17:0x00d0, B:18:0x00f7, B:20:0x0106, B:32:0x00ac), top: B:34:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0041 A[Catch: Exception -> 0x002e, TryCatch #0 {Exception -> 0x002e, blocks: (B:35:0x0003, B:37:0x0009, B:39:0x0013, B:41:0x0021, B:5:0x0034, B:7:0x0038, B:9:0x0041, B:10:0x0057, B:11:0x004b, B:12:0x0083, B:14:0x0087, B:16:0x0090, B:17:0x00d0, B:18:0x00f7, B:20:0x0106, B:32:0x00ac), top: B:34:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a(com.mbridge.msdk.video.dynview.moffer.MOfferModel r8, android.view.ViewGroup r9, android.view.ViewGroup r10) {
        /*
            Method dump skipped, instructions count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.dynview.moffer.a.a(com.mbridge.msdk.video.dynview.moffer.MOfferModel, android.view.ViewGroup, android.view.ViewGroup):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(MOfferModel mOfferModel, ViewGroup viewGroup, ViewGroup viewGroup2, CampaignUnit campaignUnit) {
        if (mOfferModel == null || viewGroup == null || viewGroup2 == null || campaignUnit == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) viewGroup2.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        layoutParams.addRule(12, -1);
        int a11 = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 5.0f);
        layoutParams.setMargins(a11, a11, a11, a11);
        a(viewGroup2);
        viewGroup2.setLayoutParams(layoutParams);
        ViewGroup viewGroup3 = (ViewGroup) viewGroup2.getParent();
        if (viewGroup3 != null) {
            viewGroup3.removeAllViews();
        }
        if (mOfferModel.getECParentTemplateCode() == 1302) {
            a(mOfferModel, viewGroup, viewGroup2);
        } else {
            a(viewGroup, viewGroup2);
        }
        new com.mbridge.msdk.video.dynview.ui.b().a(viewGroup2, 0, t0.g(com.mbridge.msdk.foundation.controller.c.m().d()), 0, t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 100.0f), 0L);
        if (viewGroup instanceof MBridgeNativeEndCardView) {
            ((MBridgeNativeEndCardView) viewGroup).setMoreOfferCampaignUnit(campaignUnit);
        }
        viewGroup.postDelayed(new b(mOfferModel), this.f39089b + 500);
    }

    private void a(MOfferModel mOfferModel, ViewGroup viewGroup, com.mbridge.msdk.video.module.listener.a aVar) {
        if (mOfferModel == null) {
            return;
        }
        mOfferModel.setMoreOfferListener(new C0558a(viewGroup, mOfferModel), aVar);
        mOfferModel.showView();
    }

    public void a(ViewGroup viewGroup, String str, com.mbridge.msdk.video.module.listener.a aVar) {
        if (viewGroup == null || aVar == null || this.f39088a == null || TextUtils.isEmpty(str) || !this.f39088a.containsKey(str)) {
            return;
        }
        SoftReference<MOfferModel> softReference = this.f39088a.get(str);
        MOfferModel mOfferModel = (softReference == null || softReference.get() == null) ? null : softReference.get();
        if (mOfferModel == null) {
            return;
        }
        a(mOfferModel, viewGroup, aVar);
    }

    public void a(CampaignEx campaignEx, int i11) {
        if (campaignEx == null) {
            return;
        }
        String str = campaignEx.getRequestId() + "_" + campaignEx.getId();
        if (this.f39088a == null) {
            this.f39088a = new ConcurrentHashMap();
        }
        if (this.f39088a.containsKey(str)) {
            return;
        }
        try {
            MOfferModel mOfferModel = new MOfferModel();
            mOfferModel.setFromType(i11);
            SoftReference<MOfferModel> softReference = new SoftReference<>(mOfferModel);
            if (softReference.get() != null) {
                this.f39088a.put(str, softReference);
                softReference.get().buildMofferAd(campaignEx);
            }
        } catch (Exception e11) {
            o0.b("MOfferEnergize", e11.getMessage());
        }
    }

    public void a(CampaignEx campaignEx, ViewGroup viewGroup, com.mbridge.msdk.video.module.listener.a aVar, int i11) {
        if (campaignEx == null) {
            return;
        }
        String str = campaignEx.getRequestId() + "_" + campaignEx.getId();
        if (this.f39088a == null) {
            this.f39088a = new ConcurrentHashMap();
        }
        try {
            MOfferModel mOfferModel = new MOfferModel();
            mOfferModel.setFromType(i11);
            SoftReference<MOfferModel> softReference = new SoftReference<>(mOfferModel);
            if (softReference.get() != null) {
                this.f39088a.put(str, softReference);
                MOfferModel mOfferModel2 = softReference.get();
                mOfferModel2.setMoreOfferListener(new c(mOfferModel2, viewGroup), aVar);
                mOfferModel2.setIsRetry(true);
                mOfferModel2.buildMofferAd(campaignEx);
            }
        } catch (Exception e11) {
            o0.b("MOfferEnergize", e11.getMessage());
        }
    }

    public void b() {
        MOfferModel mOfferModel;
        try {
            Map<String, SoftReference<MOfferModel>> map = this.f39088a;
            if (map != null) {
                for (SoftReference<MOfferModel> softReference : map.values()) {
                    if (softReference != null && (mOfferModel = softReference.get()) != null) {
                        mOfferModel.mofDestroy();
                    }
                }
                this.f39088a.clear();
            }
        } catch (Exception e11) {
            o0.b("MOfferEnergize", e11.getMessage());
        }
    }

    public boolean b(String str) {
        if (this.f39088a == null || TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f39088a.containsKey(str);
    }
}
