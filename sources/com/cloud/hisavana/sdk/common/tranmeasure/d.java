package com.cloud.hisavana.sdk.common.tranmeasure;

import android.view.View;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.d5;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.hisavana.sdk.r2;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.sdk.commonutil.util.Preconditions;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final Object f22192a;

    /* renamed from: b, reason: collision with root package name */
    protected b f22193b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference f22194c;

    /* renamed from: e, reason: collision with root package name */
    protected d5 f22196e;

    /* renamed from: h, reason: collision with root package name */
    private final com.cloud.hisavana.sdk.common.tranmeasure.c f22199h;

    /* renamed from: d, reason: collision with root package name */
    private boolean f22195d = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f22197f = true;

    /* renamed from: g, reason: collision with root package name */
    private AtomicBoolean f22198g = new AtomicBoolean(false);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            e.c().f(d.this);
        }
    }

    /* loaded from: classes3.dex */
    public interface b {
        void a(Object obj);
    }

    /* loaded from: classes3.dex */
    public static class c implements Preconditions.a {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference f22201a;

        public c(d dVar) {
            this.f22201a = new WeakReference(dVar);
        }

        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
        public void onRun() {
            d dVar;
            WeakReference weakReference = this.f22201a;
            if (weakReference == null || (dVar = (d) weakReference.get()) == null) {
                return;
            }
            b bVar = dVar.f22193b;
            Object g11 = dVar.g();
            if (bVar == null || g11 == null) {
                return;
            }
            e4.b().d("ssp", "----------------> 曝光回调");
            bVar.a(g11);
        }
    }

    public d(Object obj) {
        d5 d5Var = new d5();
        this.f22196e = d5Var;
        d5Var.f22458c = 1000;
        d5Var.f22456a = 50.0f;
        d5Var.f22457b = 0;
        this.f22192a = obj;
        this.f22199h = new com.cloud.hisavana.sdk.common.tranmeasure.c(this);
    }

    public void a() {
        WeakReference weakReference = this.f22194c;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.f22193b = null;
        HSScopeHelper.f23249a.e(new a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(View view, b bVar) {
        e4.b().d("ssp_measure", "MeasureSession registerView,isImpression = " + this.f22195d);
        if (this.f22195d) {
            return;
        }
        this.f22194c = new WeakReference(view);
        this.f22193b = bVar;
        e.c().d(this);
        com.cloud.hisavana.sdk.common.tranmeasure.c cVar = this.f22199h;
        if (cVar == null || cVar.d() <= 0 || this.f22195d) {
            return;
        }
        if (this.f22193b != null) {
            AdsDTO e11 = e();
            if (e11 != null && view != null) {
                e11.setImageWidth(Integer.valueOf(view.getMeasuredWidth()));
                e11.setImageHeight(Integer.valueOf(view.getMeasuredHeight()));
            }
            Preconditions.d(new c(this));
            this.f22195d = true;
        }
        AdsDTO e12 = e();
        if (e12 != null) {
            e12.setShowReportTimeType(1);
            r2.a(e12);
        }
    }

    public void c(boolean z10) {
        this.f22195d = z10;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean d(Object obj) {
        return this.f22192a == obj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public AdsDTO e() {
        Object obj = this.f22192a;
        if (obj instanceof AdsDTO) {
            return (AdsDTO) obj;
        }
        if (obj instanceof TaNativeInfo) {
            return ((TaNativeInfo) obj).getAdItem();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View f() {
        WeakReference weakReference = this.f22194c;
        if (weakReference != null) {
            return (View) weakReference.get();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object g() {
        return this.f22192a;
    }

    public boolean h() {
        return this.f22195d;
    }

    public boolean i() {
        return this.f22198g.get();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void j() {
        com.cloud.hisavana.sdk.common.tranmeasure.c cVar = this.f22199h;
        if (cVar != null) {
            cVar.c();
        }
    }
}
