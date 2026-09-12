package com.cloud.hisavana.sdk.common.http.listener;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.Log;
import com.cloud.hisavana.sdk.N0;
import com.cloud.hisavana.sdk.common.bean.AdImage;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;
import com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener;
import com.cloud.hisavana.sdk.e4;
import com.cloud.sdk.commonutil.util.HSScopeHelper;
import com.cloud.sdk.commonutil.util.Preconditions;
import com.cloud.sdk.commonutil.util.e;
import l7.c;

/* loaded from: classes3.dex */
public abstract class DrawableResponseListener extends ResponseBaseListener {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener$2, reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass2 implements Runnable {
        final /* synthetic */ byte[] val$data;
        final /* synthetic */ String val$filePath;
        final /* synthetic */ int val$mime;
        final /* synthetic */ int val$statusCode;

        /* renamed from: com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener$2$a */
        /* loaded from: classes3.dex */
        class a implements Preconditions.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Drawable f22168a;

            a(Drawable drawable) {
                this.f22168a = drawable;
            }

            @Override // com.cloud.sdk.commonutil.util.Preconditions.a
            public void onRun() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                if (anonymousClass2.val$mime == -1) {
                    DrawableResponseListener.this.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TAKE_FAILED, "parse bitmap error."));
                    return;
                }
                DrawableResponseListener drawableResponseListener = DrawableResponseListener.this;
                int i11 = anonymousClass2.val$statusCode;
                AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                drawableResponseListener.g(i11, new AdImage(anonymousClass22.val$mime, this.f22168a, anonymousClass22.val$filePath));
            }
        }

        AnonymousClass2(byte[] bArr, int i11, int i12, String str) {
            this.val$data = bArr;
            this.val$mime = i11;
            this.val$statusCode = i12;
            this.val$filePath = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$0() {
            DrawableResponseListener.this.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TOO_LARGE, "bitmap is too large."));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$run$1() {
            DrawableResponseListener.this.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TOO_LARGE, "bitmap is too large."));
        }

        @Override // java.lang.Runnable
        public void run() {
            final Drawable drawable;
            try {
            } catch (Throwable th2) {
                e4.b().e(Log.getStackTraceString(th2));
                drawable = null;
            }
            if (N0.A(e.a(), this.val$data)) {
                Handler handler = DrawableResponseListener.this.f22170a;
                if (handler != null) {
                    handler.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.listener.a
                        @Override // java.lang.Runnable
                        public final void run() {
                            DrawableResponseListener.AnonymousClass2.this.lambda$run$0();
                        }
                    });
                    return;
                } else {
                    Preconditions.d(new Preconditions.a() { // from class: com.cloud.hisavana.sdk.common.http.listener.b
                        @Override // com.cloud.sdk.commonutil.util.Preconditions.a
                        public final void onRun() {
                            DrawableResponseListener.AnonymousClass2.this.lambda$run$1();
                        }
                    });
                    return;
                }
            }
            drawable = c.b(this.val$data);
            Handler handler2 = DrawableResponseListener.this.f22170a;
            if (handler2 != null) {
                handler2.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        if (anonymousClass2.val$mime == -1) {
                            DrawableResponseListener.this.a(new TaErrorCode(TaErrorCode.CODE_BITMAP_TAKE_FAILED, "parse bitmap error."));
                            return;
                        }
                        DrawableResponseListener drawableResponseListener = DrawableResponseListener.this;
                        int i11 = anonymousClass2.val$statusCode;
                        AnonymousClass2 anonymousClass22 = AnonymousClass2.this;
                        drawableResponseListener.g(i11, new AdImage(anonymousClass22.val$mime, drawable, anonymousClass22.val$filePath));
                    }
                });
            } else {
                Preconditions.d(new a(drawable));
            }
        }
    }

    public abstract void g(int i11, AdImage adImage);

    public final void h(int i11, final int i12, byte[] bArr, final String str) {
        int i13 = 1;
        if (bArr.length <= 1) {
            i13 = -1;
        } else if (bArr[0] == 71) {
            i13 = 2;
        }
        final int i14 = i13;
        if (i11 != 3) {
            HSScopeHelper.f23249a.g(new AnonymousClass2(bArr, i14, i12, str));
            return;
        }
        Handler handler = this.f22170a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.listener.DrawableResponseListener.1
                @Override // java.lang.Runnable
                public void run() {
                    DrawableResponseListener.this.g(i12, new AdImage(i14, null, str));
                }
            });
        } else {
            g(i12, new AdImage(i14, null, str));
        }
    }
}
