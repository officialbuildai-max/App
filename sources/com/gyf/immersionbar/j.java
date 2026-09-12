package com.gyf.immersionbar;

import android.app.Application;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Looper;
import com.gyf.immersionbar.g;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes4.dex */
final class j extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    private ArrayList f33175a;

    /* renamed from: b, reason: collision with root package name */
    private Application f33176b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f33177c;

    /* loaded from: classes4.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final j f33178a = new j();
    }

    private j() {
        super(new Handler(Looper.getMainLooper()));
        this.f33177c = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static j b() {
        return b.f33178a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(n nVar) {
        if (nVar == null) {
            return;
        }
        if (this.f33175a == null) {
            this.f33175a = new ArrayList();
        }
        if (this.f33175a.contains(nVar)) {
            return;
        }
        this.f33175a.add(nVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(android.app.Application r6) {
        /*
            r5 = this;
            r5.f33176b = r6
            if (r6 == 0) goto Lcd
            android.content.ContentResolver r6 = r6.getContentResolver()
            if (r6 == 0) goto Lcd
            boolean r6 = r5.f33177c
            if (r6 != 0) goto Lcd
            boolean r6 = com.gyf.immersionbar.OSUtils.isHuaWei()
            r0 = 0
            if (r6 != 0) goto L97
            boolean r6 = com.gyf.immersionbar.OSUtils.isEMUI()
            if (r6 == 0) goto L1d
            goto L97
        L1d:
            boolean r6 = com.gyf.immersionbar.OSUtils.isXiaoMi()
            if (r6 != 0) goto L87
            boolean r6 = com.gyf.immersionbar.OSUtils.isMIUI()
            if (r6 == 0) goto L2a
            goto L87
        L2a:
            boolean r6 = com.gyf.immersionbar.OSUtils.isVivo()
            if (r6 != 0) goto L80
            boolean r6 = com.gyf.immersionbar.OSUtils.isFuntouchOrOriginOs()
            if (r6 == 0) goto L37
            goto L80
        L37:
            boolean r6 = com.gyf.immersionbar.OSUtils.isOppo()
            if (r6 != 0) goto L79
            boolean r6 = com.gyf.immersionbar.OSUtils.isColorOs()
            if (r6 == 0) goto L44
            goto L79
        L44:
            boolean r6 = com.gyf.immersionbar.OSUtils.isSamsung()
            if (r6 == 0) goto L71
            android.app.Application r6 = r5.f33176b
            android.content.ContentResolver r6 = r6.getContentResolver()
            java.lang.String r1 = "navigationbar_hide_bar_enabled"
            r2 = -1
            int r6 = android.provider.Settings.Global.getInt(r6, r1, r2)
            if (r6 != r2) goto L6c
            java.lang.String r6 = "navigation_bar_gesture_while_hidden"
            android.net.Uri r6 = android.provider.Settings.Global.getUriFor(r6)
            java.lang.String r0 = "navigation_bar_gesture_detail_type"
            android.net.Uri r0 = android.provider.Settings.Global.getUriFor(r0)
            java.lang.String r1 = "navigation_bar_gesture_hint"
            android.net.Uri r1 = android.provider.Settings.Global.getUriFor(r1)
            goto La9
        L6c:
            android.net.Uri r6 = android.provider.Settings.Global.getUriFor(r1)
            goto L77
        L71:
            java.lang.String r6 = "navigation_mode"
            android.net.Uri r6 = android.provider.Settings.Secure.getUriFor(r6)
        L77:
            r1 = r0
            goto La9
        L79:
            java.lang.String r6 = "hide_navigationbar_enable"
            android.net.Uri r6 = android.provider.Settings.Secure.getUriFor(r6)
            goto L77
        L80:
            java.lang.String r6 = "navigation_gesture_on"
            android.net.Uri r6 = android.provider.Settings.Secure.getUriFor(r6)
            goto L77
        L87:
            java.lang.String r6 = "force_fsg_nav_bar"
            android.net.Uri r6 = android.provider.Settings.Global.getUriFor(r6)
            java.lang.String r1 = "hide_gesture_line"
            android.net.Uri r1 = android.provider.Settings.Global.getUriFor(r1)
            r4 = r1
            r1 = r0
            r0 = r4
            goto La9
        L97:
            boolean r6 = com.gyf.immersionbar.OSUtils.isEMUI3_x()
            java.lang.String r1 = "navigationbar_is_min"
            if (r6 != 0) goto La4
            android.net.Uri r6 = android.provider.Settings.Global.getUriFor(r1)
            goto L77
        La4:
            android.net.Uri r6 = android.provider.Settings.System.getUriFor(r1)
            goto L77
        La9:
            r2 = 1
            if (r6 == 0) goto Lb7
            android.app.Application r3 = r5.f33176b
            android.content.ContentResolver r3 = r3.getContentResolver()
            r3.registerContentObserver(r6, r2, r5)
            r5.f33177c = r2
        Lb7:
            if (r0 == 0) goto Lc2
            android.app.Application r6 = r5.f33176b
            android.content.ContentResolver r6 = r6.getContentResolver()
            r6.registerContentObserver(r0, r2, r5)
        Lc2:
            if (r1 == 0) goto Lcd
            android.app.Application r6 = r5.f33176b
            android.content.ContentResolver r6 = r6.getContentResolver()
            r6.registerContentObserver(r1, r2, r5)
        Lcd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.gyf.immersionbar.j.c(android.app.Application):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(n nVar) {
        ArrayList arrayList;
        if (nVar == null || (arrayList = this.f33175a) == null) {
            return;
        }
        arrayList.remove(nVar);
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z10) {
        super.onChange(z10);
        ArrayList arrayList = this.f33175a;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        g.a a11 = g.a(this.f33176b);
        boolean z11 = true;
        if (a11.f33172a && (!a11.f33173b || com.gyf.immersionbar.a.f(this.f33176b) <= 0)) {
            z11 = false;
        }
        Iterator it = this.f33175a.iterator();
        while (it.hasNext()) {
            ((n) it.next()).onNavigationBarChange(z11, a11.f33174c);
        }
    }
}
