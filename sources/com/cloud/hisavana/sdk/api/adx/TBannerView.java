package com.cloud.hisavana.sdk.api.adx;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.cloud.hisavana.sdk.G;
import com.cloud.hisavana.sdk.R$styleable;
import com.cloud.hisavana.sdk.api.adx.ViewApi;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.p3;
import com.cloud.hisavana.sdk.q3;

/* loaded from: classes3.dex */
public final class TBannerView extends ViewApi {
    public int autoRefreshNum;
    public long lastestAutoRefreshTs;

    /* renamed from: m, reason: collision with root package name */
    private Integer f21660m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f21661n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f21662o;

    public TBannerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TBannerView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        String str = null;
        this.f21660m = null;
        this.lastestAutoRefreshTs = 0L;
        this.autoRefreshNum = 1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.AdBannerView);
        for (int i12 = 0; i12 < obtainStyledAttributes.getIndexCount(); i12++) {
            int index = obtainStyledAttributes.getIndex(i12);
            if (index == R$styleable.AdBannerView_placementId) {
                str = obtainStyledAttributes.getString(index);
            }
        }
        if (obtainStyledAttributes.getIndexCount() > 0) {
            e4.b().d("ssp", "placementId=" + str);
        }
        obtainStyledAttributes.recycle();
    }

    public TBannerView(Context context, String str) {
        super(context, str);
        this.f21660m = null;
        this.lastestAutoRefreshTs = 0L;
        this.autoRefreshNum = 1;
    }

    @Nullable
    public Integer getCloseTypeUsedForTrack() {
        return this.f21660m;
    }

    public void loadAd() {
        this.autoRefreshNum = 1;
        loadAdFromAutoRefresh(false);
    }

    public void loadAdFromAutoRefresh(boolean z10) {
        String str = "";
        if (z10) {
            try {
                G g11 = this.f21671a;
                if (g11 != null && (g11 instanceof p3)) {
                    p3 p3Var = (p3) g11;
                    try {
                        q3 p11 = g11.p();
                        if (p11 != null) {
                            str = p11.n();
                        }
                    } catch (Throwable unused) {
                    }
                    long j11 = p3Var.f22919p;
                    long intValue = p3Var.f22920q.intValue();
                    if (this.autoRefreshNum > intValue) {
                        e4.b().d("ssp", "autoRefreshNum > autoCarouselCount, returnautoRefreshNum->" + this.autoRefreshNum + "autoCarouselCount->" + intValue);
                        return;
                    }
                    if (this.lastestAutoRefreshTs != 0 && j11 != 0) {
                        long currentTimeMillis = System.currentTimeMillis() - this.lastestAutoRefreshTs;
                        if (currentTimeMillis < j11) {
                            e4.b().d("ssp", "loadNextAD auto refresh is so quickly,return interval->" + currentTimeMillis + "autoRefreshTs->" + j11);
                            return;
                        }
                    }
                    this.lastestAutoRefreshTs = System.currentTimeMillis();
                    this.autoRefreshNum++;
                }
            } catch (Throwable unused2) {
            }
        }
        if (b()) {
            p3 p3Var2 = new p3(new q3.b(str).i(2).e(this.f21672b).r(this.f21673c).l(this.f21674d).j(this.f21675e).c(this.f21680j).o(this.f21677g).v(this.f21678h).m(this.f21662o).s(this.f21661n).f(z10).b(this.f21679i).g());
            p3Var2.I(this);
            p3Var2.g(new ViewApi.a(this));
            p3Var2.N(z10);
        }
    }

    public void setCloseDirectlyWithoutJumping(boolean z10) {
        this.f21662o = z10;
    }

    public void setCloseTypeUsedForTrack(Integer num) {
        this.f21660m = num;
    }

    public void setHideAdCloseView(boolean z10) {
        this.f21661n = z10;
    }

    public void show() {
        G g11 = this.f21671a;
        if (g11 instanceof p3) {
            try {
                this.f21681k.add(g11);
            } catch (Throwable unused) {
            }
            ((p3) this.f21671a).M(this);
        }
    }
}
