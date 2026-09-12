package com.transsion.baselib.helper;

import android.content.Context;
import android.view.OrientationEventListener;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class g extends OrientationEventListener {

    /* renamed from: a, reason: collision with root package name */
    private final Function1 f43324a;

    /* renamed from: b, reason: collision with root package name */
    private final int f43325b;

    /* renamed from: c, reason: collision with root package name */
    private long f43326c;

    /* renamed from: d, reason: collision with root package name */
    private int f43327d;

    /* renamed from: e, reason: collision with root package name */
    private final int f43328e;

    /* renamed from: f, reason: collision with root package name */
    private final int f43329f;

    /* renamed from: g, reason: collision with root package name */
    private final int f43330g;

    /* renamed from: h, reason: collision with root package name */
    private final int f43331h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, Function1 callback) {
        super(context);
        Intrinsics.h(context, "context");
        Intrinsics.h(callback, "callback");
        this.f43324a = callback;
        this.f43325b = 500;
        this.f43327d = -1;
        this.f43328e = 1;
        this.f43329f = 2;
        this.f43330g = 3;
        this.f43331h = 4;
    }

    @Override // android.view.OrientationEventListener
    public void onOrientationChanged(int i11) {
        if (i11 == -1 || System.currentTimeMillis() - this.f43326c < this.f43325b) {
            return;
        }
        this.f43326c = System.currentTimeMillis();
        if (i11 >= 335 || i11 < 25) {
            int i12 = this.f43327d;
            int i13 = this.f43328e;
            if (i12 != i13) {
                this.f43327d = i13;
                this.f43324a.invoke(Boolean.TRUE);
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("竖屏：");
            sb2.append(i11);
            return;
        }
        if (65 <= i11 && i11 < 116) {
            int i14 = this.f43327d;
            int i15 = this.f43329f;
            if (i14 != i15) {
                this.f43327d = i15;
                this.f43324a.invoke(Boolean.FALSE);
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("横屏：");
            sb3.append(i11);
            return;
        }
        if (155 <= i11 && i11 < 206) {
            int i16 = this.f43327d;
            int i17 = this.f43330g;
            if (i16 != i17) {
                this.f43327d = i17;
                this.f43324a.invoke(Boolean.TRUE);
            }
            StringBuilder sb4 = new StringBuilder();
            sb4.append("反向-竖屏：");
            sb4.append(i11);
            return;
        }
        if (245 > i11 || i11 >= 296) {
            return;
        }
        int i18 = this.f43327d;
        int i19 = this.f43331h;
        if (i18 != i19) {
            this.f43327d = i19;
            this.f43324a.invoke(Boolean.FALSE);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("反向-横屏：");
        sb5.append(i11);
    }
}
