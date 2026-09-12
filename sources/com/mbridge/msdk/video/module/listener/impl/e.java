package com.mbridge.msdk.video.module.listener.impl;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.k0;
import com.mbridge.msdk.foundation.tools.o0;

/* loaded from: classes5.dex */
public class e implements com.mbridge.msdk.foundation.same.image.c {

    /* renamed from: a, reason: collision with root package name */
    protected ImageView f39506a;

    /* renamed from: b, reason: collision with root package name */
    private CampaignEx f39507b;

    /* renamed from: c, reason: collision with root package name */
    private String f39508c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f39509a;

        a(String str) {
            this.f39509a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                com.mbridge.msdk.foundation.db.n a11 = com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.g.a(com.mbridge.msdk.foundation.controller.c.m().d()));
                if (e.this.f39507b == null) {
                    o0.a("ImageLoaderListener", "campaign is null");
                    return;
                }
                com.mbridge.msdk.foundation.entity.m mVar = new com.mbridge.msdk.foundation.entity.m();
                mVar.j("2000044");
                mVar.c(k0.s(com.mbridge.msdk.foundation.controller.c.m().d()));
                mVar.b(e.this.f39507b.getId());
                mVar.i(e.this.f39507b.getImageUrl());
                mVar.n(e.this.f39507b.getRequestId());
                mVar.o(e.this.f39507b.getRequestIdNotice());
                mVar.u(e.this.f39508c);
                mVar.m(this.f39509a);
                a11.a(mVar);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public e(ImageView imageView) {
        this.f39506a = imageView;
    }

    public e(ImageView imageView, CampaignEx campaignEx, String str) {
        this.f39506a = imageView;
        this.f39507b = campaignEx;
        this.f39508c = str;
    }

    @Override // com.mbridge.msdk.foundation.same.image.c
    public void onFailedLoad(String str, String str2) {
        a aVar = new a(str);
        if (com.mbridge.msdk.foundation.controller.d.a().e()) {
            com.mbridge.msdk.foundation.same.threadpool.a.b().execute(aVar);
        } else {
            aVar.run();
        }
        o0.b("ImageLoaderListener", "desc:" + str);
    }

    @Override // com.mbridge.msdk.foundation.same.image.c
    public void onSuccessLoad(Bitmap bitmap, String str) {
        try {
            if (bitmap == null) {
                o0.b("ImageLoaderListener", "bitmap=null");
            } else {
                if (this.f39506a == null || bitmap.isRecycled()) {
                    return;
                }
                this.f39506a.setImageBitmap(bitmap);
                this.f39506a.setVisibility(0);
            }
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                th2.printStackTrace();
            }
        }
    }
}
