package io;

import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.transsion.player.p007enum.PlayMimeType;
import go.c;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f65396a = new a();

    /* renamed from: b, reason: collision with root package name */
    private static boolean f65397b;

    private a() {
    }

    public final String a(go.a bean) {
        Intrinsics.h(bean, "bean");
        if (bean.v() == PlayMimeType.DASH) {
            return "3";
        }
        if (bean.v() == PlayMimeType.HLS) {
            return bean.w() ? "5" : PrepareException.ERROR_NO_URL;
        }
        c cVar = (c) CollectionsKt.k0(bean.j());
        return (cVar == null || !cVar.j()) ? "0" : "4";
    }

    public final boolean b() {
        return f65397b;
    }

    public final void c(boolean z10) {
        f65397b = z10;
    }
}
