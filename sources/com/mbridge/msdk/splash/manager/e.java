package com.mbridge.msdk.splash.manager;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.kernel.minicover.NativeComponentConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.m;
import com.mbridge.msdk.foundation.same.c;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.foundation.tools.y0;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.setting.l;
import com.mbridge.msdk.splash.common.c;
import com.mbridge.msdk.splash.manager.g;
import com.mbridge.msdk.splash.view.MBSplashView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class e {
    private static String A = "SplashLoadManager";

    /* renamed from: a, reason: collision with root package name */
    private String f37520a;

    /* renamed from: b, reason: collision with root package name */
    private String f37521b;

    /* renamed from: c, reason: collision with root package name */
    private long f37522c;

    /* renamed from: d, reason: collision with root package name */
    private long f37523d;

    /* renamed from: e, reason: collision with root package name */
    private com.mbridge.msdk.splash.middle.b f37524e;

    /* renamed from: g, reason: collision with root package name */
    private MBSplashView f37526g;

    /* renamed from: h, reason: collision with root package name */
    private l f37527h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f37528i;

    /* renamed from: j, reason: collision with root package name */
    private int f37529j;

    /* renamed from: k, reason: collision with root package name */
    private int f37530k;

    /* renamed from: l, reason: collision with root package name */
    private int f37531l;

    /* renamed from: m, reason: collision with root package name */
    private String f37532m;

    /* renamed from: n, reason: collision with root package name */
    private int f37533n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f37534o;

    /* renamed from: p, reason: collision with root package name */
    private volatile boolean f37535p;

    /* renamed from: q, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f37536q;

    /* renamed from: r, reason: collision with root package name */
    private H5DownLoadManager.ZipDownloadListener f37537r;

    /* renamed from: s, reason: collision with root package name */
    private String f37538s;

    /* renamed from: t, reason: collision with root package name */
    private int f37539t;

    /* renamed from: v, reason: collision with root package name */
    private int f37541v;

    /* renamed from: w, reason: collision with root package name */
    private List<CampaignEx> f37542w;

    /* renamed from: u, reason: collision with root package name */
    private String f37540u = "";

    /* renamed from: x, reason: collision with root package name */
    private String f37543x = "";

    /* renamed from: y, reason: collision with root package name */
    private Handler f37544y = new c(Looper.getMainLooper());

    /* renamed from: z, reason: collision with root package name */
    private Runnable f37545z = new d();

    /* renamed from: f, reason: collision with root package name */
    private Context f37525f = com.mbridge.msdk.foundation.controller.c.m().d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements g.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f37546a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f37547b;

        a(CampaignEx campaignEx, int i11) {
            this.f37546a = campaignEx;
            this.f37547b = i11;
        }

        @Override // com.mbridge.msdk.splash.manager.g.c
        public void a() {
            if (this.f37546a.isHasMBTplMark()) {
                return;
            }
            e.this.g(this.f37546a, this.f37547b);
        }

        @Override // com.mbridge.msdk.splash.manager.g.c
        public void a(int i11) {
            if (i11 == 1) {
                e.this.g(this.f37546a, this.f37547b);
            } else {
                e.this.a("readyState 2", this.f37547b, this.f37546a);
            }
        }

        @Override // com.mbridge.msdk.splash.manager.g.c
        public void onError(String str) {
            e.this.a(str, this.f37547b, this.f37546a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements com.mbridge.msdk.videocommon.listener.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f37549a;

        b(CampaignEx campaignEx) {
            this.f37549a = campaignEx;
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str) {
            e.this.f37526g.setVideoReady(true);
            Message obtain = Message.obtain();
            obtain.obj = this.f37549a;
            obtain.what = 3;
            e.this.f37544y.sendMessage(obtain);
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str, String str2) {
            e.this.f37526g.setVideoReady(false);
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880004);
            bVar.c(str);
            e eVar = e.this;
            eVar.a(bVar, eVar.f37532m, e.this.f37533n, this.f37549a);
            Message obtain = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putSerializable("campaignex", this.f37549a);
            bundle.putString(NotificationCompat.CATEGORY_MESSAGE, str);
            bundle.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 1);
            obtain.obj = bundle;
            obtain.what = 2;
            e.this.f37544y.sendMessage(obtain);
        }
    }

    /* loaded from: classes5.dex */
    class c extends Handler {
        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            super.handleMessage(message);
            int i11 = message.what;
            if (i11 == 1) {
                Object obj = message.obj;
                int i12 = message.arg1;
                if (obj instanceof CampaignEx) {
                    CampaignEx campaignEx = (CampaignEx) obj;
                    e.this.a(H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getAdZip()), campaignEx, i12);
                    return;
                }
                return;
            }
            if (i11 != 2) {
                if (i11 != 3) {
                    return;
                }
                Object obj2 = message.obj;
                if (obj2 instanceof CampaignEx) {
                    e eVar = e.this;
                    eVar.h((CampaignEx) obj2, eVar.f37533n);
                    return;
                }
                return;
            }
            Object obj3 = message.obj;
            try {
                if (obj3 instanceof Bundle) {
                    int i13 = ((Bundle) obj3).getInt(NativeComponentConstants.KEY_COMPONENT_TYPE);
                    String string = ((Bundle) obj3).getString(NotificationCompat.CATEGORY_MESSAGE);
                    CampaignEx campaignEx2 = (CampaignEx) ((Bundle) obj3).getSerializable("campaignex");
                    com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(i13 == 1 ? 880004 : i13 == 2 ? 880006 : 880027);
                    bVar.c(string);
                    e eVar2 = e.this;
                    eVar2.a(bVar, eVar2.f37532m, e.this.f37533n, campaignEx2);
                }
            } catch (Exception e11) {
                com.mbridge.msdk.foundation.error.b bVar2 = new com.mbridge.msdk.foundation.error.b(880024);
                bVar2.a((Throwable) e11);
                e eVar3 = e.this;
                eVar3.a(bVar2, eVar3.f37532m, e.this.f37533n, (CampaignEx) null);
            }
        }
    }

    /* loaded from: classes5.dex */
    class d implements Runnable {
        d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880010);
            e eVar = e.this;
            eVar.a(bVar, eVar.f37532m, e.this.f37533n, (CampaignEx) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.mbridge.msdk.splash.manager.e$e, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C0544e extends com.mbridge.msdk.splash.request.b {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f37553e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f37554f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C0544e(int i11, String str, int i12) {
            super(i11);
            this.f37553e = str;
            this.f37554f = i12;
        }

        @Override // com.mbridge.msdk.splash.request.b
        public void a(CampaignUnit campaignUnit, int i11) {
            try {
                e eVar = e.this;
                eVar.a(campaignUnit, i11, eVar.f37520a, this.f37553e);
                e.this.f37540u = campaignUnit.getRequestId();
                e.this.f37542w = campaignUnit.getAds();
            } catch (Exception e11) {
                e11.printStackTrace();
                com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880003);
                bVar.a((Throwable) e11);
                e.this.a(bVar, this.f37553e, i11, (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() == 0) ? null : campaignUnit.getAds().get(0));
                e.this.f();
            }
        }

        @Override // com.mbridge.msdk.splash.request.b
        public void b(int i11, String str) {
            o0.b(e.A, str);
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880002);
            bVar.c(str);
            e.this.a(bVar, this.f37553e, this.f37554f, (CampaignEx) null);
            e.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class f extends c.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f37556a;

        f(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
            this.f37556a = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.same.c.a
        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            com.mbridge.msdk.splash.report.a.a(str, cVar, this.f37556a, e.this.f37525f, (com.mbridge.msdk.foundation.same.report.metrics.callback.a) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f37558a;

        g(CampaignEx campaignEx) {
            this.f37558a = campaignEx;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.foundation.db.j.a(com.mbridge.msdk.foundation.db.g.a(e.this.f37525f)).a();
            w.a(e.this.f37525f, this.f37558a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class h implements com.mbridge.msdk.splash.view.nativeview.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f37560a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f37561b;

        h(CampaignEx campaignEx, int i11) {
            this.f37560a = campaignEx;
            this.f37561b = i11;
        }

        @Override // com.mbridge.msdk.splash.view.nativeview.a
        public void a() {
            if (this.f37560a.isDynamicView() && e.this.f37526g != null) {
                e.this.f37526g.setImageReady(true);
                e.this.f(this.f37560a, this.f37561b);
            }
            e.this.h(this.f37560a, this.f37561b);
        }

        @Override // com.mbridge.msdk.splash.view.nativeview.a
        public void b() {
            if (!this.f37560a.isDynamicView() || e.this.f37526g == null) {
                return;
            }
            e.this.f37526g.setImageReady(false);
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880027);
            e eVar = e.this;
            eVar.a(bVar, eVar.f37532m, this.f37561b, this.f37560a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class i implements x.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f37563a;

        i(CampaignEx campaignEx) {
            this.f37563a = campaignEx;
        }

        @Override // com.mbridge.msdk.foundation.tools.x.c
        public void a(String str, DownloadError downloadError) {
            String str2 = "";
            if (downloadError != null) {
                try {
                    if (downloadError.getException() != null) {
                        str2 = downloadError.getException().getMessage();
                    }
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                        return;
                    }
                    return;
                }
            }
            e.this.a(this.f37563a, str, false, str2);
        }

        @Override // com.mbridge.msdk.foundation.tools.x.c
        public void a(String str, String str2, String str3, String str4, boolean z10) {
            if (z10) {
                return;
            }
            e.this.a(this.f37563a, str, true, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class j implements H5DownLoadManager.ZipDownloadListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f37565a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f37566b;

        j(CampaignEx campaignEx, int i11) {
            this.f37565a = campaignEx;
            this.f37566b = i11;
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onFailed(String str, String str2) {
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880006);
            e eVar = e.this;
            eVar.a(bVar, eVar.f37532m, this.f37566b, this.f37565a);
            Message obtain = Message.obtain();
            obtain.what = 2;
            Bundle bundle = new Bundle();
            bundle.putSerializable("campaignex", this.f37565a);
            bundle.putString(NotificationCompat.CATEGORY_MESSAGE, str);
            bundle.putInt(NativeComponentConstants.KEY_COMPONENT_TYPE, 2);
            obtain.obj = bundle;
            e.this.f37544y.sendMessage(obtain);
            e.this.a(this.f37565a, str2, false, str);
        }

        @Override // com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter
        public void onSuccess(String str, String str2, boolean z10) {
            Message obtain = Message.obtain();
            obtain.what = 1;
            obtain.obj = this.f37565a;
            obtain.arg1 = this.f37566b;
            e.this.f37544y.sendMessage(obtain);
            if (z10) {
                return;
            }
            CampaignEx campaignEx = this.f37565a;
            e.this.a(this.f37565a, campaignEx != null ? campaignEx.getAdZip() : "", true, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class k implements com.mbridge.msdk.splash.inter.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ CampaignEx f37568a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f37569b;

        k(CampaignEx campaignEx, int i11) {
            this.f37568a = campaignEx;
            this.f37569b = i11;
        }

        @Override // com.mbridge.msdk.splash.inter.a
        public void a(View view) {
            if (e.this.f37526g != null) {
                e.this.f37526g.setDynamicView(true);
                e.this.f37526g.setSplashNativeView(view);
                e.this.h(this.f37568a, this.f37569b);
            }
        }

        @Override // com.mbridge.msdk.splash.inter.a
        public void onError(String str) {
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880034);
            bVar.c(str);
            e eVar = e.this;
            eVar.a(bVar, eVar.f37532m, this.f37569b, this.f37568a);
        }
    }

    public e(String str, String str2, long j11) {
        this.f37521b = str;
        this.f37520a = str2;
        this.f37523d = j11;
    }

    private List<CampaignEx> a(CampaignUnit campaignUnit) {
        if (campaignUnit == null || campaignUnit.getAds() == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        CampaignEx campaignEx = campaignUnit.getAds().get(0);
        campaignEx.setCampaignUnitId(this.f37520a);
        a(campaignEx);
        this.f37538s = campaignUnit.getSessionId();
        if (campaignEx.getOfferType() != 99 && (!TextUtils.isEmpty(campaignEx.getAdZip()) || !TextUtils.isEmpty(campaignEx.getAdHtml()))) {
            if (t0.c(campaignEx)) {
                campaignEx.setRtinsType(t0.c(this.f37525f, campaignEx.getPackageName()) ? 1 : 2);
            }
            if (com.mbridge.msdk.foundation.same.c.b(this.f37525f, campaignEx)) {
                arrayList.add(campaignEx);
            } else {
                t0.a(this.f37520a, campaignEx, com.mbridge.msdk.foundation.same.a.f35406x);
                this.f37543x = "APP ALREADY INSTALLED";
            }
            a(campaignEx, (com.mbridge.msdk.foundation.same.report.metrics.c) null, (com.mbridge.msdk.foundation.same.report.metrics.callback.a) null);
        }
        return arrayList;
    }

    private void a(long j11) {
        this.f37544y.postDelayed(this.f37545z, j11);
    }

    private void a(Context context, String str, int i11) {
        try {
            if (context == null) {
                a(new com.mbridge.msdk.foundation.error.b(880025), str, i11, (CampaignEx) null);
                return;
            }
            if (y0.a(this.f37520a)) {
                a(new com.mbridge.msdk.foundation.error.b(880032), str, i11, (CampaignEx) null);
                return;
            }
            MBridgeIds mBridgeIds = new MBridgeIds(this.f37521b, this.f37520a);
            com.mbridge.msdk.splash.request.f fVar = new com.mbridge.msdk.splash.request.f();
            fVar.d(i11);
            fVar.c(this.f37539t);
            fVar.a(this.f37538s);
            fVar.b(this.f37531l);
            fVar.a(this.f37530k);
            com.mbridge.msdk.foundation.same.net.wrapper.e b11 = com.mbridge.msdk.splash.request.e.b(context, mBridgeIds, fVar);
            if (b11 == null) {
                a(new com.mbridge.msdk.foundation.error.b(880001), str, i11, (CampaignEx) null);
                return;
            }
            if (!TextUtils.isEmpty(str)) {
                b11.a("token", str);
            }
            String d11 = t0.d(this.f37520a);
            if (!TextUtils.isEmpty(d11)) {
                b11.a(com.mbridge.msdk.foundation.same.report.j.f35620b, d11);
            }
            com.mbridge.msdk.splash.request.c cVar = new com.mbridge.msdk.splash.request.c(context);
            C0544e c0544e = new C0544e(i11, str, i11);
            c0544e.a(str);
            c0544e.setUnitId(this.f37520a);
            c0544e.setPlacementId(this.f37521b);
            c0544e.setAdType(297);
            cVar.choiceV3OrV5BySetting(1, b11, c0544e, str, com.mbridge.msdk.foundation.same.c.a(this.f37522c, 30000L));
        } catch (Exception e11) {
            o0.b(A, e11.getMessage());
            com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880020);
            bVar.a((Throwable) e11);
            a(bVar, str, i11, (CampaignEx) null);
            f();
        }
    }

    private void a(CampaignEx campaignEx) {
        new Thread(new g(campaignEx)).start();
    }

    private void a(CampaignEx campaignEx, int i11) {
        this.f37526g.clearResState();
        if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
            e(campaignEx, i11);
        }
        if (campaignEx.isDynamicView()) {
            return;
        }
        if (!TextUtils.isEmpty(campaignEx.getAdHtml())) {
            d(campaignEx, i11);
        }
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            b(campaignEx, i11);
        }
        if (TextUtils.isEmpty(campaignEx.getImageUrl())) {
            return;
        }
        c(campaignEx, i11);
    }

    private void a(CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.metrics.c cVar, com.mbridge.msdk.foundation.same.report.metrics.callback.a aVar) {
        try {
            com.mbridge.msdk.foundation.same.c.a(campaignEx, this.f37525f, cVar, new f(campaignEx, aVar));
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignEx campaignEx, String str, boolean z10, String str2) {
        try {
            m mVar = new m();
            mVar.e(2);
            mVar.j("m_download_end");
            if (campaignEx != null) {
                mVar.b(campaignEx.isMraid() ? m.N : m.O);
                mVar.o(campaignEx.getRequestIdNotice());
            }
            mVar.b("url", str);
            mVar.b("scenes", "1");
            if (z10) {
                mVar.d(1);
            } else {
                mVar.d(3);
                mVar.m(str2);
            }
            com.mbridge.msdk.foundation.same.report.metrics.d.b().a(mVar, campaignEx);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                o0.b(A, e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CampaignUnit campaignUnit, int i11, String str, String str2) {
        List<CampaignEx> a11 = a(campaignUnit);
        if (a11 == null || a11.size() <= 0) {
            a(this.f37543x.contains("INSTALLED") ? new com.mbridge.msdk.foundation.error.b(880021, "APP ALREADY INSTALLED") : new com.mbridge.msdk.foundation.error.b(880003), str2, i11, (campaignUnit == null || campaignUnit.getAds() == null || campaignUnit.getAds().size() == 0) ? null : campaignUnit.getAds().get(0));
            return;
        }
        g();
        CampaignEx campaignEx = a11.get(0);
        if (!TextUtils.isEmpty(campaignEx.getAdZip()) || (!TextUtils.isEmpty(campaignEx.getAdHtml()) && campaignEx.getAdHtml().contains("<MBTPLMARK>"))) {
            campaignEx.setHasMBTplMark(true);
            campaignEx.setIsMraid(false);
        } else {
            campaignEx.setHasMBTplMark(false);
            campaignEx.setIsMraid(true);
        }
        i(campaignEx, i11);
    }

    private void a(com.mbridge.msdk.foundation.error.b bVar, int i11, CampaignEx campaignEx) {
        if (this.f37535p) {
            return;
        }
        b();
        this.f37535p = true;
        if (bVar != null) {
            bVar.a(campaignEx);
        }
        com.mbridge.msdk.splash.middle.b bVar2 = this.f37524e;
        if (bVar2 != null) {
            bVar2.a(bVar, i11);
        }
    }

    private void a(com.mbridge.msdk.foundation.error.b bVar, int i11, String str, CampaignEx campaignEx) {
        CampaignEx a11 = com.mbridge.msdk.splash.manager.d.a(this.f37526g, this.f37521b, this.f37520a, str, this.f37528i, this.f37529j, true, false);
        if (a11 != null) {
            i(a11, i11);
        } else {
            a(bVar, i11, campaignEx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.foundation.error.b bVar, String str, int i11, CampaignEx campaignEx) {
        if (!this.f37534o) {
            a(bVar, i11, campaignEx);
        } else {
            this.f37534o = false;
            a(bVar, i11, str, campaignEx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i11, CampaignEx campaignEx) {
        com.mbridge.msdk.foundation.error.b bVar = new com.mbridge.msdk.foundation.error.b(880009);
        bVar.c(str);
        a(bVar, this.f37532m, i11, campaignEx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, CampaignEx campaignEx, int i11) {
        g.d dVar = new g.d();
        dVar.c(this.f37520a);
        dVar.b(this.f37521b);
        dVar.a(campaignEx);
        dVar.a(str);
        dVar.a(this.f37528i);
        dVar.a(this.f37529j);
        com.mbridge.msdk.splash.manager.g.a().a(this.f37526g, dVar, new a(campaignEx, i11));
    }

    private void b() {
        this.f37544y.removeCallbacks(this.f37545z);
    }

    private void b(CampaignEx campaignEx, int i11) {
        this.f37536q = new b(campaignEx);
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(campaignEx);
        com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(this.f37525f, this.f37520a, copyOnWriteArrayList, 297, this.f37536q);
        if (!com.mbridge.msdk.videocommon.download.b.getInstance().b(297, this.f37520a, campaignEx.isBidCampaign())) {
            com.mbridge.msdk.videocommon.download.b.getInstance().load(this.f37520a);
        } else {
            this.f37526g.setVideoReady(true);
            h(campaignEx, i11);
        }
    }

    private void c(CampaignEx campaignEx, int i11) {
        com.mbridge.msdk.splash.manager.d.a(this.f37526g, campaignEx, new h(campaignEx, i11));
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00d3 A[Catch: Exception -> 0x011b, TRY_ENTER, TryCatch #3 {Exception -> 0x011b, blocks: (B:46:0x0117, B:47:0x011a, B:30:0x00d3, B:32:0x00d7, B:34:0x00dd, B:36:0x00e3, B:38:0x00e9, B:41:0x0109, B:51:0x00b4), top: B:2:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00dd A[Catch: Exception -> 0x011b, TryCatch #3 {Exception -> 0x011b, blocks: (B:46:0x0117, B:47:0x011a, B:30:0x00d3, B:32:0x00d7, B:34:0x00dd, B:36:0x00e3, B:38:0x00e9, B:41:0x0109, B:51:0x00b4), top: B:2:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void d(com.mbridge.msdk.foundation.entity.CampaignEx r11, int r12) {
        /*
            Method dump skipped, instructions count: 294
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.splash.manager.e.d(com.mbridge.msdk.foundation.entity.CampaignEx, int):void");
    }

    private void e(CampaignEx campaignEx, int i11) {
        if (campaignEx.isDynamicView()) {
            x.a(5, "", campaignEx.getAdZip(), new i(campaignEx), campaignEx);
            return;
        }
        this.f37537r = new j(campaignEx, i11);
        com.mbridge.msdk.foundation.same.report.metrics.c cVar = new com.mbridge.msdk.foundation.same.report.metrics.c();
        cVar.a(297);
        cVar.e(2);
        cVar.a(campaignEx);
        cVar.f(campaignEx.getAabEntity() != null ? campaignEx.getAabEntity().h3c : 0);
        H5DownLoadManager.getInstance().downloadH5Res(cVar, campaignEx.getAdZip(), this.f37537r);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.f37539t = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(CampaignEx campaignEx, int i11) {
        if (campaignEx.isDynamicView()) {
            c.a aVar = new c.a();
            aVar.b(this.f37520a).a(this.f37521b).a(this.f37528i).a(campaignEx).c(this.f37529j).f(this.f37541v);
            try {
                if (!TextUtils.isEmpty(campaignEx.getAdZip())) {
                    Uri parse = Uri.parse(campaignEx.getAdZip());
                    String queryParameter = parse.getQueryParameter("hdbtn");
                    String queryParameter2 = parse.getQueryParameter("alecfc");
                    String queryParameter3 = parse.getQueryParameter("hdinfo");
                    String queryParameter4 = parse.getQueryParameter("shake_show");
                    String queryParameter5 = parse.getQueryParameter("shake_strength");
                    String queryParameter6 = parse.getQueryParameter("shake_time");
                    String queryParameter7 = parse.getQueryParameter("n_logo");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        aVar.b(Integer.parseInt(queryParameter));
                    }
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        aVar.e(Integer.parseInt(queryParameter2));
                    }
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        aVar.a(Integer.parseInt(queryParameter3));
                    }
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        aVar.g(Integer.parseInt(queryParameter4));
                    }
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        aVar.h(Integer.parseInt(queryParameter5));
                    }
                    if (!TextUtils.isEmpty(queryParameter6)) {
                        aVar.i(Integer.parseInt(queryParameter6));
                    }
                    if (!TextUtils.isEmpty(queryParameter7)) {
                        aVar.d(Integer.parseInt(queryParameter7) == 0 ? 0 : 1);
                    }
                }
            } catch (Throwable th2) {
                o0.b(A, th2.getMessage());
            }
            com.mbridge.msdk.splash.manager.c.a().a(this.f37526g, aVar.a(), new k(campaignEx, i11));
        }
    }

    private void g() {
        try {
            int i11 = this.f37539t + 1;
            this.f37539t = i11;
            l lVar = this.f37527h;
            if (lVar != null && i11 <= lVar.y()) {
                return;
            }
            this.f37539t = 0;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(CampaignEx campaignEx, int i11) {
        if (this.f37526g.isH5Ready()) {
            return;
        }
        this.f37526g.setH5Ready(true);
        h(campaignEx, i11);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(CampaignEx campaignEx, int i11) {
        if (!com.mbridge.msdk.splash.manager.d.a(this.f37526g, campaignEx) || this.f37535p) {
            return;
        }
        b();
        if (this.f37534o) {
            com.mbridge.msdk.splash.manager.d.a(campaignEx, this.f37520a);
        }
        this.f37535p = true;
        com.mbridge.msdk.splash.middle.b bVar = this.f37524e;
        if (bVar != null) {
            bVar.a(campaignEx, i11);
        }
    }

    private void i(CampaignEx campaignEx, int i11) {
        MBSplashView mBSplashView = this.f37526g;
        if (mBSplashView != null) {
            mBSplashView.setDynamicView(false);
        }
        if (campaignEx.isDynamicView()) {
            c(campaignEx, i11);
        } else {
            MBSplashView mBSplashView2 = this.f37526g;
            if (mBSplashView2 != null) {
                mBSplashView2.setSplashWebView();
            }
        }
        if (com.mbridge.msdk.splash.manager.d.a(this.f37526g, campaignEx)) {
            h(campaignEx, i11);
        } else {
            a(campaignEx, i11);
        }
    }

    public void a(int i11) {
        this.f37529j = i11;
    }

    public void a(int i11, int i12) {
        this.f37531l = i11;
        this.f37530k = i12;
    }

    public void a(l lVar) {
        this.f37527h = lVar;
    }

    public void a(com.mbridge.msdk.splash.middle.b bVar) {
        this.f37524e = bVar;
    }

    public void a(MBSplashView mBSplashView) {
        this.f37526g = mBSplashView;
    }

    public void a(String str, int i11) {
        this.f37535p = false;
        this.f37532m = str;
        this.f37533n = i11;
        CampaignEx a11 = com.mbridge.msdk.splash.manager.d.a(this.f37526g, this.f37521b, this.f37520a, str, this.f37528i, this.f37529j, false, false);
        long timestamp = a11 != null ? a11.getTimestamp() : 0L;
        if (this.f37527h.t() == 1 && i11 != 1 && a11 != null) {
            i(a11, i11);
            return;
        }
        this.f37534o = true;
        if (i11 == 1) {
            List<Integer> c11 = this.f37527h.c();
            if (c11 == null || c11.size() <= 0) {
                this.f37522c = 30000L;
            } else {
                this.f37522c = c11.get(0).intValue() * 1000;
            }
        } else {
            long j11 = this.f37523d;
            if (j11 <= 0) {
                this.f37522c = this.f37527h.E();
            } else {
                this.f37522c = j11;
            }
        }
        if (this.f37527h == null || timestamp <= 0 || !TextUtils.isEmpty(str)) {
            a(this.f37522c);
            a(this.f37525f, str, i11);
            return;
        }
        if (System.currentTimeMillis() - timestamp <= this.f37527h.v() * 1000) {
            i(a11, i11);
        } else {
            a(this.f37522c);
            a(this.f37525f, str, i11);
        }
    }

    public void a(boolean z10) {
        this.f37528i = z10;
    }

    public void b(int i11) {
        this.f37541v = i11;
    }

    public String c() {
        return com.mbridge.msdk.foundation.same.c.b(this.f37542w);
    }

    public String d() {
        return this.f37540u;
    }

    public void e() {
        if (this.f37524e != null) {
            this.f37524e = null;
        }
        if (this.f37536q != null) {
            this.f37536q = null;
        }
        if (this.f37537r != null) {
            this.f37537r = null;
        }
    }
}
