package com.mbridge.msdk.mbbanner.common.util;

import android.os.Handler;
import android.os.Looper;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.tools.o0;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static final String f36203c = "a";

    /* renamed from: a, reason: collision with root package name */
    private final Handler f36204a = new Handler(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    private boolean f36205b;

    /* renamed from: com.mbridge.msdk.mbbanner.common.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class RunnableC0505a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.listener.b f36206a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f36207b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ CampaignUnit f36208c;

        RunnableC0505a(com.mbridge.msdk.mbbanner.common.listener.b bVar, String str, CampaignUnit campaignUnit) {
            this.f36206a = bVar;
            this.f36207b = str;
            this.f36208c = campaignUnit;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.mbbanner.common.listener.b bVar = this.f36206a;
            if (bVar != null) {
                bVar.a(this.f36207b, this.f36208c, a.this.f36205b);
            }
        }
    }

    /* loaded from: classes5.dex */
    class b implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.listener.b f36210a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.foundation.error.b f36211b;

        b(com.mbridge.msdk.mbbanner.common.listener.b bVar, com.mbridge.msdk.foundation.error.b bVar2) {
            this.f36210a = bVar;
            this.f36211b = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f36210a != null) {
                this.f36211b.a(a.this.f36205b);
                this.f36210a.a(this.f36211b);
            }
        }
    }

    /* loaded from: classes5.dex */
    class c implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.listener.b f36213a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f36214b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f36215c;

        c(com.mbridge.msdk.mbbanner.common.listener.b bVar, String str, int i11) {
            this.f36213a = bVar;
            this.f36214b = str;
            this.f36215c = i11;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.mbridge.msdk.mbbanner.common.listener.b bVar = this.f36213a;
            if (bVar != null) {
                bVar.a(this.f36214b, this.f36215c, a.this.f36205b);
            }
        }
    }

    /* loaded from: classes5.dex */
    class d implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.mbbanner.common.listener.b f36217a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.foundation.error.b f36218b;

        d(com.mbridge.msdk.mbbanner.common.listener.b bVar, com.mbridge.msdk.foundation.error.b bVar2) {
            this.f36217a = bVar;
            this.f36218b = bVar2;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f36217a != null) {
                this.f36218b.a(a.this.f36205b);
                this.f36217a.b(this.f36218b);
            }
        }
    }

    public void a(com.mbridge.msdk.mbbanner.common.listener.b bVar, CampaignUnit campaignUnit, String str) {
        o0.b(f36203c, "postCampaignSuccess unitId=" + str);
        this.f36204a.post(new RunnableC0505a(bVar, str, campaignUnit));
    }

    public void a(com.mbridge.msdk.mbbanner.common.listener.b bVar, com.mbridge.msdk.foundation.error.b bVar2) {
        this.f36204a.post(new b(bVar, bVar2));
    }

    public void a(com.mbridge.msdk.mbbanner.common.listener.b bVar, String str, int i11) {
        o0.b(f36203c, "postResourceSuccess unitId=" + str);
        this.f36204a.post(new c(bVar, str, i11));
    }

    public void a(boolean z10) {
        this.f36205b = z10;
    }

    public void b(com.mbridge.msdk.mbbanner.common.listener.b bVar, com.mbridge.msdk.foundation.error.b bVar2) {
        o0.b(f36203c, "postResourceFail unitId=" + bVar2);
        this.f36204a.post(new d(bVar, bVar2));
    }
}
