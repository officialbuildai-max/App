package com.transsion.ad.monopoly.manager;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.y0;

/* loaded from: classes5.dex */
public final class AdSceneAssetsManager extends c {

    /* renamed from: b, reason: collision with root package name */
    public static final AdSceneAssetsManager f42212b = new AdSceneAssetsManager();

    private AdSceneAssetsManager() {
    }

    @Override // com.transsion.ad.monopoly.manager.c
    public Object b(Continuation continuation) {
        Object g11 = i.g(y0.b(), new AdSceneAssetsManager$innerCopy$2(null), continuation);
        return g11 == IntrinsicsKt.f() ? g11 : Unit.f67184a;
    }
}
