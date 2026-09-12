package com.mbridge.msdk.timer;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.e;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.l;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.i;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.out.MBSupportMuteAdType;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private long f38534a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f38535b;

    /* renamed from: c, reason: collision with root package name */
    private LinkedList<i> f38536c;

    /* renamed from: d, reason: collision with root package name */
    private LinkedList<i> f38537d;

    /* renamed from: e, reason: collision with root package name */
    private int f38538e;

    /* renamed from: f, reason: collision with root package name */
    private int f38539f;

    /* renamed from: g, reason: collision with root package name */
    private e f38540g;

    /* renamed from: h, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.setting.a f38541h;

    /* renamed from: i, reason: collision with root package name */
    private l f38542i;

    /* renamed from: j, reason: collision with root package name */
    private g f38543j;

    /* renamed from: k, reason: collision with root package name */
    private Handler f38544k;

    /* renamed from: com.mbridge.msdk.timer.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class HandlerC0554a extends Handler {
        HandlerC0554a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (a.this) {
                try {
                    int i11 = message.what;
                    if (i11 != 1) {
                        if (i11 == 2) {
                            a.this.c();
                        }
                    } else {
                        if (a.this.f38535b) {
                            return;
                        }
                        a aVar = a.this;
                        aVar.a(aVar.f38534a);
                        sendMessageDelayed(obtainMessage(1), a.this.f38534a);
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements com.mbridge.msdk.reward.adapter.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.mbridge.msdk.reward.adapter.c f38546a;

        b(com.mbridge.msdk.reward.adapter.c cVar) {
            this.f38546a = cVar;
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public void a(String str, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            a.this.f38544k.sendMessage(a.this.f38544k.obtainMessage(2));
            this.f38546a.a((com.mbridge.msdk.reward.adapter.a) null);
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public void a(List<CampaignEx> list, com.mbridge.msdk.foundation.error.b bVar, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
            a.this.f38544k.sendMessage(a.this.f38544k.obtainMessage(2));
            this.f38546a.a((com.mbridge.msdk.reward.adapter.a) null);
        }

        @Override // com.mbridge.msdk.reward.adapter.a
        public void a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.metrics.c cVar) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        static a f38548a = new a(null);
    }

    private a() {
        this.f38535b = false;
        this.f38536c = new LinkedList<>();
        this.f38537d = new LinkedList<>();
        this.f38538e = 0;
        this.f38539f = 0;
        this.f38544k = new HandlerC0554a();
    }

    /* synthetic */ a(HandlerC0554a handlerC0554a) {
        this();
    }

    public static a a() {
        return c.f38548a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j11) {
        LinkedList<i> linkedList = this.f38536c;
        if (linkedList == null || linkedList.size() <= 0 || this.f38538e == 0 || this.f38536c.size() <= this.f38538e) {
            LinkedList<i> linkedList2 = this.f38537d;
            if (linkedList2 == null || linkedList2.size() <= 0 || this.f38539f == 0 || this.f38537d.size() == this.f38539f) {
                this.f38539f = 0;
                this.f38538e = 0;
                Handler handler = this.f38544k;
                handler.sendMessage(handler.obtainMessage(2));
            }
        }
    }

    private void a(String str, String str2, boolean z10) {
        try {
            Context d11 = com.mbridge.msdk.foundation.controller.c.m().d();
            if (d11 == null) {
                return;
            }
            com.mbridge.msdk.reward.adapter.c cVar = new com.mbridge.msdk.reward.adapter.c(d11, str, str2);
            cVar.d(z10);
            cVar.a(new b(cVar));
            com.mbridge.msdk.foundation.same.report.metrics.c cVar2 = new com.mbridge.msdk.foundation.same.report.metrics.c();
            cVar2.h(SameMD5.getMD5(t0.d()));
            cVar2.m(str2);
            if (z10) {
                cVar2.a(MBSupportMuteAdType.INTERSTITIAL_VIDEO);
            } else {
                cVar2.a(94);
            }
            cVar2.g("0");
            cVar2.e("1");
            cVar.a(1, 8000, false, cVar2);
        } catch (Exception e11) {
            o0.b("LoopTimer", e11.getMessage(), e11);
        }
    }

    private boolean a(i iVar) {
        boolean z10 = false;
        if (iVar == null || TextUtils.isEmpty(iVar.b())) {
            return false;
        }
        String b11 = iVar.b();
        try {
            if (this.f38540g != null) {
                com.mbridge.msdk.videocommon.setting.a aVar = this.f38541h;
                int a11 = this.f38540g.a(b11, aVar != null ? aVar.e() : 0L);
                if (a11 == -1) {
                    a(b11);
                } else if (a11 != 1) {
                }
                try {
                    Handler handler = this.f38544k;
                    handler.sendMessage(handler.obtainMessage(2));
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    o0.b("LoopTimer", th.getMessage(), th);
                    return z10;
                }
            }
            return true;
        } catch (Throwable th3) {
            th = th3;
            z10 = true;
        }
    }

    private void b() {
        if (this.f38543j == null) {
            this.f38543j = g.a(com.mbridge.msdk.foundation.controller.c.m().d());
        }
        if (this.f38542i == null) {
            this.f38542i = l.a(this.f38543j);
        }
        List<i> a11 = this.f38542i.a(MBSupportMuteAdType.INTERSTITIAL_VIDEO);
        if (a11 != null) {
            this.f38537d.addAll(a11);
            for (i iVar : a11) {
                a(iVar.a(), iVar.b());
            }
        }
        List<i> a12 = this.f38542i.a(94);
        if (a12 != null) {
            this.f38536c.addAll(a12);
            for (i iVar2 : a12) {
                b(iVar2.a(), iVar2.b());
            }
        }
        if (this.f38540g == null) {
            this.f38540g = e.a(this.f38543j);
        }
        if (this.f38541h == null) {
            this.f38541h = com.mbridge.msdk.videocommon.setting.b.b().c();
        }
    }

    private void b(String str) {
        l lVar = this.f38542i;
        if (lVar != null) {
            lVar.a(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            LinkedList<i> linkedList = this.f38536c;
            if (linkedList == null || linkedList.size() <= 0 || this.f38538e >= this.f38536c.size()) {
                LinkedList<i> linkedList2 = this.f38537d;
                if (linkedList2 != null && linkedList2.size() > 0 && this.f38539f < this.f38537d.size()) {
                    i iVar = this.f38537d.get(this.f38539f);
                    this.f38539f++;
                    if (a(iVar)) {
                        c(iVar.a(), iVar.b());
                    }
                }
            } else {
                i iVar2 = this.f38536c.get(this.f38538e);
                this.f38538e++;
                if (a(iVar2)) {
                    a(iVar2.a(), iVar2.b(), false);
                }
            }
        } catch (Throwable th2) {
            o0.b("LoopTimer", th2.getMessage(), th2);
        }
    }

    private void c(String str, String str2) {
        a(str, str2, true);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        LinkedList<i> linkedList = this.f38536c;
        if (linkedList == null || !linkedList.contains(str)) {
            LinkedList<i> linkedList2 = this.f38537d;
            if (linkedList2 != null && linkedList2.contains(str)) {
                this.f38537d.remove(str);
            }
        } else {
            this.f38536c.remove(str);
        }
        b(str);
    }

    public void a(String str, String str2) {
        if (this.f38537d.contains(str2)) {
            return;
        }
        this.f38537d.add(new i(str, str2, MBSupportMuteAdType.INTERSTITIAL_VIDEO));
        l lVar = this.f38542i;
        if (lVar != null) {
            lVar.a(str, str2, MBSupportMuteAdType.INTERSTITIAL_VIDEO);
        }
    }

    public void b(long j11) {
        b();
        this.f38534a = j11;
        this.f38535b = false;
        Handler handler = this.f38544k;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f38534a);
    }

    public void b(String str, String str2) {
        if (this.f38536c.contains(str2)) {
            return;
        }
        this.f38536c.add(new i(str, str2, 94));
        l lVar = this.f38542i;
        if (lVar != null) {
            lVar.a(str, str2, 94);
        }
    }
}
