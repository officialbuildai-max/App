package com.transsion.push.feature.sport;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import com.blankj.utilcode.util.a0;
import com.transsion.lib.push.R$drawable;
import com.transsion.lib.push.R$id;
import com.transsion.lib.push.R$layout;
import com.transsion.lib.push.R$string;
import com.transsion.mpush.api.LocalPushMessage;
import com.transsion.mpush.core.renderer.AbsNotificationRenderer;
import com.transsion.mpush.core.utils.c;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.y0;

/* loaded from: classes6.dex */
public final class SportsNotificationRenderer extends AbsNotificationRenderer {

    /* renamed from: e, reason: collision with root package name */
    public static final a f50882e = new a(null);

    /* loaded from: classes6.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final ServerMatchListItemData f50883a;

        /* renamed from: b, reason: collision with root package name */
        private final Bitmap f50884b;

        /* renamed from: c, reason: collision with root package name */
        private final Bitmap f50885c;

        public b(ServerMatchListItemData matchData, Bitmap bitmap, Bitmap bitmap2) {
            Intrinsics.h(matchData, "matchData");
            this.f50883a = matchData;
            this.f50884b = bitmap;
            this.f50885c = bitmap2;
        }

        public final ServerMatchListItemData a() {
            return this.f50883a;
        }

        public final Bitmap b() {
            return this.f50884b;
        }

        public final Bitmap c() {
            return this.f50885c;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return Intrinsics.c(this.f50883a, bVar.f50883a) && Intrinsics.c(this.f50884b, bVar.f50884b) && Intrinsics.c(this.f50885c, bVar.f50885c);
        }

        public int hashCode() {
            int hashCode = this.f50883a.hashCode() * 31;
            Bitmap bitmap = this.f50884b;
            int hashCode2 = (hashCode + (bitmap == null ? 0 : bitmap.hashCode())) * 31;
            Bitmap bitmap2 = this.f50885c;
            return hashCode2 + (bitmap2 != null ? bitmap2.hashCode() : 0);
        }

        public String toString() {
            return "MatchPayload(matchData=" + this.f50883a + ", team1Bitmap=" + this.f50884b + ", team2Bitmap=" + this.f50885c + ")";
        }
    }

    private final void H(Context context, RemoteViews remoteViews, RemoteViews remoteViews2, b bVar) {
        String str;
        String name;
        ServerMatchListItemData a11 = bVar.a();
        Bitmap b11 = bVar.b();
        Bitmap c11 = bVar.c();
        String string = context.getString(R$string.match_vs);
        Intrinsics.g(string, "getString(...)");
        TeamInfoMatch team1 = a11.getTeam1();
        String str2 = "";
        if (team1 == null || (str = team1.getName()) == null) {
            str = "";
        }
        TeamInfoMatch team2 = a11.getTeam2();
        if (team2 != null && (name = team2.getName()) != null) {
            str2 = name;
        }
        String str3 = context.getString(R$string.match_vs_notification1) + str + " " + string + " " + str2 + context.getString(R$string.match_vs_notification2);
        if (remoteViews != null) {
            remoteViews.setTextViewText(R$id.notification_title_tv, str3);
        }
        if (remoteViews2 != null) {
            remoteViews2.setTextViewText(R$id.notification_title_tv, str3);
        }
        if (remoteViews2 != null) {
            remoteViews2.setTextViewText(R$id.tv_team1_name, str);
            remoteViews2.setTextViewText(R$id.tv_team2_name, str2);
            remoteViews2.setTextViewText(R$id.match_round, a11.getMatchRound());
            remoteViews2.setTextViewText(R$id.btn_upcoming, I(a11.getStartTime()));
            if (b11 != null) {
                remoteViews2.setImageViewBitmap(R$id.iv_team1_logo, c.h(c.f47679a, b11, null, a0.a(1.0f), 0, 10, null));
            }
            if (c11 != null) {
                remoteViews2.setImageViewBitmap(R$id.iv_team2_logo, c.h(c.f47679a, c11, null, a0.a(1.0f), 0, 10, null));
            }
            remoteViews2.setInt(R$id.match_push_ly, "setBackgroundResource", R$drawable.push_layer_match_push_bg);
        }
    }

    private final String I(String str) {
        String format;
        if (str == null) {
            return "";
        }
        if (str.length() != 0) {
            try {
                format = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(Long.parseLong(str)));
                Intrinsics.e(format);
            } catch (Exception unused) {
                return "";
            }
        }
        return format;
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    public void D(NotificationCompat.m builder, LocalPushMessage message, Bitmap bitmap) {
        Intrinsics.h(builder, "builder");
        Intrinsics.h(message, "message");
        builder.q(message.getTitle()).p(message.getDesc());
    }

    public final void J(Context context, LocalPushMessage message, ServerMatchListItemData serverMatchListItemData) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        if (serverMatchListItemData == null) {
            super.show(context, message);
        } else {
            k.d(o0.a(y0.b()), null, null, new SportsNotificationRenderer$show$1(serverMatchListItemData, this, context, message, null), 3, null);
        }
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    public void q(Context context, RemoteViews remoteViews, RemoteViews remoteViews2, LocalPushMessage message, Bitmap bitmap, Object obj) {
        Intrinsics.h(context, "context");
        Intrinsics.h(message, "message");
        if (obj instanceof b) {
            H(context, remoteViews, remoteViews2, (b) obj);
        }
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    protected String t() {
        return "push_sdk_sports_channel";
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    protected String u() {
        return "Sports Notification";
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    public Integer v(LocalPushMessage message) {
        Intrinsics.h(message, "message");
        return Integer.valueOf(R$layout.push_notification_normal_small_match);
    }

    @Override // com.transsion.mpush.core.renderer.AbsNotificationRenderer
    public Integer w(LocalPushMessage message) {
        Intrinsics.h(message, "message");
        return Integer.valueOf(R$layout.push_notification_match_upcoming);
    }
}
