package com.iab.omid.library.hisavana.internal;

import android.view.View;
import com.iab.omid.library.hisavana.adsession.FriendlyObstructionPurpose;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final ke.a f33632a;

    /* renamed from: b, reason: collision with root package name */
    private final String f33633b;

    /* renamed from: c, reason: collision with root package name */
    private final FriendlyObstructionPurpose f33634c;

    /* renamed from: d, reason: collision with root package name */
    private final String f33635d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.f33632a = new ke.a(view);
        this.f33633b = view.getClass().getCanonicalName();
        this.f33634c = friendlyObstructionPurpose;
        this.f33635d = str;
    }

    public String a() {
        return this.f33635d;
    }

    public FriendlyObstructionPurpose b() {
        return this.f33634c;
    }

    public ke.a c() {
        return this.f33632a;
    }

    public String d() {
        return this.f33633b;
    }
}
