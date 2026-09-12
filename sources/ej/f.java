package ej;

import android.app.Application;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
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
import com.transsion.base.image.R$color;
import com.transsion.base.image.blurhash.BlurHash;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes6.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final a f62005a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    private static int f62006b = y.e() / 3;

    /* renamed from: c, reason: collision with root package name */
    private static int f62007c = y.b() / 2;

    /* renamed from: d, reason: collision with root package name */
    private static int f62008d = y.c();

    /* renamed from: e, reason: collision with root package name */
    private static final BlurHash f62009e;

    /* renamed from: f, reason: collision with root package name */
    private static final DrawableTransitionOptions f62010f;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: ej.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes6.dex */
        public static final class C0768a implements RequestListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f62011a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function3 f62012b;

            C0768a(long j11, Function3 function3) {
                this.f62011a = j11;
                this.f62012b = function3;
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable resource, Object model, Target target, DataSource dataSource, boolean z10) {
                Intrinsics.h(resource, "resource");
                Intrinsics.h(model, "model");
                Intrinsics.h(dataSource, "dataSource");
                long currentTimeMillis = System.currentTimeMillis() - this.f62011a;
                Function3 function3 = this.f62012b;
                if (function3 != null) {
                }
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
                Intrinsics.h(target, "target");
                long currentTimeMillis = System.currentTimeMillis() - this.f62011a;
                Function3 function3 = this.f62012b;
                if (function3 == null) {
                    return false;
                }
                Boolean bool = Boolean.FALSE;
                return false;
            }
        }

        /* loaded from: classes6.dex */
        public static final class b implements RequestListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ long f62013a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function3 f62014b;

            b(long j11, Function3 function3) {
                this.f62013a = j11;
                this.f62014b = function3;
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable resource, Object model, Target target, DataSource dataSource, boolean z10) {
                Intrinsics.h(resource, "resource");
                Intrinsics.h(model, "model");
                Intrinsics.h(dataSource, "dataSource");
                long currentTimeMillis = System.currentTimeMillis() - this.f62013a;
                Function3 function3 = this.f62014b;
                if (function3 != null) {
                }
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
                Intrinsics.h(target, "target");
                long currentTimeMillis = System.currentTimeMillis() - this.f62013a;
                Function3 function3 = this.f62014b;
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
            final /* synthetic */ long f62015a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Function3 f62016b;

            c(long j11, Function3 function3) {
                this.f62015a = j11;
                this.f62016b = function3;
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable resource, Object model, Target target, DataSource dataSource, boolean z10) {
                Intrinsics.h(resource, "resource");
                Intrinsics.h(model, "model");
                Intrinsics.h(dataSource, "dataSource");
                long currentTimeMillis = System.currentTimeMillis() - this.f62015a;
                Function3 function3 = this.f62016b;
                if (function3 != null) {
                }
                return false;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
                Intrinsics.h(target, "target");
                long currentTimeMillis = System.currentTimeMillis() - this.f62015a;
                Function3 function3 = this.f62016b;
                if (function3 == null) {
                    return false;
                }
                Boolean bool = Boolean.FALSE;
                return false;
            }
        }

        /* loaded from: classes6.dex */
        public static final class d implements RequestListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Function1 f62017a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ String f62018b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ int f62019c;

            d(Function1 function1, String str, int i11) {
                this.f62017a = function1;
                this.f62018b = str;
                this.f62019c = i11;
            }

            @Override // com.bumptech.glide.request.RequestListener
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public boolean onResourceReady(Drawable resource, Object model, Target target, DataSource dataSource, boolean z10) {
                Intrinsics.h(resource, "resource");
                Intrinsics.h(model, "model");
                Intrinsics.h(dataSource, "dataSource");
                g.f62037a.h(this.f62018b, this.f62019c);
                Function1 function1 = this.f62017a;
                if (function1 == null) {
                    return true;
                }
                function1.invoke(Boolean.TRUE);
                return true;
            }

            @Override // com.bumptech.glide.request.RequestListener
            public boolean onLoadFailed(GlideException glideException, Object obj, Target target, boolean z10) {
                Intrinsics.h(target, "target");
                Function1 function1 = this.f62017a;
                if (function1 == null) {
                    return true;
                }
                function1.invoke(Boolean.FALSE);
                return true;
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ String e(a aVar, String str, int i11, boolean z10, boolean z11, int i12, Object obj) {
            if ((i12 & 2) != 0) {
                i11 = 0;
            }
            if ((i12 & 4) != 0) {
                z10 = true;
            }
            if ((i12 & 8) != 0) {
                z11 = false;
            }
            return aVar.d(str, i11, z10, z11);
        }

        /* JADX WARN: Removed duplicated region for block: B:36:0x0125  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x015e  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x0164  */
        /* JADX WARN: Removed duplicated region for block: B:43:0x0161  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x0134  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void f(android.content.Context r24, final android.widget.ImageView r25, java.lang.String r26, int r27, int r28, int r29, int r30, boolean r31, java.lang.String r32, boolean r33, boolean r34, boolean r35, boolean r36, com.bumptech.glide.Priority r37, int r38, kotlin.jvm.functions.Function3 r39) {
            /*
                Method dump skipped, instructions count: 436
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: ej.f.a.f(android.content.Context, android.widget.ImageView, java.lang.String, int, int, int, int, boolean, java.lang.String, boolean, boolean, boolean, boolean, com.bumptech.glide.Priority, int, kotlin.jvm.functions.Function3):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit g(ImageView imageView, RequestBuilder it) {
            Intrinsics.h(it, "it");
            it.into(imageView);
            return Unit.f67184a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void h(Context context, ImageView imageView, String str, int i11, int i12, int i13, int i14, boolean z10, String str2, boolean z11, boolean z12, boolean z13, boolean z14, Priority priority, int i15, Function3 function3) {
            if ((context instanceof FragmentActivity) && ((FragmentActivity) context).isDestroyed()) {
                return;
            }
            if (TextUtils.isEmpty(str)) {
                Glide.with(context).load("").transition(f.f62010f).apply((BaseRequestOptions<?>) l(this, i11, i14, z13 ? i13 : -1, z13 ? i12 : -1, null, 16, null)).into(imageView);
                return;
            }
            try {
                f(context, imageView, str, i11, i14, (i12 != f.f62007c || imageView.getLayoutParams().width <= 0) ? i12 : imageView.getLayoutParams().width, i13, z10, str2, z11, z12, z13, z14, priority, i15, function3);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }

        public static /* synthetic */ void j(a aVar, String str, String str2, int i11, Function1 function1, int i12, Object obj) {
            if ((i12 & 8) != 0) {
                function1 = null;
            }
            aVar.i(str, str2, i11, function1);
        }

        private final RequestOptions k(int i11, int i12, int i13, int i14, Priority priority) {
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

        static /* synthetic */ RequestOptions l(a aVar, int i11, int i12, int i13, int i14, Priority priority, int i15, Object obj) {
            if ((i15 & 16) != 0) {
                priority = Priority.NORMAL;
            }
            return aVar.k(i11, i12, i13, i14, priority);
        }

        public final int c() {
            return f.f62006b;
        }

        public final String d(String url, int i11, boolean z10, boolean z11) {
            Intrinsics.h(url, "url");
            return g.e(g.f62037a, url, i11, z10, false, 0, false, z11, 0, 184, null);
        }

        public final void i(String url, String originUrl, int i11, Function1 function1) {
            Intrinsics.h(url, "url");
            Intrinsics.h(originUrl, "originUrl");
            Glide.with(Utils.a()).load(url).diskCacheStrategy(DiskCacheStrategy.DATA).addListener(new d(function1, originUrl, i11)).preload();
        }

        public final b m(Context context) {
            Intrinsics.h(context, "context");
            return new b(context);
        }
    }

    /* loaded from: classes6.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        private final Context f62020a;

        /* renamed from: b, reason: collision with root package name */
        private final int f62021b;

        /* renamed from: c, reason: collision with root package name */
        private final int f62022c;

        /* renamed from: d, reason: collision with root package name */
        private int f62023d;

        /* renamed from: e, reason: collision with root package name */
        private int f62024e;

        /* renamed from: f, reason: collision with root package name */
        private String f62025f;

        /* renamed from: g, reason: collision with root package name */
        private String f62026g;

        /* renamed from: h, reason: collision with root package name */
        private int f62027h;

        /* renamed from: i, reason: collision with root package name */
        private int f62028i;

        /* renamed from: j, reason: collision with root package name */
        private boolean f62029j;

        /* renamed from: k, reason: collision with root package name */
        private boolean f62030k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f62031l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f62032m;

        /* renamed from: n, reason: collision with root package name */
        private boolean f62033n;

        /* renamed from: o, reason: collision with root package name */
        private Priority f62034o;

        /* renamed from: p, reason: collision with root package name */
        private Function3 f62035p;

        /* renamed from: q, reason: collision with root package name */
        private int f62036q;

        public b(Context context) {
            Intrinsics.h(context, "context");
            this.f62020a = context;
            int b11 = y.b() / 2;
            this.f62021b = b11;
            int c11 = y.c();
            this.f62022c = c11;
            this.f62023d = b11;
            this.f62024e = c11;
            this.f62025f = "";
            this.f62026g = "";
            this.f62027h = R$color.image_default;
            this.f62029j = true;
            this.f62030k = true;
            this.f62031l = true;
            this.f62034o = Priority.NORMAL;
        }

        public final b a(int i11) {
            this.f62036q = i11;
            return this;
        }

        public final b b(Function3 function3) {
            this.f62035p = function3;
            return this;
        }

        public final b c(int i11) {
            this.f62024e = i11;
            this.f62033n = true;
            return this;
        }

        public final void d(ImageView imageView) {
            Intrinsics.h(imageView, "imageView");
            f.f62005a.h(this.f62020a, imageView, this.f62025f, this.f62027h, this.f62023d, this.f62024e, this.f62028i, this.f62029j, this.f62026g, this.f62030k, this.f62031l, this.f62032m, this.f62033n, this.f62034o, this.f62036q, this.f62035p);
        }

        public final b e(boolean z10) {
            this.f62030k = z10;
            return this;
        }

        public final b f(boolean z10) {
            this.f62029j = z10;
            return this;
        }

        public final b g(String str) {
            if (str == null) {
                str = "";
            }
            this.f62025f = str;
            return this;
        }

        public final b h(boolean z10) {
            this.f62032m = z10;
            return this;
        }

        public final b i(int i11) {
            this.f62027h = i11;
            return this;
        }

        public final b j(int i11) {
            this.f62028i = i11;
            return this;
        }

        public final b k(boolean z10) {
            this.f62031l = z10;
            return this;
        }

        public final b l(String thumbnail) {
            Intrinsics.h(thumbnail, "thumbnail");
            this.f62026g = thumbnail;
            return this;
        }

        public final b m(int i11) {
            this.f62023d = i11;
            return this;
        }
    }

    static {
        Application a11 = Utils.a();
        Intrinsics.g(a11, "getApp(...)");
        f62009e = new BlurHash(a11, 5, 0.6f);
        DrawableTransitionOptions with = DrawableTransitionOptions.with(new DrawableCrossFadeFactory.Builder(100).setCrossFadeEnabled(true).build());
        Intrinsics.g(with, "with(...)");
        f62010f = with;
    }
}
