package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.android.billingclient.api.w;
import com.google.android.gms.internal.play_billing.zzaf;
import com.google.android.gms.internal.play_billing.zzb;
import com.google.android.gms.internal.play_billing.zzin;
import com.google.android.gms.internal.play_billing.zzio;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class i extends h {
    private ExecutorService A;

    /* renamed from: a, reason: collision with root package name */
    private volatile int f19143a;

    /* renamed from: b, reason: collision with root package name */
    private final String f19144b;

    /* renamed from: c, reason: collision with root package name */
    private final Handler f19145c;

    /* renamed from: d, reason: collision with root package name */
    private volatile q1 f19146d;

    /* renamed from: e, reason: collision with root package name */
    private Context f19147e;

    /* renamed from: f, reason: collision with root package name */
    private n0 f19148f;

    /* renamed from: g, reason: collision with root package name */
    private volatile com.google.android.gms.internal.play_billing.zzm f19149g;

    /* renamed from: h, reason: collision with root package name */
    private volatile f0 f19150h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f19151i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f19152j;

    /* renamed from: k, reason: collision with root package name */
    private int f19153k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f19154l;

    /* renamed from: m, reason: collision with root package name */
    private boolean f19155m;

    /* renamed from: n, reason: collision with root package name */
    private boolean f19156n;

    /* renamed from: o, reason: collision with root package name */
    private boolean f19157o;

    /* renamed from: p, reason: collision with root package name */
    private boolean f19158p;

    /* renamed from: q, reason: collision with root package name */
    private boolean f19159q;

    /* renamed from: r, reason: collision with root package name */
    private boolean f19160r;

    /* renamed from: s, reason: collision with root package name */
    private boolean f19161s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f19162t;

    /* renamed from: u, reason: collision with root package name */
    private boolean f19163u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f19164v;

    /* renamed from: w, reason: collision with root package name */
    private boolean f19165w;

    /* renamed from: x, reason: collision with root package name */
    private boolean f19166x;

    /* renamed from: y, reason: collision with root package name */
    private x0 f19167y;

    /* renamed from: z, reason: collision with root package name */
    private boolean f19168z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str, Context context, n0 n0Var, ExecutorService executorService) {
        this.f19143a = 0;
        this.f19145c = new Handler(Looper.getMainLooper());
        this.f19153k = 0;
        String J = J();
        this.f19144b = J;
        this.f19147e = context.getApplicationContext();
        zzin zzv = zzio.zzv();
        zzv.zzj(J);
        zzv.zzi(this.f19147e.getPackageName());
        this.f19148f = new q0(this.f19147e, (zzio) zzv.zzc());
        this.f19147e.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str, x0 x0Var, Context context, t0 t0Var, n0 n0Var, ExecutorService executorService) {
        this.f19143a = 0;
        this.f19145c = new Handler(Looper.getMainLooper());
        this.f19153k = 0;
        this.f19144b = J();
        this.f19147e = context.getApplicationContext();
        zzin zzv = zzio.zzv();
        zzv.zzj(J());
        zzv.zzi(this.f19147e.getPackageName());
        this.f19148f = new q0(this.f19147e, (zzio) zzv.zzc());
        zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        this.f19146d = new q1(this.f19147e, null, this.f19148f);
        this.f19167y = x0Var;
        this.f19147e.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(String str, x0 x0Var, Context context, v vVar, c cVar, n0 n0Var, ExecutorService executorService) {
        String J = J();
        this.f19143a = 0;
        this.f19145c = new Handler(Looper.getMainLooper());
        this.f19153k = 0;
        this.f19144b = J;
        g(context, vVar, x0Var, cVar, J, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ e1 E(i iVar, String str, int i11) {
        Bundle zzi;
        zzb.zzj("BillingClient", "Querying owned items, item type: ".concat(String.valueOf(str)));
        ArrayList arrayList = new ArrayList();
        boolean z10 = true;
        int i12 = 0;
        Bundle zzd = zzb.zzd(iVar.f19156n, iVar.f19164v, true, false, iVar.f19144b);
        List list = null;
        String str2 = null;
        while (true) {
            try {
                if (iVar.f19156n) {
                    zzi = iVar.f19149g.zzj(z10 != iVar.f19164v ? 9 : 19, iVar.f19147e.getPackageName(), str, str2, zzd);
                } else {
                    zzi = iVar.f19149g.zzi(3, iVar.f19147e.getPackageName(), str, str2);
                }
                f1 a11 = g1.a(zzi, "BillingClient", "getPurchase()");
                n a12 = a11.a();
                if (a12 != p0.f19210l) {
                    iVar.f19148f.a(m0.a(a11.b(), 9, a12));
                    return new e1(a12, list);
                }
                ArrayList<String> stringArrayList = zzi.getStringArrayList("INAPP_PURCHASE_ITEM_LIST");
                ArrayList<String> stringArrayList2 = zzi.getStringArrayList("INAPP_PURCHASE_DATA_LIST");
                ArrayList<String> stringArrayList3 = zzi.getStringArrayList("INAPP_DATA_SIGNATURE_LIST");
                int i13 = i12;
                int i14 = i13;
                while (i13 < stringArrayList2.size()) {
                    String str3 = stringArrayList2.get(i13);
                    String str4 = stringArrayList3.get(i13);
                    zzb.zzj("BillingClient", "Sku is owned: ".concat(String.valueOf(stringArrayList.get(i13))));
                    try {
                        Purchase purchase = new Purchase(str3, str4);
                        if (TextUtils.isEmpty(purchase.g())) {
                            zzb.zzk("BillingClient", "BUG: empty/null token!");
                            i14 = 1;
                        }
                        arrayList.add(purchase);
                        i13++;
                    } catch (JSONException e11) {
                        zzb.zzl("BillingClient", "Got an exception trying to decode the purchase!", e11);
                        n0 n0Var = iVar.f19148f;
                        n nVar = p0.f19208j;
                        n0Var.a(m0.a(51, 9, nVar));
                        return new e1(nVar, null);
                    }
                }
                if (i14 != 0) {
                    iVar.f19148f.a(m0.a(26, 9, p0.f19208j));
                }
                str2 = zzi.getString("INAPP_CONTINUATION_TOKEN");
                zzb.zzj("BillingClient", "Continuation token: ".concat(String.valueOf(str2)));
                if (TextUtils.isEmpty(str2)) {
                    return new e1(p0.f19210l, arrayList);
                }
                list = null;
                z10 = true;
                i12 = 0;
            } catch (Exception e12) {
                n0 n0Var2 = iVar.f19148f;
                n nVar2 = p0.f19211m;
                n0Var2.a(m0.a(52, 9, nVar2));
                zzb.zzl("BillingClient", "Got exception trying to get purchasesm try to reconnect", e12);
                return new e1(nVar2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler F() {
        return Looper.myLooper() == null ? this.f19145c : new Handler(Looper.myLooper());
    }

    private final n G(final n nVar) {
        if (Thread.interrupted()) {
            return nVar;
        }
        this.f19145c.post(new Runnable() { // from class: com.android.billingclient.api.zzj
            @Override // java.lang.Runnable
            public final void run() {
                i.this.u(nVar);
            }
        });
        return nVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final n I() {
        return (this.f19143a == 0 || this.f19143a == 3) ? p0.f19211m : p0.f19208j;
    }

    private static String J() {
        try {
            return (String) f5.a.class.getField("VERSION_NAME").get(null);
        } catch (Exception unused) {
            return "6.1.0";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Future K(Callable callable, long j11, final Runnable runnable, Handler handler) {
        if (this.A == null) {
            this.A = Executors.newFixedThreadPool(zzb.zza, new b0(this));
        }
        try {
            final Future submit = this.A.submit(callable);
            handler.postDelayed(new Runnable() { // from class: com.android.billingclient.api.zzn
                @Override // java.lang.Runnable
                public final void run() {
                    Future future = submit;
                    if (future.isDone() || future.isCancelled()) {
                        return;
                    }
                    Runnable runnable2 = runnable;
                    future.cancel(true);
                    zzb.zzk("BillingClient", "Async task is taking too long, cancel it!");
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            }, (long) (j11 * 0.95d));
            return submit;
        } catch (Exception e11) {
            zzb.zzl("BillingClient", "Async task throws exception!", e11);
            return null;
        }
    }

    private final void L(String str, final u uVar) {
        if (!a()) {
            n0 n0Var = this.f19148f;
            n nVar = p0.f19211m;
            n0Var.a(m0.a(2, 9, nVar));
            uVar.a(nVar, zzaf.zzk());
            return;
        }
        if (TextUtils.isEmpty(str)) {
            zzb.zzk("BillingClient", "Please provide a valid product type.");
            n0 n0Var2 = this.f19148f;
            n nVar2 = p0.f19205g;
            n0Var2.a(m0.a(50, 9, nVar2));
            uVar.a(nVar2, zzaf.zzk());
            return;
        }
        if (K(new c0(this, str, uVar), 30000L, new Runnable() { // from class: com.android.billingclient.api.zzs
            @Override // java.lang.Runnable
            public final void run() {
                i.this.B(uVar);
            }
        }, F()) == null) {
            n I = I();
            this.f19148f.a(m0.a(25, 9, I));
            uVar.a(I, zzaf.zzk());
        }
    }

    private void g(Context context, v vVar, x0 x0Var, c cVar, String str, n0 n0Var) {
        this.f19147e = context.getApplicationContext();
        zzin zzv = zzio.zzv();
        zzv.zzj(str);
        zzv.zzi(this.f19147e.getPackageName());
        if (n0Var != null) {
            this.f19148f = n0Var;
        } else {
            this.f19148f = new q0(this.f19147e, (zzio) zzv.zzc());
        }
        if (vVar == null) {
            zzb.zzk("BillingClient", "Billing client should have a valid listener but the provided is null.");
        }
        this.f19146d = new q1(this.f19147e, vVar, cVar, this.f19148f);
        this.f19167y = x0Var;
        this.f19168z = cVar != null;
        this.f19147e.getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void A(t tVar) {
        n0 n0Var = this.f19148f;
        n nVar = p0.f19212n;
        n0Var.a(m0.a(24, 11, nVar));
        tVar.a(nVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void B(u uVar) {
        n0 n0Var = this.f19148f;
        n nVar = p0.f19212n;
        n0Var.a(m0.a(24, 9, nVar));
        uVar.a(nVar, zzaf.zzk());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void C(y yVar) {
        n0 n0Var = this.f19148f;
        n nVar = p0.f19212n;
        n0Var.a(m0.a(24, 8, nVar));
        yVar.a(nVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void D(e eVar) {
        n0 n0Var = this.f19148f;
        n nVar = p0.f19212n;
        n0Var.a(m0.a(24, 16, nVar));
        eVar.a(nVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Bundle N(int i11, String str, String str2, m mVar, Bundle bundle) {
        return this.f19149g.zzg(i11, this.f19147e.getPackageName(), str, str2, null, bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Bundle O(String str, String str2) {
        return this.f19149g.zzf(3, this.f19147e.getPackageName(), str, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Object U(w wVar, s sVar) {
        String str;
        int i11;
        int i12;
        int i13;
        ArrayList arrayList = new ArrayList();
        String c11 = wVar.c();
        zzaf b11 = wVar.b();
        int size = b11.size();
        int i14 = 0;
        while (true) {
            if (i14 >= size) {
                str = "";
                i11 = 0;
                break;
            }
            int i15 = i14 + 20;
            ArrayList arrayList2 = new ArrayList(b11.subList(i14, i15 > size ? size : i15));
            ArrayList<String> arrayList3 = new ArrayList<>();
            int size2 = arrayList2.size();
            for (int i16 = 0; i16 < size2; i16++) {
                arrayList3.add(((w.b) arrayList2.get(i16)).b());
            }
            Bundle bundle = new Bundle();
            bundle.putStringArrayList("ITEM_ID_LIST", arrayList3);
            bundle.putString("playBillingLibraryVersion", this.f19144b);
            try {
                com.google.android.gms.internal.play_billing.zzm zzmVar = this.f19149g;
                int i17 = true != this.f19165w ? 17 : 20;
                String packageName = this.f19147e.getPackageName();
                String str2 = this.f19144b;
                if (TextUtils.isEmpty(null)) {
                    this.f19147e.getPackageName();
                }
                Bundle bundle2 = new Bundle();
                bundle2.putString("playBillingLibraryVersion", str2);
                bundle2.putBoolean("enablePendingPurchases", true);
                bundle2.putString("SKU_DETAILS_RESPONSE_FORMAT", "PRODUCT_DETAILS");
                ArrayList<String> arrayList4 = new ArrayList<>();
                ArrayList<String> arrayList5 = new ArrayList<>();
                int size3 = arrayList2.size();
                zzaf zzafVar = b11;
                int i18 = 0;
                boolean z10 = false;
                boolean z11 = false;
                while (i18 < size3) {
                    w.b bVar = (w.b) arrayList2.get(i18);
                    ArrayList arrayList6 = arrayList2;
                    arrayList4.add(null);
                    z10 |= !TextUtils.isEmpty(null);
                    String c12 = bVar.c();
                    int i19 = size3;
                    if (c12.equals("first_party")) {
                        com.google.android.gms.internal.play_billing.zzx.zzc(null, "Serialized DocId is required for constructing ExtraParams to query ProductDetails for all first party products.");
                        arrayList5.add(null);
                        z11 = true;
                    }
                    i18++;
                    size3 = i19;
                    arrayList2 = arrayList6;
                }
                if (z10) {
                    bundle2.putStringArrayList("SKU_OFFER_ID_TOKEN_LIST", arrayList4);
                }
                if (!arrayList5.isEmpty()) {
                    bundle2.putStringArrayList("SKU_SERIALIZED_DOCID_LIST", arrayList5);
                }
                if (z11 && !TextUtils.isEmpty(null)) {
                    bundle2.putString("accountName", null);
                }
                i13 = 7;
                try {
                    Bundle zzl = zzmVar.zzl(i17, packageName, c11, bundle, bundle2);
                    str = "Item is unavailable for purchase.";
                    if (zzl == null) {
                        zzb.zzk("BillingClient", "queryProductDetailsAsync got empty product details response.");
                        this.f19148f.a(m0.a(44, 7, p0.B));
                        break;
                    }
                    if (zzl.containsKey("DETAILS_LIST")) {
                        ArrayList<String> stringArrayList = zzl.getStringArrayList("DETAILS_LIST");
                        if (stringArrayList == null) {
                            zzb.zzk("BillingClient", "queryProductDetailsAsync got null response list");
                            this.f19148f.a(m0.a(46, 7, p0.B));
                            break;
                        }
                        for (int i20 = 0; i20 < stringArrayList.size(); i20++) {
                            try {
                                r rVar = new r(stringArrayList.get(i20));
                                zzb.zzj("BillingClient", "Got product details: ".concat(rVar.toString()));
                                arrayList.add(rVar);
                            } catch (JSONException e11) {
                                zzb.zzl("BillingClient", "Got a JSON exception trying to decode ProductDetails. \n Exception: ", e11);
                                str = "Error trying to decode SkuDetails.";
                                i12 = 6;
                                this.f19148f.a(m0.a(47, 7, p0.a(6, "Error trying to decode SkuDetails.")));
                                i11 = i12;
                                sVar.a(p0.a(i11, str), arrayList);
                                return null;
                            }
                        }
                        i14 = i15;
                        b11 = zzafVar;
                    } else {
                        i11 = zzb.zzb(zzl, "BillingClient");
                        str = zzb.zzg(zzl, "BillingClient");
                        if (i11 != 0) {
                            zzb.zzk("BillingClient", "getSkuDetails() failed for queryProductDetailsAsync. Response code: " + i11);
                            this.f19148f.a(m0.a(23, 7, p0.a(i11, str)));
                        } else {
                            zzb.zzk("BillingClient", "getSkuDetails() returned a bundle with neither an error nor a product detail list for queryProductDetailsAsync.");
                            this.f19148f.a(m0.a(45, 7, p0.a(6, str)));
                            i11 = 6;
                        }
                    }
                } catch (Exception e12) {
                    e = e12;
                    i12 = 6;
                    zzb.zzl("BillingClient", "queryProductDetailsAsync got a remote exception (try to reconnect).", e);
                    this.f19148f.a(m0.a(43, i13, p0.f19208j));
                    str = "An internal error occurred.";
                    i11 = i12;
                    sVar.a(p0.a(i11, str), arrayList);
                    return null;
                }
            } catch (Exception e13) {
                e = e13;
                i12 = 6;
                i13 = 7;
            }
        }
        i11 = 4;
        sVar.a(p0.a(i11, str), arrayList);
        return null;
    }

    @Override // com.android.billingclient.api.h
    public final boolean a() {
        return (this.f19143a != 2 || this.f19149g == null || this.f19150h == null) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:135:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0384  */
    @Override // com.android.billingclient.api.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.android.billingclient.api.n b(android.app.Activity r25, final com.android.billingclient.api.m r26) {
        /*
            Method dump skipped, instructions count: 1134
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.i.b(android.app.Activity, com.android.billingclient.api.m):com.android.billingclient.api.n");
    }

    @Override // com.android.billingclient.api.h
    public final void d(final w wVar, final s sVar) {
        if (!a()) {
            n0 n0Var = this.f19148f;
            n nVar = p0.f19211m;
            n0Var.a(m0.a(2, 7, nVar));
            sVar.a(nVar, new ArrayList());
            return;
        }
        if (this.f19162t) {
            if (K(new Callable() { // from class: com.android.billingclient.api.s1
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    i.this.U(wVar, sVar);
                    return null;
                }
            }, 30000L, new Runnable() { // from class: com.android.billingclient.api.zzz
                @Override // java.lang.Runnable
                public final void run() {
                    i.this.z(sVar);
                }
            }, F()) == null) {
                n I = I();
                this.f19148f.a(m0.a(25, 7, I));
                sVar.a(I, new ArrayList());
                return;
            }
            return;
        }
        zzb.zzk("BillingClient", "Querying product details is not supported.");
        n0 n0Var2 = this.f19148f;
        n nVar2 = p0.f19220v;
        n0Var2.a(m0.a(20, 7, nVar2));
        sVar.a(nVar2, new ArrayList());
    }

    @Override // com.android.billingclient.api.h
    public final void e(x xVar, u uVar) {
        L(xVar.b(), uVar);
    }

    @Override // com.android.billingclient.api.h
    public final void f(j jVar) {
        if (a()) {
            zzb.zzj("BillingClient", "Service connection is valid. No need to re-initialize.");
            this.f19148f.c(m0.b(6));
            jVar.a(p0.f19210l);
            return;
        }
        int i11 = 1;
        if (this.f19143a == 1) {
            zzb.zzk("BillingClient", "Client is already in the process of connecting to billing service.");
            n0 n0Var = this.f19148f;
            n nVar = p0.f19202d;
            n0Var.a(m0.a(37, 6, nVar));
            jVar.a(nVar);
            return;
        }
        if (this.f19143a == 3) {
            zzb.zzk("BillingClient", "Client was already closed and can't be reused. Please create another instance.");
            n0 n0Var2 = this.f19148f;
            n nVar2 = p0.f19211m;
            n0Var2.a(m0.a(38, 6, nVar2));
            jVar.a(nVar2);
            return;
        }
        this.f19143a = 1;
        zzb.zzj("BillingClient", "Starting in-app billing setup.");
        this.f19150h = new f0(this, jVar, null);
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        List<ResolveInfo> queryIntentServices = this.f19147e.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            i11 = 41;
        } else {
            ServiceInfo serviceInfo = queryIntentServices.get(0).serviceInfo;
            if (serviceInfo != null) {
                String str = serviceInfo.packageName;
                String str2 = serviceInfo.name;
                if (!"com.android.vending".equals(str) || str2 == null) {
                    zzb.zzk("BillingClient", "The device doesn't have valid Play Store.");
                    i11 = 40;
                } else {
                    ComponentName componentName = new ComponentName(str, str2);
                    Intent intent2 = new Intent(intent);
                    intent2.setComponent(componentName);
                    intent2.putExtra("playBillingLibraryVersion", this.f19144b);
                    if (this.f19147e.bindService(intent2, this.f19150h, 1)) {
                        zzb.zzj("BillingClient", "Service was bonded successfully.");
                        return;
                    } else {
                        zzb.zzk("BillingClient", "Connection to Billing service is blocked.");
                        i11 = 39;
                    }
                }
            }
        }
        this.f19143a = 0;
        zzb.zzj("BillingClient", "Billing service unavailable on device.");
        n0 n0Var3 = this.f19148f;
        n nVar3 = p0.f19201c;
        n0Var3.a(m0.a(i11, 6, nVar3));
        jVar.a(nVar3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void t(b bVar) {
        n0 n0Var = this.f19148f;
        n nVar = p0.f19212n;
        n0Var.a(m0.a(24, 3, nVar));
        bVar.a(nVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void u(n nVar) {
        if (this.f19146d.d() != null) {
            this.f19146d.d().a(nVar, null);
        } else {
            this.f19146d.c();
            zzb.zzk("BillingClient", "No valid listener is set in BroadcastManager");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void v(p pVar, o oVar) {
        this.f19148f.a(m0.a(24, 4, p0.f19212n));
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void w(g gVar) {
        n0 n0Var = this.f19148f;
        n nVar = p0.f19212n;
        n0Var.a(m0.a(24, 15, nVar));
        gVar.a(nVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void x(l lVar) {
        n0 n0Var = this.f19148f;
        n nVar = p0.f19212n;
        n0Var.a(m0.a(24, 13, nVar));
        lVar.a(nVar, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void y(d dVar) {
        n0 n0Var = this.f19148f;
        n nVar = p0.f19212n;
        n0Var.a(m0.a(24, 14, nVar));
        dVar.a(nVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void z(s sVar) {
        n0 n0Var = this.f19148f;
        n nVar = p0.f19212n;
        n0Var.a(m0.a(24, 7, nVar));
        sVar.a(nVar, new ArrayList());
    }
}
