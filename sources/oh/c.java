package oh;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import lg.a;

/* loaded from: classes4.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final a f71140a = new a(null);

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: oh.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static final class C0890a extends CustomTarget {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function1 f71141a;

            C0890a(Function1 function1) {
                this.f71141a = function1;
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onLoadCleared(Drawable drawable) {
                this.f71141a.invoke(null);
                a.C0856a.f(lg.a.f68962a, "ImageHelper", "loadAsBitmap onFailure", false, 4, null);
            }

            @Override // com.bumptech.glide.request.target.Target
            public void onResourceReady(Bitmap resource, Transition transition) {
                Intrinsics.h(resource, "resource");
                this.f71141a.invoke(resource);
                a.C0856a.f(lg.a.f68962a, "ImageHelper", "loadAsBitmap onSuccess", false, 4, null);
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bitmap a(ImageView imageView) {
            Intrinsics.h(imageView, "imageView");
            Drawable drawable = imageView.getDrawable();
            if (drawable instanceof BitmapDrawable) {
                Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
                Intrinsics.g(bitmap, "getBitmap(...)");
                return bitmap;
            }
            if (drawable == null) {
                return null;
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
                intrinsicWidth = imageView.getWidth();
                intrinsicHeight = imageView.getHeight();
            }
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
            Intrinsics.g(createBitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
            drawable.draw(canvas);
            return createBitmap;
        }

        public final void b(String url, Function1 callback) {
            Intrinsics.h(url, "url");
            Intrinsics.h(callback, "callback");
            Glide.with(Utils.a()).asBitmap().diskCacheStrategy(DiskCacheStrategy.DATA).load2(url).into((RequestBuilder) new C0890a(callback));
        }
    }
}
