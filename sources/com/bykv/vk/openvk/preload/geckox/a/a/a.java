package com.bykv.vk.openvk.preload.geckox.a.a;

/* loaded from: classes2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    final int f20665a;

    /* renamed from: b, reason: collision with root package name */
    final c f20666b;

    /* renamed from: c, reason: collision with root package name */
    private final b f20667c;

    /* renamed from: com.bykv.vk.openvk.preload.geckox.a.a.a$a, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static final class C0200a {

        /* renamed from: a, reason: collision with root package name */
        private int f20668a;

        /* renamed from: b, reason: collision with root package name */
        private b f20669b = b.f20671a;

        /* renamed from: c, reason: collision with root package name */
        private c f20670c;

        public final C0200a a() {
            this.f20668a = 20;
            return this;
        }

        public final C0200a a(b bVar) {
            if (bVar == null) {
                bVar = b.f20671a;
            }
            this.f20669b = bVar;
            return this;
        }

        public final a b() {
            return new a(this, (byte) 0);
        }
    }

    private a(C0200a c0200a) {
        this.f20665a = c0200a.f20668a;
        this.f20667c = c0200a.f20669b;
        this.f20666b = c0200a.f20670c;
    }

    /* synthetic */ a(C0200a c0200a, byte b11) {
        this(c0200a);
    }

    public final b a() {
        return this.f20667c;
    }
}
