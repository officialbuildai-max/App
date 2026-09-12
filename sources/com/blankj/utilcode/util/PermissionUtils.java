package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.util.Pair;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.UtilsTransActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes2.dex */
public final class PermissionUtils {

    /* renamed from: h, reason: collision with root package name */
    private static PermissionUtils f20107h;

    /* renamed from: i, reason: collision with root package name */
    private static b f20108i;

    /* renamed from: j, reason: collision with root package name */
    private static b f20109j;

    /* renamed from: a, reason: collision with root package name */
    private String[] f20110a;

    /* renamed from: b, reason: collision with root package name */
    private b f20111b;

    /* renamed from: c, reason: collision with root package name */
    private Set f20112c;

    /* renamed from: d, reason: collision with root package name */
    private List f20113d;

    /* renamed from: e, reason: collision with root package name */
    private List f20114e;

    /* renamed from: f, reason: collision with root package name */
    private List f20115f;

    /* renamed from: g, reason: collision with root package name */
    private List f20116g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class PermissionActivityImpl extends UtilsTransActivity.TransActivityDelegate {

        /* renamed from: a, reason: collision with root package name */
        private static int f20117a = -1;

        /* renamed from: b, reason: collision with root package name */
        private static PermissionActivityImpl f20118b = new PermissionActivityImpl();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a implements Utils.b {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ int f20119a;

            a(int i11) {
                this.f20119a = i11;
            }

            @Override // com.blankj.utilcode.util.Utils.b
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void accept(Intent intent) {
                intent.putExtra("TYPE", this.f20119a);
            }
        }

        PermissionActivityImpl() {
        }

        private void a(int i11) {
            if (i11 == 2) {
                if (PermissionUtils.f20108i == null) {
                    return;
                }
                if (PermissionUtils.u()) {
                    PermissionUtils.f20108i.onGranted();
                } else {
                    PermissionUtils.f20108i.onDenied();
                }
                b unused = PermissionUtils.f20108i = null;
                return;
            }
            if (i11 != 3 || PermissionUtils.f20109j == null) {
                return;
            }
            if (PermissionUtils.t()) {
                PermissionUtils.f20109j.onGranted();
            } else {
                PermissionUtils.f20109j.onDenied();
            }
            b unused2 = PermissionUtils.f20109j = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b(final UtilsTransActivity utilsTransActivity) {
            if (PermissionUtils.f20107h.A(utilsTransActivity, new Runnable() { // from class: com.blankj.utilcode.util.PermissionUtils.PermissionActivityImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    utilsTransActivity.requestPermissions((String[]) PermissionUtils.f20107h.f20113d.toArray(new String[0]), 1);
                }
            })) {
                return;
            }
            utilsTransActivity.requestPermissions((String[]) PermissionUtils.f20107h.f20113d.toArray(new String[0]), 1);
        }

        public static void start(int i11) {
            UtilsTransActivity.T(new a(i11), f20118b);
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public boolean dispatchTouchEvent(@NonNull UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            utilsTransActivity.finish();
            return true;
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onActivityResult(@NonNull UtilsTransActivity utilsTransActivity, int i11, int i12, Intent intent) {
            utilsTransActivity.finish();
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onCreated(@NonNull UtilsTransActivity utilsTransActivity, @Nullable Bundle bundle) {
            utilsTransActivity.getWindow().addFlags(262160);
            int intExtra = utilsTransActivity.getIntent().getIntExtra("TYPE", -1);
            if (intExtra != 1) {
                if (intExtra == 2) {
                    f20117a = 2;
                    PermissionUtils.D(utilsTransActivity, 2);
                    return;
                } else if (intExtra == 3) {
                    f20117a = 3;
                    PermissionUtils.B(utilsTransActivity, 3);
                    return;
                } else {
                    utilsTransActivity.finish();
                    Log.e("PermissionUtils", "type is wrong.");
                    return;
                }
            }
            if (PermissionUtils.f20107h == null) {
                Log.e("PermissionUtils", "sInstance is null.");
                utilsTransActivity.finish();
                return;
            }
            if (PermissionUtils.f20107h.f20113d == null) {
                Log.e("PermissionUtils", "mPermissionsRequest is null.");
                utilsTransActivity.finish();
            } else if (PermissionUtils.f20107h.f20113d.size() <= 0) {
                Log.e("PermissionUtils", "mPermissionsRequest's size is no more than 0.");
                utilsTransActivity.finish();
            } else {
                PermissionUtils.i(PermissionUtils.f20107h);
                PermissionUtils.j(PermissionUtils.f20107h);
                b(utilsTransActivity);
            }
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onDestroy(@NonNull UtilsTransActivity utilsTransActivity) {
            int i11 = f20117a;
            if (i11 != -1) {
                a(i11);
                f20117a = -1;
            }
            super.onDestroy(utilsTransActivity);
        }

        @Override // com.blankj.utilcode.util.UtilsTransActivity.TransActivityDelegate
        public void onRequestPermissionsResult(@NonNull UtilsTransActivity utilsTransActivity, int i11, @NonNull String[] strArr, @NonNull int[] iArr) {
            utilsTransActivity.finish();
            if (PermissionUtils.f20107h == null || PermissionUtils.f20107h.f20113d == null) {
                return;
            }
            PermissionUtils.f20107h.w(utilsTransActivity);
        }
    }

    /* loaded from: classes2.dex */
    public interface a {
    }

    /* loaded from: classes2.dex */
    public interface b {
        void onDenied();

        void onGranted();
    }

    /* loaded from: classes2.dex */
    public interface c {
    }

    private PermissionUtils(String... strArr) {
        this.f20110a = strArr;
        f20107h = this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A(UtilsTransActivity utilsTransActivity, Runnable runnable) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void B(Activity activity, int i11) {
        Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
        intent.setData(Uri.parse("package:" + Utils.a().getPackageName()));
        if (e0.A(intent)) {
            activity.startActivityForResult(intent, i11);
        } else {
            v();
        }
    }

    private void C() {
        PermissionActivityImpl.start(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void D(Activity activity, int i11) {
        Intent intent = new Intent("android.settings.action.MANAGE_WRITE_SETTINGS");
        intent.setData(Uri.parse("package:" + Utils.a().getPackageName()));
        if (e0.A(intent)) {
            activity.startActivityForResult(intent, i11);
        } else {
            v();
        }
    }

    static /* synthetic */ c i(PermissionUtils permissionUtils) {
        permissionUtils.getClass();
        return null;
    }

    static /* synthetic */ a j(PermissionUtils permissionUtils) {
        permissionUtils.getClass();
        return null;
    }

    public static List n() {
        return o(Utils.a().getPackageName());
    }

    public static List o(String str) {
        try {
            String[] strArr = Utils.a().getPackageManager().getPackageInfo(str, 4096).requestedPermissions;
            return strArr == null ? Collections.emptyList() : Arrays.asList(strArr);
        } catch (PackageManager.NameNotFoundException e11) {
            e11.printStackTrace();
            return Collections.emptyList();
        }
    }

    private void p(Activity activity) {
        for (String str : this.f20113d) {
            if (r(str)) {
                this.f20114e.add(str);
            } else {
                this.f20115f.add(str);
                if (!activity.shouldShowRequestPermissionRationale(str)) {
                    this.f20116g.add(str);
                }
            }
        }
    }

    private static Pair q(String... strArr) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        List n11 = n();
        for (String str : strArr) {
            boolean z10 = false;
            for (String str2 : s5.a.a(str)) {
                if (n11.contains(str2)) {
                    arrayList.add(str2);
                    z10 = true;
                }
            }
            if (!z10) {
                arrayList2.add(str);
                Log.e("PermissionUtils", "U should add the permission of " + str + " in manifest.");
            }
        }
        return Pair.create(arrayList, arrayList2);
    }

    private static boolean r(String str) {
        return androidx.core.content.b.checkSelfPermission(Utils.a(), str) == 0;
    }

    public static boolean s(String... strArr) {
        Pair q11 = q(strArr);
        if (!((List) q11.second).isEmpty()) {
            return false;
        }
        Iterator it = ((List) q11.first).iterator();
        while (it.hasNext()) {
            if (!r((String) it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean t() {
        return Settings.canDrawOverlays(Utils.a());
    }

    public static boolean u() {
        return Settings.System.canWrite(Utils.a());
    }

    public static void v() {
        Intent o11 = e0.o(Utils.a().getPackageName(), true);
        if (e0.A(o11)) {
            Utils.a().startActivity(o11);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w(Activity activity) {
        p(activity);
        z();
    }

    public static PermissionUtils x(String... strArr) {
        return new PermissionUtils(strArr);
    }

    private void z() {
        if (this.f20111b != null) {
            if (this.f20115f.isEmpty()) {
                this.f20111b.onGranted();
            } else {
                this.f20111b.onDenied();
            }
            this.f20111b = null;
        }
    }

    public PermissionUtils m(b bVar) {
        this.f20111b = bVar;
        return this;
    }

    public void y() {
        String[] strArr = this.f20110a;
        if (strArr == null || strArr.length <= 0) {
            Log.w("PermissionUtils", "No permissions to request.");
            return;
        }
        this.f20112c = new LinkedHashSet();
        this.f20113d = new ArrayList();
        this.f20114e = new ArrayList();
        this.f20115f = new ArrayList();
        this.f20116g = new ArrayList();
        Pair q11 = q(this.f20110a);
        this.f20112c.addAll((Collection) q11.first);
        this.f20115f.addAll((Collection) q11.second);
        for (String str : this.f20112c) {
            if (r(str)) {
                this.f20114e.add(str);
            } else {
                this.f20113d.add(str);
            }
        }
        if (this.f20113d.isEmpty()) {
            z();
        } else {
            C();
        }
    }
}
