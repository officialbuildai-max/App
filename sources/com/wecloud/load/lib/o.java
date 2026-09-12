package com.wecloud.load.lib;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.wecloud.load.lib.i;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes7.dex */
public final class o {

    /* renamed from: f, reason: collision with root package name */
    public static final a f60988f = new a(null);

    /* renamed from: g, reason: collision with root package name */
    private static volatile o f60989g;

    /* renamed from: a, reason: collision with root package name */
    private volatile i f60990a;

    /* renamed from: b, reason: collision with root package name */
    private volatile boolean f60991b;

    /* renamed from: c, reason: collision with root package name */
    private volatile h f60992c;

    /* renamed from: d, reason: collision with root package name */
    private ServiceConnection f60993d;

    /* renamed from: e, reason: collision with root package name */
    private SoDownloadRequest f60994e;

    /* loaded from: classes7.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final o a() {
            o oVar = o.f60989g;
            if (oVar == null) {
                synchronized (this) {
                    oVar = o.f60989g;
                    if (oVar == null) {
                        oVar = new o(null);
                        o.f60989g = oVar;
                    }
                }
            }
            return oVar;
        }
    }

    /* loaded from: classes7.dex */
    public static final class b implements ServiceConnection {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f60996b;

        b(Context context) {
            this.f60996b = context;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            o.this.f60990a = i.a.Y0(iBinder);
            o.this.f60991b = true;
            a.C0856a.f(lg.a.f68962a, "SoLoadManager", "服务绑定成功", false, 4, null);
            SoDownloadRequest soDownloadRequest = o.this.f60994e;
            if (soDownloadRequest != null) {
                o oVar = o.this;
                oVar.f60994e = null;
                oVar.j(soDownloadRequest);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            o.this.f60990a = null;
            o.this.f60991b = false;
            a.C0856a.f(lg.a.f68962a, "SoLoadManager", "服务断开连接", false, 4, null);
            try {
                if (o.this.f60993d != null) {
                    Context context = this.f60996b;
                    ServiceConnection serviceConnection = o.this.f60993d;
                    Intrinsics.e(serviceConnection);
                    context.unbindService(serviceConnection);
                }
            } catch (Exception e11) {
                a.C0856a.k(lg.a.f68962a, "SoLoadManager", "解绑服务异常: " + e11.getMessage(), e11, false, 8, null);
            }
            o.this.f60993d = null;
        }
    }

    private o() {
    }

    public /* synthetic */ o(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void i(Context context, h callback, SoDownloadRequest request) {
        Intrinsics.h(context, "context");
        Intrinsics.h(callback, "callback");
        Intrinsics.h(request, "request");
        this.f60992c = callback;
        this.f60994e = request;
        if (this.f60991b && this.f60990a != null) {
            this.f60994e = null;
            j(request);
            return;
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(context.getPackageName(), "com.wecloud.load.lib.SoLoadService"));
        this.f60993d = new b(context);
        try {
            context.startService(intent);
            a.C0856a c0856a = lg.a.f68962a;
            a.C0856a.f(c0856a, "SoLoadManager", "已启动 Service", false, 4, null);
            ServiceConnection serviceConnection = this.f60993d;
            if (serviceConnection == null) {
                a.C0856a.l(c0856a, "SoLoadManager", "绑定服务失败：serviceConnection 已被并发清空", false, 4, null);
                this.f60994e = null;
            } else {
                if (context.bindService(intent, serviceConnection, 0)) {
                    return;
                }
                a.C0856a.l(c0856a, "SoLoadManager", "绑定服务失败", false, 4, null);
                this.f60994e = null;
            }
        } catch (Exception e11) {
            a.C0856a.k(lg.a.f68962a, "SoLoadManager", "启动 Service 失败: " + e11.getMessage(), e11, false, 8, null);
        }
    }

    public final boolean j(SoDownloadRequest request) {
        Intrinsics.h(request, "request");
        if (!this.f60991b || this.f60990a == null) {
            a.C0856a.l(lg.a.f68962a, "SoLoadManager", "服务未绑定，无法加载SO", false, 4, null);
            return false;
        }
        if (this.f60992c == null) {
            a.C0856a.l(lg.a.f68962a, "SoLoadManager", "回调接口为空", false, 4, null);
            return false;
        }
        try {
            i iVar = this.f60990a;
            if (iVar != null) {
                iVar.D(request, this.f60992c);
            }
            return true;
        } catch (RemoteException e11) {
            a.C0856a.k(lg.a.f68962a, "SoLoadManager", "调用服务异常: " + e11.getMessage(), e11, false, 8, null);
            return false;
        }
    }

    public final void k(Context context) {
        ServiceConnection serviceConnection;
        Intrinsics.h(context, "context");
        if (!this.f60991b || (serviceConnection = this.f60993d) == null) {
            return;
        }
        try {
            Intrinsics.e(serviceConnection);
            context.unbindService(serviceConnection);
        } catch (Exception e11) {
            a.C0856a.k(lg.a.f68962a, "SoLoadManager", "解绑服务异常: " + e11.getMessage(), e11, false, 8, null);
        }
        this.f60990a = null;
        this.f60991b = false;
        this.f60992c = null;
        this.f60993d = null;
        this.f60994e = null;
        Log.e("SoLoadManager", "解绑服务:");
    }
}
