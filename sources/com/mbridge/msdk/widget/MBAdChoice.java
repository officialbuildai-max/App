package com.mbridge.msdk.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.image.c;
import com.mbridge.msdk.foundation.same.net.utils.d;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.setting.g;
import com.mbridge.msdk.setting.h;

/* loaded from: classes5.dex */
public class MBAdChoice extends MBImageView {

    /* renamed from: c, reason: collision with root package name */
    private final Context f40077c;

    /* renamed from: d, reason: collision with root package name */
    private String f40078d;

    /* renamed from: e, reason: collision with root package name */
    private String f40079e;

    /* renamed from: f, reason: collision with root package name */
    private String f40080f;

    /* renamed from: g, reason: collision with root package name */
    private CampaignEx f40081g;

    /* renamed from: h, reason: collision with root package name */
    private com.mbridge.msdk.foundation.feedback.a f40082h;

    /* loaded from: classes5.dex */
    class a implements com.mbridge.msdk.foundation.feedback.a {
        a() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a() {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void a(String str) {
        }

        @Override // com.mbridge.msdk.foundation.feedback.a
        public void close() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements c {
        b() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            MBAdChoice.this.setImageBitmap(bitmap);
        }
    }

    public MBAdChoice(Context context) {
        super(context);
        this.f40078d = "";
        this.f40079e = "";
        this.f40080f = "";
        this.f40077c = context;
        b();
    }

    public MBAdChoice(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f40078d = "";
        this.f40079e = "";
        this.f40080f = "";
        this.f40077c = context;
        b();
    }

    public MBAdChoice(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f40078d = "";
        this.f40079e = "";
        this.f40080f = "";
        this.f40077c = context;
        b();
    }

    private void a() {
        if (this.f40077c != null) {
            com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(this.f40078d, new b());
        }
    }

    private void a(CampaignEx campaignEx, g gVar) {
        this.f40081g = campaignEx;
        if (campaignEx == null) {
            if (gVar != null) {
                this.f40078d = gVar.b();
                return;
            }
            return;
        }
        CampaignEx.a adchoice = campaignEx.getAdchoice();
        if (adchoice != null) {
            this.f40078d = adchoice.b();
        }
        if (!TextUtils.isEmpty(this.f40078d) || gVar == null) {
            return;
        }
        this.f40078d = gVar.b();
    }

    private boolean a(CampaignEx campaignEx) {
        this.f40081g = campaignEx;
        g d11 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        c(campaignEx, d11);
        a(campaignEx, d11);
        b(campaignEx, d11);
        boolean z10 = (TextUtils.isEmpty(this.f40078d) || TextUtils.isEmpty(this.f40079e) || TextUtils.isEmpty(this.f40080f)) ? false : true;
        setImageUrl(this.f40078d);
        return z10;
    }

    private void b() {
        setScaleType(ImageView.ScaleType.FIT_CENTER);
        setClickable(true);
    }

    private void b(CampaignEx campaignEx, g gVar) {
        this.f40081g = campaignEx;
        if (campaignEx == null) {
            if (gVar != null) {
                this.f40080f = gVar.d();
                return;
            }
            return;
        }
        CampaignEx.a adchoice = campaignEx.getAdchoice();
        if (adchoice != null) {
            this.f40080f = adchoice.d();
        }
        if (!TextUtils.isEmpty(this.f40080f) || gVar == null) {
            return;
        }
        this.f40080f = gVar.d();
    }

    private void c(CampaignEx campaignEx, g gVar) {
        this.f40081g = campaignEx;
        if (campaignEx == null) {
            if (gVar != null) {
                this.f40079e = gVar.c();
                return;
            }
            return;
        }
        String privacyUrl = campaignEx.getPrivacyUrl();
        this.f40079e = privacyUrl;
        if (TextUtils.isEmpty(privacyUrl)) {
            CampaignEx.a adchoice = campaignEx.getAdchoice();
            if (adchoice != null) {
                this.f40079e = adchoice.c();
            }
            if (TextUtils.isEmpty(this.f40079e) && gVar != null) {
                this.f40079e = gVar.c();
            }
            if (TextUtils.isEmpty(this.f40079e)) {
                this.f40079e = d.h().f35528g;
            }
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        if (this.f40082h == null) {
            this.f40082h = new a();
        }
        t0.a(this.f40081g, this.f40082h, 4, "");
        return true;
    }

    public void setCampaign(Campaign campaign) {
        if (!(campaign instanceof CampaignEx)) {
            this.f40081g = null;
            return;
        }
        CampaignEx campaignEx = (CampaignEx) campaign;
        this.f40081g = campaignEx;
        if (a(campaignEx)) {
            a();
        }
    }

    public void setFeedbackDialogEventListener(com.mbridge.msdk.foundation.feedback.a aVar) {
        this.f40082h = aVar;
    }
}
