package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes2.dex */
public abstract class MediaCodecUtil {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap f12256a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private static int f12257b = -1;

    /* loaded from: classes2.dex */
    public static class DecoderQueryException extends Exception {
        private DecoderQueryException(Throwable th2) {
            super("Failed to query underlying media codecs", th2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        public final String f12258a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f12259b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f12260c;

        public b(String str, boolean z10, boolean z11) {
            this.f12258a = str;
            this.f12259b = z10;
            this.f12260c = z11;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != b.class) {
                return false;
            }
            b bVar = (b) obj;
            return TextUtils.equals(this.f12258a, bVar.f12258a) && this.f12259b == bVar.f12259b && this.f12260c == bVar.f12260c;
        }

        public int hashCode() {
            return ((((this.f12258a.hashCode() + 31) * 31) + (this.f12259b ? 1231 : 1237)) * 31) + (this.f12260c ? 1231 : 1237);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface c {
        boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int getCodecCount();

        MediaCodecInfo getCodecInfoAt(int i11);

        boolean secureDecodersExplicit();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class d implements c {
        private d() {
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.c
        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return "secure-playback".equals(str) && MimeTypes.VIDEO_H264.equals(str2);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.c
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return false;
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.c
        public int getCodecCount() {
            return MediaCodecList.getCodecCount();
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.c
        public MediaCodecInfo getCodecInfoAt(int i11) {
            return MediaCodecList.getCodecInfoAt(i11);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.c
        public boolean secureDecodersExplicit() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class e implements c {

        /* renamed from: a, reason: collision with root package name */
        private final int f12261a;

        /* renamed from: b, reason: collision with root package name */
        private MediaCodecInfo[] f12262b;

        public e(boolean z10, boolean z11, boolean z12) {
            this.f12261a = (z10 || z11 || z12) ? 1 : 0;
        }

        private void c() {
            if (this.f12262b == null) {
                this.f12262b = new MediaCodecList(this.f12261a).getCodecInfos();
            }
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.c
        public boolean a(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.c
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.c
        public int getCodecCount() {
            c();
            return this.f12262b.length;
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.c
        public MediaCodecInfo getCodecInfoAt(int i11) {
            c();
            return this.f12262b[i11];
        }

        @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.c
        public boolean secureDecodersExplicit() {
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public interface f {
        int a(Object obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int A(w wVar) {
        String str = wVar.f12337a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (a1.f10432a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int B(androidx.media3.common.r rVar, w wVar) {
        return wVar.n(rVar) ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int C(w wVar) {
        return (wVar.f12345i ? 2 : 0) + (!wVar.f12346j ? 1 : 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int D(f fVar, Object obj, Object obj2) {
        return fVar.a(obj2) - fVar.a(obj);
    }

    private static void E(List list, final f fVar) {
        Collections.sort(list, new Comparator() { // from class: androidx.media3.exoplayer.mediacodec.o0
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int D;
                D = MediaCodecUtil.D(MediaCodecUtil.f.this, obj, obj2);
                return D;
            }
        });
    }

    private static void e(String str, List list) {
        if (MimeTypes.AUDIO_RAW.equals(str)) {
            if (a1.f10432a < 26 && Build.DEVICE.equals("R9") && list.size() == 1 && ((w) list.get(0)).f12337a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(w.D("OMX.google.raw.decoder", MimeTypes.AUDIO_RAW, MimeTypes.AUDIO_RAW, null, false, true, false, false, false));
            }
            E(list, new f() { // from class: androidx.media3.exoplayer.mediacodec.m0
                @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.f
                public final int a(Object obj) {
                    int A;
                    A = MediaCodecUtil.A((w) obj);
                    return A;
                }
            });
        }
        if (a1.f10432a >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(((w) list.get(0)).f12337a)) {
            return;
        }
        list.add((w) list.remove(0));
    }

    public static String f(androidx.media3.common.r rVar) {
        Pair i11;
        if (MimeTypes.AUDIO_E_AC3_JOC.equals(rVar.f10243o)) {
            return MimeTypes.AUDIO_E_AC3;
        }
        if ("video/dolby-vision".equals(rVar.f10243o) && (i11 = i(rVar)) != null) {
            int intValue = ((Integer) i11.first).intValue();
            if (intValue == 16 || intValue == 256) {
                return MimeTypes.VIDEO_H265;
            }
            if (intValue == 512) {
                return MimeTypes.VIDEO_H264;
            }
            if (intValue == 1024) {
                return "video/av01";
            }
        }
        if ("video/mv-hevc".equals(rVar.f10243o)) {
            return MimeTypes.VIDEO_H265;
        }
        return null;
    }

    public static List g(h0 h0Var, androidx.media3.common.r rVar, boolean z10, boolean z11) {
        String f11 = f(rVar);
        return f11 == null ? ImmutableList.of() : h0Var.a(f11, z10, z11);
    }

    private static String h(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals("video/mv-hevc")) {
            if ("c2.qti.mvhevc.decoder".equals(str) || "c2.qti.mvhevc.decoder.secure".equals(str)) {
                return "video/x-mvhevc";
            }
            return null;
        }
        if (str2.equals(MimeTypes.AUDIO_ALAC) && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals(MimeTypes.AUDIO_FLAC) && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals(MimeTypes.AUDIO_AC3) && "OMX.lge.ac3.decoder".equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    public static Pair i(androidx.media3.common.r rVar) {
        return androidx.media3.common.util.j.n(rVar);
    }

    public static w j(String str, boolean z10, boolean z11) {
        List k11 = k(str, z10, z11);
        if (k11.isEmpty()) {
            return null;
        }
        return (w) k11.get(0);
    }

    public static synchronized List k(String str, boolean z10, boolean z11) {
        synchronized (MediaCodecUtil.class) {
            try {
                b bVar = new b(str, z10, z11);
                HashMap hashMap = f12256a;
                List list = (List) hashMap.get(bVar);
                if (list != null) {
                    return list;
                }
                ArrayList l11 = l(bVar, new e(z10, z11, str.equals("video/mv-hevc")));
                if (z10 && l11.isEmpty() && a1.f10432a <= 23) {
                    l11 = l(bVar, new d());
                    if (!l11.isEmpty()) {
                        androidx.media3.common.util.u.h("MediaCodecUtil", "MediaCodecList API didn't list secure decoder for: " + str + ". Assuming: " + ((w) l11.get(0)).f12337a);
                    }
                }
                e(str, l11);
                ImmutableList copyOf = ImmutableList.copyOf((Collection) l11);
                hashMap.put(bVar, copyOf);
                return copyOf;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:28|(4:(2:72|73)|53|(9:56|57|58|59|60|61|62|64|65)|9)|32|33|34|36|9) */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b1, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x008c, code lost:
    
        if (r1.f12259b == false) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0105 A[Catch: Exception -> 0x012e, TRY_ENTER, TryCatch #1 {Exception -> 0x012e, blocks: (B:3:0x0008, B:5:0x001b, B:9:0x0124, B:10:0x002d, B:13:0x0038, B:39:0x00fd, B:42:0x0105, B:44:0x010b, B:47:0x0130, B:48:0x0153), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0130 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.util.ArrayList l(androidx.media3.exoplayer.mediacodec.MediaCodecUtil.b r24, androidx.media3.exoplayer.mediacodec.MediaCodecUtil.c r25) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecUtil.l(androidx.media3.exoplayer.mediacodec.MediaCodecUtil$b, androidx.media3.exoplayer.mediacodec.MediaCodecUtil$c):java.util.ArrayList");
    }

    public static List m(h0 h0Var, androidx.media3.common.r rVar, boolean z10, boolean z11) {
        List a11 = h0Var.a(rVar.f10243o, z10, z11);
        return ImmutableList.builder().l(a11).l(g(h0Var, rVar, z10, z11)).e();
    }

    public static List n(List list, final androidx.media3.common.r rVar) {
        ArrayList arrayList = new ArrayList(list);
        E(arrayList, new f() { // from class: androidx.media3.exoplayer.mediacodec.n0
            @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.f
            public final int a(Object obj) {
                int B;
                B = MediaCodecUtil.B(androidx.media3.common.r.this, (w) obj);
                return B;
            }
        });
        return arrayList;
    }

    public static List o(List list) {
        ArrayList arrayList = new ArrayList(list);
        E(arrayList, new f() { // from class: androidx.media3.exoplayer.mediacodec.p0
            @Override // androidx.media3.exoplayer.mediacodec.MediaCodecUtil.f
            public final int a(Object obj) {
                int C;
                C = MediaCodecUtil.C((w) obj);
                return C;
            }
        });
        return ImmutableList.copyOf((Collection) arrayList);
    }

    public static w p() {
        return j(MimeTypes.AUDIO_RAW, false, false);
    }

    public static Pair q(androidx.media3.common.r rVar) {
        String h11 = androidx.media3.container.g.h(rVar.f10246r);
        if (h11 == null) {
            return null;
        }
        return androidx.media3.common.util.j.q(h11, a1.o1(h11.trim(), "\\."), rVar.C);
    }

    private static boolean r(MediaCodecInfo mediaCodecInfo) {
        return a1.f10432a >= 29 && s(mediaCodecInfo);
    }

    private static boolean s(MediaCodecInfo mediaCodecInfo) {
        boolean isAlias;
        isAlias = mediaCodecInfo.isAlias();
        return isAlias;
    }

    private static boolean t(MediaCodecInfo mediaCodecInfo, String str, boolean z10, String str2) {
        if (mediaCodecInfo.isEncoder() || (!z10 && str.endsWith(".secure"))) {
            return false;
        }
        int i11 = a1.f10432a;
        if (i11 < 24 && (("OMX.SEC.aac.dec".equals(str) || "OMX.Exynos.AAC.Decoder".equals(str)) && "samsung".equals(Build.MANUFACTURER))) {
            String str3 = Build.DEVICE;
            if (str3.startsWith("zeroflte") || str3.startsWith("zerolte") || str3.startsWith("zenlte") || "SC-05G".equals(str3) || "marinelteatt".equals(str3) || "404SC".equals(str3) || "SC-04G".equals(str3) || "SCV31".equals(str3)) {
                return false;
            }
        }
        return (i11 <= 23 && MimeTypes.AUDIO_E_AC3_JOC.equals(str2) && "OMX.MTK.AUDIO.DECODER.DSPAC3".equals(str)) ? false : true;
    }

    private static boolean u(MediaCodecInfo mediaCodecInfo, String str) {
        return a1.f10432a >= 29 ? v(mediaCodecInfo) : !w(mediaCodecInfo, str);
    }

    private static boolean v(MediaCodecInfo mediaCodecInfo) {
        boolean isHardwareAccelerated;
        isHardwareAccelerated = mediaCodecInfo.isHardwareAccelerated();
        return isHardwareAccelerated;
    }

    private static boolean w(MediaCodecInfo mediaCodecInfo, String str) {
        if (a1.f10432a >= 29) {
            return x(mediaCodecInfo);
        }
        if (androidx.media3.common.y.o(str)) {
            return true;
        }
        String e11 = com.google.common.base.a.e(mediaCodecInfo.getName());
        if (e11.startsWith("arc.")) {
            return false;
        }
        if (e11.startsWith("omx.google.") || e11.startsWith("omx.ffmpeg.")) {
            return true;
        }
        if ((e11.startsWith("omx.sec.") && e11.contains(".sw.")) || e11.equals("omx.qcom.video.decoder.hevcswvdec") || e11.startsWith("c2.android.") || e11.startsWith("c2.google.")) {
            return true;
        }
        return (e11.startsWith("omx.") || e11.startsWith("c2.")) ? false : true;
    }

    private static boolean x(MediaCodecInfo mediaCodecInfo) {
        boolean isSoftwareOnly;
        isSoftwareOnly = mediaCodecInfo.isSoftwareOnly();
        return isSoftwareOnly;
    }

    private static boolean y(MediaCodecInfo mediaCodecInfo) {
        if (a1.f10432a >= 29) {
            return z(mediaCodecInfo);
        }
        String e11 = com.google.common.base.a.e(mediaCodecInfo.getName());
        return (e11.startsWith("omx.google.") || e11.startsWith("c2.android.") || e11.startsWith("c2.google.")) ? false : true;
    }

    private static boolean z(MediaCodecInfo mediaCodecInfo) {
        boolean isVendor;
        isVendor = mediaCodecInfo.isVendor();
        return isVendor;
    }
}
