package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.o1;
import com.google.common.collect.ImmutableMap;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.ads.internal.protos.Sdk$SDKError;
import java.util.Map;

/* loaded from: classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final int f26483a;

    /* renamed from: b, reason: collision with root package name */
    public final int f26484b;

    /* renamed from: c, reason: collision with root package name */
    public final o1 f26485c;

    /* renamed from: d, reason: collision with root package name */
    public final ImmutableMap f26486d;

    public j(o1 o1Var, int i11, int i12, Map map) {
        this.f26483a = i11;
        this.f26484b = i12;
        this.f26485c = o1Var;
        this.f26486d = ImmutableMap.copyOf(map);
    }

    public static String a(String str) {
        String g11 = com.google.common.base.a.g(str);
        g11.hashCode();
        char c11 = 65535;
        switch (g11.hashCode()) {
            case -1922091719:
                if (g11.equals("MPEG4-GENERIC")) {
                    c11 = 0;
                    break;
                }
                break;
            case 64593:
                if (g11.equals("AC3")) {
                    c11 = 1;
                    break;
                }
                break;
            case 2194728:
                if (g11.equals("H264")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return MimeTypes.AUDIO_AAC;
            case 1:
                return MimeTypes.AUDIO_AC3;
            case 2:
                return MimeTypes.VIDEO_H264;
            default:
                throw new IllegalArgumentException(str);
        }
    }

    public static boolean b(a aVar) {
        String g11 = com.google.common.base.a.g(aVar.f26366j.f26377b);
        g11.hashCode();
        char c11 = 65535;
        switch (g11.hashCode()) {
            case -1922091719:
                if (g11.equals("MPEG4-GENERIC")) {
                    c11 = 0;
                    break;
                }
                break;
            case 64593:
                if (g11.equals("AC3")) {
                    c11 = 1;
                    break;
                }
                break;
            case 2194728:
                if (g11.equals("H264")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
            case 1:
            case 2:
                return true;
            default:
                return false;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        return this.f26483a == jVar.f26483a && this.f26484b == jVar.f26484b && this.f26485c.equals(jVar.f26485c) && this.f26486d.equals(jVar.f26486d);
    }

    public int hashCode() {
        return ((((((Sdk$SDKError.Reason.AD_RESPONSE_TIMED_OUT_VALUE + this.f26483a) * 31) + this.f26484b) * 31) + this.f26485c.hashCode()) * 31) + this.f26486d.hashCode();
    }
}
