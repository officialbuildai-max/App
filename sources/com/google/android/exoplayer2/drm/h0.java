package com.google.android.exoplayer2.drm;

import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.UnsupportedSchemeException;
import android.media.metrics.LogSessionId;
import android.text.TextUtils;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.c0;
import com.google.android.exoplayer2.util.p0;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import e9.u1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: classes3.dex */
public final class h0 implements c0 {

    /* renamed from: d, reason: collision with root package name */
    public static final c0.c f25038d = new c0.c() { // from class: com.google.android.exoplayer2.drm.e0
        @Override // com.google.android.exoplayer2.drm.c0.c
        public final c0 a(UUID uuid) {
            c0 s11;
            s11 = h0.s(uuid);
            return s11;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    private final UUID f25039a;

    /* renamed from: b, reason: collision with root package name */
    private final MediaDrm f25040b;

    /* renamed from: c, reason: collision with root package name */
    private int f25041c;

    /* loaded from: classes3.dex */
    private static class a {
        public static boolean a(MediaDrm mediaDrm, String str) {
            boolean requiresSecureDecoder;
            requiresSecureDecoder = mediaDrm.requiresSecureDecoder(str);
            return requiresSecureDecoder;
        }

        public static void b(MediaDrm mediaDrm, byte[] bArr, u1 u1Var) {
            LogSessionId logSessionId;
            boolean equals;
            MediaDrm.PlaybackComponent playbackComponent;
            LogSessionId a11 = u1Var.a();
            logSessionId = LogSessionId.LOG_SESSION_ID_NONE;
            equals = a11.equals(logSessionId);
            if (equals) {
                return;
            }
            playbackComponent = mediaDrm.getPlaybackComponent(bArr);
            androidx.media3.exoplayer.drm.h0.a(com.google.android.exoplayer2.util.a.e(playbackComponent)).setLogSessionId(a11);
        }
    }

    private h0(UUID uuid) {
        com.google.android.exoplayer2.util.a.e(uuid);
        com.google.android.exoplayer2.util.a.b(!com.google.android.exoplayer2.l.f25241b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f25039a = uuid;
        MediaDrm mediaDrm = new MediaDrm(m(uuid));
        this.f25040b = mediaDrm;
        this.f25041c = 1;
        if (com.google.android.exoplayer2.l.f25243d.equals(uuid) && t()) {
            o(mediaDrm);
        }
    }

    private static byte[] i(byte[] bArr) {
        com.google.android.exoplayer2.util.d0 d0Var = new com.google.android.exoplayer2.util.d0(bArr);
        int q11 = d0Var.q();
        short s11 = d0Var.s();
        short s12 = d0Var.s();
        if (s11 != 1 || s12 != 1) {
            com.google.android.exoplayer2.util.s.f("FrameworkMediaDrm", "Unexpected record count or type. Skipping LA_URL workaround.");
            return bArr;
        }
        short s13 = d0Var.s();
        Charset charset = com.google.common.base.c.f30284e;
        String B = d0Var.B(s13, charset);
        if (B.contains("<LA_URL>")) {
            return bArr;
        }
        int indexOf = B.indexOf("</DATA>");
        if (indexOf == -1) {
            com.google.android.exoplayer2.util.s.i("FrameworkMediaDrm", "Could not find the </DATA> tag. Skipping LA_URL workaround.");
        }
        String str = B.substring(0, indexOf) + "<LA_URL>https://x</LA_URL>" + B.substring(indexOf);
        int i11 = q11 + 52;
        ByteBuffer allocate = ByteBuffer.allocate(i11);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        allocate.putInt(i11);
        allocate.putShort(s11);
        allocate.putShort(s12);
        allocate.putShort((short) (str.length() * 2));
        allocate.put(str.getBytes(charset));
        return allocate.array();
    }

    private static byte[] j(UUID uuid, byte[] bArr) {
        return com.google.android.exoplayer2.l.f25242c.equals(uuid) ? com.google.android.exoplayer2.drm.a.a(bArr) : bArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
    
        if ("AFTT".equals(r0) == false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static byte[] k(java.util.UUID r3, byte[] r4) {
        /*
            java.util.UUID r0 = com.google.android.exoplayer2.l.f25244e
            boolean r1 = r0.equals(r3)
            if (r1 == 0) goto L18
            byte[] r1 = o9.l.e(r4, r3)
            if (r1 != 0) goto Lf
            goto L10
        Lf:
            r4 = r1
        L10:
            byte[] r4 = i(r4)
            byte[] r4 = o9.l.a(r0, r4)
        L18:
            int r1 = com.google.android.exoplayer2.util.p0.f27680a
            r2 = 23
            if (r1 >= r2) goto L26
            java.util.UUID r1 = com.google.android.exoplayer2.l.f25243d
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L58
        L26:
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L5f
            java.lang.String r0 = "Amazon"
            java.lang.String r1 = com.google.android.exoplayer2.util.p0.f27682c
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L5f
            java.lang.String r0 = com.google.android.exoplayer2.util.p0.f27683d
            java.lang.String r1 = "AFTB"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTS"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTM"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L58
            java.lang.String r1 = "AFTT"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L5f
        L58:
            byte[] r3 = o9.l.e(r4, r3)
            if (r3 == 0) goto L5f
            return r3
        L5f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.h0.k(java.util.UUID, byte[]):byte[]");
    }

    private static String l(UUID uuid, String str) {
        return (p0.f27680a < 26 && com.google.android.exoplayer2.l.f25242c.equals(uuid) && (MimeTypes.VIDEO_MP4.equals(str) || MimeTypes.AUDIO_MP4.equals(str))) ? C.CENC_TYPE_cenc : str;
    }

    private static UUID m(UUID uuid) {
        return (p0.f27680a >= 27 || !com.google.android.exoplayer2.l.f25242c.equals(uuid)) ? uuid : com.google.android.exoplayer2.l.f25241b;
    }

    private static void o(MediaDrm mediaDrm) {
        mediaDrm.setPropertyString("securityLevel", "L3");
    }

    private static DrmInitData.SchemeData q(UUID uuid, List list) {
        if (!com.google.android.exoplayer2.l.f25243d.equals(uuid)) {
            return (DrmInitData.SchemeData) list.get(0);
        }
        if (p0.f27680a >= 28 && list.size() > 1) {
            DrmInitData.SchemeData schemeData = (DrmInitData.SchemeData) list.get(0);
            int i11 = 0;
            for (int i12 = 0; i12 < list.size(); i12++) {
                DrmInitData.SchemeData schemeData2 = (DrmInitData.SchemeData) list.get(i12);
                byte[] bArr = (byte[]) com.google.android.exoplayer2.util.a.e(schemeData2.data);
                if (p0.c(schemeData2.mimeType, schemeData.mimeType) && p0.c(schemeData2.licenseServerUrl, schemeData.licenseServerUrl) && o9.l.c(bArr)) {
                    i11 += bArr.length;
                }
            }
            byte[] bArr2 = new byte[i11];
            int i13 = 0;
            for (int i14 = 0; i14 < list.size(); i14++) {
                byte[] bArr3 = (byte[]) com.google.android.exoplayer2.util.a.e(((DrmInitData.SchemeData) list.get(i14)).data);
                int length = bArr3.length;
                System.arraycopy(bArr3, 0, bArr2, i13, length);
                i13 += length;
            }
            return schemeData.copyWithData(bArr2);
        }
        for (int i15 = 0; i15 < list.size(); i15++) {
            DrmInitData.SchemeData schemeData3 = (DrmInitData.SchemeData) list.get(i15);
            int g11 = o9.l.g((byte[]) com.google.android.exoplayer2.util.a.e(schemeData3.data));
            int i16 = p0.f27680a;
            if (i16 < 23 && g11 == 0) {
                return schemeData3;
            }
            if (i16 >= 23 && g11 == 1) {
                return schemeData3;
            }
        }
        return (DrmInitData.SchemeData) list.get(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(c0.b bVar, MediaDrm mediaDrm, byte[] bArr, int i11, int i12, byte[] bArr2) {
        bVar.a(this, bArr, i11, i12, bArr2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ c0 s(UUID uuid) {
        try {
            return u(uuid);
        } catch (UnsupportedDrmException unused) {
            com.google.android.exoplayer2.util.s.c("FrameworkMediaDrm", "Failed to instantiate a FrameworkMediaDrm for uuid: " + uuid + ".");
            return new z();
        }
    }

    private static boolean t() {
        return "ASUS_Z00AD".equals(p0.f27683d);
    }

    public static h0 u(UUID uuid) {
        try {
            return new h0(uuid);
        } catch (UnsupportedSchemeException e11) {
            throw new UnsupportedDrmException(1, e11);
        } catch (Exception e12) {
            throw new UnsupportedDrmException(2, e12);
        }
    }

    @Override // com.google.android.exoplayer2.drm.c0
    public int a() {
        return 2;
    }

    @Override // com.google.android.exoplayer2.drm.c0
    public boolean c(byte[] bArr, String str) {
        if (p0.f27680a >= 31) {
            return a.a(this.f25040b, str);
        }
        try {
            MediaCrypto mediaCrypto = new MediaCrypto(this.f25039a, bArr);
            try {
                return mediaCrypto.requiresSecureDecoderComponent(str);
            } finally {
                mediaCrypto.release();
            }
        } catch (MediaCryptoException unused) {
            return true;
        }
    }

    @Override // com.google.android.exoplayer2.drm.c0
    public void closeSession(byte[] bArr) {
        this.f25040b.closeSession(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.c0
    public c0.a d(byte[] bArr, List list, int i11, HashMap hashMap) {
        DrmInitData.SchemeData schemeData;
        byte[] bArr2;
        String str;
        if (list != null) {
            schemeData = q(this.f25039a, list);
            bArr2 = k(this.f25039a, (byte[]) com.google.android.exoplayer2.util.a.e(schemeData.data));
            str = l(this.f25039a, schemeData.mimeType);
        } else {
            schemeData = null;
            bArr2 = null;
            str = null;
        }
        MediaDrm.KeyRequest keyRequest = this.f25040b.getKeyRequest(bArr, bArr2, str, i11, hashMap);
        byte[] j11 = j(this.f25039a, keyRequest.getData());
        String defaultUrl = keyRequest.getDefaultUrl();
        if ("https://x".equals(defaultUrl)) {
            defaultUrl = "";
        }
        if (TextUtils.isEmpty(defaultUrl) && schemeData != null && !TextUtils.isEmpty(schemeData.licenseServerUrl)) {
            defaultUrl = schemeData.licenseServerUrl;
        }
        return new c0.a(j11, defaultUrl, p0.f27680a >= 23 ? keyRequest.getRequestType() : Integer.MIN_VALUE);
    }

    @Override // com.google.android.exoplayer2.drm.c0
    public void e(final c0.b bVar) {
        this.f25040b.setOnEventListener(bVar == null ? null : new MediaDrm.OnEventListener() { // from class: com.google.android.exoplayer2.drm.f0
            @Override // android.media.MediaDrm.OnEventListener
            public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i11, int i12, byte[] bArr2) {
                h0.this.r(bVar, mediaDrm, bArr, i11, i12, bArr2);
            }
        });
    }

    @Override // com.google.android.exoplayer2.drm.c0
    public void f(byte[] bArr, u1 u1Var) {
        if (p0.f27680a >= 31) {
            try {
                a.b(this.f25040b, bArr, u1Var);
            } catch (UnsupportedOperationException unused) {
                com.google.android.exoplayer2.util.s.i("FrameworkMediaDrm", "setLogSessionId failed.");
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.c0
    public c0.d getProvisionRequest() {
        MediaDrm.ProvisionRequest provisionRequest = this.f25040b.getProvisionRequest();
        return new c0.d(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    @Override // com.google.android.exoplayer2.drm.c0
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public d0 b(byte[] bArr) {
        return new d0(m(this.f25039a), bArr, p0.f27680a < 21 && com.google.android.exoplayer2.l.f25243d.equals(this.f25039a) && "L3".equals(p("securityLevel")));
    }

    @Override // com.google.android.exoplayer2.drm.c0
    public byte[] openSession() {
        return this.f25040b.openSession();
    }

    public String p(String str) {
        return this.f25040b.getPropertyString(str);
    }

    @Override // com.google.android.exoplayer2.drm.c0
    public byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) {
        if (com.google.android.exoplayer2.l.f25242c.equals(this.f25039a)) {
            bArr2 = com.google.android.exoplayer2.drm.a.b(bArr2);
        }
        return this.f25040b.provideKeyResponse(bArr, bArr2);
    }

    @Override // com.google.android.exoplayer2.drm.c0
    public void provideProvisionResponse(byte[] bArr) {
        this.f25040b.provideProvisionResponse(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.c0
    public Map queryKeyStatus(byte[] bArr) {
        return this.f25040b.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.c0
    public synchronized void release() {
        int i11 = this.f25041c - 1;
        this.f25041c = i11;
        if (i11 == 0) {
            this.f25040b.release();
        }
    }

    @Override // com.google.android.exoplayer2.drm.c0
    public void restoreKeys(byte[] bArr, byte[] bArr2) {
        this.f25040b.restoreKeys(bArr, bArr2);
    }
}
