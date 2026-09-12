package com.mbridge.msdk.thrid.okhttp.internal.http2;

/* loaded from: classes5.dex */
public enum b {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);


    /* renamed from: a, reason: collision with root package name */
    public final int f38106a;

    b(int i11) {
        this.f38106a = i11;
    }

    public static b a(int i11) {
        for (b bVar : values()) {
            if (bVar.f38106a == i11) {
                return bVar;
            }
        }
        return null;
    }
}
