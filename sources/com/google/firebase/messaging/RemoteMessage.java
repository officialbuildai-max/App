package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.messaging.e;
import com.transsion.push.PushConstants;
import java.util.Map;

@SafeParcelable.Class(creator = "RemoteMessageCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new s0();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;

    @SafeParcelable.Field(id = 2)
    Bundle bundle;
    private Map<String, String> data;
    private b notification;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private final String f32040a;

        /* renamed from: b, reason: collision with root package name */
        private final String f32041b;

        /* renamed from: c, reason: collision with root package name */
        private final String[] f32042c;

        /* renamed from: d, reason: collision with root package name */
        private final String f32043d;

        /* renamed from: e, reason: collision with root package name */
        private final String f32044e;

        /* renamed from: f, reason: collision with root package name */
        private final String[] f32045f;

        /* renamed from: g, reason: collision with root package name */
        private final String f32046g;

        /* renamed from: h, reason: collision with root package name */
        private final String f32047h;

        /* renamed from: i, reason: collision with root package name */
        private final String f32048i;

        /* renamed from: j, reason: collision with root package name */
        private final String f32049j;

        /* renamed from: k, reason: collision with root package name */
        private final String f32050k;

        /* renamed from: l, reason: collision with root package name */
        private final String f32051l;

        /* renamed from: m, reason: collision with root package name */
        private final String f32052m;

        /* renamed from: n, reason: collision with root package name */
        private final Uri f32053n;

        /* renamed from: o, reason: collision with root package name */
        private final String f32054o;

        /* renamed from: p, reason: collision with root package name */
        private final Integer f32055p;

        /* renamed from: q, reason: collision with root package name */
        private final Integer f32056q;

        /* renamed from: r, reason: collision with root package name */
        private final Integer f32057r;

        /* renamed from: s, reason: collision with root package name */
        private final int[] f32058s;

        /* renamed from: t, reason: collision with root package name */
        private final Long f32059t;

        /* renamed from: u, reason: collision with root package name */
        private final boolean f32060u;

        /* renamed from: v, reason: collision with root package name */
        private final boolean f32061v;

        /* renamed from: w, reason: collision with root package name */
        private final boolean f32062w;

        /* renamed from: x, reason: collision with root package name */
        private final boolean f32063x;

        /* renamed from: y, reason: collision with root package name */
        private final boolean f32064y;

        /* renamed from: z, reason: collision with root package name */
        private final long[] f32065z;

        private b(k0 k0Var) {
            this.f32040a = k0Var.p("gcm.n.title");
            this.f32041b = k0Var.h("gcm.n.title");
            this.f32042c = a(k0Var, "gcm.n.title");
            this.f32043d = k0Var.p("gcm.n.body");
            this.f32044e = k0Var.h("gcm.n.body");
            this.f32045f = a(k0Var, "gcm.n.body");
            this.f32046g = k0Var.p("gcm.n.icon");
            this.f32048i = k0Var.o();
            this.f32049j = k0Var.p("gcm.n.tag");
            this.f32050k = k0Var.p("gcm.n.color");
            this.f32051l = k0Var.p("gcm.n.click_action");
            this.f32052m = k0Var.p("gcm.n.android_channel_id");
            this.f32053n = k0Var.f();
            this.f32047h = k0Var.p("gcm.n.image");
            this.f32054o = k0Var.p("gcm.n.ticker");
            this.f32055p = k0Var.b("gcm.n.notification_priority");
            this.f32056q = k0Var.b("gcm.n.visibility");
            this.f32057r = k0Var.b("gcm.n.notification_count");
            this.f32060u = k0Var.a("gcm.n.sticky");
            this.f32061v = k0Var.a("gcm.n.local_only");
            this.f32062w = k0Var.a("gcm.n.default_sound");
            this.f32063x = k0Var.a("gcm.n.default_vibrate_timings");
            this.f32064y = k0Var.a("gcm.n.default_light_settings");
            this.f32059t = k0Var.j("gcm.n.event_time");
            this.f32058s = k0Var.e();
            this.f32065z = k0Var.q();
        }

        private static String[] a(k0 k0Var, String str) {
            Object[] g11 = k0Var.g(str);
            if (g11 == null) {
                return null;
            }
            String[] strArr = new String[g11.length];
            for (int i11 = 0; i11 < g11.length; i11++) {
                strArr[i11] = String.valueOf(g11[i11]);
            }
            return strArr;
        }
    }

    @SafeParcelable.Constructor
    public RemoteMessage(@SafeParcelable.Param(id = 2) Bundle bundle) {
        this.bundle = bundle;
    }

    private int getMessagePriority(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    @Nullable
    public String getCollapseKey() {
        return this.bundle.getString("collapse_key");
    }

    @NonNull
    public Map<String, String> getData() {
        if (this.data == null) {
            this.data = e.a.a(this.bundle);
        }
        return this.data;
    }

    @Nullable
    public String getFrom() {
        return this.bundle.getString("from");
    }

    @Nullable
    public String getMessageId() {
        String string = this.bundle.getString("google.message_id");
        return string == null ? this.bundle.getString(PushConstants.EXTRA_PUSH_MESSAGE_ID) : string;
    }

    @Nullable
    public String getMessageType() {
        return this.bundle.getString(PushConstants.EXTRA_PUSH_MESSAGE_TYPE);
    }

    @Nullable
    public b getNotification() {
        if (this.notification == null && k0.t(this.bundle)) {
            this.notification = new b(new k0(this.bundle));
        }
        return this.notification;
    }

    public int getOriginalPriority() {
        String string = this.bundle.getString("google.original_priority");
        if (string == null) {
            string = this.bundle.getString("google.priority");
        }
        return getMessagePriority(string);
    }

    public int getPriority() {
        String string = this.bundle.getString("google.delivered_priority");
        if (string == null) {
            if ("1".equals(this.bundle.getString("google.priority_reduced"))) {
                return 2;
            }
            string = this.bundle.getString("google.priority");
        }
        return getMessagePriority(string);
    }

    @Nullable
    @ShowFirstParty
    public byte[] getRawData() {
        return this.bundle.getByteArray("rawData");
    }

    @Nullable
    public String getSenderId() {
        return this.bundle.getString("google.c.sender.id");
    }

    public long getSentTime() {
        Object obj = this.bundle.get("google.sent_time");
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return 0L;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("FirebaseMessaging", "Invalid sent time: " + obj);
            return 0L;
        }
    }

    @Nullable
    @Deprecated
    public String getTo() {
        return this.bundle.getString("google.to");
    }

    public int getTtl() {
        Object obj = this.bundle.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            Log.w("FirebaseMessaging", "Invalid TTL: " + obj);
            return 0;
        }
    }

    void populateSendMessageIntent(Intent intent) {
        intent.putExtras(this.bundle);
    }

    @KeepForSdk
    public Intent toIntent() {
        Intent intent = new Intent();
        intent.putExtras(this.bundle);
        return intent;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i11) {
        s0.c(this, parcel, i11);
    }
}
