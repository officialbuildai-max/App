package com.tn.tranpay;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final a f41576c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f41577a;

    /* renamed from: b, reason: collision with root package name */
    private final String f41578b;

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final b a(int i11, String debugMessage, String str) {
            Intrinsics.h(debugMessage, "debugMessage");
            if (str != null) {
                debugMessage = debugMessage + " and serverCode: " + str;
            }
            return new b(i11, debugMessage);
        }
    }

    public b(int i11, String debugMessage) {
        Intrinsics.h(debugMessage, "debugMessage");
        this.f41577a = i11;
        this.f41578b = debugMessage;
    }

    public final String a() {
        return this.f41578b;
    }

    public final int b() {
        return this.f41577a;
    }

    public String toString() {
        return "Response Code: " + this.f41577a + ", Debug Message: " + this.f41578b;
    }
}
