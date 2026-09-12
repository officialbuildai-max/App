package com.mbridge.msdk.video.bt.module;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import com.cloud.tmc.integration.event.EventConstants;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;
import com.iab.omid.library.mmadbridge.adsession.media.InteractionType;
import com.mbridge.msdk.dycreator.baseview.cusview.SoundImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.metrics.e;
import com.mbridge.msdk.foundation.tools.g0;
import com.mbridge.msdk.foundation.tools.o0;
import com.mbridge.msdk.foundation.tools.t0;
import com.mbridge.msdk.foundation.tools.y0;
import com.mbridge.msdk.mbsignalcommon.windvane.f;
import com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener;
import com.mbridge.msdk.playercommon.PlayerErrorConstant;
import com.mbridge.msdk.playercommon.PlayerView;
import com.mbridge.msdk.widget.FeedBackButton;
import java.io.File;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class MBridgeBTVideoView extends BTBaseView {
    private static boolean P;
    private static long Q;
    private com.iab.omid.library.mmadbridge.adsession.b A;
    private com.iab.omid.library.mmadbridge.adsession.a B;
    private com.iab.omid.library.mmadbridge.adsession.media.a C;
    private d D;
    private int E;
    private int F;
    private boolean G;
    private int H;
    private int I;
    private String J;
    private boolean K;
    private boolean L;
    private boolean M;
    private RelativeLayout N;
    private ProgressBar O;

    /* renamed from: p, reason: collision with root package name */
    private PlayerView f38958p;

    /* renamed from: q, reason: collision with root package name */
    private SoundImageView f38959q;

    /* renamed from: r, reason: collision with root package name */
    private TextView f38960r;

    /* renamed from: s, reason: collision with root package name */
    private View f38961s;

    /* renamed from: t, reason: collision with root package name */
    private FeedBackButton f38962t;

    /* renamed from: u, reason: collision with root package name */
    private ImageView f38963u;

    /* renamed from: v, reason: collision with root package name */
    private WebView f38964v;

    /* renamed from: w, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.download.a f38965w;

    /* renamed from: x, reason: collision with root package name */
    private int f38966x;

    /* renamed from: y, reason: collision with root package name */
    private int f38967y;

    /* renamed from: z, reason: collision with root package name */
    private int f38968z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            boolean isSilent = MBridgeBTVideoView.this.f38958p.isSilent();
            if (MBridgeBTVideoView.this.f38964v != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", BTBaseView.f38863n);
                    jSONObject.put("id", MBridgeBTVideoView.this.f38868d);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(CampaignEx.JSON_NATIVE_VIDEO_MUTE, MBridgeBTVideoView.this.E);
                    jSONObject.put("data", jSONObject2);
                    f.a().a(MBridgeBTVideoView.this.f38964v, "onPlayerMuteBtnClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    o0.a("OperateViews", "onPlayerMuteBtnClicked isMute = " + isSilent + " mute = " + MBridgeBTVideoView.this.E);
                } catch (Exception e11) {
                    com.mbridge.msdk.video.bt.component.d.c().a(MBridgeBTVideoView.this.f38964v, e11.getMessage());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MBridgeBTVideoView.this.f38964v != null) {
                BTBaseView.a(MBridgeBTVideoView.this.f38964v, "onPlayerCloseBtnClicked", MBridgeBTVideoView.this.f38868d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (MBridgeBTVideoView.this.C != null) {
                try {
                    MBridgeBTVideoView.this.C.a(InteractionType.CLICK);
                    o0.a("omsdk", "btv adUserInteraction click");
                } catch (Exception e11) {
                    o0.b("omsdk", e11.getMessage());
                }
            }
            if (MBridgeBTVideoView.this.f38964v != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", BTBaseView.f38863n);
                    jSONObject.put("id", MBridgeBTVideoView.this.f38868d);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("x", String.valueOf(view.getX()));
                    jSONObject2.put("y", String.valueOf(view.getY()));
                    jSONObject.put("data", jSONObject2);
                    f.a().a(MBridgeBTVideoView.this.f38964v, "onClicked", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception unused) {
                    com.mbridge.msdk.video.bt.component.d.c().a(MBridgeBTVideoView.this.f38964v, "onClicked", MBridgeBTVideoView.this.f38868d);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class d extends DefaultVideoPlayerStatusListener {

        /* renamed from: a, reason: collision with root package name */
        private MBridgeBTVideoView f38972a;

        /* renamed from: b, reason: collision with root package name */
        private WebView f38973b;

        /* renamed from: c, reason: collision with root package name */
        private com.iab.omid.library.mmadbridge.adsession.media.a f38974c;

        /* renamed from: d, reason: collision with root package name */
        private String f38975d;

        /* renamed from: e, reason: collision with root package name */
        private String f38976e;

        /* renamed from: f, reason: collision with root package name */
        private int f38977f;

        /* renamed from: g, reason: collision with root package name */
        private int f38978g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f38979h;

        /* renamed from: l, reason: collision with root package name */
        private int f38983l;

        /* renamed from: m, reason: collision with root package name */
        private int f38984m;

        /* renamed from: i, reason: collision with root package name */
        private boolean f38980i = false;

        /* renamed from: j, reason: collision with root package name */
        private boolean f38981j = false;

        /* renamed from: k, reason: collision with root package name */
        private boolean f38982k = false;

        /* renamed from: n, reason: collision with root package name */
        private boolean f38985n = false;

        /* renamed from: o, reason: collision with root package name */
        private boolean f38986o = false;

        public d(MBridgeBTVideoView mBridgeBTVideoView, WebView webView, com.iab.omid.library.mmadbridge.adsession.media.a aVar) {
            this.f38972a = mBridgeBTVideoView;
            this.f38973b = webView;
            this.f38974c = aVar;
            if (mBridgeBTVideoView != null) {
                this.f38975d = mBridgeBTVideoView.f38868d;
                this.f38976e = mBridgeBTVideoView.f38867c;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x00a2 A[Catch: Exception -> 0x006a, TryCatch #0 {Exception -> 0x006a, blocks: (B:17:0x002a, B:19:0x0032, B:22:0x003f, B:23:0x0096, B:25:0x00a2, B:27:0x00ac, B:32:0x006c), top: B:16:0x002a }] */
        /* JADX WARN: Removed duplicated region for block: B:31:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void a() {
            /*
                r4 = this;
                java.lang.String r0 = "DefaultVideoPlayerStatusListener"
                com.mbridge.msdk.foundation.tools.q0 r1 = com.mbridge.msdk.foundation.tools.q0.a()
                java.lang.String r2 = "h_c_r_w_p_c"
                r3 = 0
                boolean r1 = r1.a(r2, r3)
                if (r1 != 0) goto L10
                return
            L10:
                int r1 = r4.f38983l
                r2 = 100
                if (r1 == r2) goto Lbd
                int r2 = r4.f38984m
                if (r2 != 0) goto Lbd
                boolean r2 = r4.f38985n
                if (r2 != 0) goto Lbd
                if (r1 == 0) goto Lbd
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r4.f38972a
                if (r1 == 0) goto Lbd
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f38866b
                if (r1 != 0) goto L2a
                goto Lbd
            L2a:
                int r1 = r1.getAdType()     // Catch: java.lang.Exception -> L6a
                r2 = 94
                if (r1 == r2) goto L6c
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r4.f38972a     // Catch: java.lang.Exception -> L6a
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f38866b     // Catch: java.lang.Exception -> L6a
                int r1 = r1.getAdType()     // Catch: java.lang.Exception -> L6a
                r2 = 287(0x11f, float:4.02E-43)
                if (r1 != r2) goto L3f
                goto L6c
            L3f:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6a
                r1.<init>()     // Catch: java.lang.Exception -> L6a
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r4.f38972a     // Catch: java.lang.Exception -> L6a
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.f38866b     // Catch: java.lang.Exception -> L6a
                java.lang.String r2 = r2.getId()     // Catch: java.lang.Exception -> L6a
                r1.append(r2)     // Catch: java.lang.Exception -> L6a
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r4.f38972a     // Catch: java.lang.Exception -> L6a
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.f38866b     // Catch: java.lang.Exception -> L6a
                java.lang.String r2 = r2.getVideoUrlEncode()     // Catch: java.lang.Exception -> L6a
                r1.append(r2)     // Catch: java.lang.Exception -> L6a
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r4.f38972a     // Catch: java.lang.Exception -> L6a
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.f38866b     // Catch: java.lang.Exception -> L6a
                java.lang.String r2 = r2.getBidToken()     // Catch: java.lang.Exception -> L6a
                r1.append(r2)     // Catch: java.lang.Exception -> L6a
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L6a
                goto L96
            L6a:
                r1 = move-exception
                goto Lb2
            L6c:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L6a
                r1.<init>()     // Catch: java.lang.Exception -> L6a
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r4.f38972a     // Catch: java.lang.Exception -> L6a
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.f38866b     // Catch: java.lang.Exception -> L6a
                java.lang.String r2 = r2.getRequestId()     // Catch: java.lang.Exception -> L6a
                r1.append(r2)     // Catch: java.lang.Exception -> L6a
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r4.f38972a     // Catch: java.lang.Exception -> L6a
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.f38866b     // Catch: java.lang.Exception -> L6a
                java.lang.String r2 = r2.getId()     // Catch: java.lang.Exception -> L6a
                r1.append(r2)     // Catch: java.lang.Exception -> L6a
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r2 = r4.f38972a     // Catch: java.lang.Exception -> L6a
                com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.f38866b     // Catch: java.lang.Exception -> L6a
                java.lang.String r2 = r2.getVideoUrlEncode()     // Catch: java.lang.Exception -> L6a
                r1.append(r2)     // Catch: java.lang.Exception -> L6a
                java.lang.String r1 = r1.toString()     // Catch: java.lang.Exception -> L6a
            L96:
                com.mbridge.msdk.videocommon.download.b r2 = com.mbridge.msdk.videocommon.download.b.getInstance()     // Catch: java.lang.Exception -> L6a
                java.lang.String r3 = r4.f38976e     // Catch: java.lang.Exception -> L6a
                com.mbridge.msdk.videocommon.download.a r1 = r2.a(r3, r1)     // Catch: java.lang.Exception -> L6a
                if (r1 == 0) goto Lbd
                r1.v()     // Catch: java.lang.Exception -> L6a
                r1 = 1
                r4.f38985n = r1     // Catch: java.lang.Exception -> L6a
                boolean r1 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch: java.lang.Exception -> L6a
                if (r1 == 0) goto Lbd
                java.lang.String r1 = "CDRate is : 0  and start download when player create!"
                com.mbridge.msdk.foundation.tools.o0.b(r0, r1)     // Catch: java.lang.Exception -> L6a
                goto Lbd
            Lb2:
                boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
                if (r2 == 0) goto Lbd
                java.lang.String r1 = r1.getMessage()
                com.mbridge.msdk.foundation.tools.o0.b(r0, r1)
            Lbd:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.d.a():void");
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0093 A[Catch: Exception -> 0x005b, TRY_LEAVE, TryCatch #0 {Exception -> 0x005b, blocks: (B:3:0x0002, B:5:0x0008, B:10:0x000f, B:12:0x0013, B:14:0x0017, B:16:0x0023, B:19:0x0030, B:20:0x0087, B:22:0x0093, B:26:0x005d), top: B:2:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void a(int r5, int r6) {
            /*
                r4 = this;
                java.lang.String r0 = "DefaultVideoPlayerStatusListener"
                int r1 = r4.f38983l     // Catch: java.lang.Exception -> L5b
                r2 = 100
                if (r1 == r2) goto Lba
                boolean r3 = r4.f38985n     // Catch: java.lang.Exception -> L5b
                if (r3 != 0) goto Lba
                if (r1 != 0) goto Lf
                return
            Lf:
                int r1 = r4.f38984m     // Catch: java.lang.Exception -> L5b
                if (r1 < 0) goto Lba
                int r6 = r6 * r1
                int r6 = r6 / r2
                if (r5 < r6) goto Lba
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r5 = r4.f38972a     // Catch: java.lang.Exception -> L5b
                com.mbridge.msdk.foundation.entity.CampaignEx r5 = r5.f38866b     // Catch: java.lang.Exception -> L5b
                int r5 = r5.getAdType()     // Catch: java.lang.Exception -> L5b
                r1 = 94
                if (r5 == r1) goto L5d
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r5 = r4.f38972a     // Catch: java.lang.Exception -> L5b
                com.mbridge.msdk.foundation.entity.CampaignEx r5 = r5.f38866b     // Catch: java.lang.Exception -> L5b
                int r5 = r5.getAdType()     // Catch: java.lang.Exception -> L5b
                r1 = 287(0x11f, float:4.02E-43)
                if (r5 != r1) goto L30
                goto L5d
            L30:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5b
                r5.<init>()     // Catch: java.lang.Exception -> L5b
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r4.f38972a     // Catch: java.lang.Exception -> L5b
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f38866b     // Catch: java.lang.Exception -> L5b
                java.lang.String r1 = r1.getId()     // Catch: java.lang.Exception -> L5b
                r5.append(r1)     // Catch: java.lang.Exception -> L5b
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r4.f38972a     // Catch: java.lang.Exception -> L5b
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f38866b     // Catch: java.lang.Exception -> L5b
                java.lang.String r1 = r1.getVideoUrlEncode()     // Catch: java.lang.Exception -> L5b
                r5.append(r1)     // Catch: java.lang.Exception -> L5b
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r4.f38972a     // Catch: java.lang.Exception -> L5b
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f38866b     // Catch: java.lang.Exception -> L5b
                java.lang.String r1 = r1.getBidToken()     // Catch: java.lang.Exception -> L5b
                r5.append(r1)     // Catch: java.lang.Exception -> L5b
                java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L5b
                goto L87
            L5b:
                r5 = move-exception
                goto Lb3
            L5d:
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5b
                r5.<init>()     // Catch: java.lang.Exception -> L5b
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r4.f38972a     // Catch: java.lang.Exception -> L5b
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f38866b     // Catch: java.lang.Exception -> L5b
                java.lang.String r1 = r1.getRequestId()     // Catch: java.lang.Exception -> L5b
                r5.append(r1)     // Catch: java.lang.Exception -> L5b
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r4.f38972a     // Catch: java.lang.Exception -> L5b
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f38866b     // Catch: java.lang.Exception -> L5b
                java.lang.String r1 = r1.getId()     // Catch: java.lang.Exception -> L5b
                r5.append(r1)     // Catch: java.lang.Exception -> L5b
                com.mbridge.msdk.video.bt.module.MBridgeBTVideoView r1 = r4.f38972a     // Catch: java.lang.Exception -> L5b
                com.mbridge.msdk.foundation.entity.CampaignEx r1 = r1.f38866b     // Catch: java.lang.Exception -> L5b
                java.lang.String r1 = r1.getVideoUrlEncode()     // Catch: java.lang.Exception -> L5b
                r5.append(r1)     // Catch: java.lang.Exception -> L5b
                java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L5b
            L87:
                com.mbridge.msdk.videocommon.download.b r1 = com.mbridge.msdk.videocommon.download.b.getInstance()     // Catch: java.lang.Exception -> L5b
                java.lang.String r2 = r4.f38976e     // Catch: java.lang.Exception -> L5b
                com.mbridge.msdk.videocommon.download.a r5 = r1.a(r2, r5)     // Catch: java.lang.Exception -> L5b
                if (r5 == 0) goto Lba
                r5.v()     // Catch: java.lang.Exception -> L5b
                r5 = 1
                r4.f38985n = r5     // Catch: java.lang.Exception -> L5b
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L5b
                r5.<init>()     // Catch: java.lang.Exception -> L5b
                java.lang.String r1 = "CDRate is : "
                r5.append(r1)     // Catch: java.lang.Exception -> L5b
                r5.append(r6)     // Catch: java.lang.Exception -> L5b
                java.lang.String r6 = " and start download !"
                r5.append(r6)     // Catch: java.lang.Exception -> L5b
                java.lang.String r5 = r5.toString()     // Catch: java.lang.Exception -> L5b
                com.mbridge.msdk.foundation.tools.o0.b(r0, r5)     // Catch: java.lang.Exception -> L5b
                goto Lba
            Lb3:
                java.lang.String r5 = r5.getMessage()
                com.mbridge.msdk.foundation.tools.o0.b(r0, r5)
            Lba:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.video.bt.module.MBridgeBTVideoView.d.a(int, int):void");
        }

        public void b(int i11, int i12) {
            this.f38983l = i11;
            this.f38984m = i12;
            a();
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onBufferingEnd() {
            try {
                super.onBufferingEnd();
                if (this.f38974c == null || !this.f38986o) {
                    return;
                }
                o0.b("omsdk", "bt onBufferingEnd");
                this.f38986o = false;
                this.f38974c.b();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onBufferingStart(String str) {
            try {
                o0.b("omsdk", "bt onBufferingStart1");
                super.onBufferingStart(str);
                if (this.f38974c != null) {
                    o0.b("omsdk", "bt onBufferingStart");
                    this.f38974c.c();
                    this.f38986o = true;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onBufferingTimeOut(String str) {
            try {
                if (!str.equals(PlayerErrorConstant.PREPARE_TIMEOUT) && !str.equals(PlayerErrorConstant.PLAYERING_TIMEOUT)) {
                    return;
                }
                if (this.f38973b != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("code", BTBaseView.f38863n);
                        jSONObject.put("id", this.f38975d);
                        jSONObject.put("data", new JSONObject());
                        f.a().a(this.f38973b, "onPlayerTimeout", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                    } catch (Exception e11) {
                        com.mbridge.msdk.video.bt.component.d.c().a(this.f38973b, e11.getMessage());
                    }
                }
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onPlayCompleted() {
            super.onPlayCompleted();
            MBridgeBTVideoView mBridgeBTVideoView = this.f38972a;
            CampaignEx campaignEx = mBridgeBTVideoView.f38866b;
            if (campaignEx == null) {
                mBridgeBTVideoView.f38960r.setText("0");
            } else if (campaignEx.getVideoCompleteTime() > 0) {
                this.f38972a.f38960r.setText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_complete", "string"));
            } else {
                this.f38972a.f38960r.setText("0");
            }
            this.f38972a.f38958p.setClickable(false);
            WebView webView = this.f38973b;
            if (webView != null) {
                BTBaseView.a(webView, "onPlayerFinish", this.f38975d);
            }
            com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f38974c;
            if (aVar != null) {
                aVar.d();
                o0.a("omsdk", "play:  videoEvents.complete()");
            }
            this.f38977f = this.f38978g;
            boolean unused = MBridgeBTVideoView.P = true;
            this.f38972a.stop();
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onPlayError(String str) {
            super.onPlayError(str);
            if (this.f38973b != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", BTBaseView.f38864o);
                    jSONObject.put("id", this.f38975d);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("error", str);
                    jSONObject2.put("id", this.f38975d);
                    jSONObject.put("data", jSONObject2);
                    f.a().a(this.f38973b, "onPlayerFailed", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e11) {
                    com.mbridge.msdk.video.bt.component.d.c().a(this.f38973b, e11.getMessage());
                }
            }
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onPlayProgress(int i11, int i12) {
            int i13;
            StringBuilder sb2;
            String str;
            String sb3;
            super.onPlayProgress(i11, i12);
            if (MBridgeBTVideoView.Q == 0) {
                long unused = MBridgeBTVideoView.Q = System.currentTimeMillis();
            }
            MBridgeBTVideoView mBridgeBTVideoView = this.f38972a;
            if (mBridgeBTVideoView.f38872h) {
                CampaignEx campaignEx = mBridgeBTVideoView.f38866b;
                if (campaignEx != null) {
                    i13 = campaignEx.getVideoCompleteTime();
                    com.mbridge.msdk.foundation.feedback.b.b().b(this.f38972a.f38866b.getCampaignUnitId() + "_1", i11);
                } else {
                    i13 = 0;
                }
                if (i13 > i12 || i13 <= 0) {
                    i13 = i12;
                }
                int i14 = i13 <= 0 ? i12 - i11 : i13 - i11;
                if (i14 <= 0) {
                    sb3 = i13 <= 0 ? "0" : (String) this.f38972a.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_complete", "string"));
                } else {
                    if (i13 <= 0) {
                        sb2 = new StringBuilder();
                        sb2.append(i14);
                        str = "";
                    } else {
                        sb2 = new StringBuilder();
                        sb2.append(i14);
                        str = (String) this.f38972a.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_left", "string"));
                    }
                    sb2.append(str);
                    sb3 = sb2.toString();
                }
                CampaignEx campaignEx2 = this.f38972a.f38866b;
                if (campaignEx2 != null && campaignEx2.getUseSkipTime() == 1) {
                    int min = Math.min(this.f38972a.f38866b.getVst(), i12);
                    if (min >= i13 || min < 0) {
                        int i15 = i13 - i11;
                        if (this.f38972a.f38866b.getAdType() == 287) {
                            if (i15 > 0) {
                                sb3 = i15 + ((String) this.f38972a.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_left_skip_time", "string")));
                            } else if (i15 == 0) {
                                this.f38972a.f38960r.setVisibility(4);
                            }
                        }
                    } else {
                        int i16 = min - i11;
                        if (i16 > 0) {
                            sb3 = i16 + ((String) this.f38972a.getContext().getResources().getText(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_view_reward_time_left_skip_time", "string")));
                        } else if (this.f38972a.f38866b.getAdType() == 287 && i16 == 0) {
                            this.f38972a.f38960r.setVisibility(4);
                        }
                    }
                }
                this.f38972a.f38960r.setText(sb3);
            }
            this.f38978g = i12;
            this.f38977f = i11;
            this.f38972a.O.setMax(this.f38978g);
            this.f38972a.O.setProgress(this.f38977f);
            if (this.f38973b != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", BTBaseView.f38863n);
                    jSONObject.put("id", this.f38975d);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("id", this.f38975d);
                    jSONObject2.put(NotificationCompat.CATEGORY_PROGRESS, MBridgeBTVideoView.b(i11, i12));
                    jSONObject2.put(EventConstants.KEY_TIME, String.valueOf(i11));
                    jSONObject2.put("duration", String.valueOf(i12));
                    jSONObject.put("data", jSONObject2);
                    f.a().a(this.f38973b, "onPlayerProgressChanged", Base64.encodeToString(jSONObject.toString().getBytes(), 2));
                } catch (Exception e11) {
                    com.mbridge.msdk.video.bt.component.d.c().a(this.f38973b, e11.getMessage());
                }
            }
            com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.f38974c;
            if (aVar != null) {
                int i17 = (i11 * 100) / i12;
                int i18 = ((i11 + 1) * 100) / i12;
                if (i17 <= 25 && 25 < i18 && !this.f38980i) {
                    this.f38980i = true;
                    aVar.h();
                    o0.a("omsdk", "play:  videoEvents.firstQuartile()");
                } else if (i17 <= 50 && 50 < i18 && !this.f38981j) {
                    this.f38981j = true;
                    aVar.i();
                    o0.a("omsdk", "play:  videoEvents.midpoint()");
                } else if (i17 <= 75 && 75 < i18 && !this.f38982k) {
                    this.f38982k = true;
                    aVar.o();
                    o0.a("omsdk", "play:  videoEvents.thirdQuartile()");
                }
            }
            a(i11, i12);
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onPlaySetDataSourceError(String str) {
            super.onPlaySetDataSourceError(str);
        }

        @Override // com.mbridge.msdk.playercommon.DefaultVideoPlayerStatusListener, com.mbridge.msdk.playercommon.VideoPlayerStatusListener
        public void onPlayStarted(int i11) {
            super.onPlayStarted(i11);
            if (!this.f38979h) {
                this.f38972a.O.setMax(i11);
                WebView webView = this.f38973b;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerPlay", this.f38975d);
                }
                this.f38979h = true;
                if (this.f38974c != null) {
                    try {
                        MBridgeBTVideoView mBridgeBTVideoView = this.f38972a;
                        this.f38974c.n(i11, (mBridgeBTVideoView == null || mBridgeBTVideoView.f38958p == null) ? 0.0f : this.f38972a.f38958p.getVolume());
                        o0.a("omsdk", "play2: videoEvents.start()");
                    } catch (Exception e11) {
                        o0.b("omsdk", e11.getMessage());
                    }
                }
            }
            boolean unused = MBridgeBTVideoView.P = false;
        }
    }

    public MBridgeBTVideoView(Context context) {
        super(context);
        this.f38966x = 0;
        this.f38967y = 0;
        this.f38968z = 0;
        this.E = 2;
        this.G = false;
        this.H = 2;
        this.I = 1;
        this.K = false;
        this.L = false;
        this.M = false;
    }

    public MBridgeBTVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38966x = 0;
        this.f38967y = 0;
        this.f38968z = 0;
        this.E = 2;
        this.G = false;
        this.H = 2;
        this.I = 1;
        this.K = false;
        this.L = false;
        this.M = false;
    }

    private int a(CampaignEx campaignEx) {
        if (campaignEx != null && campaignEx.getReady_rate() != -1) {
            return campaignEx.getReady_rate();
        }
        return com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.f38867c, false).w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i11, int i12) {
        if (i12 != 0) {
            try {
                return t0.a(Double.valueOf(i11 / i12)) + "";
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return i12 + "";
    }

    private void d() {
        String str;
        if (this.f38866b.getAdType() == 94 || this.f38866b.getAdType() == 287) {
            str = this.f38866b.getRequestId() + this.f38866b.getId() + this.f38866b.getVideoUrlEncode();
        } else {
            str = this.f38866b.getId() + this.f38866b.getVideoUrlEncode() + this.f38866b.getBidToken();
        }
        com.mbridge.msdk.videocommon.download.a a11 = com.mbridge.msdk.videocommon.download.b.getInstance().a(this.f38867c, str);
        if (a11 != null) {
            this.f38965w = a11;
        }
    }

    private boolean e() {
        try {
            this.f38958p = (PlayerView) findViewById(findID("mbridge_vfpv"));
            this.f38959q = (SoundImageView) findViewById(findID("mbridge_sound_switch"));
            this.f38960r = (TextView) findViewById(findID("mbridge_tv_count"));
            this.f38961s = findViewById(findID("mbridge_rl_playing_close"));
            this.N = (RelativeLayout) findViewById(findID("mbridge_top_control"));
            this.O = (ProgressBar) findViewById(findID("mbridge_video_progress_bar"));
            this.f38958p.setIsBTVideo(true);
            this.f38962t = (FeedBackButton) findViewById(findID("mbridge_native_endcard_feed_btn"));
            this.f38963u = (ImageView) findViewById(findID("mbridge_iv_link"));
            return isNotNULL(this.f38958p, this.f38959q, this.f38960r, this.f38961s);
        } catch (Throwable th2) {
            o0.b(BTBaseView.TAG, th2.getMessage(), th2);
            return false;
        }
    }

    private int getBufferTimeout() {
        try {
            com.mbridge.msdk.videocommon.setting.a c11 = com.mbridge.msdk.videocommon.setting.b.b().c();
            if (c11 == null) {
                com.mbridge.msdk.videocommon.setting.b.b().a();
            }
            r0 = c11 != null ? (int) c11.i() : 5;
            o0.c(BTBaseView.TAG, "MBridgeBaseView buffetTimeout:" + r0);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return r0;
    }

    private int getCDRate() {
        return com.mbridge.msdk.videocommon.setting.b.b().a(com.mbridge.msdk.foundation.controller.c.m().b(), this.f38867c, false).g();
    }

    private String getPlayURL() {
        String str = "";
        try {
            str = this.f38866b.getVideoUrlEncode();
            com.mbridge.msdk.videocommon.download.a aVar = this.f38965w;
            if (aVar == null) {
                return str;
            }
            String k11 = aVar.k();
            return !y0.a(k11) ? new File(k11).exists() ? k11 : str : str;
        } catch (Throwable th2) {
            o0.b(BTBaseView.TAG, th2.getMessage(), th2);
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void b() {
        super.b();
        if (this.f38872h) {
            this.f38959q.setOnClickListener(new a());
            this.f38961s.setOnClickListener(new b());
            setOnClickListener(new c());
        }
    }

    public com.iab.omid.library.mmadbridge.adsession.a getAdEvents() {
        return this.B;
    }

    public com.iab.omid.library.mmadbridge.adsession.b getAdSession() {
        return this.A;
    }

    public int getMute() {
        return this.E;
    }

    public com.iab.omid.library.mmadbridge.adsession.media.a getVideoEvents() {
        return this.C;
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void init(Context context) {
        int findLayout = findLayout("mbridge_reward_videoview_item");
        if (g0.a(findLayout)) {
            this.f38870f.inflate(findLayout, this);
            boolean e11 = e();
            this.f38872h = e11;
            if (!e11) {
                o0.b(BTBaseView.TAG, "MBridgeVideoView init fail");
            }
            b();
        }
        P = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        View rootView;
        super.onAttachedToWindow();
        if (!this.M) {
            this.H = com.mbridge.msdk.video.bt.component.d.c().g(this.f38867c);
        }
        View view = this.f38961s;
        if (view != null) {
            view.setVisibility(this.f38967y == 0 ? 8 : 0);
        }
        SoundImageView soundImageView = this.f38959q;
        if (soundImageView != null) {
            soundImageView.setVisibility(this.f38968z == 0 ? 8 : 0);
        }
        CampaignEx campaignEx = this.f38866b;
        if (campaignEx != null) {
            campaignEx.setCampaignUnitId(this.f38867c);
            com.mbridge.msdk.foundation.feedback.b.b().a(this.f38867c + "_1", this.f38866b);
        }
        TextView textView = this.f38960r;
        if (textView != null) {
            textView.setVisibility(this.f38966x == 0 ? 8 : 0);
            if (this.f38960r.getVisibility() == 0 && com.mbridge.msdk.foundation.feedback.b.b().a()) {
                com.mbridge.msdk.foundation.feedback.b.b().a(this.f38867c + "_1", this.f38962t);
            }
        }
        if (this.A == null || (rootView = getRootView()) == null) {
            return;
        }
        this.A.f(rootView);
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void onDestory() {
        try {
            if (this.f38958p != null) {
                com.iab.omid.library.mmadbridge.adsession.b bVar = this.A;
                if (bVar != null) {
                    bVar.c();
                }
                this.f38958p.setOnClickListener(null);
                this.f38958p.release();
                this.f38958p = null;
                if (!TextUtils.isEmpty(this.J)) {
                    e eVar = new e();
                    long j11 = Q;
                    if (j11 != 0) {
                        j11 = System.currentTimeMillis() - Q;
                    }
                    eVar.a("duration", Long.valueOf(j11));
                    com.mbridge.msdk.foundation.same.report.metrics.d.b().a("2000146", this.f38866b, eVar);
                }
            }
            SoundImageView soundImageView = this.f38959q;
            if (soundImageView != null) {
                soundImageView.setOnClickListener(null);
            }
            View view = this.f38961s;
            if (view != null) {
                view.setOnClickListener(null);
            }
            if (this.f38964v != null) {
                this.f38964v = null;
            }
            if (this.A != null) {
                this.A = null;
            }
            if (this.C != null) {
                this.C = null;
            }
            setOnClickListener(null);
        } catch (Throwable th2) {
            o0.a(BTBaseView.TAG, th2.getMessage());
        }
    }

    public void onPause() {
        PlayerView playerView = this.f38958p;
        if (playerView != null) {
            boolean isPlayIng = playerView.isPlayIng();
            this.L = isPlayIng;
            this.f38958p.setIsBTVideoPlaying(isPlayIng);
            com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.C;
            if (aVar != null) {
                this.f38958p.setVideoEvents(aVar);
            }
            this.f38958p.onPause();
        }
    }

    public void onResume() {
        PlayerView playerView = this.f38958p;
        if (playerView != null) {
            playerView.setDesk(true);
            this.f38958p.setIsCovered(false);
            if (this.L) {
                this.f38958p.start(true);
            }
            this.f38958p.resumeOMSDK();
        }
    }

    public void onStop() {
        PlayerView playerView = this.f38958p;
        if (playerView != null) {
            playerView.setIsCovered(true);
        }
    }

    public void pause() {
        try {
            PlayerView playerView = this.f38958p;
            if (playerView != null) {
                playerView.pause();
                WebView webView = this.f38964v;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerPause", this.f38868d);
                }
            }
        } catch (Exception e11) {
            o0.b(BTBaseView.TAG, e11.getMessage(), e11);
        }
    }

    public void play() {
        d dVar;
        try {
            if (this.M) {
                if (this.G) {
                    this.f38958p.playVideo(0);
                    this.G = false;
                } else {
                    this.f38958p.start(false);
                }
                try {
                    com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.C;
                    if (aVar != null) {
                        aVar.l();
                        o0.a("omsdk", "btv play2:  videoEvents.resume()");
                    }
                } catch (Throwable th2) {
                    o0.a(BTBaseView.TAG, th2.getMessage());
                }
                WebView webView = this.f38964v;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerPlay", this.f38868d);
                    return;
                }
                return;
            }
            String playURL = getPlayURL();
            this.J = playURL;
            this.f38958p.initVFPData(playURL, this.f38866b.getVideoUrlEncode(), this.D);
            if (this.H == 1) {
                playMute();
            } else {
                playUnMute();
            }
            try {
                if (this.B != null) {
                    o0.b("omsdk", "bt impressionOccurred");
                    this.B.b();
                }
            } catch (Throwable th3) {
                o0.a(BTBaseView.TAG, th3.getMessage());
            }
            if (!this.f38958p.playVideo() && (dVar = this.D) != null) {
                dVar.onPlayError("play video failed");
            }
            this.M = true;
            return;
        } catch (Exception e11) {
            o0.b(BTBaseView.TAG, e11.getMessage(), e11);
        }
        o0.b(BTBaseView.TAG, e11.getMessage(), e11);
    }

    public boolean playMute() {
        try {
            PlayerView playerView = this.f38958p;
            if (playerView != null && this.f38964v != null) {
                playerView.closeSound();
                this.f38959q.setSoundStatus(false);
                this.E = 1;
                try {
                    com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.C;
                    if (aVar != null) {
                        aVar.p(0.0f);
                    }
                } catch (Exception e11) {
                    o0.a("OMSDK", e11.getMessage());
                }
                BTBaseView.a(this.f38964v, "onPlayerMute", this.f38868d);
                return true;
            }
        } catch (Exception e12) {
            o0.b(BTBaseView.TAG, e12.getMessage());
        }
        return false;
    }

    public boolean playUnMute() {
        try {
            PlayerView playerView = this.f38958p;
            if (playerView == null || this.f38964v == null) {
                return false;
            }
            playerView.openSound();
            this.f38959q.setSoundStatus(true);
            this.E = 2;
            try {
                com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.C;
                if (aVar != null) {
                    aVar.p(1.0f);
                }
            } catch (Exception e11) {
                o0.a("OMSDK", e11.getMessage());
            }
            BTBaseView.a(this.f38964v, "onUnmute", this.f38868d);
            return true;
        } catch (Exception e12) {
            o0.b(BTBaseView.TAG, e12.getMessage());
            return false;
        }
    }

    public void preLoadData() {
        d();
        this.F = getBufferTimeout();
        String playURL = getPlayURL();
        this.J = playURL;
        if (this.f38872h && !TextUtils.isEmpty(playURL) && this.f38866b != null) {
            com.iab.omid.library.mmadbridge.adsession.b bVar = this.A;
            if (bVar != null) {
                bVar.d(this.f38958p);
                com.iab.omid.library.mmadbridge.adsession.b bVar2 = this.A;
                SoundImageView soundImageView = this.f38959q;
                FriendlyObstructionPurpose friendlyObstructionPurpose = FriendlyObstructionPurpose.OTHER;
                bVar2.a(soundImageView, friendlyObstructionPurpose, null);
                this.A.a(this.f38960r, friendlyObstructionPurpose, null);
                this.A.a(this.f38961s, FriendlyObstructionPurpose.VIDEO_CONTROLS, null);
            }
            d dVar = new d(this, this.f38964v, this.C);
            this.D = dVar;
            dVar.b(a(this.f38866b), getCDRate());
            this.f38958p.setDesk(false);
            this.f38958p.initBufferIngParam(this.F);
            soundOperate(this.E, -1, null);
        }
        P = false;
    }

    public void resume() {
        try {
            PlayerView playerView = this.f38958p;
            if (playerView != null) {
                if (this.G) {
                    playerView.playVideo(0);
                    this.G = false;
                } else {
                    playerView.onResume();
                }
                try {
                    com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.C;
                    if (aVar != null) {
                        aVar.l();
                        o0.a("omsdk", "btv play3:  videoEvents.resume()");
                    }
                } catch (Throwable th2) {
                    o0.a(BTBaseView.TAG, th2.getMessage());
                }
                WebView webView = this.f38964v;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerResume", this.f38868d);
                }
            }
        } catch (Exception e11) {
            o0.b(BTBaseView.TAG, e11.getMessage());
        }
    }

    public void setAdEvents(com.iab.omid.library.mmadbridge.adsession.a aVar) {
        this.B = aVar;
    }

    public void setAdSession(com.iab.omid.library.mmadbridge.adsession.b bVar) {
        this.A = bVar;
    }

    @Override // com.mbridge.msdk.video.bt.module.BTBaseView
    public void setCampaign(CampaignEx campaignEx) {
        super.setCampaign(campaignEx);
        if (campaignEx == null || campaignEx.getVideoCompleteTime() <= 0) {
            this.f38960r.setBackgroundResource(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_shape_progress", "drawable"));
            this.f38960r.setWidth(t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 30.0f));
            return;
        }
        this.f38960r.setBackgroundResource(g0.a(com.mbridge.msdk.foundation.controller.c.m().d(), "mbridge_reward_video_time_count_num_bg", "drawable"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 30.0f));
        int a11 = t0.a(com.mbridge.msdk.foundation.controller.c.m().d(), 5.0f);
        layoutParams.setMargins(a11, 0, 0, 0);
        this.f38960r.setPadding(a11, 0, a11, 0);
        this.f38960r.setLayoutParams(layoutParams);
    }

    public void setCloseViewVisable(int i11) {
        this.f38961s.setVisibility(i11 == 0 ? 4 : 0);
    }

    public void setCountDownTextViewVisable(int i11) {
        this.f38960r.setVisibility(i11 == 0 ? 4 : 0);
    }

    public void setCreateWebView(WebView webView) {
        this.f38964v = webView;
    }

    public void setNotchPadding(int i11, int i12, int i13, int i14) {
        if (i11 <= 0) {
            i11 = this.N.getPaddingLeft();
        }
        if (i12 <= 0) {
            i12 = this.N.getPaddingRight();
        }
        if (i13 <= 0) {
            i13 = this.N.getPaddingTop();
        }
        if (i14 <= 0) {
            i14 = this.N.getPaddingBottom();
        }
        o0.b(BTBaseView.TAG, "NOTCH BTVideoView " + String.format("%1s-%2s-%3s-%4s", Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14)));
        this.N.setPadding(i11, i13, i12, i14);
    }

    public void setOrientation(int i11) {
        this.I = i11;
    }

    public void setPlaybackParams(float f11) {
        PlayerView playerView = this.f38958p;
        if (playerView != null) {
            playerView.setPlaybackParams(f11);
        }
    }

    public void setProgressBarState(int i11) {
        ProgressBar progressBar = this.O;
        if (progressBar != null) {
            progressBar.setVisibility(i11 == 0 ? 8 : 0);
            CampaignEx campaignEx = this.f38866b;
            if (campaignEx == null || campaignEx.getProgressBarShow() != 1) {
                return;
            }
            this.O.setVisibility(0);
        }
    }

    public void setShowClose(int i11) {
        this.f38967y = i11;
    }

    public void setShowMute(int i11) {
        this.f38968z = i11;
    }

    public void setShowTime(int i11) {
        this.f38966x = i11;
    }

    public void setSoundImageViewVisble(int i11) {
        this.f38959q.setVisibility(i11 == 0 ? 4 : 0);
    }

    public void setVideoEvents(com.iab.omid.library.mmadbridge.adsession.media.a aVar) {
        this.C = aVar;
        d dVar = this.D;
        if (dVar != null) {
            dVar.f38974c = aVar;
        }
        PlayerView playerView = this.f38958p;
        if (playerView != null) {
            playerView.setVideoEvents(aVar);
        }
    }

    public void setVolume(float f11, float f12) {
        PlayerView playerView = this.f38958p;
        if (playerView != null) {
            playerView.setVolume(f11, f12);
        }
    }

    public void soundOperate(int i11, int i12, String str) {
        if (this.f38872h) {
            this.E = i11;
            if (i11 == 1) {
                this.f38959q.setSoundStatus(false);
                this.f38958p.closeSound();
            } else if (i11 == 2) {
                this.f38959q.setSoundStatus(true);
                this.f38958p.openSound();
            }
            if (i12 == 1) {
                this.f38959q.setVisibility(8);
            } else if (i12 == 2) {
                this.f38959q.setVisibility(0);
            }
            com.iab.omid.library.mmadbridge.adsession.media.a aVar = this.C;
            if (aVar != null) {
                try {
                    aVar.p(this.f38958p.getVolume());
                } catch (Exception e11) {
                    o0.b("omsdk", e11.getMessage());
                }
            }
        }
    }

    public void stop() {
        try {
            PlayerView playerView = this.f38958p;
            if (playerView != null) {
                playerView.pause();
                this.f38958p.stop();
                this.G = true;
                WebView webView = this.f38964v;
                if (webView != null) {
                    BTBaseView.a(webView, "onPlayerStop", this.f38868d);
                }
            }
        } catch (Exception e11) {
            o0.b(BTBaseView.TAG, e11.getMessage(), e11);
        }
    }
}
