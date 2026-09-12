package com.transsion.payment.lib.strategy;

import android.app.Activity;
import android.app.Application;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.SystemClock;
import androidx.appcompat.app.AppCompatActivity;
import androidx.view.b0;
import com.android.billingclient.api.j;
import com.android.billingclient.api.m;
import com.android.billingclient.api.r;
import com.android.billingclient.api.s;
import com.android.billingclient.api.u;
import com.android.billingclient.api.v;
import com.android.billingclient.api.w;
import com.android.billingclient.api.x;
import com.blankj.utilcode.util.Utils;
import com.transsion.payment.lib.PaymentService;
import com.transsion.payment.lib.b;
import com.transsion.payment.lib.bean.CreateOrderReq;
import com.transsion.payment.lib.strategy.g;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.n0;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.t1;
import kotlinx.coroutines.y0;
import nh.l;
import nh.n;
import retrofit2.HttpException;
import retrofit2.j0;

/* loaded from: classes6.dex */
public final class GoogleStrategy implements g, n {

    /* renamed from: a, reason: collision with root package name */
    private final b0 f47851a = new b0();

    /* renamed from: b, reason: collision with root package name */
    private final HashSet f47852b;

    /* renamed from: c, reason: collision with root package name */
    private final HashSet f47853c;

    /* renamed from: d, reason: collision with root package name */
    private final int f47854d;

    /* renamed from: e, reason: collision with root package name */
    private int f47855e;

    /* renamed from: f, reason: collision with root package name */
    private int f47856f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f47857g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f47858h;

    /* renamed from: i, reason: collision with root package name */
    private n0 f47859i;

    /* renamed from: j, reason: collision with root package name */
    private com.transsion.payment.lib.b f47860j;

    /* renamed from: k, reason: collision with root package name */
    private final v f47861k;

    /* renamed from: l, reason: collision with root package name */
    private final com.android.billingclient.api.h f47862l;

    /* renamed from: m, reason: collision with root package name */
    private final Lazy f47863m;

    /* renamed from: n, reason: collision with root package name */
    private long f47864n;

    public GoogleStrategy() {
        HashSet hashSet = new HashSet();
        this.f47852b = hashSet;
        HashSet hashSet2 = new HashSet();
        this.f47853c = hashSet2;
        l.f70588g.a().F(this);
        hashSet.add(3);
        hashSet.add(5);
        hashSet.add(-2);
        hashSet.add(7);
        hashSet2.add(4);
        hashSet2.add(-3);
        hashSet2.add(6);
        hashSet2.add(-1);
        hashSet2.add(2);
        hashSet2.add(12);
        this.f47854d = 3;
        this.f47856f = 2000;
        this.f47859i = o0.a(y0.b());
        v vVar = new v() { // from class: com.transsion.payment.lib.strategy.a
            @Override // com.android.billingclient.api.v
            public final void a(com.android.billingclient.api.n nVar, List list) {
                GoogleStrategy.F(GoogleStrategy.this, nVar, list);
            }
        };
        this.f47861k = vVar;
        com.android.billingclient.api.h a11 = com.android.billingclient.api.h.c(Utils.a()).c(vVar).b().a();
        Intrinsics.g(a11, "build(...)");
        this.f47862l = a11;
        this.f47863m = LazyKt.b(new Function0() { // from class: com.transsion.payment.lib.strategy.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                PaymentService E;
                E = GoogleStrategy.E();
                return E;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(13:1|(2:3|(10:5|6|7|8|(1:(4:11|12|13|14)(2:49|50))(8:51|52|(1:54)(1:96)|(1:95)(1:58)|(1:94)(1:62)|(1:64)(1:93)|65|(3:86|(2:(1:89)(1:91)|90)|92)(7:74|75|76|77|78|79|(1:81)))|15|16|(3:18|(2:20|(5:22|(1:24)(1:30)|25|(1:27)(1:29)|28))(2:32|(1:34))|31)|35|36))|101|6|7|8|(0)(0)|15|16|(0)|35|36|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:100:0x003c, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00f4, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0138, code lost:
    
        r1 = kotlin.Result.INSTANCE;
        r0 = kotlin.Result.m1185constructorimpl(kotlin.ResultKt.a(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x003b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00fa A[Catch: all -> 0x00f4, TryCatch #2 {all -> 0x00f4, blocks: (B:15:0x0131, B:42:0x00f6, B:44:0x00fa, B:45:0x00fd, B:47:0x0101, B:48:0x0108, B:79:0x00ed, B:86:0x0112, B:89:0x0122, B:90:0x012c, B:92:0x012f), top: B:8:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0101 A[Catch: all -> 0x00f4, TryCatch #2 {all -> 0x00f4, blocks: (B:15:0x0131, B:42:0x00f6, B:44:0x00fa, B:45:0x00fd, B:47:0x0101, B:48:0x0108, B:79:0x00ed, B:86:0x0112, B:89:0x0122, B:90:0x012c, B:92:0x012f), top: B:8:0x002d }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B(com.android.billingclient.api.Purchase r24, kotlin.coroutines.Continuation r25) {
        /*
            Method dump skipped, instructions count: 430
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.payment.lib.strategy.GoogleStrategy.B(com.android.billingclient.api.Purchase, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(GoogleStrategy googleStrategy, com.android.billingclient.api.n billingResult, List purchaseList) {
        Intrinsics.h(billingResult, "billingResult");
        Intrinsics.h(purchaseList, "purchaseList");
        k.d(googleStrategy.f47859i, null, null, new GoogleStrategy$orderCheck$1$1(purchaseList, googleStrategy, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaymentService E() {
        return new PaymentService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(GoogleStrategy googleStrategy, com.android.billingclient.api.n billingResult, List list) {
        Intrinsics.h(billingResult, "billingResult");
        com.transsion.payment.lib.d dVar = com.transsion.payment.lib.d.f47833a;
        dVar.a("PurchasesUpdatedListener responseCode:" + billingResult.b() + " " + (list != null ? Integer.valueOf(list.size()) : null));
        StringBuilder sb2 = new StringBuilder();
        sb2.append("purchases: ");
        sb2.append(list);
        dVar.a(sb2.toString());
        if (billingResult.b() == 0 && list != null) {
            googleStrategy.f47855e = 0;
            com.transsion.payment.lib.b bVar = googleStrategy.f47860j;
            if (bVar != null) {
                bVar.b(true);
            }
            k.d(o0.a(y0.b()), null, null, new GoogleStrategy$purchasesUpdatedListener$1$1(list, googleStrategy, null), 3, null);
            return;
        }
        if (billingResult.b() != 1) {
            com.transsion.payment.lib.b bVar2 = googleStrategy.f47860j;
            if (bVar2 != null) {
                b.a.a(bVar2, Integer.valueOf(billingResult.b()), billingResult.a(), false, null, 8, null);
            }
            googleStrategy.f47860j = null;
            return;
        }
        dVar.a("PurchasesUpdatedListener USER_CANCELED");
        com.transsion.payment.lib.b bVar3 = googleStrategy.f47860j;
        if (bVar3 != null) {
            b.a.a(bVar3, 1, "User Cancelled", false, null, 8, null);
        }
        googleStrategy.f47860j = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(final Activity activity, String str, final String str2, final boolean z10, final com.transsion.payment.lib.b bVar) {
        w.b a11 = w.b.a().b(str).c(z10 ? "subs" : "inapp").a();
        Intrinsics.g(a11, "build(...)");
        w a12 = w.a().b(CollectionsKt.q(a11)).a();
        Intrinsics.g(a12, "build(...)");
        this.f47862l.d(a12, new s() { // from class: com.transsion.payment.lib.strategy.f
            @Override // com.android.billingclient.api.s
            public final void a(com.android.billingclient.api.n nVar, List list) {
                GoogleStrategy.H(z10, str2, this, bVar, activity, nVar, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(boolean z10, String str, GoogleStrategy googleStrategy, com.transsion.payment.lib.b bVar, Activity activity, com.android.billingclient.api.n billingResult, List productDetailsList) {
        String str2;
        r.d dVar;
        Intrinsics.h(billingResult, "billingResult");
        Intrinsics.h(productDetailsList, "productDetailsList");
        com.transsion.payment.lib.d dVar2 = com.transsion.payment.lib.d.f47833a;
        dVar2.a("queryProductDetailsAsync resultCode: " + billingResult.b() + " result size: " + productDetailsList.size());
        if (productDetailsList.size() <= 0) {
            bVar.a(Integer.valueOf(billingResult.b()), billingResult.a(), false, str);
            dVar2.b("queryProductDetailsAsync failed list: " + productDetailsList + ", code: " + billingResult.b() + ", message: " + billingResult.a());
            return;
        }
        r rVar = (r) productDetailsList.get(0);
        if (rVar == null) {
            dVar2.b("billingFlowParams productDetail null");
            bVar.a(Integer.valueOf(billingResult.b()), billingResult.a(), false, str);
            return;
        }
        ArrayList arrayList = new ArrayList();
        dVar2.a("productDetail is " + rVar);
        m.b.a c11 = m.b.a().c(rVar);
        Intrinsics.g(c11, "setProductDetails(...)");
        if (z10) {
            List d11 = rVar.d();
            if (d11 == null || (dVar = (r.d) CollectionsKt.i0(d11)) == null || (str2 = dVar.a()) == null) {
                str2 = "";
            }
            c11.b(str2);
        }
        m.b a11 = c11.a();
        Intrinsics.g(a11, "build(...)");
        arrayList.add(a11);
        m a12 = m.a().c(arrayList).b(str).a();
        Intrinsics.g(a12, "build(...)");
        googleStrategy.f47860j = bVar;
        dVar2.a("Launch billing flow");
        googleStrategy.f47862l.b(activity, a12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit I(GoogleStrategy googleStrategy, AppCompatActivity appCompatActivity, CreateOrderReq createOrderReq, boolean z10, com.transsion.payment.lib.b bVar, Function1 function1) {
        googleStrategy.b(appCompatActivity, createOrderReq, z10, bVar, function1);
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0071 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x006f -> B:17:0x0044). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object J(long r8, kotlin.jvm.functions.Function1 r10, kotlin.coroutines.Continuation r11) {
        /*
            r7 = this;
            boolean r0 = r11 instanceof com.transsion.payment.lib.strategy.GoogleStrategy$retryCheck$1
            if (r0 == 0) goto L13
            r0 = r11
            com.transsion.payment.lib.strategy.GoogleStrategy$retryCheck$1 r0 = (com.transsion.payment.lib.strategy.GoogleStrategy$retryCheck$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.transsion.payment.lib.strategy.GoogleStrategy$retryCheck$1 r0 = new com.transsion.payment.lib.strategy.GoogleStrategy$retryCheck$1
            r0.<init>(r7, r11)
        L18:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L41
            if (r2 == r4) goto L37
            if (r2 != r3) goto L2f
            long r8 = r0.J$0
            java.lang.Object r10 = r0.L$0
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            goto L41
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            long r8 = r0.J$0
            java.lang.Object r10 = r0.L$0
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
            kotlin.ResultKt.b(r11)
            goto L65
        L41:
            kotlin.ResultKt.b(r11)
        L44:
            int r11 = r7.f47855e
            int r2 = r11 + 1
            r7.f47855e = r2
            int r2 = r7.f47854d
            if (r11 >= r2) goto L72
            boolean r11 = r7.f47858h
            if (r11 != 0) goto L72
            r5 = 0
            int r11 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
            if (r11 <= 0) goto L65
            r0.L$0 = r10
            r0.J$0 = r8
            r0.label = r4
            java.lang.Object r11 = kotlinx.coroutines.u0.a(r8, r0)
            if (r11 != r1) goto L65
            return r1
        L65:
            r0.L$0 = r10
            r0.J$0 = r8
            r0.label = r3
            java.lang.Object r11 = r10.invoke(r0)
            if (r11 != r1) goto L44
            return r1
        L72:
            kotlin.Unit r8 = kotlin.Unit.f67184a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.payment.lib.strategy.GoogleStrategy.J(long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void K() {
        com.android.billingclient.api.h hVar = this.f47862l;
        if (hVar == null || hVar.a()) {
            return;
        }
        g.a.b(this, null, null, new Function0() { // from class: com.transsion.payment.lib.strategy.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit L;
                L = GoogleStrategy.L(GoogleStrategy.this);
                return L;
            }
        }, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit L(GoogleStrategy googleStrategy) {
        List list;
        if (googleStrategy.f47851a.f() == null || ((list = (List) googleStrategy.f47851a.f()) != null && list.isEmpty())) {
            googleStrategy.w();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PaymentService z() {
        return (PaymentService) this.f47863m.getValue();
    }

    public final long A() {
        return this.f47864n;
    }

    public void C() {
        x.a b11 = x.a().b("inapp");
        Intrinsics.g(b11, "setProductType(...)");
        this.f47862l.e(b11.a(), new u() { // from class: com.transsion.payment.lib.strategy.e
            @Override // com.android.billingclient.api.u
            public final void a(com.android.billingclient.api.n nVar, List list) {
                GoogleStrategy.D(GoogleStrategy.this, nVar, list);
            }
        });
    }

    @Override // com.transsion.payment.lib.strategy.g
    public void a(final Boolean bool, final com.transsion.payment.lib.b bVar, final Function0 function0) {
        if (this.f47857g) {
            return;
        }
        this.f47857g = true;
        com.transsion.payment.lib.d.f47833a.a("startBillingConnection start");
        this.f47864n = SystemClock.elapsedRealtime();
        this.f47862l.f(new j() { // from class: com.transsion.payment.lib.strategy.GoogleStrategy$startConnectPlatform$1
            @Override // com.android.billingclient.api.j
            public void a(com.android.billingclient.api.n billingResult) {
                int i11;
                int i12;
                int i13;
                n0 n0Var;
                Intrinsics.h(billingResult, "billingResult");
                GoogleStrategy.this.f47857g = false;
                GoogleStrategy.this.f47858h = true;
                GoogleStrategy.this.f47855e = 0;
                if (billingResult.b() == 0) {
                    com.transsion.payment.lib.d.f47833a.a("content Billing response OK");
                    GoogleStrategy.this.w();
                    Function0 function02 = function0;
                    if (function02 != null) {
                        function02.invoke();
                    }
                    GoogleStrategy.this.C();
                    return;
                }
                if (!GoogleStrategy.this.y().contains(Integer.valueOf(billingResult.b()))) {
                    com.transsion.payment.lib.b bVar2 = bVar;
                    if (bVar2 != null) {
                        b.a.a(bVar2, Integer.valueOf(billingResult.b()), billingResult.a(), false, null, 8, null);
                        return;
                    }
                    return;
                }
                com.transsion.payment.lib.d.f47833a.c("connect error code " + billingResult.b() + " msg " + billingResult.a());
                i11 = GoogleStrategy.this.f47856f;
                long elapsedRealtime = ((long) i11) - (SystemClock.elapsedRealtime() - GoogleStrategy.this.A());
                if (!Intrinsics.c(bool, Boolean.TRUE)) {
                    com.transsion.payment.lib.b bVar3 = bVar;
                    if (bVar3 != null) {
                        b.a.a(bVar3, Integer.valueOf(billingResult.b()), billingResult.a(), false, null, 8, null);
                        return;
                    }
                    return;
                }
                i12 = GoogleStrategy.this.f47855e;
                i13 = GoogleStrategy.this.f47854d;
                if (i12 <= i13) {
                    n0Var = GoogleStrategy.this.f47859i;
                    k.d(n0Var, null, null, new GoogleStrategy$startConnectPlatform$1$onBillingSetupFinished$1(GoogleStrategy.this, elapsedRealtime, function0, null), 3, null);
                } else {
                    com.transsion.payment.lib.b bVar4 = bVar;
                    if (bVar4 != null) {
                        b.a.a(bVar4, Integer.valueOf(billingResult.b()), billingResult.a(), false, null, 8, null);
                    }
                }
            }

            @Override // com.android.billingclient.api.j
            public void b() {
                int i11;
                n0 n0Var;
                GoogleStrategy.this.f47857g = false;
                GoogleStrategy.this.f47858h = false;
                com.transsion.payment.lib.d.f47833a.c("content Service disconnected");
                i11 = GoogleStrategy.this.f47856f;
                long elapsedRealtime = i11 - (SystemClock.elapsedRealtime() - GoogleStrategy.this.A());
                n0Var = GoogleStrategy.this.f47859i;
                k.d(n0Var, null, null, new GoogleStrategy$startConnectPlatform$1$onBillingServiceDisconnected$1(GoogleStrategy.this, elapsedRealtime, function0, null), 3, null);
            }
        });
    }

    @Override // com.transsion.payment.lib.strategy.g
    public void b(final AppCompatActivity activity, final CreateOrderReq createOrderReq, final boolean z10, final com.transsion.payment.lib.b payCallback, final Function1 function1) {
        Object m1185constructorimpl;
        t1 d11;
        Intrinsics.h(activity, "activity");
        Intrinsics.h(createOrderReq, "createOrderReq");
        Intrinsics.h(payCallback, "payCallback");
        com.transsion.payment.lib.d.f47833a.a(x() + " --> requestPay() --> 请求接口创建订单....");
        payCallback.b(true);
        try {
            Result.Companion companion = Result.INSTANCE;
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (!this.f47862l.a()) {
            a(Boolean.FALSE, payCallback, new Function0() { // from class: com.transsion.payment.lib.strategy.d
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit I;
                    I = GoogleStrategy.I(GoogleStrategy.this, activity, createOrderReq, z10, payCallback, function1);
                    return I;
                }
            });
            return;
        }
        d11 = k.d(this.f47859i, null, null, new GoogleStrategy$requestPay$1$2(this, createOrderReq, activity, z10, payCallback, function1, null), 3, null);
        m1185constructorimpl = Result.m1185constructorimpl(d11);
        Throwable m1188exceptionOrNullimpl = Result.m1188exceptionOrNullimpl(m1185constructorimpl);
        if (m1188exceptionOrNullimpl == null) {
            return;
        }
        if (!(m1188exceptionOrNullimpl instanceof HttpException)) {
            b.a.a(payCallback, -10, m1188exceptionOrNullimpl.getMessage(), false, null, 8, null);
            return;
        }
        HttpException httpException = (HttpException) m1188exceptionOrNullimpl;
        j0<?> response = httpException.response();
        Integer valueOf = response != null ? Integer.valueOf(response.b()) : null;
        j0<?> response2 = httpException.response();
        b.a.a(payCallback, valueOf, response2 != null ? response2.f() : null, false, null, 8, null);
    }

    @Override // com.transsion.payment.lib.strategy.g
    public void init(Application application) {
        Intrinsics.h(application, "application");
        l.f70588g.a().F(this);
    }

    @Override // nh.n
    public void onConnected() {
        n.a.a(this);
    }

    @Override // nh.n
    public void onConnected(Network network, NetworkCapabilities networkCapabilities) {
        Intrinsics.h(network, "network");
        Intrinsics.h(networkCapabilities, "networkCapabilities");
        K();
    }

    @Override // nh.n
    public void onDisconnected() {
    }

    public void w() {
        k.d(this.f47859i, null, null, new GoogleStrategy$fetchSkuList$1(this, null), 3, null);
    }

    public String x() {
        return g.a.a(this);
    }

    public final HashSet y() {
        return this.f47853c;
    }
}
