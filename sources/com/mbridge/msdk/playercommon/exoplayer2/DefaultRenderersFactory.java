package com.mbridge.msdk.playercommon.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor;
import com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager;
import com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto;
import com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataOutput;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.text.TextOutput;
import com.mbridge.msdk.playercommon.exoplayer2.text.TextRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.video.MediaCodecVideoRenderer;
import com.mbridge.msdk.playercommon.exoplayer2.video.VideoRendererEventListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class DefaultRenderersFactory implements RenderersFactory {
    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000;
    public static final int EXTENSION_RENDERER_MODE_OFF = 0;
    public static final int EXTENSION_RENDERER_MODE_ON = 1;
    public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
    protected static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
    private static final String TAG = "DefaultRenderersFactory";
    private final long allowedVideoJoiningTimeMs;
    private final Context context;

    @Nullable
    private final DrmSessionManager<FrameworkMediaCrypto> drmSessionManager;
    private final int extensionRendererMode;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes5.dex */
    public @interface ExtensionRendererMode {
    }

    public DefaultRenderersFactory(Context context) {
        this(context, 0);
    }

    public DefaultRenderersFactory(Context context, int i11) {
        this(context, null, i11, 5000L);
    }

    public DefaultRenderersFactory(Context context, int i11, long j11) {
        this(context, null, i11, j11);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager) {
        this(context, drmSessionManager, 0);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, int i11) {
        this(context, drmSessionManager, i11, 5000L);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, int i11, long j11) {
        this.context = context;
        this.extensionRendererMode = i11;
        this.allowedVideoJoiningTimeMs = j11;
        this.drmSessionManager = drmSessionManager;
    }

    protected AudioProcessor[] buildAudioProcessors() {
        return new AudioProcessor[0];
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:5|(1:7)|8|9|10|(2:11|12)|13|14|15|16|17|(2:19|20)) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0090, code lost:
    
        r9 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009a, code lost:
    
        r5 = r9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void buildAudioRenderers(android.content.Context r19, @androidx.annotation.Nullable com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager<com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaCrypto> r20, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor[] r21, android.os.Handler r22, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener r23, int r24, java.util.ArrayList<com.mbridge.msdk.playercommon.exoplayer2.Renderer> r25) {
        /*
            r18 = this;
            r0 = r24
            r1 = r25
            r2 = 0
            r3 = 3
            r4 = 2
            java.lang.Class<com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor[]> r6 = com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor[].class
            java.lang.Class<com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener> r7 = com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener.class
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            com.mbridge.msdk.playercommon.exoplayer2.audio.MediaCodecAudioRenderer r15 = new com.mbridge.msdk.playercommon.exoplayer2.audio.MediaCodecAudioRenderer
            com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector r11 = com.mbridge.msdk.playercommon.exoplayer2.mediacodec.MediaCodecSelector.DEFAULT
            com.mbridge.msdk.playercommon.exoplayer2.audio.AudioCapabilities r16 = com.mbridge.msdk.playercommon.exoplayer2.audio.AudioCapabilities.getCapabilities(r19)
            r13 = 0
            r9 = r15
            r10 = r19
            r12 = r20
            r14 = r22
            r5 = r15
            r15 = r23
            r17 = r21
            r9.<init>(r10, r11, r12, r13, r14, r15, r16, r17)
            r1.add(r5)
            if (r0 != 0) goto L2b
            return
        L2b:
            int r5 = r25.size()
            if (r0 != r4) goto L33
            int r5 = r5 + (-1)
        L33:
            java.lang.String r0 = "com.mbridge.msdk.playercommon.exoplayer2.ext.opus.LibopusAudioRenderer"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Exception -> L5a java.lang.ClassNotFoundException -> L66
            java.lang.Class[] r9 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> L5a java.lang.ClassNotFoundException -> L66
            r9[r2] = r8     // Catch: java.lang.Exception -> L5a java.lang.ClassNotFoundException -> L66
            r10 = 1
            r9[r10] = r7     // Catch: java.lang.Exception -> L5a java.lang.ClassNotFoundException -> L66
            r9[r4] = r6     // Catch: java.lang.Exception -> L5a java.lang.ClassNotFoundException -> L66
            java.lang.reflect.Constructor r0 = r0.getConstructor(r9)     // Catch: java.lang.Exception -> L5a java.lang.ClassNotFoundException -> L66
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L5a java.lang.ClassNotFoundException -> L66
            r9[r2] = r22     // Catch: java.lang.Exception -> L5a java.lang.ClassNotFoundException -> L66
            r9[r10] = r23     // Catch: java.lang.Exception -> L5a java.lang.ClassNotFoundException -> L66
            r9[r4] = r21     // Catch: java.lang.Exception -> L5a java.lang.ClassNotFoundException -> L66
            java.lang.Object r0 = r0.newInstance(r9)     // Catch: java.lang.Exception -> L5a java.lang.ClassNotFoundException -> L66
            com.mbridge.msdk.playercommon.exoplayer2.Renderer r0 = (com.mbridge.msdk.playercommon.exoplayer2.Renderer) r0     // Catch: java.lang.Exception -> L5a java.lang.ClassNotFoundException -> L66
            int r9 = r5 + 1
            r1.add(r5, r0)     // Catch: java.lang.Exception -> L5a java.lang.ClassNotFoundException -> L5c
            goto L67
        L5a:
            r0 = move-exception
            goto L5e
        L5c:
            r5 = r9
            goto L66
        L5e:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating Opus extension"
            r1.<init>(r2, r0)
            throw r1
        L66:
            r9 = r5
        L67:
            java.lang.String r0 = "com.mbridge.msdk.playercommon.exoplayer2.ext.flac.LibflacAudioRenderer"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Exception -> L8e java.lang.ClassNotFoundException -> L9a
            java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> L8e java.lang.ClassNotFoundException -> L9a
            r5[r2] = r8     // Catch: java.lang.Exception -> L8e java.lang.ClassNotFoundException -> L9a
            r10 = 1
            r5[r10] = r7     // Catch: java.lang.Exception -> L8e java.lang.ClassNotFoundException -> L9a
            r5[r4] = r6     // Catch: java.lang.Exception -> L8e java.lang.ClassNotFoundException -> L9a
            java.lang.reflect.Constructor r0 = r0.getConstructor(r5)     // Catch: java.lang.Exception -> L8e java.lang.ClassNotFoundException -> L9a
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> L8e java.lang.ClassNotFoundException -> L9a
            r5[r2] = r22     // Catch: java.lang.Exception -> L8e java.lang.ClassNotFoundException -> L9a
            r5[r10] = r23     // Catch: java.lang.Exception -> L8e java.lang.ClassNotFoundException -> L9a
            r5[r4] = r21     // Catch: java.lang.Exception -> L8e java.lang.ClassNotFoundException -> L9a
            java.lang.Object r0 = r0.newInstance(r5)     // Catch: java.lang.Exception -> L8e java.lang.ClassNotFoundException -> L9a
            com.mbridge.msdk.playercommon.exoplayer2.Renderer r0 = (com.mbridge.msdk.playercommon.exoplayer2.Renderer) r0     // Catch: java.lang.Exception -> L8e java.lang.ClassNotFoundException -> L9a
            int r5 = r9 + 1
            r1.add(r9, r0)     // Catch: java.lang.Exception -> L8e java.lang.ClassNotFoundException -> L90
            goto L9b
        L8e:
            r0 = move-exception
            goto L92
        L90:
            r9 = r5
            goto L9a
        L92:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FLAC extension"
            r1.<init>(r2, r0)
            throw r1
        L9a:
            r5 = r9
        L9b:
            java.lang.String r0 = "com.mbridge.msdk.playercommon.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch: java.lang.Exception -> Lc0 java.lang.ClassNotFoundException -> Lc9
            java.lang.Class[] r9 = new java.lang.Class[r3]     // Catch: java.lang.Exception -> Lc0 java.lang.ClassNotFoundException -> Lc9
            r9[r2] = r8     // Catch: java.lang.Exception -> Lc0 java.lang.ClassNotFoundException -> Lc9
            r8 = 1
            r9[r8] = r7     // Catch: java.lang.Exception -> Lc0 java.lang.ClassNotFoundException -> Lc9
            r9[r4] = r6     // Catch: java.lang.Exception -> Lc0 java.lang.ClassNotFoundException -> Lc9
            java.lang.reflect.Constructor r0 = r0.getConstructor(r9)     // Catch: java.lang.Exception -> Lc0 java.lang.ClassNotFoundException -> Lc9
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Exception -> Lc0 java.lang.ClassNotFoundException -> Lc9
            r3[r2] = r22     // Catch: java.lang.Exception -> Lc0 java.lang.ClassNotFoundException -> Lc9
            r3[r8] = r23     // Catch: java.lang.Exception -> Lc0 java.lang.ClassNotFoundException -> Lc9
            r3[r4] = r21     // Catch: java.lang.Exception -> Lc0 java.lang.ClassNotFoundException -> Lc9
            java.lang.Object r0 = r0.newInstance(r3)     // Catch: java.lang.Exception -> Lc0 java.lang.ClassNotFoundException -> Lc9
            com.mbridge.msdk.playercommon.exoplayer2.Renderer r0 = (com.mbridge.msdk.playercommon.exoplayer2.Renderer) r0     // Catch: java.lang.Exception -> Lc0 java.lang.ClassNotFoundException -> Lc9
            r1.add(r5, r0)     // Catch: java.lang.Exception -> Lc0 java.lang.ClassNotFoundException -> Lc9
            goto Lc9
        Lc0:
            r0 = move-exception
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Error instantiating FFmpeg extension"
            r1.<init>(r2, r0)
            throw r1
        Lc9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.DefaultRenderersFactory.buildAudioRenderers(android.content.Context, com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSessionManager, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioProcessor[], android.os.Handler, com.mbridge.msdk.playercommon.exoplayer2.audio.AudioRendererEventListener, int, java.util.ArrayList):void");
    }

    protected void buildMetadataRenderers(Context context, MetadataOutput metadataOutput, Looper looper, int i11, ArrayList<Renderer> arrayList) {
        arrayList.add(new MetadataRenderer(metadataOutput, looper));
    }

    protected void buildMiscellaneousRenderers(Context context, Handler handler, int i11, ArrayList<Renderer> arrayList) {
    }

    protected void buildTextRenderers(Context context, TextOutput textOutput, Looper looper, int i11, ArrayList<Renderer> arrayList) {
        arrayList.add(new TextRenderer(textOutput, looper));
    }

    protected void buildVideoRenderers(Context context, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager, long j11, Handler handler, VideoRendererEventListener videoRendererEventListener, int i11, ArrayList<Renderer> arrayList) {
        arrayList.add(new MediaCodecVideoRenderer(context, MediaCodecSelector.DEFAULT, j11, drmSessionManager, false, handler, videoRendererEventListener, 50));
        if (i11 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i11 == 2) {
            size--;
        }
        try {
            arrayList.add(size, (Renderer) Class.forName("com.mbridge.msdk.playercommon.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Boolean.TYPE, Long.TYPE, Handler.class, VideoRendererEventListener.class, Integer.TYPE).newInstance(Boolean.TRUE, Long.valueOf(j11), handler, videoRendererEventListener, 50));
        } catch (ClassNotFoundException unused) {
        } catch (Exception e11) {
            throw new RuntimeException("Error instantiating VP9 extension", e11);
        }
    }

    @Override // com.mbridge.msdk.playercommon.exoplayer2.RenderersFactory
    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput, @Nullable DrmSessionManager<FrameworkMediaCrypto> drmSessionManager) {
        DrmSessionManager<FrameworkMediaCrypto> drmSessionManager2 = drmSessionManager == null ? this.drmSessionManager : drmSessionManager;
        ArrayList<Renderer> arrayList = new ArrayList<>();
        DrmSessionManager<FrameworkMediaCrypto> drmSessionManager3 = drmSessionManager2;
        buildVideoRenderers(this.context, drmSessionManager3, this.allowedVideoJoiningTimeMs, handler, videoRendererEventListener, this.extensionRendererMode, arrayList);
        buildAudioRenderers(this.context, drmSessionManager3, buildAudioProcessors(), handler, audioRendererEventListener, this.extensionRendererMode, arrayList);
        buildTextRenderers(this.context, textOutput, handler.getLooper(), this.extensionRendererMode, arrayList);
        buildMetadataRenderers(this.context, metadataOutput, handler.getLooper(), this.extensionRendererMode, arrayList);
        buildMiscellaneousRenderers(this.context, handler, this.extensionRendererMode, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[arrayList.size()]);
    }
}
