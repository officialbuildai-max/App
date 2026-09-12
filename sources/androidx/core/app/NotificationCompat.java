package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.core.R$color;
import androidx.core.R$dimen;
import androidx.core.R$drawable;
import androidx.core.R$id;
import androidx.core.R$layout;
import androidx.core.R$string;
import androidx.core.app.w;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class NotificationCompat {
    public static final int BADGE_ICON_LARGE = 2;
    public static final int BADGE_ICON_NONE = 0;
    public static final int BADGE_ICON_SMALL = 1;
    public static final String CATEGORY_ALARM = "alarm";
    public static final String CATEGORY_CALL = "call";
    public static final String CATEGORY_EMAIL = "email";
    public static final String CATEGORY_ERROR = "err";
    public static final String CATEGORY_EVENT = "event";
    public static final String CATEGORY_LOCATION_SHARING = "location_sharing";
    public static final String CATEGORY_MESSAGE = "msg";
    public static final String CATEGORY_MISSED_CALL = "missed_call";
    public static final String CATEGORY_NAVIGATION = "navigation";
    public static final String CATEGORY_PROGRESS = "progress";
    public static final String CATEGORY_PROMO = "promo";
    public static final String CATEGORY_RECOMMENDATION = "recommendation";
    public static final String CATEGORY_REMINDER = "reminder";
    public static final String CATEGORY_SERVICE = "service";
    public static final String CATEGORY_SOCIAL = "social";
    public static final String CATEGORY_STATUS = "status";
    public static final String CATEGORY_STOPWATCH = "stopwatch";
    public static final String CATEGORY_SYSTEM = "sys";
    public static final String CATEGORY_TRANSPORT = "transport";
    public static final String CATEGORY_VOICEMAIL = "voicemail";
    public static final String CATEGORY_WORKOUT = "workout";
    public static final int COLOR_DEFAULT = 0;
    public static final int DEFAULT_ALL = -1;
    public static final int DEFAULT_LIGHTS = 4;
    public static final int DEFAULT_SOUND = 1;
    public static final int DEFAULT_VIBRATE = 2;

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_ANSWER_COLOR = "android.answerColor";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_ANSWER_INTENT = "android.answerIntent";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_AUDIO_CONTENTS_URI = "android.audioContents";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_BACKGROUND_IMAGE_URI = "android.backgroundImageUri";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_BIG_TEXT = "android.bigText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_IS_VIDEO = "android.callIsVideo";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_PERSON = "android.callPerson";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_PERSON_COMPAT = "android.callPersonCompat";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CALL_TYPE = "android.callType";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHANNEL_GROUP_ID = "android.intent.extra.CHANNEL_GROUP_ID";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHANNEL_ID = "android.intent.extra.CHANNEL_ID";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CHRONOMETER_COUNT_DOWN = "android.chronometerCountDown";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_COLORIZED = "android.colorized";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_COMPACT_ACTIONS = "android.compactActions";
    public static final String EXTRA_COMPAT_TEMPLATE = "androidx.core.app.extra.COMPAT_TEMPLATE";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_CONVERSATION_TITLE = "android.conversationTitle";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_DECLINE_COLOR = "android.declineColor";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_DECLINE_INTENT = "android.declineIntent";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HANG_UP_INTENT = "android.hangUpIntent";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HIDDEN_CONVERSATION_TITLE = "android.hiddenConversationTitle";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_HISTORIC_MESSAGES = "android.messages.historic";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_INFO_TEXT = "android.infoText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_IS_GROUP_CONVERSATION = "android.isGroupConversation";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_LARGE_ICON = "android.largeIcon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_LARGE_ICON_BIG = "android.largeIcon.big";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MEDIA_SESSION = "android.mediaSession";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MESSAGES = "android.messages";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_MESSAGING_STYLE_USER = "android.messagingStyleUser";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_NOTIFICATION_ID = "android.intent.extra.NOTIFICATION_ID";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_NOTIFICATION_TAG = "android.intent.extra.NOTIFICATION_TAG";

    @SuppressLint({"ActionValue"})
    @Deprecated
    public static final String EXTRA_PEOPLE = "android.people";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PEOPLE_LIST = "android.people.list";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE = "android.picture";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE_CONTENT_DESCRIPTION = "android.pictureContentDescription";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PICTURE_ICON = "android.pictureIcon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS = "android.progress";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS_INDETERMINATE = "android.progressIndeterminate";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_PROGRESS_MAX = "android.progressMax";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_REMOTE_INPUT_HISTORY = "android.remoteInputHistory";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SELF_DISPLAY_NAME = "android.selfDisplayName";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_BIG_PICTURE_WHEN_COLLAPSED = "android.showBigPictureWhenCollapsed";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_CHRONOMETER = "android.showChronometer";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SHOW_WHEN = "android.showWhen";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SMALL_ICON = "android.icon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SUB_TEXT = "android.subText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_SUMMARY_TEXT = "android.summaryText";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEMPLATE = "android.template";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEXT = "android.text";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TEXT_LINES = "android.textLines";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TITLE = "android.title";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_TITLE_BIG = "android.title.big";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_VERIFICATION_ICON = "android.verificationIcon";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_VERIFICATION_ICON_COMPAT = "android.verificationIconCompat";

    @SuppressLint({"ActionValue"})
    public static final String EXTRA_VERIFICATION_TEXT = "android.verificationText";
    public static final int FLAG_AUTO_CANCEL = 16;
    public static final int FLAG_BUBBLE = 4096;
    public static final int FLAG_FOREGROUND_SERVICE = 64;
    public static final int FLAG_GROUP_SUMMARY = 512;

    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;
    public static final int FLAG_INSISTENT = 4;
    public static final int FLAG_LOCAL_ONLY = 256;
    public static final int FLAG_NO_CLEAR = 32;
    public static final int FLAG_ONGOING_EVENT = 2;
    public static final int FLAG_ONLY_ALERT_ONCE = 8;
    public static final int FLAG_SHOW_LIGHTS = 1;
    public static final int FOREGROUND_SERVICE_DEFAULT = 0;
    public static final int FOREGROUND_SERVICE_DEFERRED = 2;
    public static final int FOREGROUND_SERVICE_IMMEDIATE = 1;
    public static final int GROUP_ALERT_ALL = 0;
    public static final int GROUP_ALERT_CHILDREN = 2;
    public static final int GROUP_ALERT_SUMMARY = 1;
    public static final String GROUP_KEY_SILENT = "silent";

    @SuppressLint({"ActionValue"})
    public static final String INTENT_CATEGORY_NOTIFICATION_PREFERENCES = "android.intent.category.NOTIFICATION_PREFERENCES";
    public static final int MAX_ACTION_BUTTONS = 3;
    public static final int PRIORITY_DEFAULT = 0;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_MAX = 2;
    public static final int PRIORITY_MIN = -2;
    public static final int STREAM_DEFAULT = -1;
    private static final String TAG = "NotifCompat";
    public static final int VISIBILITY_PRIVATE = 0;
    public static final int VISIBILITY_PUBLIC = 1;
    public static final int VISIBILITY_SECRET = -1;

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        final Bundle f8049a;

        /* renamed from: b, reason: collision with root package name */
        private IconCompat f8050b;

        /* renamed from: c, reason: collision with root package name */
        private final y[] f8051c;

        /* renamed from: d, reason: collision with root package name */
        private final y[] f8052d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f8053e;

        /* renamed from: f, reason: collision with root package name */
        boolean f8054f;

        /* renamed from: g, reason: collision with root package name */
        private final int f8055g;

        /* renamed from: h, reason: collision with root package name */
        private final boolean f8056h;

        /* renamed from: i, reason: collision with root package name */
        public int f8057i;

        /* renamed from: j, reason: collision with root package name */
        public CharSequence f8058j;

        /* renamed from: k, reason: collision with root package name */
        public PendingIntent f8059k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f8060l;

        /* loaded from: classes.dex */
        public static final class a {

            /* renamed from: a, reason: collision with root package name */
            private final IconCompat f8061a;

            /* renamed from: b, reason: collision with root package name */
            private final CharSequence f8062b;

            /* renamed from: c, reason: collision with root package name */
            private final PendingIntent f8063c;

            /* renamed from: d, reason: collision with root package name */
            private boolean f8064d;

            /* renamed from: e, reason: collision with root package name */
            private final Bundle f8065e;

            /* renamed from: f, reason: collision with root package name */
            private ArrayList f8066f;

            /* renamed from: g, reason: collision with root package name */
            private int f8067g;

            /* renamed from: h, reason: collision with root package name */
            private boolean f8068h;

            /* renamed from: i, reason: collision with root package name */
            private boolean f8069i;

            /* renamed from: j, reason: collision with root package name */
            private boolean f8070j;

            public a(int i11, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i11 != 0 ? IconCompat.k(null, "", i11) : null, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            private a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, y[] yVarArr, boolean z10, int i11, boolean z11, boolean z12, boolean z13) {
                this.f8064d = true;
                this.f8068h = true;
                this.f8061a = iconCompat;
                this.f8062b = m.k(charSequence);
                this.f8063c = pendingIntent;
                this.f8065e = bundle;
                this.f8066f = yVarArr == null ? null : new ArrayList(Arrays.asList(yVarArr));
                this.f8064d = z10;
                this.f8067g = i11;
                this.f8068h = z11;
                this.f8069i = z12;
                this.f8070j = z13;
            }

            private void b() {
                if (this.f8069i && this.f8063c == null) {
                    throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
                }
            }

            public b a() {
                b();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = this.f8066f;
                if (arrayList3 != null) {
                    Iterator it = arrayList3.iterator();
                    while (it.hasNext()) {
                        y yVar = (y) it.next();
                        if (yVar.j()) {
                            arrayList.add(yVar);
                        } else {
                            arrayList2.add(yVar);
                        }
                    }
                }
                return new b(this.f8061a, this.f8062b, this.f8063c, this.f8065e, arrayList2.isEmpty() ? null : (y[]) arrayList2.toArray(new y[arrayList2.size()]), arrayList.isEmpty() ? null : (y[]) arrayList.toArray(new y[arrayList.size()]), this.f8064d, this.f8067g, this.f8068h, this.f8069i, this.f8070j);
            }
        }

        public b(int i11, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i11 != 0 ? IconCompat.k(null, "", i11) : null, charSequence, pendingIntent);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(int i11, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, y[] yVarArr, y[] yVarArr2, boolean z10, int i12, boolean z11, boolean z12, boolean z13) {
            this(i11 != 0 ? IconCompat.k(null, "", i11) : null, charSequence, pendingIntent, bundle, yVarArr, yVarArr2, z10, i12, z11, z12, z13);
        }

        public b(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (y[]) null, (y[]) null, true, 0, true, false, false);
        }

        b(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, y[] yVarArr, y[] yVarArr2, boolean z10, int i11, boolean z11, boolean z12, boolean z13) {
            this.f8054f = true;
            this.f8050b = iconCompat;
            if (iconCompat != null && iconCompat.p() == 2) {
                this.f8057i = iconCompat.m();
            }
            this.f8058j = m.k(charSequence);
            this.f8059k = pendingIntent;
            this.f8049a = bundle == null ? new Bundle() : bundle;
            this.f8051c = yVarArr;
            this.f8052d = yVarArr2;
            this.f8053e = z10;
            this.f8055g = i11;
            this.f8054f = z11;
            this.f8056h = z12;
            this.f8060l = z13;
        }

        public PendingIntent a() {
            return this.f8059k;
        }

        public boolean b() {
            return this.f8053e;
        }

        public Bundle c() {
            return this.f8049a;
        }

        public IconCompat d() {
            int i11;
            if (this.f8050b == null && (i11 = this.f8057i) != 0) {
                this.f8050b = IconCompat.k(null, "", i11);
            }
            return this.f8050b;
        }

        public y[] e() {
            return this.f8051c;
        }

        public int f() {
            return this.f8055g;
        }

        public boolean g() {
            return this.f8054f;
        }

        public CharSequence h() {
            return this.f8058j;
        }

        public boolean i() {
            return this.f8060l;
        }

        public boolean j() {
            return this.f8056h;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class c {
        static boolean a(RemoteInput remoteInput) {
            return remoteInput.getAllowFreeFormInput();
        }

        static CharSequence[] b(RemoteInput remoteInput) {
            return remoteInput.getChoices();
        }

        static Bundle c(Notification.Action action) {
            return action.getExtras();
        }

        static Bundle d(RemoteInput remoteInput) {
            return remoteInput.getExtras();
        }

        static String e(Notification notification) {
            return notification.getGroup();
        }

        static CharSequence f(RemoteInput remoteInput) {
            return remoteInput.getLabel();
        }

        static RemoteInput[] g(Notification.Action action) {
            return action.getRemoteInputs();
        }

        static String h(RemoteInput remoteInput) {
            return remoteInput.getResultKey();
        }

        static String i(Notification notification) {
            return notification.getSortKey();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d {
        static Icon a(Notification.Action action) {
            return action.getIcon();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class e {
        static boolean a(Notification.Action action) {
            return action.getAllowGeneratedReplies();
        }
    }

    /* loaded from: classes.dex */
    static class f {
        static int a(Notification notification) {
            return notification.getBadgeIconType();
        }

        static String b(Notification notification) {
            return notification.getChannelId();
        }

        static int c(Notification notification) {
            return notification.getGroupAlertBehavior();
        }

        static CharSequence d(Notification notification) {
            return notification.getSettingsText();
        }

        static String e(Notification notification) {
            return notification.getShortcutId();
        }

        static long f(Notification notification) {
            return notification.getTimeoutAfter();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class g {
        static int a(Notification.Action action) {
            return action.getSemanticAction();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class h {
        static boolean a(Notification notification) {
            return notification.getAllowSystemGeneratedContextualActions();
        }

        static Notification.BubbleMetadata b(Notification notification) {
            return notification.getBubbleMetadata();
        }

        static int c(RemoteInput remoteInput) {
            return remoteInput.getEditChoicesBeforeSending();
        }

        static LocusId d(Notification notification) {
            return notification.getLocusId();
        }

        static boolean e(Notification.Action action) {
            return action.isContextual();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class i {
        static boolean a(Notification.Action action) {
            return action.isAuthenticationRequired();
        }
    }

    /* loaded from: classes.dex */
    public static class j extends p {

        /* renamed from: e, reason: collision with root package name */
        private IconCompat f8071e;

        /* renamed from: f, reason: collision with root package name */
        private IconCompat f8072f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f8073g;

        /* renamed from: h, reason: collision with root package name */
        private CharSequence f8074h;

        /* renamed from: i, reason: collision with root package name */
        private boolean f8075i;

        /* loaded from: classes.dex */
        private static class a {
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        /* loaded from: classes.dex */
        private static class b {
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            static void c(Notification.BigPictureStyle bigPictureStyle, boolean z10) {
                bigPictureStyle.showBigPictureWhenCollapsed(z10);
            }
        }

        @Override // androidx.core.app.NotificationCompat.p
        public void b(androidx.core.app.o oVar) {
            Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(oVar.a()).setBigContentTitle(this.f8128b);
            IconCompat iconCompat = this.f8071e;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 31) {
                    b.a(bigContentTitle, this.f8071e.x(oVar instanceof r ? ((r) oVar).f() : null));
                } else if (iconCompat.p() == 1) {
                    bigContentTitle = bigContentTitle.bigPicture(this.f8071e.l());
                }
            }
            if (this.f8073g) {
                if (this.f8072f == null) {
                    bigContentTitle.bigLargeIcon((Bitmap) null);
                } else {
                    a.a(bigContentTitle, this.f8072f.x(oVar instanceof r ? ((r) oVar).f() : null));
                }
            }
            if (this.f8130d) {
                bigContentTitle.setSummaryText(this.f8129c);
            }
            if (Build.VERSION.SDK_INT >= 31) {
                b.c(bigContentTitle, this.f8075i);
                b.b(bigContentTitle, this.f8074h);
            }
        }

        @Override // androidx.core.app.NotificationCompat.p
        protected String k() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        public j q(Bitmap bitmap) {
            this.f8072f = bitmap == null ? null : IconCompat.g(bitmap);
            this.f8073g = true;
            return this;
        }

        public j r(Bitmap bitmap) {
            this.f8071e = bitmap == null ? null : IconCompat.g(bitmap);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class k extends p {

        /* renamed from: e, reason: collision with root package name */
        private CharSequence f8076e;

        @Override // androidx.core.app.NotificationCompat.p
        public void a(Bundle bundle) {
            super.a(bundle);
        }

        @Override // androidx.core.app.NotificationCompat.p
        public void b(androidx.core.app.o oVar) {
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(oVar.a()).setBigContentTitle(this.f8128b).bigText(this.f8076e);
            if (this.f8130d) {
                bigText.setSummaryText(this.f8129c);
            }
        }

        @Override // androidx.core.app.NotificationCompat.p
        protected String k() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        public k q(CharSequence charSequence) {
            this.f8076e = m.k(charSequence);
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class l {

        /* renamed from: a, reason: collision with root package name */
        private PendingIntent f8077a;

        /* renamed from: b, reason: collision with root package name */
        private PendingIntent f8078b;

        /* renamed from: c, reason: collision with root package name */
        private IconCompat f8079c;

        /* renamed from: d, reason: collision with root package name */
        private int f8080d;

        /* renamed from: e, reason: collision with root package name */
        private int f8081e;

        /* renamed from: f, reason: collision with root package name */
        private int f8082f;

        /* renamed from: g, reason: collision with root package name */
        private String f8083g;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class a {
            static l a(Notification.BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null || bubbleMetadata.getIntent() == null) {
                    return null;
                }
                c g11 = new c(bubbleMetadata.getIntent(), IconCompat.b(bubbleMetadata.getIcon())).b(bubbleMetadata.getAutoExpandBubble()).c(bubbleMetadata.getDeleteIntent()).g(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    g11.d(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    g11.e(bubbleMetadata.getDesiredHeightResId());
                }
                return g11.a();
            }

            static Notification.BubbleMetadata b(l lVar) {
                if (lVar == null || lVar.g() == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setIcon(lVar.f().w()).setIntent(lVar.g()).setDeleteIntent(lVar.c()).setAutoExpandBubble(lVar.b()).setSuppressNotification(lVar.i());
                if (lVar.d() != 0) {
                    suppressNotification.setDesiredHeight(lVar.d());
                }
                if (lVar.e() != 0) {
                    suppressNotification.setDesiredHeightResId(lVar.e());
                }
                return suppressNotification.build();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class b {
            static l a(Notification.BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null) {
                    return null;
                }
                c cVar = bubbleMetadata.getShortcutId() != null ? new c(bubbleMetadata.getShortcutId()) : new c(bubbleMetadata.getIntent(), IconCompat.b(bubbleMetadata.getIcon()));
                cVar.b(bubbleMetadata.getAutoExpandBubble()).c(bubbleMetadata.getDeleteIntent()).g(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    cVar.d(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    cVar.e(bubbleMetadata.getDesiredHeightResId());
                }
                return cVar.a();
            }

            static Notification.BubbleMetadata b(l lVar) {
                if (lVar == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder builder = lVar.h() != null ? new Notification.BubbleMetadata.Builder(lVar.h()) : new Notification.BubbleMetadata.Builder(lVar.g(), lVar.f().w());
                builder.setDeleteIntent(lVar.c()).setAutoExpandBubble(lVar.b()).setSuppressNotification(lVar.i());
                if (lVar.d() != 0) {
                    builder.setDesiredHeight(lVar.d());
                }
                if (lVar.e() != 0) {
                    builder.setDesiredHeightResId(lVar.e());
                }
                return builder.build();
            }
        }

        /* loaded from: classes.dex */
        public static final class c {

            /* renamed from: a, reason: collision with root package name */
            private PendingIntent f8084a;

            /* renamed from: b, reason: collision with root package name */
            private IconCompat f8085b;

            /* renamed from: c, reason: collision with root package name */
            private int f8086c;

            /* renamed from: d, reason: collision with root package name */
            private int f8087d;

            /* renamed from: e, reason: collision with root package name */
            private int f8088e;

            /* renamed from: f, reason: collision with root package name */
            private PendingIntent f8089f;

            /* renamed from: g, reason: collision with root package name */
            private String f8090g;

            @Deprecated
            public c() {
            }

            public c(PendingIntent pendingIntent, IconCompat iconCompat) {
                if (pendingIntent == null) {
                    throw new NullPointerException("Bubble requires non-null pending intent");
                }
                if (iconCompat == null) {
                    throw new NullPointerException("Bubbles require non-null icon");
                }
                this.f8084a = pendingIntent;
                this.f8085b = iconCompat;
            }

            public c(String str) {
                if (TextUtils.isEmpty(str)) {
                    throw new NullPointerException("Bubble requires a non-null shortcut id");
                }
                this.f8090g = str;
            }

            private c f(int i11, boolean z10) {
                if (z10) {
                    this.f8088e = i11 | this.f8088e;
                } else {
                    this.f8088e = (~i11) & this.f8088e;
                }
                return this;
            }

            public l a() {
                String str = this.f8090g;
                if (str == null && this.f8084a == null) {
                    throw new NullPointerException("Must supply pending intent or shortcut to bubble");
                }
                if (str == null && this.f8085b == null) {
                    throw new NullPointerException("Must supply an icon or shortcut for the bubble");
                }
                l lVar = new l(this.f8084a, this.f8089f, this.f8085b, this.f8086c, this.f8087d, this.f8088e, str);
                lVar.j(this.f8088e);
                return lVar;
            }

            public c b(boolean z10) {
                f(1, z10);
                return this;
            }

            public c c(PendingIntent pendingIntent) {
                this.f8089f = pendingIntent;
                return this;
            }

            public c d(int i11) {
                this.f8086c = Math.max(i11, 0);
                this.f8087d = 0;
                return this;
            }

            public c e(int i11) {
                this.f8087d = i11;
                this.f8086c = 0;
                return this;
            }

            public c g(boolean z10) {
                f(2, z10);
                return this;
            }
        }

        private l(PendingIntent pendingIntent, PendingIntent pendingIntent2, IconCompat iconCompat, int i11, int i12, int i13, String str) {
            this.f8077a = pendingIntent;
            this.f8079c = iconCompat;
            this.f8080d = i11;
            this.f8081e = i12;
            this.f8078b = pendingIntent2;
            this.f8082f = i13;
            this.f8083g = str;
        }

        public static l a(Notification.BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 30) {
                return b.a(bubbleMetadata);
            }
            if (i11 == 29) {
                return a.a(bubbleMetadata);
            }
            return null;
        }

        public static Notification.BubbleMetadata k(l lVar) {
            if (lVar == null) {
                return null;
            }
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 30) {
                return b.b(lVar);
            }
            if (i11 == 29) {
                return a.b(lVar);
            }
            return null;
        }

        public boolean b() {
            return (this.f8082f & 1) != 0;
        }

        public PendingIntent c() {
            return this.f8078b;
        }

        public int d() {
            return this.f8080d;
        }

        public int e() {
            return this.f8081e;
        }

        public IconCompat f() {
            return this.f8079c;
        }

        public PendingIntent g() {
            return this.f8077a;
        }

        public String h() {
            return this.f8083g;
        }

        public boolean i() {
            return (this.f8082f & 2) != 0;
        }

        public void j(int i11) {
            this.f8082f = i11;
        }
    }

    /* loaded from: classes.dex */
    public static class m {
        boolean A;
        boolean B;
        boolean C;
        String D;
        Bundle E;
        int F;
        int G;
        Notification H;
        RemoteViews I;
        RemoteViews J;
        RemoteViews K;
        String L;
        int M;
        String N;
        androidx.core.content.c O;
        long P;
        int Q;
        int R;
        boolean S;
        l T;
        Notification U;
        boolean V;
        Object W;
        public ArrayList X;

        /* renamed from: a, reason: collision with root package name */
        public Context f8091a;

        /* renamed from: b, reason: collision with root package name */
        public ArrayList f8092b;

        /* renamed from: c, reason: collision with root package name */
        public ArrayList f8093c;

        /* renamed from: d, reason: collision with root package name */
        ArrayList f8094d;

        /* renamed from: e, reason: collision with root package name */
        CharSequence f8095e;

        /* renamed from: f, reason: collision with root package name */
        CharSequence f8096f;

        /* renamed from: g, reason: collision with root package name */
        PendingIntent f8097g;

        /* renamed from: h, reason: collision with root package name */
        PendingIntent f8098h;

        /* renamed from: i, reason: collision with root package name */
        RemoteViews f8099i;

        /* renamed from: j, reason: collision with root package name */
        IconCompat f8100j;

        /* renamed from: k, reason: collision with root package name */
        CharSequence f8101k;

        /* renamed from: l, reason: collision with root package name */
        int f8102l;

        /* renamed from: m, reason: collision with root package name */
        int f8103m;

        /* renamed from: n, reason: collision with root package name */
        boolean f8104n;

        /* renamed from: o, reason: collision with root package name */
        boolean f8105o;

        /* renamed from: p, reason: collision with root package name */
        boolean f8106p;

        /* renamed from: q, reason: collision with root package name */
        p f8107q;

        /* renamed from: r, reason: collision with root package name */
        CharSequence f8108r;

        /* renamed from: s, reason: collision with root package name */
        CharSequence f8109s;

        /* renamed from: t, reason: collision with root package name */
        CharSequence[] f8110t;

        /* renamed from: u, reason: collision with root package name */
        int f8111u;

        /* renamed from: v, reason: collision with root package name */
        int f8112v;

        /* renamed from: w, reason: collision with root package name */
        boolean f8113w;

        /* renamed from: x, reason: collision with root package name */
        String f8114x;

        /* renamed from: y, reason: collision with root package name */
        boolean f8115y;

        /* renamed from: z, reason: collision with root package name */
        String f8116z;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a {
            static AudioAttributes a(AudioAttributes.Builder builder) {
                return builder.build();
            }

            static AudioAttributes.Builder b() {
                return new AudioAttributes.Builder();
            }

            static AudioAttributes.Builder c(AudioAttributes.Builder builder, int i11) {
                return builder.setContentType(i11);
            }

            static AudioAttributes.Builder d(AudioAttributes.Builder builder, int i11) {
                return builder.setUsage(i11);
            }
        }

        public m(Context context) {
            this(context, null);
        }

        public m(Context context, String str) {
            this.f8092b = new ArrayList();
            this.f8093c = new ArrayList();
            this.f8094d = new ArrayList();
            this.f8104n = true;
            this.A = false;
            this.F = 0;
            this.G = 0;
            this.M = 0;
            this.Q = 0;
            this.R = 0;
            Notification notification = new Notification();
            this.U = notification;
            this.f8091a = context;
            this.L = str;
            notification.when = System.currentTimeMillis();
            this.U.audioStreamType = -1;
            this.f8103m = 0;
            this.X = new ArrayList();
            this.S = true;
        }

        protected static CharSequence k(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        private void v(int i11, boolean z10) {
            if (z10) {
                Notification notification = this.U;
                notification.flags = i11 | notification.flags;
            } else {
                Notification notification2 = this.U;
                notification2.flags = (~i11) & notification2.flags;
            }
        }

        public m A(Bitmap bitmap) {
            this.f8100j = bitmap == null ? null : IconCompat.g(NotificationCompat.reduceLargeIconSize(this.f8091a, bitmap));
            return this;
        }

        public m B(int i11, int i12, int i13) {
            Notification notification = this.U;
            notification.ledARGB = i11;
            notification.ledOnMS = i12;
            notification.ledOffMS = i13;
            notification.flags = ((i12 == 0 || i13 == 0) ? 0 : 1) | (notification.flags & (-2));
            return this;
        }

        public m C(boolean z10) {
            this.A = z10;
            return this;
        }

        public m D(int i11) {
            this.f8102l = i11;
            return this;
        }

        public m E(boolean z10) {
            v(2, z10);
            return this;
        }

        public m F(boolean z10) {
            v(8, z10);
            return this;
        }

        public m G(int i11) {
            this.f8103m = i11;
            return this;
        }

        public m H(int i11, int i12, boolean z10) {
            this.f8111u = i11;
            this.f8112v = i12;
            this.f8113w = z10;
            return this;
        }

        public m I(boolean z10) {
            this.f8104n = z10;
            return this;
        }

        public m J(int i11) {
            this.U.icon = i11;
            return this;
        }

        public m K(Uri uri) {
            Notification notification = this.U;
            notification.sound = uri;
            notification.audioStreamType = -1;
            AudioAttributes.Builder d11 = a.d(a.c(a.b(), 4), 5);
            this.U.audioAttributes = a.a(d11);
            return this;
        }

        public m L(p pVar) {
            if (this.f8107q != pVar) {
                this.f8107q = pVar;
                if (pVar != null) {
                    pVar.p(this);
                }
            }
            return this;
        }

        public m M(CharSequence charSequence) {
            this.U.tickerText = k(charSequence);
            return this;
        }

        public m N(long[] jArr) {
            this.U.vibrate = jArr;
            return this;
        }

        public m O(int i11) {
            this.G = i11;
            return this;
        }

        public m P(long j11) {
            this.U.when = j11;
            return this;
        }

        public m a(int i11, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f8092b.add(new b(i11, charSequence, pendingIntent));
            return this;
        }

        public m b(b bVar) {
            if (bVar != null) {
                this.f8092b.add(bVar);
            }
            return this;
        }

        public Notification c() {
            return new r(this).c();
        }

        public RemoteViews d() {
            return this.J;
        }

        public int e() {
            return this.F;
        }

        public RemoteViews f() {
            return this.I;
        }

        public Bundle g() {
            if (this.E == null) {
                this.E = new Bundle();
            }
            return this.E;
        }

        public RemoteViews h() {
            return this.K;
        }

        public int i() {
            return this.f8103m;
        }

        public long j() {
            if (this.f8104n) {
                return this.U.when;
            }
            return 0L;
        }

        public m l(boolean z10) {
            v(16, z10);
            return this;
        }

        public m m(String str) {
            this.L = str;
            return this;
        }

        public m n(int i11) {
            this.F = i11;
            return this;
        }

        public m o(PendingIntent pendingIntent) {
            this.f8097g = pendingIntent;
            return this;
        }

        public m p(CharSequence charSequence) {
            this.f8096f = k(charSequence);
            return this;
        }

        public m q(CharSequence charSequence) {
            this.f8095e = k(charSequence);
            return this;
        }

        public m r(RemoteViews remoteViews) {
            this.J = remoteViews;
            return this;
        }

        public m s(RemoteViews remoteViews) {
            this.I = remoteViews;
            return this;
        }

        public m t(int i11) {
            Notification notification = this.U;
            notification.defaults = i11;
            if ((i11 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        public m u(PendingIntent pendingIntent) {
            this.U.deleteIntent = pendingIntent;
            return this;
        }

        public m w(int i11) {
            this.R = i11;
            return this;
        }

        public m x(PendingIntent pendingIntent, boolean z10) {
            this.f8098h = pendingIntent;
            v(128, z10);
            return this;
        }

        public m y(String str) {
            this.f8114x = str;
            return this;
        }

        public m z(boolean z10) {
            this.f8115y = z10;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static class n extends p {

        /* renamed from: e, reason: collision with root package name */
        private int f8117e;

        /* renamed from: f, reason: collision with root package name */
        private w f8118f;

        /* renamed from: g, reason: collision with root package name */
        private PendingIntent f8119g;

        /* renamed from: h, reason: collision with root package name */
        private PendingIntent f8120h;

        /* renamed from: i, reason: collision with root package name */
        private PendingIntent f8121i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f8122j;

        /* renamed from: k, reason: collision with root package name */
        private Integer f8123k;

        /* renamed from: l, reason: collision with root package name */
        private Integer f8124l;

        /* renamed from: m, reason: collision with root package name */
        private IconCompat f8125m;

        /* renamed from: n, reason: collision with root package name */
        private CharSequence f8126n;

        /* loaded from: classes.dex */
        static class a {
            static Notification.Builder a(Notification.Builder builder, String str) {
                return builder.addPerson(str);
            }

            static Notification.Builder b(Notification.Builder builder, String str) {
                return builder.setCategory(str);
            }
        }

        /* loaded from: classes.dex */
        static class b {
            static Parcelable a(Icon icon) {
                return icon;
            }

            static void b(Notification.Builder builder, Icon icon) {
                builder.setLargeIcon(icon);
            }
        }

        /* loaded from: classes.dex */
        static class c {
            static Notification.Builder a(Notification.Builder builder, Person person) {
                return builder.addPerson(person);
            }

            static Parcelable b(Person person) {
                return person;
            }
        }

        /* loaded from: classes.dex */
        static class d {
            static Notification.CallStyle a(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
            }

            static Notification.CallStyle b(Person person, PendingIntent pendingIntent) {
                return Notification.CallStyle.forOngoingCall(person, pendingIntent);
            }

            static Notification.CallStyle c(Person person, PendingIntent pendingIntent, PendingIntent pendingIntent2) {
                return Notification.CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
            }

            static Notification.CallStyle d(Notification.CallStyle callStyle, int i11) {
                return callStyle.setAnswerButtonColorHint(i11);
            }

            static Notification.CallStyle e(Notification.CallStyle callStyle, int i11) {
                return callStyle.setDeclineButtonColorHint(i11);
            }

            static Notification.CallStyle f(Notification.CallStyle callStyle, boolean z10) {
                return callStyle.setIsVideo(z10);
            }

            static Notification.CallStyle g(Notification.CallStyle callStyle, Icon icon) {
                return callStyle.setVerificationIcon(icon);
            }

            static Notification.CallStyle h(Notification.CallStyle callStyle, CharSequence charSequence) {
                return callStyle.setVerificationText(charSequence);
            }
        }

        private String r() {
            int i11 = this.f8117e;
            if (i11 == 1) {
                return this.f8127a.f8091a.getResources().getString(R$string.call_notification_incoming_text);
            }
            if (i11 == 2) {
                return this.f8127a.f8091a.getResources().getString(R$string.call_notification_ongoing_text);
            }
            if (i11 != 3) {
                return null;
            }
            return this.f8127a.f8091a.getResources().getString(R$string.call_notification_screening_text);
        }

        private boolean s(b bVar) {
            return bVar != null && bVar.c().getBoolean("key_action_priority");
        }

        private b t(int i11, int i12, Integer num, int i13, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(androidx.core.content.b.getColor(this.f8127a.f8091a, i13));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.f8127a.f8091a.getResources().getString(i12));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            b a11 = new b.a(IconCompat.j(this.f8127a.f8091a, i11), spannableStringBuilder, pendingIntent).a();
            a11.c().putBoolean("key_action_priority", true);
            return a11;
        }

        private b u() {
            int i11 = R$drawable.ic_call_answer_video;
            int i12 = R$drawable.ic_call_answer;
            PendingIntent pendingIntent = this.f8119g;
            if (pendingIntent == null) {
                return null;
            }
            boolean z10 = this.f8122j;
            return t(z10 ? i11 : i12, z10 ? R$string.call_notification_answer_video_action : R$string.call_notification_answer_action, this.f8123k, R$color.call_notification_answer_color, pendingIntent);
        }

        private b v() {
            int i11 = R$drawable.ic_call_decline;
            PendingIntent pendingIntent = this.f8120h;
            return pendingIntent == null ? t(i11, R$string.call_notification_hang_up_action, this.f8124l, R$color.call_notification_decline_color, this.f8121i) : t(i11, R$string.call_notification_decline_action, this.f8124l, R$color.call_notification_decline_color, pendingIntent);
        }

        @Override // androidx.core.app.NotificationCompat.p
        public void a(Bundle bundle) {
            super.a(bundle);
            bundle.putInt(NotificationCompat.EXTRA_CALL_TYPE, this.f8117e);
            bundle.putBoolean(NotificationCompat.EXTRA_CALL_IS_VIDEO, this.f8122j);
            w wVar = this.f8118f;
            if (wVar != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    bundle.putParcelable(NotificationCompat.EXTRA_CALL_PERSON, c.b(wVar.i()));
                } else {
                    bundle.putParcelable(NotificationCompat.EXTRA_CALL_PERSON_COMPAT, wVar.j());
                }
            }
            IconCompat iconCompat = this.f8125m;
            if (iconCompat != null) {
                bundle.putParcelable(NotificationCompat.EXTRA_VERIFICATION_ICON, b.a(iconCompat.x(this.f8127a.f8091a)));
            }
            bundle.putCharSequence(NotificationCompat.EXTRA_VERIFICATION_TEXT, this.f8126n);
            bundle.putParcelable(NotificationCompat.EXTRA_ANSWER_INTENT, this.f8119g);
            bundle.putParcelable(NotificationCompat.EXTRA_DECLINE_INTENT, this.f8120h);
            bundle.putParcelable(NotificationCompat.EXTRA_HANG_UP_INTENT, this.f8121i);
            Integer num = this.f8123k;
            if (num != null) {
                bundle.putInt(NotificationCompat.EXTRA_ANSWER_COLOR, num.intValue());
            }
            Integer num2 = this.f8124l;
            if (num2 != null) {
                bundle.putInt(NotificationCompat.EXTRA_DECLINE_COLOR, num2.intValue());
            }
        }

        @Override // androidx.core.app.NotificationCompat.p
        public void b(androidx.core.app.o oVar) {
            int i11 = Build.VERSION.SDK_INT;
            CharSequence charSequence = null;
            r2 = null;
            Notification.CallStyle a11 = null;
            charSequence = null;
            if (i11 < 31) {
                Notification.Builder a12 = oVar.a();
                w wVar = this.f8118f;
                a12.setContentTitle(wVar != null ? wVar.d() : null);
                Bundle bundle = this.f8127a.E;
                if (bundle != null && bundle.containsKey(NotificationCompat.EXTRA_TEXT)) {
                    charSequence = this.f8127a.E.getCharSequence(NotificationCompat.EXTRA_TEXT);
                }
                if (charSequence == null) {
                    charSequence = r();
                }
                a12.setContentText(charSequence);
                w wVar2 = this.f8118f;
                if (wVar2 != null) {
                    if (wVar2.b() != null) {
                        b.b(a12, this.f8118f.b().x(this.f8127a.f8091a));
                    }
                    if (i11 >= 28) {
                        c.a(a12, this.f8118f.i());
                    } else {
                        a.a(a12, this.f8118f.e());
                    }
                }
                a.b(a12, "call");
                return;
            }
            int i12 = this.f8117e;
            if (i12 == 1) {
                a11 = d.a(this.f8118f.i(), this.f8120h, this.f8119g);
            } else if (i12 == 2) {
                a11 = d.b(this.f8118f.i(), this.f8121i);
            } else if (i12 == 3) {
                a11 = d.c(this.f8118f.i(), this.f8121i, this.f8119g);
            } else if (Log.isLoggable(NotificationCompat.TAG, 3)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Unrecognized call type in CallStyle: ");
                sb2.append(String.valueOf(this.f8117e));
            }
            if (a11 != null) {
                a11.setBuilder(oVar.a());
                Integer num = this.f8123k;
                if (num != null) {
                    d.d(a11, num.intValue());
                }
                Integer num2 = this.f8124l;
                if (num2 != null) {
                    d.e(a11, num2.intValue());
                }
                d.h(a11, this.f8126n);
                IconCompat iconCompat = this.f8125m;
                if (iconCompat != null) {
                    d.g(a11, iconCompat.x(this.f8127a.f8091a));
                }
                d.f(a11, this.f8122j);
            }
        }

        @Override // androidx.core.app.NotificationCompat.p
        protected String k() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }

        public ArrayList q() {
            b v11 = v();
            b u11 = u();
            ArrayList arrayList = new ArrayList(3);
            arrayList.add(v11);
            ArrayList<b> arrayList2 = this.f8127a.f8092b;
            int i11 = 2;
            if (arrayList2 != null) {
                for (b bVar : arrayList2) {
                    if (bVar.j()) {
                        arrayList.add(bVar);
                    } else if (!s(bVar) && i11 > 1) {
                        arrayList.add(bVar);
                        i11--;
                    }
                    if (u11 != null && i11 == 1) {
                        arrayList.add(u11);
                        i11--;
                    }
                }
            }
            if (u11 != null && i11 >= 1) {
                arrayList.add(u11);
            }
            return arrayList;
        }
    }

    /* loaded from: classes.dex */
    public static class o extends p {

        /* loaded from: classes.dex */
        static class a {
            static Notification.Style a() {
                return new Notification.DecoratedCustomViewStyle();
            }
        }

        private RemoteViews q(RemoteViews remoteViews, boolean z10) {
            int min;
            int i11 = 0;
            RemoteViews c11 = c(true, R$layout.notification_template_custom_big, false);
            c11.removeAllViews(R$id.actions);
            List s11 = s(this.f8127a.f8092b);
            if (!z10 || s11 == null || (min = Math.min(s11.size(), 3)) <= 0) {
                i11 = 8;
            } else {
                for (int i12 = 0; i12 < min; i12++) {
                    c11.addView(R$id.actions, r((b) s11.get(i12)));
                }
            }
            c11.setViewVisibility(R$id.actions, i11);
            c11.setViewVisibility(R$id.action_divider, i11);
            d(c11, remoteViews);
            return c11;
        }

        private RemoteViews r(b bVar) {
            boolean z10 = bVar.f8059k == null;
            RemoteViews remoteViews = new RemoteViews(this.f8127a.f8091a.getPackageName(), z10 ? R$layout.notification_action_tombstone : R$layout.notification_action);
            IconCompat d11 = bVar.d();
            if (d11 != null) {
                remoteViews.setImageViewBitmap(R$id.action_image, h(d11, R$color.notification_action_color_filter));
            }
            remoteViews.setTextViewText(R$id.action_text, bVar.f8058j);
            if (!z10) {
                remoteViews.setOnClickPendingIntent(R$id.action_container, bVar.f8059k);
            }
            remoteViews.setContentDescription(R$id.action_container, bVar.f8058j);
            return remoteViews;
        }

        private static List s(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (!bVar.j()) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        }

        @Override // androidx.core.app.NotificationCompat.p
        public void b(androidx.core.app.o oVar) {
            if (Build.VERSION.SDK_INT >= 24) {
                oVar.a().setStyle(a.a());
            }
        }

        @Override // androidx.core.app.NotificationCompat.p
        protected String k() {
            return "androidx.core.app.NotificationCompat$DecoratedCustomViewStyle";
        }

        @Override // androidx.core.app.NotificationCompat.p
        public RemoteViews m(androidx.core.app.o oVar) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews d11 = this.f8127a.d();
            if (d11 == null) {
                d11 = this.f8127a.f();
            }
            if (d11 == null) {
                return null;
            }
            return q(d11, true);
        }

        @Override // androidx.core.app.NotificationCompat.p
        public RemoteViews n(androidx.core.app.o oVar) {
            if (Build.VERSION.SDK_INT < 24 && this.f8127a.f() != null) {
                return q(this.f8127a.f(), false);
            }
            return null;
        }

        @Override // androidx.core.app.NotificationCompat.p
        public RemoteViews o(androidx.core.app.o oVar) {
            if (Build.VERSION.SDK_INT >= 24) {
                return null;
            }
            RemoteViews h11 = this.f8127a.h();
            RemoteViews f11 = h11 != null ? h11 : this.f8127a.f();
            if (h11 == null) {
                return null;
            }
            return q(f11, true);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class p {

        /* renamed from: a, reason: collision with root package name */
        protected m f8127a;

        /* renamed from: b, reason: collision with root package name */
        CharSequence f8128b;

        /* renamed from: c, reason: collision with root package name */
        CharSequence f8129c;

        /* renamed from: d, reason: collision with root package name */
        boolean f8130d = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public static class a {
            static void a(RemoteViews remoteViews, int i11, boolean z10) {
                remoteViews.setChronometerCountDown(i11, z10);
            }
        }

        private int e() {
            Resources resources = this.f8127a.f8091a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.notification_top_pad);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.notification_top_pad_large_text);
            float f11 = (f(resources.getConfiguration().fontScale, 1.0f, 1.3f) - 1.0f) / 0.29999995f;
            return Math.round(((1.0f - f11) * dimensionPixelSize) + (f11 * dimensionPixelSize2));
        }

        private static float f(float f11, float f12, float f13) {
            return f11 < f12 ? f12 : f11 > f13 ? f13 : f11;
        }

        private Bitmap g(int i11, int i12, int i13) {
            return i(IconCompat.j(this.f8127a.f8091a, i11), i12, i13);
        }

        private Bitmap i(IconCompat iconCompat, int i11, int i12) {
            Drawable s11 = iconCompat.s(this.f8127a.f8091a);
            int intrinsicWidth = i12 == 0 ? s11.getIntrinsicWidth() : i12;
            if (i12 == 0) {
                i12 = s11.getIntrinsicHeight();
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, i12, Bitmap.Config.ARGB_8888);
            s11.setBounds(0, 0, intrinsicWidth, i12);
            if (i11 != 0) {
                s11.mutate().setColorFilter(new PorterDuffColorFilter(i11, PorterDuff.Mode.SRC_IN));
            }
            s11.draw(new Canvas(createBitmap));
            return createBitmap;
        }

        private Bitmap j(int i11, int i12, int i13, int i14) {
            int i15 = R$drawable.notification_icon_background;
            if (i14 == 0) {
                i14 = 0;
            }
            Bitmap g11 = g(i15, i14, i12);
            Canvas canvas = new Canvas(g11);
            Drawable mutate = this.f8127a.f8091a.getResources().getDrawable(i11).mutate();
            mutate.setFilterBitmap(true);
            int i16 = (i12 - i13) / 2;
            int i17 = i13 + i16;
            mutate.setBounds(i16, i16, i17, i17);
            mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            mutate.draw(canvas);
            return g11;
        }

        private void l(RemoteViews remoteViews) {
            remoteViews.setViewVisibility(R$id.title, 8);
            remoteViews.setViewVisibility(R$id.text2, 8);
            remoteViews.setViewVisibility(R$id.text, 8);
        }

        public void a(Bundle bundle) {
            if (this.f8130d) {
                bundle.putCharSequence(NotificationCompat.EXTRA_SUMMARY_TEXT, this.f8129c);
            }
            CharSequence charSequence = this.f8128b;
            if (charSequence != null) {
                bundle.putCharSequence(NotificationCompat.EXTRA_TITLE_BIG, charSequence);
            }
            String k11 = k();
            if (k11 != null) {
                bundle.putString(NotificationCompat.EXTRA_COMPAT_TEMPLATE, k11);
            }
        }

        public void b(androidx.core.app.o oVar) {
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x010a  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0149  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x019a  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x01a5  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x019c  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0195  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public android.widget.RemoteViews c(boolean r13, int r14, boolean r15) {
            /*
                Method dump skipped, instructions count: 426
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.NotificationCompat.p.c(boolean, int, boolean):android.widget.RemoteViews");
        }

        public void d(RemoteViews remoteViews, RemoteViews remoteViews2) {
            l(remoteViews);
            remoteViews.removeAllViews(R$id.notification_main_column);
            remoteViews.addView(R$id.notification_main_column, remoteViews2.clone());
            remoteViews.setViewVisibility(R$id.notification_main_column, 0);
            remoteViews.setViewPadding(R$id.notification_main_column_container, 0, e(), 0, 0);
        }

        Bitmap h(IconCompat iconCompat, int i11) {
            return i(iconCompat, i11, 0);
        }

        protected String k() {
            return null;
        }

        public RemoteViews m(androidx.core.app.o oVar) {
            return null;
        }

        public RemoteViews n(androidx.core.app.o oVar) {
            return null;
        }

        public RemoteViews o(androidx.core.app.o oVar) {
            return null;
        }

        public void p(m mVar) {
            if (this.f8127a != mVar) {
                this.f8127a = mVar;
                if (mVar != null) {
                    mVar.L(this);
                }
            }
        }
    }

    @Deprecated
    public NotificationCompat() {
    }

    public static b getAction(Notification notification, int i11) {
        return getActionCompatFromAction(notification.actions[i11]);
    }

    static b getActionCompatFromAction(Notification.Action action) {
        y[] yVarArr;
        int i11;
        RemoteInput[] g11 = c.g(action);
        if (g11 == null) {
            yVarArr = null;
        } else {
            y[] yVarArr2 = new y[g11.length];
            for (int i12 = 0; i12 < g11.length; i12++) {
                RemoteInput remoteInput = g11[i12];
                yVarArr2[i12] = new y(c.h(remoteInput), c.f(remoteInput), c.b(remoteInput), c.a(remoteInput), Build.VERSION.SDK_INT >= 29 ? h.c(remoteInput) : 0, c.d(remoteInput), null);
            }
            yVarArr = yVarArr2;
        }
        int i13 = Build.VERSION.SDK_INT;
        boolean z10 = i13 >= 24 ? c.c(action).getBoolean("android.support.allowGeneratedReplies") || e.a(action) : c.c(action).getBoolean("android.support.allowGeneratedReplies");
        boolean z11 = c.c(action).getBoolean("android.support.action.showsUserInterface", true);
        int a11 = i13 >= 28 ? g.a(action) : c.c(action).getInt("android.support.action.semanticAction", 0);
        boolean e11 = i13 >= 29 ? h.e(action) : false;
        boolean a12 = i13 >= 31 ? i.a(action) : false;
        if (d.a(action) != null || (i11 = action.icon) == 0) {
            return new b(d.a(action) != null ? IconCompat.c(d.a(action)) : null, action.title, action.actionIntent, c.c(action), yVarArr, (y[]) null, z10, a11, z11, e11, a12);
        }
        return new b(i11, action.title, action.actionIntent, c.c(action), yVarArr, (y[]) null, z10, a11, z11, e11, a12);
    }

    public static int getActionCount(Notification notification) {
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr.length;
        }
        return 0;
    }

    public static boolean getAllowSystemGeneratedContextualActions(Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return h.a(notification);
        }
        return false;
    }

    public static boolean getAutoCancel(Notification notification) {
        return (notification.flags & 16) != 0;
    }

    public static int getBadgeIconType(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f.a(notification);
        }
        return 0;
    }

    public static l getBubbleMetadata(Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return l.a(h.b(notification));
        }
        return null;
    }

    public static String getCategory(Notification notification) {
        return notification.category;
    }

    public static String getChannelId(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f.b(notification);
        }
        return null;
    }

    public static int getColor(Notification notification) {
        return notification.color;
    }

    public static CharSequence getContentInfo(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_INFO_TEXT);
    }

    public static CharSequence getContentText(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TEXT);
    }

    public static CharSequence getContentTitle(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_TITLE);
    }

    @Deprecated
    public static Bundle getExtras(Notification notification) {
        return notification.extras;
    }

    public static String getGroup(Notification notification) {
        return c.e(notification);
    }

    public static int getGroupAlertBehavior(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f.c(notification);
        }
        return 0;
    }

    static boolean getHighPriority(Notification notification) {
        return (notification.flags & 128) != 0;
    }

    public static List<b> getInvisibleActions(Notification notification) {
        Bundle bundle;
        ArrayList arrayList = new ArrayList();
        Bundle bundle2 = notification.extras.getBundle("android.car.EXTENSIONS");
        if (bundle2 != null && (bundle = bundle2.getBundle("invisible_actions")) != null) {
            for (int i11 = 0; i11 < bundle.size(); i11++) {
                arrayList.add(s.c(bundle.getBundle(Integer.toString(i11))));
            }
        }
        return arrayList;
    }

    public static boolean getLocalOnly(Notification notification) {
        return (notification.flags & 256) != 0;
    }

    public static androidx.core.content.c getLocusId(Notification notification) {
        LocusId d11;
        if (Build.VERSION.SDK_INT < 29 || (d11 = h.d(notification)) == null) {
            return null;
        }
        return androidx.core.content.c.c(d11);
    }

    static Notification[] getNotificationArrayFromBundle(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if ((parcelableArray instanceof Notification[]) || parcelableArray == null) {
            return (Notification[]) parcelableArray;
        }
        Notification[] notificationArr = new Notification[parcelableArray.length];
        for (int i11 = 0; i11 < parcelableArray.length; i11++) {
            notificationArr[i11] = (Notification) parcelableArray[i11];
        }
        bundle.putParcelableArray(str, notificationArr);
        return notificationArr;
    }

    public static boolean getOngoing(Notification notification) {
        return (notification.flags & 2) != 0;
    }

    public static boolean getOnlyAlertOnce(Notification notification) {
        return (notification.flags & 8) != 0;
    }

    public static List<w> getPeople(Notification notification) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 28) {
            ArrayList parcelableArrayList = notification.extras.getParcelableArrayList(EXTRA_PEOPLE_LIST);
            if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    arrayList.add(w.a(androidx.core.app.p.a(it.next())));
                }
            }
        } else {
            String[] stringArray = notification.extras.getStringArray(EXTRA_PEOPLE);
            if (stringArray != null && stringArray.length != 0) {
                for (String str : stringArray) {
                    arrayList.add(new w.b().g(str).a());
                }
            }
        }
        return arrayList;
    }

    public static Notification getPublicVersion(Notification notification) {
        return notification.publicVersion;
    }

    public static CharSequence getSettingsText(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f.d(notification);
        }
        return null;
    }

    public static String getShortcutId(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f.e(notification);
        }
        return null;
    }

    public static boolean getShowWhen(Notification notification) {
        return notification.extras.getBoolean(EXTRA_SHOW_WHEN);
    }

    public static String getSortKey(Notification notification) {
        return c.i(notification);
    }

    public static CharSequence getSubText(Notification notification) {
        return notification.extras.getCharSequence(EXTRA_SUB_TEXT);
    }

    public static long getTimeoutAfter(Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return f.f(notification);
        }
        return 0L;
    }

    public static boolean getUsesChronometer(Notification notification) {
        return notification.extras.getBoolean(EXTRA_SHOW_CHRONOMETER);
    }

    public static int getVisibility(Notification notification) {
        return notification.visibility;
    }

    public static boolean isGroupSummary(Notification notification) {
        return (notification.flags & 512) != 0;
    }

    public static Bitmap reduceLargeIconSize(Context context, Bitmap bitmap) {
        if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
            return bitmap;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_width);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.compat_notification_large_icon_max_height);
        if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
            return bitmap;
        }
        double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
        return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(bitmap.getHeight() * min), true);
    }
}
