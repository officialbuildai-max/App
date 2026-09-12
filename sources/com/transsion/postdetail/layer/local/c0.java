package com.transsion.postdetail.layer.local;

import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.global.TnPlayerType;
import com.transsion.ugcvideodetail.api.bean.UGCVideo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class c0 {

    /* renamed from: g0 */
    public static final a f49046g0 = new a(null);
    private String A;
    private String B;
    private String C;
    private String D;
    private String E;
    private String F;
    private String H;
    private String I;
    private DownloadBean J;
    private String K;
    private int L;
    private boolean M;
    private int N;
    private int O;
    private String R;
    private UGCVideo U;
    private String V;
    private String W;
    private String X;

    /* renamed from: a */
    private com.transsion.player.orplayer.g f49047a;

    /* renamed from: a0 */
    private boolean f49048a0;

    /* renamed from: b0 */
    private TnPlayerType f49050b0;

    /* renamed from: c */
    private long f49051c;

    /* renamed from: c0 */
    private boolean f49052c0;

    /* renamed from: d */
    private long f49053d;

    /* renamed from: d0 */
    private boolean f49054d0;

    /* renamed from: e */
    private long f49055e;

    /* renamed from: e0 */
    private yj.c f49056e0;

    /* renamed from: f */
    private long f49057f;

    /* renamed from: f0 */
    private boolean f49058f0;

    /* renamed from: g */
    private long f49059g;

    /* renamed from: h */
    private int f49060h;

    /* renamed from: i */
    private int f49061i;

    /* renamed from: j */
    private Double f49062j;

    /* renamed from: k */
    private Double f49063k;

    /* renamed from: l */
    private long f49064l;

    /* renamed from: m */
    private long f49065m;

    /* renamed from: n */
    private long f49066n;

    /* renamed from: o */
    private long f49067o;

    /* renamed from: p */
    private long f49068p;

    /* renamed from: q */
    private long f49069q;

    /* renamed from: r */
    private boolean f49070r;

    /* renamed from: t */
    private boolean f49072t;

    /* renamed from: u */
    private boolean f49073u;

    /* renamed from: v */
    private long f49074v;

    /* renamed from: w */
    private long f49075w;

    /* renamed from: x */
    private int f49076x;

    /* renamed from: y */
    private long f49077y;

    /* renamed from: z */
    private Integer f49078z;

    /* renamed from: b */
    private final String f49049b = "long_video_play";

    /* renamed from: s */
    private boolean f49071s = true;
    private int G = -1;
    private int P = -1;
    private int Q = -1;
    private String S = "local_video_detail";
    private String T = "long_video_play";
    private Map Y = new LinkedHashMap();
    private final List Z = new ArrayList();

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ void c(c0 c0Var, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z10 = false;
        }
        c0Var.b(z10);
    }

    private final yj.c f() {
        if (this.f49056e0 == null) {
            this.f49056e0 = (yj.c) yj.a.f79145a.a(yj.c.class);
        }
        return this.f49056e0;
    }

    private final void y(boolean z10) {
        this.f49051c = 0L;
        this.f49053d = 0L;
        this.f49055e = 0L;
        this.f49057f = 0L;
        this.f49059g = 0L;
        this.f49060h = 0;
        this.f49065m = 0L;
        this.f49066n = 0L;
        this.f49074v = 0L;
        this.f49075w = 0L;
        this.f49076x = 0;
        this.f49067o = 0L;
        this.f49068p = 0L;
        this.f49069q = 0L;
        this.f49061i = 0;
        this.f49070r = false;
        this.f49078z = null;
        this.A = null;
        this.L = 0;
        this.B = "";
        if (z10) {
            return;
        }
        this.f49064l = 0L;
        this.f49077y = 0L;
        this.f49050b0 = null;
        this.f49052c0 = false;
        this.f49054d0 = false;
        this.f49073u = false;
    }

    public final void A(DownloadBean downloadBean, String str) {
        this.K = str;
        this.J = downloadBean;
        if (downloadBean == null || !downloadBean.isInnerRes()) {
            this.H = "2";
            this.I = downloadBean != null ? downloadBean.getPath() : null;
        } else if (downloadBean == null || downloadBean.getStatus() != 5) {
            this.H = "1";
            this.I = downloadBean != null ? downloadBean.getUrl() : null;
        } else {
            this.H = "0";
            this.I = downloadBean.getPath();
        }
        a.C0856a.f(lg.a.f68962a, this.f49049b, "setData", false, 4, null);
    }

    public final void B(int i11) {
        this.Q = i11;
    }

    public final void C(int i11) {
        this.P = i11;
    }

    public final void D(boolean z10) {
        this.f49072t = z10;
    }

    public final void E(String str) {
        Intrinsics.h(str, "<set-?>");
        this.T = str;
    }

    public final void F(boolean z10) {
        this.f49048a0 = z10;
    }

    public final void G(boolean z10) {
        this.f49058f0 = z10;
    }

    public final void H(int i11, String str) {
        String str2;
        if (i11 == 1 || this.L != 1 || (str2 = this.B) == null || str2.length() <= 0) {
            this.L = i11;
            this.B = str;
        }
    }

    public final void I(com.transsion.player.orplayer.g gVar) {
        this.f49047a = gVar;
    }

    public final void J(String str) {
        Intrinsics.h(str, "<set-?>");
        this.S = str;
    }

    public final void K(String str) {
        this.H = str;
    }

    public final void L(String str) {
        this.R = str;
    }

    public final void M(boolean z10) {
        this.f49054d0 = z10;
    }

    public final void N(String str) {
        this.V = str;
    }

    public final void O(String str) {
        this.X = str;
    }

    public final void P(String str) {
        this.W = str;
    }

    public final void Q(UGCVideo uGCVideo) {
        this.U = uGCVideo;
    }

    public final void a() {
        this.f49053d = System.currentTimeMillis();
        a.C0856a.f(lg.a.f68962a, this.f49049b, "addSurface", false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:137:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0467  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x048e  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x04a3  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x04d3  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x04f1  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x05ea  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0687  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x04f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x046a  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x043c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(boolean r27) {
        /*
            Method dump skipped, instructions count: 1700
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.postdetail.layer.local.c0.b(boolean):void");
    }

    public final boolean d() {
        return this.f49048a0;
    }

    public final Map e() {
        return this.Y;
    }

    public final void g() {
        this.f49051c = System.currentTimeMillis();
        a.C0856a.f(lg.a.f68962a, this.f49049b, "initView", false, 4, null);
    }

    public final void h(Double d11, long j11, long j12, Double d12) {
        a.C0856a.f(lg.a.f68962a, this.f49049b, "onBandwidthRedundancyRate", false, 4, null);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onBandwidthRedundancyRate: redundancyRate:");
        sb2.append(d11);
        sb2.append("，totalDownloadBytesAll : ");
        sb2.append(j11);
        sb2.append("，consumed:");
        sb2.append(j12);
        sb2.append(",poolPercent:");
        sb2.append(d12);
        this.f49062j = d11;
        this.f49063k = d12;
    }

    public final void i() {
        a.C0856a.f(lg.a.f68962a, this.f49049b, "onCompletion", false, 4, null);
        this.f49070r = true;
    }

    public final void j() {
        a.C0856a.f(lg.a.f68962a, this.f49049b, "onLoadingBegin", false, 4, null);
        this.f49059g = System.currentTimeMillis();
    }

    public final void k() {
        if (this.f49059g > 0) {
            this.f49057f += System.currentTimeMillis() - this.f49059g;
            this.f49060h++;
            this.f49059g = 0L;
        }
    }

    public final void l(LocalUiType uiType) {
        Intrinsics.h(uiType, "uiType");
        this.f49071s = uiType == LocalUiType.MIDDLE;
        a.C0856a.f(lg.a.f68962a, this.f49049b, "onLocalUiChanged， uiType= " + uiType, false, 4, null);
    }

    public final void m(PlayError errorInfo) {
        Intrinsics.h(errorInfo, "errorInfo");
        this.f49078z = errorInfo.getErrorCode();
        String errorMessage = errorInfo.getErrorMessage();
        this.A = errorMessage;
        a.C0856a.f(lg.a.f68962a, this.f49049b, "onPlayError, playerErrorCode  =" + this.f49078z + ", playerErrorMessage =" + errorMessage, false, 4, null);
        H(3, this.A);
    }

    public final void n(long j11) {
        yj.c f11;
        if (this.f49077y <= 0) {
            com.transsion.player.orplayer.g gVar = this.f49047a;
            this.f49077y = gVar != null ? gVar.getDuration() : 0L;
        }
        long j12 = this.f49065m;
        long j13 = j11 - j12;
        if (1 <= j13 && j13 < 2000) {
            this.f49066n += j11 - j12;
            if (this.f49072t) {
                this.f49069q += j11 - j12;
            } else if (this.f49071s) {
                this.f49068p += j11 - j12;
            } else {
                this.f49067o += j11 - j12;
            }
        }
        this.f49065m = j11;
        if (j11 > this.f49064l) {
            this.f49064l = j11;
        }
        DownloadBean downloadBean = this.J;
        if ((downloadBean == null || downloadBean.getSubjectType() != 6) && (f11 = f()) != null) {
            f11.a(this.f49066n);
        }
    }

    public final void o() {
        a.C0856a.f(lg.a.f68962a, this.f49049b, "onRenderFirstFrame", false, 4, null);
        this.f49055e = System.currentTimeMillis();
    }

    public final void p() {
        a.C0856a.f(lg.a.f68962a, this.f49049b, "oonReplayonReplay", false, 4, null);
        this.M = true;
        this.f49073u = false;
    }

    public final void q() {
        this.f49061i++;
    }

    public final void r(List list) {
        Intrinsics.h(list, "list");
        this.Z.clear();
        this.Z.addAll(list);
    }

    public final void s(String name, String lan, int i11) {
        Intrinsics.h(name, "name");
        Intrinsics.h(lan, "lan");
        a.C0856a.f(lg.a.f68962a, this.f49049b, "onSubtitleSelected = " + name, false, 4, null);
        this.E = name;
        this.F = lan;
        this.G = i11;
    }

    public final void t(String str, String str2) {
        this.C = str;
        this.D = str2;
    }

    public final void u(int i11) {
        this.O = i11;
    }

    public final void v(int i11) {
        this.N = i11;
    }

    public final void w() {
        this.f49076x++;
        a.C0856a.f(lg.a.f68962a, this.f49049b, "onVideoPause", false, 4, null);
        this.f49074v = System.currentTimeMillis();
    }

    public final void x() {
        a.C0856a.f(lg.a.f68962a, this.f49049b, "onVideoStart", false, 4, null);
        if (this.f49074v != 0) {
            this.f49075w += System.currentTimeMillis() - this.f49074v;
            this.f49074v = 0L;
        }
    }

    public final void z(boolean z10) {
        this.f49052c0 = z10;
    }
}
