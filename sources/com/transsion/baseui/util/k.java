package com.transsion.baseui.util;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public abstract class k {

    /* loaded from: classes5.dex */
    public static final class a extends k {

        /* renamed from: a, reason: collision with root package name */
        private final int f43574a;

        public a(int i11) {
            super(null);
            this.f43574a = i11;
        }

        public final int a() {
            return this.f43574a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.f43574a == ((a) obj).f43574a;
        }

        public int hashCode() {
            return this.f43574a;
        }

        public String toString() {
            return "Icon(iconRes=" + this.f43574a + ")";
        }
    }

    /* loaded from: classes5.dex */
    public static final class b extends k {

        /* renamed from: a, reason: collision with root package name */
        private final String f43575a;

        /* renamed from: b, reason: collision with root package name */
        private final Integer f43576b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String content, Integer num) {
            super(null);
            Intrinsics.h(content, "content");
            this.f43575a = content;
            this.f43576b = num;
        }

        public final String a() {
            return this.f43575a;
        }

        public final Integer b() {
            return this.f43576b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.c(this.f43575a, bVar.f43575a) && Intrinsics.c(this.f43576b, bVar.f43576b);
        }

        public int hashCode() {
            int hashCode = this.f43575a.hashCode() * 31;
            Integer num = this.f43576b;
            return hashCode + (num == null ? 0 : num.hashCode());
        }

        public String toString() {
            return "Text(content=" + this.f43575a + ", textColorRes=" + this.f43576b + ")";
        }
    }

    private k() {
    }

    public /* synthetic */ k(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
