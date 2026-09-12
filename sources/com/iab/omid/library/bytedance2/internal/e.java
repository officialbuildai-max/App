package com.iab.omid.library.bytedance2.internal;

import android.view.View;
import androidx.annotation.Nullable;
import com.iab.omid.library.bytedance2.adsession.FriendlyObstructionPurpose;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private final com.iab.omid.library.bytedance2.weakreference.a f33502a;

    /* renamed from: b, reason: collision with root package name */
    private final String f33503b;

    /* renamed from: c, reason: collision with root package name */
    private final FriendlyObstructionPurpose f33504c;

    /* renamed from: d, reason: collision with root package name */
    private final String f33505d;

    public e(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, @Nullable String str) {
        this.f33502a = new com.iab.omid.library.bytedance2.weakreference.a(view);
        this.f33503b = view.getClass().getCanonicalName();
        this.f33504c = friendlyObstructionPurpose;
        this.f33505d = str;
    }

    public String a() {
        return this.f33505d;
    }

    public FriendlyObstructionPurpose b() {
        return this.f33504c;
    }

    public com.iab.omid.library.bytedance2.weakreference.a c() {
        return this.f33502a;
    }

    public String d() {
        return this.f33503b;
    }
}
