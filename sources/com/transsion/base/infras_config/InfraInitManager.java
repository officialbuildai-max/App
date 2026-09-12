package com.transsion.base.infras_config;

import com.google.gson.Gson;
import com.tn.lib.net.bean.BaseDto;
import com.transsion.base.infras_config.api.InfraInitApi;
import com.transsion.base.infras_config.model.ConfigInitData;
import com.transsion.base.infras_config.model.ConfigInitDataItem;
import com.transsion.base.infras_config.model.ConfigInitMobileInfraReq;
import com.transsion.base.infras_config.model.ConfigInitRspCode;
import com.transsion.base.infras_config.model.InfrasSourceType;
import io.reactivex.rxjava3.core.j;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lg.a;
import lz.d;
import lz.f;
import lz.h;

/* loaded from: classes5.dex */
public final class InfraInitManager {

    /* renamed from: a, reason: collision with root package name */
    public static final InfraInitManager f43049a = new InfraInitManager();

    /* renamed from: b, reason: collision with root package name */
    private static final Lazy f43050b = LazyKt.b(new Function0() { // from class: com.transsion.base.infras_config.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            InfraInitApi b11;
            b11 = InfraInitManager.b();
            return b11;
        }
    });

    /* loaded from: classes5.dex */
    static final class a implements d {

        /* renamed from: a, reason: collision with root package name */
        public static final a f43051a = new a();

        a() {
        }

        @Override // lz.d
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public final boolean a(Integer count, Throwable th2) {
            Intrinsics.h(count, "count");
            Intrinsics.h(th2, "<unused var>");
            return count.intValue() <= 1;
        }
    }

    /* loaded from: classes5.dex */
    static final class b implements h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f43052a;

        /* loaded from: classes5.dex */
        public /* synthetic */ class a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f43053a;

            static {
                int[] iArr = new int[ConfigInitRspCode.values().length];
                try {
                    iArr[ConfigInitRspCode.IRC_MODIFIED.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ConfigInitRspCode.IRC_NOT_MODIFIED.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ConfigInitRspCode.IRC_UNKNOWN.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                f43053a = iArr;
            }
        }

        b(long j11) {
            this.f43052a = j11;
        }

        @Override // lz.h
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final ConfigInitData apply(BaseDto response) {
            Intrinsics.h(response, "response");
            ConfigInitData configInitData = (ConfigInitData) response.getData();
            if (configInitData == null) {
                throw new IllegalStateException("init response data is null");
            }
            ConfigInitRspCode code = configInitData.getCode();
            int i11 = code == null ? -1 : a.f43053a[code.ordinal()];
            if (i11 != -1 && i11 != 1 && i11 != 2) {
                if (i11 != 3) {
                    throw new NoWhenBranchMatchedException();
                }
                throw new IllegalStateException("init failed, code=" + configInitData.getCode());
            }
            long currentTimeMillis = System.currentTimeMillis();
            gj.b.f63746a.j(configInitData, currentTimeMillis);
            long j11 = currentTimeMillis - this.f43052a;
            a.C0856a c0856a = lg.a.f68962a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("initRx() success, code=");
            sb2.append(configInitData.getCode());
            sb2.append(", items=");
            List<ConfigInitDataItem> items = configInitData.getItems();
            sb2.append(items != null ? items.size() : 0);
            sb2.append(", version=");
            sb2.append(configInitData.getVersion());
            sb2.append(", cost=");
            sb2.append(j11);
            sb2.append("ms");
            a.C0856a.f(c0856a, "InfraInitManager", sb2.toString(), false, 4, null);
            return configInitData;
        }
    }

    /* loaded from: classes5.dex */
    static final class c implements f {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f43054a;

        c(long j11) {
            this.f43054a = j11;
        }

        @Override // lz.f
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void accept(Throwable t11) {
            Intrinsics.h(t11, "t");
            long currentTimeMillis = System.currentTimeMillis() - this.f43054a;
            a.C0856a c0856a = lg.a.f68962a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("initRx() failed, cost=");
            sb2.append(currentTimeMillis);
            sb2.append("ms, msg=");
            String message = t11.getMessage();
            if (message == null) {
                message = t11.getClass().getSimpleName();
            }
            sb2.append(message);
            a.C0856a.k(c0856a, "InfraInitManager", sb2.toString(), t11, false, 8, null);
        }
    }

    private InfraInitManager() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InfraInitApi b() {
        return (InfraInitApi) zg.c.f79537e.a().h(InfraInitApi.class);
    }

    private final InfraInitApi c() {
        return (InfraInitApi) f43050b.getValue();
    }

    public final ConfigInitDataItem d(InfrasSourceType sourceType) {
        Intrinsics.h(sourceType, "sourceType");
        return gj.b.f63746a.c(sourceType);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(java.util.List r6, java.lang.String r7, java.lang.String r8, kotlin.coroutines.Continuation r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.transsion.base.infras_config.InfraInitManager$init$1
            if (r0 == 0) goto L13
            r0 = r9
            com.transsion.base.infras_config.InfraInitManager$init$1 r0 = (com.transsion.base.infras_config.InfraInitManager$init$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.base.infras_config.InfraInitManager$init$1 r0 = new com.transsion.base.infras_config.InfraInitManager$init$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r9)
            goto L47
        L29:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L31:
            kotlin.ResultKt.b(r9)
            kotlinx.coroutines.i0 r9 = kotlinx.coroutines.y0.b()
            com.transsion.base.infras_config.InfraInitManager$init$2 r2 = new com.transsion.base.infras_config.InfraInitManager$init$2
            r4 = 0
            r2.<init>(r6, r7, r8, r4)
            r0.label = r3
            java.lang.Object r9 = kotlinx.coroutines.i.g(r9, r2, r0)
            if (r9 != r1) goto L47
            return r1
        L47:
            kotlin.Result r9 = (kotlin.Result) r9
            java.lang.Object r6 = r9.getValue()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.base.infras_config.InfraInitManager.e(java.util.List, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(java.util.List r14, java.lang.String r15, long r16, java.lang.String r18, kotlin.coroutines.Continuation r19) {
        /*
            r13 = this;
            r0 = r19
            boolean r1 = r0 instanceof com.transsion.base.infras_config.InfraInitManager$initIfNeeded$1
            if (r1 == 0) goto L16
            r1 = r0
            com.transsion.base.infras_config.InfraInitManager$initIfNeeded$1 r1 = (com.transsion.base.infras_config.InfraInitManager$initIfNeeded$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L16
            int r2 = r2 - r3
            r1.label = r2
            r2 = r13
            goto L1c
        L16:
            com.transsion.base.infras_config.InfraInitManager$initIfNeeded$1 r1 = new com.transsion.base.infras_config.InfraInitManager$initIfNeeded$1
            r2 = r13
            r1.<init>(r13, r0)
        L1c:
            java.lang.Object r0 = r1.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r4 = r1.label
            r5 = 1
            if (r4 == 0) goto L35
            if (r4 != r5) goto L2d
            kotlin.ResultKt.b(r0)
            goto L52
        L2d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L35:
            kotlin.ResultKt.b(r0)
            kotlinx.coroutines.i0 r0 = kotlinx.coroutines.y0.b()
            com.transsion.base.infras_config.InfraInitManager$initIfNeeded$2 r4 = new com.transsion.base.infras_config.InfraInitManager$initIfNeeded$2
            r12 = 0
            r6 = r4
            r7 = r16
            r9 = r14
            r10 = r15
            r11 = r18
            r6.<init>(r7, r9, r10, r11, r12)
            r1.label = r5
            java.lang.Object r0 = kotlinx.coroutines.i.g(r0, r4, r1)
            if (r0 != r3) goto L52
            return r3
        L52:
            kotlin.Result r0 = (kotlin.Result) r0
            java.lang.Object r0 = r0.getValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.base.infras_config.InfraInitManager.f(java.util.List, java.lang.String, long, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final j h(List sourceVersions, String str, String str2) {
        Intrinsics.h(sourceVersions, "sourceVersions");
        long currentTimeMillis = System.currentTimeMillis();
        a.C0856a.f(lg.a.f68962a, "InfraInitManager", "initRx() start, sourceCount=" + sourceVersions.size() + ", version=" + str + ", baseUrl=" + str2, false, 4, null);
        List list = sourceVersions;
        gj.b.f63746a.l(list.isEmpty() ? null : list);
        if (list.isEmpty()) {
            list = null;
        }
        ConfigInitMobileInfraReq configInitMobileInfraReq = new ConfigInitMobileInfraReq(list, str);
        new Gson().toJson(configInitMobileInfraReq);
        j j11 = c().initMobileInfra(str2, configInitMobileInfraReq).f(sg.d.f75472a.e()).y(a.f43051a).u(new b(currentTimeMillis)).j(new c(currentTimeMillis));
        Intrinsics.g(j11, "doOnError(...)");
        return j11;
    }
}
