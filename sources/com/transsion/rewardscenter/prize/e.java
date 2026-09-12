package com.transsion.rewardscenter.prize;

import com.transsion.rewardscenterapi.DrawChance;
import com.transsion.rewardscenterapi.DrawResult;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public abstract class e {

    /* loaded from: classes6.dex */
    public static final class a extends e {

        /* renamed from: a, reason: collision with root package name */
        private final DrawChance f51045a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(DrawChance data) {
            super(null);
            Intrinsics.h(data, "data");
            this.f51045a = data;
        }

        public final DrawChance a() {
            return this.f51045a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && Intrinsics.c(this.f51045a, ((a) obj).f51045a);
        }

        public int hashCode() {
            return this.f51045a.hashCode();
        }

        public String toString() {
            return "DrawChanceItem(data=" + this.f51045a + ")";
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends e {

        /* renamed from: a, reason: collision with root package name */
        private final boolean f51046a;

        public b(boolean z10) {
            super(null);
            this.f51046a = z10;
        }

        public final boolean a() {
            return this.f51046a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && this.f51046a == ((b) obj).f51046a;
        }

        public int hashCode() {
            return androidx.compose.foundation.e.a(this.f51046a);
        }

        public String toString() {
            return "FooterItem(isExpanded=" + this.f51046a + ")";
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends e {

        /* renamed from: a, reason: collision with root package name */
        private final DrawResult f51047a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(DrawResult data) {
            super(null);
            Intrinsics.h(data, "data");
            this.f51047a = data;
        }

        public final DrawResult a() {
            return this.f51047a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof c) && Intrinsics.c(this.f51047a, ((c) obj).f51047a);
        }

        public int hashCode() {
            return this.f51047a.hashCode();
        }

        public String toString() {
            return "Row(data=" + this.f51047a + ")";
        }
    }

    private e() {
    }

    public /* synthetic */ e(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
