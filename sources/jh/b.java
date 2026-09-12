package jh;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import jh.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes4.dex */
public final class b implements ServiceConnection {

    /* renamed from: c, reason: collision with root package name */
    public static final a f66140c = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final String f66141a;

    /* renamed from: b, reason: collision with root package name */
    private Context f66142b;

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
        this.f66141a = b.class.getSimpleName();
        if (context instanceof Application) {
            this.f66142b = context;
        } else {
            this.f66142b = context.getApplicationContext();
        }
        try {
            context.bindService(intent, this, 1);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public /* synthetic */ b(Context context, Intent intent, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, intent);
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName name, IBinder service) {
        Intrinsics.h(name, "name");
        Intrinsics.h(service, "service");
        try {
            try {
                try {
                    String id2 = a.AbstractBinderC0829a.Y0(service).getId();
                    ih.b bVar = ih.b.f65364a;
                    Intrinsics.e(id2);
                    bVar.s(id2);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("onServiceConnected oaid=");
                    sb2.append(id2);
                    Context context = this.f66142b;
                    if (context != null) {
                        context.unbindService(this);
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            } catch (Exception e12) {
                e12.printStackTrace();
                Context context2 = this.f66142b;
                if (context2 != null) {
                    context2.unbindService(this);
                }
            }
        } catch (Throwable th2) {
            try {
                Context context3 = this.f66142b;
                if (context3 != null) {
                    context3.unbindService(this);
                }
            } catch (Exception e13) {
                e13.printStackTrace();
            }
            throw th2;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName name) {
        Intrinsics.h(name, "name");
    }
}
