package com.mbridge.msdk.mbbid.out;

/* loaded from: classes5.dex */
public class AdvancedNativeBidRequestParams extends CommonBidRequestParams {

    /* renamed from: d, reason: collision with root package name */
    private int f36271d;

    /* renamed from: e, reason: collision with root package name */
    private int f36272e;

    public AdvancedNativeBidRequestParams(String str, String str2, int i11, int i12) {
        super(str, str2);
        this.f36271d = i12;
        this.f36272e = i11;
    }

    public AdvancedNativeBidRequestParams(String str, String str2, String str3, int i11, int i12) {
        super(str, str2, str3);
        this.f36271d = i12;
        this.f36272e = i11;
    }

    public int getHeight() {
        return this.f36271d;
    }

    public int getWidth() {
        return this.f36272e;
    }

    public void setHeight(int i11) {
        this.f36271d = i11;
    }

    public void setWidth(int i11) {
        this.f36272e = i11;
    }
}
