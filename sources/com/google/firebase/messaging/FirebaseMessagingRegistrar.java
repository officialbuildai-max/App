package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import java.util.Arrays;
import java.util.List;

@Keep
@KeepForSdk
/* loaded from: classes.dex */
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FirebaseMessaging lambda$getComponents$0(mb.b0 b0Var, mb.e eVar) {
        com.google.firebase.f fVar = (com.google.firebase.f) eVar.a(com.google.firebase.f.class);
        android.support.v4.media.session.c.a(eVar.a(hc.a.class));
        return new FirebaseMessaging(fVar, null, eVar.f(xc.i.class), eVar.f(HeartBeatInfo.class), (jc.e) eVar.a(jc.e.class), eVar.g(b0Var), (fc.d) eVar.a(fc.d.class));
    }

    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    public List<mb.c> getComponents() {
        final mb.b0 a11 = mb.b0.a(zb.b.class, r8.i.class);
        return Arrays.asList(mb.c.c(FirebaseMessaging.class).h(LIBRARY_NAME).b(mb.r.k(com.google.firebase.f.class)).b(mb.r.h(hc.a.class)).b(mb.r.i(xc.i.class)).b(mb.r.i(HeartBeatInfo.class)).b(mb.r.k(jc.e.class)).b(mb.r.j(a11)).b(mb.r.k(fc.d.class)).f(new mb.h() { // from class: com.google.firebase.messaging.c0
            @Override // mb.h
            public final Object a(mb.e eVar) {
                FirebaseMessaging lambda$getComponents$0;
                lambda$getComponents$0 = FirebaseMessagingRegistrar.lambda$getComponents$0(mb.b0.this, eVar);
                return lambda$getComponents$0;
            }
        }).c().d(), xc.h.b(LIBRARY_NAME, "25.0.1"));
    }
}
