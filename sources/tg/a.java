package tg;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final C0952a f76334a = new C0952a(null);

    /* renamed from: tg.a$a, reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0952a {
        private C0952a() {
        }

        public /* synthetic */ C0952a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(String token) {
            Intrinsics.h(token, "token");
            return "Bearer " + token;
        }
    }
}
