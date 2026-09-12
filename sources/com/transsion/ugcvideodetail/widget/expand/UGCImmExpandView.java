package com.transsion.ugcvideodetail.widget.expand;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import com.transsion.shorttv.R$mipmap;
import com.transsion.shorttv.R$string;
import com.transsion.shorttv.R$styleable;
import com.transsion.shorttv_pugc.base.widget.TnTextView;
import com.transsion.ugcvideodetail.widget.expand.UGCImmExpandView;
import kotlin.jvm.functions.Function0;

/* loaded from: classes6.dex */
public class UGCImmExpandView extends TnTextView {
    public static final int STATE_EXPAND = 1;
    public static final int STATE_SHRINK = 0;
    private String A;
    private boolean B;

    /* renamed from: b, reason: collision with root package name */
    private String f56681b;

    /* renamed from: c, reason: collision with root package name */
    private String f56682c;

    /* renamed from: d, reason: collision with root package name */
    private String f56683d;

    /* renamed from: e, reason: collision with root package name */
    private String f56684e;

    /* renamed from: f, reason: collision with root package name */
    private String f56685f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f56686g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f56687h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f56688i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f56689j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f56690k;

    /* renamed from: l, reason: collision with root package name */
    private int f56691l;

    /* renamed from: m, reason: collision with root package name */
    private int f56692m;

    /* renamed from: n, reason: collision with root package name */
    private int f56693n;

    /* renamed from: o, reason: collision with root package name */
    private int f56694o;

    /* renamed from: p, reason: collision with root package name */
    private int f56695p;

    /* renamed from: q, reason: collision with root package name */
    private int f56696q;

    /* renamed from: r, reason: collision with root package name */
    private int f56697r;

    /* renamed from: s, reason: collision with root package name */
    private float f56698s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f56699t;

    /* renamed from: u, reason: collision with root package name */
    private ClickableSpan f56700u;

    /* renamed from: v, reason: collision with root package name */
    private uv.a f56701v;

    /* renamed from: w, reason: collision with root package name */
    private uv.a f56702w;

    /* renamed from: x, reason: collision with root package name */
    private Layout f56703x;

    /* renamed from: y, reason: collision with root package name */
    private CharSequence f56704y;

    /* renamed from: z, reason: collision with root package name */
    private String f56705z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            UGCImmExpandView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            UGCImmExpandView uGCImmExpandView = UGCImmExpandView.this;
            uGCImmExpandView.l(uGCImmExpandView.f56704y);
            UGCImmExpandView.this.f56690k = true;
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
    }

    /* loaded from: classes6.dex */
    public interface c {
    }

    public UGCImmExpandView(Context context) {
        this(context, null);
    }

    public UGCImmExpandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f56684e = "  ";
        this.f56685f = "  ";
        this.f56686g = false;
        this.f56687h = true;
        this.f56688i = true;
        this.f56689j = true;
        this.f56690k = false;
        this.f56691l = 1;
        this.f56692m = -1711276033;
        this.f56693n = -1711276033;
        this.f56694o = 0;
        this.f56695p = 0;
        this.f56696q = -1;
        this.f56697r = 0;
        this.f56699t = true;
        this.B = false;
        j(context, attributeSet);
    }

    public UGCImmExpandView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f56684e = "  ";
        this.f56685f = "  ";
        this.f56686g = false;
        this.f56687h = true;
        this.f56688i = true;
        this.f56689j = true;
        this.f56690k = false;
        this.f56691l = 1;
        this.f56692m = -1711276033;
        this.f56693n = -1711276033;
        this.f56694o = 0;
        this.f56695p = 0;
        this.f56696q = -1;
        this.f56697r = 0;
        this.f56699t = true;
        this.B = false;
        j(context, attributeSet);
    }

    private int getLayoutWidth() {
        Layout layout = getLayout();
        int width = layout != null ? layout.getWidth() : 0;
        return (width > 0 || getWidth() == 0) ? width : (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private CharSequence h(int i11) {
        int i12;
        TextPaint paint = getPaint();
        String str = "";
        if (this.f56704y != null) {
            str = "" + ((Object) this.f56704y);
        }
        if (this.f56703x == null) {
            this.f56703x = new StaticLayout(str, paint, i11, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        }
        int lineCount = this.f56703x.getLineCount();
        int i13 = this.f56691l;
        if (lineCount <= i13) {
            CharSequence charSequence = this.f56704y;
            if (charSequence == null) {
                charSequence = " ";
            }
            return n(new SpannableStringBuilder(charSequence));
        }
        int i14 = this.f56697r;
        if (i14 != 0) {
            if (i14 != 1 || !this.f56689j) {
                return n(new SpannableStringBuilder(this.f56704y));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f56704y);
            spannableStringBuilder.append((CharSequence) this.f56685f).append((CharSequence) this.f56683d);
            int length = (spannableStringBuilder.length() - this.f56685f.length()) - this.f56683d.length();
            int length2 = spannableStringBuilder.length();
            i12 = length >= 0 ? length : 0;
            spannableStringBuilder.setSpan(this.f56700u, i12, length2, 33);
            spannableStringBuilder.setSpan(this.f56701v, i12, length2, 33);
            return n(spannableStringBuilder);
        }
        int lineEnd = this.f56703x.getLineEnd(i13 - 1);
        this.f56703x.getLineStart(this.f56691l - 1);
        CharSequence charSequence2 = this.f56704y;
        if (charSequence2 != null && charSequence2.length() <= lineEnd) {
            lineEnd = this.f56704y.length() - 1;
        }
        CharSequence charSequence3 = this.f56704y;
        if (charSequence3 == null || lineEnd <= 0) {
            return charSequence3;
        }
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder((charSequence3.subSequence(0, Math.max(0, lineEnd - 3)).toString() + this.f56681b).replace("\n\n", "\n"));
        if (this.f56688i) {
            spannableStringBuilder2.append((CharSequence) this.f56684e);
            spannableStringBuilder2.append((CharSequence) this.f56682c);
            int length3 = (spannableStringBuilder2.length() - this.f56684e.length()) - this.f56682c.length();
            int length4 = spannableStringBuilder2.length();
            i12 = length3 >= 0 ? length3 : 0;
            spannableStringBuilder2.setSpan(this.f56700u, i12, length4, 33);
            spannableStringBuilder2.setSpan(this.f56702w, i12, length4, 33);
        }
        return n(spannableStringBuilder2);
    }

    private void i() {
        if (this.f56698s == 0.0f) {
            this.f56698s = getTextSize();
        }
        boolean z10 = getLayoutDirection() == 1;
        this.f56702w = new uv.a(getContext(), this.f56699t ? R$mipmap.short_tv_ic_down_more : -111, this.f56692m, this.f56694o, this.f56698s, 0, z10);
        this.f56701v = new uv.a(getContext(), this.f56699t ? R$mipmap.short_tv_ic_up_hide : -111, this.f56693n, this.f56695p, this.f56698s, 0, z10);
        setMovementMethod(new LinkMovementMethod());
        if (TextUtils.isEmpty(this.f56681b)) {
            this.f56681b = "...";
        }
        if (TextUtils.isEmpty(this.f56682c)) {
            this.f56682c = getResources().getString(R$string.short_tv_str_more);
        }
        if (TextUtils.isEmpty(this.f56683d)) {
            this.f56683d = "\n" + getResources().getString(R$string.short_tv_str_hide);
        }
        if (this.f56684e == null) {
            this.f56684e = "  ";
        }
        if (this.f56685f == null) {
            this.f56685f = "  ";
        }
        setOnClickListener(new View.OnClickListener() { // from class: uv.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UGCImmExpandView.this.k(view);
            }
        });
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private void j(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            i();
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExpandView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.ExpandView_pop_hint_text_size) {
                this.f56698s = obtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == R$styleable.ExpandView_pop_reverse_Lines) {
                this.f56691l = obtainStyledAttributes.getInteger(index, 1);
            } else if (index == R$styleable.ExpandView_pop_ellipsis) {
                this.f56681b = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_expand_hint) {
                this.f56682c = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_shrink_hint) {
                this.f56683d = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_toggle_enabled) {
                this.f56686g = obtainStyledAttributes.getBoolean(index, this.f56686g);
            } else if (index == R$styleable.ExpandView_pop_show_expand_hint) {
                this.f56688i = obtainStyledAttributes.getBoolean(index, this.f56688i);
            } else if (index == R$styleable.ExpandView_pop_show_shrink_hint) {
                this.f56689j = obtainStyledAttributes.getBoolean(index, this.f56689j);
            } else if (index == R$styleable.ExpandView_pop_expand_hint_color) {
                this.f56692m = obtainStyledAttributes.getInteger(index, -1711276033);
            } else if (index == R$styleable.ExpandView_pop_shrink_hint_color) {
                this.f56693n = obtainStyledAttributes.getInteger(index, -1711276033);
            } else if (index == R$styleable.ExpandView_pop_expand_bg_Color) {
                this.f56694o = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R$styleable.ExpandView_pop_shrink_bg_color) {
                this.f56695p = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R$styleable.ExpandView_pop_Init_state) {
                this.f56697r = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R$styleable.ExpandView_pop_expand_gap) {
                this.f56684e = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_collapse_gap) {
                this.f56685f = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_hash_tag_color) {
                this.f56696q = obtainStyledAttributes.getInteger(index, this.f56696q);
            } else if (index == R$styleable.ExpandView_pop_show_hint_icon) {
                this.f56699t = obtainStyledAttributes.getBoolean(index, true);
            }
        }
        obtainStyledAttributes.recycle();
        i();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(View view) {
        o();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CharSequence m(final CharSequence charSequence) {
        if (!this.f56687h) {
            return charSequence;
        }
        if (!TextUtils.equals(charSequence, this.f56704y)) {
            this.f56703x = null;
        }
        this.f56704y = charSequence;
        int layoutWidth = getLayoutWidth();
        if (layoutWidth > 0) {
            this.B = true;
            return this.f56704y == null ? charSequence : h(layoutWidth);
        }
        if (this.f56690k) {
            postDelayed(new Runnable() { // from class: uv.d
                @Override // java.lang.Runnable
                public final void run() {
                    UGCImmExpandView.this.l(charSequence);
                }
            }, 100L);
        }
        return null;
    }

    private CharSequence n(SpannableStringBuilder spannableStringBuilder) {
        return spannableStringBuilder;
    }

    private void o() {
        if (getText().toString().contains(this.f56682c) || getText().toString().contains(this.f56683d)) {
            int i11 = this.f56697r;
            if (i11 == 0) {
                this.f56697r = 1;
            } else if (i11 == 1) {
                this.f56697r = 0;
            }
            l(this.f56704y);
        }
    }

    public void addLegacyHashTag(String str, String str2) {
        this.A = str;
        this.f56705z = str2;
    }

    @Override // com.transsion.shorttv_pugc.base.widget.TnTextView, ft.a
    public void changeLocal() {
        this.f56682c = getResources().getString(R$string.short_tv_str_more);
        this.f56683d = getResources().getString(R$string.short_tv_str_hide);
        super.changeLocal();
    }

    public int getExpandState() {
        return this.f56697r;
    }

    public boolean isOutLines() {
        Layout layout = this.f56703x;
        return layout != null && layout.getLineCount() > this.f56691l;
    }

    public boolean isSetTitleSuccess() {
        return this.B;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void reset() {
        this.f56697r = 0;
        l(this.f56704y);
    }

    public void setCollapseEnable(boolean z10) {
        this.f56687h = z10;
    }

    public void setExpandListener(c cVar) {
    }

    public void setOnClickHashTagListener(b bVar) {
    }

    /* renamed from: setTitle, reason: merged with bridge method [inline-methods] */
    public void l(final CharSequence charSequence) {
        setTextAction(new Function0() { // from class: uv.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                CharSequence m11;
                m11 = UGCImmExpandView.this.m(charSequence);
                return m11;
            }
        });
    }
}
