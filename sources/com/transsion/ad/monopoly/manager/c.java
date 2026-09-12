package com.transsion.ad.monopoly.manager;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import oi.b;

/* loaded from: classes5.dex */
public abstract class c implements oi.b {

    /* renamed from: a, reason: collision with root package name */
    private AtomicBoolean f42213a = new AtomicBoolean(false);

    public final Object a(Continuation continuation) {
        if (this.f42213a.get()) {
            return Unit.f67184a;
        }
        this.f42213a.set(true);
        Object b11 = b(continuation);
        return b11 == IntrinsicsKt.f() ? b11 : Unit.f67184a;
    }

    public abstract Object b(Continuation continuation);

    @Override // oi.b
    public String getClassTag() {
        return b.a.a(this);
    }

    @Override // oi.b
    public String getLogTag() {
        return "ad_init";
    }

    @Override // oi.b
    public String getSceneId() {
        return "";
    }

    @Override // oi.b
    public void onLog(int i11, String str, String str2, boolean z10) {
        b.a.b(this, i11, str, str2, z10);
    }
}
