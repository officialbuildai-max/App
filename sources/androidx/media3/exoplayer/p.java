package androidx.media3.exoplayer;

import android.content.Context;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.media.MediaRouter2$ControllerCallback;
import android.media.MediaRouter2$RouteCallback;
import android.media.RouteDiscoveryPreference;
import android.media.RoutingSessionInfo;
import android.os.Handler;
import android.os.Looper;
import androidx.media3.common.util.g;
import androidx.media3.exoplayer.m4;
import androidx.media3.exoplayer.p;
import com.google.common.collect.ImmutableList;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
final class p implements m4 {

    /* renamed from: a, reason: collision with root package name */
    private final m4 f12514a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class b implements m4 {

        /* renamed from: a, reason: collision with root package name */
        private AudioManager f12515a;

        /* renamed from: b, reason: collision with root package name */
        private AudioDeviceCallback f12516b;

        /* renamed from: c, reason: collision with root package name */
        private androidx.media3.common.util.g f12517c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a extends AudioDeviceCallback {
            a() {
            }

            @Override // android.media.AudioDeviceCallback
            public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
                b.this.f12517c.i(Boolean.valueOf(b.this.h()));
            }

            @Override // android.media.AudioDeviceCallback
            public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
                b.this.f12517c.i(Boolean.valueOf(b.this.h()));
            }
        }

        private b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean h() {
            for (AudioDeviceInfo audioDeviceInfo : ((AudioManager) androidx.media3.common.util.a.i(this.f12515a)).getDevices(2)) {
                if (audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 5 || audioDeviceInfo.getType() == 6 || audioDeviceInfo.getType() == 11 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 3) {
                    return true;
                }
                int i11 = androidx.media3.common.util.a1.f10432a;
                if (i11 >= 26 && audioDeviceInfo.getType() == 22) {
                    return true;
                }
                if (i11 >= 28 && audioDeviceInfo.getType() == 23) {
                    return true;
                }
                if (i11 >= 31 && (audioDeviceInfo.getType() == 26 || audioDeviceInfo.getType() == 27)) {
                    return true;
                }
                if (i11 >= 33 && audioDeviceInfo.getType() == 30) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void i() {
            AudioManager audioManager = this.f12515a;
            if (audioManager != null) {
                audioManager.unregisterAudioDeviceCallback((AudioDeviceCallback) androidx.media3.common.util.a.e(this.f12516b));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void j(m4.a aVar, Boolean bool, Boolean bool2) {
            aVar.a(bool2.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k(Context context) {
            AudioManager audioManager;
            androidx.media3.common.util.a.e(this.f12517c);
            if (androidx.media3.common.util.a1.L0(context) && (audioManager = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO)) != null) {
                this.f12515a = audioManager;
                a aVar = new a();
                this.f12516b = aVar;
                audioManager.registerAudioDeviceCallback(aVar, new Handler((Looper) androidx.media3.common.util.a.e(Looper.myLooper())));
                this.f12517c.i(Boolean.valueOf(h()));
            }
        }

        @Override // androidx.media3.exoplayer.m4
        public boolean a() {
            androidx.media3.common.util.g gVar = this.f12517c;
            if (gVar == null) {
                return true;
            }
            return ((Boolean) gVar.d()).booleanValue();
        }

        @Override // androidx.media3.exoplayer.m4
        public void b(final m4.a aVar, final Context context, Looper looper, Looper looper2, androidx.media3.common.util.i iVar) {
            androidx.media3.common.util.g gVar = new androidx.media3.common.util.g(Boolean.TRUE, looper2, looper, iVar, new g.a() { // from class: androidx.media3.exoplayer.r
                @Override // androidx.media3.common.util.g.a
                public final void a(Object obj, Object obj2) {
                    p.b.j(m4.a.this, (Boolean) obj, (Boolean) obj2);
                }
            });
            this.f12517c = gVar;
            gVar.h(new Runnable() { // from class: androidx.media3.exoplayer.s
                @Override // java.lang.Runnable
                public final void run() {
                    p.b.this.k(context);
                }
            });
        }

        @Override // androidx.media3.exoplayer.m4
        public void disable() {
            ((androidx.media3.common.util.g) androidx.media3.common.util.a.e(this.f12517c)).h(new Runnable() { // from class: androidx.media3.exoplayer.q
                @Override // java.lang.Runnable
                public final void run() {
                    p.b.this.i();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c implements m4 {

        /* renamed from: e, reason: collision with root package name */
        private static final RouteDiscoveryPreference f12519e;

        /* renamed from: a, reason: collision with root package name */
        private MediaRouter2 f12520a;

        /* renamed from: b, reason: collision with root package name */
        private MediaRouter2$RouteCallback f12521b;

        /* renamed from: c, reason: collision with root package name */
        private MediaRouter2$ControllerCallback f12522c;

        /* renamed from: d, reason: collision with root package name */
        private androidx.media3.common.util.g f12523d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class a extends MediaRouter2$RouteCallback {
            a() {
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes2.dex */
        public class b extends MediaRouter2$ControllerCallback {
            b() {
            }

            public void onControllerUpdated(MediaRouter2.RoutingController routingController) {
                c.this.f12523d.i(Boolean.valueOf(c.j(c.this.f12520a)));
            }
        }

        static {
            RouteDiscoveryPreference build;
            c0.a();
            build = t.a(ImmutableList.of(), false).build();
            f12519e = build;
        }

        private c() {
        }

        private static boolean i(MediaRoute2Info mediaRoute2Info, int i11, boolean z10) {
            int suitabilityStatus;
            suitabilityStatus = mediaRoute2Info.getSuitabilityStatus();
            return suitabilityStatus == 1 ? (i11 == 1 || i11 == 2) && z10 : suitabilityStatus == 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean j(MediaRouter2 mediaRouter2) {
            MediaRouter2.RoutingController systemController;
            RoutingSessionInfo routingSessionInfo;
            int transferReason;
            MediaRouter2.RoutingController systemController2;
            boolean wasTransferInitiatedBySelf;
            MediaRouter2.RoutingController systemController3;
            List selectedRoutes;
            systemController = h0.a(androidx.media3.common.util.a.e(mediaRouter2)).getSystemController();
            routingSessionInfo = systemController.getRoutingSessionInfo();
            transferReason = routingSessionInfo.getTransferReason();
            systemController2 = mediaRouter2.getSystemController();
            wasTransferInitiatedBySelf = systemController2.wasTransferInitiatedBySelf();
            systemController3 = mediaRouter2.getSystemController();
            selectedRoutes = systemController3.getSelectedRoutes();
            Iterator it = selectedRoutes.iterator();
            while (it.hasNext()) {
                if (i(a0.a(it.next()), transferReason, wasTransferInitiatedBySelf)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void k() {
            h0.a(androidx.media3.common.util.a.e(this.f12520a)).unregisterControllerCallback(i0.a(androidx.media3.common.util.a.e(this.f12522c)));
            this.f12522c = null;
            this.f12520a.unregisterRouteCallback(k0.a(androidx.media3.common.util.a.e(this.f12521b)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void l(m4.a aVar, Boolean bool, Boolean bool2) {
            aVar.a(bool2.booleanValue());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void m(Context context) {
            MediaRouter2 mediaRouter2;
            androidx.media3.common.util.a.e(this.f12523d);
            mediaRouter2 = MediaRouter2.getInstance(context);
            this.f12520a = mediaRouter2;
            this.f12521b = new a();
            final androidx.media3.common.util.g gVar = this.f12523d;
            Objects.requireNonNull(gVar);
            Executor executor = new Executor() { // from class: androidx.media3.exoplayer.o0
                @Override // java.util.concurrent.Executor
                public final void execute(Runnable runnable) {
                    androidx.media3.common.util.g.this.h(runnable);
                }
            };
            this.f12520a.registerRouteCallback(executor, this.f12521b, f12519e);
            b bVar = new b();
            this.f12522c = bVar;
            this.f12520a.registerControllerCallback(executor, bVar);
            this.f12523d.i(Boolean.valueOf(j(this.f12520a)));
        }

        @Override // androidx.media3.exoplayer.m4
        public boolean a() {
            androidx.media3.common.util.g gVar = this.f12523d;
            if (gVar == null) {
                return true;
            }
            return ((Boolean) gVar.d()).booleanValue();
        }

        @Override // androidx.media3.exoplayer.m4
        public void b(final m4.a aVar, final Context context, Looper looper, Looper looper2, androidx.media3.common.util.i iVar) {
            androidx.media3.common.util.g gVar = new androidx.media3.common.util.g(Boolean.TRUE, looper2, looper, iVar, new g.a() { // from class: androidx.media3.exoplayer.m0
                @Override // androidx.media3.common.util.g.a
                public final void a(Object obj, Object obj2) {
                    p.c.l(m4.a.this, (Boolean) obj, (Boolean) obj2);
                }
            });
            this.f12523d = gVar;
            gVar.h(new Runnable() { // from class: androidx.media3.exoplayer.n0
                @Override // java.lang.Runnable
                public final void run() {
                    p.c.this.m(context);
                }
            });
        }

        @Override // androidx.media3.exoplayer.m4
        public void disable() {
            ((androidx.media3.common.util.g) androidx.media3.common.util.a.i(this.f12523d)).h(new Runnable() { // from class: androidx.media3.exoplayer.l0
                @Override // java.lang.Runnable
                public final void run() {
                    p.c.this.k();
                }
            });
        }
    }

    public p() {
        int i11 = androidx.media3.common.util.a1.f10432a;
        if (i11 >= 35) {
            this.f12514a = new c();
        } else if (i11 >= 23) {
            this.f12514a = new b();
        } else {
            this.f12514a = null;
        }
    }

    @Override // androidx.media3.exoplayer.m4
    public boolean a() {
        m4 m4Var = this.f12514a;
        return m4Var == null || m4Var.a();
    }

    @Override // androidx.media3.exoplayer.m4
    public void b(m4.a aVar, Context context, Looper looper, Looper looper2, androidx.media3.common.util.i iVar) {
        m4 m4Var = this.f12514a;
        if (m4Var != null) {
            m4Var.b(aVar, context, looper, looper2, iVar);
        }
    }

    @Override // androidx.media3.exoplayer.m4
    public void disable() {
        m4 m4Var = this.f12514a;
        if (m4Var != null) {
            m4Var.disable();
        }
    }
}
