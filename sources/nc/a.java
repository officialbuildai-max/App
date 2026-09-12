package nc;

import com.google.firebase.messaging.l0;
import com.google.firebase.messaging.reporting.MessagingClientEvent;

/* loaded from: classes5.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name */
    private static final a f70424b = new C0876a().a();

    /* renamed from: a, reason: collision with root package name */
    private final MessagingClientEvent f70425a;

    /* renamed from: nc.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0876a {

        /* renamed from: a, reason: collision with root package name */
        private MessagingClientEvent f70426a = null;

        C0876a() {
        }

        public a a() {
            return new a(this.f70426a);
        }

        public C0876a b(MessagingClientEvent messagingClientEvent) {
            this.f70426a = messagingClientEvent;
            return this;
        }
    }

    a(MessagingClientEvent messagingClientEvent) {
        this.f70425a = messagingClientEvent;
    }

    public static C0876a b() {
        return new C0876a();
    }

    public MessagingClientEvent a() {
        return this.f70425a;
    }

    public byte[] c() {
        return l0.a(this);
    }
}
