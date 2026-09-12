package com.transsion.player.longvideo.helper;

import fo.a;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    private ho.j f48038a;

    /* renamed from: b, reason: collision with root package name */
    private String f48039b;

    /* renamed from: c, reason: collision with root package name */
    private a.b f48040c;

    /* JADX INFO: Access modifiers changed from: protected */
    public final a.b a() {
        return this.f48040c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ho.j b() {
        return this.f48038a;
    }

    public void c(String str, ho.j viewBinding) {
        Intrinsics.h(viewBinding, "viewBinding");
        this.f48039b = str;
        this.f48038a = viewBinding;
    }

    public final void d(a.b bVar) {
        this.f48040c = bVar;
    }
}
