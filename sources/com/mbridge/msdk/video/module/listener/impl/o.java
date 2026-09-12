package com.mbridge.msdk.video.module.listener.impl;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.q0;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import java.util.Map;

/* loaded from: classes5.dex */
public class o extends k {

    /* renamed from: n, reason: collision with root package name */
    private boolean f39539n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f39540o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f39541p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f39542q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f39543r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f39544s;

    /* renamed from: t, reason: collision with root package name */
    protected int f39545t;

    /* renamed from: u, reason: collision with root package name */
    private Map<Integer, String> f39546u;

    /* renamed from: v, reason: collision with root package name */
    private MBridgeVideoView.u f39547v;

    /* renamed from: w, reason: collision with root package name */
    private int f39548w;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Object f39549a;

        a(Object obj) {
            this.f39549a = obj;
        }

        @Override // java.lang.Runnable
        public void run() {
            Object obj = this.f39549a;
            if (obj instanceof String) {
                o.this.b((String) obj);
            }
        }
    }

    public o(CampaignEx campaignEx, com.mbridge.msdk.videocommon.entity.c cVar, com.mbridge.msdk.videocommon.download.a aVar, String str, String str2, com.mbridge.msdk.video.module.listener.a aVar2, int i11, boolean z10) {
        super(campaignEx, aVar, cVar, str, str2, aVar2, i11, z10);
        this.f39544s = false;
        this.f39545t = 0;
        this.f39548w = -1;
        if (this.f39514a) {
            this.f39546u = campaignEx.getAdvImpList();
        }
        this.f39545t = campaignEx.getVideoCompleteTime();
    }

    @Override // com.mbridge.msdk.video.module.listener.impl.k, com.mbridge.msdk.video.module.listener.impl.f, com.mbridge.msdk.video.module.listener.a
    public void a(int i11, Object obj) {
        int i12;
        CampaignEx campaignEx;
        try {
            if (i11 != 2) {
                int i13 = 0;
                if (i11 != 20) {
                    if (i11 != 130) {
                        if (i11 != 6) {
                            if (i11 != 7) {
                                if (i11 == 15) {
                                    j();
                                    h();
                                    i();
                                    if (q0.a().a("i_l_s_t_r_i", false) && !this.f39542q) {
                                        this.f39542q = true;
                                        MBridgeVideoView.u uVar = this.f39547v;
                                        if (uVar != null) {
                                            uVar.a();
                                        }
                                    }
                                    if (obj == null || !(obj instanceof MBridgeVideoView.v)) {
                                        i12 = 0;
                                    } else {
                                        int i14 = ((MBridgeVideoView.v) obj).f39482a;
                                        i13 = ((MBridgeVideoView.v) obj).f39483b;
                                        i12 = i14;
                                    }
                                    if (i13 == 0 && (campaignEx = this.f39515b) != null) {
                                        i13 = campaignEx.getVideoLength();
                                    }
                                    com.mbridge.msdk.video.module.report.b.a(com.mbridge.msdk.foundation.controller.c.m().d(), this.f39515b, i12, i13, this.f39523j);
                                    com.mbridge.msdk.video.module.report.b.a(this.f39515b, this.f39546u, this.f39520g, i12);
                                    if (!this.f39543r) {
                                        this.f39543r = true;
                                        com.mbridge.msdk.video.module.report.b.a(this.f39515b, this.f39520g);
                                    }
                                    if (!this.f39544s) {
                                        int i15 = this.f39545t;
                                        if (i15 != 0) {
                                            i13 = i15;
                                        }
                                        if (i12 >= i13) {
                                            this.f39544s = true;
                                            i11 = 17;
                                        }
                                    }
                                    o0.b("NotifyListener", "onPlayProgress:" + i12);
                                    this.f39548w = i12;
                                } else if (i11 != 16) {
                                    switch (i11) {
                                        case 11:
                                            a();
                                            l();
                                            break;
                                        case 12:
                                            a aVar = new a(obj);
                                            if (com.mbridge.msdk.foundation.controller.d.a().e()) {
                                                com.mbridge.msdk.foundation.same.threadpool.a.b().execute(aVar);
                                            } else {
                                                aVar.run();
                                            }
                                            l();
                                            c();
                                            b();
                                            e();
                                            a();
                                            break;
                                        case 13:
                                            c();
                                            b();
                                            break;
                                    }
                                }
                            } else if (this.f39514a && obj != null && (obj instanceof Integer)) {
                                int intValue = ((Integer) obj).intValue();
                                if (intValue == 2) {
                                    if (!this.f39540o) {
                                        this.f39540o = true;
                                        com.mbridge.msdk.video.module.report.b.e(com.mbridge.msdk.foundation.controller.c.m().d(), this.f39515b);
                                    }
                                } else if (intValue == 1 && !this.f39539n) {
                                    this.f39539n = true;
                                    com.mbridge.msdk.video.module.report.b.f(com.mbridge.msdk.foundation.controller.c.m().d(), this.f39515b);
                                }
                            }
                        }
                    } else if (obj instanceof Integer) {
                        this.f39545t = ((Integer) obj).intValue();
                    }
                } else if (q0.a().a("i_l_s_t_r_i", false) && (obj instanceof MBridgeVideoView.u)) {
                    this.f39547v = (MBridgeVideoView.u) obj;
                }
                this.f39522i.a(i11, obj);
            }
            if (this.f39514a && !this.f39541p) {
                this.f39541p = true;
                l();
                com.mbridge.msdk.video.module.report.b.b(com.mbridge.msdk.foundation.controller.c.m().d(), this.f39515b);
            }
            this.f39522i.a(i11, obj);
        } catch (Throwable th2) {
            o0.b("NotifyListener", th2.getMessage(), th2);
        }
    }
}
