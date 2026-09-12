package com.tn.lib.view.expand;

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
import com.tn.lib.view.expand.ExpandView;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
import com.tn.lib.widget.R$styleable;
import com.tn.lib.widget.TnTextView;
import kotlin.jvm.functions.Function0;

/* loaded from: classes4.dex */
public class ExpandView extends TnTextView {
    public static final int STATE_EXPAND = 1;
    public static final int STATE_SHRINK = 0;
    private String A;
    private String B;

    /* renamed from: b, reason: collision with root package name */
    private String f41325b;

    /* renamed from: c, reason: collision with root package name */
    private String f41326c;

    /* renamed from: d, reason: collision with root package name */
    private String f41327d;

    /* renamed from: e, reason: collision with root package name */
    private String f41328e;

    /* renamed from: f, reason: collision with root package name */
    private String f41329f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f41330g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f41331h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f41332i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f41333j;

    /* renamed from: k, reason: collision with root package name */
    private boolean f41334k;

    /* renamed from: l, reason: collision with root package name */
    private int f41335l;

    /* renamed from: m, reason: collision with root package name */
    private int f41336m;

    /* renamed from: n, reason: collision with root package name */
    private int f41337n;

    /* renamed from: o, reason: collision with root package name */
    private int f41338o;

    /* renamed from: p, reason: collision with root package name */
    private int f41339p;

    /* renamed from: q, reason: collision with root package name */
    private int f41340q;

    /* renamed from: r, reason: collision with root package name */
    private int f41341r;

    /* renamed from: s, reason: collision with root package name */
    private float f41342s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f41343t;

    /* renamed from: u, reason: collision with root package name */
    private ClickableSpan f41344u;

    /* renamed from: v, reason: collision with root package name */
    private qh.a f41345v;

    /* renamed from: w, reason: collision with root package name */
    private qh.a f41346w;

    /* renamed from: x, reason: collision with root package name */
    private Layout f41347x;

    /* renamed from: y, reason: collision with root package name */
    private CharSequence f41348y;

    /* renamed from: z, reason: collision with root package name */
    private c f41349z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            ExpandView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            ExpandView expandView = ExpandView.this;
            expandView.m(expandView.f41348y);
            ExpandView.this.f41334k = true;
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a(ExpandView expandView);

        void b(ExpandView expandView);
    }

    public ExpandView(Context context) {
        this(context, null);
    }

    public ExpandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41328e = "  ";
        this.f41329f = "  ";
        this.f41330g = false;
        this.f41331h = true;
        this.f41332i = true;
        this.f41333j = true;
        this.f41334k = false;
        this.f41335l = 1;
        this.f41336m = -1711276033;
        this.f41337n = -1711276033;
        this.f41338o = 872415231;
        this.f41339p = 872415231;
        this.f41340q = -1;
        this.f41341r = 0;
        this.f41343t = true;
        k(context, attributeSet);
    }

    public ExpandView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f41328e = "  ";
        this.f41329f = "  ";
        this.f41330g = false;
        this.f41331h = true;
        this.f41332i = true;
        this.f41333j = true;
        this.f41334k = false;
        this.f41335l = 1;
        this.f41336m = -1711276033;
        this.f41337n = -1711276033;
        this.f41338o = 872415231;
        this.f41339p = 872415231;
        this.f41340q = -1;
        this.f41341r = 0;
        this.f41343t = true;
        k(context, attributeSet);
    }

    private int getLayoutWidth() {
        Layout layout = getLayout();
        int width = layout != null ? layout.getWidth() : 0;
        return (width > 0 || getWidth() == 0) ? width : (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private CharSequence h(int i11) {
        String str;
        int i12;
        TextPaint paint = getPaint();
        if (this.f41348y != null) {
            str = "" + ((Object) this.f41348y);
        } else {
            str = "";
        }
        if (this.f41347x == null) {
            this.f41347x = new StaticLayout(str, paint, i11, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
        }
        int lineCount = this.f41347x.getLineCount();
        int i13 = this.f41335l;
        if (lineCount <= i13) {
            CharSequence charSequence = this.f41348y;
            if (charSequence == null) {
                charSequence = " ";
            }
            return o(new SpannableStringBuilder(charSequence));
        }
        int i14 = this.f41341r;
        if (i14 != 0) {
            if (i14 != 1 || !this.f41333j) {
                return o(new SpannableStringBuilder(this.f41348y));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.f41348y);
            spannableStringBuilder.append((CharSequence) this.f41329f).append((CharSequence) this.f41327d);
            int length = (spannableStringBuilder.length() - this.f41329f.length()) - this.f41327d.length();
            int length2 = spannableStringBuilder.length();
            i12 = length >= 0 ? length : 0;
            spannableStringBuilder.setSpan(this.f41344u, i12, length2, 33);
            spannableStringBuilder.setSpan(this.f41345v, i12, length2, 33);
            return o(spannableStringBuilder);
        }
        int i15 = i(str, paint, this.f41347x.getLineStart(this.f41335l - 1), this.f41347x.getLineEnd(i13 - 1), i11);
        CharSequence charSequence2 = this.f41348y;
        if (charSequence2 != null && charSequence2.length() <= i15) {
            i15 = this.f41348y.length() - 1;
        }
        CharSequence charSequence3 = this.f41348y;
        if (charSequence3 == null || i15 <= 0) {
            return charSequence3;
        }
        SpannableStringBuilder append = new SpannableStringBuilder(charSequence3.subSequence(0, i15)).append((CharSequence) this.f41325b);
        if (this.f41332i) {
            append.append((CharSequence) this.f41328e);
            append.append((CharSequence) this.f41326c);
            int length3 = (append.length() - this.f41328e.length()) - this.f41326c.length();
            int length4 = append.length();
            i12 = length3 >= 0 ? length3 : 0;
            append.setSpan(this.f41344u, i12, length4, 33);
            append.setSpan(this.f41346w, i12, length4, 33);
        }
        return o(append);
    }

    private int i(String str, TextPaint textPaint, int i11, int i12, int i13) {
        String str2;
        qh.a aVar = this.f41346w;
        String str3 = this.f41325b;
        if (this.f41332i) {
            str2 = this.f41326c + this.f41328e;
        } else {
            str2 = "";
        }
        return textPaint.breakText(str, i11, i12, true, i13 - aVar.e(textPaint, str3, str2), null) + i11;
    }

    private void j() {
        if (this.f41342s == 0.0f) {
            this.f41342s = getTextSize();
        }
        boolean z10 = getLayoutDirection() == 1;
        this.f41346w = new qh.a(getContext(), this.f41343t ? R$mipmap.info_player_ic_expand : -111, this.f41336m, this.f41338o, this.f41342s, 5, z10);
        this.f41345v = new qh.a(getContext(), this.f41343t ? R$mipmap.info_player_ic_collapse : -111, this.f41337n, this.f41339p, this.f41342s, 5, z10);
        setMovementMethod(new LinkMovementMethod());
        if (TextUtils.isEmpty(this.f41325b)) {
            this.f41325b = "...";
        }
        if (TextUtils.isEmpty(this.f41326c)) {
            this.f41326c = getResources().getString(R$string.player_more);
        }
        if (TextUtils.isEmpty(this.f41327d)) {
            this.f41327d = getResources().getString(R$string.player_hide);
        }
        if (this.f41328e == null) {
            this.f41328e = "  ";
        }
        if (this.f41329f == null) {
            this.f41329f = "  ";
        }
        setOnClickListener(new View.OnClickListener() { // from class: qh.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandView.this.l(view);
            }
        });
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    private void k(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            j();
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExpandView);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i11 = 0; i11 < indexCount; i11++) {
            int index = obtainStyledAttributes.getIndex(i11);
            if (index == R$styleable.ExpandView_pop_hint_text_size) {
                this.f41342s = obtainStyledAttributes.getDimension(index, 0.0f);
            } else if (index == R$styleable.ExpandView_pop_reverse_Lines) {
                this.f41335l = obtainStyledAttributes.getInteger(index, 1);
            } else if (index == R$styleable.ExpandView_pop_ellipsis) {
                this.f41325b = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_expand_hint) {
                this.f41326c = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_shrink_hint) {
                this.f41327d = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_toggle_enabled) {
                this.f41330g = obtainStyledAttributes.getBoolean(index, this.f41330g);
            } else if (index == R$styleable.ExpandView_pop_show_expand_hint) {
                this.f41332i = obtainStyledAttributes.getBoolean(index, this.f41332i);
            } else if (index == R$styleable.ExpandView_pop_show_shrink_hint) {
                this.f41333j = obtainStyledAttributes.getBoolean(index, this.f41333j);
            } else if (index == R$styleable.ExpandView_pop_expand_hint_color) {
                this.f41336m = obtainStyledAttributes.getInteger(index, -1711276033);
            } else if (index == R$styleable.ExpandView_pop_shrink_hint_color) {
                this.f41337n = obtainStyledAttributes.getInteger(index, -1711276033);
            } else if (index == R$styleable.ExpandView_pop_expand_bg_Color) {
                this.f41338o = obtainStyledAttributes.getInteger(index, 872415231);
            } else if (index == R$styleable.ExpandView_pop_shrink_bg_color) {
                this.f41339p = obtainStyledAttributes.getInteger(index, 872415231);
            } else if (index == R$styleable.ExpandView_pop_Init_state) {
                this.f41341r = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R$styleable.ExpandView_pop_expand_gap) {
                this.f41328e = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_collapse_gap) {
                this.f41329f = obtainStyledAttributes.getString(index);
            } else if (index == R$styleable.ExpandView_pop_hash_tag_color) {
                this.f41340q = obtainStyledAttributes.getInteger(index, this.f41340q);
            } else if (index == R$styleable.ExpandView_pop_show_hint_icon) {
                this.f41343t = obtainStyledAttributes.getBoolean(index, true);
            }
        }
        obtainStyledAttributes.recycle();
        j();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(View view) {
        p();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ CharSequence n(final CharSequence charSequence) {
        if (!this.f41331h) {
            return charSequence;
        }
        if (!TextUtils.equals(charSequence, this.f41348y)) {
            this.f41347x = null;
        }
        this.f41348y = charSequence;
        int layoutWidth = getLayoutWidth();
        if (layoutWidth > 0) {
            return this.f41348y == null ? charSequence : h(layoutWidth);
        }
        if (this.f41334k) {
            postDelayed(new Runnable() { // from class: qh.d
                @Override // java.lang.Runnable
                public final void run() {
                    ExpandView.this.m(charSequence);
                }
            }, 100L);
        }
        return null;
    }

    private CharSequence o(SpannableStringBuilder spannableStringBuilder) {
        return spannableStringBuilder;
    }

    private void p() {
        if (getText().toString().contains(this.f41326c) || getText().toString().contains(this.f41327d)) {
            int i11 = this.f41341r;
            if (i11 == 0) {
                this.f41341r = 1;
                c cVar = this.f41349z;
                if (cVar != null) {
                    cVar.b(this);
                }
            } else if (i11 == 1) {
                this.f41341r = 0;
                c cVar2 = this.f41349z;
                if (cVar2 != null) {
                    cVar2.a(this);
                }
            }
            m(this.f41348y);
        }
    }

    public void addLegacyHashTag(String str, String str2) {
        this.B = str;
        this.A = str2;
    }

    @Override // com.tn.lib.widget.TnTextView, tj.a
    public void changeLocal() {
        this.f41326c = getResources().getString(R$string.player_more);
        this.f41327d = getResources().getString(R$string.player_hide);
        super.changeLocal();
    }

    public int getExpandState() {
        return this.f41341r;
    }

    public boolean isOutLines() {
        Layout layout = this.f41347x;
        return layout != null && layout.getLineCount() > this.f41335l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.AppCompatTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void reset() {
        this.f41341r = 0;
        c cVar = this.f41349z;
        if (cVar != null) {
            cVar.a(this);
        }
        m(this.f41348y);
    }

    public void setCollapseEnable(boolean z10) {
        this.f41331h = z10;
    }

    public void setExpandListener(c cVar) {
        this.f41349z = cVar;
    }

    public void setOnClickHashTagListener(b bVar) {
    }

    /* renamed from: setTitle, reason: merged with bridge method [inline-methods] */
    public void m(final CharSequence charSequence) {
        setTextAction(new Function0() { // from class: qh.b
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                CharSequence n11;
                n11 = ExpandView.this.n(charSequence);
                return n11;
            }
        });
    }
}
