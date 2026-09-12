package cf;

import android.os.Build;
import android.os.Environment;
import androidx.core.app.ActivityCompat;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class t0 extends d {

    /* renamed from: f, reason: collision with root package name */
    public static final a f17300f = new a(null);

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(o0 permissionBuilder) {
        super(permissionBuilder);
        Intrinsics.h(permissionBuilder, "permissionBuilder");
    }

    @Override // cf.e
    public void a(List permissions) {
        Intrinsics.h(permissions, "permissions");
        this.f17227a.w(this);
    }

    @Override // cf.e
    public void request() {
        boolean isExternalStorageManager;
        boolean z10;
        if (!this.f17227a.I() || Build.VERSION.SDK_INT < 30) {
            finish();
            return;
        }
        isExternalStorageManager = Environment.isExternalStorageManager();
        if (isExternalStorageManager) {
            finish();
            return;
        }
        this.f17227a.getClass();
        if (this.f17227a.f17287q == null) {
            finish();
            return;
        }
        if (d().getBoolean("android.permission.MANAGE_EXTERNAL_STORAGE", false)) {
            z10 = ActivityCompat.j(this.f17227a.m(), "android.permission.MANAGE_EXTERNAL_STORAGE");
        } else {
            d().putBoolean("android.permission.MANAGE_EXTERNAL_STORAGE", true);
            z10 = true;
        }
        this.f17227a.E(this);
        List q11 = CollectionsKt.q("android.permission.MANAGE_EXTERNAL_STORAGE");
        o0 o0Var = this.f17227a;
        ze.b bVar = o0Var.f17287q;
        if (bVar != null) {
            Intrinsics.e(bVar);
            bVar.a(b(), q11, true, !z10);
        } else {
            o0Var.getClass();
            Intrinsics.e(null);
            b();
            throw null;
        }
    }
}
