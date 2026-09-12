package as;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.y;
import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.transsion.shorttv.R$color;
import com.transsion.shorttv.base.image.blurhash.BlurHash;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final a f16186a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static int f16187b = y.e() / 3;

    /* renamed from: c, reason: collision with root package name */
    private static int f16188c = y.b() / 2;

    /* renamed from: d, reason: collision with root package name */
    private static int f16189d = y.c();

    /* renamed from: e, reason: collision with root package name */
    private static final BlurHash f16190e;

    /* renamed from: f, reason: collision with root package name */
    private static final DrawableTransitionOptions f16191f;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: as.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0146a implements RequestListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f16192a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function3 f16193b;

            C0146a(long j11, Function3 function3) {
                this.f16192a = j11;
                this.f16193b = function3;
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable resource, Object model, Target target, DataSource dataSource, boolean z10) {
                Intrinsics.h(resource, "resource");
                Intrinsics.h(model, "model");
                Intrinsics.h(dataSource, "dataSource");
                long currentTimeMillis = System.currentTimeMillis() - this.f16192a;
                Function3 function3 = this.f16193b;
                if (function3 != null) {
                }
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
                Intrinsics.h(target, "target");
                long currentTimeMillis = System.currentTimeMillis() - this.f16192a;
                Function3 function3 = this.f16193b;
                if (function3 == null) {
                    return false;
                }
                Boolean bool = Boolean.FALSE;
                return false;
            }
        }

        /* renamed from: as.b$a$b, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0147b implements RequestListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f16194a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function3 f16195b;

            C0147b(long j11, Function3 function3) {
                this.f16194a = j11;
                this.f16195b = function3;
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable resource, Object model, Target target, DataSource dataSource, boolean z10) {
                Intrinsics.h(resource, "resource");
                Intrinsics.h(model, "model");
                Intrinsics.h(dataSource, "dataSource");
                long currentTimeMillis = System.currentTimeMillis() - this.f16194a;
                Function3 function3 = this.f16195b;
                if (function3 != null) {
                }
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
                Intrinsics.h(target, "target");
                long currentTimeMillis = System.currentTimeMillis() - this.f16194a;
                Function3 function3 = this.f16195b;
                if (function3 == null) {
                    return false;
                }
                Boolean bool = Boolean.FALSE;
                return false;
            }
        }

        /* loaded from: classes6.dex */
        public static final class c implements RequestListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f16196a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function3 f16197b;

            c(long j11, Function3 function3) {
                this.f16196a = j11;
                this.f16197b = function3;
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable resource, Object model, Target target, DataSource dataSource, boolean z10) {
                Intrinsics.h(resource, "resource");
                Intrinsics.h(model, "model");
                Intrinsics.h(dataSource, "dataSource");
                long currentTimeMillis = System.currentTimeMillis() - this.f16196a;
                Function3 function3 = this.f16197b;
                if (function3 != null) {
                }
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
                Intrinsics.h(target, "target");
                long currentTimeMillis = System.currentTimeMillis() - this.f16196a;
                Function3 function3 = this.f16197b;
                if (function3 == null) {
                    return false;
                }
                Boolean bool = Boolean.FALSE;
                return false;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x012d  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0166  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x016c  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0169  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x013c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void f(android.content.Context r18, final android.widget.ImageView r19, java.lang.String r20, int r21, int r22, int r23, int r24, boolean r25, java.lang.String r26, boolean r27, boolean r28, boolean r29, boolean r30, boolean r31, int r32, com.bumptech.glide.Priority r33, kotlin.jvm.functions.Function3 r34) {
            /*
                Method dump skipped, instructions count: 444
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: as.b.a.f(android.content.Context, android.widget.ImageView, java.lang.String, int, int, int, int, boolean, java.lang.String, boolean, boolean, boolean, boolean, boolean, int, com.bumptech.glide.Priority, kotlin.jvm.functions.Function3):void");
        }

        static /* synthetic */ void g(a aVar, Context context, ImageView imageView, String str, int i11, int i12, int i13, int i14, boolean z10, String str2, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, int i15, Priority priority, Function3 function3, int i16, Object obj) {
            aVar.f(context, imageView, str, (i16 & 8) != 0 ? R$color.image_skeleton : i11, (i16 & 16) != 0 ? 0 : i12, (i16 & 32) != 0 ? -1 : i13, (i16 & 64) != 0 ? -1 : i14, (i16 & 128) != 0 ? true : z10, (i16 & 256) != 0 ? "" : str2, (i16 & 512) != 0 ? true : z11, (i16 & 1024) != 0 ? true : z12, (i16 & 2048) != 0 ? false : z13, (i16 & 4096) != 0 ? false : z14, (i16 & 8192) != 0 ? false : z15, (i16 & 16384) != 0 ? 25 : i15, (32768 & i16) != 0 ? Priority.NORMAL : priority, (i16 & 65536) != 0 ? null : function3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit h(ImageView imageView, RequestBuilder it) {
            Intrinsics.h(it, "it");
            try {
                Intrinsics.e(it.into(imageView));
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            return Unit.f67184a;
        }

        private final RequestOptions o(int i11, int i12, int i13, int i14, Priority priority) {
            RequestOptions diskCacheStrategy = new RequestOptions().priority(priority).diskCacheStrategy(DiskCacheStrategy.DATA);
            Intrinsics.g(diskCacheStrategy, "diskCacheStrategy(...)");
            RequestOptions requestOptions = diskCacheStrategy;
            if (i11 != 0) {
                RequestOptions placeholder = requestOptions.placeholder(i11);
                Intrinsics.g(placeholder, "placeholder(...)");
                requestOptions = placeholder;
            }
            if (i12 > 0) {
                RequestOptions transform = requestOptions.transform(new MultiTransformation(new CenterCrop(), new RoundedCorners(i12)));
                Intrinsics.g(transform, "transform(...)");
                requestOptions = transform;
            } else if (i12 < 0) {
                requestOptions = RequestOptions.circleCropTransform();
                Intrinsics.g(requestOptions, "circleCropTransform(...)");
            }
            if (i13 == -1 && i14 == -1) {
                return requestOptions;
            }
            RequestOptions override = requestOptions.override(i14, i13);
            Intrinsics.g(override, "override(...)");
            return override;
        }

        static /* synthetic */ RequestOptions p(a aVar, int i11, int i12, int i13, int i14, Priority priority, int i15, Object obj) {
            if ((i15 & 16) != 0) {
                priority = Priority.NORMAL;
            }
            return aVar.o(i11, i12, i13, i14, priority);
        }

        public final int b() {
            return b.f16189d;
        }

        public final int c() {
            return b.f16188c;
        }

        public final String d(String url, int i11, int i12, boolean z10, boolean z11, boolean z12, int i13) {
            String d11;
            Intrinsics.h(url, "url");
            d11 = as.c.f16198a.d(url, i11, (r23 & 4) != 0 ? true : z10, (r23 & 8) != 0, (r23 & 16) != 0 ? 0 : 0, (r23 & 32) != 0 ? false : false, (r23 & 64) != 0 ? false : z11, (r23 & 128) != 0 ? false : z12, (r23 & 256) != 0 ? 25 : i13);
            return d11;
        }

        public final void i(Context context, ImageView imageView, String url, int i11, int i12, int i13, int i14, boolean z10, String thumbnail, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, int i15) {
            Intrinsics.h(context, "context");
            Intrinsics.h(imageView, "imageView");
            Intrinsics.h(url, "url");
            Intrinsics.h(thumbnail, "thumbnail");
            if ((context instanceof FragmentActivity) && ((FragmentActivity) context).isDestroyed()) {
                return;
            }
            if (url.length() == 0) {
                Glide.with(context).load2("").transition(b.f16191f).apply((BaseRequestOptions<?>) p(this, i11, i14, z13 ? i13 : -1, z13 ? i12 : -1, null, 16, null)).into(imageView);
                return;
            }
            try {
                g(this, context, imageView, url, i11, i14, (i12 != c() || imageView.getLayoutParams().width <= 0) ? i12 : imageView.getLayoutParams().width, i13, z10, thumbnail, z11, z12, z13, z14, z15, i15, null, null, 98304, null);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public final void j(Context context, ImageView imageView, String url, int i11, int i12, boolean z10, String thumbnail, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, int i13) {
            Intrinsics.h(context, "context");
            Intrinsics.h(imageView, "imageView");
            Intrinsics.h(url, "url");
            Intrinsics.h(thumbnail, "thumbnail");
            i(context, imageView, url, R$color.image_skeleton, i11, i12, 0, z10, thumbnail, z11, z12, z13, z14, z15, i13);
        }

        public final void k(Context context, ImageView imageView, String url, int i11, int i12, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, int i13) {
            Intrinsics.h(context, "context");
            Intrinsics.h(imageView, "imageView");
            Intrinsics.h(url, "url");
            i(context, imageView, url, R$color.image_skeleton, i11, i12, 0, z10, "", z11, z12, z13, z14, z15, i13);
        }
    }

    static {
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        f16190e = new BlurHash(a11, 5, 0.6f);
        DrawableTransitionOptions with = DrawableTransitionOptions.with(new DrawableCrossFadeFactory.Builder(100).setCrossFadeEnabled(true).build());
        Intrinsics.g(with, "with(...)");
        f16191f = with;
    }
}
