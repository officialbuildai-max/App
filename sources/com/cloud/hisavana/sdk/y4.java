package com.cloud.hisavana.sdk;

import android.os.Bundle;
import com.cloud.hisavana.sdk.common.athena.SSPTrackingHelper;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.l4;
import com.cloud.hisavana.sdk.v4;
import java.util.List;

/* loaded from: classes3.dex */
public class y4 extends l4 {

    /* renamed from: e, reason: collision with root package name */
    private List f23204e;

    /* renamed from: f, reason: collision with root package name */
    private q3 f23205f;

    /* loaded from: classes3.dex */
    class a implements v4.f {
        a() {
        }

        @Override // com.cloud.hisavana.sdk.v4.f
        public void a(TaErrorCode taErrorCode, Bundle bundle) {
            y4.this.g(taErrorCode);
            SSPTrackingHelper.f22035a.U(2, y4.this.f23205f, taErrorCode, bundle);
        }

        @Override // com.cloud.hisavana.sdk.v4.f
        public void b(List list, Bundle bundle) {
            y4.this.j(list);
            SSPTrackingHelper.f22035a.U(2, y4.this.f23205f, TaErrorCode.ERROR_SUCCESS, bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(TaErrorCode taErrorCode) {
        this.f22708b = 3;
        l4.a aVar = this.f22707a;
        if (aVar != null) {
            aVar.a(taErrorCode, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(List list) {
        this.f22708b = 3;
        if (list == null || list.isEmpty()) {
            g(TaErrorCode.ERROR_AD_MATERIAL_DOWNLOAD_IS_NULL);
            return;
        }
        l4.a aVar = this.f22707a;
        if (aVar != null) {
            aVar.b(list, null);
        }
    }

    @Override // com.cloud.hisavana.sdk.c4
    public void a(q3 q3Var) {
        this.f22708b = 2;
        this.f23205f = q3Var;
        e4.b().d("ssp", "start execute getAdCreativies.");
        v4 v4Var = new v4();
        v4Var.c(new a());
        SSPTrackingHelper.f22035a.U(1, this.f23205f, TaErrorCode.ERROR_SUCCESS, new Bundle());
        v4Var.e(this.f23204e, q3Var.e(), 1, this.f22710d);
    }

    public void k(List list) {
        this.f23204e = list;
    }
}
