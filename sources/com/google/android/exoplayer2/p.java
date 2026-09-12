package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.mediacodec.l;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class p implements b3 {

    /* renamed from: a, reason: collision with root package name */
    private final Context f25640a;

    /* renamed from: e, reason: collision with root package name */
    private boolean f25644e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f25646g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f25647h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f25648i;

    /* renamed from: b, reason: collision with root package name */
    private final com.google.android.exoplayer2.mediacodec.j f25641b = new com.google.android.exoplayer2.mediacodec.j();

    /* renamed from: c, reason: collision with root package name */
    private int f25642c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f25643d = 5000;

    /* renamed from: f, reason: collision with root package name */
    private com.google.android.exoplayer2.mediacodec.o f25645f = com.google.android.exoplayer2.mediacodec.o.f25463a;

    public p(Context context) {
        this.f25640a = context;
    }

    @Override // com.google.android.exoplayer2.b3
    public x2[] a(Handler handler, com.google.android.exoplayer2.video.w wVar, com.google.android.exoplayer2.audio.r rVar, ba.o oVar, com.google.android.exoplayer2.metadata.e eVar) {
        ArrayList arrayList = new ArrayList();
        h(this.f25640a, this.f25642c, this.f25645f, this.f25644e, handler, wVar, this.f25643d, arrayList);
        AudioSink c11 = c(this.f25640a, this.f25646g, this.f25647h, this.f25648i);
        if (c11 != null) {
            b(this.f25640a, this.f25642c, this.f25645f, this.f25644e, c11, handler, rVar, arrayList);
        }
        g(this.f25640a, oVar, handler.getLooper(), this.f25642c, arrayList);
        e(this.f25640a, eVar, handler.getLooper(), this.f25642c, arrayList);
        d(this.f25640a, this.f25642c, arrayList);
        f(this.f25640a, handler, this.f25642c, arrayList);
        return (x2[]) arrayList.toArray(new x2[0]);
    }

    protected void b(Context context, int i11, com.google.android.exoplayer2.mediacodec.o oVar, boolean z10, AudioSink audioSink, Handler handler, com.google.android.exoplayer2.audio.r rVar, ArrayList arrayList) {
        int i12;
        int i13;
        int i14;
        arrayList.add(new com.google.android.exoplayer2.audio.a0(context, i(), oVar, z10, handler, rVar, audioSink));
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
                    arrayList.add(size, (x2) Class.forName("com.google.android.exoplayer2.decoder.midi.MidiRenderer").getConstructor(null).newInstance(null));
                    com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded MidiRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i12;
                    i12 = size;
                    try {
                        i13 = i12 + 1;
                        arrayList.add(i12, (x2) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.r.class, AudioSink.class).newInstance(handler, rVar, audioSink));
                        com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
                    } catch (ClassNotFoundException unused2) {
                    }
                    try {
                        i14 = i13 + 1;
                        try {
                            arrayList.add(i13, (x2) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.r.class, AudioSink.class).newInstance(handler, rVar, audioSink));
                            com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                        } catch (ClassNotFoundException unused3) {
                            i13 = i14;
                            i14 = i13;
                            arrayList.add(i14, (x2) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.r.class, AudioSink.class).newInstance(handler, rVar, audioSink));
                            com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                        }
                    } catch (ClassNotFoundException unused4) {
                    }
                    arrayList.add(i14, (x2) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.r.class, AudioSink.class).newInstance(handler, rVar, audioSink));
                    com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                }
            } catch (Exception e11) {
                throw new RuntimeException("Error instantiating MIDI extension", e11);
            }
        } catch (ClassNotFoundException unused5) {
        }
        try {
            i13 = i12 + 1;
            try {
                arrayList.add(i12, (x2) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.r.class, AudioSink.class).newInstance(handler, rVar, audioSink));
                com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
            } catch (ClassNotFoundException unused6) {
                i12 = i13;
                i13 = i12;
                i14 = i13 + 1;
                arrayList.add(i13, (x2) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.r.class, AudioSink.class).newInstance(handler, rVar, audioSink));
                com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                arrayList.add(i14, (x2) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.r.class, AudioSink.class).newInstance(handler, rVar, audioSink));
                com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
            }
            try {
                i14 = i13 + 1;
                arrayList.add(i13, (x2) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.r.class, AudioSink.class).newInstance(handler, rVar, audioSink));
                com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                try {
                    arrayList.add(i14, (x2) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, com.google.android.exoplayer2.audio.r.class, AudioSink.class).newInstance(handler, rVar, audioSink));
                    com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
                } catch (ClassNotFoundException unused7) {
                } catch (Exception e12) {
                    throw new RuntimeException("Error instantiating FFmpeg extension", e12);
                }
            } catch (Exception e13) {
                throw new RuntimeException("Error instantiating FLAC extension", e13);
            }
        } catch (Exception e14) {
            throw new RuntimeException("Error instantiating Opus extension", e14);
        }
    }

    protected AudioSink c(Context context, boolean z10, boolean z11, boolean z12) {
        return new DefaultAudioSink.d().g(com.google.android.exoplayer2.audio.f.c(context)).i(z10).h(z11).j(z12 ? 1 : 0).f();
    }

    protected void d(Context context, int i11, ArrayList arrayList) {
        arrayList.add(new ma.b());
    }

    protected void e(Context context, com.google.android.exoplayer2.metadata.e eVar, Looper looper, int i11, ArrayList arrayList) {
        arrayList.add(new com.google.android.exoplayer2.metadata.f(eVar, looper));
    }

    protected void f(Context context, Handler handler, int i11, ArrayList arrayList) {
    }

    protected void g(Context context, ba.o oVar, Looper looper, int i11, ArrayList arrayList) {
        arrayList.add(new ba.p(oVar, looper));
    }

    protected void h(Context context, int i11, com.google.android.exoplayer2.mediacodec.o oVar, boolean z10, Handler handler, com.google.android.exoplayer2.video.w wVar, long j11, ArrayList arrayList) {
        int i12;
        arrayList.add(new com.google.android.exoplayer2.video.g(context, i(), oVar, j11, z10, handler, wVar, 50));
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
                    arrayList.add(size, (x2) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, com.google.android.exoplayer2.video.w.class, Integer.TYPE).newInstance(Long.valueOf(j11), handler, wVar, 50));
                    com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i12;
                    i12 = size;
                    arrayList.add(i12, (x2) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, com.google.android.exoplayer2.video.w.class, Integer.TYPE).newInstance(Long.valueOf(j11), handler, wVar, 50));
                    com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
                }
            } catch (ClassNotFoundException unused2) {
            }
            try {
                arrayList.add(i12, (x2) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, com.google.android.exoplayer2.video.w.class, Integer.TYPE).newInstance(Long.valueOf(j11), handler, wVar, 50));
                com.google.android.exoplayer2.util.s.f("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
            } catch (ClassNotFoundException unused3) {
            } catch (Exception e11) {
                throw new RuntimeException("Error instantiating AV1 extension", e11);
            }
        } catch (Exception e12) {
            throw new RuntimeException("Error instantiating VP9 extension", e12);
        }
    }

    protected l.b i() {
        return this.f25641b;
    }

    public p j(boolean z10) {
        this.f25644e = z10;
        return this;
    }
}
