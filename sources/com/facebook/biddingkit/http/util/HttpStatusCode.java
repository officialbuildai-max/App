package com.facebook.biddingkit.http.util;

import com.vungle.ads.internal.protos.Sdk$SDKError;

/* loaded from: classes3.dex */
public enum HttpStatusCode {
    SUCCESS(200),
    NO_BID(Sdk$SDKError.Reason.AD_ALREADY_LOADED_VALUE),
    BAD_REQUEST(400),
    TIMEOUT(504),
    UNKNOWN(-1);

    private int mStatusCode;

    /* loaded from: classes3.dex */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f24167a;

        static {
            int[] iArr = new int[HttpStatusCode.values().length];
            f24167a = iArr;
            try {
                iArr[HttpStatusCode.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24167a[HttpStatusCode.NO_BID.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f24167a[HttpStatusCode.BAD_REQUEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f24167a[HttpStatusCode.TIMEOUT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    HttpStatusCode(int i11) {
        this.mStatusCode = i11;
    }

    public static HttpStatusCode getValue(int i11) {
        for (HttpStatusCode httpStatusCode : values()) {
            if (httpStatusCode.mStatusCode == i11) {
                return httpStatusCode;
            }
        }
        return UNKNOWN;
    }

    public String getErrorMessage() {
        int i11 = a.f24167a[ordinal()];
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? "Unknown error" : "Server timeout" : "Invalid request" : "No bid" : "";
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }
}
