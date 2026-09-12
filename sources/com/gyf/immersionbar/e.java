package com.gyf.immersionbar;

import android.app.Application;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class e extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList f33157a;

    /* renamed from: b, reason: collision with root package name */
    private Application f33158b;

    /* renamed from: c, reason: collision with root package name */
    private Boolean f33159c;

    /* loaded from: classes4.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final e f33160a = new e();
    }

    private e() {
        super(new Handler(Looper.getMainLooper()));
        this.f33159c = Boolean.FALSE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static e b() {
        return b.f33160a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ImmersionCallback immersionCallback) {
        if (immersionCallback == null) {
            return;
        }
        if (this.f33157a == null) {
            this.f33157a = new ArrayList();
        }
        if (this.f33157a.contains(immersionCallback)) {
            return;
        }
        this.f33157a.add(immersionCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Application application) {
        Uri uriFor;
        this.f33158b = application;
        if (application == null || application.getContentResolver() == null || this.f33159c.booleanValue() || (uriFor = Settings.System.getUriFor("navigationbar_is_min")) == null) {
            return;
        }
        this.f33158b.getContentResolver().registerContentObserver(uriFor, true, this);
        this.f33159c = Boolean.TRUE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(ImmersionCallback immersionCallback) {
        ArrayList arrayList;
        if (immersionCallback == null || (arrayList = this.f33157a) == null) {
            return;
        }
        arrayList.remove(immersionCallback);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        ArrayList arrayList;
        super.onChange(z10);
        Application application = this.f33158b;
        if (application == null || application.getContentResolver() == null || (arrayList = this.f33157a) == null || arrayList.isEmpty()) {
            return;
        }
        int i11 = Settings.System.getInt(this.f33158b.getContentResolver(), "navigationbar_is_min", 0);
        NavigationBarType navigationBarType = NavigationBarType.CLASSIC;
        if (i11 == 1) {
            navigationBarType = NavigationBarType.GESTURES;
        }
        Iterator it = this.f33157a.iterator();
        while (it.hasNext()) {
            ((ImmersionCallback) it.next()).onNavigationBarChange(i11 == 0, navigationBarType);
        }
    }
}
