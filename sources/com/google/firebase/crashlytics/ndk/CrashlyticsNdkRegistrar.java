package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.crashlytics.ndk.CrashlyticsNdkRegistrar;
import java.util.Arrays;
import java.util.List;
import mb.e;
import mb.r;

/* loaded from: classes.dex */
public class CrashlyticsNdkRegistrar implements ComponentRegistrar {
    /* JADX INFO: Access modifiers changed from: private */
    public ob.a b(mb.e eVar) {
        return c.f((Context) eVar.a(Context.class), !ob.f.g(r2));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    public List getComponents() {
        return Arrays.asList(mb.c.c(ob.a.class).h("fire-cls-ndk").b(r.k(Context.class)).f(new mb.h() { // from class: yb.a
            @Override // mb.h
            public final Object a(e eVar) {
                ob.a b11;
                b11 = CrashlyticsNdkRegistrar.this.b(eVar);
                return b11;
            }
        }).e().d(), xc.h.b("fire-cls-ndk", "19.3.0"));
    }
}
