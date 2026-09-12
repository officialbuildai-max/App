package com.google.firebase.sessions;

import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.util.Locale;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* loaded from: classes4.dex */
public final class SessionGenerator {

    /* renamed from: f, reason: collision with root package name */
    public static final a f32656f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final b0 f32657a;

    /* renamed from: b, reason: collision with root package name */
    private final Function0 f32658b;

    /* renamed from: c, reason: collision with root package name */
    private final String f32659c;

    /* renamed from: d, reason: collision with root package name */
    private int f32660d;

    /* renamed from: e, reason: collision with root package name */
    private t f32661e;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* renamed from: com.google.firebase.sessions.SessionGenerator$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<UUID> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0, UUID.class, "randomUUID", "randomUUID()Ljava/util/UUID;", 0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final UUID invoke() {
            return UUID.randomUUID();
        }
    }

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SessionGenerator a() {
            Object j11 = com.google.firebase.l.a(com.google.firebase.c.f31123a).j(SessionGenerator.class);
            Intrinsics.g(j11, "Firebase.app[SessionGenerator::class.java]");
            return (SessionGenerator) j11;
        }
    }

    public SessionGenerator(b0 timeProvider, Function0 uuidGenerator) {
        Intrinsics.h(timeProvider, "timeProvider");
        Intrinsics.h(uuidGenerator, "uuidGenerator");
        this.f32657a = timeProvider;
        this.f32658b = uuidGenerator;
        this.f32659c = b();
        this.f32660d = -1;
    }

    public /* synthetic */ SessionGenerator(b0 b0Var, Function0 function0, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(b0Var, (i11 & 2) != 0 ? AnonymousClass1.INSTANCE : function0);
    }

    private final String b() {
        String uuid = ((UUID) this.f32658b.invoke()).toString();
        Intrinsics.g(uuid, "uuidGenerator().toString()");
        String lowerCase = StringsKt.Q(uuid, "-", "", false, 4, null).toLowerCase(Locale.ROOT);
        Intrinsics.g(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        return lowerCase;
    }

    public final t a() {
        int i11 = this.f32660d + 1;
        this.f32660d = i11;
        this.f32661e = new t(i11 == 0 ? this.f32659c : b(), this.f32659c, this.f32660d, this.f32657a.a());
        return c();
    }

    public final t c() {
        t tVar = this.f32661e;
        if (tVar != null) {
            return tVar;
        }
        Intrinsics.z("currentSession");
        return null;
    }
}
