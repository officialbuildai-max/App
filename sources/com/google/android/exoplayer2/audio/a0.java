package com.google.android.exoplayer2.audio;

import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.r;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.l;
import com.google.android.exoplayer2.n2;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.x2;
import com.google.android.exoplayer2.y2;
import com.google.common.collect.ImmutableList;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.Collection;
import java.util.List;

/* loaded from: classes3.dex */
public class a0 extends MediaCodecRenderer implements com.google.android.exoplayer2.util.u {
    private final Context G0;
    private final r.a H0;
    private final AudioSink I0;
    private int J0;
    private boolean K0;
    private o1 L0;
    private long M0;
    private boolean N0;
    private boolean O0;
    private boolean P0;
    private boolean Q0;
    private x2.a R0;

    /* loaded from: classes3.dex */
    private final class b implements AudioSink.a {
        private b() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void a(Exception exc) {
            com.google.android.exoplayer2.util.s.d("MediaCodecAudioRenderer", "Audio sink error", exc);
            a0.this.H0.l(exc);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void b(long j11) {
            a0.this.H0.B(j11);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void c() {
            if (a0.this.R0 != null) {
                a0.this.R0.a();
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void d() {
            if (a0.this.R0 != null) {
                a0.this.R0.b();
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void onPositionDiscontinuity() {
            a0.this.f1();
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void onSkipSilenceEnabledChanged(boolean z10) {
            a0.this.H0.C(z10);
        }

        @Override // com.google.android.exoplayer2.audio.AudioSink.a
        public void onUnderrun(int i11, long j11, long j12) {
            a0.this.H0.D(i11, j11, j12);
        }
    }

    public a0(Context context, l.b bVar, com.google.android.exoplayer2.mediacodec.o oVar, boolean z10, Handler handler, r rVar, AudioSink audioSink) {
        super(1, bVar, oVar, z10, 44100.0f);
        this.G0 = context.getApplicationContext();
        this.I0 = audioSink;
        this.H0 = new r.a(handler, rVar);
        audioSink.g(new b());
    }

    private static boolean Z0(String str) {
        if (p0.f27680a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(p0.f27682c)) {
            String str2 = p0.f27681b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    private static boolean a1() {
        if (p0.f27680a == 23) {
            String str = p0.f27683d;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private int b1(com.google.android.exoplayer2.mediacodec.m mVar, o1 o1Var) {
        int i11;
        if (!"OMX.google.raw.decoder".equals(mVar.f25452a) || (i11 = p0.f27680a) >= 24 || (i11 == 23 && p0.x0(this.G0))) {
            return o1Var.f25551m;
        }
        return -1;
    }

    private static List d1(com.google.android.exoplayer2.mediacodec.o oVar, o1 o1Var, boolean z10, AudioSink audioSink) {
        com.google.android.exoplayer2.mediacodec.m v11;
        String str = o1Var.f25550l;
        if (str == null) {
            return ImmutableList.of();
        }
        if (audioSink.a(o1Var) && (v11 = MediaCodecUtil.v()) != null) {
            return ImmutableList.of(v11);
        }
        List a11 = oVar.a(str, z10, false);
        String m11 = MediaCodecUtil.m(o1Var);
        return m11 == null ? ImmutableList.copyOf((Collection) a11) : ImmutableList.builder().l(a11).l(oVar.a(m11, z10, false)).e();
    }

    private void g1() {
        long currentPositionUs = this.I0.getCurrentPositionUs(isEnded());
        if (currentPositionUs != Long.MIN_VALUE) {
            if (!this.O0) {
                currentPositionUs = Math.max(this.M0, currentPositionUs);
            }
            this.M0 = currentPositionUs;
            this.O0 = false;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean A0(long j11, long j12, com.google.android.exoplayer2.mediacodec.l lVar, ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z10, boolean z11, o1 o1Var) {
        com.google.android.exoplayer2.util.a.e(byteBuffer);
        if (this.L0 != null && (i12 & 2) != 0) {
            ((com.google.android.exoplayer2.mediacodec.l) com.google.android.exoplayer2.util.a.e(lVar)).k(i11, false);
            return true;
        }
        if (z10) {
            if (lVar != null) {
                lVar.k(i11, false);
            }
            this.B0.f24934f += i13;
            this.I0.handleDiscontinuity();
            return true;
        }
        try {
            if (!this.I0.c(byteBuffer, j13, i13)) {
                return false;
            }
            if (lVar != null) {
                lVar.k(i11, false);
            }
            this.B0.f24933e += i13;
            return true;
        } catch (AudioSink.InitializationException e11) {
            throw i(e11, e11.format, e11.isRecoverable, 5001);
        } catch (AudioSink.WriteException e12) {
            throw i(e12, o1Var, e12.isRecoverable, 5002);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected com.google.android.exoplayer2.decoder.g B(com.google.android.exoplayer2.mediacodec.m mVar, o1 o1Var, o1 o1Var2) {
        com.google.android.exoplayer2.decoder.g e11 = mVar.e(o1Var, o1Var2);
        int i11 = e11.f24947e;
        if (b1(mVar, o1Var2) > this.J0) {
            i11 |= 64;
        }
        int i12 = i11;
        return new com.google.android.exoplayer2.decoder.g(mVar.f25452a, o1Var, o1Var2, i12 != 0 ? 0 : e11.f24946d, i12);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void F0() {
        try {
            this.I0.playToEndOfStream();
        } catch (AudioSink.WriteException e11) {
            throw i(e11, e11.format, e11.isRecoverable, 5002);
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected boolean R0(o1 o1Var) {
        return this.I0.a(o1Var);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected int S0(com.google.android.exoplayer2.mediacodec.o oVar, o1 o1Var) {
        boolean z10;
        if (!com.google.android.exoplayer2.util.w.p(o1Var.f25550l)) {
            return y2.a(0);
        }
        int i11 = p0.f27680a >= 21 ? 32 : 0;
        boolean z11 = true;
        boolean z12 = o1Var.E != 0;
        boolean T0 = MediaCodecRenderer.T0(o1Var);
        int i12 = 8;
        if (T0 && this.I0.a(o1Var) && (!z12 || MediaCodecUtil.v() != null)) {
            return y2.b(4, 8, i11);
        }
        if ((!MimeTypes.AUDIO_RAW.equals(o1Var.f25550l) || this.I0.a(o1Var)) && this.I0.a(p0.d0(2, o1Var.f25563y, o1Var.f25564z))) {
            List d12 = d1(oVar, o1Var, false, this.I0);
            if (d12.isEmpty()) {
                return y2.a(1);
            }
            if (!T0) {
                return y2.a(2);
            }
            com.google.android.exoplayer2.mediacodec.m mVar = (com.google.android.exoplayer2.mediacodec.m) d12.get(0);
            boolean m11 = mVar.m(o1Var);
            if (!m11) {
                for (int i13 = 1; i13 < d12.size(); i13++) {
                    com.google.android.exoplayer2.mediacodec.m mVar2 = (com.google.android.exoplayer2.mediacodec.m) d12.get(i13);
                    if (mVar2.m(o1Var)) {
                        z10 = false;
                        mVar = mVar2;
                        break;
                    }
                }
            }
            z10 = true;
            z11 = m11;
            int i14 = z11 ? 4 : 3;
            if (z11 && mVar.p(o1Var)) {
                i12 = 16;
            }
            return y2.c(i14, i12, i11, mVar.f25459h ? 64 : 0, z10 ? 128 : 0);
        }
        return y2.a(1);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected float a0(float f11, o1 o1Var, o1[] o1VarArr) {
        int i11 = -1;
        for (o1 o1Var2 : o1VarArr) {
            int i12 = o1Var2.f25564z;
            if (i12 != -1) {
                i11 = Math.max(i11, i12);
            }
        }
        if (i11 == -1) {
            return -1.0f;
        }
        return f11 * i11;
    }

    @Override // com.google.android.exoplayer2.util.u
    public void b(n2 n2Var) {
        this.I0.b(n2Var);
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected List c0(com.google.android.exoplayer2.mediacodec.o oVar, o1 o1Var, boolean z10) {
        return MediaCodecUtil.u(d1(oVar, o1Var, z10, this.I0), o1Var);
    }

    protected int c1(com.google.android.exoplayer2.mediacodec.m mVar, o1 o1Var, o1[] o1VarArr) {
        int b12 = b1(mVar, o1Var);
        if (o1VarArr.length == 1) {
            return b12;
        }
        for (o1 o1Var2 : o1VarArr) {
            if (mVar.e(o1Var, o1Var2).f24946d != 0) {
                b12 = Math.max(b12, b1(mVar, o1Var2));
            }
        }
        return b12;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected l.a e0(com.google.android.exoplayer2.mediacodec.m mVar, o1 o1Var, MediaCrypto mediaCrypto, float f11) {
        this.J0 = c1(mVar, o1Var, n());
        this.K0 = Z0(mVar.f25452a);
        MediaFormat e12 = e1(o1Var, mVar.f25454c, this.J0, f11);
        this.L0 = (!MimeTypes.AUDIO_RAW.equals(mVar.f25453b) || MimeTypes.AUDIO_RAW.equals(o1Var.f25550l)) ? null : o1Var;
        return l.a.a(mVar, e12, o1Var, mediaCrypto);
    }

    protected MediaFormat e1(o1 o1Var, String str, int i11, float f11) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", str);
        mediaFormat.setInteger("channel-count", o1Var.f25563y);
        mediaFormat.setInteger("sample-rate", o1Var.f25564z);
        com.google.android.exoplayer2.util.v.e(mediaFormat, o1Var.f25552n);
        com.google.android.exoplayer2.util.v.d(mediaFormat, "max-input-size", i11);
        int i12 = p0.f27680a;
        if (i12 >= 23) {
            mediaFormat.setInteger(TrackingKey.PRIORITY, 0);
            if (f11 != -1.0f && !a1()) {
                mediaFormat.setFloat("operating-rate", f11);
            }
        }
        if (i12 <= 28 && "audio/ac4".equals(o1Var.f25550l)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i12 >= 24 && this.I0.h(p0.d0(4, o1Var.f25563y, o1Var.f25564z)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (i12 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        return mediaFormat;
    }

    protected void f1() {
        this.O0 = true;
    }

    @Override // com.google.android.exoplayer2.h, com.google.android.exoplayer2.x2
    public com.google.android.exoplayer2.util.u getMediaClock() {
        return this;
    }

    @Override // com.google.android.exoplayer2.x2, com.google.android.exoplayer2.z2
    public String getName() {
        return "MediaCodecAudioRenderer";
    }

    @Override // com.google.android.exoplayer2.util.u
    public n2 getPlaybackParameters() {
        return this.I0.getPlaybackParameters();
    }

    @Override // com.google.android.exoplayer2.util.u
    public long getPositionUs() {
        if (getState() == 2) {
            g1();
        }
        return this.M0;
    }

    @Override // com.google.android.exoplayer2.h, com.google.android.exoplayer2.s2.b
    public void handleMessage(int i11, Object obj) {
        if (i11 == 2) {
            this.I0.setVolume(((Float) obj).floatValue());
            return;
        }
        if (i11 == 3) {
            this.I0.f((e) obj);
            return;
        }
        if (i11 == 6) {
            this.I0.j((u) obj);
            return;
        }
        switch (i11) {
            case 9:
                this.I0.e(((Boolean) obj).booleanValue());
                return;
            case 10:
                this.I0.setAudioSessionId(((Integer) obj).intValue());
                return;
            case 11:
                this.R0 = (x2.a) obj;
                return;
            default:
                super.handleMessage(i11, obj);
                return;
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.x2
    public boolean isEnded() {
        return super.isEnded() && this.I0.isEnded();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.x2
    public boolean isReady() {
        return this.I0.hasPendingData() || super.isReady();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.h
    public void p() {
        this.P0 = true;
        try {
            this.I0.flush();
            try {
                super.p();
            } finally {
            }
        } catch (Throwable th2) {
            try {
                super.p();
                throw th2;
            } finally {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.h
    public void q(boolean z10, boolean z11) {
        super.q(z10, z11);
        this.H0.p(this.B0);
        if (j().f24582a) {
            this.I0.d();
        } else {
            this.I0.disableTunneling();
        }
        this.I0.k(m());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.h
    public void r(long j11, boolean z10) {
        super.r(j11, z10);
        if (this.Q0) {
            this.I0.i();
        } else {
            this.I0.flush();
        }
        this.M0 = j11;
        this.N0 = true;
        this.O0 = true;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void r0(Exception exc) {
        com.google.android.exoplayer2.util.s.d("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.H0.k(exc);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.h
    public void s() {
        try {
            super.s();
        } finally {
            if (this.P0) {
                this.P0 = false;
                this.I0.reset();
            }
        }
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void s0(String str, l.a aVar, long j11, long j12) {
        this.H0.m(str, j11, j12);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.h
    public void t() {
        super.t();
        this.I0.play();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void t0(String str) {
        this.H0.n(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer, com.google.android.exoplayer2.h
    public void u() {
        g1();
        this.I0.pause();
        super.u();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public com.google.android.exoplayer2.decoder.g u0(p1 p1Var) {
        com.google.android.exoplayer2.decoder.g u02 = super.u0(p1Var);
        this.H0.q(p1Var.f25652b, u02);
        return u02;
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void v0(o1 o1Var, MediaFormat mediaFormat) {
        int i11;
        o1 o1Var2 = this.L0;
        int[] iArr = null;
        if (o1Var2 != null) {
            o1Var = o1Var2;
        } else if (X() != null) {
            o1 E = new o1.b().e0(MimeTypes.AUDIO_RAW).Y(MimeTypes.AUDIO_RAW.equals(o1Var.f25550l) ? o1Var.A : (p0.f27680a < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey("v-bits-per-sample") ? p0.c0(mediaFormat.getInteger("v-bits-per-sample")) : 2 : mediaFormat.getInteger("pcm-encoding")).N(o1Var.B).O(o1Var.C).H(mediaFormat.getInteger("channel-count")).f0(mediaFormat.getInteger("sample-rate")).E();
            if (this.K0 && E.f25563y == 6 && (i11 = o1Var.f25563y) < 6) {
                iArr = new int[i11];
                for (int i12 = 0; i12 < o1Var.f25563y; i12++) {
                    iArr[i12] = i12;
                }
            }
            o1Var = E;
        }
        try {
            this.I0.l(o1Var, 0, iArr);
        } catch (AudioSink.ConfigurationException e11) {
            throw f(e11, e11.format, 5001);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    public void x0() {
        super.x0();
        this.I0.handleDiscontinuity();
    }

    @Override // com.google.android.exoplayer2.mediacodec.MediaCodecRenderer
    protected void y0(DecoderInputBuffer decoderInputBuffer) {
        if (!this.N0 || decoderInputBuffer.g()) {
            return;
        }
        if (Math.abs(decoderInputBuffer.f24899e - this.M0) > 500000) {
            this.M0 = decoderInputBuffer.f24899e;
        }
        this.N0 = false;
    }
}
