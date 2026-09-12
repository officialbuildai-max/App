package com.transsion.mpush.core.renderer;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;
import com.blankj.utilcode.util.Utils;
import com.transsion.mpush.R$dimen;
import com.transsion.mpush.R$id;
import com.transsion.mpush.R$layout;
import com.transsion.mpush.api.PermanentPushMessage;
import com.transsion.mpush.core.config.PermanentConfig;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes6.dex */
public final class v extends AbsPermanentNotificationRenderer {

    /* renamed from: i, reason: collision with root package name */
    private final Lazy f47636i = LazyKt.b(new Function0() { // from class: com.transsion.mpush.core.renderer.t
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int Q;
            Q = v.Q();
            return Integer.valueOf(Q);
        }
    });

    /* renamed from: j, reason: collision with root package name */
    private final Lazy f47637j = LazyKt.b(new Function0() { // from class: com.transsion.mpush.core.renderer.u
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int P;
            P = v.P();
            return Integer.valueOf(P);
        }
    });

    /* renamed from: k, reason: collision with root package name */
    private final Integer[] f47638k = {Integer.valueOf(R$id.imageIv1), Integer.valueOf(R$id.imageIv2), Integer.valueOf(R$id.imageIv3), Integer.valueOf(R$id.imageIv4), Integer.valueOf(R$id.imageIv5), Integer.valueOf(R$id.imageIv6), Integer.valueOf(R$id.imageIv7), Integer.valueOf(R$id.imageIv8), Integer.valueOf(R$id.imageIv9), Integer.valueOf(R$id.imageIv10)};

    private final int N() {
        return ((Number) this.f47637j.getValue()).intValue();
    }

    private final int O() {
        return ((Number) this.f47636i.getValue()).intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int P() {
        return (int) Utils.a().getResources().getDimension(R$dimen.push_permanent_image_height);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int Q() {
        return (int) Utils.a().getResources().getDimension(R$dimen.push_permanent_image_width);
    }

    private final Bitmap R(Bitmap bitmap) {
        Bitmap a11;
        try {
            com.transsion.mpush.core.utils.c cVar = com.transsion.mpush.core.utils.c.f47679a;
            Application a12 = Utils.a();
            Intrinsics.g(a12, "getApp(...)");
            a11 = cVar.a(a12, bitmap, O(), N(), ln.a.f69101a.i().getDefaultImgRes(), (r17 & 32) != 0 ? 8 : cVar.c(4.0f), (r17 & 64) != 0 ? false : false);
            return a11;
        } catch (Exception e11) {
            a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "toResizeBitmap: failed " + e11, false, 4, null);
            return null;
        }
    }

    @Override // com.transsion.mpush.core.renderer.AbsPermanentNotificationRenderer
    public Integer A(List messages) {
        Intrinsics.h(messages, "messages");
        return Integer.valueOf(R$layout.push_notification_permanent_big);
    }

    @Override // com.transsion.mpush.core.renderer.AbsPermanentNotificationRenderer
    public void s(Context context, RemoteViews remoteViews, RemoteViews remoteViews2, List list, List bitmaps, PermanentConfig permanentConfig) {
        Bitmap R;
        Bitmap bitmap;
        List messages = list;
        Intrinsics.h(context, "context");
        Intrinsics.h(messages, "messages");
        Intrinsics.h(bitmaps, "bitmaps");
        a.C0856a.r(lg.a.f68962a, "M_PUSH_SDK", new String[]{"【常驻渲染】开始绑定自定义视图，消息数：" + list.size() + "，图片数：" + bitmaps.size()}, false, 4, null);
        String title = permanentConfig != null ? permanentConfig.getTitle() : null;
        String title2 = (title == null || title.length() == 0) ? ((PermanentPushMessage) CollectionsKt.i0(list)).getTitle() : permanentConfig.getTitle();
        if (title2 == null) {
            title2 = "";
        }
        if (remoteViews != null) {
            remoteViews.setTextViewText(R$id.push_notification_title, title2);
        }
        if (remoteViews2 != null) {
            remoteViews2.setTextViewText(R$id.push_notification_title, title2);
        }
        int i11 = 0;
        int i12 = 0;
        for (Object obj : bitmaps) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                CollectionsKt.u();
            }
            Bitmap bitmap2 = (Bitmap) obj;
            PermanentPushMessage permanentPushMessage = (PermanentPushMessage) CollectionsKt.l0(messages, i12);
            if (permanentPushMessage != null && (R = R(bitmap2)) != null) {
                if (i12 >= 3 || remoteViews == null) {
                    bitmap = R;
                } else {
                    int intValue = this.f47638k[i12].intValue();
                    remoteViews.setImageViewBitmap(intValue, R);
                    remoteViews.setViewVisibility(intValue, i11);
                    bitmap = R;
                    remoteViews.setOnClickPendingIntent(intValue, AbsPermanentNotificationRenderer.w(this, context, permanentPushMessage, null, null, 12, null));
                }
                if (remoteViews2 != null) {
                    Integer[] numArr = this.f47638k;
                    if (i12 < numArr.length) {
                        int intValue2 = numArr[i12].intValue();
                        remoteViews2.setImageViewBitmap(intValue2, bitmap);
                        remoteViews2.setViewVisibility(intValue2, 0);
                        remoteViews2.setOnClickPendingIntent(intValue2, i12 == this.f47638k.length + (-1) ? AbsPermanentNotificationRenderer.w(this, context, null, B(), String.valueOf(i12), 2, null) : AbsPermanentNotificationRenderer.w(this, context, permanentPushMessage, null, null, 12, null));
                    }
                }
            }
            messages = list;
            i12 = i13;
            i11 = 0;
        }
        int length = this.f47638k.length;
        for (int size = bitmaps.size(); size < length; size++) {
            if (size < 3 && remoteViews != null) {
                remoteViews.setViewVisibility(this.f47638k[size].intValue(), 8);
            }
            if (remoteViews2 != null) {
                remoteViews2.setViewVisibility(this.f47638k[size].intValue(), 8);
            }
        }
        if (bitmaps.size() <= 5) {
            if (remoteViews2 != null) {
                remoteViews2.setViewVisibility(R$id.content_layout_2, 8);
            }
        } else if (remoteViews2 != null) {
            remoteViews2.setViewVisibility(R$id.content_layout_2, 0);
        }
        a.C0856a.r(lg.a.f68962a, "M_PUSH_SDK", new String[]{"【常驻渲染】视图绑定完成"}, false, 4, null);
    }

    @Override // com.transsion.mpush.core.renderer.AbsPermanentNotificationRenderer
    public Integer z(List messages) {
        Intrinsics.h(messages, "messages");
        return Integer.valueOf(R$layout.push_notification_permanent_small);
    }
}
