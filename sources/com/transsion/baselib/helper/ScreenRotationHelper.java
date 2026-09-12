package com.transsion.baselib.helper;

import android.content.Context;
import android.os.Handler;
import android.provider.Settings;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class ScreenRotationHelper {

    /* renamed from: a, reason: collision with root package name */
    private final Context f43310a;

    /* renamed from: b, reason: collision with root package name */
    private final Function0 f43311b;

    /* renamed from: c, reason: collision with root package name */
    private final Function1 f43312c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f43313d;

    /* renamed from: e, reason: collision with root package name */
    private final Lazy f43314e;

    /* renamed from: f, reason: collision with root package name */
    private final Lazy f43315f;

    public ScreenRotationHelper(Context context, Function0 isCloseAutoRotationCallback, Function1 rotationCallback) {
        Intrinsics.h(context, "context");
        Intrinsics.h(isCloseAutoRotationCallback, "isCloseAutoRotationCallback");
        Intrinsics.h(rotationCallback, "rotationCallback");
        this.f43310a = context;
        this.f43311b = isCloseAutoRotationCallback;
        this.f43312c = rotationCallback;
        this.f43314e = LazyKt.b(new Function0() { // from class: com.transsion.baselib.helper.h
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                g k11;
                k11 = ScreenRotationHelper.k(ScreenRotationHelper.this);
                return k11;
            }
        });
        this.f43315f = LazyKt.b(new Function0() { // from class: com.transsion.baselib.helper.i
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                k i11;
                i11 = ScreenRotationHelper.i(ScreenRotationHelper.this);
                return i11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(boolean z10) {
        if (!((Boolean) this.f43311b.invoke()).booleanValue() && this.f43313d && com.blankj.utilcode.util.c.l()) {
            this.f43312c.invoke(Boolean.valueOf(z10));
        }
    }

    private final k f() {
        return (k) this.f43315f.getValue();
    }

    private final g g() {
        return (g) this.f43314e.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final k i(final ScreenRotationHelper screenRotationHelper) {
        return new k(new Handler(), new WeakReference(screenRotationHelper.f43310a), new Function1() { // from class: com.transsion.baselib.helper.j
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit j11;
                j11 = ScreenRotationHelper.j(ScreenRotationHelper.this, ((Boolean) obj).booleanValue());
                return j11;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit j(ScreenRotationHelper screenRotationHelper, boolean z10) {
        screenRotationHelper.f43313d = z10;
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final g k(ScreenRotationHelper screenRotationHelper) {
        return new g(screenRotationHelper.f43310a, new ScreenRotationHelper$orientationListener$2$1(screenRotationHelper));
    }

    public final void h() {
        this.f43310a.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, f());
        this.f43313d = f().a(this.f43310a);
        g g11 = g();
        if (g11.canDetectOrientation()) {
            g11.enable();
        }
    }

    public final void l() {
        try {
            Result.Companion companion = Result.INSTANCE;
            this.f43310a.getContentResolver().unregisterContentObserver(f());
            g().disable();
            Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }
}
