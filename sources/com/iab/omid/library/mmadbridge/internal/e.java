package com.iab.omid.library.mmadbridge.internal;

import android.view.View;
import com.iab.omid.library.mmadbridge.adsession.FriendlyObstructionPurpose;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final qe.a f33751a;

    /* renamed from: b, reason: collision with root package name */
    private final String f33752b;

    /* renamed from: c, reason: collision with root package name */
    private final FriendlyObstructionPurpose f33753c;

    /* renamed from: d, reason: collision with root package name */
    private final String f33754d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        this.f33751a = new qe.a(view);
        this.f33752b = view.getClass().getCanonicalName();
        this.f33753c = friendlyObstructionPurpose;
        this.f33754d = str;
    }

    public String a() {
        return this.f33754d;
    }

    public FriendlyObstructionPurpose b() {
        return this.f33753c;
    }

    public qe.a c() {
        return this.f33751a;
    }

    public String d() {
        return this.f33752b;
    }
}
