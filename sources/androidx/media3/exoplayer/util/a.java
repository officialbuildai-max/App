package androidx.media3.exoplayer.util;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.a0;
import androidx.media3.common.e0;
import androidx.media3.common.h0;
import androidx.media3.common.i0;
import androidx.media3.common.m;
import androidx.media3.common.m0;
import androidx.media3.common.r;
import androidx.media3.common.t;
import androidx.media3.common.util.a1;
import androidx.media3.common.util.u;
import androidx.media3.common.v;
import androidx.media3.common.x;
import androidx.media3.common.z;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.j;
import androidx.media3.exoplayer.k;
import com.cloud.tmc.kernel.utils.UrlUtils;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.transsion.wrapperad.view.secondfloor.CustomSwipeRefreshLayout;
import g2.i;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import y1.c;

/* loaded from: classes2.dex */
public class a implements y1.c {

    /* renamed from: e, reason: collision with root package name */
    private static final NumberFormat f13114e;

    /* renamed from: a, reason: collision with root package name */
    private final String f13115a;

    /* renamed from: b, reason: collision with root package name */
    private final e0.c f13116b;

    /* renamed from: c, reason: collision with root package name */
    private final e0.b f13117c;

    /* renamed from: d, reason: collision with root package name */
    private final long f13118d;

    static {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        f13114e = numberFormat;
        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setGroupingUsed(false);
    }

    public a() {
        this("EventLogger");
    }

    public a(String str) {
        this.f13115a = str;
        this.f13116b = new e0.c();
        this.f13117c = new e0.b();
        this.f13118d = SystemClock.elapsedRealtime();
    }

    private static String A0(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 3 ? UrlUtils.QUESTION_MARK : "UNSUITABLE_AUDIO_OUTPUT" : "TRANSIENT_AUDIO_FOCUS_LOSS" : "NONE";
    }

    private static String B0(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? UrlUtils.QUESTION_MARK : "ALL" : "ONE" : "OFF";
    }

    private String C(c.a aVar, String str, String str2, Throwable th2) {
        String str3 = str + " [" + H(aVar);
        if (th2 instanceof PlaybackException) {
            str3 = str3 + ", errorCode=" + ((PlaybackException) th2).getErrorCodeName();
        }
        if (str2 != null) {
            str3 = str3 + ", " + str2;
        }
        String e11 = u.e(th2);
        if (!TextUtils.isEmpty(e11)) {
            str3 = str3 + "\n  " + e11.replace("\n", "\n  ") + '\n';
        }
        return str3 + "]";
    }

    private static String C0(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? UrlUtils.QUESTION_MARK : "ENDED" : "READY" : "BUFFERING" : CustomSwipeRefreshLayout.IDLE;
    }

    private static String D0(long j11) {
        return j11 == C.TIME_UNSET ? UrlUtils.QUESTION_MARK : f13114e.format(((float) j11) / 1000.0f);
    }

    private static String E0(int i11) {
        return i11 != 0 ? i11 != 1 ? UrlUtils.QUESTION_MARK : "SOURCE_UPDATE" : "PLAYLIST_CHANGED";
    }

    private static String F0(boolean z10) {
        return z10 ? "[X]" : "[ ]";
    }

    private String H(c.a aVar) {
        String str = "window=" + aVar.f78735c;
        if (aVar.f78736d != null) {
            str = str + ", period=" + aVar.f78734b.b(aVar.f78736d.f12965a);
            if (aVar.f78736d.b()) {
                str = (str + ", adGroup=" + aVar.f78736d.f12966b) + ", ad=" + aVar.f78736d.f12967c;
            }
        }
        return "eventTime=" + D0(aVar.f78733a - this.f13118d) + ", mediaPos=" + D0(aVar.f78737e) + ", " + str;
    }

    private void H0(c.a aVar, String str) {
        G0(C(aVar, str, null, null));
    }

    private void I0(c.a aVar, String str, String str2) {
        G0(C(aVar, str, str2, null));
    }

    private void K0(c.a aVar, String str, String str2, Throwable th2) {
        J0(C(aVar, str, str2, th2));
    }

    private void L0(c.a aVar, String str, Throwable th2) {
        J0(C(aVar, str, null, th2));
    }

    private void M0(c.a aVar, String str, Exception exc) {
        K0(aVar, "internalError", str, exc);
    }

    private void N0(x xVar, String str) {
        for (int i11 = 0; i11 < xVar.e(); i11++) {
            G0(str + xVar.d(i11));
        }
    }

    private static String e(AudioSink.a aVar) {
        return aVar.f11083a + "," + aVar.f11085c + "," + aVar.f11084b + "," + aVar.f11086d + "," + aVar.f11087e + "," + aVar.f11088f;
    }

    private static String l(int i11) {
        switch (i11) {
            case 0:
                return "AUTO_TRANSITION";
            case 1:
                return "SEEK";
            case 2:
                return "SEEK_ADJUSTMENT";
            case 3:
                return "SKIP";
            case 4:
                return "REMOVE";
            case 5:
                return "INTERNAL";
            case 6:
                return "SILENCE_SKIP";
            default:
                return UrlUtils.QUESTION_MARK;
        }
    }

    private static String y0(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? UrlUtils.QUESTION_MARK : "PLAYLIST_CHANGED" : "SEEK" : "AUTO" : "REPEAT";
    }

    private static String z0(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? UrlUtils.QUESTION_MARK : "END_OF_MEDIA_ITEM" : "REMOTE" : "AUDIO_BECOMING_NOISY" : "AUDIO_FOCUS_LOSS" : "USER_REQUEST";
    }

    @Override // y1.c
    public /* synthetic */ void A(c.a aVar) {
        y1.b.w(this, aVar);
    }

    @Override // y1.c
    public /* synthetic */ void B(c.a aVar) {
        y1.b.X(this, aVar);
    }

    @Override // y1.c
    public /* synthetic */ void D(c.a aVar, PlaybackException playbackException) {
        y1.b.Q(this, aVar, playbackException);
    }

    @Override // y1.c
    public void E(c.a aVar, j jVar) {
        H0(aVar, "videoDisabled");
    }

    @Override // y1.c
    public void F(c.a aVar, a0.e eVar, a0.e eVar2, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("reason=");
        sb2.append(l(i11));
        sb2.append(", PositionInfo:old [");
        sb2.append("mediaItem=");
        sb2.append(eVar.f9889c);
        sb2.append(", period=");
        sb2.append(eVar.f9892f);
        sb2.append(", pos=");
        sb2.append(eVar.f9893g);
        if (eVar.f9895i != -1) {
            sb2.append(", contentPos=");
            sb2.append(eVar.f9894h);
            sb2.append(", adGroup=");
            sb2.append(eVar.f9895i);
            sb2.append(", ad=");
            sb2.append(eVar.f9896j);
        }
        sb2.append("], PositionInfo:new [");
        sb2.append("mediaItem=");
        sb2.append(eVar2.f9889c);
        sb2.append(", period=");
        sb2.append(eVar2.f9892f);
        sb2.append(", pos=");
        sb2.append(eVar2.f9893g);
        if (eVar2.f9895i != -1) {
            sb2.append(", contentPos=");
            sb2.append(eVar2.f9894h);
            sb2.append(", adGroup=");
            sb2.append(eVar2.f9895i);
            sb2.append(", ad=");
            sb2.append(eVar2.f9896j);
        }
        sb2.append("]");
        I0(aVar, "positionDiscontinuity", sb2.toString());
    }

    @Override // y1.c
    public void G(c.a aVar, Object obj, long j11) {
        I0(aVar, "renderedFirstFrame", String.valueOf(obj));
    }

    protected void G0(String str) {
        u.b(this.f13115a, str);
    }

    @Override // y1.c
    public /* synthetic */ void I(c.a aVar, i iVar, g2.j jVar) {
        y1.b.G(this, aVar, iVar, jVar);
    }

    @Override // y1.c
    public /* synthetic */ void J(c.a aVar, int i11, long j11, long j12) {
        y1.b.o(this, aVar, i11, j11, j12);
    }

    protected void J0(String str) {
        u.c(this.f13115a, str);
    }

    @Override // y1.c
    public void K(c.a aVar, j jVar) {
        H0(aVar, "audioEnabled");
    }

    @Override // y1.c
    public void L(c.a aVar, int i11) {
        I0(aVar, "audioSessionId", Integer.toString(i11));
    }

    @Override // y1.c
    public /* synthetic */ void M(c.a aVar, boolean z10) {
        y1.b.I(this, aVar, z10);
    }

    @Override // y1.c
    public void N(c.a aVar, int i11, long j11, long j12) {
        K0(aVar, "audioTrackUnderrun", i11 + ", " + j11 + ", " + j12, null);
    }

    @Override // y1.c
    public void O(c.a aVar, boolean z10, int i11) {
        I0(aVar, "playWhenReady", z10 + ", " + z0(i11));
    }

    @Override // y1.c
    public void P(c.a aVar, z zVar) {
        I0(aVar, "playbackParameters", zVar.toString());
    }

    @Override // y1.c
    public void Q(c.a aVar) {
        H0(aVar, "drmSessionReleased");
    }

    @Override // y1.c
    public void R(c.a aVar, String str, long j11, long j12) {
        I0(aVar, "audioDecoderInitialized", str);
    }

    @Override // y1.c
    public void S(c.a aVar, m0 m0Var) {
        I0(aVar, "videoSize", m0Var.f10197a + ", " + m0Var.f10198b);
    }

    @Override // y1.c
    public /* synthetic */ void T(c.a aVar, long j11, int i11) {
        y1.b.k0(this, aVar, j11, i11);
    }

    @Override // y1.c
    public void U(c.a aVar, int i11) {
        I0(aVar, "drmSessionAcquired", "state=" + i11);
    }

    @Override // y1.c
    public void V(c.a aVar, int i11) {
        I0(aVar, "playbackSuppressionReason", A0(i11));
    }

    @Override // y1.c
    public /* synthetic */ void W(c.a aVar, String str, long j11) {
        y1.b.b(this, aVar, str, j11);
    }

    @Override // y1.c
    public void X(c.a aVar, Exception exc) {
        M0(aVar, "drmSessionManagerError", exc);
    }

    @Override // y1.c
    public void Y(c.a aVar, AudioSink.a aVar2) {
        I0(aVar, "audioTrackInit", e(aVar2));
    }

    @Override // y1.c
    public void Z(c.a aVar, String str) {
        I0(aVar, "videoDecoderReleased", str);
    }

    @Override // y1.c
    public void a(c.a aVar, j jVar) {
        H0(aVar, "audioDisabled");
    }

    @Override // y1.c
    public void a0(c.a aVar, String str) {
        I0(aVar, "audioDecoderReleased", str);
    }

    @Override // y1.c
    public void b(c.a aVar, float f11) {
        I0(aVar, "volume", Float.toString(f11));
    }

    @Override // y1.c
    public /* synthetic */ void b0(c.a aVar, boolean z10, int i11) {
        y1.b.S(this, aVar, z10, i11);
    }

    @Override // y1.c
    public void c(c.a aVar, PlaybackException playbackException) {
        L0(aVar, "playerFailed", playbackException);
    }

    @Override // y1.c
    public /* synthetic */ void c0(c.a aVar, a0.b bVar) {
        y1.b.n(this, aVar, bVar);
    }

    @Override // y1.c
    public /* synthetic */ void d(c.a aVar, int i11) {
        y1.b.T(this, aVar, i11);
    }

    @Override // y1.c
    public /* synthetic */ void d0(a0 a0Var, c.b bVar) {
        y1.b.B(this, a0Var, bVar);
    }

    @Override // y1.c
    public void e0(c.a aVar, boolean z10) {
        I0(aVar, "shuffleModeEnabled", Boolean.toString(z10));
    }

    @Override // y1.c
    public void f(c.a aVar, int i11, int i12, boolean z10) {
        I0(aVar, "rendererReady", "rendererIndex=" + i11 + ", " + a1.t0(i12) + ", " + z10);
    }

    @Override // y1.c
    public /* synthetic */ void f0(c.a aVar, int i11, int i12, int i13, float f11) {
        y1.b.m0(this, aVar, i11, i12, i13, f11);
    }

    @Override // y1.c
    public void g(c.a aVar, boolean z10) {
        I0(aVar, "loading", Boolean.toString(z10));
    }

    @Override // y1.c
    public /* synthetic */ void g0(c.a aVar, v vVar) {
        y1.b.K(this, aVar, vVar);
    }

    @Override // y1.c
    public void h(c.a aVar, int i11, long j11) {
        I0(aVar, "droppedFrames", Integer.toString(i11));
    }

    @Override // y1.c
    public /* synthetic */ void h0(c.a aVar, Exception exc) {
        y1.b.f0(this, aVar, exc);
    }

    @Override // y1.c
    public /* synthetic */ void i(c.a aVar, u1.b bVar) {
        y1.b.q(this, aVar, bVar);
    }

    @Override // y1.c
    public void i0(c.a aVar, r rVar, k kVar) {
        I0(aVar, "audioInputFormat", r.i(rVar));
    }

    @Override // y1.c
    public void j(c.a aVar, g2.j jVar) {
        I0(aVar, "downstreamFormat", r.i(jVar.f63340c));
    }

    @Override // y1.c
    public /* synthetic */ void j0(c.a aVar, long j11) {
        y1.b.h(this, aVar, j11);
    }

    @Override // y1.c
    public void k(c.a aVar) {
        H0(aVar, "drmKeysRestored");
    }

    @Override // y1.c
    public /* synthetic */ void k0(c.a aVar, i iVar, g2.j jVar, int i11) {
        y1.b.H(this, aVar, iVar, jVar, i11);
    }

    @Override // y1.c
    public void l0(c.a aVar, int i11) {
        I0(aVar, "state", C0(i11));
    }

    @Override // y1.c
    public void m(c.a aVar, x xVar) {
        G0("metadata [" + H(aVar));
        N0(xVar, "  ");
        G0("]");
    }

    @Override // y1.c
    public void m0(c.a aVar, boolean z10) {
        I0(aVar, "skipSilenceEnabled", Boolean.toString(z10));
    }

    @Override // y1.c
    public void n(c.a aVar, boolean z10) {
        I0(aVar, "isPlaying", Boolean.toString(z10));
    }

    @Override // y1.c
    public /* synthetic */ void n0(c.a aVar, Exception exc) {
        y1.b.j(this, aVar, exc);
    }

    @Override // y1.c
    public /* synthetic */ void o(c.a aVar, Exception exc) {
        y1.b.a(this, aVar, exc);
    }

    @Override // y1.c
    public void o0(c.a aVar, j jVar) {
        H0(aVar, "videoEnabled");
    }

    @Override // y1.c
    public void p(c.a aVar) {
        H0(aVar, "drmKeysLoaded");
    }

    @Override // y1.c
    public void p0(c.a aVar, int i11, int i12) {
        I0(aVar, "surfaceSize", i11 + ", " + i12);
    }

    @Override // y1.c
    public void q(c.a aVar, String str, long j11, long j12) {
        I0(aVar, "videoDecoderInitialized", str);
    }

    @Override // y1.c
    public /* synthetic */ void q0(c.a aVar) {
        y1.b.R(this, aVar);
    }

    @Override // y1.c
    public /* synthetic */ void r(c.a aVar, i iVar, g2.j jVar) {
        y1.b.E(this, aVar, iVar, jVar);
    }

    @Override // y1.c
    public /* synthetic */ void r0(c.a aVar, List list) {
        y1.b.p(this, aVar, list);
    }

    @Override // y1.c
    public void s(c.a aVar, AudioSink.a aVar2) {
        I0(aVar, "audioTrackReleased", e(aVar2));
    }

    @Override // y1.c
    public /* synthetic */ void s0(c.a aVar, int i11, boolean z10) {
        y1.b.s(this, aVar, i11, z10);
    }

    @Override // y1.c
    public void t(c.a aVar) {
        H0(aVar, "drmKeysRemoved");
    }

    @Override // y1.c
    public void t0(c.a aVar, t tVar, int i11) {
        G0("mediaItem [" + H(aVar) + ", reason=" + y0(i11) + "]");
    }

    @Override // y1.c
    public /* synthetic */ void u(c.a aVar, m mVar) {
        y1.b.r(this, aVar, mVar);
    }

    @Override // y1.c
    public /* synthetic */ void u0(c.a aVar, h0 h0Var) {
        y1.b.c0(this, aVar, h0Var);
    }

    @Override // y1.c
    public void v(c.a aVar, i iVar, g2.j jVar, IOException iOException, boolean z10) {
        M0(aVar, "loadError", iOException);
    }

    @Override // y1.c
    public void v0(c.a aVar, g2.j jVar) {
        I0(aVar, "upstreamDiscarded", r.i(jVar.f63340c));
    }

    @Override // y1.c
    public /* synthetic */ void w(c.a aVar, String str, long j11) {
        y1.b.g0(this, aVar, str, j11);
    }

    @Override // y1.c
    public void w0(c.a aVar, int i11) {
        int i12 = aVar.f78734b.i();
        int p11 = aVar.f78734b.p();
        G0("timeline [" + H(aVar) + ", periodCount=" + i12 + ", windowCount=" + p11 + ", reason=" + E0(i11));
        for (int i13 = 0; i13 < Math.min(i12, 3); i13++) {
            aVar.f78734b.f(i13, this.f13117c);
            G0("  period [" + D0(this.f13117c.j()) + "]");
        }
        if (i12 > 3) {
            G0("  ...");
        }
        for (int i14 = 0; i14 < Math.min(p11, 3); i14++) {
            aVar.f78734b.n(i14, this.f13116b);
            G0("  window [" + D0(this.f13116b.d()) + ", seekable=" + this.f13116b.f10040h + ", dynamic=" + this.f13116b.f10041i + "]");
        }
        if (p11 > 3) {
            G0("  ...");
        }
        G0("]");
    }

    @Override // y1.c
    public void x(c.a aVar, r rVar, k kVar) {
        I0(aVar, "videoInputFormat", r.i(rVar));
    }

    @Override // y1.c
    public /* synthetic */ void x0(c.a aVar, i iVar, g2.j jVar) {
        y1.b.F(this, aVar, iVar, jVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // y1.c
    public void y(c.a aVar, i0 i0Var) {
        x xVar;
        G0("tracks [" + H(aVar));
        ImmutableList a11 = i0Var.a();
        for (int i11 = 0; i11 < a11.size(); i11++) {
            i0.a aVar2 = (i0.a) a11.get(i11);
            G0("  group [");
            for (int i12 = 0; i12 < aVar2.f10173a; i12++) {
                G0("    " + F0(aVar2.h(i12)) + " Track:" + i12 + ", " + r.i(aVar2.b(i12)) + ", supported=" + a1.d0(aVar2.c(i12)));
            }
            G0("  ]");
        }
        boolean z10 = false;
        for (int i13 = 0; !z10 && i13 < a11.size(); i13++) {
            i0.a aVar3 = (i0.a) a11.get(i13);
            for (int i14 = 0; !z10 && i14 < aVar3.f10173a; i14++) {
                if (aVar3.h(i14) && (xVar = aVar3.b(i14).f10240l) != null && xVar.e() > 0) {
                    G0("  Metadata [");
                    N0(xVar, "    ");
                    G0("  ]");
                    z10 = true;
                }
            }
        }
        G0("]");
    }

    @Override // y1.c
    public void z(c.a aVar, int i11) {
        I0(aVar, "repeatMode", B0(i11));
    }
}
