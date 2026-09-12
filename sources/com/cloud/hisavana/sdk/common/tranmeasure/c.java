package com.cloud.hisavana.sdk.common.tranmeasure;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import com.cloud.hisavana.sdk.common.constant.Constants;
import com.cloud.hisavana.sdk.d5;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.r2;
import com.cloud.sdk.commonutil.R$id;
import com.cloud.sdk.commonutil.util.Preconditions;

/* loaded from: classes3.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private final d f22184a;

    /* renamed from: b, reason: collision with root package name */
    private final h f22185b;

    /* renamed from: c, reason: collision with root package name */
    private long f22186c;

    /* renamed from: d, reason: collision with root package name */
    private long f22187d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f22188e = false;

    /* renamed from: f, reason: collision with root package name */
    private int f22189f = 0;

    /* renamed from: g, reason: collision with root package name */
    private String f22190g;

    /* loaded from: classes3.dex */
    class a implements Preconditions.a {
        a() {
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            if (c.this.f22184a == null || c.this.f22184a.f22193b == null || c.this.f22184a.g() == null) {
                return;
            }
            c.this.f22184a.f22193b.a(c.this.f22184a.g());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public c(d dVar) {
        this.f22184a = dVar;
        this.f22185b = h.b(dVar.f22196e);
    }

    private boolean b() {
        d5 d5Var;
        d dVar = this.f22184a;
        return (dVar == null || (d5Var = dVar.f22196e) == null || this.f22187d < ((long) d5Var.f22458c)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        int i11;
        d dVar = this.f22184a;
        if (dVar == null) {
            return;
        }
        View f11 = dVar.f();
        if (this.f22185b == null || this.f22184a.f22196e == null || f11 == null) {
            return;
        }
        if (f11.getTag(R$id.native_view_source) != null && !TextUtils.equals(Constants.f22123a, f11.getTag(R$id.native_view_source).toString())) {
            if (f11.getTag(R$id.native_view_source) != null) {
                e4.b().d("ssp_measure", "session.AdView.Tag" + f11.getTag(R$id.native_view_source).toString());
                return;
            }
            return;
        }
        if (this.f22184a.i()) {
            return;
        }
        try {
            i11 = d();
        } catch (Throwable th2) {
            e4.b().w("ssp_measure", Log.getStackTraceString(th2));
            i11 = 0;
        }
        if (i11 > 0 && !this.f22184a.h()) {
            d dVar2 = this.f22184a;
            if (dVar2.f22193b != null) {
                dVar2.c(true);
                Preconditions.d(new a());
                AdsDTO e11 = this.f22184a.e();
                if (e11 != null) {
                    int measuredWidth = f11.getMeasuredWidth();
                    e11.setViewHeight(f11.getMeasuredHeight());
                    e11.setViewWidth(measuredWidth);
                    e11.setShowReportTimeType(1);
                    r2.a(e11);
                }
            }
        }
        if (i11 > this.f22189f) {
            this.f22189f = i11;
            this.f22190g = this.f22185b.f22219b;
        }
        if (i11 <= 0) {
            this.f22186c = 0L;
            return;
        }
        if (!this.f22188e) {
            e4.b().d("ssp_measure", "检查View在Window的可见性 返回百分比 --> exposureRatio = " + i11 + " totalImpressionTime=" + this.f22187d);
        }
        if (this.f22186c > 0) {
            this.f22187d += SystemClock.uptimeMillis() - this.f22186c;
        }
        this.f22186c = SystemClock.uptimeMillis();
        if (b()) {
            float f12 = i11;
            d dVar3 = this.f22184a;
            if (f12 < dVar3.f22196e.f22456a || this.f22188e) {
                return;
            }
            this.f22188e = true;
            AdsDTO e12 = dVar3.e();
            if (e12 != null) {
                e12.setShowReportTimeType(2);
                e12.setActualShowRate(Integer.valueOf(this.f22189f));
                e12.setShowArea(this.f22190g);
                e12.setActualShowTime(Long.valueOf(this.f22187d));
                if (a7.d.a(e12)) {
                    r2.b(e12);
                } else {
                    r2.a(e12);
                }
            } else {
                e4.b().d("ssp_measure", "session.getmKey() instanceof AdsDTO --> false");
            }
            e.c().f(this.f22184a);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d() {
        d5 d5Var;
        h hVar;
        d dVar = this.f22184a;
        if (dVar == null || (d5Var = dVar.f22196e) == null || (hVar = this.f22185b) == null) {
            return 0;
        }
        return hVar.a(d5Var, dVar.f());
    }
}
