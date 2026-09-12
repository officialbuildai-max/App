package com.transsion.ad.monopoly.intercept;

import android.os.SystemClock;
import androidx.collection.s;
import com.transsion.ad.db.plan.MbAdDbPlans;
import java.util.Locale;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nh.m;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public final class ShowOnNetworkStateHandler extends com.transsion.ad.monopoly.intercept.a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f42190b = new a(null);

    /* renamed from: c, reason: collision with root package name */
    private static volatile a.C0596a f42191c;

    /* loaded from: classes5.dex */
    public static final class a {

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: com.transsion.ad.monopoly.intercept.ShowOnNetworkStateHandler$a$a, reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public static final class C0596a {

            /* renamed from: a, reason: collision with root package name */
            private final boolean f42192a;

            /* renamed from: b, reason: collision with root package name */
            private final long f42193b;

            public C0596a(boolean z10, long j11) {
                this.f42192a = z10;
                this.f42193b = j11;
            }

            public final boolean a() {
                return this.f42192a;
            }

            public final long b() {
                return this.f42193b;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0596a)) {
                    return false;
                }
                C0596a c0596a = (C0596a) obj;
                return this.f42192a == c0596a.f42192a && this.f42193b == c0596a.f42193b;
            }

            public int hashCode() {
                return (androidx.compose.foundation.e.a(this.f42192a) * 31) + s.a(this.f42193b);
            }

            public String toString() {
                return "NetworkCache(status=" + this.f42192a + ", timestamp=" + this.f42193b + ")";
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object b(Continuation continuation) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            C0596a c0596a = ShowOnNetworkStateHandler.f42191c;
            if (c0596a != null) {
                if (elapsedRealtime - c0596a.b() >= 1000) {
                    c0596a = null;
                }
                if (c0596a != null) {
                    return Boxing.a(c0596a.a());
                }
            }
            boolean e11 = m.f70597a.e();
            ShowOnNetworkStateHandler.f42191c = new C0596a(e11, elapsedRealtime);
            return Boxing.a(e11);
        }
    }

    private final Boolean i(MbAdDbPlans mbAdDbPlans) {
        String extraConfig;
        if (mbAdDbPlans != null && (extraConfig = mbAdDbPlans.getExtraConfig()) != null) {
            try {
                String string = new JSONObject(extraConfig).getString("network");
                Intrinsics.e(string);
                String lowerCase = string.toLowerCase(Locale.ROOT);
                Intrinsics.g(lowerCase, "toLowerCase(...)");
                return Boolean.valueOf(Intrinsics.c(lowerCase, "on"));
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.transsion.ad.monopoly.intercept.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(java.lang.String r8, com.transsion.ad.db.plan.MbAdDbPlans r9, java.util.Map r10, kotlin.coroutines.Continuation r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.transsion.ad.monopoly.intercept.ShowOnNetworkStateHandler$doHandle$1
            if (r0 == 0) goto L13
            r0 = r11
            com.transsion.ad.monopoly.intercept.ShowOnNetworkStateHandler$doHandle$1 r0 = (com.transsion.ad.monopoly.intercept.ShowOnNetworkStateHandler$doHandle$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.ad.monopoly.intercept.ShowOnNetworkStateHandler$doHandle$1 r0 = new com.transsion.ad.monopoly.intercept.ShowOnNetworkStateHandler$doHandle$1
            r0.<init>(r7, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L35
            if (r2 != r3) goto L2d
            kotlin.ResultKt.b(r11)
            goto Lc2
        L2d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L35:
            java.lang.Object r8 = r0.L$3
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            java.lang.Object r9 = r0.L$2
            r10 = r9
            java.util.Map r10 = (java.util.Map) r10
            java.lang.Object r9 = r0.L$1
            com.transsion.ad.db.plan.MbAdDbPlans r9 = (com.transsion.ad.db.plan.MbAdDbPlans) r9
            java.lang.Object r2 = r0.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.b(r11)
            goto L68
        L4a:
            kotlin.ResultKt.b(r11)
            java.lang.Boolean r11 = r7.i(r9)
            com.transsion.ad.monopoly.intercept.ShowOnNetworkStateHandler$a r2 = com.transsion.ad.monopoly.intercept.ShowOnNetworkStateHandler.f42190b
            r0.L$0 = r8
            r0.L$1 = r9
            r0.L$2 = r10
            r0.L$3 = r11
            r0.label = r4
            java.lang.Object r2 = com.transsion.ad.monopoly.intercept.ShowOnNetworkStateHandler.a.a(r2, r0)
            if (r2 != r1) goto L64
            return r1
        L64:
            r6 = r2
            r2 = r8
            r8 = r11
            r11 = r6
        L68:
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            r5 = 0
            if (r11 == 0) goto L7e
            if (r8 == 0) goto Laa
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.a(r4)
            boolean r4 = kotlin.jvm.internal.Intrinsics.c(r8, r4)
            if (r4 == 0) goto L8b
            goto Laa
        L7e:
            if (r8 == 0) goto Laa
            java.lang.Boolean r4 = kotlin.coroutines.jvm.internal.Boxing.a(r5)
            boolean r4 = kotlin.jvm.internal.Intrinsics.c(r8, r4)
            if (r4 == 0) goto L8b
            goto Laa
        L8b:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r9 = new com.transsion.ad.monopoly.model.AdPlansHitResponse
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "当前网络状态 = "
            r10.append(r0)
            r10.append(r11)
            java.lang.String r11 = " -- isShowOnNetwork = "
            r10.append(r11)
            r10.append(r8)
            java.lang.String r8 = r10.toString()
            r9.<init>(r5, r8)
            goto Lcb
        Laa:
            com.transsion.ad.monopoly.intercept.a r8 = r7.c()
            if (r8 == 0) goto Lc7
            r11 = 0
            r0.L$0 = r11
            r0.L$1 = r11
            r0.L$2 = r11
            r0.L$3 = r11
            r0.label = r3
            java.lang.Object r11 = r8.b(r2, r9, r10, r0)
            if (r11 != r1) goto Lc2
            return r1
        Lc2:
            r9 = r11
            com.transsion.ad.monopoly.model.AdPlansHitResponse r9 = (com.transsion.ad.monopoly.model.AdPlansHitResponse) r9
            if (r9 != 0) goto Lcb
        Lc7:
            com.transsion.ad.monopoly.model.AdPlansHitResponse r9 = r7.e()
        Lcb:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.monopoly.intercept.ShowOnNetworkStateHandler.b(java.lang.String, com.transsion.ad.db.plan.MbAdDbPlans, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
