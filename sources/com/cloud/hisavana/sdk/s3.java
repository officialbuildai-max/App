package com.cloud.hisavana.sdk;

import android.os.Bundle;
import com.cloud.hisavana.sdk.api.listener.AdCallback;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.sdk.commonutil.util.Preconditions;
import java.util.List;

/* loaded from: classes3.dex */
public class s3 extends G {

    /* renamed from: i, reason: collision with root package name */
    private p4 f23020i;

    /* renamed from: j, reason: collision with root package name */
    private volatile AdsDTO f23021j;

    public s3(q3 q3Var) {
        super(q3Var);
        this.f23021j = null;
    }

    private void L() {
        this.f23020i = new p4(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void F(TaErrorCode taErrorCode) {
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.t(taErrorCode, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void G(AdsDTO adsDTO) {
        if (adsDTO != null) {
            this.f23021j = adsDTO;
        }
    }

    public void H(AdsDTO adsDTO) {
        this.f23021j = adsDTO;
        L();
        this.f23020i.e(adsDTO);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I() {
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.m();
            this.f21586e.k(this.f23021j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void J() {
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.p(this.f23021j);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void K() {
        f();
        k(true);
        AdCallback adCallback = this.f21586e;
        if (adCallback != null) {
            adCallback.s();
        }
    }

    public void M() {
        Preconditions.a();
        L();
        if (this.f23021j == null) {
            F(TaErrorCode.ERROR_SHOW_ADBEAN_NULL);
            e4.b().d("ssp", "adBean = null");
        } else if (r() == 0 && !z()) {
            this.f23020i.e(this.f23021j);
        } else {
            F(TaErrorCode.ERROR_SHOW_INNER_INVALID);
            e4.b().d("ssp", "ad not condition to use");
        }
    }

    @Override // com.cloud.hisavana.sdk.G, com.cloud.hisavana.sdk.api.listener.f
    public void d(List list, Bundle bundle) {
        this.f23021j = (list == null || list.isEmpty()) ? null : (AdsDTO) list.get(0);
        super.d(list, bundle);
    }

    @Override // com.cloud.hisavana.sdk.G
    public void m() {
        super.m();
        p4 p4Var = this.f23020i;
        if (p4Var != null) {
            p4Var.d();
        }
    }
}
