package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Bundle;
import android.os.SystemClock;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.d0;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil;
import com.google.android.exoplayer2.mediacodec.l;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.p1;
import com.google.android.exoplayer2.util.k0;
import com.google.android.exoplayer2.util.m0;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.x;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import e9.u1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes3.dex */
public abstract class MediaCodecRenderer extends com.google.android.exoplayer2.h {
    private static final byte[] F0 = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private final long[] A;
    private ExoPlaybackException A0;
    private o1 B;
    protected com.google.android.exoplayer2.decoder.e B0;
    private o1 C;
    private long C0;
    private DrmSession D;
    private long D0;
    private DrmSession E;
    private int E0;
    private MediaCrypto F;
    private boolean G;
    private long H;
    private float I;
    private float J;
    private l K;
    private o1 L;
    private MediaFormat M;
    private boolean N;
    private float O;
    private ArrayDeque P;
    private DecoderInitializationException Q;
    private m R;
    private int S;
    private boolean T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private boolean f25344a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f25345b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f25346c0;

    /* renamed from: d0, reason: collision with root package name */
    private i f25347d0;

    /* renamed from: e0, reason: collision with root package name */
    private long f25348e0;

    /* renamed from: f0, reason: collision with root package name */
    private int f25349f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f25350g0;

    /* renamed from: h0, reason: collision with root package name */
    private ByteBuffer f25351h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f25352i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f25353j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f25354k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f25355l0;

    /* renamed from: m0, reason: collision with root package name */
    private boolean f25356m0;

    /* renamed from: n, reason: collision with root package name */
    private final l.b f25357n;

    /* renamed from: n0, reason: collision with root package name */
    private boolean f25358n0;

    /* renamed from: o, reason: collision with root package name */
    private final o f25359o;

    /* renamed from: o0, reason: collision with root package name */
    private int f25360o0;

    /* renamed from: p, reason: collision with root package name */
    private final boolean f25361p;

    /* renamed from: p0, reason: collision with root package name */
    private int f25362p0;

    /* renamed from: q, reason: collision with root package name */
    private final float f25363q;

    /* renamed from: q0, reason: collision with root package name */
    private int f25364q0;

    /* renamed from: r, reason: collision with root package name */
    private final DecoderInputBuffer f25365r;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f25366r0;

    /* renamed from: s, reason: collision with root package name */
    private final DecoderInputBuffer f25367s;

    /* renamed from: s0, reason: collision with root package name */
    private boolean f25368s0;

    /* renamed from: t, reason: collision with root package name */
    private final DecoderInputBuffer f25369t;

    /* renamed from: t0, reason: collision with root package name */
    private boolean f25370t0;

    /* renamed from: u, reason: collision with root package name */
    private final h f25371u;

    /* renamed from: u0, reason: collision with root package name */
    private long f25372u0;

    /* renamed from: v, reason: collision with root package name */
    private final k0 f25373v;

    /* renamed from: v0, reason: collision with root package name */
    private long f25374v0;

    /* renamed from: w, reason: collision with root package name */
    private final ArrayList f25375w;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f25376w0;

    /* renamed from: x, reason: collision with root package name */
    private final MediaCodec.BufferInfo f25377x;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f25378x0;

    /* renamed from: y, reason: collision with root package name */
    private final long[] f25379y;

    /* renamed from: y0, reason: collision with root package name */
    private boolean f25380y0;

    /* renamed from: z, reason: collision with root package name */
    private final long[] f25381z;

    /* renamed from: z0, reason: collision with root package name */
    private boolean f25382z0;

    /* loaded from: classes3.dex */
    public static class DecoderInitializationException extends Exception {
        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;

        @Nullable
        public final m codecInfo;

        @Nullable
        public final String diagnosticInfo;

        @Nullable
        public final DecoderInitializationException fallbackDecoderInitializationException;
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(o1 o1Var, @Nullable Throwable th2, boolean z10, int i11) {
            this("Decoder init failed: [" + i11 + "], " + o1Var, th2, o1Var.f25550l, z10, null, buildCustomDiagnosticInfo(i11), null);
        }

        public DecoderInitializationException(o1 o1Var, @Nullable Throwable th2, boolean z10, m mVar) {
            this("Decoder init failed: " + mVar.f25452a + ", " + o1Var, th2, o1Var.f25550l, z10, mVar, p0.f27680a >= 21 ? getDiagnosticInfoV21(th2) : null, null);
        }

        private DecoderInitializationException(String str, @Nullable Throwable th2, String str2, boolean z10, @Nullable m mVar, @Nullable String str3, @Nullable DecoderInitializationException decoderInitializationException) {
            super(str, th2);
            this.mimeType = str2;
            this.secureDecoderRequired = z10;
            this.codecInfo = mVar;
            this.diagnosticInfo = str3;
            this.fallbackDecoderInitializationException = decoderInitializationException;
        }

        private static String buildCustomDiagnosticInfo(int i11) {
            return "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_" + (i11 < 0 ? "neg_" : "") + Math.abs(i11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @CheckResult
        public DecoderInitializationException copyWithFallbackException(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, decoderInitializationException);
        }

        @Nullable
        private static String getDiagnosticInfoV21(@Nullable Throwable th2) {
            if (th2 instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th2).getDiagnosticInfo();
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class a {
        public static void a(l.a aVar, u1 u1Var) {
            LogSessionId logSessionId;
            boolean equals;
            String stringId;
            LogSessionId a11 = u1Var.a();
            logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
            equals = a11.equals(logSessionId);
            if (equals) {
                return;
            }
            MediaFormat mediaFormat = aVar.f25447b;
            stringId = a11.getStringId();
            mediaFormat.setString("log-session-id", stringId);
        }
    }

    public MediaCodecRenderer(int i11, l.b bVar, o oVar, boolean z10, float f11) {
        super(i11);
        this.f25357n = bVar;
        this.f25359o = (o) com.google.android.exoplayer2.util.a.e(oVar);
        this.f25361p = z10;
        this.f25363q = f11;
        this.f25365r = DecoderInputBuffer.p();
        this.f25367s = new DecoderInputBuffer(0);
        this.f25369t = new DecoderInputBuffer(2);
        h hVar = new h();
        this.f25371u = hVar;
        this.f25373v = new k0();
        this.f25375w = new ArrayList();
        this.f25377x = new MediaCodec.BufferInfo();
        this.I = 1.0f;
        this.J = 1.0f;
        this.H = C.TIME_UNSET;
        this.f25379y = new long[10];
        this.f25381z = new long[10];
        this.A = new long[10];
        this.C0 = C.TIME_UNSET;
        this.D0 = C.TIME_UNSET;
        hVar.m(0);
        hVar.f24897c.order(ByteOrder.nativeOrder());
        this.O = -1.0f;
        this.S = 0;
        this.f25360o0 = 0;
        this.f25349f0 = -1;
        this.f25350g0 = -1;
        this.f25348e0 = C.TIME_UNSET;
        this.f25372u0 = C.TIME_UNSET;
        this.f25374v0 = C.TIME_UNSET;
        this.f25362p0 = 0;
        this.f25364q0 = 0;
    }

    private boolean A(long j11, long j12) {
        boolean z10;
        com.google.android.exoplayer2.util.a.g(!this.f25378x0);
        if (this.f25371u.w()) {
            h hVar = this.f25371u;
            if (!A0(j11, j12, null, hVar.f24897c, this.f25350g0, 0, hVar.v(), this.f25371u.t(), this.f25371u.g(), this.f25371u.h(), this.C)) {
                return false;
            }
            w0(this.f25371u.u());
            this.f25371u.b();
            z10 = false;
        } else {
            z10 = false;
        }
        if (this.f25376w0) {
            this.f25378x0 = true;
            return z10;
        }
        if (this.f25355l0) {
            com.google.android.exoplayer2.util.a.g(this.f25371u.r(this.f25369t));
            this.f25355l0 = z10;
        }
        if (this.f25356m0) {
            if (this.f25371u.w()) {
                return true;
            }
            M();
            this.f25356m0 = z10;
            p0();
            if (!this.f25354k0) {
                return z10;
            }
        }
        z();
        if (this.f25371u.w()) {
            this.f25371u.n();
        }
        if (this.f25371u.w() || this.f25376w0 || this.f25356m0) {
            return true;
        }
        return z10;
    }

    private void B0() {
        this.f25370t0 = true;
        MediaFormat c11 = this.K.c();
        if (this.S != 0 && c11.getInteger("width") == 32 && c11.getInteger("height") == 32) {
            this.f25345b0 = true;
            return;
        }
        if (this.Z) {
            c11.setInteger("channel-count", 1);
        }
        this.M = c11;
        this.N = true;
    }

    private int C(String str) {
        int i11 = p0.f27680a;
        if (i11 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = p0.f27683d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i11 >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        String str3 = p0.f27681b;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    private boolean C0(int i11) {
        p1 k11 = k();
        this.f25365r.b();
        int w11 = w(k11, this.f25365r, i11 | 4);
        if (w11 == -5) {
            u0(k11);
            return true;
        }
        if (w11 != -4 || !this.f25365r.h()) {
            return false;
        }
        this.f25376w0 = true;
        z0();
        return false;
    }

    private static boolean D(String str, o1 o1Var) {
        return p0.f27680a < 21 && o1Var.f25552n.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private void D0() {
        E0();
        p0();
    }

    private static boolean E(String str) {
        if (p0.f27680a < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(p0.f27682c)) {
            String str2 = p0.f27681b;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    private static boolean F(String str) {
        int i11 = p0.f27680a;
        if (i11 > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i11 <= 19) {
                String str2 = p0.f27681b;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                }
            }
            return false;
        }
        return true;
    }

    private static boolean G(String str) {
        return p0.f27680a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean H(m mVar) {
        String str = mVar.f25452a;
        int i11 = p0.f27680a;
        return (i11 <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (i11 <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((i11 <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str))) || ("Amazon".equals(p0.f27682c) && "AFTS".equals(p0.f27683d) && mVar.f25458g));
    }

    private static boolean I(String str) {
        int i11 = p0.f27680a;
        return i11 < 18 || (i11 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i11 == 19 && p0.f27683d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private void I0() {
        this.f25349f0 = -1;
        this.f25367s.f24897c = null;
    }

    private static boolean J(String str, o1 o1Var) {
        return p0.f27680a <= 18 && o1Var.f25563y == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    private void J0() {
        this.f25350g0 = -1;
        this.f25351h0 = null;
    }

    private static boolean K(String str) {
        return p0.f27680a == 29 && "c2.android.aac.decoder".equals(str);
    }

    private void K0(DrmSession drmSession) {
        com.google.android.exoplayer2.drm.k.a(this.D, drmSession);
        this.D = drmSession;
    }

    private void M() {
        this.f25356m0 = false;
        this.f25371u.b();
        this.f25369t.b();
        this.f25355l0 = false;
        this.f25354k0 = false;
    }

    private boolean N() {
        if (this.f25366r0) {
            this.f25362p0 = 1;
            if (this.U || this.W) {
                this.f25364q0 = 3;
                return false;
            }
            this.f25364q0 = 1;
        }
        return true;
    }

    private void N0(DrmSession drmSession) {
        com.google.android.exoplayer2.drm.k.a(this.E, drmSession);
        this.E = drmSession;
    }

    private void O() {
        if (!this.f25366r0) {
            D0();
        } else {
            this.f25362p0 = 1;
            this.f25364q0 = 3;
        }
    }

    private boolean O0(long j11) {
        return this.H == C.TIME_UNSET || SystemClock.elapsedRealtime() - j11 < this.H;
    }

    private boolean P() {
        if (this.f25366r0) {
            this.f25362p0 = 1;
            if (this.U || this.W) {
                this.f25364q0 = 3;
                return false;
            }
            this.f25364q0 = 2;
        } else {
            V0();
        }
        return true;
    }

    private boolean Q(long j11, long j12) {
        boolean z10;
        boolean A0;
        l lVar;
        ByteBuffer byteBuffer;
        int i11;
        MediaCodec.BufferInfo bufferInfo;
        int j13;
        if (!i0()) {
            if (this.X && this.f25368s0) {
                try {
                    j13 = this.K.j(this.f25377x);
                } catch (IllegalStateException unused) {
                    z0();
                    if (this.f25378x0) {
                        E0();
                    }
                    return false;
                }
            } else {
                j13 = this.K.j(this.f25377x);
            }
            if (j13 < 0) {
                if (j13 == -2) {
                    B0();
                    return true;
                }
                if (this.f25346c0 && (this.f25376w0 || this.f25362p0 == 2)) {
                    z0();
                }
                return false;
            }
            if (this.f25345b0) {
                this.f25345b0 = false;
                this.K.k(j13, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo2 = this.f25377x;
            if (bufferInfo2.size == 0 && (bufferInfo2.flags & 4) != 0) {
                z0();
                return false;
            }
            this.f25350g0 = j13;
            ByteBuffer l11 = this.K.l(j13);
            this.f25351h0 = l11;
            if (l11 != null) {
                l11.position(this.f25377x.offset);
                ByteBuffer byteBuffer2 = this.f25351h0;
                MediaCodec.BufferInfo bufferInfo3 = this.f25377x;
                byteBuffer2.limit(bufferInfo3.offset + bufferInfo3.size);
            }
            if (this.Y) {
                MediaCodec.BufferInfo bufferInfo4 = this.f25377x;
                if (bufferInfo4.presentationTimeUs == 0 && (bufferInfo4.flags & 4) != 0) {
                    long j14 = this.f25372u0;
                    if (j14 != C.TIME_UNSET) {
                        bufferInfo4.presentationTimeUs = j14;
                    }
                }
            }
            this.f25352i0 = l0(this.f25377x.presentationTimeUs);
            long j15 = this.f25374v0;
            long j16 = this.f25377x.presentationTimeUs;
            this.f25353j0 = j15 == j16;
            W0(j16);
        }
        if (this.X && this.f25368s0) {
            try {
                lVar = this.K;
                byteBuffer = this.f25351h0;
                i11 = this.f25350g0;
                bufferInfo = this.f25377x;
                z10 = false;
            } catch (IllegalStateException unused2) {
                z10 = false;
            }
            try {
                A0 = A0(j11, j12, lVar, byteBuffer, i11, bufferInfo.flags, 1, bufferInfo.presentationTimeUs, this.f25352i0, this.f25353j0, this.C);
            } catch (IllegalStateException unused3) {
                z0();
                if (this.f25378x0) {
                    E0();
                }
                return z10;
            }
        } else {
            z10 = false;
            l lVar2 = this.K;
            ByteBuffer byteBuffer3 = this.f25351h0;
            int i12 = this.f25350g0;
            MediaCodec.BufferInfo bufferInfo5 = this.f25377x;
            A0 = A0(j11, j12, lVar2, byteBuffer3, i12, bufferInfo5.flags, 1, bufferInfo5.presentationTimeUs, this.f25352i0, this.f25353j0, this.C);
        }
        if (A0) {
            w0(this.f25377x.presentationTimeUs);
            boolean z11 = (this.f25377x.flags & 4) != 0 ? true : z10;
            J0();
            if (!z11) {
                return true;
            }
            z0();
        }
        return z10;
    }

    private boolean R(m mVar, o1 o1Var, DrmSession drmSession, DrmSession drmSession2) {
        d0 d02;
        if (drmSession == drmSession2) {
            return false;
        }
        if (drmSession2 == null || drmSession == null || p0.f27680a < 23) {
            return true;
        }
        UUID uuid = com.google.android.exoplayer2.l.f25244e;
        if (uuid.equals(drmSession.a()) || uuid.equals(drmSession2.a()) || (d02 = d0(drmSession2)) == null) {
            return true;
        }
        return !mVar.f25458g && (d02.f25032c ? false : drmSession2.d(o1Var.f25550l));
    }

    private boolean S() {
        int i11;
        if (this.K == null || (i11 = this.f25362p0) == 2 || this.f25376w0) {
            return false;
        }
        if (i11 == 0 && Q0()) {
            O();
        }
        if (this.f25349f0 < 0) {
            int i12 = this.K.i();
            this.f25349f0 = i12;
            if (i12 < 0) {
                return false;
            }
            this.f25367s.f24897c = this.K.d(i12);
            this.f25367s.b();
        }
        if (this.f25362p0 == 1) {
            if (!this.f25346c0) {
                this.f25368s0 = true;
                this.K.a(this.f25349f0, 0, 0, 0L, 4);
                I0();
            }
            this.f25362p0 = 2;
            return false;
        }
        if (this.f25344a0) {
            this.f25344a0 = false;
            ByteBuffer byteBuffer = this.f25367s.f24897c;
            byte[] bArr = F0;
            byteBuffer.put(bArr);
            this.K.a(this.f25349f0, 0, bArr.length, 0L, 0);
            I0();
            this.f25366r0 = true;
            return true;
        }
        if (this.f25360o0 == 1) {
            for (int i13 = 0; i13 < this.L.f25552n.size(); i13++) {
                this.f25367s.f24897c.put((byte[]) this.L.f25552n.get(i13));
            }
            this.f25360o0 = 2;
        }
        int position = this.f25367s.f24897c.position();
        p1 k11 = k();
        try {
            int w11 = w(k11, this.f25367s, 0);
            if (hasReadStreamToEnd()) {
                this.f25374v0 = this.f25372u0;
            }
            if (w11 == -3) {
                return false;
            }
            if (w11 == -5) {
                if (this.f25360o0 == 2) {
                    this.f25367s.b();
                    this.f25360o0 = 1;
                }
                u0(k11);
                return true;
            }
            if (this.f25367s.h()) {
                if (this.f25360o0 == 2) {
                    this.f25367s.b();
                    this.f25360o0 = 1;
                }
                this.f25376w0 = true;
                if (!this.f25366r0) {
                    z0();
                    return false;
                }
                try {
                    if (!this.f25346c0) {
                        this.f25368s0 = true;
                        this.K.a(this.f25349f0, 0, 0, 0L, 4);
                        I0();
                    }
                    return false;
                } catch (MediaCodec.CryptoException e11) {
                    throw f(e11, this.B, p0.V(e11.getErrorCode()));
                }
            }
            if (!this.f25366r0 && !this.f25367s.j()) {
                this.f25367s.b();
                if (this.f25360o0 == 2) {
                    this.f25360o0 = 1;
                }
                return true;
            }
            boolean o11 = this.f25367s.o();
            if (o11) {
                this.f25367s.f24896b.b(position);
            }
            if (this.T && !o11) {
                x.b(this.f25367s.f24897c);
                if (this.f25367s.f24897c.position() == 0) {
                    return true;
                }
                this.T = false;
            }
            DecoderInputBuffer decoderInputBuffer = this.f25367s;
            long j11 = decoderInputBuffer.f24899e;
            i iVar = this.f25347d0;
            if (iVar != null) {
                j11 = iVar.d(this.B, decoderInputBuffer);
                this.f25372u0 = Math.max(this.f25372u0, this.f25347d0.b(this.B));
            }
            long j12 = j11;
            if (this.f25367s.g()) {
                this.f25375w.add(Long.valueOf(j12));
            }
            if (this.f25380y0) {
                this.f25373v.a(j12, this.B);
                this.f25380y0 = false;
            }
            this.f25372u0 = Math.max(this.f25372u0, j12);
            this.f25367s.n();
            if (this.f25367s.f()) {
                h0(this.f25367s);
            }
            y0(this.f25367s);
            try {
                if (o11) {
                    this.K.f(this.f25349f0, 0, this.f25367s.f24896b, j12, 0);
                } else {
                    this.K.a(this.f25349f0, 0, this.f25367s.f24897c.limit(), j12, 0);
                }
                I0();
                this.f25366r0 = true;
                this.f25360o0 = 0;
                this.B0.f24931c++;
                return true;
            } catch (MediaCodec.CryptoException e12) {
                throw f(e12, this.B, p0.V(e12.getErrorCode()));
            }
        } catch (DecoderInputBuffer.InsufficientCapacityException e13) {
            r0(e13);
            C0(0);
            T();
            return true;
        }
    }

    private void T() {
        try {
            this.K.flush();
        } finally {
            G0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean T0(o1 o1Var) {
        int i11 = o1Var.E;
        return i11 == 0 || i11 == 2;
    }

    private boolean U0(o1 o1Var) {
        if (p0.f27680a >= 23 && this.K != null && this.f25364q0 != 3 && getState() != 0) {
            float a02 = a0(this.J, o1Var, n());
            float f11 = this.O;
            if (f11 == a02) {
                return true;
            }
            if (a02 == -1.0f) {
                O();
                return false;
            }
            if (f11 == -1.0f && a02 <= this.f25363q) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", a02);
            this.K.b(bundle);
            this.O = a02;
        }
        return true;
    }

    private void V0() {
        try {
            this.F.setMediaDrmSession(d0(this.E).f25031b);
            K0(this.E);
            this.f25362p0 = 0;
            this.f25364q0 = 0;
        } catch (MediaCryptoException e11) {
            throw f(e11, this.B, 6006);
        }
    }

    private List W(boolean z10) {
        List c02 = c0(this.f25359o, this.B, z10);
        if (c02.isEmpty() && z10) {
            c02 = c0(this.f25359o, this.B, false);
            if (!c02.isEmpty()) {
                com.google.android.exoplayer2.util.s.i("MediaCodecRenderer", "Drm session requires secure decoder for " + this.B.f25550l + ", but no secure decoder available. Trying to proceed with " + c02 + ".");
            }
        }
        return c02;
    }

    private d0 d0(DrmSession drmSession) {
        com.google.android.exoplayer2.decoder.b c11 = drmSession.c();
        if (c11 == null || (c11 instanceof d0)) {
            return (d0) c11;
        }
        throw f(new IllegalArgumentException("Expecting FrameworkCryptoConfig but found: " + c11), this.B, 6001);
    }

    private boolean i0() {
        return this.f25350g0 >= 0;
    }

    private void j0(o1 o1Var) {
        M();
        String str = o1Var.f25550l;
        if (MimeTypes.AUDIO_AAC.equals(str) || MimeTypes.AUDIO_MPEG.equals(str) || MimeTypes.AUDIO_OPUS.equals(str)) {
            this.f25371u.x(32);
        } else {
            this.f25371u.x(1);
        }
        this.f25354k0 = true;
    }

    private void k0(m mVar, MediaCrypto mediaCrypto) {
        String str = mVar.f25452a;
        int i11 = p0.f27680a;
        float a02 = i11 < 23 ? -1.0f : a0(this.J, this.B, n());
        float f11 = a02 > this.f25363q ? a02 : -1.0f;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        l.a e02 = e0(mVar, this.B, mediaCrypto, f11);
        if (i11 >= 31) {
            a.a(e02, m());
        }
        try {
            m0.a("createCodec:" + str);
            this.K = this.f25357n.a(e02);
            m0.c();
            long elapsedRealtime2 = SystemClock.elapsedRealtime();
            this.R = mVar;
            this.O = f11;
            this.L = this.B;
            this.S = C(str);
            this.T = D(str, this.L);
            this.U = I(str);
            this.V = K(str);
            this.W = F(str);
            this.X = G(str);
            this.Y = E(str);
            this.Z = J(str, this.L);
            this.f25346c0 = H(mVar) || Z();
            if (this.K.g()) {
                this.f25358n0 = true;
                this.f25360o0 = 1;
                this.f25344a0 = this.S != 0;
            }
            if ("c2.android.mp3.decoder".equals(mVar.f25452a)) {
                this.f25347d0 = new i();
            }
            if (getState() == 2) {
                this.f25348e0 = SystemClock.elapsedRealtime() + 1000;
            }
            this.B0.f24929a++;
            s0(str, e02, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
        } catch (Throwable th2) {
            m0.c();
            throw th2;
        }
    }

    private boolean l0(long j11) {
        int size = this.f25375w.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (((Long) this.f25375w.get(i11)).longValue() == j11) {
                this.f25375w.remove(i11);
                return true;
            }
        }
        return false;
    }

    private static boolean m0(IllegalStateException illegalStateException) {
        if (p0.f27680a >= 21 && n0(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    private static boolean n0(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    private static boolean o0(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x004a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void q0(android.media.MediaCrypto r8, boolean r9) {
        /*
            r7 = this;
            java.util.ArrayDeque r0 = r7.P
            r1 = 0
            if (r0 != 0) goto L3a
            java.util.List r0 = r7.W(r9)     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            java.util.ArrayDeque r2 = new java.util.ArrayDeque     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            r2.<init>()     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            r7.P = r2     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            boolean r3 = r7.f25361p     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            if (r3 == 0) goto L1a
            r2.addAll(r0)     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            goto L2c
        L18:
            r8 = move-exception
            goto L2f
        L1a:
            boolean r2 = r0.isEmpty()     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            if (r2 != 0) goto L2c
            java.util.ArrayDeque r2 = r7.P     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            r3 = 0
            java.lang.Object r0 = r0.get(r3)     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            com.google.android.exoplayer2.mediacodec.m r0 = (com.google.android.exoplayer2.mediacodec.m) r0     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            r2.add(r0)     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
        L2c:
            r7.Q = r1     // Catch: com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException -> L18
            goto L3a
        L2f:
            com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException r0 = new com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException
            com.google.android.exoplayer2.o1 r1 = r7.B
            r2 = -49998(0xffffffffffff3cb2, float:NaN)
            r0.<init>(r1, r8, r9, r2)
            throw r0
        L3a:
            java.util.ArrayDeque r0 = r7.P
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Lb6
            java.util.ArrayDeque r0 = r7.P
            java.lang.Object r0 = r0.peekFirst()
            com.google.android.exoplayer2.mediacodec.m r0 = (com.google.android.exoplayer2.mediacodec.m) r0
        L4a:
            com.google.android.exoplayer2.mediacodec.l r2 = r7.K
            if (r2 != 0) goto Lb3
            java.util.ArrayDeque r2 = r7.P
            java.lang.Object r2 = r2.peekFirst()
            com.google.android.exoplayer2.mediacodec.m r2 = (com.google.android.exoplayer2.mediacodec.m) r2
            boolean r3 = r7.P0(r2)
            if (r3 != 0) goto L5d
            return
        L5d:
            r7.k0(r2, r8)     // Catch: java.lang.Exception -> L61
            goto L4a
        L61:
            r3 = move-exception
            java.lang.String r4 = "MediaCodecRenderer"
            if (r2 != r0) goto L76
            java.lang.String r3 = "Preferred decoder instantiation failed. Sleeping for 50ms then retrying."
            com.google.android.exoplayer2.util.s.i(r4, r3)     // Catch: java.lang.Exception -> L74
            r5 = 50
            java.lang.Thread.sleep(r5)     // Catch: java.lang.Exception -> L74
            r7.k0(r2, r8)     // Catch: java.lang.Exception -> L74
            goto L4a
        L74:
            r3 = move-exception
            goto L77
        L76:
            throw r3     // Catch: java.lang.Exception -> L74
        L77:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Failed to initialize decoder: "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r5 = r5.toString()
            com.google.android.exoplayer2.util.s.j(r4, r5, r3)
            java.util.ArrayDeque r4 = r7.P
            r4.removeFirst()
            com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException r4 = new com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException
            com.google.android.exoplayer2.o1 r5 = r7.B
            r4.<init>(r5, r3, r9, r2)
            r7.r0(r4)
            com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException r2 = r7.Q
            if (r2 != 0) goto La1
            r7.Q = r4
            goto La7
        La1:
            com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException r2 = com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException.access$000(r2, r4)
            r7.Q = r2
        La7:
            java.util.ArrayDeque r2 = r7.P
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto Lb0
            goto L4a
        Lb0:
            com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException r8 = r7.Q
            throw r8
        Lb3:
            r7.P = r1
            return
        Lb6:
            com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException r8 = new com.google.android.exoplayer2.mediacodec.MediaCodecRenderer$DecoderInitializationException
            com.google.android.exoplayer2.o1 r0 = r7.B
            r2 = -49999(0xffffffffffff3cb1, float:NaN)
            r8.<init>(r0, r1, r9, r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.q0(android.media.MediaCrypto, boolean):void");
    }

    private void z() {
        com.google.android.exoplayer2.util.a.g(!this.f25376w0);
        p1 k11 = k();
        this.f25369t.b();
        do {
            this.f25369t.b();
            int w11 = w(k11, this.f25369t, 0);
            if (w11 == -5) {
                u0(k11);
                return;
            }
            if (w11 != -4) {
                if (w11 != -3) {
                    throw new IllegalStateException();
                }
                return;
            } else {
                if (this.f25369t.h()) {
                    this.f25376w0 = true;
                    return;
                }
                if (this.f25380y0) {
                    o1 o1Var = (o1) com.google.android.exoplayer2.util.a.e(this.B);
                    this.C = o1Var;
                    v0(o1Var, null);
                    this.f25380y0 = false;
                }
                this.f25369t.n();
            }
        } while (this.f25371u.r(this.f25369t));
        this.f25355l0 = true;
    }

    private void z0() {
        int i11 = this.f25364q0;
        if (i11 == 1) {
            T();
            return;
        }
        if (i11 == 2) {
            T();
            V0();
        } else if (i11 == 3) {
            D0();
        } else {
            this.f25378x0 = true;
            F0();
        }
    }

    protected abstract boolean A0(long j11, long j12, l lVar, ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z10, boolean z11, o1 o1Var);

    protected abstract com.google.android.exoplayer2.decoder.g B(m mVar, o1 o1Var, o1 o1Var2);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void E0() {
        try {
            l lVar = this.K;
            if (lVar != null) {
                lVar.release();
                this.B0.f24930b++;
                t0(this.R.f25452a);
            }
            this.K = null;
            try {
                MediaCrypto mediaCrypto = this.F;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th2) {
            this.K = null;
            try {
                MediaCrypto mediaCrypto2 = this.F;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th2;
            } finally {
            }
        }
    }

    protected void F0() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G0() {
        I0();
        J0();
        this.f25348e0 = C.TIME_UNSET;
        this.f25368s0 = false;
        this.f25366r0 = false;
        this.f25344a0 = false;
        this.f25345b0 = false;
        this.f25352i0 = false;
        this.f25353j0 = false;
        this.f25375w.clear();
        this.f25372u0 = C.TIME_UNSET;
        this.f25374v0 = C.TIME_UNSET;
        i iVar = this.f25347d0;
        if (iVar != null) {
            iVar.c();
        }
        this.f25362p0 = 0;
        this.f25364q0 = 0;
        this.f25360o0 = this.f25358n0 ? 1 : 0;
    }

    protected void H0() {
        G0();
        this.A0 = null;
        this.f25347d0 = null;
        this.P = null;
        this.R = null;
        this.L = null;
        this.M = null;
        this.N = false;
        this.f25370t0 = false;
        this.O = -1.0f;
        this.S = 0;
        this.T = false;
        this.U = false;
        this.V = false;
        this.W = false;
        this.X = false;
        this.Y = false;
        this.Z = false;
        this.f25346c0 = false;
        this.f25358n0 = false;
        this.f25360o0 = 0;
        this.G = false;
    }

    protected MediaCodecDecoderException L(Throwable th2, m mVar) {
        return new MediaCodecDecoderException(th2, mVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void L0() {
        this.f25382z0 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void M0(ExoPlaybackException exoPlaybackException) {
        this.A0 = exoPlaybackException;
    }

    protected boolean P0(m mVar) {
        return true;
    }

    protected boolean Q0() {
        return false;
    }

    protected boolean R0(o1 o1Var) {
        return false;
    }

    protected abstract int S0(o oVar, o1 o1Var);

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean U() {
        boolean V = V();
        if (V) {
            p0();
        }
        return V;
    }

    protected boolean V() {
        if (this.K == null) {
            return false;
        }
        int i11 = this.f25364q0;
        if (i11 == 3 || this.U || ((this.V && !this.f25370t0) || (this.W && this.f25368s0))) {
            E0();
            return true;
        }
        if (i11 == 2) {
            int i12 = p0.f27680a;
            com.google.android.exoplayer2.util.a.g(i12 >= 23);
            if (i12 >= 23) {
                try {
                    V0();
                } catch (ExoPlaybackException e11) {
                    com.google.android.exoplayer2.util.s.j("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e11);
                    E0();
                    return true;
                }
            }
        }
        T();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void W0(long j11) {
        o1 o1Var = (o1) this.f25373v.j(j11);
        if (o1Var == null && this.N) {
            o1Var = (o1) this.f25373v.i();
        }
        if (o1Var != null) {
            this.C = o1Var;
        } else if (!this.N || this.C == null) {
            return;
        }
        v0(this.C, this.M);
        this.N = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final l X() {
        return this.K;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final m Y() {
        return this.R;
    }

    protected boolean Z() {
        return false;
    }

    @Override // com.google.android.exoplayer2.z2
    public final int a(o1 o1Var) {
        try {
            return S0(this.f25359o, o1Var);
        } catch (MediaCodecUtil.DecoderQueryException e11) {
            throw f(e11, o1Var, 4002);
        }
    }

    protected abstract float a0(float f11, o1 o1Var, o1[] o1VarArr);

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaFormat b0() {
        return this.M;
    }

    protected abstract List c0(o oVar, o1 o1Var, boolean z10);

    @Override // com.google.android.exoplayer2.h, com.google.android.exoplayer2.x2
    public void d(float f11, float f12) {
        this.I = f11;
        this.J = f12;
        U0(this.L);
    }

    protected abstract l.a e0(m mVar, o1 o1Var, MediaCrypto mediaCrypto, float f11);

    /* JADX INFO: Access modifiers changed from: protected */
    public final long f0() {
        return this.D0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float g0() {
        return this.I;
    }

    protected void h0(DecoderInputBuffer decoderInputBuffer) {
    }

    @Override // com.google.android.exoplayer2.x2
    public boolean isEnded() {
        return this.f25378x0;
    }

    @Override // com.google.android.exoplayer2.x2
    public boolean isReady() {
        return this.B != null && (o() || i0() || (this.f25348e0 != C.TIME_UNSET && SystemClock.elapsedRealtime() < this.f25348e0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.h
    public void p() {
        this.B = null;
        this.C0 = C.TIME_UNSET;
        this.D0 = C.TIME_UNSET;
        this.E0 = 0;
        V();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void p0() {
        o1 o1Var;
        if (this.K != null || this.f25354k0 || (o1Var = this.B) == null) {
            return;
        }
        if (this.E == null && R0(o1Var)) {
            j0(this.B);
            return;
        }
        K0(this.E);
        String str = this.B.f25550l;
        DrmSession drmSession = this.D;
        if (drmSession != null) {
            if (this.F == null) {
                d0 d02 = d0(drmSession);
                if (d02 != null) {
                    try {
                        MediaCrypto mediaCrypto = new MediaCrypto(d02.f25030a, d02.f25031b);
                        this.F = mediaCrypto;
                        this.G = !d02.f25032c && mediaCrypto.requiresSecureDecoderComponent(str);
                    } catch (MediaCryptoException e11) {
                        throw f(e11, this.B, 6006);
                    }
                } else if (this.D.getError() == null) {
                    return;
                }
            }
            if (d0.f25029d) {
                int state = this.D.getState();
                if (state == 1) {
                    DrmSession.DrmSessionException drmSessionException = (DrmSession.DrmSessionException) com.google.android.exoplayer2.util.a.e(this.D.getError());
                    throw f(drmSessionException, this.B, drmSessionException.errorCode);
                }
                if (state != 4) {
                    return;
                }
            }
        }
        try {
            q0(this.F, this.G);
        } catch (DecoderInitializationException e12) {
            throw f(e12, this.B, 4001);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.h
    public void q(boolean z10, boolean z11) {
        this.B0 = new com.google.android.exoplayer2.decoder.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.h
    public void r(long j11, boolean z10) {
        this.f25376w0 = false;
        this.f25378x0 = false;
        this.f25382z0 = false;
        if (this.f25354k0) {
            this.f25371u.b();
            this.f25369t.b();
            this.f25355l0 = false;
        } else {
            U();
        }
        if (this.f25373v.l() > 0) {
            this.f25380y0 = true;
        }
        this.f25373v.c();
        int i11 = this.E0;
        if (i11 != 0) {
            this.D0 = this.f25381z[i11 - 1];
            this.C0 = this.f25379y[i11 - 1];
            this.E0 = 0;
        }
    }

    protected abstract void r0(Exception exc);

    @Override // com.google.android.exoplayer2.x2
    public void render(long j11, long j12) {
        boolean z10 = false;
        if (this.f25382z0) {
            this.f25382z0 = false;
            z0();
        }
        ExoPlaybackException exoPlaybackException = this.A0;
        if (exoPlaybackException != null) {
            this.A0 = null;
            throw exoPlaybackException;
        }
        try {
            if (this.f25378x0) {
                F0();
                return;
            }
            if (this.B != null || C0(2)) {
                p0();
                if (this.f25354k0) {
                    m0.a("bypassRender");
                    do {
                    } while (A(j11, j12));
                    m0.c();
                } else if (this.K != null) {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    m0.a("drainAndFeed");
                    while (Q(j11, j12) && O0(elapsedRealtime)) {
                    }
                    while (S() && O0(elapsedRealtime)) {
                    }
                    m0.c();
                } else {
                    this.B0.f24932d += y(j11);
                    C0(1);
                }
                this.B0.c();
            }
        } catch (IllegalStateException e11) {
            if (!m0(e11)) {
                throw e11;
            }
            r0(e11);
            if (p0.f27680a >= 21 && o0(e11)) {
                z10 = true;
            }
            if (z10) {
                E0();
            }
            throw i(L(e11, Y()), this.B, z10, 4003);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.h
    public void s() {
        try {
            M();
            E0();
        } finally {
            N0(null);
        }
    }

    protected abstract void s0(String str, l.a aVar, long j11, long j12);

    @Override // com.google.android.exoplayer2.h, com.google.android.exoplayer2.z2
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.h
    public void t() {
    }

    protected abstract void t0(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.exoplayer2.h
    public void u() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0081, code lost:
    
        if (P() == false) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0083, code lost:
    
        r7 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00b4, code lost:
    
        if (P() == false) goto L39;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.android.exoplayer2.decoder.g u0(com.google.android.exoplayer2.p1 r12) {
        /*
            Method dump skipped, instructions count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.u0(com.google.android.exoplayer2.p1):com.google.android.exoplayer2.decoder.g");
    }

    @Override // com.google.android.exoplayer2.h
    protected void v(o1[] o1VarArr, long j11, long j12) {
        if (this.D0 == C.TIME_UNSET) {
            com.google.android.exoplayer2.util.a.g(this.C0 == C.TIME_UNSET);
            this.C0 = j11;
            this.D0 = j12;
            return;
        }
        int i11 = this.E0;
        if (i11 == this.f25381z.length) {
            com.google.android.exoplayer2.util.s.i("MediaCodecRenderer", "Too many stream changes, so dropping offset: " + this.f25381z[this.E0 - 1]);
        } else {
            this.E0 = i11 + 1;
        }
        long[] jArr = this.f25379y;
        int i12 = this.E0;
        jArr[i12 - 1] = j11;
        this.f25381z[i12 - 1] = j12;
        this.A[i12 - 1] = this.f25372u0;
    }

    protected abstract void v0(o1 o1Var, MediaFormat mediaFormat);

    /* JADX INFO: Access modifiers changed from: protected */
    public void w0(long j11) {
        while (true) {
            int i11 = this.E0;
            if (i11 == 0 || j11 < this.A[0]) {
                return;
            }
            long[] jArr = this.f25379y;
            this.C0 = jArr[0];
            this.D0 = this.f25381z[0];
            int i12 = i11 - 1;
            this.E0 = i12;
            System.arraycopy(jArr, 1, jArr, 0, i12);
            long[] jArr2 = this.f25381z;
            System.arraycopy(jArr2, 1, jArr2, 0, this.E0);
            long[] jArr3 = this.A;
            System.arraycopy(jArr3, 1, jArr3, 0, this.E0);
            x0();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x0() {
    }

    protected abstract void y0(DecoderInputBuffer decoderInputBuffer);
}
