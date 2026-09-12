package com.google.firebase.sessions;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* loaded from: classes4.dex */
public final class f implements g {

    /* renamed from: b, reason: collision with root package name */
    public static final a f32738b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final ic.b f32739a;

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public f(ic.b transportFactoryProvider) {
        Intrinsics.h(transportFactoryProvider, "transportFactoryProvider");
        this.f32739a = transportFactoryProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] c(u uVar) {
        String b11 = v.f32790a.c().b(uVar);
        Intrinsics.g(b11, "SessionEvents.SESSION_EVENT_ENCODER.encode(value)");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Session Event Type: ");
        sb2.append(uVar.b().name());
        byte[] bytes = b11.getBytes(Charsets.UTF_8);
        Intrinsics.g(bytes, "this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    @Override // com.google.firebase.sessions.g
    public void a(u sessionEvent) {
        Intrinsics.h(sessionEvent, "sessionEvent");
        ((r8.i) this.f32739a.get()).b("FIREBASE_APPQUALITY_SESSION", u.class, r8.c.b("json"), new r8.g() { // from class: com.google.firebase.sessions.e
            @Override // r8.g
            public final Object apply(Object obj) {
                byte[] c11;
                c11 = f.this.c((u) obj);
                return c11;
            }
        }).b(r8.d.f(sessionEvent));
    }
}
