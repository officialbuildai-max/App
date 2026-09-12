package com.cloud.sdk.commonutil.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes3.dex */
public abstract class f {

    /* loaded from: classes3.dex */
    public static final class a extends f {

        /* renamed from: a, reason: collision with root package name */
        private final Throwable f23273a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Throwable exception) {
            super(null);
            Intrinsics.h(exception, "exception");
            this.f23273a = exception;
        }

        public final Throwable a() {
            return this.f23273a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.c(this.f23273a, ((a) obj).f23273a);
        }

        public int hashCode() {
            return this.f23273a.hashCode();
        }

        public String toString() {
            return "Failure(exception=" + this.f23273a + ')';
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends f {

        /* renamed from: a, reason: collision with root package name */
        private final Object f23274a;

        public b(Object obj) {
            super(null);
            this.f23274a = obj;
        }

        public final Object a() {
            return this.f23274a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.c(this.f23274a, ((b) obj).f23274a);
        }

        public int hashCode() {
            Object obj = this.f23274a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public String toString() {
            return "Success(value=" + this.f23274a + ')';
        }
    }

    private f() {
    }

    public /* synthetic */ f(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
