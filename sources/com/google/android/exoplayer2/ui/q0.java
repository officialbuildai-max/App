package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ui.SubtitleView;
import com.mbridge.msdk.playercommon.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
final class q0 extends FrameLayout implements SubtitleView.a {

    /* renamed from: a, reason: collision with root package name */
    private final com.google.android.exoplayer2.ui.b f27262a;

    /* renamed from: b, reason: collision with root package name */
    private final WebView f27263b;

    /* renamed from: c, reason: collision with root package name */
    private List f27264c;

    /* renamed from: d, reason: collision with root package name */
    private c f27265d;

    /* renamed from: e, reason: collision with root package name */
    private float f27266e;

    /* renamed from: f, reason: collision with root package name */
    private int f27267f;

    /* renamed from: g, reason: collision with root package name */
    private float f27268g;

    /* loaded from: classes3.dex */
    class a extends WebView {
        a(q0 q0Var, Context context, AttributeSet attributeSet) {
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
    /* loaded from: classes3.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f27269a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            f27269a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27269a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27269a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public q0(Context context) {
        this(context, null);
    }

    public q0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f27264c = Collections.emptyList();
        this.f27265d = c.f27164g;
        this.f27266e = 0.0533f;
        this.f27267f = 0;
        this.f27268g = 0.08f;
        com.google.android.exoplayer2.ui.b bVar = new com.google.android.exoplayer2.ui.b(context, attributeSet);
        this.f27262a = bVar;
        a aVar = new a(this, context, attributeSet);
        this.f27263b = aVar;
        aVar.setBackgroundColor(0);
        addView(bVar);
        addView(aVar);
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
        int i11 = b.f27269a[alignment.ordinal()];
        return i11 != 1 ? i11 != 2 ? TtmlNode.CENTER : TtmlNode.END : "start";
    }

    private static String d(c cVar) {
        int i11 = cVar.f27168d;
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? "unset" : com.google.android.exoplayer2.util.p0.C("-0.05em -0.05em 0.15em %s", h.b(cVar.f27169e)) : com.google.android.exoplayer2.util.p0.C("0.06em 0.08em 0.15em %s", h.b(cVar.f27169e)) : com.google.android.exoplayer2.util.p0.C("0.1em 0.12em 0.15em %s", h.b(cVar.f27169e)) : com.google.android.exoplayer2.util.p0.C("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", h.b(cVar.f27169e));
    }

    private String e(int i11, float f11) {
        float h11 = m0.h(i11, f11, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return h11 == -3.4028235E38f ? "unset" : com.google.android.exoplayer2.util.p0.C("%.2fpx", Float.valueOf(h11 / getContext().getResources().getDisplayMetrics().density));
    }

    private static String f(int i11) {
        return i11 != 1 ? i11 != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
    }

    private static String h(ba.b bVar) {
        float f11 = bVar.f16349q;
        if (f11 == 0.0f) {
            return "";
        }
        int i11 = bVar.f16348p;
        return com.google.android.exoplayer2.util.p0.C("%s(%.2fdeg)", (i11 == 2 || i11 == 1) ? "skewY" : "skewX", Float.valueOf(f11));
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.ui.q0.i():void");
    }

    @Override // com.google.android.exoplayer2.ui.SubtitleView.a
    public void a(List list, c cVar, float f11, int i11, float f12) {
        this.f27265d = cVar;
        this.f27266e = f11;
        this.f27267f = i11;
        this.f27268g = f12;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i12 = 0; i12 < list.size(); i12++) {
            ba.b bVar = (ba.b) list.get(i12);
            if (bVar.f16336d != null) {
                arrayList.add(bVar);
            } else {
                arrayList2.add(bVar);
            }
        }
        if (!this.f27264c.isEmpty() || !arrayList2.isEmpty()) {
            this.f27264c = arrayList2;
            i();
        }
        this.f27262a.a(arrayList, cVar, f11, i11, f12);
        invalidate();
    }

    public void g() {
        this.f27263b.destroy();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z10, int i11, int i12, int i13, int i14) {
        super.onLayout(z10, i11, i12, i13, i14);
        if (!z10 || this.f27264c.isEmpty()) {
            return;
        }
        i();
    }
}
