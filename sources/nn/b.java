package nn;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.blankj.utilcode.util.y;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.transsion.mpush.R$string;
import com.transsion.mpush.api.IPushImageLoader;
import com.transsion.mpush.core.utils.c;
import ej.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

/* loaded from: classes6.dex */
public final class b implements IPushImageLoader {

    /* renamed from: a, reason: collision with root package name */
    private final Lazy f70607a = LazyKt.b(new Function0() { // from class: nn.a
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            int b11;
            b11 = b.b();
            return Integer.valueOf(b11);
        }
    });

    /* loaded from: classes6.dex */
    public static final class a extends CustomTarget {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IPushImageLoader.Callback f70608a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f70609b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f70610c;

        a(IPushImageLoader.Callback callback, String str, Context context) {
            this.f70608a = callback;
            this.f70609b = str;
            this.f70610c = context;
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onLoadCleared(Drawable drawable) {
        }

        @Override // com.bumptech.glide.request.target.CustomTarget, com.bumptech.glide.request.target.Target
        public void onLoadFailed(Drawable drawable) {
            super.onLoadFailed(drawable);
            a.C0856a.l(lg.a.f68962a, "M_PUSH_SDK", "【图片加载】加载失败，URL：" + this.f70609b, false, 4, null);
            this.f70608a.onFailed(new Exception(this.f70610c.getString(R$string.push_error_load_image_failed, this.f70609b)));
        }

        @Override // com.bumptech.glide.request.target.Target
        public void onResourceReady(Bitmap resource, Transition transition) {
            Intrinsics.h(resource, "resource");
            a.C0856a.r(lg.a.f68962a, "M_PUSH_SDK", new String[]{"【图片加载】加载成功，图片尺寸：" + resource.getWidth() + "x" + resource.getHeight()}, false, 4, null);
            this.f70608a.onSuccess(resource);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b() {
        return y.e() - c.f47679a.c(80.0f);
    }

    private final int c() {
        return ((Number) this.f70607a.getValue()).intValue();
    }

    @Override // com.transsion.mpush.api.IPushImageLoader
    public void loadImage(Context context, String url, Integer num, IPushImageLoader.Callback callback) {
        RequestBuilder load2;
        Intrinsics.h(context, "context");
        Intrinsics.h(url, "url");
        Intrinsics.h(callback, "callback");
        a.C0856a c0856a = lg.a.f68962a;
        a.C0856a.r(c0856a, "M_PUSH_SDK", new String[]{"【图片加载】开始加载，目标宽度：" + num + "，URL：" + url}, false, 4, null);
        if (StringsKt.W(url, "http://", false, 2, null) || StringsKt.W(url, "https://", false, 2, null)) {
            load2 = Glide.with(context).asBitmap().diskCacheStrategy(DiskCacheStrategy.DATA).load2(f.a.e(f.f62005a, url, num != null ? num.intValue() : c(), true, false, 8, null));
        } else {
            Uri parse = Uri.parse("file:///android_asset/" + url);
            a.C0856a.r(c0856a, "M_PUSH_SDK", new String[]{"【图片加载】识别为 asset 路径，转换 URI：" + parse}, false, 4, null);
            load2 = Glide.with(context).asBitmap().diskCacheStrategy(DiskCacheStrategy.NONE).load2(parse);
        }
        Intrinsics.e(load2);
        load2.into((RequestBuilder) new a(callback, url, context));
    }
}
