package cf;

import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import com.tencent.mmkv.MMKV;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public abstract class d implements e {

    /* renamed from: a, reason: collision with root package name */
    public o0 f17227a;

    /* renamed from: b, reason: collision with root package name */
    private final Lazy f17228b;

    /* renamed from: c, reason: collision with root package name */
    public e f17229c;

    /* renamed from: d, reason: collision with root package name */
    private f f17230d;

    /* renamed from: e, reason: collision with root package name */
    private g f17231e;

    public d(o0 pb2) {
        Intrinsics.h(pb2, "pb");
        this.f17227a = pb2;
        this.f17228b = LazyKt.b(new Function0() { // from class: cf.c
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                MMKV e11;
                e11 = d.e();
                return e11;
            }
        });
        this.f17230d = new f(this.f17227a, this);
        this.f17231e = new g(this.f17227a, this);
        this.f17230d = new f(this.f17227a, this);
        this.f17231e = new g(this.f17227a, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MMKV e() {
        MMKV I = MMKV.I("kv_permission_x");
        Intrinsics.g(I, "mmkvWithID(...)");
        return I;
    }

    @Override // cf.e
    public f b() {
        return this.f17230d;
    }

    public final MMKV d() {
        return (MMKV) this.f17228b.getValue();
    }

    @Override // cf.e
    public void finish() {
        boolean canRequestPackageInstalls;
        boolean isExternalStorageManager;
        e eVar = this.f17229c;
        if (eVar != null) {
            eVar.request();
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f17227a.f17281k);
        arrayList.addAll(this.f17227a.f17282l);
        arrayList.addAll(this.f17227a.f17279i);
        if (this.f17227a.F()) {
            if (ye.c.f79116a.f(this.f17227a.m(), "android.permission.ACCESS_BACKGROUND_LOCATION")) {
                this.f17227a.f17280j.add("android.permission.ACCESS_BACKGROUND_LOCATION");
            } else {
                arrayList.add("android.permission.ACCESS_BACKGROUND_LOCATION");
            }
        }
        if (this.f17227a.L() && this.f17227a.p() >= 23) {
            if (Settings.canDrawOverlays(this.f17227a.m())) {
                this.f17227a.f17280j.add("android.permission.SYSTEM_ALERT_WINDOW");
            } else {
                arrayList.add("android.permission.SYSTEM_ALERT_WINDOW");
            }
        }
        if (this.f17227a.M() && this.f17227a.p() >= 23) {
            if (Settings.System.canWrite(this.f17227a.m())) {
                this.f17227a.f17280j.add("android.permission.WRITE_SETTINGS");
            } else {
                arrayList.add("android.permission.WRITE_SETTINGS");
            }
        }
        if (this.f17227a.I()) {
            if (Build.VERSION.SDK_INT >= 30) {
                isExternalStorageManager = Environment.isExternalStorageManager();
                if (isExternalStorageManager) {
                    this.f17227a.f17280j.add("android.permission.MANAGE_EXTERNAL_STORAGE");
                }
            }
            arrayList.add("android.permission.MANAGE_EXTERNAL_STORAGE");
        }
        if (this.f17227a.H()) {
            if (Build.VERSION.SDK_INT < 26 || this.f17227a.p() < 26) {
                arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
            } else {
                canRequestPackageInstalls = this.f17227a.m().getPackageManager().canRequestPackageInstalls();
                if (canRequestPackageInstalls) {
                    this.f17227a.f17280j.add("android.permission.REQUEST_INSTALL_PACKAGES");
                } else {
                    arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
                }
            }
        }
        if (this.f17227a.J()) {
            if (ye.c.f79116a.b(this.f17227a.m())) {
                this.f17227a.f17280j.add("android.permission.POST_NOTIFICATIONS");
            } else {
                arrayList.add("android.permission.POST_NOTIFICATIONS");
            }
        }
        if (this.f17227a.K()) {
            if (ye.c.f79116a.c(this.f17227a.m())) {
                this.f17227a.f17280j.add("android.permission.PICTURE_IN_PICTURE");
            } else {
                arrayList.add("android.permission.PICTURE_IN_PICTURE");
            }
        }
        if (this.f17227a.G()) {
            if (ye.c.f79116a.f(this.f17227a.m(), "android.permission.BODY_SENSORS_BACKGROUND")) {
                this.f17227a.f17280j.add("android.permission.BODY_SENSORS_BACKGROUND");
            } else {
                arrayList.add("android.permission.BODY_SENSORS_BACKGROUND");
            }
        }
        ze.c cVar = this.f17227a.f17286p;
        if (cVar != null) {
            Intrinsics.e(cVar);
            cVar.a(arrayList.isEmpty(), new ArrayList(this.f17227a.f17280j), arrayList);
        }
        this.f17227a.j();
    }
}
