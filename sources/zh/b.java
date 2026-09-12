package zh;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.tn.tranpay.device.TNDeviceHelper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zh.a;

/* loaded from: classes4.dex */
public final class b implements ServiceConnection {

    /* renamed from: c, reason: collision with root package name */
    public static final a f79546c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f79547a;

    /* renamed from: b, reason: collision with root package name */
    private Context f79548b;

    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Context context, Intent intent) {
            Intrinsics.h(context, "context");
            Intrinsics.h(intent, "intent");
            new b(context, intent, null);
        }
    }

    private b(Context context, Intent intent) {
        String TAG = b.class.getSimpleName();
        this.f79547a = TAG;
        if (context instanceof Application) {
            this.f79548b = context;
        } else {
            this.f79548b = context.getApplicationContext();
        }
        try {
            if (context.bindService(intent, this, 1)) {
                return;
            }
            ai.a aVar = ai.a.f694a;
            Intrinsics.g(TAG, "TAG");
            aVar.b("Service binding failed", TAG);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public /* synthetic */ b(Context context, Intent intent, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, intent);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0042 -> B:8:0x0053). Please report as a decompilation issue!!! */
    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        Intrinsics.h(name, "name");
        Intrinsics.h(service, "service");
        try {
            try {
                try {
                    String oaid = a.AbstractBinderC1005a.Y0(service).getId();
                    TNDeviceHelper tNDeviceHelper = TNDeviceHelper.f41584a;
                    Intrinsics.g(oaid, "oaid");
                    tNDeviceHelper.h(oaid);
                    String TAG = this.f79547a;
                    Intrinsics.g(TAG, "TAG");
                    ai.a.f694a.b("onServiceConnected oaid=" + oaid, TAG);
                    Context context = this.f79548b;
                    if (context != null) {
                        context.unbindService(this);
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                    Context context2 = this.f79548b;
                    if (context2 != null) {
                        context2.unbindService(this);
                    }
                }
            } catch (Throwable th2) {
                try {
                    Context context3 = this.f79548b;
                    if (context3 != null) {
                        context3.unbindService(this);
                    }
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
                throw th2;
            }
        } catch (Exception e13) {
            e13.printStackTrace();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        Intrinsics.h(name, "name");
    }
}
