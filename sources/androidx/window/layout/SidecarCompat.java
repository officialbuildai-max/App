package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.core.Version;
import androidx.window.layout.n;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public final class SidecarCompat implements n {

    /* renamed from: f, reason: collision with root package name */
    public static final a f15393f = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final SidecarInterface f15394a;

    /* renamed from: b, reason: collision with root package name */
    private final SidecarAdapter f15395b;

    /* renamed from: c, reason: collision with root package name */
    private final Map f15396c;

    /* renamed from: d, reason: collision with root package name */
    private final Map f15397d;

    /* renamed from: e, reason: collision with root package name */
    private n.a f15398e;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0004\u001a\u00020\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0083\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR \u0010 \u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u001d8\u0002X\u0083\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006!"}, d2 = {"Landroidx/window/layout/SidecarCompat$DistinctSidecarElementCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "Landroidx/window/layout/SidecarAdapter;", "sidecarAdapter", "callbackInterface", "<init>", "(Landroidx/window/layout/SidecarAdapter;Landroidx/window/sidecar/SidecarInterface$SidecarCallback;)V", "Landroidx/window/sidecar/SidecarDeviceState;", "newDeviceState", "", "onDeviceStateChanged", "(Landroidx/window/sidecar/SidecarDeviceState;)V", "Landroid/os/IBinder;", "token", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "newLayout", "onWindowLayoutChanged", "(Landroid/os/IBinder;Landroidx/window/sidecar/SidecarWindowLayoutInfo;)V", "a", "Landroidx/window/layout/SidecarAdapter;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "Ljava/util/concurrent/locks/ReentrantLock;", "c", "Ljava/util/concurrent/locks/ReentrantLock;", "lock", "d", "Landroidx/window/sidecar/SidecarDeviceState;", "lastDeviceState", "Ljava/util/WeakHashMap;", "e", "Ljava/util/WeakHashMap;", "mActivityWindowLayoutInfo", "window_release"}, k = 1, mv = {1, 6, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes2.dex */
    private static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final SidecarAdapter sidecarAdapter;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final SidecarInterface.SidecarCallback callbackInterface;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        private final ReentrantLock lock;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private SidecarDeviceState lastDeviceState;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final WeakHashMap mActivityWindowLayoutInfo;

        public DistinctSidecarElementCallback(SidecarAdapter sidecarAdapter, SidecarInterface.SidecarCallback callbackInterface) {
            Intrinsics.h(sidecarAdapter, "sidecarAdapter");
            Intrinsics.h(callbackInterface, "callbackInterface");
            this.sidecarAdapter = sidecarAdapter;
            this.callbackInterface = callbackInterface;
            this.lock = new ReentrantLock();
            this.mActivityWindowLayoutInfo = new WeakHashMap();
        }

        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            Intrinsics.h(newDeviceState, "newDeviceState");
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                if (this.sidecarAdapter.a(this.lastDeviceState, newDeviceState)) {
                    return;
                }
                this.lastDeviceState = newDeviceState;
                this.callbackInterface.onDeviceStateChanged(newDeviceState);
                Unit unit = Unit.f67184a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public void onWindowLayoutChanged(IBinder token, SidecarWindowLayoutInfo newLayout) {
            Intrinsics.h(token, "token");
            Intrinsics.h(newLayout, "newLayout");
            synchronized (this.lock) {
                if (this.sidecarAdapter.d((SidecarWindowLayoutInfo) this.mActivityWindowLayoutInfo.get(token), newLayout)) {
                    return;
                }
                this.callbackInterface.onWindowLayoutChanged(token, newLayout);
            }
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017¨\u0006\f"}, d2 = {"Landroidx/window/layout/SidecarCompat$TranslatingCallback;", "Landroidx/window/sidecar/SidecarInterface$SidecarCallback;", "(Landroidx/window/layout/SidecarCompat;)V", "onDeviceStateChanged", "", "newDeviceState", "Landroidx/window/sidecar/SidecarDeviceState;", "onWindowLayoutChanged", "windowToken", "Landroid/os/IBinder;", "newLayout", "Landroidx/window/sidecar/SidecarWindowLayoutInfo;", "window_release"}, k = 1, mv = {1, 6, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
    /* loaded from: classes2.dex */
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SidecarCompat f15404a;

        public TranslatingCallback(SidecarCompat this$0) {
            Intrinsics.h(this$0, "this$0");
            this.f15404a = this$0;
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            SidecarInterface g11;
            Intrinsics.h(newDeviceState, "newDeviceState");
            Collection<Activity> values = this.f15404a.f15396c.values();
            SidecarCompat sidecarCompat = this.f15404a;
            for (Activity activity : values) {
                IBinder a11 = SidecarCompat.f15393f.a(activity);
                SidecarWindowLayoutInfo sidecarWindowLayoutInfo = null;
                if (a11 != null && (g11 = sidecarCompat.g()) != null) {
                    sidecarWindowLayoutInfo = g11.getWindowLayoutInfo(a11);
                }
                n.a aVar = sidecarCompat.f15398e;
                if (aVar != null) {
                    aVar.a(activity, sidecarCompat.f15395b.e(sidecarWindowLayoutInfo, newDeviceState));
                }
            }
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onWindowLayoutChanged(IBinder windowToken, SidecarWindowLayoutInfo newLayout) {
            Intrinsics.h(windowToken, "windowToken");
            Intrinsics.h(newLayout, "newLayout");
            Activity activity = (Activity) this.f15404a.f15396c.get(windowToken);
            if (activity == null) {
                Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            SidecarAdapter sidecarAdapter = this.f15404a.f15395b;
            SidecarInterface g11 = this.f15404a.g();
            SidecarDeviceState deviceState = g11 == null ? null : g11.getDeviceState();
            if (deviceState == null) {
                deviceState = new SidecarDeviceState();
            }
            a0 e11 = sidecarAdapter.e(newLayout, deviceState);
            n.a aVar = this.f15404a.f15398e;
            if (aVar == null) {
                return;
            }
            aVar.a(activity, e11);
        }
    }

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IBinder a(Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return null;
            }
            return attributes.token;
        }

        public final SidecarInterface b(Context context) {
            Intrinsics.h(context, "context");
            return SidecarProvider.getSidecarImpl(context.getApplicationContext());
        }

        public final Version c() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (TextUtils.isEmpty(apiVersion)) {
                    return null;
                }
                return Version.f15360f.b(apiVersion);
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }
    }

    /* loaded from: classes2.dex */
    private static final class b implements n.a {

        /* renamed from: a, reason: collision with root package name */
        private final n.a f15405a;

        /* renamed from: b, reason: collision with root package name */
        private final ReentrantLock f15406b;

        /* renamed from: c, reason: collision with root package name */
        private final WeakHashMap f15407c;

        public b(n.a callbackInterface) {
            Intrinsics.h(callbackInterface, "callbackInterface");
            this.f15405a = callbackInterface;
            this.f15406b = new ReentrantLock();
            this.f15407c = new WeakHashMap();
        }

        @Override // androidx.window.layout.n.a
        public void a(Activity activity, a0 newLayout) {
            Intrinsics.h(activity, "activity");
            Intrinsics.h(newLayout, "newLayout");
            ReentrantLock reentrantLock = this.f15406b;
            reentrantLock.lock();
            try {
                if (Intrinsics.c(newLayout, (a0) this.f15407c.get(activity))) {
                    return;
                }
                reentrantLock.unlock();
                this.f15405a.a(activity, newLayout);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* loaded from: classes2.dex */
    private static final class c implements View.OnAttachStateChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private final SidecarCompat f15408a;

        /* renamed from: b, reason: collision with root package name */
        private final WeakReference f15409b;

        public c(SidecarCompat sidecarCompat, Activity activity) {
            Intrinsics.h(sidecarCompat, "sidecarCompat");
            Intrinsics.h(activity, "activity");
            this.f15408a = sidecarCompat;
            this.f15409b = new WeakReference(activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Intrinsics.h(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = (Activity) this.f15409b.get();
            IBinder a11 = SidecarCompat.f15393f.a(activity);
            if (activity == null || a11 == null) {
                return;
            }
            this.f15408a.i(a11, activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Intrinsics.h(view, "view");
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements ComponentCallbacks {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Activity f15411b;

        d(Activity activity) {
            this.f15411b = activity;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration newConfig) {
            Intrinsics.h(newConfig, "newConfig");
            n.a aVar = SidecarCompat.this.f15398e;
            if (aVar == null) {
                return;
            }
            Activity activity = this.f15411b;
            aVar.a(activity, SidecarCompat.this.h(activity));
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SidecarCompat(Context context) {
        this(f15393f.b(context), new SidecarAdapter(null, 1, null));
        Intrinsics.h(context, "context");
    }

    public SidecarCompat(SidecarInterface sidecarInterface, SidecarAdapter sidecarAdapter) {
        Intrinsics.h(sidecarAdapter, "sidecarAdapter");
        this.f15394a = sidecarInterface;
        this.f15395b = sidecarAdapter;
        this.f15396c = new LinkedHashMap();
        this.f15397d = new LinkedHashMap();
    }

    private final void j(Activity activity) {
        if (this.f15397d.get(activity) == null) {
            d dVar = new d(activity);
            this.f15397d.put(activity, dVar);
            activity.registerComponentCallbacks(dVar);
        }
    }

    private final void k(Activity activity) {
        activity.unregisterComponentCallbacks((ComponentCallbacks) this.f15397d.get(activity));
        this.f15397d.remove(activity);
    }

    @Override // androidx.window.layout.n
    public void a(n.a extensionCallback) {
        Intrinsics.h(extensionCallback, "extensionCallback");
        this.f15398e = new b(extensionCallback);
        SidecarInterface sidecarInterface = this.f15394a;
        if (sidecarInterface == null) {
            return;
        }
        sidecarInterface.setSidecarCallback(new DistinctSidecarElementCallback(this.f15395b, new TranslatingCallback(this)));
    }

    @Override // androidx.window.layout.n
    public void b(Activity activity) {
        Intrinsics.h(activity, "activity");
        IBinder a11 = f15393f.a(activity);
        if (a11 != null) {
            i(a11, activity);
        } else {
            activity.getWindow().getDecorView().addOnAttachStateChangeListener(new c(this, activity));
        }
    }

    @Override // androidx.window.layout.n
    public void c(Activity activity) {
        SidecarInterface sidecarInterface;
        Intrinsics.h(activity, "activity");
        IBinder a11 = f15393f.a(activity);
        if (a11 == null) {
            return;
        }
        SidecarInterface sidecarInterface2 = this.f15394a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerRemoved(a11);
        }
        k(activity);
        boolean z10 = this.f15396c.size() == 1;
        this.f15396c.remove(a11);
        if (!z10 || (sidecarInterface = this.f15394a) == null) {
            return;
        }
        sidecarInterface.onDeviceStateListenersChanged(true);
    }

    public final SidecarInterface g() {
        return this.f15394a;
    }

    public final a0 h(Activity activity) {
        Intrinsics.h(activity, "activity");
        IBinder a11 = f15393f.a(activity);
        if (a11 == null) {
            return new a0(CollectionsKt.l());
        }
        SidecarInterface sidecarInterface = this.f15394a;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface == null ? null : sidecarInterface.getWindowLayoutInfo(a11);
        SidecarAdapter sidecarAdapter = this.f15395b;
        SidecarInterface sidecarInterface2 = this.f15394a;
        SidecarDeviceState deviceState = sidecarInterface2 != null ? sidecarInterface2.getDeviceState() : null;
        if (deviceState == null) {
            deviceState = new SidecarDeviceState();
        }
        return sidecarAdapter.e(windowLayoutInfo, deviceState);
    }

    public final void i(IBinder windowToken, Activity activity) {
        SidecarInterface sidecarInterface;
        Intrinsics.h(windowToken, "windowToken");
        Intrinsics.h(activity, "activity");
        this.f15396c.put(windowToken, activity);
        SidecarInterface sidecarInterface2 = this.f15394a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(windowToken);
        }
        if (this.f15396c.size() == 1 && (sidecarInterface = this.f15394a) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        n.a aVar = this.f15398e;
        if (aVar != null) {
            aVar.a(activity, h(activity));
        }
        j(activity);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002c A[Catch: all -> 0x018b, TryCatch #2 {all -> 0x018b, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0103, B:49:0x0106, B:51:0x0131, B:53:0x013b, B:54:0x0142, B:55:0x0143, B:56:0x014a, B:58:0x00b8, B:60:0x00df, B:62:0x014b, B:63:0x0152, B:64:0x0153, B:65:0x015a, B:66:0x015b, B:67:0x0166, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0167, B:74:0x0172, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0173, B:81:0x017e, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017f, B:90:0x018a, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0065 A[Catch: all -> 0x018b, TryCatch #2 {all -> 0x018b, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0103, B:49:0x0106, B:51:0x0131, B:53:0x013b, B:54:0x0142, B:55:0x0143, B:56:0x014a, B:58:0x00b8, B:60:0x00df, B:62:0x014b, B:63:0x0152, B:64:0x0153, B:65:0x015a, B:66:0x015b, B:67:0x0166, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0167, B:74:0x0172, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0173, B:81:0x017e, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017f, B:90:0x018a, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008a A[Catch: all -> 0x018b, TryCatch #2 {all -> 0x018b, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0103, B:49:0x0106, B:51:0x0131, B:53:0x013b, B:54:0x0142, B:55:0x0143, B:56:0x014a, B:58:0x00b8, B:60:0x00df, B:62:0x014b, B:63:0x0152, B:64:0x0153, B:65:0x015a, B:66:0x015b, B:67:0x0166, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0167, B:74:0x0172, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0173, B:81:0x017e, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017f, B:90:0x018a, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00af A[Catch: all -> 0x018b, TRY_LEAVE, TryCatch #2 {all -> 0x018b, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0103, B:49:0x0106, B:51:0x0131, B:53:0x013b, B:54:0x0142, B:55:0x0143, B:56:0x014a, B:58:0x00b8, B:60:0x00df, B:62:0x014b, B:63:0x0152, B:64:0x0153, B:65:0x015a, B:66:0x015b, B:67:0x0166, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0167, B:74:0x0172, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0173, B:81:0x017e, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017f, B:90:0x018a, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x015b A[Catch: all -> 0x018b, TryCatch #2 {all -> 0x018b, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0103, B:49:0x0106, B:51:0x0131, B:53:0x013b, B:54:0x0142, B:55:0x0143, B:56:0x014a, B:58:0x00b8, B:60:0x00df, B:62:0x014b, B:63:0x0152, B:64:0x0153, B:65:0x015a, B:66:0x015b, B:67:0x0166, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0167, B:74:0x0172, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0173, B:81:0x017e, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017f, B:90:0x018a, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00a5 A[Catch: all -> 0x018b, TryCatch #2 {all -> 0x018b, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0103, B:49:0x0106, B:51:0x0131, B:53:0x013b, B:54:0x0142, B:55:0x0143, B:56:0x014a, B:58:0x00b8, B:60:0x00df, B:62:0x014b, B:63:0x0152, B:64:0x0153, B:65:0x015a, B:66:0x015b, B:67:0x0166, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0167, B:74:0x0172, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0173, B:81:0x017e, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017f, B:90:0x018a, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0167 A[Catch: all -> 0x018b, TryCatch #2 {all -> 0x018b, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0103, B:49:0x0106, B:51:0x0131, B:53:0x013b, B:54:0x0142, B:55:0x0143, B:56:0x014a, B:58:0x00b8, B:60:0x00df, B:62:0x014b, B:63:0x0152, B:64:0x0153, B:65:0x015a, B:66:0x015b, B:67:0x0166, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0167, B:74:0x0172, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0173, B:81:0x017e, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017f, B:90:0x018a, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0080 A[Catch: all -> 0x018b, TryCatch #2 {all -> 0x018b, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0103, B:49:0x0106, B:51:0x0131, B:53:0x013b, B:54:0x0142, B:55:0x0143, B:56:0x014a, B:58:0x00b8, B:60:0x00df, B:62:0x014b, B:63:0x0152, B:64:0x0153, B:65:0x015a, B:66:0x015b, B:67:0x0166, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0167, B:74:0x0172, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0173, B:81:0x017e, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017f, B:90:0x018a, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0173 A[Catch: all -> 0x018b, TryCatch #2 {all -> 0x018b, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0103, B:49:0x0106, B:51:0x0131, B:53:0x013b, B:54:0x0142, B:55:0x0143, B:56:0x014a, B:58:0x00b8, B:60:0x00df, B:62:0x014b, B:63:0x0152, B:64:0x0153, B:65:0x015a, B:66:0x015b, B:67:0x0166, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0167, B:74:0x0172, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0173, B:81:0x017e, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017f, B:90:0x018a, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0059 A[Catch: all -> 0x018b, TryCatch #2 {all -> 0x018b, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0103, B:49:0x0106, B:51:0x0131, B:53:0x013b, B:54:0x0142, B:55:0x0143, B:56:0x014a, B:58:0x00b8, B:60:0x00df, B:62:0x014b, B:63:0x0152, B:64:0x0153, B:65:0x015a, B:66:0x015b, B:67:0x0166, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0167, B:74:0x0172, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0173, B:81:0x017e, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017f, B:90:0x018a, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x017f A[Catch: all -> 0x018b, TryCatch #2 {all -> 0x018b, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0103, B:49:0x0106, B:51:0x0131, B:53:0x013b, B:54:0x0142, B:55:0x0143, B:56:0x014a, B:58:0x00b8, B:60:0x00df, B:62:0x014b, B:63:0x0152, B:64:0x0153, B:65:0x015a, B:66:0x015b, B:67:0x0166, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0167, B:74:0x0172, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0173, B:81:0x017e, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017f, B:90:0x018a, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0020 A[Catch: all -> 0x018b, TryCatch #2 {all -> 0x018b, blocks: (B:3:0x0002, B:8:0x0024, B:10:0x002c, B:13:0x0034, B:16:0x003c, B:22:0x005d, B:24:0x0065, B:29:0x0084, B:31:0x008a, B:36:0x00a9, B:38:0x00af, B:41:0x00b5, B:42:0x00e7, B:44:0x0103, B:49:0x0106, B:51:0x0131, B:53:0x013b, B:54:0x0142, B:55:0x0143, B:56:0x014a, B:58:0x00b8, B:60:0x00df, B:62:0x014b, B:63:0x0152, B:64:0x0153, B:65:0x015a, B:66:0x015b, B:67:0x0166, B:68:0x00a5, B:69:0x0090, B:72:0x0097, B:73:0x0167, B:74:0x0172, B:75:0x0080, B:76:0x006b, B:79:0x0072, B:80:0x0173, B:81:0x017e, B:82:0x0059, B:83:0x0044, B:86:0x004b, B:87:0x0039, B:88:0x0031, B:89:0x017f, B:90:0x018a, B:91:0x0020, B:92:0x0009, B:95:0x0010), top: B:2:0x0002, inners: #0, #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean l() {
        /*
            Method dump skipped, instructions count: 396
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.layout.SidecarCompat.l():boolean");
    }
}
