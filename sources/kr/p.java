package kr;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import com.cloud.tmc.integration.utils.share.config.ShareConstant;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes7.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public static final p f68511a = new p();

    /* renamed from: b, reason: collision with root package name */
    private static final String f68512b = "https://play.google.com/store/apps/details?id=com.community.oneroom";

    private p() {
    }

    public final void a(Activity activity, String str, Uri uri, Function1 function1) {
        Intrinsics.h(activity, "activity");
        if (str != null) {
            try {
                if (str.length() != 0) {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType(ShareConstant.SHARE_TYPE_IMAGE);
                    intent.putExtra("android.intent.extra.STREAM", uri);
                    intent.setPackage(str);
                    activity.startActivity(intent);
                    if (function1 != null) {
                    }
                }
            } catch (Exception unused) {
                if (function1 != null) {
                    return;
                }
                return;
            }
        }
        if (function1 != null) {
        }
    }

    public final void b(Activity activity, Uri uri, Function1 function1) {
        Intrinsics.h(activity, "activity");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(ShareConstant.SHARE_TYPE_IMAGE);
        intent.putExtra("android.intent.extra.STREAM", uri);
        try {
            try {
                intent.setPackage("org.telegram.messenger");
                activity.startActivity(intent);
                if (function1 != null) {
                }
            } catch (Exception unused) {
                if (function1 != null) {
                }
            }
        } catch (ActivityNotFoundException unused2) {
            intent.setPackage("org.thunderdog.challegram");
            activity.startActivity(intent);
            if (function1 != null) {
            }
        }
    }

    public final void c(Activity activity, String shareContent, Function1 function1) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(shareContent, "shareContent");
        Intent intent = new Intent();
        try {
            try {
                intent.setAction("android.intent.action.SEND");
                intent.putExtra("android.intent.extra.TEXT", shareContent);
                intent.setType(ShareConstant.SHARE_TYPE_TEXT);
                intent.setPackage("org.telegram.messenger");
                activity.startActivity(intent);
                if (function1 != null) {
                }
            } catch (Exception unused) {
                if (function1 != null) {
                }
            }
        } catch (ActivityNotFoundException unused2) {
            intent.setPackage("org.thunderdog.challegram");
            activity.startActivity(intent);
            if (function1 != null) {
            }
        }
    }

    public final void d(Activity activity, String shareContent, Function1 function1) {
        Intrinsics.h(activity, "activity");
        Intrinsics.h(shareContent, "shareContent");
        try {
            Intent intent = new Intent();
            Uri parse = Uri.parse("whatsapp://send?text=" + Uri.encode(shareContent));
            intent.setAction("android.intent.action.VIEW");
            intent.setData(parse);
            activity.startActivity(intent);
            if (function1 != null) {
            }
        } catch (Exception unused) {
            if (function1 != null) {
            }
        }
    }
}
