package com.cloud.hisavana.sdk.common.http;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.ImageView;
import com.cloud.hisavana.net.HttpRequest;
import com.cloud.hisavana.net.RequestParams;
import com.cloud.hisavana.net.disklrucache.utils.DiskLruCacheUtil;
import com.cloud.hisavana.net.impl.HttpCallbackImpl;
import com.cloud.hisavana.sdk.N0;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.DownLoadRequest;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener;
import com.cloud.hisavana.sdk.common.util.m;
import com.cloud.hisavana.sdk.data.bean.response.AdsDTO;
import com.cloud.hisavana.sdk.e4;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.vungle.ads.internal.model.AdPayload;
import java.io.File;
import okhttp3.Headers;

/* loaded from: classes3.dex */
public class DownLoadRequest extends d {

    /* renamed from: q, reason: collision with root package name */
    public static boolean f22126q;

    /* renamed from: h, reason: collision with root package name */
    private int f22132h;

    /* renamed from: p, reason: collision with root package name */
    private String f22140p;

    /* renamed from: c, reason: collision with root package name */
    long f22127c = 0;

    /* renamed from: d, reason: collision with root package name */
    String f22128d = "";

    /* renamed from: e, reason: collision with root package name */
    long f22129e = 0;

    /* renamed from: f, reason: collision with root package name */
    int f22130f = 0;

    /* renamed from: g, reason: collision with root package name */
    int f22131g = 1;

    /* renamed from: i, reason: collision with root package name */
    private int f22133i = 1;

    /* renamed from: j, reason: collision with root package name */
    private boolean f22134j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f22135k = false;

    /* renamed from: l, reason: collision with root package name */
    private String f22136l = "";

    /* renamed from: m, reason: collision with root package name */
    private int f22137m = 1;

    /* renamed from: n, reason: collision with root package name */
    private int f22138n = 1;

    /* renamed from: o, reason: collision with root package name */
    private boolean f22139o = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cloud.hisavana.sdk.common.http.DownLoadRequest$3, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass3 implements Runnable {
        final /* synthetic */ String val$filePath;
        final /* synthetic */ ImageView val$imageView;
        final /* synthetic */ DrawableResponseListener val$listener;

        AnonymousClass3(String str, DrawableResponseListener drawableResponseListener, ImageView imageView) {
            this.val$filePath = str;
            this.val$listener = drawableResponseListener;
            this.val$imageView = imageView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$0(DrawableResponseListener drawableResponseListener) {
            drawableResponseListener.a(TaErrorCode.ERROR_BITMAP_TOO_LARGE);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void lambda$run$1(ImageView imageView, Drawable drawable, DrawableResponseListener drawableResponseListener) {
            imageView.setImageDrawable(drawable);
            if (drawableResponseListener != null) {
                drawableResponseListener.g(200, null);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (N0.w(com.cloud.sdk.commonutil.util.e.a(), this.val$filePath)) {
                    final DrawableResponseListener drawableResponseListener = this.val$listener;
                    if (drawableResponseListener != null) {
                        Preconditions.d(new Preconditions.a() { // from class: com.cloud.hisavana.sdk.common.http.b
                            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
                            public final void onRun() {
                                DownLoadRequest.AnonymousClass3.lambda$run$0(DrawableResponseListener.this);
                            }
                        });
                        return;
                    }
                    return;
                }
                final Drawable b11 = l7.c.b(m.c(new File(this.val$filePath)));
                final ImageView imageView = this.val$imageView;
                final DrawableResponseListener drawableResponseListener2 = this.val$listener;
                Preconditions.d(new Preconditions.a() { // from class: com.cloud.hisavana.sdk.common.http.c
                    @Override // com.cloud.sdk.commonutil.util.Preconditions.a
                    public final void onRun() {
                        DownLoadRequest.AnonymousClass3.lambda$run$1(imageView, b11, drawableResponseListener2);
                    }
                });
            } catch (Throwable th2) {
                e4.b().e(Log.getStackTraceString(th2));
                DrawableResponseListener drawableResponseListener3 = this.val$listener;
                if (drawableResponseListener3 != null) {
                    drawableResponseListener3.a(TaErrorCode.ERROR_BITMAP_TAKE_FAILED);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class a extends DrawableResponseListener {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ DrawableResponseListener f22146b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ImageView f22147c;

        a(DrawableResponseListener drawableResponseListener, ImageView imageView) {
            this.f22146b = drawableResponseListener;
            this.f22147c = imageView;
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener
        public void a(TaErrorCode taErrorCode) {
            e4.b().e("DownLoadRequest", "loadImageView " + taErrorCode);
            DrawableResponseListener drawableResponseListener = this.f22146b;
            if (drawableResponseListener != null) {
                drawableResponseListener.a(taErrorCode);
            }
        }

        @Override // com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener
        public void g(int i11, AdImage adImage) {
            if (adImage == null) {
                DrawableResponseListener drawableResponseListener = this.f22146b;
                if (drawableResponseListener != null) {
                    drawableResponseListener.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TAKE_FAILED, "mediaBean == null."));
                    return;
                }
                return;
            }
            adImage.attachView(this.f22147c);
            DrawableResponseListener drawableResponseListener2 = this.f22146b;
            if (drawableResponseListener2 != null) {
                drawableResponseListener2.g(i11, adImage);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public class b extends HttpCallbackImpl {
        b() {
        }

        @Override // com.cloud.hisavana.net.impl.HttpCallbackImpl
        public void i(int i11, byte[] bArr, Throwable th2) {
            e4.b().d("ssp", "DownLoadRequest --> onFailure statusCode " + i11 + " e" + th2 + " url " + DownLoadRequest.this.f22136l);
            DownLoadRequest.this.f22133i = i11 == 256 ? 2 : 1;
            ResponseBaseListener responseBaseListener = DownLoadRequest.this.f22167b;
            if (responseBaseListener != null) {
                ((DrawableResponseListener) responseBaseListener).d(i11, bArr, th2);
            }
            DownLoadRequest.this.f22130f = i11;
        }

        @Override // com.cloud.hisavana.net.impl.HttpCallbackImpl
        public void l(Headers headers) {
            String value;
            super.l(headers);
            if (headers == null || headers.size() <= 0) {
                return;
            }
            for (int i11 = 0; i11 < headers.size(); i11++) {
                if (headers.name(i11) != null && headers.name(i11).contains("x-response-cdn") && (value = headers.value(i11)) != null && !value.isEmpty()) {
                    DownLoadRequest.this.f22128d = value;
                }
            }
        }

        @Override // com.cloud.hisavana.net.impl.HttpCallbackImpl
        public void n(int i11, byte[] bArr) {
            e4.b().d("DownLoadRequest", "DownLoadRequest --> onSuccess statusCode " + i11 + " url " + DownLoadRequest.this.f22136l);
            DownLoadRequest.this.f22133i = i11 == 250 ? 2 : 1;
            DownLoadRequest downLoadRequest = DownLoadRequest.this;
            ResponseBaseListener responseBaseListener = downLoadRequest.f22167b;
            if (responseBaseListener != null && (responseBaseListener instanceof DrawableResponseListener)) {
                ((DrawableResponseListener) responseBaseListener).h(downLoadRequest.f22137m, i11, bArr, null);
            }
            if (bArr != null) {
                DownLoadRequest.this.f22127c = bArr.length;
            }
            if (DownLoadRequest.this.f22132h == 3) {
                DownLoadRequest.f22126q = true;
            }
        }

        @Override // com.cloud.hisavana.net.impl.HttpCallbackImpl
        public void o(int i11, byte[] bArr, String str) {
            e4.b().d("ssp", "DownLoadRequest --> onSuccess statusCode " + i11 + " filePath " + str + " url" + DownLoadRequest.this.f22136l);
            DownLoadRequest.this.f22133i = i11 == 250 ? 2 : 1;
            DownLoadRequest downLoadRequest = DownLoadRequest.this;
            ResponseBaseListener responseBaseListener = downLoadRequest.f22167b;
            if (responseBaseListener != null && (responseBaseListener instanceof DrawableResponseListener)) {
                ((DrawableResponseListener) responseBaseListener).h(downLoadRequest.f22137m, i11, bArr, str);
            }
            if (bArr != null) {
                DownLoadRequest.this.f22127c = bArr.length;
            }
            if (DownLoadRequest.this.f22132h == 3) {
                DownLoadRequest.f22126q = true;
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(boolean z10);

        void onSuccess();
    }

    private DownLoadRequest() {
    }

    public static void j(String str, int i11, boolean z10, int i12, boolean z11, int i13, boolean z12, AdsDTO adsDTO, DrawableResponseListener drawableResponseListener) {
        if (!N0.B(adsDTO)) {
            new DownLoadRequest().v(i11).u(drawableResponseListener).w(str).r(Boolean.valueOf(z10), i12, adsDTO != null ? adsDTO.getAdCreativeId() : "").s(i13).t(z11).m(z12).b();
        } else if (drawableResponseListener != null) {
            drawableResponseListener.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TOO_LARGE, "main image is too large."));
        }
    }

    public static void k(String str, AdsDTO adsDTO, int i11, boolean z10, DrawableResponseListener drawableResponseListener) {
        j(str, 3, adsDTO == null ? false : adsDTO.isOfflineAd(), i11, z10, 1, false, adsDTO, drawableResponseListener);
    }

    public static void l(String str, AdsDTO adsDTO, boolean z10, DrawableResponseListener drawableResponseListener) {
        j(str, 3, adsDTO == null ? false : adsDTO.isOfflineAd(), 10, z10, 3, true, adsDTO, drawableResponseListener);
    }

    public static void n(final String str, final AdsDTO adsDTO, final DrawableResponseListener drawableResponseListener, final ImageView imageView) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            if (drawableResponseListener != null) {
                drawableResponseListener.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TAKE_FAILED, "filePath == null or imageView == null."));
            }
        } else if (!N0.B(adsDTO)) {
            HSScopeHelper.f23249a.g(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.DownLoadRequest.2

                /* renamed from: com.cloud.hisavana.sdk.common.http.DownLoadRequest$2$a */
                /* loaded from: classes3.dex */
                class a implements Preconditions.a {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ String f22144a;

                    a(String str) {
                        this.f22144a = str;
                    }

                    @Override // com.cloud.sdk.commonutil.util.Preconditions.a
                    public void onRun() {
                        if (!l7.b.e(AdPayload.FILE_SCHEME + this.f22144a, false, imageView)) {
                            String str = this.f22144a;
                            AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                            DownLoadRequest.p(str, drawableResponseListener, imageView);
                        } else {
                            DrawableResponseListener drawableResponseListener = drawableResponseListener;
                            if (drawableResponseListener != null) {
                                drawableResponseListener.g(200, null);
                            }
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String e11 = AdsDTO.this.isFromLocal() ? str : DiskLruCacheUtil.e(str, 4);
                    if (new File(e11).exists()) {
                        Preconditions.d(new a(e11));
                        return;
                    }
                    DrawableResponseListener drawableResponseListener2 = drawableResponseListener;
                    if (drawableResponseListener2 != null) {
                        drawableResponseListener2.a(TaErrorCode.ERROR_BITMAP_TAKE_FAILED);
                    }
                }
            });
        } else if (drawableResponseListener != null) {
            drawableResponseListener.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TOO_LARGE, "main image is too large."));
        }
    }

    public static void o(final String str, final AdsDTO adsDTO, final int i11, final DrawableResponseListener drawableResponseListener, final ImageView imageView) {
        if (TextUtils.isEmpty(str) || imageView == null) {
            if (drawableResponseListener != null) {
                drawableResponseListener.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TAKE_FAILED, "url == null."));
            }
        } else if (!N0.B(adsDTO)) {
            HSScopeHelper.f23249a.g(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.DownLoadRequest.1

                /* renamed from: com.cloud.hisavana.sdk.common.http.DownLoadRequest$1$a */
                /* loaded from: classes3.dex */
                class a implements Preconditions.a {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ boolean f22141a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ String f22142b;

                    a(boolean z10, String str) {
                        this.f22141a = z10;
                        this.f22142b = str;
                    }

                    @Override // com.cloud.sdk.commonutil.util.Preconditions.a
                    public void onRun() {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        boolean x10 = DownLoadRequest.x(AdsDTO.this, i11);
                        if (this.f22141a) {
                            if (l7.b.e(AdPayload.FILE_SCHEME + this.f22142b, x10, imageView)) {
                                DrawableResponseListener drawableResponseListener = drawableResponseListener;
                                if (drawableResponseListener != null) {
                                    drawableResponseListener.g(200, null);
                                    return;
                                }
                                return;
                            }
                        }
                        e4.b().d("ssp", "loadImageView with ssp, url: " + str);
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        DownLoadRequest.q(str, imageView, AdsDTO.this, i11, drawableResponseListener);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    String str2;
                    boolean z10 = false;
                    if (AdsDTO.this != null) {
                        str2 = DiskLruCacheUtil.e(str, 1);
                        if (!TextUtils.isEmpty(str2) && new File(str2).exists()) {
                            z10 = true;
                        }
                    } else {
                        str2 = "";
                    }
                    Preconditions.d(new a(z10, str2));
                }
            });
        } else if (drawableResponseListener != null) {
            drawableResponseListener.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TOO_LARGE, "main image is too large."));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p(String str, DrawableResponseListener drawableResponseListener, ImageView imageView) {
        if (imageView == null) {
            return;
        }
        HSScopeHelper.f23249a.g(new AnonymousClass3(str, drawableResponseListener, imageView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(String str, ImageView imageView, AdsDTO adsDTO, int i11, DrawableResponseListener drawableResponseListener) {
        j(str, 1, adsDTO == null ? false : adsDTO.isOfflineAd(), i11, false, 1, false, adsDTO, new a(drawableResponseListener, imageView));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean x(AdsDTO adsDTO, int i11) {
        if (a7.c.v() && adsDTO != null && i11 == 2) {
            return adsDTO.getAdType() == 4 || adsDTO.getAdType() == 3 || adsDTO.getAdType() == 5 || adsDTO.getAdType() == 7;
        }
        return false;
    }

    @Override // com.cloud.hisavana.sdk.common.http.d
    protected void a() {
        try {
            RequestParams requestParams = new RequestParams();
            requestParams.m(this.f22134j);
            requestParams.o(true);
            requestParams.k(this.f22138n);
            requestParams.l(this.f22139o);
            requestParams.j(this.f22140p);
            this.f22129e = System.currentTimeMillis();
            HttpRequest.c(this.f22136l, requestParams, new b());
        } catch (Throwable th2) {
            e4.b().e(Log.getStackTraceString(th2));
            this.f22133i = 1;
            ResponseBaseListener responseBaseListener = this.f22167b;
            if (responseBaseListener != null) {
                ((DrawableResponseListener) responseBaseListener).e(TaErrorCode.ERROR_UNKNOWN);
            }
            this.f22130f = 101;
        }
    }

    @Override // com.cloud.hisavana.sdk.common.http.d
    public void b() {
        if (!TextUtils.isEmpty(this.f22136l)) {
            a();
            return;
        }
        ResponseBaseListener responseBaseListener = this.f22167b;
        if (responseBaseListener != null) {
            ((DrawableResponseListener) responseBaseListener).e(TaErrorCode.ERROR_DOWNLOAD_URL_IS_EMPTY);
        }
        e4.b().e("ssp", "url is empty");
    }

    public DownLoadRequest m(boolean z10) {
        this.f22139o = z10;
        return this;
    }

    public DownLoadRequest r(Boolean bool, int i11, String str) {
        this.f22135k = bool.booleanValue();
        this.f22132h = i11;
        this.f22140p = str;
        return this;
    }

    public DownLoadRequest s(int i11) {
        this.f22138n = i11;
        return this;
    }

    public DownLoadRequest t(boolean z10) {
        this.f22134j = z10;
        return this;
    }

    public DownLoadRequest u(DrawableResponseListener drawableResponseListener) {
        this.f22167b = drawableResponseListener;
        return this;
    }

    public DownLoadRequest v(int i11) {
        this.f22137m = i11;
        return this;
    }

    public DownLoadRequest w(String str) {
        this.f22136l = str;
        return this;
    }
}
