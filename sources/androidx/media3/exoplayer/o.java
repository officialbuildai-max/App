package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.mediacodec.t;
import androidx.media3.exoplayer.video.j;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import d2.c;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class o implements b4 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f12368a;

    /* renamed from: b, reason: collision with root package name */
    private final androidx.media3.exoplayer.mediacodec.k f12369b;

    /* renamed from: e, reason: collision with root package name */
    private boolean f12372e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f12374g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f12375h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f12376i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f12377j;

    /* renamed from: c, reason: collision with root package name */
    private int f12370c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f12371d = 5000;

    /* renamed from: f, reason: collision with root package name */
    private androidx.media3.exoplayer.mediacodec.h0 f12373f = androidx.media3.exoplayer.mediacodec.h0.f12293a;

    /* renamed from: k, reason: collision with root package name */
    private long f12378k = C.TIME_UNSET;

    public o(Context context) {
        this.f12368a = context;
        this.f12369b = new androidx.media3.exoplayer.mediacodec.k(context);
    }

    @Override // androidx.media3.exoplayer.b4
    public w3[] a(Handler handler, androidx.media3.exoplayer.video.i0 i0Var, androidx.media3.exoplayer.audio.x xVar, i2.h hVar, e2.b bVar) {
        ArrayList arrayList = new ArrayList();
        k(this.f12368a, this.f12370c, this.f12373f, this.f12372e, handler, i0Var, this.f12371d, arrayList);
        AudioSink d11 = d(this.f12368a, this.f12374g, this.f12375h);
        if (d11 != null) {
            c(this.f12368a, this.f12370c, this.f12373f, this.f12372e, d11, handler, xVar, arrayList);
        }
        j(this.f12368a, hVar, handler.getLooper(), this.f12370c, arrayList);
        g(this.f12368a, bVar, handler.getLooper(), this.f12370c, arrayList);
        e(this.f12368a, this.f12370c, arrayList);
        f(arrayList);
        h(this.f12368a, handler, this.f12370c, arrayList);
        return (w3[]) arrayList.toArray(new w3[0]);
    }

    @Override // androidx.media3.exoplayer.b4
    public w3 b(w3 w3Var, Handler handler, androidx.media3.exoplayer.video.i0 i0Var, androidx.media3.exoplayer.audio.x xVar, i2.h hVar, e2.b bVar) {
        if (w3Var.getTrackType() == 2) {
            return i(w3Var, this.f12368a, this.f12370c, this.f12373f, this.f12372e, handler, i0Var, this.f12371d);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(7:(2:22|23)|24|25|26|27|28|(6:30|31|32|(2:33|34)|36|37)) */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(android.content.Context r21, int r22, androidx.media3.exoplayer.mediacodec.h0 r23, boolean r24, androidx.media3.exoplayer.audio.AudioSink r25, android.os.Handler r26, androidx.media3.exoplayer.audio.x r27, java.util.ArrayList r28) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.o.c(android.content.Context, int, androidx.media3.exoplayer.mediacodec.h0, boolean, androidx.media3.exoplayer.audio.AudioSink, android.os.Handler, androidx.media3.exoplayer.audio.x, java.util.ArrayList):void");
    }

    protected AudioSink d(Context context, boolean z10, boolean z11) {
        return new DefaultAudioSink.g(context).o(z10).n(z11).j();
    }

    protected void e(Context context, int i11, ArrayList arrayList) {
        arrayList.add(new k2.b());
    }

    protected void f(ArrayList arrayList) {
        arrayList.add(new d2.e(n(), null));
    }

    protected void g(Context context, e2.b bVar, Looper looper, int i11, ArrayList arrayList) {
        arrayList.add(new e2.c(bVar, looper));
        arrayList.add(new e2.c(bVar, looper));
    }

    protected void h(Context context, Handler handler, int i11, ArrayList arrayList) {
    }

    protected w3 i(w3 w3Var, Context context, int i11, androidx.media3.exoplayer.mediacodec.h0 h0Var, boolean z10, Handler handler, androidx.media3.exoplayer.video.i0 i0Var, long j11) {
        if (this.f12376i && w3Var.getClass() == androidx.media3.exoplayer.video.j.class) {
            return new j.d(context).q(m()).v(h0Var).p(j11).r(z10).s(handler).t(i0Var).u(50).o(this.f12377j).n(this.f12378k).m();
        }
        return null;
    }

    protected void j(Context context, i2.h hVar, Looper looper, int i11, ArrayList arrayList) {
        arrayList.add(new i2.i(hVar, looper));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void k(Context context, int i11, androidx.media3.exoplayer.mediacodec.h0 h0Var, boolean z10, Handler handler, androidx.media3.exoplayer.video.i0 i0Var, long j11, ArrayList arrayList) {
        String str;
        int i12;
        arrayList.add(new j.d(context).q(m()).v(h0Var).p(j11).r(z10).s(handler).t(i0Var).u(50).o(this.f12377j).n(this.f12378k).m());
        if (i11 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i11 == 2) {
            size--;
        }
        try {
            try {
                i12 = size + 1;
                try {
                    arrayList.add(size, (w3) Class.forName("androidx.media3.decoder.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, androidx.media3.exoplayer.video.i0.class, Integer.TYPE).newInstance(Long.valueOf(j11), handler, i0Var, 50));
                    str = "DefaultRenderersFactory";
                    try {
                        androidx.media3.common.util.u.f(str, "Loaded LibvpxVideoRenderer.");
                    } catch (ClassNotFoundException unused) {
                        size = i12;
                        i12 = size;
                        try {
                            int i13 = androidx.media3.decoder.av1.c.f11027c0;
                            int i14 = i12 + 1;
                            try {
                                arrayList.add(i12, (w3) androidx.media3.decoder.av1.c.class.getConstructor(Long.TYPE, Handler.class, androidx.media3.exoplayer.video.i0.class, Integer.TYPE).newInstance(Long.valueOf(j11), handler, i0Var, 50));
                                androidx.media3.common.util.u.f(str, "Loaded Libgav1VideoRenderer.");
                            } catch (ClassNotFoundException unused2) {
                            }
                            i12 = i14;
                            arrayList.add(i12, (w3) Class.forName("androidx.media3.decoder.ffmpeg.ExperimentalFfmpegVideoRenderer").getConstructor(Long.TYPE, Handler.class, androidx.media3.exoplayer.video.i0.class, Integer.TYPE).newInstance(Long.valueOf(j11), handler, i0Var, 50));
                            androidx.media3.common.util.u.f(str, "Loaded FfmpegVideoRenderer.");
                        } catch (Exception e11) {
                            throw new IllegalStateException("Error instantiating AV1 extension", e11);
                        }
                    }
                } catch (ClassNotFoundException unused3) {
                    str = "DefaultRenderersFactory";
                }
            } catch (Exception e12) {
                throw new IllegalStateException("Error instantiating VP9 extension", e12);
            }
        } catch (ClassNotFoundException unused4) {
            str = "DefaultRenderersFactory";
        }
        try {
            int i132 = androidx.media3.decoder.av1.c.f11027c0;
            int i142 = i12 + 1;
            arrayList.add(i12, (w3) androidx.media3.decoder.av1.c.class.getConstructor(Long.TYPE, Handler.class, androidx.media3.exoplayer.video.i0.class, Integer.TYPE).newInstance(Long.valueOf(j11), handler, i0Var, 50));
            androidx.media3.common.util.u.f(str, "Loaded Libgav1VideoRenderer.");
            i12 = i142;
        } catch (ClassNotFoundException unused5) {
        }
        try {
            arrayList.add(i12, (w3) Class.forName("androidx.media3.decoder.ffmpeg.ExperimentalFfmpegVideoRenderer").getConstructor(Long.TYPE, Handler.class, androidx.media3.exoplayer.video.i0.class, Integer.TYPE).newInstance(Long.valueOf(j11), handler, i0Var, 50));
            androidx.media3.common.util.u.f(str, "Loaded FfmpegVideoRenderer.");
        } catch (ClassNotFoundException unused6) {
        } catch (Exception e13) {
            throw new IllegalStateException("Error instantiating FFmpeg extension", e13);
        }
    }

    public final o l() {
        this.f12369b.b();
        return this;
    }

    protected t.b m() {
        return this.f12369b;
    }

    protected c.a n() {
        return c.a.f61252a;
    }

    public final o o(boolean z10) {
        this.f12372e = z10;
        return this;
    }

    public final o p(int i11) {
        this.f12370c = i11;
        return this;
    }
}
