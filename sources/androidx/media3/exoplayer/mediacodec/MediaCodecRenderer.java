package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.a1;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.audio.b1;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.mediacodec.t;
import androidx.media3.exoplayer.s2;
import androidx.media3.exoplayer.w3;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import y1.f4;

/* loaded from: classes2.dex */
public abstract class MediaCodecRenderer extends androidx.media3.exoplayer.i {
    private static final byte[] E0 = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, 24, -96, 0, 47, -65, 28, 49, -61, 39, 93, 120};
    private final ArrayDeque A;
    private d A0;
    private final b1 B;
    private long B0;
    private androidx.media3.common.r C;
    private boolean C0;
    private androidx.media3.common.r D;
    private boolean D0;
    private DrmSession E;
    private DrmSession F;
    private w3.a G;
    private MediaCrypto H;
    private long I;
    private float J;
    private float K;
    private t L;
    private androidx.media3.common.r M;
    private MediaFormat N;
    private boolean O;
    private float P;
    private ArrayDeque Q;
    private DecoderInitializationException R;
    private w S;
    private int T;
    private boolean U;
    private boolean V;
    private boolean W;
    private boolean X;
    private boolean Y;
    private boolean Z;

    /* renamed from: a0, reason: collision with root package name */
    private long f12215a0;

    /* renamed from: b0, reason: collision with root package name */
    private boolean f12216b0;

    /* renamed from: c0, reason: collision with root package name */
    private long f12217c0;

    /* renamed from: d0, reason: collision with root package name */
    private int f12218d0;

    /* renamed from: e0, reason: collision with root package name */
    private int f12219e0;

    /* renamed from: f0, reason: collision with root package name */
    private ByteBuffer f12220f0;

    /* renamed from: g0, reason: collision with root package name */
    private boolean f12221g0;

    /* renamed from: h0, reason: collision with root package name */
    private boolean f12222h0;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f12223i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f12224j0;

    /* renamed from: k0, reason: collision with root package name */
    private boolean f12225k0;

    /* renamed from: l0, reason: collision with root package name */
    private boolean f12226l0;

    /* renamed from: m0, reason: collision with root package name */
    private int f12227m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f12228n0;

    /* renamed from: o0, reason: collision with root package name */
    private int f12229o0;

    /* renamed from: p0, reason: collision with root package name */
    private boolean f12230p0;

    /* renamed from: q0, reason: collision with root package name */
    private boolean f12231q0;

    /* renamed from: r, reason: collision with root package name */
    private final t.b f12232r;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f12233r0;

    /* renamed from: s, reason: collision with root package name */
    private final h0 f12234s;

    /* renamed from: s0, reason: collision with root package name */
    private long f12235s0;

    /* renamed from: t, reason: collision with root package name */
    private final boolean f12236t;

    /* renamed from: t0, reason: collision with root package name */
    private long f12237t0;

    /* renamed from: u, reason: collision with root package name */
    private final float f12238u;

    /* renamed from: u0, reason: collision with root package name */
    private boolean f12239u0;

    /* renamed from: v, reason: collision with root package name */
    private final DecoderInputBuffer f12240v;

    /* renamed from: v0, reason: collision with root package name */
    private boolean f12241v0;

    /* renamed from: w, reason: collision with root package name */
    private final DecoderInputBuffer f12242w;

    /* renamed from: w0, reason: collision with root package name */
    private boolean f12243w0;

    /* renamed from: x, reason: collision with root package name */
    private final DecoderInputBuffer f12244x;

    /* renamed from: x0, reason: collision with root package name */
    private boolean f12245x0;

    /* renamed from: y, reason: collision with root package name */
    private final j f12246y;

    /* renamed from: y0, reason: collision with root package name */
    private ExoPlaybackException f12247y0;

    /* renamed from: z, reason: collision with root package name */
    private final MediaCodec.BufferInfo f12248z;

    /* renamed from: z0, reason: collision with root package name */
    protected androidx.media3.exoplayer.j f12249z0;

    /* loaded from: classes2.dex */
    public static class DecoderInitializationException extends Exception {
        private static final int CUSTOM_ERROR_CODE_BASE = -50000;
        private static final int DECODER_QUERY_ERROR = -49998;
        private static final int NO_SUITABLE_DECODER_ERROR = -49999;

        @Nullable
        public final w codecInfo;

        @Nullable
        public final String diagnosticInfo;

        @Nullable
        public final DecoderInitializationException fallbackDecoderInitializationException;

        @Nullable
        public final String mimeType;
        public final boolean secureDecoderRequired;

        public DecoderInitializationException(androidx.media3.common.r rVar, @Nullable Throwable th2, boolean z10, int i11) {
            this("Decoder init failed: [" + i11 + "], " + rVar, th2, rVar.f10243o, z10, null, buildCustomDiagnosticInfo(i11), null);
        }

        public DecoderInitializationException(androidx.media3.common.r rVar, @Nullable Throwable th2, boolean z10, w wVar) {
            this("Decoder init failed: " + wVar.f12337a + ", " + rVar, th2, rVar.f10243o, z10, wVar, th2 instanceof MediaCodec.CodecException ? ((MediaCodec.CodecException) th2).getDiagnosticInfo() : null, null);
        }

        private DecoderInitializationException(@Nullable String str, @Nullable Throwable th2, @Nullable String str2, boolean z10, @Nullable w wVar, @Nullable String str3, @Nullable DecoderInitializationException decoderInitializationException) {
            super(str, th2);
            this.mimeType = str2;
            this.secureDecoderRequired = z10;
            this.codecInfo = wVar;
            this.diagnosticInfo = str3;
            this.fallbackDecoderInitializationException = decoderInitializationException;
        }

        private static String buildCustomDiagnosticInfo(int i11) {
            return "androidx.media3.exoplayer.mediacodec.MediaCodecRenderer_" + (i11 < 0 ? "neg_" : "") + Math.abs(i11);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @CheckResult
        public DecoderInitializationException copyWithFallbackException(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.mimeType, this.secureDecoderRequired, this.codecInfo, this.diagnosticInfo, decoderInitializationException);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {
        public static void a(t.a aVar, f4 f4Var) {
            LogSessionId logSessionId;
            boolean equals;
            String stringId;
            LogSessionId a11 = f4Var.a();
            logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
            equals = a11.equals(logSessionId);
            if (equals) {
                return;
            }
            MediaFormat mediaFormat = aVar.f12331b;
            stringId = a11.getStringId();
            mediaFormat.setString("log-session-id", stringId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class c implements t.c {
        private c() {
        }

        @Override // androidx.media3.exoplayer.mediacodec.t.c
        public void a() {
            if (MediaCodecRenderer.this.G != null) {
                MediaCodecRenderer.this.G.b();
            }
        }

        @Override // androidx.media3.exoplayer.mediacodec.t.c
        public void b() {
            if (MediaCodecRenderer.this.G != null) {
                MediaCodecRenderer.this.G.b();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: e, reason: collision with root package name */
        public static final d f12251e = new d(C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET);

        /* renamed from: a, reason: collision with root package name */
        public final long f12252a;

        /* renamed from: b, reason: collision with root package name */
        public final long f12253b;

        /* renamed from: c, reason: collision with root package name */
        public final long f12254c;

        /* renamed from: d, reason: collision with root package name */
        public final androidx.media3.common.util.o0 f12255d = new androidx.media3.common.util.o0();

        public d(long j11, long j12, long j13) {
            this.f12252a = j11;
            this.f12253b = j12;
            this.f12254c = j13;
        }
    }

    public MediaCodecRenderer(int i11, t.b bVar, h0 h0Var, boolean z10, float f11) {
        super(i11);
        this.f12232r = bVar;
        this.f12234s = (h0) androidx.media3.common.util.a.e(h0Var);
        this.f12236t = z10;
        this.f12238u = f11;
        this.f12240v = DecoderInputBuffer.f();
        this.f12242w = new DecoderInputBuffer(0);
        this.f12244x = new DecoderInputBuffer(2);
        j jVar = new j();
        this.f12246y = jVar;
        this.f12248z = new MediaCodec.BufferInfo();
        this.J = 1.0f;
        this.K = 1.0f;
        this.I = C.TIME_UNSET;
        this.A = new ArrayDeque();
        this.A0 = d.f12251e;
        jVar.b(0);
        jVar.f11000c.order(ByteOrder.nativeOrder());
        this.B = new b1();
        this.P = -1.0f;
        this.T = 0;
        this.f12227m0 = 0;
        this.f12218d0 = -1;
        this.f12219e0 = -1;
        this.f12217c0 = C.TIME_UNSET;
        this.f12235s0 = C.TIME_UNSET;
        this.f12237t0 = C.TIME_UNSET;
        this.B0 = C.TIME_UNSET;
        this.f12215a0 = C.TIME_UNSET;
        this.f12228n0 = 0;
        this.f12229o0 = 0;
        this.f12249z0 = new androidx.media3.exoplayer.j();
    }

    private boolean A0() {
        return this.f12219e0 >= 0;
    }

    private boolean B0() {
        if (!this.f12246y.m()) {
            return true;
        }
        long w11 = w();
        return H0(w11, this.f12246y.k()) == H0(w11, this.f12244x.f11002e);
    }

    private void C0(androidx.media3.common.r rVar) {
        a0();
        String str = rVar.f10243o;
        if (MimeTypes.AUDIO_AAC.equals(str) || MimeTypes.AUDIO_MPEG.equals(str) || MimeTypes.AUDIO_OPUS.equals(str)) {
            this.f12246y.n(32);
        } else {
            this.f12246y.n(1);
        }
        this.f12223i0 = true;
    }

    private void D0(w wVar, MediaCrypto mediaCrypto) {
        androidx.media3.common.r rVar = (androidx.media3.common.r) androidx.media3.common.util.a.e(this.C);
        String str = wVar.f12337a;
        int i11 = a1.f10432a;
        float p02 = i11 < 23 ? -1.0f : p0(this.K, rVar, y());
        float f11 = p02 > this.f12238u ? p02 : -1.0f;
        long elapsedRealtime = s().elapsedRealtime();
        t.a u02 = u0(wVar, rVar, mediaCrypto, f11);
        if (i11 >= 31) {
            b.a(u02, x());
        }
        try {
            androidx.media3.common.util.q0.a("createCodec:" + str);
            t a11 = this.f12232r.a(u02);
            this.L = a11;
            this.f12216b0 = a11.m(new c());
            androidx.media3.common.util.q0.b();
            long elapsedRealtime2 = s().elapsedRealtime();
            if (!wVar.o(rVar)) {
                androidx.media3.common.util.u.h("MediaCodecRenderer", a1.G("Format exceeds selected codec's capabilities [%s, %s]", androidx.media3.common.r.i(rVar), str));
            }
            this.S = wVar;
            this.P = f11;
            this.M = rVar;
            this.T = U(str);
            this.U = Y(str);
            this.V = V(str);
            this.W = W(str);
            this.Z = X(wVar) || o0();
            if (((t) androidx.media3.common.util.a.e(this.L)).g()) {
                this.f12226l0 = true;
                this.f12227m0 = 1;
                this.X = this.T != 0;
            }
            if (getState() == 2) {
                this.f12217c0 = s().elapsedRealtime() + 1000;
            }
            this.f12249z0.f12113a++;
            N0(str, u02, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
        } catch (Throwable th2) {
            androidx.media3.common.util.q0.b();
            throw th2;
        }
    }

    private boolean E0() {
        androidx.media3.common.util.a.g(this.H == null);
        DrmSession drmSession = this.E;
        androidx.media3.decoder.b c11 = drmSession.c();
        if (androidx.media3.exoplayer.drm.c0.f11650d && (c11 instanceof androidx.media3.exoplayer.drm.c0)) {
            int state = drmSession.getState();
            if (state == 1) {
                DrmSession.DrmSessionException drmSessionException = (DrmSession.DrmSessionException) androidx.media3.common.util.a.e(drmSession.getError());
                throw q(drmSessionException, this.C, drmSessionException.errorCode);
            }
            if (state != 4) {
                return false;
            }
        }
        if (c11 == null) {
            return drmSession.getError() != null;
        }
        if (c11 instanceof androidx.media3.exoplayer.drm.c0) {
            androidx.media3.exoplayer.drm.c0 c0Var = (androidx.media3.exoplayer.drm.c0) c11;
            try {
                this.H = new MediaCrypto(c0Var.f11651a, c0Var.f11652b);
            } catch (MediaCryptoException e11) {
                throw q(e11, this.C, 6006);
            }
        }
        return true;
    }

    private boolean H0(long j11, long j12) {
        androidx.media3.common.r rVar;
        return j12 < j11 && !((rVar = this.D) != null && Objects.equals(rVar.f10243o, MimeTypes.AUDIO_OPUS) && l2.k0.g(j11, j12));
    }

    private static boolean I0(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    private void K0(MediaCrypto mediaCrypto, boolean z10) {
        androidx.media3.common.r rVar = (androidx.media3.common.r) androidx.media3.common.util.a.e(this.C);
        if (this.Q == null) {
            try {
                List k02 = k0(z10);
                ArrayDeque arrayDeque = new ArrayDeque();
                this.Q = arrayDeque;
                if (this.f12236t) {
                    arrayDeque.addAll(k02);
                } else if (!k02.isEmpty()) {
                    this.Q.add((w) k02.get(0));
                }
                this.R = null;
            } catch (MediaCodecUtil.DecoderQueryException e11) {
                throw new DecoderInitializationException(rVar, e11, z10, -49998);
            }
        }
        if (this.Q.isEmpty()) {
            throw new DecoderInitializationException(rVar, (Throwable) null, z10, -49999);
        }
        ArrayDeque arrayDeque2 = (ArrayDeque) androidx.media3.common.util.a.e(this.Q);
        while (this.L == null) {
            w wVar = (w) androidx.media3.common.util.a.e((w) arrayDeque2.peekFirst());
            if (!L0(rVar) || !o1(wVar)) {
                return;
            }
            try {
                D0(wVar, mediaCrypto);
            } catch (Exception e12) {
                androidx.media3.common.util.u.i("MediaCodecRenderer", "Failed to initialize decoder: " + wVar, e12);
                arrayDeque2.removeFirst();
                DecoderInitializationException decoderInitializationException = new DecoderInitializationException(rVar, e12, z10, wVar);
                M0(decoderInitializationException);
                if (this.R == null) {
                    this.R = decoderInitializationException;
                } else {
                    this.R = this.R.copyWithFallbackException(decoderInitializationException);
                }
                if (arrayDeque2.isEmpty()) {
                    throw this.R;
                }
            }
        }
        this.Q = null;
    }

    private void R() {
        androidx.media3.common.util.a.g(!this.f12239u0);
        s2 u11 = u();
        this.f12244x.clear();
        do {
            this.f12244x.clear();
            int N = N(u11, this.f12244x, 0);
            if (N == -5) {
                P0(u11);
                return;
            }
            if (N == -4) {
                if (!this.f12244x.isEndOfStream()) {
                    this.f12235s0 = Math.max(this.f12235s0, this.f12244x.f11002e);
                    if (hasReadStreamToEnd() || this.f12242w.isLastSample()) {
                        this.f12237t0 = this.f12235s0;
                    }
                    if (this.f12243w0) {
                        androidx.media3.common.r rVar = (androidx.media3.common.r) androidx.media3.common.util.a.e(this.C);
                        this.D = rVar;
                        if (Objects.equals(rVar.f10243o, MimeTypes.AUDIO_OPUS) && !this.D.f10246r.isEmpty()) {
                            this.D = this.D.b().Z(l2.k0.f((byte[]) this.D.f10246r.get(0))).N();
                        }
                        Q0(this.D, null);
                        this.f12243w0 = false;
                    }
                    this.f12244x.d();
                    androidx.media3.common.r rVar2 = this.D;
                    if (rVar2 != null && Objects.equals(rVar2.f10243o, MimeTypes.AUDIO_OPUS)) {
                        if (this.f12244x.hasSupplementalData()) {
                            DecoderInputBuffer decoderInputBuffer = this.f12244x;
                            decoderInputBuffer.f10998a = this.D;
                            z0(decoderInputBuffer);
                        }
                        if (l2.k0.g(w(), this.f12244x.f11002e)) {
                            this.B.a(this.f12244x, this.D.f10246r);
                        }
                    }
                    if (!B0()) {
                        break;
                    }
                } else {
                    this.f12239u0 = true;
                    this.f12237t0 = this.f12235s0;
                    return;
                }
            } else {
                if (N != -3) {
                    throw new IllegalStateException();
                }
                if (hasReadStreamToEnd()) {
                    this.f12237t0 = this.f12235s0;
                    return;
                }
                return;
            }
        } while (this.f12246y.h(this.f12244x));
        this.f12224j0 = true;
    }

    private boolean S(long j11, long j12) {
        boolean z10;
        androidx.media3.common.util.a.g(!this.f12241v0);
        if (this.f12246y.m()) {
            j jVar = this.f12246y;
            if (!X0(j11, j12, null, jVar.f11000c, this.f12219e0, 0, jVar.l(), this.f12246y.j(), H0(w(), this.f12246y.k()), this.f12246y.isEndOfStream(), (androidx.media3.common.r) androidx.media3.common.util.a.e(this.D))) {
                return false;
            }
            S0(this.f12246y.k());
            this.f12246y.clear();
            z10 = false;
        } else {
            z10 = false;
        }
        if (this.f12239u0) {
            this.f12241v0 = true;
            return z10;
        }
        if (this.f12224j0) {
            androidx.media3.common.util.a.g(this.f12246y.h(this.f12244x));
            this.f12224j0 = z10;
        }
        if (this.f12225k0) {
            if (this.f12246y.m()) {
                return true;
            }
            a0();
            this.f12225k0 = z10;
            J0();
            if (!this.f12223i0) {
                return z10;
            }
        }
        R();
        if (this.f12246y.m()) {
            this.f12246y.d();
        }
        if (this.f12246y.m() || this.f12239u0 || this.f12225k0) {
            return true;
        }
        return z10;
    }

    private int U(String str) {
        int i11 = a1.f10432a;
        if (i11 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = Build.MODEL;
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
        String str3 = Build.DEVICE;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    private static boolean V(String str) {
        return a1.f10432a <= 23 && "OMX.google.vorbis.decoder".equals(str);
    }

    private static boolean W(String str) {
        return a1.f10432a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private void W0() {
        int i11 = this.f12229o0;
        if (i11 == 1) {
            h0();
            return;
        }
        if (i11 == 2) {
            h0();
            v1();
        } else if (i11 == 3) {
            a1();
        } else {
            this.f12241v0 = true;
            c1();
        }
    }

    private static boolean X(w wVar) {
        String str = wVar.f12337a;
        int i11 = a1.f10432a;
        return (i11 <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (i11 <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str) || "OMX.bcm.vdec.avc.tunnel".equals(str) || "OMX.bcm.vdec.avc.tunnel.secure".equals(str) || "OMX.bcm.vdec.hevc.tunnel".equals(str) || "OMX.bcm.vdec.hevc.tunnel.secure".equals(str))) || ("Amazon".equals(Build.MANUFACTURER) && "AFTS".equals(Build.MODEL) && wVar.f12343g);
    }

    private static boolean Y(String str) {
        return a1.f10432a == 29 && "c2.android.aac.decoder".equals(str);
    }

    private void Y0() {
        this.f12233r0 = true;
        MediaFormat c11 = ((t) androidx.media3.common.util.a.e(this.L)).c();
        if (this.T != 0 && c11.getInteger("width") == 32 && c11.getInteger("height") == 32) {
            this.Y = true;
        } else {
            this.N = c11;
            this.O = true;
        }
    }

    private boolean Z0(int i11) {
        s2 u11 = u();
        this.f12240v.clear();
        int N = N(u11, this.f12240v, i11 | 4);
        if (N == -5) {
            P0(u11);
            return true;
        }
        if (N != -4 || !this.f12240v.isEndOfStream()) {
            return false;
        }
        this.f12239u0 = true;
        W0();
        return false;
    }

    private void a0() {
        this.f12225k0 = false;
        this.f12246y.clear();
        this.f12244x.clear();
        this.f12224j0 = false;
        this.f12223i0 = false;
        this.B.d();
    }

    private void a1() {
        b1();
        J0();
    }

    private boolean b0() {
        if (this.f12230p0) {
            this.f12228n0 = 1;
            if (this.V) {
                this.f12229o0 = 3;
                return false;
            }
            this.f12229o0 = 1;
        }
        return true;
    }

    private void c0() {
        if (!this.f12230p0) {
            a1();
        } else {
            this.f12228n0 = 1;
            this.f12229o0 = 3;
        }
    }

    private boolean d0() {
        if (this.f12230p0) {
            this.f12228n0 = 1;
            if (this.V) {
                this.f12229o0 = 3;
                return false;
            }
            this.f12229o0 = 2;
        } else {
            v1();
        }
        return true;
    }

    private boolean e0(long j11, long j12) {
        boolean z10;
        boolean X0;
        ByteBuffer byteBuffer;
        int i11;
        MediaCodec.BufferInfo bufferInfo;
        int j13;
        t tVar = (t) androidx.media3.common.util.a.e(this.L);
        if (!A0()) {
            if (this.W && this.f12231q0) {
                try {
                    j13 = tVar.j(this.f12248z);
                } catch (IllegalStateException unused) {
                    W0();
                    if (this.f12241v0) {
                        b1();
                    }
                    return false;
                }
            } else {
                j13 = tVar.j(this.f12248z);
            }
            if (j13 < 0) {
                if (j13 == -2) {
                    Y0();
                    return true;
                }
                if (this.Z && (this.f12239u0 || this.f12228n0 == 2)) {
                    W0();
                }
                long j14 = this.f12215a0;
                if (j14 != C.TIME_UNSET && j14 + 100 < s().currentTimeMillis()) {
                    W0();
                }
                return false;
            }
            if (this.Y) {
                this.Y = false;
                tVar.k(j13, false);
                return true;
            }
            MediaCodec.BufferInfo bufferInfo2 = this.f12248z;
            if (bufferInfo2.size == 0 && (bufferInfo2.flags & 4) != 0) {
                W0();
                return false;
            }
            this.f12219e0 = j13;
            ByteBuffer l11 = tVar.l(j13);
            this.f12220f0 = l11;
            if (l11 != null) {
                l11.position(this.f12248z.offset);
                ByteBuffer byteBuffer2 = this.f12220f0;
                MediaCodec.BufferInfo bufferInfo3 = this.f12248z;
                byteBuffer2.limit(bufferInfo3.offset + bufferInfo3.size);
            }
            this.f12221g0 = this.f12248z.presentationTimeUs < w();
            long j15 = this.f12237t0;
            this.f12222h0 = j15 != C.TIME_UNSET && j15 <= this.f12248z.presentationTimeUs;
            w1(this.f12248z.presentationTimeUs);
        }
        if (this.W && this.f12231q0) {
            try {
                byteBuffer = this.f12220f0;
                i11 = this.f12219e0;
                bufferInfo = this.f12248z;
                z10 = false;
            } catch (IllegalStateException unused2) {
                z10 = false;
            }
            try {
                X0 = X0(j11, j12, tVar, byteBuffer, i11, bufferInfo.flags, 1, bufferInfo.presentationTimeUs, this.f12221g0, this.f12222h0, (androidx.media3.common.r) androidx.media3.common.util.a.e(this.D));
            } catch (IllegalStateException unused3) {
                W0();
                if (this.f12241v0) {
                    b1();
                }
                return z10;
            }
        } else {
            z10 = false;
            ByteBuffer byteBuffer3 = this.f12220f0;
            int i12 = this.f12219e0;
            MediaCodec.BufferInfo bufferInfo4 = this.f12248z;
            X0 = X0(j11, j12, tVar, byteBuffer3, i12, bufferInfo4.flags, 1, bufferInfo4.presentationTimeUs, this.f12221g0, this.f12222h0, (androidx.media3.common.r) androidx.media3.common.util.a.e(this.D));
        }
        if (X0) {
            S0(this.f12248z.presentationTimeUs);
            boolean z11 = (this.f12248z.flags & 4) != 0 ? true : z10;
            if (!z11 && this.f12231q0 && this.f12222h0) {
                this.f12215a0 = s().currentTimeMillis();
            }
            g1();
            if (!z11) {
                return true;
            }
            W0();
        }
        return z10;
    }

    private boolean f0(w wVar, androidx.media3.common.r rVar, DrmSession drmSession, DrmSession drmSession2) {
        androidx.media3.decoder.b c11;
        androidx.media3.decoder.b c12;
        if (drmSession == drmSession2) {
            return false;
        }
        if (drmSession2 != null && drmSession != null && (c11 = drmSession2.c()) != null && (c12 = drmSession.c()) != null && c11.getClass().equals(c12.getClass())) {
            if (!(c11 instanceof androidx.media3.exoplayer.drm.c0)) {
                return false;
            }
            if (!drmSession2.a().equals(drmSession.a()) || a1.f10432a < 23) {
                return true;
            }
            UUID uuid = androidx.media3.common.h.f10067e;
            if (!uuid.equals(drmSession.a()) && !uuid.equals(drmSession2.a())) {
                if (wVar.f12343g) {
                    return false;
                }
                return drmSession2.getState() == 2 || ((drmSession2.getState() == 3 || drmSession2.getState() == 4) && drmSession2.d((String) androidx.media3.common.util.a.e(rVar.f10243o)));
            }
        }
        return true;
    }

    private void f1() {
        this.f12218d0 = -1;
        this.f12242w.f11000c = null;
    }

    private boolean g0() {
        int i11;
        if (this.L == null || (i11 = this.f12228n0) == 2 || this.f12239u0) {
            return false;
        }
        if (i11 == 0 && p1()) {
            c0();
        }
        t tVar = (t) androidx.media3.common.util.a.e(this.L);
        if (this.f12218d0 < 0) {
            int i12 = tVar.i();
            this.f12218d0 = i12;
            if (i12 < 0) {
                return false;
            }
            this.f12242w.f11000c = tVar.d(i12);
            this.f12242w.clear();
        }
        if (this.f12228n0 == 1) {
            if (!this.Z) {
                this.f12231q0 = true;
                tVar.a(this.f12218d0, 0, 0, 0L, 4);
                f1();
            }
            this.f12228n0 = 2;
            return false;
        }
        if (this.X) {
            this.X = false;
            ByteBuffer byteBuffer = (ByteBuffer) androidx.media3.common.util.a.e(this.f12242w.f11000c);
            byte[] bArr = E0;
            byteBuffer.put(bArr);
            tVar.a(this.f12218d0, 0, bArr.length, 0L, 0);
            f1();
            this.f12230p0 = true;
            return true;
        }
        if (this.f12227m0 == 1) {
            for (int i13 = 0; i13 < ((androidx.media3.common.r) androidx.media3.common.util.a.e(this.M)).f10246r.size(); i13++) {
                ((ByteBuffer) androidx.media3.common.util.a.e(this.f12242w.f11000c)).put((byte[]) this.M.f10246r.get(i13));
            }
            this.f12227m0 = 2;
        }
        int position = ((ByteBuffer) androidx.media3.common.util.a.e(this.f12242w.f11000c)).position();
        s2 u11 = u();
        try {
            int N = N(u11, this.f12242w, 0);
            if (N == -3) {
                if (hasReadStreamToEnd()) {
                    this.f12237t0 = this.f12235s0;
                }
                return false;
            }
            if (N == -5) {
                if (this.f12227m0 == 2) {
                    this.f12242w.clear();
                    this.f12227m0 = 1;
                }
                P0(u11);
                return true;
            }
            if (this.f12242w.isEndOfStream()) {
                this.f12237t0 = this.f12235s0;
                if (this.f12227m0 == 2) {
                    this.f12242w.clear();
                    this.f12227m0 = 1;
                }
                this.f12239u0 = true;
                if (!this.f12230p0) {
                    W0();
                    return false;
                }
                if (!this.Z) {
                    this.f12231q0 = true;
                    tVar.a(this.f12218d0, 0, 0, 0L, 4);
                    f1();
                }
                return false;
            }
            if (!this.f12230p0 && !this.f12242w.isKeyFrame()) {
                this.f12242w.clear();
                if (this.f12227m0 == 2) {
                    this.f12227m0 = 1;
                }
                return true;
            }
            if (n1(this.f12242w)) {
                return true;
            }
            boolean e11 = this.f12242w.e();
            if (e11) {
                this.f12242w.f10999b.b(position);
            }
            long j11 = this.f12242w.f11002e;
            if (this.f12243w0) {
                if (this.A.isEmpty()) {
                    this.A0.f12255d.a(j11, (androidx.media3.common.r) androidx.media3.common.util.a.e(this.C));
                } else {
                    ((d) this.A.peekLast()).f12255d.a(j11, (androidx.media3.common.r) androidx.media3.common.util.a.e(this.C));
                }
                this.f12243w0 = false;
            }
            this.f12235s0 = Math.max(this.f12235s0, j11);
            if (hasReadStreamToEnd() || this.f12242w.isLastSample()) {
                this.f12237t0 = this.f12235s0;
            }
            this.f12242w.d();
            if (this.f12242w.hasSupplementalData()) {
                z0(this.f12242w);
            }
            U0(this.f12242w);
            int m02 = m0(this.f12242w);
            if (e11) {
                ((t) androidx.media3.common.util.a.e(tVar)).f(this.f12218d0, 0, this.f12242w.f10999b, j11, m02);
            } else {
                ((t) androidx.media3.common.util.a.e(tVar)).a(this.f12218d0, 0, ((ByteBuffer) androidx.media3.common.util.a.e(this.f12242w.f11000c)).limit(), j11, m02);
            }
            f1();
            this.f12230p0 = true;
            this.f12227m0 = 0;
            this.f12249z0.f12115c++;
            return true;
        } catch (DecoderInputBuffer.InsufficientCapacityException e12) {
            M0(e12);
            Z0(0);
            h0();
            return true;
        }
    }

    private void g1() {
        this.f12219e0 = -1;
        this.f12220f0 = null;
    }

    private void h0() {
        try {
            ((t) androidx.media3.common.util.a.i(this.L)).flush();
        } finally {
            d1();
        }
    }

    private void h1(DrmSession drmSession) {
        androidx.media3.exoplayer.drm.k.a(this.E, drmSession);
        this.E = drmSession;
    }

    private void i1(d dVar) {
        this.A0 = dVar;
        long j11 = dVar.f12254c;
        if (j11 != C.TIME_UNSET) {
            this.C0 = true;
            R0(j11);
        }
    }

    private List k0(boolean z10) {
        androidx.media3.common.r rVar = (androidx.media3.common.r) androidx.media3.common.util.a.e(this.C);
        List r02 = r0(this.f12234s, rVar, z10);
        if (r02.isEmpty() && z10) {
            r02 = r0(this.f12234s, rVar, false);
            if (!r02.isEmpty()) {
                androidx.media3.common.util.u.h("MediaCodecRenderer", "Drm session requires secure decoder for " + rVar.f10243o + ", but no secure decoder available. Trying to proceed with " + r02 + ".");
            }
        }
        return r02;
    }

    private void l1(DrmSession drmSession) {
        androidx.media3.exoplayer.drm.k.a(this.F, drmSession);
        this.F = drmSession;
    }

    private boolean m1(long j11) {
        return this.I == C.TIME_UNSET || s().elapsedRealtime() - j11 < this.I;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean t1(androidx.media3.common.r rVar) {
        int i11 = rVar.N;
        return i11 == 0 || i11 == 2;
    }

    private boolean u1(androidx.media3.common.r rVar) {
        if (a1.f10432a >= 23 && this.L != null && this.f12229o0 != 3 && getState() != 0) {
            float p02 = p0(this.K, (androidx.media3.common.r) androidx.media3.common.util.a.e(rVar), y());
            float f11 = this.P;
            if (f11 == p02) {
                return true;
            }
            if (p02 == -1.0f) {
                c0();
                return false;
            }
            if (f11 == -1.0f && p02 <= this.f12238u) {
                return true;
            }
            Bundle bundle = new Bundle();
            bundle.putFloat("operating-rate", p02);
            ((t) androidx.media3.common.util.a.e(this.L)).b(bundle);
            this.P = p02;
        }
        return true;
    }

    private void v1() {
        androidx.media3.decoder.b c11 = ((DrmSession) androidx.media3.common.util.a.e(this.F)).c();
        if (c11 instanceof androidx.media3.exoplayer.drm.c0) {
            try {
                ((MediaCrypto) androidx.media3.common.util.a.e(this.H)).setMediaDrmSession(((androidx.media3.exoplayer.drm.c0) c11).f11652b);
            } catch (MediaCryptoException e11) {
                throw q(e11, this.C, 6006);
            }
        }
        h1(this.F);
        this.f12228n0 = 0;
        this.f12229o0 = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.i
    public void C() {
        this.C = null;
        i1(d.f12251e);
        this.A.clear();
        j0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.i
    public void D(boolean z10, boolean z11) {
        this.f12249z0 = new androidx.media3.exoplayer.j();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.i
    public void F(long j11, boolean z10) {
        this.f12239u0 = false;
        this.f12241v0 = false;
        this.f12245x0 = false;
        if (this.f12223i0) {
            this.f12246y.clear();
            this.f12244x.clear();
            this.f12224j0 = false;
            this.B.d();
        } else {
            i0();
        }
        if (this.A0.f12255d.l() > 0) {
            this.f12243w0 = true;
        }
        this.A0.f12255d.c();
        this.A.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean F0() {
        return this.f12223i0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean G0(androidx.media3.common.r rVar) {
        return this.F == null && r1(rVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.i
    public void I() {
        try {
            a0();
            b1();
        } finally {
            l1(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.i
    public void J() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void J0() {
        androidx.media3.common.r rVar;
        boolean z10;
        if (this.L != null || this.f12223i0 || (rVar = this.C) == null) {
            return;
        }
        if (G0(rVar)) {
            C0(rVar);
            return;
        }
        h1(this.F);
        if (this.E == null || E0()) {
            try {
                DrmSession drmSession = this.E;
                if (drmSession != null) {
                    if (drmSession.getState() != 3) {
                        if (this.E.getState() == 4) {
                        }
                    }
                    if (this.E.d((String) androidx.media3.common.util.a.i(rVar.f10243o))) {
                        z10 = true;
                        K0(this.H, z10);
                    }
                }
                z10 = false;
                K0(this.H, z10);
            } catch (DecoderInitializationException e11) {
                throw q(e11, rVar, 4001);
            }
        }
        MediaCrypto mediaCrypto = this.H;
        if (mediaCrypto == null || this.L != null) {
            return;
        }
        mediaCrypto.release();
        this.H = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.media3.exoplayer.i
    public void K() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
    
        if (r5 >= r1) goto L15;
     */
    @Override // androidx.media3.exoplayer.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void L(androidx.media3.common.r[] r13, long r14, long r16, androidx.media3.exoplayer.source.r.b r18) {
        /*
            r12 = this;
            r0 = r12
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$d r1 = r0.A0
            long r1 = r1.f12254c
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L27
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$d r1 = new androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$d
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.i1(r1)
            boolean r1 = r0.D0
            if (r1 == 0) goto L6c
            r12.T0()
            goto L6c
        L27:
            java.util.ArrayDeque r1 = r0.A
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L5c
            long r1 = r0.f12235s0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L3f
            long r5 = r0.B0
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 == 0) goto L5c
            int r1 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r1 < 0) goto L5c
        L3f:
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$d r1 = new androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$d
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r5 = r1
            r8 = r14
            r10 = r16
            r5.<init>(r6, r8, r10)
            r12.i1(r1)
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$d r1 = r0.A0
            long r1 = r1.f12254c
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L6c
            r12.T0()
            goto L6c
        L5c:
            java.util.ArrayDeque r1 = r0.A
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$d r9 = new androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$d
            long r3 = r0.f12235s0
            r2 = r9
            r5 = r14
            r7 = r16
            r2.<init>(r3, r5, r7)
            r1.add(r9)
        L6c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.L(androidx.media3.common.r[], long, long, androidx.media3.exoplayer.source.r$b):void");
    }

    protected boolean L0(androidx.media3.common.r rVar) {
        return true;
    }

    protected abstract void M0(Exception exc);

    protected abstract void N0(String str, t.a aVar, long j11, long j12);

    protected abstract void O0(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00a9, code lost:
    
        if (d0() == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00ab, code lost:
    
        r9 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00dc, code lost:
    
        if (d0() == false) goto L44;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0100  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.media3.exoplayer.k P0(androidx.media3.exoplayer.s2 r12) {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.P0(androidx.media3.exoplayer.s2):androidx.media3.exoplayer.k");
    }

    protected abstract void Q0(androidx.media3.common.r rVar, MediaFormat mediaFormat);

    protected void R0(long j11) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void S0(long j11) {
        this.B0 = j11;
        while (!this.A.isEmpty() && j11 >= ((d) this.A.peek()).f12252a) {
            i1((d) androidx.media3.common.util.a.e((d) this.A.poll()));
            T0();
        }
    }

    protected abstract androidx.media3.exoplayer.k T(w wVar, androidx.media3.common.r rVar, androidx.media3.common.r rVar2);

    /* JADX INFO: Access modifiers changed from: protected */
    public void T0() {
    }

    protected void U0(DecoderInputBuffer decoderInputBuffer) {
    }

    protected void V0(w3.a aVar) {
    }

    protected abstract boolean X0(long j11, long j12, t tVar, ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z10, boolean z11, androidx.media3.common.r rVar);

    protected MediaCodecDecoderException Z(Throwable th2, w wVar) {
        return new MediaCodecDecoderException(th2, wVar);
    }

    @Override // androidx.media3.exoplayer.y3
    public final int a(androidx.media3.common.r rVar) {
        try {
            return s1(this.f12234s, rVar);
        } catch (MediaCodecUtil.DecoderQueryException e11) {
            throw q(e11, rVar, 4002);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void b1() {
        try {
            t tVar = this.L;
            if (tVar != null) {
                tVar.release();
                this.f12249z0.f12114b++;
                O0(((w) androidx.media3.common.util.a.e(this.S)).f12337a);
            }
            this.L = null;
            try {
                MediaCrypto mediaCrypto = this.H;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
            }
        } catch (Throwable th2) {
            this.L = null;
            try {
                MediaCrypto mediaCrypto2 = this.H;
                if (mediaCrypto2 != null) {
                    mediaCrypto2.release();
                }
                throw th2;
            } finally {
            }
        }
    }

    protected abstract void c1();

    @Override // androidx.media3.exoplayer.i, androidx.media3.exoplayer.w3
    public void d(float f11, float f12) {
        this.J = f11;
        this.K = f12;
        u1(this.M);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d1() {
        f1();
        g1();
        this.f12217c0 = C.TIME_UNSET;
        this.f12231q0 = false;
        this.f12215a0 = C.TIME_UNSET;
        this.f12230p0 = false;
        this.X = false;
        this.Y = false;
        this.f12221g0 = false;
        this.f12222h0 = false;
        this.f12235s0 = C.TIME_UNSET;
        this.f12237t0 = C.TIME_UNSET;
        this.B0 = C.TIME_UNSET;
        this.f12228n0 = 0;
        this.f12229o0 = 0;
        this.f12227m0 = this.f12226l0 ? 1 : 0;
    }

    protected void e1() {
        d1();
        this.f12247y0 = null;
        this.Q = null;
        this.S = null;
        this.M = null;
        this.N = null;
        this.O = false;
        this.f12233r0 = false;
        this.P = -1.0f;
        this.T = 0;
        this.U = false;
        this.V = false;
        this.W = false;
        this.Z = false;
        this.f12216b0 = false;
        this.f12226l0 = false;
        this.f12227m0 = 0;
    }

    @Override // androidx.media3.exoplayer.i, androidx.media3.exoplayer.t3.b
    public void handleMessage(int i11, Object obj) {
        if (i11 != 11) {
            super.handleMessage(i11, obj);
            return;
        }
        w3.a aVar = (w3.a) androidx.media3.common.util.a.e((w3.a) obj);
        this.G = aVar;
        V0(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean i0() {
        boolean j02 = j0();
        if (j02) {
            J0();
        }
        return j02;
    }

    @Override // androidx.media3.exoplayer.w3
    public boolean isEnded() {
        return this.f12241v0;
    }

    @Override // androidx.media3.exoplayer.w3
    public boolean isReady() {
        return this.C != null && (B() || A0() || (this.f12217c0 != C.TIME_UNSET && s().elapsedRealtime() < this.f12217c0));
    }

    protected boolean j0() {
        if (this.L == null) {
            return false;
        }
        int i11 = this.f12229o0;
        if (i11 == 3 || ((this.U && !this.f12233r0) || (this.V && this.f12231q0))) {
            b1();
            return true;
        }
        if (i11 == 2) {
            int i12 = a1.f10432a;
            androidx.media3.common.util.a.g(i12 >= 23);
            if (i12 >= 23) {
                try {
                    v1();
                } catch (ExoPlaybackException e11) {
                    androidx.media3.common.util.u.i("MediaCodecRenderer", "Failed to update the DRM session, releasing the codec instead.", e11);
                    b1();
                    return true;
                }
            }
        }
        h0();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j1() {
        this.f12245x0 = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k1(ExoPlaybackException exoPlaybackException) {
        this.f12247y0 = exoPlaybackException;
    }

    @Override // androidx.media3.exoplayer.i, androidx.media3.exoplayer.w3
    public final long l(long j11, long j12) {
        return s0(j11, j12, this.f12216b0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final t l0() {
        return this.L;
    }

    protected int m0(DecoderInputBuffer decoderInputBuffer) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final w n0() {
        return this.S;
    }

    protected boolean n1(DecoderInputBuffer decoderInputBuffer) {
        if (!q1(decoderInputBuffer)) {
            return false;
        }
        decoderInputBuffer.clear();
        this.f12249z0.f12116d++;
        return true;
    }

    protected boolean o0() {
        return false;
    }

    protected boolean o1(w wVar) {
        return true;
    }

    protected abstract float p0(float f11, androidx.media3.common.r rVar, androidx.media3.common.r[] rVarArr);

    protected boolean p1() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final MediaFormat q0() {
        return this.N;
    }

    protected boolean q1(DecoderInputBuffer decoderInputBuffer) {
        return false;
    }

    protected abstract List r0(h0 h0Var, androidx.media3.common.r rVar, boolean z10);

    protected boolean r1(androidx.media3.common.r rVar) {
        return false;
    }

    @Override // androidx.media3.exoplayer.w3
    public void render(long j11, long j12) {
        boolean z10 = false;
        if (this.f12245x0) {
            this.f12245x0 = false;
            W0();
        }
        ExoPlaybackException exoPlaybackException = this.f12247y0;
        if (exoPlaybackException != null) {
            this.f12247y0 = null;
            throw exoPlaybackException;
        }
        try {
            if (this.f12241v0) {
                c1();
                return;
            }
            if (this.C != null || Z0(2)) {
                J0();
                if (this.f12223i0) {
                    androidx.media3.common.util.q0.a("bypassRender");
                    do {
                    } while (S(j11, j12));
                    androidx.media3.common.util.q0.b();
                } else if (this.L != null) {
                    long elapsedRealtime = s().elapsedRealtime();
                    androidx.media3.common.util.q0.a("drainAndFeed");
                    while (e0(j11, j12) && m1(elapsedRealtime)) {
                    }
                    while (g0() && m1(elapsedRealtime)) {
                    }
                    androidx.media3.common.util.q0.b();
                } else {
                    this.f12249z0.f12116d += P(j11);
                    Z0(1);
                }
                this.f12249z0.c();
            }
        } catch (MediaCodec.CryptoException e11) {
            throw q(e11, this.C, a1.b0(e11.getErrorCode()));
        } catch (IllegalStateException e12) {
            if (!I0(e12)) {
                throw e12;
            }
            M0(e12);
            if ((e12 instanceof MediaCodec.CodecException) && ((MediaCodec.CodecException) e12).isRecoverable()) {
                z10 = true;
            }
            if (z10) {
                b1();
            }
            MediaCodecDecoderException Z = Z(e12, n0());
            throw r(Z, this.C, z10, Z.errorCode == 1101 ? PlaybackException.ERROR_CODE_DECODING_RESOURCES_RECLAIMED : 4003);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long s0(long j11, long j12, boolean z10) {
        return super.l(j11, j12);
    }

    protected abstract int s1(h0 h0Var, androidx.media3.common.r rVar);

    @Override // androidx.media3.exoplayer.i, androidx.media3.exoplayer.y3
    public final int supportsMixedMimeTypeAdaptation() {
        return 8;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public long t0() {
        return this.f12237t0;
    }

    protected abstract t.a u0(w wVar, androidx.media3.common.r rVar, MediaCrypto mediaCrypto, float f11);

    /* JADX INFO: Access modifiers changed from: protected */
    public final long v0() {
        return this.A0.f12254c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final long w0() {
        return this.A0.f12253b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void w1(long j11) {
        androidx.media3.common.r rVar = (androidx.media3.common.r) this.A0.f12255d.j(j11);
        if (rVar == null && this.C0 && this.N != null) {
            rVar = (androidx.media3.common.r) this.A0.f12255d.i();
        }
        if (rVar != null) {
            this.D = rVar;
        } else if (!this.O || this.D == null) {
            return;
        }
        Q0((androidx.media3.common.r) androidx.media3.common.util.a.e(this.D), this.N);
        this.O = false;
        this.C0 = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public float x0() {
        return this.J;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final w3.a y0() {
        return this.G;
    }

    protected abstract void z0(DecoderInputBuffer decoderInputBuffer);
}
