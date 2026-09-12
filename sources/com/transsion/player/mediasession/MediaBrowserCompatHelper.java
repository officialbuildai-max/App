package com.transsion.player.mediasession;

import android.app.Application;
import android.content.ComponentName;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class MediaBrowserCompatHelper {

    /* renamed from: h, reason: collision with root package name */
    public static final a f48435h = new a(null);

    /* renamed from: i, reason: collision with root package name */
    private static final Lazy f48436i = LazyKt.b(new Function0() { // from class: com.transsion.player.mediasession.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            MediaBrowserCompatHelper q11;
            q11 = MediaBrowserCompatHelper.q();
            return q11;
        }
    });

    /* renamed from: d, reason: collision with root package name */
    private MediaBrowserCompat f48440d;

    /* renamed from: e, reason: collision with root package name */
    private MediaControllerCompat f48441e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f48443g;

    /* renamed from: a, reason: collision with root package name */
    private final MediaBrowserCompat.n f48437a = new d();

    /* renamed from: b, reason: collision with root package name */
    private final MediaControllerCompat.a f48438b = new c();

    /* renamed from: c, reason: collision with root package name */
    private final MediaBrowserCompat.c f48439c = new b();

    /* renamed from: f, reason: collision with root package name */
    private List f48442f = new ArrayList();

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MediaBrowserCompatHelper a() {
            return (MediaBrowserCompatHelper) MediaBrowserCompatHelper.f48436i.getValue();
        }
    }

    /* loaded from: classes6.dex */
    public static final class b extends MediaBrowserCompat.c {
        b() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void a() {
            String c11;
            super.a();
            try {
                try {
                    MediaBrowserCompat mediaBrowserCompat = MediaBrowserCompatHelper.this.f48440d;
                    if (mediaBrowserCompat != null && (c11 = mediaBrowserCompat.c()) != null) {
                        MediaBrowserCompatHelper mediaBrowserCompatHelper = MediaBrowserCompatHelper.this;
                        MediaBrowserCompat mediaBrowserCompat2 = mediaBrowserCompatHelper.f48440d;
                        if (mediaBrowserCompat2 != null) {
                            mediaBrowserCompat2.g(c11);
                        }
                        MediaBrowserCompat mediaBrowserCompat3 = mediaBrowserCompatHelper.f48440d;
                        if (mediaBrowserCompat3 != null) {
                            mediaBrowserCompat3.f(c11, mediaBrowserCompatHelper.f48437a);
                        }
                    }
                    MediaBrowserCompatHelper mediaBrowserCompatHelper2 = MediaBrowserCompatHelper.this;
                    Application a11 = Utils.a();
                    MediaBrowserCompat mediaBrowserCompat4 = MediaBrowserCompatHelper.this.f48440d;
                    Intrinsics.e(mediaBrowserCompat4);
                    mediaBrowserCompatHelper2.f48441e = new MediaControllerCompat(a11, mediaBrowserCompat4.d());
                    MediaControllerCompat mediaControllerCompat = MediaBrowserCompatHelper.this.f48441e;
                    if (mediaControllerCompat != null) {
                        mediaControllerCompat.c(MediaBrowserCompatHelper.this.f48438b);
                    }
                    List<Function1> list = MediaBrowserCompatHelper.this.f48442f;
                    MediaBrowserCompatHelper mediaBrowserCompatHelper3 = MediaBrowserCompatHelper.this;
                    for (Function1 function1 : list) {
                        MediaControllerCompat mediaControllerCompat2 = mediaBrowserCompatHelper3.f48441e;
                        function1.invoke(mediaControllerCompat2 != null ? mediaControllerCompat2.b() : null);
                    }
                    MediaBrowserCompatHelper.this.f48442f.clear();
                } catch (Exception e11) {
                    e11.printStackTrace();
                    i.f48462a.a("mediaSource --> connectionCallback --> e = " + Log.getStackTraceString(e11));
                }
                MediaBrowserCompatHelper.this.f48443g = false;
            } catch (Throwable th2) {
                MediaBrowserCompatHelper.this.f48443g = false;
                throw th2;
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void b() {
            super.b();
            MediaBrowserCompatHelper.this.f48443g = false;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.c
        public void c() {
            super.c();
        }
    }

    /* loaded from: classes6.dex */
    public static final class c extends MediaControllerCompat.a {
        c() {
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void d(MediaMetadataCompat metadata) {
            Intrinsics.h(metadata, "metadata");
            super.d(metadata);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.a
        public void e(PlaybackStateCompat playbackStateCompat) {
            super.e(playbackStateCompat);
        }
    }

    /* loaded from: classes6.dex */
    public static final class d extends MediaBrowserCompat.n {
        d() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.n
        public void a(String parentId, List children) {
            Intrinsics.h(parentId, "parentId");
            Intrinsics.h(children, "children");
            super.a(parentId, children);
            i.f48462a.a("mediaSource --> subscriptionCallback --> onChildrenLoaded() --> parentId = " + parentId + " -- children = " + children);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit A(MediaControllerCompat.e eVar) {
        if (eVar != null) {
            eVar.c();
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MediaBrowserCompatHelper q() {
        return new MediaBrowserCompatHelper();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit s(MediaItem mediaItem, MediaControllerCompat.e eVar) {
        if (eVar != null) {
            eVar.a("transsion_pause", androidx.core.os.d.b(new Pair("MediaItem", mediaItem)));
        }
        return Unit.f67184a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit u(MediaItem mediaItem, MediaControllerCompat.e eVar) {
        if (eVar != null) {
            eVar.a("transsion_play", androidx.core.os.d.b(new Pair("MediaItem", mediaItem)));
        }
        return Unit.f67184a;
    }

    private final void w(Function1 function1) {
        p(function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(MediaControllerCompat.e eVar) {
        if (eVar != null) {
            eVar.b();
        }
        return Unit.f67184a;
    }

    public final void p(Function1 function1) {
        Object d11;
        try {
            Result.Companion companion = Result.INSTANCE;
            MediaBrowserCompat mediaBrowserCompat = this.f48440d;
            if (mediaBrowserCompat != null && mediaBrowserCompat.e()) {
                if (function1 != null) {
                    MediaControllerCompat mediaControllerCompat = this.f48441e;
                    function1.invoke(mediaControllerCompat != null ? mediaControllerCompat.b() : null);
                    return;
                }
                return;
            }
            if (this.f48443g) {
                if (function1 != null) {
                    this.f48442f.add(function1);
                    return;
                }
                return;
            }
            this.f48443g = true;
            Application a11 = Utils.a();
            if (a11 != null) {
                if (ThreadUtils.j()) {
                    if (function1 != null) {
                        this.f48442f.add(function1);
                    }
                    MediaBrowserCompat mediaBrowserCompat2 = new MediaBrowserCompat(a11, new ComponentName(a11, (Class<?>) MediaService.class), this.f48439c, null);
                    this.f48440d = mediaBrowserCompat2;
                    mediaBrowserCompat2.a();
                    d11 = Unit.f67184a;
                } else {
                    d11 = k.d(o0.a(y0.c()), null, null, new MediaBrowserCompatHelper$init$1$2$2(function1, this, a11, null), 3, null);
                }
                r2 = d11;
            }
            Result.m1185constructorimpl(r2);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            Result.m1185constructorimpl(ResultKt.a(th2));
        }
    }

    public final void r(final MediaItem mediaItem) {
        w(new Function1() { // from class: com.transsion.player.mediasession.d
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit s11;
                s11 = MediaBrowserCompatHelper.s(MediaItem.this, (MediaControllerCompat.e) obj);
                return s11;
            }
        });
    }

    public final void t(final MediaItem mediaItem) {
        w(new Function1() { // from class: com.transsion.player.mediasession.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit u11;
                u11 = MediaBrowserCompatHelper.u(MediaItem.this, (MediaControllerCompat.e) obj);
                return u11;
            }
        });
    }

    public final void v(String mediaId) {
        Intrinsics.h(mediaId, "mediaId");
    }

    public final void x() {
        w(new Function1() { // from class: com.transsion.player.mediasession.c
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit y10;
                y10 = MediaBrowserCompatHelper.y((MediaControllerCompat.e) obj);
                return y10;
            }
        });
    }

    public final void z() {
        w(new Function1() { // from class: com.transsion.player.mediasession.e
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit A;
                A = MediaBrowserCompatHelper.A((MediaControllerCompat.e) obj);
                return A;
            }
        });
    }
}
