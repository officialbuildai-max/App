package com.cloud.hisavana.sdk;

import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.cloud.hisavana.sdk.api.view.AdChoicesView;
import com.cloud.hisavana.sdk.api.view.AdCloseView;
import com.cloud.hisavana.sdk.common.athena.AthenaTracker;
import com.cloud.hisavana.sdk.common.bean.TaNativeInfo;
import com.cloud.hisavana.sdk.common.tracking.DownUpPointBean;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.transsion.push.PushConstants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private long f22515a;

    /* renamed from: b, reason: collision with root package name */
    private final u3 f22516b;

    /* renamed from: c, reason: collision with root package name */
    private List f22517c = null;

    /* renamed from: d, reason: collision with root package name */
    private float f22518d = -1.0f;

    /* renamed from: e, reason: collision with root package name */
    private float f22519e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    private float f22520f = -1.0f;

    /* renamed from: g, reason: collision with root package name */
    private float f22521g = -1.0f;

    /* renamed from: h, reason: collision with root package name */
    private final Map f22522h = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private final AdsDTO f22523a;

        /* renamed from: b, reason: collision with root package name */
        private final TaNativeInfo f22524b;

        b(AdsDTO adsDTO, TaNativeInfo taNativeInfo) {
            this.f22523a = adsDTO;
            this.f22524b = taNativeInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null || this.f22523a == null) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (view instanceof AdCloseView) {
                if (currentTimeMillis - t2.p().r() >= 2000) {
                    f.this.f22515a = currentTimeMillis;
                    if (this.f22523a.getSource() != 4) {
                        if (t2.p().o(view.getContext(), f.this.f22516b, this.f22523a, (AdCloseView) view)) {
                            t2.p().n(f.this.f22516b, this.f22524b);
                            return;
                        }
                        return;
                    } else {
                        if (f.this.f22516b == null || f.this.f22516b.Z() == null) {
                            return;
                        }
                        f.this.f22516b.Z().o(this.f22524b, this.f22523a);
                        return;
                    }
                }
                return;
            }
            if (this.f22523a.getPslinkInfo() != null) {
                if (view.getTag() == null || !TextUtils.equals("ad_download", view.getTag().toString())) {
                    this.f22523a.getPslinkInfo().setClickType(1);
                    this.f22523a.setTrackUserClickArea(1);
                    e4.b().d("ssp", "pslink half setClickType, click_img");
                } else {
                    this.f22523a.getPslinkInfo().setClickType(2);
                    this.f22523a.setTrackUserClickArea(2);
                    e4.b().d("ssp", "pslink half setClickType, click_install");
                }
            }
            if (currentTimeMillis - f.this.f22515a > 1000) {
                try {
                    N0.b(view.getContext(), this.f22523a, new DownUpPointBean(f.this.f22518d, f.this.f22519e, f.this.f22520f, f.this.f22521g, view.getMeasuredHeight(), view.getMeasuredWidth()), f.this.f22516b == null ? false : f.this.f22516b.p().v());
                    AthenaTracker.W(this.f22523a);
                    if (f.this.f22516b != null && f.this.f22516b.Z() != null) {
                        f.this.f22516b.Z().y(this.f22524b);
                    }
                    f.this.f22515a = currentTimeMillis;
                } catch (Throwable th2) {
                    e4.b().e(Log.getStackTraceString(th2));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class c implements View.OnTouchListener {
        private c() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                f.this.f22518d = motionEvent.getX();
                f.this.f22519e = motionEvent.getY();
                return false;
            }
            if (action != 1) {
                return false;
            }
            f.this.f22520f = motionEvent.getX();
            f.this.f22521g = motionEvent.getY();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(u3 u3Var) {
        this.f22516b = u3Var;
    }

    private boolean g(View view) {
        if (view == null || view.getTag() == null) {
            return false;
        }
        return view.getTag().equals("adxAdChoice") || view.getTag().equals("image_webview");
    }

    private void n() {
        Iterator it = this.f22522h.entrySet().iterator();
        while (it.hasNext()) {
            List<View> list = (List) ((Map.Entry) it.next()).getValue();
            if (list != null) {
                for (View view : list) {
                    if (view != null) {
                        view.setOnClickListener(null);
                        view.setOnTouchListener(null);
                    }
                }
            }
        }
        this.f22522h.clear();
    }

    public void d() {
        n();
        e4.b().d("ssp", PushConstants.PROVIDER_FIELD_DESTROY);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(View view, List list, TaNativeInfo taNativeInfo, AdsDTO adsDTO) {
        if (list != null) {
            Iterator it = list.iterator();
            this.f22522h.put(taNativeInfo, list);
            c cVar = new c();
            b bVar = new b(adsDTO, taNativeInfo);
            if (view != null) {
                view.setOnTouchListener(cVar);
                view.setOnClickListener(bVar);
            }
            while (it.hasNext()) {
                View view2 = (View) it.next();
                if (view2 != null && !g(view2) && !(view2 instanceof AdChoicesView)) {
                    view2.setOnClickListener(bVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f(TaNativeInfo taNativeInfo) {
        u3 u3Var = this.f22516b;
        if (u3Var == null || u3Var.Z() == null) {
            return;
        }
        this.f22516b.W(taNativeInfo);
        AdsDTO adItem = taNativeInfo == null ? null : taNativeInfo.getAdItem();
        if (adItem == null || adItem.getImpBeanRequest() == null) {
            return;
        }
        P.g().k(adItem.getImpBeanRequest().pmid);
        if (adItem.getSource() == 4) {
            Z.f21623a.q(adItem.getAdCreativeId(), adItem.getCodeSeatId());
        } else if (adItem.isOfflineAd()) {
            adItem.setShowNum(Integer.valueOf(adItem.getShowNum().intValue() + 1));
            c0.F().q(adItem);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List j() {
        return this.f22517c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(TaNativeInfo taNativeInfo) {
        if (taNativeInfo == null) {
            return;
        }
        List<View> list = (List) this.f22522h.get(taNativeInfo);
        if (com.cloud.hisavana.sdk.common.util.i.a(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(null);
                    view.setOnTouchListener(null);
                }
            }
            this.f22522h.remove(taNativeInfo);
        }
    }
}
