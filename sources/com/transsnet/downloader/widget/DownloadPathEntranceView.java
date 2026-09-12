package com.transsnet.downloader.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import com.blankj.utilcode.util.Utils;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.noober.background.view.BLConstraintLayout;
import com.tn.lib.widget.R$color;
import com.transsnet.downloader.R$layout;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.util.DownloadUtil;
import com.vungle.ads.internal.protos.Sdk$SDKMetric;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import lg.a;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0004\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\r\u0010\u0015\u001a\u00020\f¢\u0006\u0004\b\u0015\u0010\u000eJ\r\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u000eJ\r\u0010\u0017\u001a\u00020\f¢\u0006\u0004\b\u0017\u0010\u000eJ0\u0010\u001e\u001a\u00020\f2!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0004\b\u001e\u0010\u001fJ0\u0010 \u001a\u00020\f2!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0004\b \u0010\u001fR\u0014\u0010#\u001a\u00020\u000f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010\"R\u0014\u0010,\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R3\u0010/\u001a\u001f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\f\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R3\u00101\u001a\u001f\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\f\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010.¨\u00062"}, d2 = {"Lcom/transsnet/downloader/widget/DownloadPathEntranceView;", "Lcom/noober/background/view/BLConstraintLayout;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", "attrs", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "res", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", com.mbridge.msdk.foundation.same.report.j.f35620b, "()V", "", "pathName", "", "size", "updatePathName", "(Ljava/lang/String;J)V", "onPermissionGranted", "onPermissionDenied", "onPermissionRefresh", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "callback", "setChangeClickCallback", "(Lkotlin/jvm/functions/Function1;)V", "setPermissionClickCallback", "a", "Ljava/lang/String;", "TAG", "Lpy/x0;", DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, "Lpy/x0;", "viewBinding", "c", "availableStr", "d", "I", "dp16", "e", "Lkotlin/jvm/functions/Function1;", "changeClickCallback", "f", "permissionClickCallback", "Downloader_psRelease"}, k = 1, mv = {2, 1, 0}, xi = Sdk$SDKMetric.SDKMetricType.AD_SHOW_TO_VALIDATION_DURATION_MS_VALUE)
/* loaded from: classes7.dex */
public final class DownloadPathEntranceView extends BLConstraintLayout {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final py.x0 viewBinding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String availableStr;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int dp16;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Function1 changeClickCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function1 permissionClickCallback;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadPathEntranceView(Context context) {
        this(context, null);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadPathEntranceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.h(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadPathEntranceView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.h(context, "context");
        this.TAG = "DownloadPathEntranceView";
        String string = Utils.a().getString(R$string.available);
        Intrinsics.g(string, "getString(...)");
        this.availableStr = string;
        this.dp16 = com.blankj.utilcode.util.a0.a(16.0f);
        View.inflate(context, R$layout.layout_download_re_path_entrance, this);
        py.x0 a11 = py.x0.a(this);
        Intrinsics.g(a11, "bind(...)");
        this.viewBinding = a11;
        j();
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0011, code lost:
    
        if (r0 == null) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void j() {
        /*
            r4 = this;
            android.view.ViewGroup$LayoutParams r0 = r4.getLayoutParams()
            if (r0 == 0) goto L13
            android.view.ViewGroup$LayoutParams r0 = r4.getLayoutParams()
            java.lang.String r1 = "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams"
            kotlin.jvm.internal.Intrinsics.f(r0, r1)
            androidx.constraintlayout.widget.ConstraintLayout$b r0 = (androidx.constraintlayout.widget.ConstraintLayout.b) r0
            if (r0 != 0) goto L1a
        L13:
            androidx.constraintlayout.widget.ConstraintLayout$b r0 = new androidx.constraintlayout.widget.ConstraintLayout$b
            r1 = -1
            r2 = -2
            r0.<init>(r1, r2)
        L1a:
            int r1 = r4.dp16
            r0.setMarginStart(r1)
            int r1 = r4.dp16
            r0.setMarginEnd(r1)
            r4.setLayoutParams(r0)
            com.noober.background.drawable.DrawableCreator$Builder r0 = new com.noober.background.drawable.DrawableCreator$Builder
            r0.<init>()
            r1 = 1090519040(0x41000000, float:8.0)
            int r2 = com.blankj.utilcode.util.a0.a(r1)
            float r2 = (float) r2
            com.noober.background.drawable.DrawableCreator$Builder r0 = r0.setCornersRadius(r2)
            android.content.Context r2 = r4.getContext()
            android.content.res.Resources r2 = r2.getResources()
            int r3 = com.transsnet.downloader.R$color.download_module_1
            int r2 = r2.getColor(r3)
            com.noober.background.drawable.DrawableCreator$Builder r0 = r0.setSolidColor(r2)
            android.graphics.drawable.Drawable r0 = r0.build()
            r4.setBackground(r0)
            r4.onPermissionRefresh()
            py.x0 r0 = r4.viewBinding
            android.widget.TextView r0 = r0.f73099i
            com.transsnet.downloader.widget.q r2 = new com.transsnet.downloader.widget.q
            r2.<init>()
            r0.setOnClickListener(r2)
            py.x0 r0 = r4.viewBinding
            android.widget.TextView r0 = r0.f73097g
            com.transsnet.downloader.widget.r r2 = new com.transsnet.downloader.widget.r
            r2.<init>()
            r0.setOnClickListener(r2)
            py.x0 r0 = r4.viewBinding
            androidx.constraintlayout.widget.ConstraintLayout r0 = r0.f73092b
            java.lang.String r2 = "clPermission"
            kotlin.jvm.internal.Intrinsics.g(r0, r2)
            int r1 = com.blankj.utilcode.util.i.e(r1)
            float r1 = (float) r1
            com.transsion.baseui.util.q.c(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.widget.DownloadPathEntranceView.j():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(DownloadPathEntranceView downloadPathEntranceView, View view) {
        Function1 function1 = downloadPathEntranceView.permissionClickCallback;
        if (function1 != null) {
            Intrinsics.e(view);
            function1.invoke(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(DownloadPathEntranceView downloadPathEntranceView, View view) {
        Function1 function1;
        if (downloadPathEntranceView.viewBinding.f73097g.getAlpha() != 1.0f || (function1 = downloadPathEntranceView.changeClickCallback) == null) {
            return;
        }
        Intrinsics.e(view);
        function1.invoke(view);
    }

    public final void onPermissionDenied() {
        this.viewBinding.f73097g.setAlpha(0.4f);
        Group groupPermission = this.viewBinding.f73093c;
        Intrinsics.g(groupPermission, "groupPermission");
        jg.c.k(groupPermission);
    }

    public final void onPermissionGranted() {
        a.C0856a.f(lg.a.f68962a, this.TAG, "onPermissionGranted", false, 4, null);
        Group groupPermission = this.viewBinding.f73093c;
        Intrinsics.g(groupPermission, "groupPermission");
        jg.c.g(groupPermission);
        this.viewBinding.f73097g.setAlpha(1.0f);
    }

    public final void onPermissionRefresh() {
        if (DownloadUtil.f60023a.D()) {
            onPermissionGranted();
        } else {
            onPermissionDenied();
        }
    }

    public final void setChangeClickCallback(Function1<? super View, Unit> callback) {
        Intrinsics.h(callback, "callback");
        this.changeClickCallback = callback;
    }

    public final void setPermissionClickCallback(Function1<? super View, Unit> callback) {
        Intrinsics.h(callback, "callback");
        this.permissionClickCallback = callback;
    }

    public final void updatePathName(String pathName, long size) {
        Intrinsics.h(pathName, "pathName");
        String string = Utils.a().getString(R$string.sdcard_name);
        Intrinsics.g(string, "getString(...)");
        if (StringsKt.c0(pathName, string, false, 2, null)) {
            pathName = pathName + File.separator + lj.b.f68989a.f();
        }
        this.viewBinding.f73098h.setText(getContext().getString(R$string.download_path_title_prefix) + " " + pathName);
        TextView textView = this.viewBinding.f73096f;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(size <= 0 ? "0Mb" : oh.b.a(size, 2));
        sb2.append(" ");
        sb2.append(this.availableStr);
        textView.setText(sb2.toString());
        this.viewBinding.f73096f.setTextColor(Utils.a().getResources().getColor(size <= 0 ? R$color.error_50 : R$color.text_02));
    }
}
