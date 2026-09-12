package com.android.billingclient.api;

import com.android.billingclient.api.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class p0 {
    static final n A;
    static final n B;
    static final n C;
    static final n D;
    static final n E;

    /* renamed from: a, reason: collision with root package name */
    static final n f19199a;

    /* renamed from: b, reason: collision with root package name */
    static final n f19200b;

    /* renamed from: c, reason: collision with root package name */
    static final n f19201c;

    /* renamed from: d, reason: collision with root package name */
    static final n f19202d;

    /* renamed from: e, reason: collision with root package name */
    static final n f19203e;

    /* renamed from: f, reason: collision with root package name */
    static final n f19204f;

    /* renamed from: g, reason: collision with root package name */
    static final n f19205g;

    /* renamed from: h, reason: collision with root package name */
    static final n f19206h;

    /* renamed from: i, reason: collision with root package name */
    static final n f19207i;

    /* renamed from: j, reason: collision with root package name */
    static final n f19208j;

    /* renamed from: k, reason: collision with root package name */
    static final n f19209k;

    /* renamed from: l, reason: collision with root package name */
    static final n f19210l;

    /* renamed from: m, reason: collision with root package name */
    static final n f19211m;

    /* renamed from: n, reason: collision with root package name */
    static final n f19212n;

    /* renamed from: o, reason: collision with root package name */
    static final n f19213o;

    /* renamed from: p, reason: collision with root package name */
    static final n f19214p;

    /* renamed from: q, reason: collision with root package name */
    static final n f19215q;

    /* renamed from: r, reason: collision with root package name */
    static final n f19216r;

    /* renamed from: s, reason: collision with root package name */
    static final n f19217s;

    /* renamed from: t, reason: collision with root package name */
    static final n f19218t;

    /* renamed from: u, reason: collision with root package name */
    static final n f19219u;

    /* renamed from: v, reason: collision with root package name */
    static final n f19220v;

    /* renamed from: w, reason: collision with root package name */
    static final n f19221w;

    /* renamed from: x, reason: collision with root package name */
    static final n f19222x;

    /* renamed from: y, reason: collision with root package name */
    static final n f19223y;

    /* renamed from: z, reason: collision with root package name */
    static final n f19224z;

    static {
        n.a c11 = n.c();
        c11.c(3);
        c11.b("Google Play In-app Billing API version is less than 3");
        f19199a = c11.a();
        n.a c12 = n.c();
        c12.c(3);
        c12.b("Google Play In-app Billing API version is less than 9");
        f19200b = c12.a();
        n.a c13 = n.c();
        c13.c(3);
        c13.b("Billing service unavailable on device.");
        f19201c = c13.a();
        n.a c14 = n.c();
        c14.c(5);
        c14.b("Client is already in the process of connecting to billing service.");
        f19202d = c14.a();
        n.a c15 = n.c();
        c15.c(5);
        c15.b("The list of SKUs can't be empty.");
        f19203e = c15.a();
        n.a c16 = n.c();
        c16.c(5);
        c16.b("SKU type can't be empty.");
        f19204f = c16.a();
        n.a c17 = n.c();
        c17.c(5);
        c17.b("Product type can't be empty.");
        f19205g = c17.a();
        n.a c18 = n.c();
        c18.c(-2);
        c18.b("Client does not support extra params.");
        f19206h = c18.a();
        n.a c19 = n.c();
        c19.c(5);
        c19.b("Invalid purchase token.");
        f19207i = c19.a();
        n.a c20 = n.c();
        c20.c(6);
        c20.b("An internal error occurred.");
        f19208j = c20.a();
        n.a c21 = n.c();
        c21.c(5);
        c21.b("SKU can't be null.");
        f19209k = c21.a();
        n.a c22 = n.c();
        c22.c(0);
        f19210l = c22.a();
        n.a c23 = n.c();
        c23.c(-1);
        c23.b("Service connection is disconnected.");
        f19211m = c23.a();
        n.a c24 = n.c();
        c24.c(2);
        c24.b("Timeout communicating with service.");
        f19212n = c24.a();
        n.a c25 = n.c();
        c25.c(-2);
        c25.b("Client does not support subscriptions.");
        f19213o = c25.a();
        n.a c26 = n.c();
        c26.c(-2);
        c26.b("Client does not support subscriptions update.");
        f19214p = c26.a();
        n.a c27 = n.c();
        c27.c(-2);
        c27.b("Client does not support get purchase history.");
        f19215q = c27.a();
        n.a c28 = n.c();
        c28.c(-2);
        c28.b("Client does not support price change confirmation.");
        f19216r = c28.a();
        n.a c29 = n.c();
        c29.c(-2);
        c29.b("Play Store version installed does not support cross selling products.");
        f19217s = c29.a();
        n.a c30 = n.c();
        c30.c(-2);
        c30.b("Client does not support multi-item purchases.");
        f19218t = c30.a();
        n.a c31 = n.c();
        c31.c(-2);
        c31.b("Client does not support offer_id_token.");
        f19219u = c31.a();
        n.a c32 = n.c();
        c32.c(-2);
        c32.b("Client does not support ProductDetails.");
        f19220v = c32.a();
        n.a c33 = n.c();
        c33.c(-2);
        c33.b("Client does not support in-app messages.");
        f19221w = c33.a();
        n.a c34 = n.c();
        c34.c(-2);
        c34.b("Client does not support user choice billing.");
        f19222x = c34.a();
        n.a c35 = n.c();
        c35.c(5);
        c35.b("Unknown feature");
        f19223y = c35.a();
        n.a c36 = n.c();
        c36.c(-2);
        c36.b("Play Store version installed does not support get billing config.");
        f19224z = c36.a();
        n.a c37 = n.c();
        c37.c(-2);
        c37.b("Query product details with serialized docid is not supported.");
        A = c37.a();
        n.a c38 = n.c();
        c38.c(4);
        c38.b("Item is unavailable for purchase.");
        B = c38.a();
        n.a c39 = n.c();
        c39.c(-2);
        c39.b("Query product details with developer specified account is not supported.");
        C = c39.a();
        n.a c40 = n.c();
        c40.c(-2);
        c40.b("Play Store version installed does not support alternative billing only.");
        D = c40.a();
        n.a c41 = n.c();
        c41.c(5);
        c41.b("To use this API you must specify a PurchasesUpdateListener when initializing a BillingClient.");
        E = c41.a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static n a(int i11, String str) {
        n.a c11 = n.c();
        c11.c(i11);
        c11.b(str);
        return c11.a();
    }
}
