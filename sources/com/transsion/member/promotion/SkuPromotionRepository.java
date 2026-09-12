package com.transsion.member.promotion;

import com.transsion.memberapi.SkuPromotionDto;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes5.dex */
public final class SkuPromotionRepository {

    /* renamed from: b, reason: collision with root package name */
    private static final b f46726b = new b(null);

    /* renamed from: c, reason: collision with root package name */
    public static final int f46727c = 8;

    /* renamed from: d, reason: collision with root package name */
    private static final kotlinx.coroutines.sync.a f46728d = kotlinx.coroutines.sync.g.b(false, 1, null);

    /* renamed from: e, reason: collision with root package name */
    private static volatile a f46729e;

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f46730a = LazyKt.b(new Function0() { // from class: com.transsion.member.promotion.w
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            vm.a f11;
            f11 = SkuPromotionRepository.f();
            return f11;
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f46731a;

        /* renamed from: b, reason: collision with root package name */
        private final SkuPromotionDto f46732b;

        /* renamed from: c, reason: collision with root package name */
        private final long f46733c;

        public a(String host, SkuPromotionDto promotion, long j11) {
            Intrinsics.h(host, "host");
            Intrinsics.h(promotion, "promotion");
            this.f46731a = host;
            this.f46732b = promotion;
            this.f46733c = j11;
        }

        public final long a() {
            return this.f46733c;
        }

        public final String b() {
            return this.f46731a;
        }

        public final SkuPromotionDto c() {
            return this.f46732b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.c(this.f46731a, aVar.f46731a) && Intrinsics.c(this.f46732b, aVar.f46732b) && this.f46733c == aVar.f46733c;
        }

        public int hashCode() {
            return (((this.f46731a.hashCode() * 31) + this.f46732b.hashCode()) * 31) + androidx.collection.s.a(this.f46733c);
        }

        public String toString() {
            return "CacheEntry(host=" + this.f46731a + ", promotion=" + this.f46732b + ", cachedAtElapsedRealtime=" + this.f46733c + ")";
        }
    }

    /* loaded from: classes5.dex */
    private static final class b {
        private b() {
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final vm.a c() {
        return (vm.a) this.f46730a.getValue();
    }

    private final SkuPromotionDto e(String str, long j11) {
        a aVar = f46729e;
        if (aVar == null) {
            return null;
        }
        long a11 = j11 - aVar.a();
        if (!Intrinsics.c(aVar.b(), str) || 0 > a11 || a11 >= 600000) {
            return null;
        }
        return aVar.c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final vm.a f() {
        return (vm.a) zg.c.f79537e.a().h(vm.a.class);
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x00c2, code lost:
    
        r0 = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00b0 A[Catch: all -> 0x0036, TryCatch #0 {all -> 0x0036, blocks: (B:12:0x0031, B:13:0x00aa, B:15:0x00b0, B:17:0x00b8, B:24:0x00c7, B:26:0x00cd, B:27:0x00d3, B:29:0x00d9, B:31:0x00e7), top: B:11:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x007d A[Catch: all -> 0x008c, TryCatch #1 {all -> 0x008c, blocks: (B:45:0x0071, B:48:0x007d, B:50:0x0085, B:51:0x0090), top: B:44:0x0071 }] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(kotlin.coroutines.Continuation r10) {
        /*
            Method dump skipped, instructions count: 251
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.member.promotion.SkuPromotionRepository.d(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
