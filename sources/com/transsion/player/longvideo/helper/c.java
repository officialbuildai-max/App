package com.transsion.player.longvideo.helper;

import com.transsion.player.longvideo.ui.LongVodUiType;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final ho.j f48028a;

    /* renamed from: b, reason: collision with root package name */
    private final long f48029b;

    /* renamed from: c, reason: collision with root package name */
    private final int f48030c;

    /* renamed from: d, reason: collision with root package name */
    private final int f48031d;

    /* renamed from: e, reason: collision with root package name */
    private final int f48032e;

    /* renamed from: f, reason: collision with root package name */
    private float f48033f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f48034g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f48035h;

    /* renamed from: i, reason: collision with root package name */
    private LongVodUiType f48036i;

    public c(ho.j viewBinding) {
        Intrinsics.h(viewBinding, "viewBinding");
        this.f48028a = viewBinding;
        this.f48029b = 200L;
        this.f48030c = com.blankj.utilcode.util.a0.a(24.0f);
        this.f48031d = com.blankj.utilcode.util.a0.a(16.0f);
        this.f48032e = com.blankj.utilcode.util.a0.a(20.0f);
        this.f48033f = 1.0f;
        this.f48035h = true;
        this.f48036i = LongVodUiType.MIDDLE;
    }

    public final void a() {
    }

    public final boolean b() {
        return this.f48034g;
    }

    public final void c(LongVodUiType uiType) {
        Intrinsics.h(uiType, "uiType");
    }

    public final void d() {
    }

    public final void e(long j11, long j12) {
    }

    public final void f() {
    }
}
