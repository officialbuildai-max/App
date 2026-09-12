package androidx.media3.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.media3.ui.SubtitleView;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
final class b1 extends FrameLayout implements SubtitleView.a {

    /* renamed from: a, reason: collision with root package name */
    private final androidx.media3.ui.a f13721a;

    /* renamed from: b, reason: collision with root package name */
    private final WebView f13722b;

    /* renamed from: c, reason: collision with root package name */
    private List f13723c;

    /* renamed from: d, reason: collision with root package name */
    private androidx.media3.ui.b f13724d;

    /* renamed from: e, reason: collision with root package name */
    private float f13725e;

    /* renamed from: f, reason: collision with root package name */
    private int f13726f;

    /* renamed from: g, reason: collision with root package name */
    private float f13727g;

    /* loaded from: classes2.dex */
    class a extends WebView {
        a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.webkit.WebView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            super.performClick();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f13729a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f13729a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f13729a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f13729a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public b1(Context context) {
        this(context, null);
    }

    public b1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13723c = Collections.emptyList();
        this.f13724d = androidx.media3.ui.b.f13713g;
        this.f13725e = 0.0533f;
        this.f13726f = 0;
        this.f13727g = 0.08f;
        androidx.media3.ui.a aVar = new androidx.media3.ui.a(context, attributeSet);
        this.f13721a = aVar;
        a aVar2 = new a(context, attributeSet);
        this.f13722b = aVar2;
        aVar2.setBackgroundColor(0);
        addView(aVar);
        addView(aVar2);
    }

    private static int b(int i11) {
        if (i11 != 1) {
            return i11 != 2 ? 0 : -100;
        }
        return -50;
    }

    private static String c(Layout.Alignment alignment) {
        if (alignment == null) {
            return TtmlNode.CENTER;
        }
        int i11 = b.f13729a[alignment.ordinal()];
        return i11 != 1 ? i11 != 2 ? TtmlNode.CENTER : TtmlNode.END : "start";
    }

    private static String d(androidx.media3.ui.b bVar) {
        int i11 = bVar.f13717d;
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? "unset" : androidx.media3.common.util.a1.G("-0.05em -0.05em 0.15em %s", g.b(bVar.f13718e)) : androidx.media3.common.util.a1.G("0.06em 0.08em 0.15em %s", g.b(bVar.f13718e)) : androidx.media3.common.util.a1.G("0.1em 0.12em 0.15em %s", g.b(bVar.f13718e)) : androidx.media3.common.util.a1.G("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", g.b(bVar.f13718e));
    }

    private String e(int i11, float f11) {
        float h11 = x0.h(i11, f11, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return h11 == -3.4028235E38f ? "unset" : androidx.media3.common.util.a1.G("%.2fpx", Float.valueOf(h11 / getContext().getResources().getDisplayMetrics().density));
    }

    private static String f(int i11) {
        return i11 != 1 ? i11 != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
    }

    private static String h(u1.a aVar) {
        float f11 = aVar.f76697q;
        if (f11 == 0.0f) {
            return "";
        }
        int i11 = aVar.f76696p;
        return androidx.media3.common.util.a1.G("%s(%.2fdeg)", (i11 == 2 || i11 == 1) ? "skewY" : "skewX", Float.valueOf(f11));
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x0144, code lost:
    
        if (r13 != 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0147, code lost:
    
        r21 = com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode.LEFT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0149, code lost:
    
        r23 = com.cloud.tmc.integration.constants.IntegrationConstants.TAB_BAR_POSITION_TOP;
        r13 = 2;
        r22 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x014f, code lost:
    
        if (r13 != 0) goto L40;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x023f  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void i() {
        /*
            Method dump skipped, instructions count: 708
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.b1.i():void");
    }

    @Override // androidx.media3.ui.SubtitleView.a
    public void a(List list, androidx.media3.ui.b bVar, float f11, int i11, float f12) {
        this.f13724d = bVar;
        this.f13725e = f11;
        this.f13726f = i11;
        this.f13727g = f12;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            u1.a aVar = (u1.a) list.get(i12);
            if (aVar.f76684d != null) {
                arrayList.add(aVar);
            } else {
                arrayList2.add(aVar);
            }
        }
        if (!this.f13723c.isEmpty() || !arrayList2.isEmpty()) {
            this.f13723c = arrayList2;
            i();
        }
        this.f13721a.a(arrayList, bVar, f11, i11, f12);
        invalidate();
    }

    public void g() {
        this.f13722b.destroy();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        if (!z10 || this.f13723c.isEmpty()) {
            return;
        }
        i();
    }
}
