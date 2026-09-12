package f;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.provider.MediaStore;
import com.cloud.tmc.integration.utils.share.config.ShareConstant;
import f.a;
import f.g;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes2.dex */
public class e extends f.a {

    /* renamed from: b, reason: collision with root package name */
    public static final a f62234b = new a(null);

    /* renamed from: a, reason: collision with root package name */
    private final int f62235a;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            int pickImagesMaxLimit;
            if (!g.f62236a.d()) {
                return Integer.MAX_VALUE;
            }
            pickImagesMaxLimit = MediaStore.getPickImagesMaxLimit();
            return pickImagesMaxLimit;
        }
    }

    public e() {
        this(0, 1, null);
    }

    public e(int i11) {
        this.f62235a = i11;
        if (i11 <= 1) {
            throw new IllegalArgumentException("Max items must be higher than 1");
        }
    }

    public /* synthetic */ e(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? f62234b.a() : i11);
    }

    @Override // f.a
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, androidx.activity.result.e input) {
        int pickImagesMaxLimit;
        Intrinsics.h(context, "context");
        Intrinsics.h(input, "input");
        g.a aVar = g.f62236a;
        if (aVar.d()) {
            Intent intent = new Intent("android.provider.action.PICK_IMAGES");
            intent.setType(aVar.b(input.d()));
            int min = Math.min(this.f62235a, input.c());
            if (min > 1) {
                pickImagesMaxLimit = MediaStore.getPickImagesMaxLimit();
                if (min <= pickImagesMaxLimit) {
                    intent.putExtra("android.provider.extra.PICK_IMAGES_MAX", min);
                    intent.putExtra("android.provider.extra.PICK_IMAGES_LAUNCH_TAB", input.b().a());
                    intent.putExtra("android.provider.extra.PICK_IMAGES_IN_ORDER", input.f());
                    if (!input.e()) {
                        return intent;
                    }
                    intent.putExtra("android.provider.extra.PICK_IMAGES_ACCENT_COLOR", input.a());
                    return intent;
                }
            }
            throw new IllegalArgumentException("Max items must be greater than 1 and lesser than or equal to MediaStore.getPickImagesMaxLimit()");
        }
        if (!aVar.c(context)) {
            Intent intent2 = new Intent("android.intent.action.OPEN_DOCUMENT");
            intent2.setType(aVar.b(input.d()));
            intent2.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            if (intent2.getType() != null) {
                return intent2;
            }
            intent2.setType("*/*");
            intent2.putExtra("android.intent.extra.MIME_TYPES", new String[]{ShareConstant.SHARE_TYPE_IMAGE, ShareConstant.SHARE_TYPE_VIDEO});
            return intent2;
        }
        ResolveInfo a11 = aVar.a(context);
        if (a11 == null) {
            throw new IllegalStateException("Required value was null.");
        }
        ActivityInfo activityInfo = a11.activityInfo;
        Intent intent3 = new Intent("androidx.activity.result.contract.action.PICK_IMAGES");
        intent3.setClassName(activityInfo.applicationInfo.packageName, activityInfo.name);
        intent3.setType(aVar.b(input.d()));
        int min2 = Math.min(this.f62235a, input.c());
        if (min2 <= 1) {
            throw new IllegalArgumentException("Max items must be greater than 1");
        }
        intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_MAX", min2);
        intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_LAUNCH_TAB", input.b().a());
        intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_IN_ORDER", input.f());
        if (input.e()) {
            intent3.putExtra("androidx.activity.result.contract.extra.PICK_IMAGES_ACCENT_COLOR", input.a());
        }
        return intent3;
    }

    @Override // f.a
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public final a.C0777a b(Context context, androidx.activity.result.e input) {
        Intrinsics.h(context, "context");
        Intrinsics.h(input, "input");
        return null;
    }

    @Override // f.a
    /* renamed from: f, reason: merged with bridge method [inline-methods] */
    public final List c(int i11, Intent intent) {
        List a11;
        if (i11 != -1) {
            intent = null;
        }
        return (intent == null || (a11 = c.f62233a.a(intent)) == null) ? CollectionsKt.l() : a11;
    }
}
