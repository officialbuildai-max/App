package androidx.media3.exoplayer.drm;

import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.UnsupportedSchemeException;
import android.media.metrics.LogSessionId;
import android.os.Build;
import android.text.TextUtils;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.util.a1;
import androidx.media3.exoplayer.drm.b0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import y1.f4;

/* loaded from: classes2.dex */
public final class k0 implements b0 {

    /* renamed from: d, reason: collision with root package name */
    public static final b0.c f11667d = new b0.c() { // from class: androidx.media3.exoplayer.drm.e0
        @Override // androidx.media3.exoplayer.drm.b0.c
        public final b0 a(UUID uuid) {
            b0 v11;
            v11 = k0.v(uuid);
            return v11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final UUID f11668a;

    /* renamed from: b, reason: collision with root package name */
    private final MediaDrm f11669b;

    /* renamed from: c, reason: collision with root package name */
    private int f11670c;

    /* loaded from: classes2.dex */
    private static class a {
        public static boolean a(MediaDrm mediaDrm, String str, int i11) {
            boolean requiresSecureDecoder;
            requiresSecureDecoder = mediaDrm.requiresSecureDecoder(str, i11);
            return requiresSecureDecoder;
        }

        public static void b(MediaDrm mediaDrm, byte[] bArr, f4 f4Var) {
            LogSessionId logSessionId;
            boolean equals;
            MediaDrm.PlaybackComponent playbackComponent;
            LogSessionId a11 = f4Var.a();
            logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
            equals = a11.equals(logSessionId);
            if (equals) {
                return;
            }
            playbackComponent = mediaDrm.getPlaybackComponent(bArr);
            h0.a(androidx.media3.common.util.a.e(playbackComponent)).setLogSessionId(a11);
        }
    }

    private k0(UUID uuid) {
        androidx.media3.common.util.a.e(uuid);
        androidx.media3.common.util.a.b(!androidx.media3.common.h.f10064b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f11668a = uuid;
        MediaDrm mediaDrm = new MediaDrm(n(uuid));
        this.f11669b = mediaDrm;
        this.f11670c = 1;
        if (androidx.media3.common.h.f10066d.equals(uuid) && w()) {
            q(mediaDrm);
        }
    }

    private static byte[] i(byte[] bArr) {
        androidx.media3.common.util.j0 j0Var = new androidx.media3.common.util.j0(bArr);
        int u11 = j0Var.u();
        short w11 = j0Var.w();
        short w12 = j0Var.w();
        if (w11 != 1 || w12 != 1) {
            androidx.media3.common.util.u.f("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
            return bArr;
        }
        short w13 = j0Var.w();
        Charset charset = StandardCharsets.UTF_16LE;
        String F = j0Var.F(w13, charset);
        if (F.contains("<LA_URL>")) {
            return bArr;
        }
        int indexOf = F.indexOf("</DATA>");
        if (indexOf == -1) {
            androidx.media3.common.util.u.h("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
        }
        String str = F.substring(0, indexOf) + "<LA_URL>https://x</LA_URL>" + F.substring(indexOf);
        int i11 = u11 + 52;
        ByteBuffer allocate = ByteBuffer.allocate(i11);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(i11);
        allocate.putShort(w11);
        allocate.putShort(w12);
        allocate.putShort((short) (str.length() * 2));
        allocate.put(str.getBytes(charset));
        return allocate.array();
    }

    private String j(String str) {
        if ("<LA_URL>https://x</LA_URL>".equals(str)) {
            return "";
        }
        if (a1.f10432a >= 33 && "https://default.url".equals(str)) {
            String r11 = r("version");
            if (Objects.equals(r11, "1.2") || Objects.equals(r11, "aidl-1")) {
                return "";
            }
        }
        return str;
    }

    private static byte[] k(UUID uuid, byte[] bArr) {
        return androidx.media3.common.h.f10065c.equals(uuid) ? androidx.media3.exoplayer.drm.a.a(bArr) : bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x006c, code lost:
    
        if ("AFTT".equals(r0) == false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] l(java.util.UUID r3, byte[] r4) {
        /*
            java.util.UUID r0 = androidx.media3.common.h.f10067e
            boolean r1 = r0.equals(r3)
            if (r1 == 0) goto L18
            byte[] r1 = f3.p.e(r4, r3)
            if (r1 != 0) goto Lf
            goto L10
        Lf:
            r4 = r1
        L10:
            byte[] r4 = i(r4)
            byte[] r4 = f3.p.a(r0, r4)
        L18:
            boolean r1 = o(r3)
            if (r1 == 0) goto L2e
            f3.p$a r1 = f3.p.d(r4)
            if (r1 == 0) goto L2e
            java.util.UUID r4 = androidx.media3.common.h.f10064b
            java.util.UUID[] r2 = r1.f62404d
            byte[] r1 = r1.f62403c
            byte[] r4 = f3.p.b(r4, r2, r1)
        L2e:
            int r1 = androidx.media3.common.util.a1.f10432a
            r2 = 23
            if (r1 >= r2) goto L3c
            java.util.UUID r1 = androidx.media3.common.h.f10066d
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L6e
        L3c:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L75
            java.lang.String r0 = "Amazon"
            java.lang.String r1 = android.os.Build.MANUFACTURER
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L75
            java.lang.String r0 = android.os.Build.MODEL
            java.lang.String r1 = "AFTB"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L6e
            java.lang.String r1 = "AFTS"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L6e
            java.lang.String r1 = "AFTM"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L6e
            java.lang.String r1 = "AFTT"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L75
        L6e:
            byte[] r3 = f3.p.e(r4, r3)
            if (r3 == 0) goto L75
            return r3
        L75:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.drm.k0.l(java.util.UUID, byte[]):byte[]");
    }

    private static String m(UUID uuid, String str) {
        return (a1.f10432a < 26 && androidx.media3.common.h.f10065c.equals(uuid) && (MimeTypes.VIDEO_MP4.equals(str) || MimeTypes.AUDIO_MP4.equals(str))) ? C.CENC_TYPE_cenc : str;
    }

    private static UUID n(UUID uuid) {
        return o(uuid) ? androidx.media3.common.h.f10064b : uuid;
    }

    private static boolean o(UUID uuid) {
        return a1.f10432a < 27 && Objects.equals(uuid, androidx.media3.common.h.f10065c);
    }

    private static void q(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    private static DrmInitData.SchemeData s(UUID uuid, List list) {
        if (!androidx.media3.common.h.f10066d.equals(uuid)) {
            return (DrmInitData.SchemeData) list.get(0);
        }
        if (a1.f10432a >= 28 && list.size() > 1) {
            DrmInitData.SchemeData schemeData = (DrmInitData.SchemeData) list.get(0);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                DrmInitData.SchemeData schemeData2 = (DrmInitData.SchemeData) list.get(i12);
                byte[] bArr = (byte[]) androidx.media3.common.util.a.e(schemeData2.data);
                if (Objects.equals(schemeData2.mimeType, schemeData.mimeType) && Objects.equals(schemeData2.licenseServerUrl, schemeData.licenseServerUrl) && f3.p.c(bArr)) {
                    i11 += bArr.length;
                }
            }
            byte[] bArr2 = new byte[i11];
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                byte[] bArr3 = (byte[]) androidx.media3.common.util.a.e(((DrmInitData.SchemeData) list.get(i14)).data);
                int length = bArr3.length;
                System.arraycopy(bArr3, 0, bArr2, i13, length);
                i13 += length;
            }
            return schemeData.copyWithData(bArr2);
        }
        for (int i15 = 0; i15 < list.size(); i15++) {
            DrmInitData.SchemeData schemeData3 = (DrmInitData.SchemeData) list.get(i15);
            int g11 = f3.p.g((byte[]) androidx.media3.common.util.a.e(schemeData3.data));
            int i16 = a1.f10432a;
            if (i16 < 23 && g11 == 0) {
                return schemeData3;
            }
            if (i16 >= 23 && g11 == 1) {
                return schemeData3;
            }
        }
        return (DrmInitData.SchemeData) list.get(0);
    }

    private boolean t() {
        if (!this.f11668a.equals(androidx.media3.common.h.f10066d)) {
            return this.f11668a.equals(androidx.media3.common.h.f10065c);
        }
        String r11 = r("version");
        return (r11.startsWith("v5.") || r11.startsWith("14.") || r11.startsWith("15.") || r11.startsWith("16.0")) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(b0.b bVar, MediaDrm mediaDrm, byte[] bArr, int i11, int i12, byte[] bArr2) {
        bVar.a(this, bArr, i11, i12, bArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ b0 v(UUID uuid) {
        try {
            return x(uuid);
        } catch (UnsupportedDrmException unused) {
            androidx.media3.common.util.u.c("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
            return new y();
        }
    }

    private static boolean w() {
        return "ASUS_Z00AD".equals(Build.MODEL);
    }

    public static k0 x(UUID uuid) {
        try {
            return new k0(uuid);
        } catch (UnsupportedSchemeException e11) {
            throw new UnsupportedDrmException(1, e11);
        } catch (Exception e12) {
            throw new UnsupportedDrmException(2, e12);
        }
    }

    @Override // androidx.media3.exoplayer.drm.b0
    public int a() {
        return 2;
    }

    @Override // androidx.media3.exoplayer.drm.b0
    public boolean c(byte[] bArr, String str) {
        boolean z10;
        MediaCrypto mediaCrypto;
        int securityLevel;
        if (a1.f10432a >= 31 && t()) {
            MediaDrm mediaDrm = this.f11669b;
            securityLevel = mediaDrm.getSecurityLevel(bArr);
            return a.a(mediaDrm, str, securityLevel);
        }
        MediaCrypto mediaCrypto2 = null;
        try {
            try {
                mediaCrypto = new MediaCrypto(n(this.f11668a), bArr);
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (MediaCryptoException unused) {
        }
        try {
            z10 = mediaCrypto.requiresSecureDecoderComponent(str);
            mediaCrypto.release();
        } catch (MediaCryptoException unused2) {
            mediaCrypto2 = mediaCrypto;
            z10 = !this.f11668a.equals(androidx.media3.common.h.f10065c);
            if (mediaCrypto2 != null) {
                mediaCrypto2.release();
            }
            return z10;
        } catch (Throwable th3) {
            th = th3;
            mediaCrypto2 = mediaCrypto;
            if (mediaCrypto2 != null) {
                mediaCrypto2.release();
            }
            throw th;
        }
        return z10;
    }

    @Override // androidx.media3.exoplayer.drm.b0
    public void closeSession(byte[] bArr) {
        this.f11669b.closeSession(bArr);
    }

    @Override // androidx.media3.exoplayer.drm.b0
    public b0.a d(byte[] bArr, List list, int i11, HashMap hashMap) {
        DrmInitData.SchemeData schemeData;
        byte[] bArr2;
        String str;
        if (list != null) {
            schemeData = s(this.f11668a, list);
            bArr2 = l(this.f11668a, (byte[]) androidx.media3.common.util.a.e(schemeData.data));
            str = m(this.f11668a, schemeData.mimeType);
        } else {
            schemeData = null;
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f11669b.getKeyRequest(bArr, bArr2, str, i11, hashMap);
        byte[] k11 = k(this.f11668a, keyRequest.getData());
        String j11 = j(keyRequest.getDefaultUrl());
        if (TextUtils.isEmpty(j11) && schemeData != null && !TextUtils.isEmpty(schemeData.licenseServerUrl)) {
            j11 = schemeData.licenseServerUrl;
        }
        return new b0.a(k11, j11, a1.f10432a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @Override // androidx.media3.exoplayer.drm.b0
    public void e(byte[] bArr, f4 f4Var) {
        if (a1.f10432a >= 31) {
            try {
                a.b(this.f11669b, bArr, f4Var);
            } catch (UnsupportedOperationException unused) {
                androidx.media3.common.util.u.h("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    @Override // androidx.media3.exoplayer.drm.b0
    public void f(final b0.b bVar) {
        this.f11669b.setOnEventListener(bVar == null ? null : new MediaDrm.OnEventListener() { // from class: androidx.media3.exoplayer.drm.f0
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i11, int i12, byte[] bArr2) {
                k0.this.u(bVar, mediaDrm, bArr, i11, i12, bArr2);
            }
        });
    }

    @Override // androidx.media3.exoplayer.drm.b0
    public b0.d getProvisionRequest() {
        MediaDrm.ProvisionRequest provisionRequest = this.f11669b.getProvisionRequest();
        return new b0.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // androidx.media3.exoplayer.drm.b0
    public byte[] openSession() {
        return this.f11669b.openSession();
    }

    @Override // androidx.media3.exoplayer.drm.b0
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public c0 b(byte[] bArr) {
        return new c0(n(this.f11668a), bArr);
    }

    @Override // androidx.media3.exoplayer.drm.b0
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) {
        if (androidx.media3.common.h.f10065c.equals(this.f11668a)) {
            bArr2 = androidx.media3.exoplayer.drm.a.b(bArr2);
        }
        return this.f11669b.provideKeyResponse(bArr, bArr2);
    }

    @Override // androidx.media3.exoplayer.drm.b0
    public void provideProvisionResponse(byte[] bArr) {
        this.f11669b.provideProvisionResponse(bArr);
    }

    @Override // androidx.media3.exoplayer.drm.b0
    public Map queryKeyStatus(byte[] bArr) {
        return this.f11669b.queryKeyStatus(bArr);
    }

    public String r(String str) {
        return this.f11669b.getPropertyString(str);
    }

    @Override // androidx.media3.exoplayer.drm.b0
    public synchronized void release() {
        int i11 = this.f11670c - 1;
        this.f11670c = i11;
        if (i11 == 0) {
            this.f11669b.release();
        }
    }

    @Override // androidx.media3.exoplayer.drm.b0
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        this.f11669b.restoreKeys(bArr, bArr2);
    }
}
