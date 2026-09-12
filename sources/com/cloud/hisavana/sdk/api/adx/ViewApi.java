package com.cloud.hisavana.sdk.api.adx;

import a7.c;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import b7.b;
import com.cloud.hisavana.sdk.G;
import com.cloud.hisavana.sdk.api.listener.AdCallback;
import com.cloud.hisavana.sdk.api.listener.d;
import com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.response.BidInfo;
import com.cloud.hisavana.sdk.e4;
import com.cloud.sdk.commonutil.util.e;
import java.util.Map;

/* loaded from: classes3.dex */
public class ViewApi extends RelativeLayout {

    /* renamed from: a, reason: collision with root package name */
    protected G f21671a;

    /* renamed from: b, reason: collision with root package name */
    protected String f21672b;

    /* renamed from: c, reason: collision with root package name */
    protected boolean f21673c;

    /* renamed from: d, reason: collision with root package name */
    protected int f21674d;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f21675e;

    /* renamed from: f, reason: collision with root package name */
    protected d f21676f;

    /* renamed from: g, reason: collision with root package name */
    protected boolean f21677g;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f21678h;

    /* renamed from: i, reason: collision with root package name */
    protected b7.a f21679i;

    /* renamed from: j, reason: collision with root package name */
    protected b f21680j;

    /* renamed from: k, reason: collision with root package name */
    protected androidx.collection.b f21681k;

    /* renamed from: l, reason: collision with root package name */
    private long f21682l;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public static class a extends AdCallback {

        /* renamed from: a, reason: collision with root package name */
        protected final ViewApi f21683a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(ViewApi viewApi) {
            this.f21683a = viewApi;
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public void D(G g11) {
            ViewApi viewApi = this.f21683a;
            if (viewApi != null) {
                viewApi.f21671a = g11;
            }
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public d d() {
            ViewApi viewApi = this.f21683a;
            if (viewApi != null) {
                return viewApi.f21676f;
            }
            return null;
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public String e() {
            ViewApi viewApi = this.f21683a;
            return viewApi != null ? SSPTrackingHelper.f22035a.o(viewApi.f21671a) : "";
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public String g() {
            ViewApi viewApi = this.f21683a;
            return viewApi != null ? SSPTrackingHelper.f22035a.q(viewApi.f21671a) : "";
        }

        @Override // com.cloud.hisavana.sdk.api.listener.AdCallback
        public void q(G g11, Bundle bundle) {
            ViewApi viewApi = this.f21683a;
            if (viewApi != null) {
                viewApi.f21671a = g11;
            }
            super.q(g11, bundle);
        }
    }

    public ViewApi(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewApi(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f21681k = new androidx.collection.b();
        this.f21682l = 0L;
    }

    public ViewApi(Context context, String str) {
        super(context);
        this.f21681k = new androidx.collection.b();
        this.f21682l = 0L;
        this.f21672b = str;
    }

    protected void a(TaErrorCode taErrorCode, Bundle bundle) {
        try {
            SSPTrackingHelper sSPTrackingHelper = SSPTrackingHelper.f22035a;
            sSPTrackingHelper.N(Integer.valueOf(taErrorCode.getErrorCode()), sSPTrackingHelper.q(this.f21671a), this.f21672b, sSPTrackingHelper.m(this.f21671a), bundle);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b() {
        if (TextUtils.isEmpty(c.f440b)) {
            e4.b().e("ssp", "AppId is empty, please check your config.");
            d dVar = this.f21676f;
            if (dVar != null) {
                dVar.onError(TaErrorCode.ERROR_INVALID_APP_ID);
            }
            return false;
        }
        if (!e.h()) {
            e4.b().e("ssp", "You should init first");
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long n11 = SSPTrackingHelper.f22035a.n();
        if (currentTimeMillis - this.f21682l > n11) {
            this.f21682l = currentTimeMillis;
            return true;
        }
        e4.b().d("ssp", "Ad request rate limit exceeded，current interval is" + n11);
        return false;
    }

    public void destroy() {
        this.f21676f = null;
        try {
            G g11 = this.f21671a;
            if (g11 != null) {
                this.f21681k.remove(g11);
                if (e4.c()) {
                    e4.b().i("ssp", "ViewApi mLoadedAd destroy");
                }
                this.f21671a.m();
            }
            if (this.f21681k.isEmpty()) {
                return;
            }
            for (int i11 = 0; i11 < this.f21681k.size(); i11++) {
                G g12 = (G) this.f21681k.o(i11);
                if (g12 != null) {
                    g12.m();
                }
            }
            this.f21681k.clear();
        } catch (Throwable unused) {
        }
    }

    public int getAdReadyStatusWithoutTracking() {
        G g11 = this.f21671a;
        if (g11 == null) {
            return 1115;
        }
        return g11.r();
    }

    public int getAdSource() {
        G g11 = this.f21671a;
        if (g11 != null) {
            return g11.q();
        }
        return 1;
    }

    public double getBidPrice() {
        G g11 = this.f21671a;
        if (g11 != null) {
            return g11.t();
        }
        return 0.0d;
    }

    public Map<String, Object> getExtInfo() {
        G g11 = this.f21671a;
        if (g11 == null || g11.p() == null || this.f21671a.p().l() == null) {
            return null;
        }
        return this.f21671a.p().l().a();
    }

    public int getFillAdType() {
        G g11 = this.f21671a;
        if (g11 != null) {
            return g11.u();
        }
        return 0;
    }

    public String getGameName() {
        G g11 = this.f21671a;
        if (g11 == null || g11.p() == null || this.f21671a.p().l() == null) {
            return null;
        }
        return this.f21671a.p().l().b();
    }

    public String getGameScene() {
        G g11 = this.f21671a;
        if (g11 == null || g11.p() == null || this.f21671a.p().l() == null) {
            return null;
        }
        return this.f21671a.p().l().c();
    }

    public b7.a getRequest() {
        return this.f21679i;
    }

    @Deprecated(since = "3.5.1.0")
    public boolean isAdValid() {
        return isReady();
    }

    public boolean isDefaultAd() {
        G g11 = this.f21671a;
        return g11 != null && g11.A();
    }

    public boolean isLoaded() {
        return this.f21671a != null;
    }

    public boolean isMatchVulgarBrand() {
        G g11 = this.f21671a;
        if (g11 != null) {
            return g11.B();
        }
        return false;
    }

    public boolean isOfflineAd() {
        G g11 = this.f21671a;
        return g11 != null && g11.C();
    }

    public boolean isReady() {
        G g11 = this.f21671a;
        if (g11 == null) {
            return false;
        }
        int r11 = g11.r();
        boolean z10 = r11 == 0;
        if (!z10) {
            Bundle bundle = new Bundle();
            bundle.putString("s_err_code", r11 + "");
            a(TaErrorCode.ERROR_SHOW_OUTER_INVALID, bundle);
        }
        return z10;
    }

    public void loadAd(BidInfo bidInfo) {
        G g11 = this.f21671a;
        if (g11 != null) {
            g11.j(bidInfo);
        }
    }

    public void setAdLoadScenes(@Nullable String str, @Nullable String str2, @Nullable Map<String, Object> map) {
        this.f21680j = new b(str, str2, map);
    }

    public void setBidding(boolean z10) {
        this.f21675e = z10;
    }

    public void setContainVulgarContent(boolean z10) {
        this.f21677g = z10;
    }

    public void setCurrActivityFullscreen(boolean z10) {
        this.f21673c = z10;
    }

    public void setDefaultFillTimeoutDuration(int i11) {
        this.f21674d = i11;
    }

    public void setListener(d dVar) {
        this.f21676f = dVar;
    }

    public void setOnlyFetchDefaultAd(Boolean bool) {
        this.f21678h = bool.booleanValue();
    }

    public void setPlacementId(String str) {
        this.f21672b = str;
    }

    public void setRequest(b7.a aVar) {
        this.f21679i = aVar;
    }
}
