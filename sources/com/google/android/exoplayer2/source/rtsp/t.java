package com.google.android.exoplayer2.source.rtsp;

import android.net.Uri;
import android.util.Base64;
import com.google.android.exoplayer2.o1;
import com.google.android.exoplayer2.source.rtsp.a;
import com.google.android.exoplayer2.util.p0;
import com.google.android.exoplayer2.util.x;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: classes3.dex */
final class t {

    /* renamed from: a, reason: collision with root package name */
    public final j f26540a;

    /* renamed from: b, reason: collision with root package name */
    public final Uri f26541b;

    public t(a aVar, Uri uri) {
        com.google.android.exoplayer2.util.a.a(aVar.f26365i.containsKey("control"));
        this.f26540a = b(aVar);
        this.f26541b = a(uri, (String) p0.j((String) aVar.f26365i.get("control")));
    }

    private static Uri a(Uri uri, String str) {
        Uri parse = Uri.parse(str);
        return parse.isAbsolute() ? parse : str.equals("*") ? uri : uri.buildUpon().appendEncodedPath(str).build();
    }

    static j b(a aVar) {
        int i11;
        char c11;
        o1.b bVar = new o1.b();
        int i12 = aVar.f26361e;
        if (i12 > 0) {
            bVar.G(i12);
        }
        a.c cVar = aVar.f26366j;
        int i13 = cVar.f26376a;
        String a11 = j.a(cVar.f26377b);
        bVar.e0(a11);
        int i14 = aVar.f26366j.f26378c;
        if (MimeTypes.BASE_TYPE_AUDIO.equals(aVar.f26357a)) {
            i11 = d(aVar.f26366j.f26379d, a11);
            bVar.f0(i14).H(i11);
        } else {
            i11 = -1;
        }
        ImmutableMap a12 = aVar.a();
        int hashCode = a11.hashCode();
        if (hashCode == -53558318) {
            if (a11.equals(MimeTypes.AUDIO_AAC)) {
                c11 = 0;
            }
            c11 = 65535;
        } else if (hashCode != 187078296) {
            if (hashCode == 1331836730 && a11.equals(MimeTypes.VIDEO_H264)) {
                c11 = 1;
            }
            c11 = 65535;
        } else {
            if (a11.equals(MimeTypes.AUDIO_AC3)) {
                c11 = 2;
            }
            c11 = 65535;
        }
        if (c11 == 0) {
            com.google.android.exoplayer2.util.a.a(i11 != -1);
            com.google.android.exoplayer2.util.a.a(!a12.isEmpty());
            e(bVar, a12, i11, i14);
        } else if (c11 == 1) {
            com.google.android.exoplayer2.util.a.a(!a12.isEmpty());
            f(bVar, a12);
        }
        com.google.android.exoplayer2.util.a.a(i14 > 0);
        return new j(bVar.E(), i13, i14, a12);
    }

    private static byte[] c(String str) {
        byte[] decode = Base64.decode(str, 0);
        int length = decode.length;
        byte[] bArr = com.google.android.exoplayer2.util.x.f27718a;
        byte[] bArr2 = new byte[length + bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        System.arraycopy(decode, 0, bArr2, bArr.length, decode.length);
        return bArr2;
    }

    private static int d(int i11, String str) {
        return i11 != -1 ? i11 : str.equals(MimeTypes.AUDIO_AC3) ? 6 : 1;
    }

    private static void e(o1.b bVar, ImmutableMap immutableMap, int i11, int i12) {
        com.google.android.exoplayer2.util.a.a(immutableMap.containsKey("profile-level-id"));
        String valueOf = String.valueOf((String) com.google.android.exoplayer2.util.a.e((String) immutableMap.get("profile-level-id")));
        bVar.I(valueOf.length() != 0 ? "mp4a.40.".concat(valueOf) : new String("mp4a.40."));
        bVar.T(ImmutableList.of(com.google.android.exoplayer2.audio.a.a(i12, i11)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void f(o1.b bVar, ImmutableMap immutableMap) {
        com.google.android.exoplayer2.util.a.a(immutableMap.containsKey("sprop-parameter-sets"));
        String[] S0 = p0.S0((String) com.google.android.exoplayer2.util.a.e((String) immutableMap.get("sprop-parameter-sets")), ",");
        com.google.android.exoplayer2.util.a.a(S0.length == 2);
        ImmutableList of2 = ImmutableList.of(c(S0[0]), c(S0[1]));
        bVar.T(of2);
        byte[] bArr = (byte[]) of2.get(0);
        x.c l11 = com.google.android.exoplayer2.util.x.l(bArr, com.google.android.exoplayer2.util.x.f27718a.length, bArr.length);
        bVar.a0(l11.f27742h);
        bVar.Q(l11.f27741g);
        bVar.j0(l11.f27740f);
        String str = (String) immutableMap.get("profile-level-id");
        if (str != null) {
            bVar.I(str.length() != 0 ? "avc1.".concat(str) : new String("avc1."));
        } else {
            bVar.I(com.google.android.exoplayer2.util.f.a(l11.f27735a, l11.f27736b, l11.f27737c));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t.class != obj.getClass()) {
            return false;
        }
        t tVar = (t) obj;
        return this.f26540a.equals(tVar.f26540a) && this.f26541b.equals(tVar.f26541b);
    }

    public int hashCode() {
        return ((Sdk$SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE + this.f26540a.hashCode()) * 31) + this.f26541b.hashCode();
    }
}
