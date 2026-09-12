package com.transsion.player.mediasession;

import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.core.app.z;
import androidx.media.session.MediaButtonReceiver;
import androidx.media3.common.util.g0;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.a0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.transsion.player.R$mipmap;
import com.transsion.player.R$string;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.mvel2.ast.ASTNode;

/* loaded from: classes6.dex */
public final class h {

    /* renamed from: b, reason: collision with root package name */
    private static boolean f48454b;

    /* renamed from: c, reason: collision with root package name */
    private static MediaSessionCompat f48455c;

    /* renamed from: d, reason: collision with root package name */
    private static MediaService f48456d;

    /* renamed from: e, reason: collision with root package name */
    private static MediaItem f48457e;

    /* renamed from: f, reason: collision with root package name */
    private static Integer f48458f;

    /* renamed from: g, reason: collision with root package name */
    private static Bitmap f48459g;

    /* renamed from: a, reason: collision with root package name */
    public static final h f48453a = new h();

    /* renamed from: h, reason: collision with root package name */
    private static String f48460h = "";

    /* renamed from: i, reason: collision with root package name */
    private static final a f48461i = new a();

    /* loaded from: classes6.dex */
    public static final class a extends CustomTarget {
        a() {
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
            i.f48462a.a(h.f48453a.i() + " --> loadAlbum --> onLoadCleared() ---> 加载失败");
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
            i iVar = i.f48462a;
            h hVar = h.f48453a;
            iVar.a(hVar.i() + " --> loadAlbum --> onLoadFailed() ---> 加载失败");
            h.f48459g = BitmapFactory.decodeResource(Utils.a().getResources(), R$mipmap.player_ic_notification_icon);
            hVar.o(h.f48456d, h.f48457e, h.f48458f, h.f48455c);
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Bitmap resource, Transition transition) {
            Intrinsics.h(resource, "resource");
            String str = h.f48460h;
            MediaItem mediaItem = h.f48457e;
            if (TextUtils.equals(str, mediaItem != null ? mediaItem.getCoverUrl() : null)) {
                h.f48459g = resource;
                h.f48453a.o(h.f48456d, h.f48457e, h.f48458f, h.f48455c);
            }
        }
    }

    private h() {
    }

    private final Bitmap h(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return q(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i() {
        String simpleName = h.class.getSimpleName();
        Intrinsics.g(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    private final String k(String str) {
        String b11;
        b11 = oo.h.f71202a.b(str, a0.a(48.0f), (r18 & 4) != 0 ? true : true, (r18 & 8) != 0, (r18 & 16) != 0 ? 0 : 0, (r18 & 32) != 0 ? false : false, (r18 & 64) != 0 ? false : false);
        return b11;
    }

    private final void m(MediaService mediaService, MediaItem mediaItem, Integer num, MediaSessionCompat mediaSessionCompat) {
        String str;
        String subTitle;
        f48456d = mediaService;
        f48457e = mediaItem;
        f48458f = num;
        f48455c = mediaSessionCompat;
        n();
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        NotificationCompat.m mVar = new NotificationCompat.m(a11, "MUSIC_NOTIFICATION_ID");
        String str2 = "VideoPlayer";
        if (mediaItem == null || (str = mediaItem.getTitle()) == null) {
            str = "VideoPlayer";
        }
        NotificationCompat.m q11 = mVar.q(str);
        if (mediaItem != null && (subTitle = mediaItem.getSubTitle()) != null) {
            str2 = subTitle;
        }
        NotificationCompat.m p11 = q11.p(str2);
        Intrinsics.g(p11, "setContentText(...)");
        Bitmap bitmap = f48459g;
        if (bitmap == null) {
            p11.A(BitmapFactory.decodeResource(Utils.a().getResources(), R$mipmap.player_ic_push_small_logo));
        } else {
            p11.A(bitmap);
        }
        p11.u(MusicNotificationBroadcastReceiver.INSTANCE.a());
        Object obj = null;
        if ((mediaItem != null ? mediaItem.getPendingIntent() : null) != null) {
            p11.o(mediaItem.getPendingIntent());
        }
        p11.O(1);
        if (num != null && num.intValue() == 3) {
            p11.b(new NotificationCompat.b.a(R$mipmap.player_pause, "pause", MediaButtonReceiver.a(a11, 2L)).a());
        } else {
            p11.b(new NotificationCompat.b.a(R$mipmap.player_play, MediaItem.MUSIC_FLOAT_STATE_PLAY, MediaButtonReceiver.a(a11, 4L)).a());
        }
        androidx.media.app.c cVar = new androidx.media.app.c();
        MediaSessionCompat mediaSessionCompat2 = f48455c;
        p11.L(cVar.q(mediaSessionCompat2 != null ? mediaSessionCompat2.b() : null).r(0));
        p11.J(R$mipmap.player_ic_push_small_logo);
        try {
            Notification c11 = p11.c();
            Intrinsics.e(c11);
            c11.flags = 224;
            if (f48454b) {
                if (mediaService != null) {
                    try {
                        obj = mediaService.getSystemService("notification");
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                        return;
                    }
                }
                Intrinsics.f(obj, "null cannot be cast to non-null type android.app.NotificationManager");
                ((NotificationManager) obj).notify(89757, c11);
                return;
            }
            if (!com.blankj.utilcode.util.c.l()) {
                i.f48462a.b("Service is restricted, cannot start foreground.");
                return;
            }
            if (mediaService != null) {
                try {
                    mediaService.startForeground(89757, c11);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                    try {
                        Object systemService = mediaService.getSystemService("notification");
                        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
                        ((NotificationManager) systemService).notify(89757, c11);
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
            }
            f48454b = true;
        } catch (Throwable unused) {
        }
    }

    private final void n() {
        Object m1185constructorimpl;
        String str;
        MediaItem mediaItem = f48457e;
        String coverUrl = mediaItem != null ? mediaItem.getCoverUrl() : null;
        if (TextUtils.isEmpty(coverUrl) || TextUtils.equals(f48460h, coverUrl)) {
            return;
        }
        f48460h = coverUrl;
        if (coverUrl != null && StringsKt.c0(coverUrl, "http", false, 2, null)) {
            f48459g = null;
            RequestBuilder diskCacheStrategy = Glide.with(Utils.a()).asBitmap().centerInside().diskCacheStrategy(DiskCacheStrategy.DATA);
            MediaItem mediaItem2 = f48457e;
            if (mediaItem2 == null || (str = mediaItem2.getCoverUrl()) == null) {
                str = "";
            }
            Intrinsics.e(diskCacheStrategy.load2(k(str)).into((RequestBuilder) f48461i));
            return;
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            f48459g = f48453a.h(f48460h);
            m1185constructorimpl = Result.m1185constructorimpl(Unit.f67184a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.INSTANCE;
            m1185constructorimpl = Result.m1185constructorimpl(ResultKt.a(th2));
        }
        if (Result.m1188exceptionOrNullimpl(m1185constructorimpl) != null) {
            f48459g = BitmapFactory.decodeResource(Utils.a().getResources(), R$mipmap.player_ic_push_small_logo);
        }
        m(f48456d, f48457e, f48458f, f48455c);
    }

    private final Bitmap q(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        int a11 = a0.a(48.0f);
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i11 = 1;
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            int i12 = options.outWidth;
            int i13 = options.outHeight;
            if (i12 <= a11 && i13 <= a11) {
                options.inJustDecodeBounds = false;
                return BitmapFactory.decodeFile(str, options);
            }
            if (i13 > a11 || i12 > a11) {
                float f11 = a11;
                i11 = Math.round(RangesKt.e(i13 / f11, i12 / f11));
            }
            options.inSampleSize = i11;
            options.inJustDecodeBounds = false;
            return BitmapFactory.decodeFile(str, options);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return null;
        }
    }

    public final int j() {
        if (Build.VERSION.SDK_INT >= 31) {
            return 67108864;
        }
        return ASTNode.NOJIT;
    }

    public final void l() {
        i.f48462a.a(i() + " --> initNotificationChannel() --> 初始化 通知的 渠道");
        Object systemService = Utils.a().getSystemService("notification");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager notificationManager = (NotificationManager) systemService;
        if (Build.VERSION.SDK_INT >= 26) {
            g0.a();
            NotificationChannel a11 = m.f.a("MUSIC_NOTIFICATION_ID", Utils.a().getString(R$string.player_notification_name), 3);
            a11.setSound(null, null);
            a11.setDescription("playing media");
            notificationManager.createNotificationChannel(a11);
        }
        MusicNotificationBroadcastReceiver.INSTANCE.b();
    }

    public final void o(MediaService mediaService, MediaItem mediaItem, Integer num, MediaSessionCompat mediaSessionCompat) {
        if (mediaItem != null) {
            m(mediaService, mediaItem, num, mediaSessionCompat);
            return;
        }
        i.f48462a.b(i() + " --> notifyNotification() --> mediaItem == null --> return");
        p();
    }

    public final void p() {
        MediaService mediaService = f48456d;
        if (mediaService != null) {
            z.a(mediaService, 1);
        }
        Object systemService = Utils.a().getSystemService("notification");
        Intrinsics.f(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
        ((NotificationManager) systemService).cancel(89757);
        f48454b = false;
    }

    public final void r(boolean z10) {
        f48454b = z10;
    }
}
