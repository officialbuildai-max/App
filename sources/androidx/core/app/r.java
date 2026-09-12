package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements o {

    /* renamed from: a, reason: collision with root package name */
    private final Context f8154a;

    /* renamed from: b, reason: collision with root package name */
    private final Notification.Builder f8155b;

    /* renamed from: c, reason: collision with root package name */
    private final NotificationCompat.m f8156c;

    /* renamed from: d, reason: collision with root package name */
    private RemoteViews f8157d;

    /* renamed from: e, reason: collision with root package name */
    private RemoteViews f8158e;

    /* renamed from: f, reason: collision with root package name */
    private final List f8159f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    private final Bundle f8160g = new Bundle();

    /* renamed from: h, reason: collision with root package name */
    private int f8161h;

    /* renamed from: i, reason: collision with root package name */
    private RemoteViews f8162i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class a {
        static Notification.Builder a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        static Notification.Action d(Notification.Action.Builder builder) {
            return builder.build();
        }

        static String e(Notification notification) {
            return notification.getGroup();
        }

        static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        static Notification.Builder g(Notification.Builder builder, boolean z10) {
            return builder.setGroupSummary(z10);
        }

        static Notification.Builder h(Notification.Builder builder, boolean z10) {
            return builder.setLocalOnly(z10);
        }

        static Notification.Builder i(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    /* loaded from: classes.dex */
    static class b {
        static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        static Notification.Builder b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        static Notification.Builder c(Notification.Builder builder, int i11) {
            return builder.setColor(i11);
        }

        static Notification.Builder d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        static Notification.Builder e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        static Notification.Builder f(Notification.Builder builder, int i11) {
            return builder.setVisibility(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {
        static Notification.Action.Builder a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        static Notification.Builder b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        static Notification.Builder c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
            return builder.setAllowGeneratedReplies(z10);
        }

        static Notification.Builder b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        static Notification.Builder c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        static Notification.Builder d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    /* loaded from: classes.dex */
    static class e {
        static Notification.Builder a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        static Notification.Builder b(Notification.Builder builder, int i11) {
            return builder.setBadgeIconType(i11);
        }

        static Notification.Builder c(Notification.Builder builder, boolean z10) {
            return builder.setColorized(z10);
        }

        static Notification.Builder d(Notification.Builder builder, int i11) {
            return builder.setGroupAlertBehavior(i11);
        }

        static Notification.Builder e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        static Notification.Builder f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        static Notification.Builder g(Notification.Builder builder, long j11) {
            return builder.setTimeoutAfter(j11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class f {
        static Notification.Builder a(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }

        static Notification.Action.Builder b(Notification.Action.Builder builder, int i11) {
            return builder.setSemanticAction(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class g {
        static Notification.Builder a(Notification.Builder builder, boolean z10) {
            return builder.setAllowSystemGeneratedContextualActions(z10);
        }

        static Notification.Builder b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        static Notification.Action.Builder c(Notification.Action.Builder builder, boolean z10) {
            return builder.setContextual(z10);
        }

        static Notification.Builder d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h {
        static Notification.Action.Builder a(Notification.Action.Builder builder, boolean z10) {
            return builder.setAuthenticationRequired(z10);
        }

        static Notification.Builder b(Notification.Builder builder, int i11) {
            return builder.setForegroundServiceBehavior(i11);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(NotificationCompat.m mVar) {
        int i11;
        this.f8156c = mVar;
        Context context = mVar.f8091a;
        this.f8154a = context;
        if (Build.VERSION.SDK_INT >= 26) {
            this.f8155b = e.a(context, mVar.L);
        } else {
            this.f8155b = new Notification.Builder(mVar.f8091a);
        }
        Notification notification = mVar.U;
        this.f8155b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, mVar.f8099i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(mVar.f8095e).setContentText(mVar.f8096f).setContentInfo(mVar.f8101k).setContentIntent(mVar.f8097g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(mVar.f8098h, (notification.flags & 128) != 0).setNumber(mVar.f8102l).setProgress(mVar.f8111u, mVar.f8112v, mVar.f8113w);
        Notification.Builder builder = this.f8155b;
        IconCompat iconCompat = mVar.f8100j;
        c.b(builder, iconCompat == null ? null : iconCompat.x(context));
        this.f8155b.setSubText(mVar.f8108r).setUsesChronometer(mVar.f8105o).setPriority(mVar.f8103m);
        NotificationCompat.p pVar = mVar.f8107q;
        if (pVar instanceof NotificationCompat.n) {
            Iterator it = ((NotificationCompat.n) pVar).q().iterator();
            while (it.hasNext()) {
                b((NotificationCompat.b) it.next());
            }
        } else {
            Iterator it2 = mVar.f8092b.iterator();
            while (it2.hasNext()) {
                b((NotificationCompat.b) it2.next());
            }
        }
        Bundle bundle = mVar.E;
        if (bundle != null) {
            this.f8160g.putAll(bundle);
        }
        int i12 = Build.VERSION.SDK_INT;
        this.f8157d = mVar.I;
        this.f8158e = mVar.J;
        this.f8155b.setShowWhen(mVar.f8104n);
        a.h(this.f8155b, mVar.A);
        a.f(this.f8155b, mVar.f8114x);
        a.i(this.f8155b, mVar.f8116z);
        a.g(this.f8155b, mVar.f8115y);
        this.f8161h = mVar.Q;
        b.b(this.f8155b, mVar.D);
        b.c(this.f8155b, mVar.F);
        b.f(this.f8155b, mVar.G);
        b.d(this.f8155b, mVar.H);
        b.e(this.f8155b, notification.sound, notification.audioAttributes);
        List e11 = i12 < 28 ? e(g(mVar.f8093c), mVar.X) : mVar.X;
        if (e11 != null && !e11.isEmpty()) {
            Iterator it3 = e11.iterator();
            while (it3.hasNext()) {
                b.a(this.f8155b, (String) it3.next());
            }
        }
        this.f8162i = mVar.K;
        if (mVar.f8094d.size() > 0) {
            Bundle bundle2 = mVar.g().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i13 = 0; i13 < mVar.f8094d.size(); i13++) {
                bundle4.putBundle(Integer.toString(i13), s.e((NotificationCompat.b) mVar.f8094d.get(i13)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            mVar.g().putBundle("android.car.EXTENSIONS", bundle2);
            this.f8160g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i14 = Build.VERSION.SDK_INT;
        Object obj = mVar.W;
        if (obj != null) {
            c.c(this.f8155b, obj);
        }
        if (i14 >= 24) {
            this.f8155b.setExtras(mVar.E);
            d.e(this.f8155b, mVar.f8110t);
            RemoteViews remoteViews = mVar.I;
            if (remoteViews != null) {
                d.c(this.f8155b, remoteViews);
            }
            RemoteViews remoteViews2 = mVar.J;
            if (remoteViews2 != null) {
                d.b(this.f8155b, remoteViews2);
            }
            RemoteViews remoteViews3 = mVar.K;
            if (remoteViews3 != null) {
                d.d(this.f8155b, remoteViews3);
            }
        }
        if (i14 >= 26) {
            e.b(this.f8155b, mVar.M);
            e.e(this.f8155b, mVar.f8109s);
            e.f(this.f8155b, mVar.N);
            e.g(this.f8155b, mVar.P);
            e.d(this.f8155b, mVar.Q);
            if (mVar.C) {
                e.c(this.f8155b, mVar.B);
            }
            if (!TextUtils.isEmpty(mVar.L)) {
                this.f8155b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i14 >= 28) {
            Iterator it4 = mVar.f8093c.iterator();
            while (it4.hasNext()) {
                f.a(this.f8155b, ((w) it4.next()).i());
            }
        }
        int i15 = Build.VERSION.SDK_INT;
        if (i15 >= 29) {
            g.a(this.f8155b, mVar.S);
            g.b(this.f8155b, NotificationCompat.l.k(mVar.T));
            androidx.core.content.c cVar = mVar.O;
            if (cVar != null) {
                g.d(this.f8155b, cVar.b());
            }
        }
        if (i15 >= 31 && (i11 = mVar.R) != 0) {
            h.b(this.f8155b, i11);
        }
        if (mVar.V) {
            if (this.f8156c.f8115y) {
                this.f8161h = 2;
            } else {
                this.f8161h = 1;
            }
            this.f8155b.setVibrate(null);
            this.f8155b.setSound(null);
            int i16 = notification.defaults & (-4);
            notification.defaults = i16;
            this.f8155b.setDefaults(i16);
            if (i15 >= 26) {
                if (TextUtils.isEmpty(this.f8156c.f8114x)) {
                    a.f(this.f8155b, NotificationCompat.GROUP_KEY_SILENT);
                }
                e.d(this.f8155b, this.f8161h);
            }
        }
    }

    private void b(NotificationCompat.b bVar) {
        IconCompat d11 = bVar.d();
        Notification.Action.Builder a11 = c.a(d11 != null ? d11.w() : null, bVar.h(), bVar.a());
        if (bVar.e() != null) {
            for (RemoteInput remoteInput : y.b(bVar.e())) {
                a.c(a11, remoteInput);
            }
        }
        Bundle bundle = bVar.c() != null ? new Bundle(bVar.c()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", bVar.b());
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 24) {
            d.a(a11, bVar.b());
        }
        bundle.putInt("android.support.action.semanticAction", bVar.f());
        if (i11 >= 28) {
            f.b(a11, bVar.f());
        }
        if (i11 >= 29) {
            g.c(a11, bVar.j());
        }
        if (i11 >= 31) {
            h.a(a11, bVar.i());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", bVar.g());
        a.b(a11, bundle);
        a.a(this.f8155b, a.d(a11));
    }

    private static List e(List list, List list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        androidx.collection.b bVar = new androidx.collection.b(list.size() + list2.size());
        bVar.addAll(list);
        bVar.addAll(list2);
        return new ArrayList(bVar);
    }

    private static List g(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((w) it.next()).h());
        }
        return arrayList;
    }

    private void h(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }

    @Override // androidx.core.app.o
    public Notification.Builder a() {
        return this.f8155b;
    }

    public Notification c() {
        Bundle extras;
        RemoteViews o11;
        RemoteViews m11;
        NotificationCompat.p pVar = this.f8156c.f8107q;
        if (pVar != null) {
            pVar.b(this);
        }
        RemoteViews n11 = pVar != null ? pVar.n(this) : null;
        Notification d11 = d();
        if (n11 != null) {
            d11.contentView = n11;
        } else {
            RemoteViews remoteViews = this.f8156c.I;
            if (remoteViews != null) {
                d11.contentView = remoteViews;
            }
        }
        if (pVar != null && (m11 = pVar.m(this)) != null) {
            d11.bigContentView = m11;
        }
        if (pVar != null && (o11 = this.f8156c.f8107q.o(this)) != null) {
            d11.headsUpContentView = o11;
        }
        if (pVar != null && (extras = NotificationCompat.getExtras(d11)) != null) {
            pVar.a(extras);
        }
        return d11;
    }

    protected Notification d() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            return this.f8155b.build();
        }
        if (i11 >= 24) {
            Notification build = this.f8155b.build();
            if (this.f8161h != 0) {
                if (a.e(build) != null && (build.flags & 512) != 0 && this.f8161h == 2) {
                    h(build);
                }
                if (a.e(build) != null && (build.flags & 512) == 0 && this.f8161h == 1) {
                    h(build);
                }
            }
            return build;
        }
        this.f8155b.setExtras(this.f8160g);
        Notification build2 = this.f8155b.build();
        RemoteViews remoteViews = this.f8157d;
        if (remoteViews != null) {
            build2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.f8158e;
        if (remoteViews2 != null) {
            build2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.f8162i;
        if (remoteViews3 != null) {
            build2.headsUpContentView = remoteViews3;
        }
        if (this.f8161h != 0) {
            if (a.e(build2) != null && (build2.flags & 512) != 0 && this.f8161h == 2) {
                h(build2);
            }
            if (a.e(build2) != null && (build2.flags & 512) == 0 && this.f8161h == 1) {
                h(build2);
            }
        }
        return build2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context f() {
        return this.f8154a;
    }
}
