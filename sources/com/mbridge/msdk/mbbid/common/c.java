package com.mbridge.msdk.mbbid.common;

/* loaded from: classes5.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name */
    private String f36253a;

    /* renamed from: b, reason: collision with root package name */
    private String f36254b;

    /* renamed from: c, reason: collision with root package name */
    private String f36255c;

    public c(String str, String str2) {
        this.f36253a = str;
        this.f36254b = str2;
    }

    public c(String str, String str2, String str3) {
        this.f36253a = str;
        this.f36254b = str2;
        this.f36255c = str3;
    }

    public String getmFloorPrice() {
        return this.f36255c;
    }

    public String getmPlacementId() {
        return this.f36253a;
    }

    public String getmUnitId() {
        return this.f36254b;
    }

    public void setmFloorPrice(String str) {
        this.f36255c = str;
    }

    public void setmPlacementId(String str) {
        this.f36253a = str;
    }

    public void setmUnitId(String str) {
        this.f36254b = str;
    }
}
