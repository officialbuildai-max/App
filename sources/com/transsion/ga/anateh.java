package com.transsion.ga;

import android.os.Bundle;

/* loaded from: classes5.dex */
public class anateh extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f44239a = 0;

    /* renamed from: b, reason: collision with root package name */
    private final String f44240b;

    /* renamed from: c, reason: collision with root package name */
    private final Bundle f44241c;

    public anateh(String str, Bundle bundle) {
        super(str, null);
        this.f44240b = str;
        this.f44241c = bundle;
    }

    public anateh(String str, Throwable th2) {
        super(str, th2);
        this.f44240b = str;
        this.f44241c = null;
    }

    public static void a(String str, Throwable th2) {
        i.a().c(new anateh(str, th2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a() {
        return this.f44240b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle b() {
        return this.f44241c;
    }
}
