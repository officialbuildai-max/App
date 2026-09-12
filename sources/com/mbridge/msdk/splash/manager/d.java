package com.mbridge.msdk.splash.manager;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.setting.h;
import com.mbridge.msdk.splash.manager.g;
import com.mbridge.msdk.splash.view.MBSplashView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes5.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static int f37515a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static com.mbridge.msdk.foundation.db.e f37516b = com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements com.mbridge.msdk.videocommon.listener.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MBSplashView f37517a;

        a(MBSplashView mBSplashView) {
            this.f37517a = mBSplashView;
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str) {
            this.f37517a.setVideoReady(true);
        }

        @Override // com.mbridge.msdk.videocommon.listener.a
        public void a(String str, String str2) {
            this.f37517a.setVideoReady(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements com.mbridge.msdk.foundation.same.image.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.splash.view.nativeview.a f37518a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ MBSplashView f37519b;

        b(com.mbridge.msdk.splash.view.nativeview.a aVar, MBSplashView mBSplashView) {
            this.f37518a = aVar;
            this.f37519b = mBSplashView;
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
            com.mbridge.msdk.splash.view.nativeview.a aVar = this.f37518a;
            if (aVar != null) {
                aVar.b();
            }
            MBSplashView mBSplashView = this.f37519b;
            if (mBSplashView != null) {
                mBSplashView.setImageReady(false);
            }
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
            com.mbridge.msdk.splash.view.nativeview.a aVar = this.f37518a;
            if (aVar != null) {
                aVar.a();
            }
            MBSplashView mBSplashView = this.f37519b;
            if (mBSplashView != null) {
                mBSplashView.setImageReady(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements com.mbridge.msdk.foundation.same.image.c {
        c() {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onFailedLoad(String str, String str2) {
        }

        @Override // com.mbridge.msdk.foundation.same.image.c
        public void onSuccessLoad(Bitmap bitmap, String str) {
        }
    }

    private static CampaignEx a(CampaignEx campaignEx) {
        if (!TextUtils.isEmpty(campaignEx.getAdZip()) || (!TextUtils.isEmpty(campaignEx.getAdHtml()) && campaignEx.getAdHtml().contains("<MBTPLMARK>"))) {
            campaignEx.setHasMBTplMark(true);
            campaignEx.setIsMraid(false);
        } else {
            campaignEx.setHasMBTplMark(false);
            campaignEx.setIsMraid(true);
        }
        return campaignEx;
    }

    public static CampaignEx a(MBSplashView mBSplashView, String str, String str2, String str3, boolean z10, int i11, boolean z11, boolean z12) {
        if (f37516b == null) {
            f37516b = com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        }
        com.mbridge.msdk.setting.g d11 = h.b().d(com.mbridge.msdk.foundation.controller.c.m().b());
        if (d11 == null) {
            d11 = h.b().a();
        }
        long Z = d11.Z() * 1000;
        long a02 = d11.a0() * 1000;
        a(a02, str2);
        List<CampaignEx> a11 = f37516b.a(str2, 0, 0, f37515a, !TextUtils.isEmpty(str3));
        if (a11 == null || a11.size() <= 0) {
            return null;
        }
        CampaignEx campaignEx = a11.get(0);
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j11 = currentTimeMillis - Z;
        if (!z11) {
            if (((campaignEx.getPlct() <= 0 || (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() < currentTimeMillis) && (campaignEx.getPlct() > 0 || campaignEx.getTimestamp() < j11)) || !a(mBSplashView, campaignEx, str, str2, z10, i11, z12)) {
                return null;
            }
            return a(campaignEx);
        }
        if ((campaignEx.getPlct() > 0 && (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() >= currentTimeMillis) || (campaignEx.getPlct() <= 0 && campaignEx.getTimestamp() >= j11)) {
            if (a(mBSplashView, campaignEx, str, str2, z10, i11, z12)) {
                return a(campaignEx);
            }
            return null;
        }
        if (a(mBSplashView, campaignEx, str, str2, z10, i11, z12) && campaignEx.isSpareOffer(Z, a02)) {
            return a(campaignEx);
        }
        return null;
    }

    private static String a(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return "file:///" + file.getAbsolutePath();
            }
            return "";
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Exception e11) {
                e11.getMessage();
            }
        }
    }

    public static void a(long j11, String str) {
        if (f37516b == null) {
            f37516b = com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        }
        f37516b.a(j11, str);
    }

    public static void a(CampaignEx campaignEx, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        if (f37516b == null) {
            f37516b = com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        }
        f37516b.a(arrayList, str);
    }

    public static void a(MBSplashView mBSplashView, CampaignEx campaignEx, com.mbridge.msdk.splash.view.nativeview.a aVar) {
        com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(campaignEx.getImageUrl(), new b(aVar, mBSplashView));
        if (TextUtils.isEmpty(campaignEx.getIconUrl())) {
            return;
        }
        com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).a(campaignEx.getIconUrl(), new c());
    }

    private static void a(MBSplashView mBSplashView, CampaignEx campaignEx, String str) {
        a aVar = new a(mBSplashView);
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        copyOnWriteArrayList.add(campaignEx);
        com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(com.mbridge.msdk.foundation.controller.c.m().d(), str, copyOnWriteArrayList, 297, aVar);
        if (com.mbridge.msdk.videocommon.download.b.getInstance().b(297, str, campaignEx.isBidCampaign())) {
            mBSplashView.setVideoReady(true);
        } else {
            com.mbridge.msdk.videocommon.download.b.getInstance().load(str);
        }
    }

    private static void a(MBSplashView mBSplashView, String str, CampaignEx campaignEx, String str2, String str3, boolean z10, int i11) {
        g.d dVar = new g.d();
        dVar.c(str3);
        dVar.b(str2);
        dVar.a(campaignEx);
        dVar.a(str);
        dVar.a(z10);
        dVar.a(i11);
        g.a().a(mBSplashView, dVar, null);
    }

    public static boolean a(MBSplashView mBSplashView, CampaignEx campaignEx) {
        if (mBSplashView == null) {
            return false;
        }
        boolean isVideoReady = !TextUtils.isEmpty(campaignEx.getVideoUrlEncode()) ? mBSplashView.isVideoReady() : true;
        if (isVideoReady && !TextUtils.isEmpty(campaignEx.getAdZip())) {
            isVideoReady = mBSplashView.isH5Ready();
        }
        if (isVideoReady && TextUtils.isEmpty(campaignEx.getAdZip()) && !TextUtils.isEmpty(campaignEx.getAdHtml())) {
            isVideoReady = mBSplashView.isH5Ready();
        }
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            isVideoReady = false;
        }
        if (!campaignEx.isDynamicView()) {
            return isVideoReady;
        }
        if (TextUtils.isEmpty(campaignEx.getImageUrl())) {
            return false;
        }
        return mBSplashView.isImageReady();
    }

    public static boolean a(MBSplashView mBSplashView, CampaignEx campaignEx, String str, String str2, boolean z10, int i11, boolean z11) {
        boolean z12;
        if (campaignEx == null) {
            return false;
        }
        mBSplashView.clearResState();
        if (TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            z12 = true;
        } else {
            boolean z13 = mBSplashView.isVideoReady() || com.mbridge.msdk.videocommon.download.b.getInstance().b(297, str2, campaignEx.isBidCampaign());
            if (z13) {
                mBSplashView.setVideoReady(true);
            } else {
                a(mBSplashView, campaignEx, str2);
            }
            z12 = z13;
        }
        if (!TextUtils.isEmpty(campaignEx.getAdZip()) && !mBSplashView.isH5Ready()) {
            String h5ResAddress = H5DownLoadManager.getInstance().getH5ResAddress(campaignEx.getAdZip());
            if (TextUtils.isEmpty(h5ResAddress)) {
                z12 = false;
            } else if (!z11) {
                a(mBSplashView, h5ResAddress, campaignEx, str, str2, z10, i11);
            }
        }
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && !TextUtils.isEmpty(campaignEx.getAdHtml()) && !mBSplashView.isH5Ready()) {
            String a11 = a(campaignEx.getAdHtml());
            if (TextUtils.isEmpty(a11)) {
                z12 = false;
            } else if (!z11) {
                a(mBSplashView, a11, campaignEx, str, str2, z10, i11);
            }
        }
        if (campaignEx.isDynamicView()) {
            if (TextUtils.isEmpty(campaignEx.getImageUrl()) || mBSplashView.isImageReady()) {
                return false;
            }
            if (com.mbridge.msdk.foundation.same.image.b.a(com.mbridge.msdk.foundation.controller.c.m().d()).c(campaignEx.getImageUrl())) {
                mBSplashView.setImageReady(true);
                return true;
            }
            a(mBSplashView, campaignEx, (com.mbridge.msdk.splash.view.nativeview.a) null);
        }
        return z12;
    }

    public static void b(String str) {
        if (f37516b == null) {
            f37516b = com.mbridge.msdk.foundation.db.e.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
        }
        f37516b.a(str, 0, f37515a);
    }
}
