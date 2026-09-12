package com.google.firebase.messaging.reporting;

/* loaded from: classes4.dex */
public final class MessagingClientEvent {

    /* renamed from: p, reason: collision with root package name */
    private static final MessagingClientEvent f32180p = new a().a();

    /* renamed from: a, reason: collision with root package name */
    private final long f32181a;

    /* renamed from: b, reason: collision with root package name */
    private final String f32182b;

    /* renamed from: c, reason: collision with root package name */
    private final String f32183c;

    /* renamed from: d, reason: collision with root package name */
    private final MessageType f32184d;

    /* renamed from: e, reason: collision with root package name */
    private final SDKPlatform f32185e;

    /* renamed from: f, reason: collision with root package name */
    private final String f32186f;

    /* renamed from: g, reason: collision with root package name */
    private final String f32187g;

    /* renamed from: h, reason: collision with root package name */
    private final int f32188h;

    /* renamed from: i, reason: collision with root package name */
    private final int f32189i;

    /* renamed from: j, reason: collision with root package name */
    private final String f32190j;

    /* renamed from: k, reason: collision with root package name */
    private final long f32191k;

    /* renamed from: l, reason: collision with root package name */
    private final Event f32192l;

    /* renamed from: m, reason: collision with root package name */
    private final String f32193m;

    /* renamed from: n, reason: collision with root package name */
    private final long f32194n;

    /* renamed from: o, reason: collision with root package name */
    private final String f32195o;

    /* loaded from: classes4.dex */
    public enum Event implements ec.a {
        UNKNOWN_EVENT(0),
        MESSAGE_DELIVERED(1),
        MESSAGE_OPEN(2);

        private final int number_;

        Event(int i11) {
            this.number_ = i11;
        }

        @Override // ec.a
        public int getNumber() {
            return this.number_;
        }
    }

    /* loaded from: classes4.dex */
    public enum MessageType implements ec.a {
        UNKNOWN(0),
        DATA_MESSAGE(1),
        TOPIC(2),
        DISPLAY_NOTIFICATION(3);

        private final int number_;

        MessageType(int i11) {
            this.number_ = i11;
        }

        @Override // ec.a
        public int getNumber() {
            return this.number_;
        }
    }

    /* loaded from: classes4.dex */
    public enum SDKPlatform implements ec.a {
        UNKNOWN_OS(0),
        ANDROID(1),
        IOS(2),
        WEB(3);

        private final int number_;

        SDKPlatform(int i11) {
            this.number_ = i11;
        }

        @Override // ec.a
        public int getNumber() {
            return this.number_;
        }
    }

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private long f32196a = 0;

        /* renamed from: b, reason: collision with root package name */
        private String f32197b = "";

        /* renamed from: c, reason: collision with root package name */
        private String f32198c = "";

        /* renamed from: d, reason: collision with root package name */
        private MessageType f32199d = MessageType.UNKNOWN;

        /* renamed from: e, reason: collision with root package name */
        private SDKPlatform f32200e = SDKPlatform.UNKNOWN_OS;

        /* renamed from: f, reason: collision with root package name */
        private String f32201f = "";

        /* renamed from: g, reason: collision with root package name */
        private String f32202g = "";

        /* renamed from: h, reason: collision with root package name */
        private int f32203h = 0;

        /* renamed from: i, reason: collision with root package name */
        private int f32204i = 0;

        /* renamed from: j, reason: collision with root package name */
        private String f32205j = "";

        /* renamed from: k, reason: collision with root package name */
        private long f32206k = 0;

        /* renamed from: l, reason: collision with root package name */
        private Event f32207l = Event.UNKNOWN_EVENT;

        /* renamed from: m, reason: collision with root package name */
        private String f32208m = "";

        /* renamed from: n, reason: collision with root package name */
        private long f32209n = 0;

        /* renamed from: o, reason: collision with root package name */
        private String f32210o = "";

        a() {
        }

        public MessagingClientEvent a() {
            return new MessagingClientEvent(this.f32196a, this.f32197b, this.f32198c, this.f32199d, this.f32200e, this.f32201f, this.f32202g, this.f32203h, this.f32204i, this.f32205j, this.f32206k, this.f32207l, this.f32208m, this.f32209n, this.f32210o);
        }

        public a b(String str) {
            this.f32208m = str;
            return this;
        }

        public a c(String str) {
            this.f32202g = str;
            return this;
        }

        public a d(String str) {
            this.f32210o = str;
            return this;
        }

        public a e(Event event) {
            this.f32207l = event;
            return this;
        }

        public a f(String str) {
            this.f32198c = str;
            return this;
        }

        public a g(String str) {
            this.f32197b = str;
            return this;
        }

        public a h(MessageType messageType) {
            this.f32199d = messageType;
            return this;
        }

        public a i(String str) {
            this.f32201f = str;
            return this;
        }

        public a j(int i11) {
            this.f32203h = i11;
            return this;
        }

        public a k(long j11) {
            this.f32196a = j11;
            return this;
        }

        public a l(SDKPlatform sDKPlatform) {
            this.f32200e = sDKPlatform;
            return this;
        }

        public a m(String str) {
            this.f32205j = str;
            return this;
        }

        public a n(int i11) {
            this.f32204i = i11;
            return this;
        }
    }

    MessagingClientEvent(long j11, String str, String str2, MessageType messageType, SDKPlatform sDKPlatform, String str3, String str4, int i11, int i12, String str5, long j12, Event event, String str6, long j13, String str7) {
        this.f32181a = j11;
        this.f32182b = str;
        this.f32183c = str2;
        this.f32184d = messageType;
        this.f32185e = sDKPlatform;
        this.f32186f = str3;
        this.f32187g = str4;
        this.f32188h = i11;
        this.f32189i = i12;
        this.f32190j = str5;
        this.f32191k = j12;
        this.f32192l = event;
        this.f32193m = str6;
        this.f32194n = j13;
        this.f32195o = str7;
    }

    public static a p() {
        return new a();
    }

    public String a() {
        return this.f32193m;
    }

    public long b() {
        return this.f32191k;
    }

    public long c() {
        return this.f32194n;
    }

    public String d() {
        return this.f32187g;
    }

    public String e() {
        return this.f32195o;
    }

    public Event f() {
        return this.f32192l;
    }

    public String g() {
        return this.f32183c;
    }

    public String h() {
        return this.f32182b;
    }

    public MessageType i() {
        return this.f32184d;
    }

    public String j() {
        return this.f32186f;
    }

    public int k() {
        return this.f32188h;
    }

    public long l() {
        return this.f32181a;
    }

    public SDKPlatform m() {
        return this.f32185e;
    }

    public String n() {
        return this.f32190j;
    }

    public int o() {
        return this.f32189i;
    }
}
