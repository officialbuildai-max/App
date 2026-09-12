package com.cloud.tmc.miniapp.widget.pulldownrefresh.header;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cloud.tmc.integration.utils.ext.ViewExtKt;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.miniapp.R;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOOO;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOOO0;
import com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.MiniRefreshState;
import com.cloud.tmc.miniutils.util.VibrateUtils;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;

/* loaded from: classes3.dex */
public final class OooO0OO extends com.cloud.tmc.miniapp.widget.pulldownrefresh.internal.OooO0O0 implements OooOO0 {
    public OooOOO0 OooO;
    public ImageView OooO0Oo;
    public String OooO0o;
    public TextView OooO0o0;
    public int OooO0oO;
    public int OooO0oo;
    public File OooOO0;
    public File OooOO0O;
    public File OooOO0o;
    public File OooOOO0;

    /* loaded from: classes3.dex */
    public /* synthetic */ class OooO00o {
        public static final /* synthetic */ int[] OooO00o;

        static {
            int[] iArr = new int[MiniRefreshState.values().length];
            try {
                iArr[MiniRefreshState.PULL_DOWN_TO_REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MiniRefreshState.REFRESHING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MiniRefreshState.REFRESH_RELEASED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MiniRefreshState.RELEASE_TO_REFRESH.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            OooO00o = iArr;
        }
    }

    /* loaded from: classes3.dex */
    public static final class OooO0O0 extends Lambda implements Function1<Drawable, Unit> {
        public final /* synthetic */ ImageView OooO00o;
        public final /* synthetic */ Drawable OooO0O0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0O0(ImageView imageView, Drawable drawable) {
            super(1);
            this.OooO00o = imageView;
            this.OooO0O0 = drawable;
        }

        @Override // kotlin.jvm.functions.Function1
        public Object invoke(Object obj) {
            this.OooO00o.setImageDrawable(this.OooO0O0);
            return Unit.f67184a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public OooO0OO(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.h(context, "context");
        this.OooO0oo = 500;
        this.OooO0O0 = com.cloud.tmc.miniapp.widget.pulldownrefresh.constant.OooO0O0.OooO0Oo;
        View.inflate(context, R.layout.layout_sharp_news_header, this);
        this.OooO0Oo = (ImageView) findViewById(R.id.srl_classics_progress);
        TextView textView = (TextView) findViewById(R.id.srl_classics_title);
        this.OooO0o0 = textView;
        if (textView != null) {
            textView.setTextSize(0, com.cloud.tmc.miniapp.widget.pulldownrefresh.util.OooO0O0.OooO00o(16.0f));
        }
        this.OooO0o = context.getString(R.string.srl_header_pulling);
        context.getString(R.string.srl_header_release);
        context.getString(R.string.srl_header_finish);
        context.getString(R.string.srl_header_failed);
        context.getString(R.string.srl_header_refreshing);
        setVisibility(4);
    }

    @Override // com.cloud.tmc.miniapp.widget.pulldownrefresh.internal.OooO0O0, com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O
    public int OooO00o(OooOOO miniRefreshLayout, boolean z10) {
        Intrinsics.h(miniRefreshLayout, "miniRefreshLayout");
        if (z10) {
            OooO00o(2);
            TextView textView = this.OooO0o0;
            if (textView != null) {
                textView.setText("");
            }
        }
        return this.OooO0oo;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void OooO00o(int r12) {
        /*
            r11 = this;
            android.content.Context r1 = r11.getContext()
            if (r1 != 0) goto L7
            return
        L7:
            android.widget.ImageView r4 = r11.OooO0Oo
            if (r4 != 0) goto Lc
            return
        Lc:
            r0 = 4
            r2 = 3
            r3 = 2
            r5 = 1
            r6 = 0
            if (r12 == r5) goto L24
            if (r12 == r3) goto L21
            if (r12 == r2) goto L1e
            if (r12 == r0) goto L1b
            r7 = r6
            goto L26
        L1b:
            java.io.File r7 = r11.OooOOO0
            goto L26
        L1e:
            java.io.File r7 = r11.OooOO0o
            goto L26
        L21:
            java.io.File r7 = r11.OooOO0O
            goto L26
        L24:
            java.io.File r7 = r11.OooOO0
        L26:
            boolean r8 = com.cloud.tmc.integration.utils.FileUtil.access(r7)
            java.lang.String r9 = "MiniCustomHeader"
            if (r8 != 0) goto L49
            if (r7 == 0) goto L34
            java.lang.String r6 = r7.getAbsolutePath()
        L34:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "加载目标文件不存在，"
            r12.append(r0)
            r12.append(r6)
            java.lang.String r12 = r12.toString()
            com.cloud.tmc.kernel.log.TmcLogger.d(r9, r12)
            return
        L49:
            if (r12 == r5) goto L56
            if (r12 == r3) goto L53
            if (r12 == r2) goto L56
            if (r12 == r0) goto L53
            r8 = r6
            goto L58
        L53:
            java.io.File r8 = r11.OooOOO0
            goto L58
        L56:
            java.io.File r8 = r11.OooOO0o
        L58:
            boolean r10 = com.cloud.tmc.integration.utils.FileUtil.access(r8)
            if (r10 != 0) goto L79
            if (r8 == 0) goto L64
            java.lang.String r6 = r8.getAbsolutePath()
        L64:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r0 = "加载占位图文件不存在，"
            r12.append(r0)
            r12.append(r6)
            java.lang.String r12 = r12.toString()
            com.cloud.tmc.kernel.log.TmcLogger.d(r9, r12)
            return
        L79:
            if (r8 == 0) goto L82
            java.lang.String r8 = r8.getAbsolutePath()     // Catch: java.lang.Throwable -> L80
            goto L83
        L80:
            r12 = move-exception
            goto Lbc
        L82:
            r8 = r6
        L83:
            android.graphics.drawable.Drawable r8 = android.graphics.drawable.Drawable.createFromPath(r8)     // Catch: java.lang.Throwable -> L80
            java.lang.Class<com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy> r10 = com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy.class
            if (r12 == r5) goto Lb2
            if (r12 == r3) goto La0
            if (r12 == r2) goto L92
            if (r12 == r0) goto L92
            goto Lc1
        L92:
            if (r7 == 0) goto L98
            java.lang.String r6 = r7.getAbsolutePath()     // Catch: java.lang.Throwable -> L80
        L98:
            android.graphics.drawable.Drawable r12 = android.graphics.drawable.Drawable.createFromPath(r6)     // Catch: java.lang.Throwable -> L80
            r4.setImageDrawable(r12)     // Catch: java.lang.Throwable -> L80
            goto Lc1
        La0:
            java.lang.Object r12 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r10)     // Catch: java.lang.Throwable -> L80
            r0 = r12
            com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy r0 = (com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy) r0     // Catch: java.lang.Throwable -> L80
            com.cloud.tmc.miniapp.widget.pulldownrefresh.header.OooO0OO$OooO0O0 r5 = new com.cloud.tmc.miniapp.widget.pulldownrefresh.header.OooO0OO$OooO0O0     // Catch: java.lang.Throwable -> L80
            r5.<init>(r4, r8)     // Catch: java.lang.Throwable -> L80
            r3 = 0
            r2 = r7
            r0.loadImgGifPlayOnce(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L80
            goto Lc1
        Lb2:
            java.lang.Object r12 = com.cloud.tmc.kernel.proxy.TmcProxy.get(r10)     // Catch: java.lang.Throwable -> L80
            com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy r12 = (com.cloud.tmc.kernel.proxy.imageloader.ImageLoaderProxy) r12     // Catch: java.lang.Throwable -> L80
            r12.loadImgGifPlay(r1, r7, r8, r4)     // Catch: java.lang.Throwable -> L80
            goto Lc1
        Lbc:
            java.lang.String r0 = "Error loading image"
            com.cloud.tmc.kernel.log.TmcLogger.e(r9, r0, r12)
        Lc1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cloud.tmc.miniapp.widget.pulldownrefresh.header.OooO0OO.OooO00o(int):void");
    }

    @Override // com.cloud.tmc.miniapp.widget.pulldownrefresh.internal.OooO0O0, com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O
    public void OooO00o(OooOOO0 kernel, int i11, int i12) {
        Intrinsics.h(kernel, "kernel");
        this.OooO = kernel;
    }

    @Override // com.cloud.tmc.miniapp.widget.pulldownrefresh.internal.OooO0O0, com.cloud.tmc.miniapp.widget.pulldownrefresh.listener.OooO0o
    public void OooO00o(OooOOO miniRefreshLayout, MiniRefreshState oldState, MiniRefreshState newState) {
        Intrinsics.h(miniRefreshLayout, "miniRefreshLayout");
        Intrinsics.h(oldState, "oldState");
        Intrinsics.h(newState, "newState");
        int i11 = OooO00o.OooO00o[newState.ordinal()];
        if (i11 == 1) {
            OooO00o(3);
            ImageView imageView = this.OooO0Oo;
            if (imageView != null) {
                ViewExtKt.toVisible(imageView);
            }
            TextView textView = this.OooO0o0;
            if (textView == null) {
                return;
            }
            textView.setText(this.OooO0o);
            return;
        }
        if (i11 == 2 || i11 == 3) {
            TextView textView2 = this.OooO0o0;
            if (textView2 == null) {
                return;
            }
            textView2.setText("");
            return;
        }
        if (i11 != 4) {
            return;
        }
        try {
            VibrateUtils.vibrate(100L);
        } catch (Throwable th2) {
            TmcLogger.e("MiniCustomHeader", "ReleaseToRefresh vibrate failed!", th2);
        }
        TextView textView3 = this.OooO0o0;
        if (textView3 == null) {
            return;
        }
        textView3.setText(this.OooO0o);
    }

    @Override // com.cloud.tmc.miniapp.widget.pulldownrefresh.internal.OooO0O0, com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O
    public void OooO00o(boolean z10, float f11, int i11, int i12, int i13) {
        setAlpha(RangesKt.e(0.0f, RangesKt.h(1.0f, f11)));
        if (i11 > this.OooO0oO) {
            if (getVisibility() != 0) {
                setVisibility(0);
            }
        } else if (getVisibility() != 4) {
            setVisibility(4);
        }
        if (i11 == 0) {
            OooO00o(3);
        }
    }

    @Override // com.cloud.tmc.miniapp.widget.pulldownrefresh.internal.OooO0O0, com.cloud.tmc.miniapp.widget.pulldownrefresh.api.OooOO0O
    public void OooO0O0(OooOOO miniRefreshLayout, int i11, int i12) {
        Intrinsics.h(miniRefreshLayout, "miniRefreshLayout");
        OooO00o(1);
    }
}
