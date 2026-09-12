package com.mbridge.msdk.video.dynview.error;

/* loaded from: classes5.dex */
public enum a {
    NOT_FOUND_VIEWOPTION(-1, "ViewOption is null"),
    NOT_FOUND_CONTEXT(-2, "Context is null"),
    NOT_FOUND_LAYOUTNAME(-3, "layout xml name is null"),
    CAMPAIGNEX_IS_NULL(-4, "Campaign size only one"),
    VIEW_CREATE_ERROR(-5, "view create error"),
    NOT_FOUND_ROOTVIEW(-6, "rootview is null");


    /* renamed from: a, reason: collision with root package name */
    private int f39073a;

    /* renamed from: b, reason: collision with root package name */
    private String f39074b;

    a(int i11, String str) {
        this.f39073a = i11;
        this.f39074b = str;
    }

    public int b() {
        return this.f39073a;
    }

    public String c() {
        return this.f39074b;
    }
}
